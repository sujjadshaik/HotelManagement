package com.mindtree.hotelmanagement.entity;

import java.util.List;

public class Hotel {
	private int id;
	private String name;
	private String city;
	private List<Room> room;

	public Hotel() {
		// TODO Auto-generated constructor stub
	}

	public List<Room> getRoom() {
		return room;
	}

	public void setRoom(List<Room> room) {
		this.room = room;
	}

	public Hotel(int id, String name, String city, List<Room> room) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.room = room;
	}

	public Hotel(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
