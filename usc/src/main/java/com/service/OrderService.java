package com.service;

import com.bean.CartItem;
import com.bean.Order;
import com.bean.OrderItem;
import com.bean.Product;
import com.bean.User;
import com.dao.CartItemDao;
import com.dao.OrderDao;
import com.dao.OrderItemDao;
import com.dao.ProductDao;
import com.dao.UserDao;
import com.http.Response;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@Transactional
public class OrderService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    CartItemDao cartItemDao;

    @Autowired
    UserDao userDao;

    @Autowired
    ProductDao productDao;

    @Autowired
    OrderItemDao orderItemDao;


//    Show order by user
    public List<Order> getOrder(String username) {
       int uid = userDao.findByUsername(username).getId();
       return orderDao.findByUser(uid);
    }

    public List<Order> getall() {

        return orderDao.findAllorder();
    }

//    user place order
    public Response placeOrder(Order order, String username) {
            try {
                if(order.getItemlist().size() == 0){
                    return new Response(false);
                }
                List<OrderItem> itemlist = order.getItemlist();
                itemlist.forEach((orderItem) -> {
                    Product product = (Product) productDao.findById(orderItem.getProduct().getId()).get();
                    orderItem.setProduct(product);
                    orderItem.setOrder(order);
                });
                order.setUser(userDao.findByUsername(username));
                orderDao.save(order);
                order.setItemlist(itemlist);
                return new Response(true);
            } catch (Exception e) {
                return new Response(false);
            }
    }

//    change status
    public Response changeStatus(Order order, String status){
        order.setStatus(status);
        orderDao.save(order);
        return new Response(true);
    }

    public Response deleteOrder(int id){
        Order o = orderDao.findByid(id);
        if (o != null) {
            List<OrderItem> items = o.getItemlist();
            orderDao.deleteById(o.getId());
            for(OrderItem a : items) {
                orderItemDao.deleteOrderItemByid(a.getId());
            }
            return new Response(true);
        } else {
            return new Response(false, "Order is not found.");
        }
    }








}
