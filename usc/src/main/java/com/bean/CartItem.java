package com.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "uscfinal.cart")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

//    @Column
//    private String price;

    @Column
    private int itcount;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public CartItem() {
    }

    public CartItem(int id, Product product, int itcount, User user) {
        this.id = id;
        this.product = product;
        this.itcount = itcount;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItcount() {
        return itcount;
    }

    public void setItcount(int itcount) {
        this.itcount = itcount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", product=" + product +
                ", itcount=" + itcount +
                ", user=" + user +
                '}';
    }
}
