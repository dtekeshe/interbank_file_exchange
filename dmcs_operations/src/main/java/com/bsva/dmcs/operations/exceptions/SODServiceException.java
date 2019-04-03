package com.bsva.dmcs.operations.exceptions;

public class SODServiceException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	private String errorcode;

	    public SODServiceException() {
	    }

	    public SODServiceException(String msg) {
	        super(msg);
	    }

	    public SODServiceException(String msg, Throwable th) {
	        super(msg, th);
	    }

	    public SODServiceException(String msg, String errorcode, Throwable th) {
	        super(msg, th);
	        this.errorcode = errorcode;
	    }

	    public String getErrorcode() {
	        return errorcode;
	    }

	    public void setErrorcode(String errorcode) {
	        this.errorcode = errorcode;
	    }
}
