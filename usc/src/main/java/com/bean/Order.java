package com.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "uscfinal.order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String Status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"password", "profiles","enabled","authorities", "accountNonExpired", "accountNonLocked","credentialsNonExpired","hibernateLazyInitializer"})
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderItem> itemlist;

    public Order() {
    }

    public Order(int id, String status, User user, List<OrderItem> itemlist) {
        this.id = id;
        Status = status;
        this.user = user;
        this.itemlist = itemlist;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", Status='" + Status + '\'' +
                ", user=" + user +
                ", itemlist=" + itemlist +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getItemlist() {
        return itemlist;
    }

    public void setItemlist(List<OrderItem> itemlist) {
        this.itemlist = itemlist;
    }
}
