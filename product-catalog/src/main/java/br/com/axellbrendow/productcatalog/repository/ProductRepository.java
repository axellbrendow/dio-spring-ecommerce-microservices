package br.com.axellbrendow.productcatalog.repository;

import br.com.axellbrendow.productcatalog.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {
}
