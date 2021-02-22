package com.mindtree.hotelmanagement.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.hotelmanagement.entity.Hotel;
import com.mindtree.hotelmanagement.entity.Room;
import com.mindtree.hotelmanagement.exceptions.DaoException;
import com.mindtree.hotelmanagement.utility.DButility;

public class DaoImplementation implements DaoService{

	DButility dbUtility = new DButility();

	@Override
	public void addHotels(Hotel hotel) throws DaoException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO HOTEL (ID,name,city) values (?,?,?)";
		
		try {
			PreparedStatement statement = dbUtility.connectDB().prepareStatement(sql);
			statement.setInt(1, hotel.getId());
			statement.setString(2, hotel.getName());
			statement.setString(3, hotel.getCity());
			statement.execute();
			
			dbUtility.connectDB().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException(e);
		};
		
	}

	@Override
	public void addRooms(Room room) throws DaoException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO ROOM (ID,hotelId,type,price) values (?,?,?,?)";
		try {
			PreparedStatement statement = dbUtility.connectDB().prepareStatement(sql);
			statement.setInt(1, room.getId());
			statement.setInt(2, room.getHotelID());
			statement.setString(3, room.getRoomType());
			statement.setInt(4, room.getPrice());
			statement.execute();
			
			dbUtility.connectDB().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException(e);
		}
		
		
	}

	@Override
	public List<Hotel> getAllHotels(String city) throws DaoException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM HOTEL where city = ?";
		int hotelId = 0;
		List<Hotel> hotels = new ArrayList<>();
		List<Room> rooms = new ArrayList<>();
		try {
			PreparedStatement statement = dbUtility.connectDB().prepareStatement(sql);
			statement.setString(1, city);
			
			ResultSet resultSet = statement.executeQuery();
//			Hotel hotel = new Hotel();
			

			while(resultSet.next()) {
				Hotel hotel = new Hotel();
				hotel.setId(resultSet.getInt("id"));
				hotelId = resultSet.getInt("id");
				hotel.setName(resultSet.getString("name"));
				hotel.setCity(resultSet.getString("city"));
				hotel.setRoom(getAllRooms(hotelId));
				hotels.add(hotel);
//				hotels.add(hotel);
			}
			
			dbUtility.connectDB().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
				throw new DaoException(e);
			
		}
		if(hotels.isEmpty() && hotelId == 0) 
			throw new DaoException("hotels of given city are not present");
		
		return hotels;
		
	}

	@Override
	public List<Room> getAllRooms(int hotelId) throws DaoException {
		// TODO Auto-generated method stub
		List<Room> rooms = new ArrayList<>();
		String sql = "select * from room where hotelId = ?";
		try {
			PreparedStatement statement = dbUtility.connectDB().prepareStatement(sql);
			statement.setInt(1, hotelId);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Room room = new Room();
				room.setId(resultSet.getInt("id"));
				room.setHotelID(resultSet.getInt("hotelId"));
				room.setRoomType(resultSet.getString("type"));
				room.setPrice(resultSet.getInt("price"));
				rooms.add(room);
			}
			dbUtility.connectDB().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException(e);
		}
		return rooms;
	}
	
	

	
}
