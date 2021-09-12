package br.com.axellbrendow.productcatalog.controller;

import br.com.axellbrendow.productcatalog.dto.ProductDto;
import br.com.axellbrendow.productcatalog.model.Product;
import br.com.axellbrendow.productcatalog.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<ProductDto> listProducts() {
        List<Product> productList = service.listProducts();
        return productList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable String id) {
         Optional<Product> productOptional = service.getProductById(id);
         if (productOptional.isPresent()) {
             return ResponseEntity.ok().body(convertToDto(productOptional.get()));
         }
         return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ProductDto create(@RequestBody ProductDto productDto) {
        Product product = convertToEntity(productDto);
        Product createdProduct = service.createProduct(product);
        return convertToDto(createdProduct);
    }

    private ProductDto convertToDto(Product product) {
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        return productDto;
    }

    private Product convertToEntity(ProductDto productDto)  {
        Product product = modelMapper.map(productDto, Product.class);
        return product;
    }
}
