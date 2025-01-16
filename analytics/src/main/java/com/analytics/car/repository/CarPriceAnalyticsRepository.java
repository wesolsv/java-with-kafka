package com.analytics.car.repository;

import com.analytics.car.entity.CarModelPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPriceAnalyticsRepository extends JpaRepository<CarModelPriceEntity, Long> {

}
