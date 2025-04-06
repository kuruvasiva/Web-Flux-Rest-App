package com.kiss.service;

import com.kiss.help.Response;
import com.kiss.model.Phone;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPhoneServiceMgmt {

	public Mono<Phone>  savePhone(Phone phone);
	
	public Flux<Phone> listOfPhones();
	
	public Mono<Response> findById(Integer pid);
	
	public Mono<String> deletePhoneById(Integer pid);
	
	public Mono<String> updatePhone(Phone phone);
	
	public Flux<Phone> phonesFindByname(String name);
}
