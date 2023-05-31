package com.dao;

import com.bean.CartItem;
import com.bean.Product;
import com.bean.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemDao extends JpaRepository<CartItem, Integer> {

    CartItem findCartItemById(Integer id);

    CartItem findCartItemByUserAndProduct(User user, Product product);

//    @Query(value = "SELECT product_id FROM uscfinal.uscfinal_cart WHERE user_id = ?1 ",nativeQuery = true)
//    List<Integer> findByUser(Integer uid);
//
//    @Query(value = "SELECT itcount FROM uscfinal.uscfinal_cart WHERE product_id = ?1 ",nativeQuery = true)
//    Integer findCartItemsByUser(Integer pid);
//
    @Query(value = "SELECT * FROM uscfinal.uscfinal_cart WHERE user_id = ?1 ",nativeQuery = true)
    List<CartItem> findAllCartItemByUserid(Integer userid);

    @Query(value = "SELECT * FROM uscfinal.uscfinal_cart WHERE user_id = ?1 AND product_id = ?2",nativeQuery = true)
    CartItem findCartItemByUserIdandProducttId(Integer userid, Integer productid);



}
