package connection;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class DBHandler {
	public static Connection establishConnection(){
		Connection conn=null;
		try {
			Class.forName("org.postgresql.Driver");
			 conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/VarshTravelAgency","postgres","3265");
			// System.out.println(" Connection successful");
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("error Connection failed");
		}
		return conn;
	}
}
