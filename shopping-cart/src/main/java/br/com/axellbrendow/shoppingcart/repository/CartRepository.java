package br.com.axellbrendow.shoppingcart.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.axellbrendow.shoppingcart.model.Cart;

public interface CartRepository extends CrudRepository<Cart, Integer> {}
