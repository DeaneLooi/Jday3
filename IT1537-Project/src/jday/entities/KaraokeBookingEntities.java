package jday.entities;

public class KaraokeBookingEntities {
	
	private String date;
	private int day; 
	private String month;
	private String year;
	
	private String time; 
	
	private String rooms;
	
	private String memberId;
	
	private int bookingNo;
	
	public KaraokeBookingEntities() {

	}
	public int getDay(){
		return day;
	}
	
	public void setDay(int day) {
		this.day = day;
	}

	
    public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear(){
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public String getRooms() {
		return rooms;
	}

	public void setRooms(String rooms) {
		this.rooms = rooms;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = day + month + year;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getBookingNo() {
		return bookingNo;
	}

	public void setBookingNo(int bookingNo) {
		this.bookingNo = bookingNo;
	}

}
