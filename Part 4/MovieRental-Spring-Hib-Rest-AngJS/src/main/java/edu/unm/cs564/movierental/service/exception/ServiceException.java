package edu.unm.cs564.movierental.service.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ServiceException() {		
	}

	public ServiceException(String message){
		super(message);
	}
}
