package jday.entitites.dao;

import java.util.ArrayList;

import jday.entities.Member;
import jday.entities.dao.MemberDAO;

import org.junit.Test;

public class MemberDAOTest {

	@Test
	public void testSearchByName() {
		
		String name = "yuwen";
		/*Member member = MemberDAO.searchByName(name);
		assert(member.getEmail().equals("d.yuwen.yw@gmail.com"));
		System.out.println(member.getAddress());
		System.out.println(member.getEmail());
		System.out.println(member.getMemberid());
		*/
	
	}
	
	@Test
	public void testRegister() {
		Member member = new Member();
		member.setMemberid("100000e");
		member.setName("arifah");
		member.setBirthdate("12/12/12");
		member.setContactnoH(81293456);
		member.setContactnoM(96678677);
		member.setEmail("arifah@yahoo.com.");
		member.setAddress("dsacdcvldkhn,d");
		MemberDAO.register(member);
	}
	
	@Test
	public void testRetrieveAll(){
		ArrayList<Member> memberList = MemberDAO.retrieveAll();
		for (Member member:memberList)
		System.out.println(member.getMemberid()+ ","+ member.getName()+"," + member.getBirthdate() + "'" + member.getContactnoH() + ","+ member.getContactnoM()+ ","+ member.getAddress() + "," +member.getEmail() + ",");
	}

}
