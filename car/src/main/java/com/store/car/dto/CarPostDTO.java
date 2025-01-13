package com.store.car.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@NoArgsConstructor
@JsonInclude
public class CarPostDTO {

    private String model;

    private String brand;

    private Double price;

    private String description;

    private String engineVersion;

    private String city;

    private String createdDate;

    private Long ownerId;

    private String ownerName;

    private String ownerType;

    private String contact;

    @Builder
    public CarPostDTO(String model, String brand, Double price, String description, String engineVersion, String city, String createdDate, Long ownerId, String ownerName, String ownerType, String contact) {
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.engineVersion = engineVersion;
        this.city = city;
        this.createdDate = createdDate;
        this.ownerName = ownerName;
    }
}
