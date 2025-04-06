package com.kiss.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.kiss.model.Phone;

import reactor.core.publisher.Flux;


public interface IPhoneRepository extends ReactiveMongoRepository<Phone, Integer> {

	public Flux<Phone> findByName(String name);
}
