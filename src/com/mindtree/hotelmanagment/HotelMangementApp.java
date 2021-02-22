package com.mindtree.hotelmanagment;

import com.mindtree.hotelmanagement.exceptions.ServiceException;
import com.mindtree.hotelmanagement.service.HotelOperations;
import com.mindtree.hotelmanagement.service.Validation;

public class HotelMangementApp {
	public static void main(String[] args) {
		Validation validation = new Validation();
		HotelOperations operations = new HotelOperations();
		do {
			System.out.println("Enter 1 to add hotel\nEnter 2 list hotel deatails by city\nEnter 3 to get rooms by hotel id");
			int in = validation.ValidateIntegerInput();
			switch (in) {
			case 1:
				try {
					operations.addHotel();
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				try {
					operations.listHotels();
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try {
					operations.listRooms();
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			default:
				System.out.println("Invalid option");        
				break;
			}
		}while(true);

	}

}
