package jday.entities;

public class SportBooking extends Booking{
	
	private String date;
	private int court;
	
	public SportBooking(){}
	
	public SportBooking(String memberid, int bookingno, String venue, String time, String date, int court){
		super(memberid, bookingno, venue, time);
		this.date=date;
		this.court=court;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	public int getCourt() {
		return court;
	}
	public String getDate() {
		return date;
	}

	public void setCourt(int court) {
		this.court = court;
	}

}
