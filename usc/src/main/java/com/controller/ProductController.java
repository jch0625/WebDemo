package com.controller;

import com.bean.Product;
import com.dao.ProductDao;
import com.http.Response;
import com.service.ProductService;
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
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductDao productDao;

    @Autowired
    ProductService productService;


    @GetMapping
    public List<Product> getproduct() {
        return productDao.findAll();
    }

    @GetMapping("/test")
    public List<Product> test(){
        return productService.test();
    }

    @PostMapping
    public Response addproduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping
    public Response changeProduct(@RequestBody Product product) {
        return productService.changeProduct(product);
    }

    @DeleteMapping("/{productid}")
    public Response deleteProduct(@PathVariable Integer productid) {
        return productService.deleteProduct(productid);
    }

}

//{
//        "productname" : "orange",
//        "picurl" : "#",
//        "price" :"15",
//        "description" : "this is description for orange!"
//        }
