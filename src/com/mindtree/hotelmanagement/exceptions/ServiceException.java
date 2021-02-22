package com.mindtree.hotelmanagement.exceptions;

public class ServiceException extends DaoException {

	public ServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    } 

}
