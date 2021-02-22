package com.mindtree.hotelmanagement.entity;

public class Room {
	private int hotelID;
	private int id;
	private String roomType;
	private int price;
	public Room() {
		// TODO Auto-generated constructor stub
	}
	public Room(int hotelID, int id, String roomType, int price) {
		super();
		this.hotelID = hotelID;
		this.id = id;
		this.roomType = roomType;
		this.price = price;
	}
	public int getHotelID() {
		return hotelID;
	}
	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
