package model;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import connection.DBHandler;



public class AddToDB {
	
	public static void addPackDetailsToDB(List<Package> lis) {
		Connection conn=DBHandler.establishConnection();
		for(Package p:lis) {
		
		try {
			PreparedStatement ps=conn.prepareStatement("insert into package_details values(?,?,?,?,?)");
			ps.setString(1, p.getPackageId());
			ps.setString(2, p.getSourcePlace());
			ps.setString(3,p.getDestinationPlace());
			ps.setInt(4, p.getNoOfDays());
			int t=(int) p.getPackageCost();
			ps.setInt(5, t);
			ps.executeUpdate();
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		
		
		
	}

	
}