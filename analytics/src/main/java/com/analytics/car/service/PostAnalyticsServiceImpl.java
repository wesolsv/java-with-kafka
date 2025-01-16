package com.analytics.car.service;

import com.analytics.car.dto.CarPostDTO;
import com.analytics.car.entity.BrandAnalyticsEntity;
import com.analytics.car.entity.CarModelAnalyticsEntity;
import com.analytics.car.entity.CarModelPriceEntity;
import com.analytics.car.repository.BrandAnalyticsRepository;
import com.analytics.car.repository.CarModelAnalyticsRepository;
import com.analytics.car.repository.CarPriceAnalyticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostAnalyticsServiceImpl implements PostAnalyticsService{

    @Autowired
    private BrandAnalyticsRepository brandAnalyticsRepository;

    @Autowired
    private CarModelAnalyticsRepository carModelAnalyticsRepository;

    @Autowired
    private CarPriceAnalyticsRepository carPriceAnalyticsRepository;

    @Override
    public void saveDataAnalytics(CarPostDTO carPostDTO) {
        saveBrandAnalytics(carPostDTO.getBrand());
        saveCarModelAnalytics(carPostDTO.getModel());
        saveCarModelPriceAnalytics(carPostDTO.getModel(), carPostDTO.getPrice());
    }

    private void saveBrandAnalytics(String brand) {
        BrandAnalyticsEntity brandAnalyticsEntity = new BrandAnalyticsEntity();

        brandAnalyticsRepository.findByBrand(brand).ifPresentOrElse(item ->{
            item.setPosts(item.getPosts()+1);
            brandAnalyticsRepository.save(item);
        }, () -> {
            brandAnalyticsEntity.setBrand(brand);
            brandAnalyticsEntity.setPosts(1L);
            brandAnalyticsRepository.save(brandAnalyticsEntity);
        });
    }

    private void saveCarModelAnalytics(String model) {

        CarModelAnalyticsEntity carModelAnalyticsEntity = new CarModelAnalyticsEntity();

        carModelAnalyticsRepository.findByModel(model).ifPresentOrElse(item ->{
            item.setPosts(item.getPosts()+1);
            carModelAnalyticsRepository.save(item);
        }, () ->{
            carModelAnalyticsEntity.setModel(model);
            carModelAnalyticsEntity.setPosts(1L);
            carModelAnalyticsRepository.save(carModelAnalyticsEntity);
        });
    }

    private void saveCarModelPriceAnalytics(String model, Double price) {

        CarModelPriceEntity carModelPriceEntity = new CarModelPriceEntity();

        carModelPriceEntity.setModel(model);
        carModelPriceEntity.setPrice(price);
        carPriceAnalyticsRepository.save(carModelPriceEntity);
    }


}
