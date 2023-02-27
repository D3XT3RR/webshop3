package com.zarlok.webshop.entity;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private double price;
    @Column(name = "available")
    private boolean available;
    @Column(name = "quantity")
    private int quantity;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "product")
//    @JoinTable(
//            name = "product_reviews",
//            joinColumns = @JoinColumn(name = "productId"),
//            inverseJoinColumns = @JoinColumn(name = "reviewId")
//    )
    private List<Review> reviewsList;

    public Product(){}

    public Product(String name, double price, boolean available, int quantity, List<Review> reviewsList) {
        this.name = name;
        this.price = price;
        this.available = available;
        this.quantity = quantity;
        this.reviewsList = reviewsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Review> getReviewsList() {
        return reviewsList;
    }

    public void setReviewsList(List<Review> reviewsList) {
        this.reviewsList = reviewsList;
    }

    public void saveReviewToList(Review review){
        if(this.reviewsList != null){
            this.reviewsList.add(review);
        }else{
            this.reviewsList = new ArrayList<>();
            this.reviewsList.add(review);
        }

    }

    public double getAvgReviewRate(){
        double avg = 0;
        int count = 0;
        for(Review r : reviewsList){
            count++;
            avg += r.getRate();
        }
        return count != 0 ? avg/count : 0;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", available=" + available +
                ", quantity=" + quantity +
                ", reviewsList=" + reviewsList.toString() +
                '}';
    }
}
