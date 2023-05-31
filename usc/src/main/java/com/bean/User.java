package com.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity //jpa ORmapping
@Table(name = "user") //不写的话就是class名字为表名
public class User implements UserDetails {

    private static final long serialVersionUID = 1L;
    @Id //primary keystrategy
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "USC_USER_SEQ")
    private int id;

    @Column(name = "username", unique = true, nullable = false)
//    @column define a column name
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "c_user_c_user_profile", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "user_profile_id", referencedColumnName = "id")
    })
    private List<UserProfile> profiles = new ArrayList<>();

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CartItem> cart;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Order> order;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        TODO Auto-generated Method stub
        return profiles;
    }

    @Override
    public String getPassword() {
        //        TODO Auto-generated Method stub
        return password;
    }

    @Override
    public String getUsername() {
        //        TODO Auto-generated Method stub
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        //        TODO Auto-generated Method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //        TODO Auto-generated Method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", profiles=" + profiles +
                ", cart=" + cart +
                ", order=" + order +
                '}';
    }

    public User(int id, String username, String password, List<UserProfile> profiles,
            List<CartItem> cart, List<Order> order) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.profiles = profiles;
        this.cart = cart;
        this.order = order;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserProfile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<UserProfile> profiles) {
        this.profiles = profiles;
    }


    public User() {
        super();
    }

    public List<CartItem> getCart() {
        return cart;
    }

    public void setCart(List<CartItem> cart) {
        this.cart = cart;
    }


}
