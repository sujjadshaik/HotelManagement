package com.mindtree.hotelmanagement.Dao;

import java.util.List;

import com.mindtree.hotelmanagement.entity.Hotel;
import com.mindtree.hotelmanagement.entity.Room;
import com.mindtree.hotelmanagement.exceptions.DaoException;

public interface DaoService {
	void addHotels(Hotel hotel)throws DaoException;
	void addRooms(Room room)throws DaoException;
	List<Hotel> getAllHotels(String city)throws DaoException;
	List<Room> getAllRooms(int hotelId)throws DaoException;


}
