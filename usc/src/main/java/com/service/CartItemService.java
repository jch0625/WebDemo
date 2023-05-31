package com.service;

import com.bean.CartItem;
import com.bean.Product;
import com.bean.User;
import com.dao.CartItemDao;
import com.dao.ProductDao;
import com.dao.UserDao;
import com.http.Response;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {

    @Autowired
    CartItemDao cartItemDao;

    @Autowired
    UserDao userDao;

    @Autowired
    ProductDao productDao;


    public List<CartItem> getItem(String username) {
        User u = userDao.findByUsername(username);
        Integer uid = u.getId();
        return cartItemDao.findAllCartItemByUserid(uid);
    }

    public Response addCartItem(CartItem cartItem, String username) {
        User u = userDao.findByUsername(username);
        Product p = productDao.findProductById(cartItem.getProduct().getId());
        CartItem c = cartItemDao.findCartItemByUserIdandProducttId(u.getId(), p.getId());
        if (c == null) {
            cartItem.setUser(u);
            cartItemDao.save(cartItem);
        } else {
            c.setItcount(c.getItcount() + cartItem.getItcount());
            cartItemDao.save(c);
        }
        return new Response(true);
    }

    public Response changeCount(CartItem cartItem, String username) {
        User u = userDao.findByUsername(username);
        CartItem c = cartItemDao.findCartItemById(cartItem.getId());
        cartItem.setUser(u);
        c.setItcount(cartItem.getItcount());
        cartItemDao.save(c);
        return new Response(true);
    }

    public Response deleteItem(Integer id) {
        cartItemDao.deleteById(id);
        return new Response(true);
    }



}
