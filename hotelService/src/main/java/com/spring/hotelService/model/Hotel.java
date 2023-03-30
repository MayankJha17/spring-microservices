package com.spring.hotelService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "Hotels")
public class Hotel {

	@Id
	private String id;
	private String name;
	private String location;
	private String about = "";

}
