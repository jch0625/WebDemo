package com.dao;

import com.bean.Order;
import com.bean.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface OrderItemDao extends JpaRepository<OrderItem, Integer> {
    OrderItem findOrderItemById(Integer id);

    @Modifying
    @Query(value = "DELETE FROM uscfinal_order_item WHERE id = ?1 ",nativeQuery = true)
    void deleteOrderItemByid(Integer id);



}
