package com.controller;

import com.bean.CartItem;
import com.bean.Order;
import com.dao.OrderDao;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.http.Response;
import com.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderDao orderDao;



//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/all")
    public List<Order> findAllorder() {
        return orderService.getall();
    }


    @GetMapping("/{username}")
    public List<Order> getOrder(@PathVariable String username) {
        return orderService.getOrder(username);
    }

    @PostMapping("/{username}")
    public Response placeOder(@RequestBody Order order,@PathVariable String username) {
        return orderService.placeOrder(order, username);
    }

    @DeleteMapping("/{id}")
    public Response deleteOrder(@PathVariable int id){
        return orderService.deleteOrder(id);
    }









}
