package com.service;


import com.bean.Product;
import com.dao.ProductDao;
import com.http.Response;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService {

    @Autowired
    ProductDao productDao;

    public List<Product> test(){
        return productDao.findAll();
    }

    public Response addProduct(Product product) {
        product.setIsshow("show");
        if(productDao.findByProductname(product.getProductname()) != null) {
            return new Response(false);
        }
        productDao.save(product);
        return new Response(true);
    }

    public Response changeProduct(Product product) {
        Product p =productDao.findProductById(product.getId());
        if(p != null) {
            if(product.getProductname() != null) p.setProductname(product.getProductname());
            if(product.getDescription() != "" && product.getDescription() != null) p.setDescription(product.getDescription());
            if(product.getPrice() != null) p.setPrice(product.getPrice());
            if(product.getPicurl() != "" && product.getPicurl() != null) p.setPicurl(product.getPicurl());
            if(product.getIsshow() != null) p.setIsshow(product.getIsshow());
            productDao.save(p);
            return new Response(true);
        } else {
            return new Response(false);
        }

    }

    public Response deleteProduct(Integer productid) {

        if (productDao.findProductById(productid) != null) {
            productDao.deleteById(productid);
            return new Response(true);
        } else {
            return new Response(false, "Product is not found.");
        }
    }

}
