package com.controller;

import com.bean.User;
import com.dao.UserDao;
import com.http.Response;
import com.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController() //receipt API request
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserDao userDao;

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping
    public List<User> getusers() {
        return userDao.findAll();
    }

    @PostMapping
    public Response adduser(@RequestBody User user) { //接收参数是josn， 要用@RequestBody。 返回的自动是json， 所以不用@ResponseBody
        return userService.register(user);
    }

    @RequestMapping("/adm")
    @PostMapping
    public Response addAdmin(@RequestBody User user) { //接收参数是josn， 要用@RequestBody。 返回的自动是json， 所以不用@ResponseBody
        return userService.registerAdm(user);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    @PutMapping
    public Response changUser(@RequestBody User user, Authentication authentication) {
        return userService.changePassword(user, authentication);
    }

    @DeleteMapping("/{id}")
    public Response deleteUser(@PathVariable int id) { //把变量ID从path中提取， 然后注入到function里
        return userService.deleteUser(id);
    }

    @GetMapping("/test")
    public Response test(Authentication authentication){
        return new Response(userService.isAdmin(authentication.getAuthorities()));
    }



}
