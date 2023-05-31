package com.controller;

import com.bean.CartItem;
import com.dao.CartItemDao;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.http.Response;
import com.service.CartItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cartitem")
public class CartItemController {


    @Autowired
    CartItemDao cartItemDao;

    @Autowired
    CartItemService cartItemService;

    @GetMapping("/test")
    public List<CartItem> getCatItem1() {
        return cartItemDao.findAll();
    }

    @GetMapping("/{username}")
    public List<CartItem> getCatItem(@PathVariable String username) {
        return cartItemService.getItem(username);
    }

    @PostMapping("/{username}")
    public Response addCartItem(@RequestBody CartItem cartItem, @PathVariable String username) {
        return cartItemService.addCartItem(cartItem, username);
    }

    @PutMapping("/{username}")
    public Response changeCount(@RequestBody CartItem cartItem, @PathVariable String username ) {
        return cartItemService.changeCount(cartItem, username);
    }

    @DeleteMapping("/{id}")
    public Response deleteItem(@PathVariable Integer id) {
        return cartItemService.deleteItem(id);
    }


}
