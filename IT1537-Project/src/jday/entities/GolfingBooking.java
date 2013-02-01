//golf booking, store in database
package jday.entities;

public class GolfingBooking extends Booking {
	
	private String date;
	private String greenfees;
	private double price;
	
	public GolfingBooking(){}
	public GolfingBooking(String memberid, int bookingno, String venue, String time, String date, String greenfees, double price){
		super(memberid, bookingno, venue, time);
		this.date=date;
		this.greenfees=greenfees;
		this.price=price;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getGreenfees() {
		return greenfees;
	}
	public void setGreenFees(String greenfees) {
		this.greenfees = greenfees;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
