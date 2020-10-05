package com.revature.services;

import java.sql.Connection;

public class ConnectionTest {
	public static void main(String[] args) {
		Connection connect = ConnectionService.getConnection();
		ConnectionService.closeConnection();
	}
}
