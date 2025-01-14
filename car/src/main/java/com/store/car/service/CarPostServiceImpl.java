package com.store.car.service;

import com.store.car.dto.CarPostDTO;
import com.store.car.entity.CarPostEntity;
import com.store.car.repository.CarPostRepository;
import com.store.car.repository.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarPostServiceImpl implements CarPostService {

    @Autowired
    private CarPostRepository carPostRepository;

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Override
    public void newPostDetails(CarPostDTO carPostDTO) {
        CarPostEntity entity = mapCarDtoToEntity(carPostDTO);
        carPostRepository.save(entity);
    }

    @Override
    public List<CarPostDTO> getCarSales() {
        List<CarPostDTO> listCarsSales = new ArrayList<>();
        carPostRepository.findAll().forEach(item -> listCarsSales.add(mapCarEntityToDTO(item)));

        return listCarsSales;
    }

    private CarPostDTO mapCarEntityToDTO(CarPostEntity carPostEntity) {
        return new CarPostDTO(
                carPostEntity.getModel(),
                carPostEntity.getBrand(),
                carPostEntity.getPrice(),
                carPostEntity.getDescription(),
                carPostEntity.getEngineVersion(),
                carPostEntity.getCity(),
                String.valueOf(carPostEntity.getCreatedDate()),
                carPostEntity.getOwnerPost().getId(),
                carPostEntity.getOwnerPost().getName()
        );
    }

    private CarPostEntity mapCarDtoToEntity(CarPostDTO dto) {
        CarPostEntity entity = new CarPostEntity();

        ownerPostRepository.findById(dto.getOwnerId()).ifPresentOrElse(item ->{
            entity.setOwnerPost(item);
            entity.setContact(item.getContactNumber());
        }, ()->{
            throw new RuntimeException();
        });

        entity.setModel(dto.getModel());
        entity.setBrand(dto.getBrand());
        entity.setPrice(dto.getPrice());
        entity.setCity(dto.getCity());
        entity.setDescription(dto.getDescription());
        entity.setEngineVersion(dto.getEngineVersion());
        entity.setCreatedDate(String.valueOf(new Date()));

        return entity;
    }

    @Override
    public void changeCarSale(CarPostDTO carPostDTO, Long postId) {
        carPostRepository.findById(postId).ifPresentOrElse(item -> {
            item.setDescription(carPostDTO.getDescription());
            item.setContact(carPostDTO.getContact());
            item.setPrice(carPostDTO.getPrice());
            item.setBrand(carPostDTO.getBrand());
            item.setEngineVersion(carPostDTO.getEngineVersion());
            item.setModel(carPostDTO.getModel());

            carPostRepository.save(item);
        }, () -> {
            throw new NoSuchElementException();
        });
    }

    @Override
    public void removeCarSale(Long postId) {
        carPostRepository.deleteById(postId);
    }
    
    
}
