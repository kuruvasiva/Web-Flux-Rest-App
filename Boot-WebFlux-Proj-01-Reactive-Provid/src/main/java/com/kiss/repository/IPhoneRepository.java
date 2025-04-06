package com.kiss.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.kiss.model.Phone;

public interface IPhoneRepository extends ReactiveMongoRepository<Phone, Integer> {

}
