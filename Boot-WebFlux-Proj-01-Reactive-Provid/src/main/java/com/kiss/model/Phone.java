package com.kiss.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.GroupSequence;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@NoArgsConstructor
@RequiredArgsConstructor
@Document
@AllArgsConstructor
@Data
public class Phone {

	@Id
	private Integer pid;
	@NonNull
	private String name;
	@NonNull
	private String model;
	@NonNull
	private String ram;
	@NonNull
	private String Storage;
	@NonNull
	private Double price;
	@NonNull
	private Integer quantity;
}
