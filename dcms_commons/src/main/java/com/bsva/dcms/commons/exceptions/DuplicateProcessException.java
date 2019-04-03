package com.bsva.dcms.commons.exceptions;

public class DuplicateProcessException extends Exception {
	
	
	public DuplicateProcessException(){
		super();
	}

	public DuplicateProcessException(String msg){
		super(msg);
	}
	
	public DuplicateProcessException(String msg, Throwable cause){
		super(msg, cause);
	}
}
