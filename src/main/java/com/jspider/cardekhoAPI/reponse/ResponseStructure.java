package com.jspider.cardekhoAPI.reponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseStructure <T> {
	
	
	private String massage;
	private T data;
	private int status;
		

	

}
