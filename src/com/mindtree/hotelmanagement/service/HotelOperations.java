package com.mindtree.hotelmanagement.service;

import java.util.List;
import java.util.Scanner;


import com.mindtree.hotelmanagement.Dao.DaoImplementation;
import com.mindtree.hotelmanagement.entity.Hotel;
import com.mindtree.hotelmanagement.entity.Room;
import com.mindtree.hotelmanagement.exceptions.DaoException;
import com.mindtree.hotelmanagement.exceptions.ServiceException;


public class HotelOperations implements HotelServices {
	Validation validation = new Validation();
	DaoImplementation daoImplementation = new DaoImplementation();

	@Override
	public void addHotel() throws ServiceException {
		// TODO Auto-generated method stub
		System.out.println("Enter hotel id");
		int hotelId = validation.ValidateIntegerInput();
		System.out.println("Enter hotel name");
		String name = validation.ValidateStringInputAfterInterInput();
		System.out.println("Enter city");
		String city = validation.ValidateStringInput();
		try {
			daoImplementation.addHotels(new Hotel(hotelId, name, city));
			System.out.println("Hotel is created");
			while(true) {
				System.out.println("want to add room yes or no");
				String option = validation.ValidateStringInput();
				if(option.equalsIgnoreCase("yes")) {
				System.out.println("enter room id");
				int roomId = validation.ValidateIntegerInput();
				System.out.println("Enter room type");
				String type = validation.ValidateStringInputAfterInterInput();
				System.out.println("Enter room price");
				int price = validation.ValidateIntegerInput();
				daoImplementation.addRooms(new Room(hotelId, roomId, type, price));
			
				}else {
					break;
				}
			}

		} catch (DaoException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}

	}

	@Override
	public void listHotels() throws ServiceException {
		// TODO Auto-generated method stub
		System.out.println("Enter city");
		String city = validation.ValidateStringInputAfterInterInput();
		try {
			for(Hotel hotel : daoImplementation.getAllHotels(city)) {
//				System.out.println("check");
				System.out.println("id:"+hotel.getId()+"\nname :"+hotel.getName());
				for(Room room : hotel.getRoom()) {
					System.out.println("RoomId:"+room.getId());
					System.out.println("type:"+room.getRoomType());
					System.out.println("price:"+room.getPrice());
				}
			}
			
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}
		
	}

	@Override
	public void listRooms() throws ServiceException {
		// TODO Auto-generated method stub
		System.out.println("Enter hotel id to show rooms");
		int hotelid = validation.ValidateIntegerInput();
		try {
			for(Room room : daoImplementation.getAllRooms(hotelid)) {
				System.out.println("id:"+room.getId()+"\nroomtype :"+room.getRoomType()+"\nprice:"+room.getPrice());
			}
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}
		
	}

}
