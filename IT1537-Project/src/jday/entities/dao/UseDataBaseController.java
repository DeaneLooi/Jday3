package jday.entities.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import jday.entities.Admin;
import jday.entities.BasicMember;
import jday.entities.CourseBooking;
import jday.entities.FnB;
import jday.entities.KitchenAdmin;
import jday.entities.Member;
import jday.entities.PremiumMember;
import jday.entities.Register;


public class UseDataBaseController {
	
	public static void main(String args[]) throws Exception{
		/*FnB fnb = new FnB();
		fnb.setFnborder("Grilled Fish");
		fnb.setPrice(21.70);
		fnb.setQuantity(1);
		fnb.setVenue("Room 603");
		Member m = new Member("admin");
		fnb.createOrder(fnb, m);
		*/

		/*for(int i = 0; i <fnb1.size();i++){
		FnB fnb2 =fnb1.get(i);
		System.out.println(fnb2.getBookingno());
		System.out.println(fnb2.getFnborder());
		System.out.println(fnb2.getPrice());
		System.out.println(fnb2.getVenue());
		System.out.println(fnb2.getQuantity());
		}
	*/
		
		Member m = new Member();
		m.setMemberid("sdf");
		m.retrieveMemberInfo();
		System.out.println(m.getMemberid()+m.getAddress());
		}
		
	public static void FnBOrder(ArrayList<FnB>list){
		for(int i=0; i<list.size();i++){
			FnB fnb = list.get(i);
			System.out.println(fnb.getFnborder());
		}
	}

}
