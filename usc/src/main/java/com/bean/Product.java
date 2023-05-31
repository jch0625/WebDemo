package com.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="uscfinal.product")
public class Product {
    private static final long serialVersionUID = 1L;
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "USC_USER_SEQ")
    private int Id;

    @Column(name = "productname", unique = false, nullable = false)
    private String productname;

    @Column(name = "price", nullable = false)
    private String price;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "picurl", nullable = false)
    private String picurl;

    @Column(name = "isshow", nullable = false, columnDefinition = "varchar(20) default 'show'")
    private String isshow;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CartItem> cart;


    public Product() {
    }

    public Product(int id, String productname, String price, String description,
            String picurl, String isshow) {
        Id = id;
        this.productname = productname;
        this.price = price;
        this.description = description;
        this.picurl = picurl;
        this.isshow = isshow;
        this.cart = cart;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getIsshow() {
        return isshow;
    }

    public void setIsshow(String isshow) {
        this.isshow = isshow;
    }

    public List<CartItem> getCart() {
        return cart;
    }

    public void setCart(List<CartItem> cart) {
        this.cart = cart;
    }

    //    public List<CartItem> getCart() {
//        return cart;
//    }
//
//    public void setCart(List<CartItem> cart) {
//        this.cart = cart;
//    }


    @Override
    public String toString() {
        return "Product{" +
                "Id=" + Id +
                ", productname='" + productname + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", picurl='" + picurl + '\'' +
                ", isshow='" + isshow + '\'' +
                ", cart=" + cart +
                '}';
    }
}
