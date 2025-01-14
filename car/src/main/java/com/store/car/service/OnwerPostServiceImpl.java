package com.store.car.service;

import com.store.car.dto.OwnerPostDTO;
import com.store.car.entity.OwnerPostEntity;
import com.store.car.repository.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OnwerPostServiceImpl implements OnwerPostService{

    @Autowired
    private OwnerPostRepository repository;

    @Override
    public void createOwnerPost(OwnerPostDTO ownerPostDTO) {
        OwnerPostEntity ownerPost = new OwnerPostEntity();

        ownerPost.setName(ownerPostDTO.getName());
        ownerPost.setType(ownerPostDTO.getType());
        ownerPost.setContactNumber(ownerPostDTO.getContactNumber());

        repository.save(ownerPost);
    }
}
