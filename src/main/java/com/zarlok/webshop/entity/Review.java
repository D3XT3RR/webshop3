package com.zarlok.webshop.entity;


import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "rate")
    private double rate;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinTable(name = "product_reviews",
            joinColumns = @JoinColumn(name = "reviewId"),
            inverseJoinColumns = @JoinColumn(name = "productId"))
    private Product product;

    public Review() {
    }

    public Review(int id, double rate, String text, Product product) {
        this.id = id;
        this.rate = rate;
        this.text = text;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setProduct(Product product){this.product = product;}

    public Product getProduct(){return this.product;}

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", rate=" + rate +
                ", text='" + text + '\'' +
                ", product=" + product +
                '}';
    }
}

