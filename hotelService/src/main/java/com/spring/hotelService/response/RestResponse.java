package com.spring.hotelService.response;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestResponse {

	private boolean status;
	private String message;
	private Map<String , Object> content;

}
