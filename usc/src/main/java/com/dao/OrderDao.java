package com.dao;

import com.bean.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderDao extends JpaRepository<Order,Integer> {
    Order findOrderByid(Integer id);

    @Query(value = "SELECT * FROM uscfinal_order WHERE user_id = ?1 ",nativeQuery = true)
    List<Order> findByUser(Integer userid);

    @Query(value = "SELECT * FROM uscfinal_order",nativeQuery = true)
    List<Order> findAllorder();

    @Query(value = "SELECT * FROM uscfinal_order WHERE id = ?1 ",nativeQuery = true)
    Order findByid(Integer id);
}
