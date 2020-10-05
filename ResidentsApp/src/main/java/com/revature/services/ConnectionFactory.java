package com.revature.services;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
// The ConnectionFactory carries all of the information about creating connections
// but does not manage them. It is up to the programmer to close them.
// Typically more useful in real world applications, since many users would be accessing the same
// static variable if used a connection service.
public class ConnectionFactory {
		//private static Connection connection;
		private Connection connection;
		//Connection connection =null;
		
		public Connection getConnection() {
			
			//if(connection ==null) {
				try {
					FileInputStream fis = new FileInputStream("connection.properties");
					Properties prop = new Properties();
					prop.load(fis);
					
					connection = DriverManager.getConnection(prop.getProperty("url"), 
							prop.getProperty("username"), prop.getProperty("password"));
					//Connection connection = DriverManager.getConnection(connectionString, username, password);
					return connection;
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			//}
			return null;
		}
		/*public static void closeConnection() {
			if(connection!=null) {
				try{
					connection.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
		}
	}*/
}
