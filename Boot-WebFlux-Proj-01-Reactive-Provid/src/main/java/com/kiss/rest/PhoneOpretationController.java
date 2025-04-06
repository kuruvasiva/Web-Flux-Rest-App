package com.kiss.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiss.help.Response;
import com.kiss.model.Phone;
import com.kiss.service.IPhoneServiceMgmt;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/phone-api")
public class PhoneOpretationController {

	@Autowired
	private IPhoneServiceMgmt service;
	
	@PostMapping("/save")
	public ResponseEntity<Mono<Phone>> registerPhone(@RequestBody Phone phone){
		
		// System.out.println(phone);
		System.out.println("RegisterPhone() \033[1;31m"+Thread.currentThread().getName()+"\033[1;0m");
		 Mono<Phone> mono = service.savePhone(phone);
		 return new ResponseEntity<Mono<Phone>>(mono,HttpStatus.CREATED);
	}
	@GetMapping("/all")
	public ResponseEntity<Flux<Phone>> getAllPhones(){
		System.out.println("getAllPhones() \033[1;32m"+Thread.currentThread().getName()+" \033[1;0m");
		 Flux<Phone> flux = service.listOfPhones();
		 return new ResponseEntity<>(flux,HttpStatus.OK);
	}
	@GetMapping("/find/{pid}")
	public ResponseEntity<Mono<Response>> findByIdPhone(@PathVariable Integer pid){
		System.out.println("findByIdPhone() \033[1;33m"+Thread.currentThread().getName()+" \033[1;0m");
		 
		Mono<Response> mono = service.findById(pid);
		 
		 return new ResponseEntity<Mono<Response>>(mono,HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{pid}")
	public ResponseEntity<Mono<String>> deletehoneById(@PathVariable Integer pid){
		System.out.println("deletehoneById() \033[1;34m"+Thread.currentThread().getName()+" \033[1;0m");
		
		Mono<String> deleteMsg = service.deletePhoneById(pid);
	   deleteMsg.subscribe(System.out::println);
		return new ResponseEntity<Mono<String>>(deleteMsg,HttpStatus.OK);
	}
	 
	@PutMapping("/update")
	public ResponseEntity<Mono<String>> updatePhone(@RequestBody Phone phone) {
		System.out.println("updatePhone() \033[1;35m"+Thread.currentThread().getName()+" \033[1;0m");
		
		Mono<String> updateMsg = service.updatePhone(phone);
		
		return new ResponseEntity<>(updateMsg, HttpStatus.OK);
	}
	
	@GetMapping("/findName/{name}")   // get mapping @ReqeuestBody is not working 
	public ResponseEntity<Flux<Phone>> findPhonesByName(@PathVariable String name){
		System.out.println("findByPhone() \033[1;33m"+Thread.currentThread().getName()+" \033[1;0m");
		 
		Flux<Phone> flux = service.phonesFindByname(name);	
		
		 return new ResponseEntity<>(flux,HttpStatus.OK);
	}
	
}
