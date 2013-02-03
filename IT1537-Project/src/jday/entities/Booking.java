//booking for SPA, sport, golf, karaoke
//this is for admin to view booking 
package jday.entities;

public class Booking {
     private String memberid;
     private int bookingno;
     private String venue;
     private String time;
     
    public Booking(){
    	
    }
    
    public Booking(int bookingno){
    	this.bookingno=bookingno;
    }
    
    public Booking(String memberid, int bookingno, String venue, String time){
    	this.memberid=memberid;
    	this.bookingno=bookingno;
    	this.venue=venue;
    	this.time=time;
    	
    }
    
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public int getBookingno() {
		return bookingno;
	}
	public void setBookingno(int bookingno) {
		this.bookingno = bookingno;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
     
}
