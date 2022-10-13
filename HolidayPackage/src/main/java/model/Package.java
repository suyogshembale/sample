package model;

public class Package {
	String packageId;
	String sourcePlace;
	String destinationPlace;
	double basicFare;
	int noOfDays;
	double packageCost;
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public String getSourcePlace() {
		return sourcePlace;
	}
	public void setSourcePlace(String sourcePlace) {
		this.sourcePlace = sourcePlace;
	}
	public String getDestinationPlace() {
		return destinationPlace;
	}
	public void setDestinationPlace(String destinationPlace) {
		this.destinationPlace = destinationPlace;
	}
	public double getBasicFare() {
		return basicFare;
	}
	public void setBasicFare(double basicFare) {
		this.basicFare = basicFare;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	public double getPackageCost() {
		return packageCost;
	}
	public void setPackageCost(double packageCost) {
		this.packageCost = packageCost;
	}
	public void calculatePackageCost() {
		double basicFare=getBasicFare();
		 int nod=getNoOfDays();
		 double discount=0;
		 
		 if(nod<=5) {discount=0;}
		 else if(nod>5 && nod<=8) {discount=0.03;}
		 else if(nod>8 && nod<=10) {discount=0.05;}
		 else if(nod>10) {discount=0.07;}
		 
		double d=(basicFare*nod)-(discount*(basicFare*nod));
		double gst=d*0.12;
		d=d+gst;
		this.packageCost=d;
	}

}
