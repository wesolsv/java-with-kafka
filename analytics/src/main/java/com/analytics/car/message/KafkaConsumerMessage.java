package com.analytics.car.message;

import com.analytics.car.dto.CarPostDTO;
import com.analytics.car.service.PostAnalyticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerMessage {

    private final Logger LOG = LoggerFactory.getLogger(KafkaConsumerMessage.class);

    @Autowired
    private PostAnalyticsService carPostService;

    @KafkaListener(topics = "car-post-topic", groupId = "analytics-posts-group")
    public void listening(CarPostDTO carPost){
        LOG.info("ANALYTICS -> Received Car Post information: {}", carPost);
        carPostService.saveDataAnalytics(carPost);
    }
}
