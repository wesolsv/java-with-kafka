package com.analytics.car.service;

import com.analytics.car.dto.CarPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface PostAnalyticsService {

     void saveDataAnalytics(CarPostDTO carPostDTO);
}
