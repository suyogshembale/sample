package control;
import java.util.List;

import model.Package;
import utility.TravelAgency;

public class MainMethod {

	public static void main(String[] args){
		//AddToDB.addPackDetailsToDB(List<Package> lis);
		TravelAgency t = new TravelAgency();
		try {
			List<Package> minDaysPackage = t.findPackagesWithMinimumNumberOfDays();
			for(Package p: minDaysPackage) {
				System.out.println(p.getPackageId()+" "+p.getSourcePlace()+" "+p.getDestinationPlace()+" "+p.getNoOfDays()+" "+p.getPackageCost());
			}
		

			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}

}