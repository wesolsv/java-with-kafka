package com.portal.api.service;

import com.portal.api.dto.OwnerPostDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface OwnerPostService {

    void createOwnerCar(OwnerPostDTO ownerPostDTO);
}
