package com.store.car.service;

import com.store.car.dto.OwnerPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface OnwerPostService {

    void createOwnerPost(OwnerPostDTO ownerPostDTO);
}
