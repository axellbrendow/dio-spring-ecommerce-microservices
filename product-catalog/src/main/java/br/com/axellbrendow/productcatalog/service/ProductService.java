package br.com.axellbrendow.productcatalog.service;

import br.com.axellbrendow.productcatalog.model.Product;
import br.com.axellbrendow.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> listProducts() {
        Iterable<Product> productIterable = repository.findAll();
        return StreamSupport.stream(productIterable.spliterator(),false).collect(Collectors.toList());
    }

    public Optional<Product> getProductById(@PathVariable String id) {
        return repository.findById(id);
    }

    public Product createProduct(Product product) {
        return repository.save(product);
    }
}
