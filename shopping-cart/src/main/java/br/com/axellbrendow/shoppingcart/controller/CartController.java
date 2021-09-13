package br.com.axellbrendow.shoppingcart.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.axellbrendow.shoppingcart.model.Cart;
import br.com.axellbrendow.shoppingcart.model.Item;
import br.com.axellbrendow.shoppingcart.repository.CartRepository;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartRepository repository;

    @PostMapping("/{id}/add-item")
    public Cart addItem(@PathVariable("id") Integer id, @RequestBody Item item) {
        var cart = repository.findById(id).orElseGet(() -> new Cart(id));
        cart.getItems().add(item);
        return repository.save(cart);
    }

    @GetMapping("/{id}")
    public Optional<Cart> findById(@PathVariable("id") Integer id) {
        return repository.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Integer id) {
        repository.deleteById(id);
    }
}
