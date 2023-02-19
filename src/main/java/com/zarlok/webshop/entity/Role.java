package com.zarlok.webshop.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Table( name = "authorities")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

//    @Column(name = "username")
//    private String username;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;

    @Column(name = "authority")
    private String authority;

    public Role(){}

    public Role(User user, String authority) {
        this.user = user;
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    @Override
    public String toString() {
        return String.format("Role\nUsername = %s\nAuthority = %s", this.user, this.authority);
    }
}
