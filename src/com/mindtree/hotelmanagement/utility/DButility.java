package com.mindtree.hotelmanagement.utility;

import java.sql.Connection;
import java.sql.DriverManager;


public class DButility {
	private static final String URL = "jdbc:mysql://localhost:3306/mindtree?autoReconnect=true&useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	public DButility() {
		// TODO Auto-generated constructor stub
	}
	public Connection connectDB() {
        Connection conn = null;
        try {
            conn = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

}
