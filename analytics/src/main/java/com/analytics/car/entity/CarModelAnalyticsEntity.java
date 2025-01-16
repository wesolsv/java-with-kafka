package com.analytics.car.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "car_model_analytics")
public class CarModelAnalyticsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String model;

    private Long posts;

    public CarModelAnalyticsEntity(Long id, String model, Long posts) {
        this.id = id;
        this.model = model;
        this.posts = posts;
    }

    public CarModelAnalyticsEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getPosts() {
        return posts;
    }

    public void setPosts(Long posts) {
        this.posts = posts;
    }
}
