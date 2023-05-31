package com.dao;

import com.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    //spring JPA
//    findBy后面会自动寻找查找field
    //就是hibernate，抽象程度高
    User findByUsername(String username);
}