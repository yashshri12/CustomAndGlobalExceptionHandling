package com.rest.api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmptyInput extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMessage;

}
