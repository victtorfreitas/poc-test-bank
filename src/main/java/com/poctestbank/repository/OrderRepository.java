package com.poctestbank.repository;

import com.poctestbank.repository.model.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<OrderEntity, String> {

    List<OrderEntity> findAllByDestinationContaining(String destination);
}
