package com.scezen.microservices.contrat_mongodb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)    
public class CreationContratImpossibleException extends RuntimeException {

	/**
	 * 
	 */
	public CreationContratImpossibleException(String message) {
		super(message);
	}

}

