package com.kiss.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiss.help.Response;
import com.kiss.model.Phone;
import com.kiss.repository.IPhoneRepository;

import io.swagger.v3.oas.models.examples.Example;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PhoneServiceMgmtImpl implements IPhoneServiceMgmt{

	@Autowired
	private IPhoneRepository repo;

	@Override
	public Mono<Phone> savePhone(Phone phone) {
		// use repository
		Mono<Phone> monoPhone = repo.save(phone); 
		
		return monoPhone;
	}

	@Override
	public Flux<Phone> listOfPhones() {
		// 
		return repo.findAll().switchIfEmpty(Flux.empty());
	}

	@Override
	public Mono<Response> findById(Integer pid) {
	    return repo.findById(pid)
	            .map(phone -> new Response(phone)) // If found, wrap the Phone in the Response
	            .switchIfEmpty(Mono.just(new Response("Phone with ID " + pid + " not found"))); // If not found, wrap the message in the Response
	}

	@Override
	public Mono<String> deletePhoneById(Integer pid) {
		// TODO Auto-generated method stub
		
		return repo.findById(pid)
				.switchIfEmpty(Mono.error(new RuntimeException("Phone document not for deletion")))
				.flatMap(phone-> repo.delete(phone))
				.then(Mono.just("sucessfully delete phone document thsi Id "+pid));
	}
	
	@Override
		public Mono<String> updatePhone(Phone phone) {
			// TODO  getting Phone Object from databse
		   return repo.findById(phone.getPid())
				   .flatMap(existing->{
					   BeanUtils.copyProperties(phone, existing);
					   return repo.save(existing);
				   }).map(up->"Phone updated successfully with ID:"+up.getPid())
				   .switchIfEmpty(Mono.just("Phone with ID " + phone.getPid() + " not found for updation "));
		   
		}	
	
	@Override
	public Flux<Phone> phonesFindByname(String name) {
		// 
		Flux<Phone> list = repo.findByName(name);
		return list.switchIfEmpty(Flux.empty());
	}
}
