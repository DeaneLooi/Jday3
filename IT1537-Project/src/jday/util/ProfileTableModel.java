package jday.util;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import jday.entities.Booking;
import jday.entities.Member;
import jday.entities.dao.AdminViewBookingDAO;

public class ProfileTableModel extends AbstractTableModel {
	private final long serialVersionUID = 1L;
	private int rowCount, colCount;
	private String[] columnNames = {"memberid", "name", "birthdate" , "contactnoH", "contactnoM", "email" , "address"};
	private Object [] [] data;
	
	//ArrayList<Member> memberList = new ArrayList<Member>();
	
	public ProfileTableModel(ArrayList<Member>memList){
	rowCount = memList.size();
	colCount = columnNames.length;
	data = new Object[rowCount][colCount];
	for(int i = 0; i< rowCount; i++){
		/*Copy an ArrayList element to an instance of MyObject*/
        Member member = memList.get(i); 
        data[i][0] = member.getMemberid();          
        data[i][1] = member.getName();
        data[i][2] = member.getBirthdate();
        data[i][3] = member.getContactnoH();
        data[i][4] = member.getContactnoM();
        data[i][5] = member.getEmail();
        data[i][6] = member.getAddress();
	}
	
	}
	@Override public int getColumnCount() {
		return colCount;
	}

	@Override public int getRowCount() {
		return rowCount;
	}
	
	@Override public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

	public String getColumnName(int col){
		return columnNames[col];
	}
	
}


