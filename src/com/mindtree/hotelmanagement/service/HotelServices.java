package com.mindtree.hotelmanagement.service;

import com.mindtree.hotelmanagement.exceptions.ServiceException;

public interface HotelServices {
	void addHotel() throws ServiceException;
	void listHotels() throws ServiceException;
	void listRooms() throws ServiceException;
}
