package com.store.car.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "car_post")
@Data
@NoArgsConstructor
public class CarPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "car_model")
    private String model;

    @Column(name = "car_brand")
    private String brand;

    @Column(name = "car_price")
    private Double price;

    @Column(name = "car_description")
    private String description;

    @Column(name = "car_engine")
    private String engineVersion;

    @Column(name = "car_city")
    private String city;

    @Column(name = "car_created")
    private String createdDate;

    @Column(name = "car_post_contact")
    private String contact;

    @ManyToOne
    @JoinColumn(name = "owner_post_id", nullable = false, referencedColumnName = "id")
    private OwnerPostEntity ownerPost;

    public long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getEngineVersion() {
        return engineVersion;
    }

    public String getCity() {
        return city;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getContact() {
        return contact;
    }

    public OwnerPostEntity getOwnerPost() {
        return ownerPost;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEngineVersion(String engineVersion) {
        this.engineVersion = engineVersion;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setOwnerPost(OwnerPostEntity ownerPost) {
        this.ownerPost = ownerPost;
    }
}
