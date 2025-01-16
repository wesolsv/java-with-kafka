package com.analytics.car.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "brand_analytics")
public class BrandAnalyticsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String brand;

    private Long posts;

    public BrandAnalyticsEntity(Long id, String brand, Long posts) {
        this.id = id;
        this.brand = brand;
        this.posts = posts;
    }

    public BrandAnalyticsEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getPosts() {
        return posts;
    }

    public void setPosts(Long posts) {
        this.posts = posts;
    }
}
