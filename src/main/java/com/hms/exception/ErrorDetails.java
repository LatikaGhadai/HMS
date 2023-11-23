package com.hms.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorDetails {
	
	private Date timeStamp;
	private String details;
	private String message;

}
