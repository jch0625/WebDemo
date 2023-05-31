package com.dao;

import com.bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {
    //spring JPA
//    findBy后面会自动寻找查找field
    //就是hibernate，抽象程度高
    Product findByProductname(String productname);

    @Query(value = "SELECT * FROM uscfinal.uscfinal_product WHERE id = ?1 ",nativeQuery = true)
    Product findProductById(Integer Id);
}
