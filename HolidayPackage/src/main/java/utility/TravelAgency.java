package utility;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import connection.DBHandler;
import model.Package;

public class TravelAgency{
	public List<Package> generatePackageCost(String f){
		List<Package> list = new ArrayList<Package>();
		try {
			Reader reader = new FileReader(f);
			BufferedReader br = new BufferedReader(reader);
			String s = "";
			while((s=br.readLine())!= null) {
				Package p = new Package();
				String []a = s.split(",");
				String packageId = a[0];
				try {   
					if(validate(packageId)) {
						p.setPackageId(a[0]);
						p.setSourcePlace(a[1]);
						p.setDestinationPlace(a[2]);
						p.setBasicFare((Double.parseDouble(a[3])));
						p.setNoOfDays(Integer.parseInt(a[4]));
						p.calculatePackageCost();
						list.add(p);
					}
				}
				catch (InvalidPackageIdException e) {
					System.out.println(e.getMessage() + packageId);
				}
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	public boolean validate(String s) throws InvalidPackageIdException {
	if(s.length()==7 && s.charAt(3)=='/')
		return true;
		else throw new InvalidPackageIdException("Invalid Pacakge Id");
	}
	

	public List<Package> findPackagesWithMinimumNumberOfDays() {
		List<Package> list = new ArrayList<Package>();
		Connection c = DBHandler.establishConnection();
		try {
			PreparedStatement ps = c.prepareStatement("select * from package_details where no_of_days in (select min(no_of_days) from package_details)");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Package p = new Package();
				p.setPackageId(rs.getString(1));
				p.setSourcePlace(rs.getString(2));
				p.setDestinationPlace(rs.getString(3));
				p.setNoOfDays(rs.getInt(4));
				p.setPackageCost(rs.getDouble(5));
				list.add(p);
			}
			c.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
		
	}
}
