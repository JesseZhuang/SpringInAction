package com.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Because StoreService is a singleton bean, it will be created as the Spring application context is loaded.
 * As it’s created, Spring will attempt to inject ShoppingCart into the setShoppingCart() method.
 * But the ShoppingCart bean, being session scoped, doesn’t exist yet.
 * There won’t be an instance of ShoppingCart until a user comes along and a session is created.
 * <p>
 * Moreover, there will be many instances of ShoppingCart: one per user. You don’t want Spring to inject
 * just any single instance of ShoppingCart into StoreService.
 */
@Component
public class StoreService {

    private ShoppingCart shoppingCart;

    @Autowired
    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
