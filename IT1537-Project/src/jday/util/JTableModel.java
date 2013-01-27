package jday.util;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import jday.entities.Booking;
import jday.entities.dao.AdminViewBookingDAO;

public class JTableModel implements TableModel {


		private final long serialVersionUID = 1L;
		private final String[] COLUMN_NAMES = new String[] {"memberid", "bookingno", "location", "time"};
		private final Class<?>[] COLUMN_TYPES = new Class<?>[] {String.class, String.class, String.class,  String.class};
		
		ArrayList<Booking> bookingList = AdminViewBookingDAO.retrieveAll();
		int count = bookingList.size();
		
		@Override public int getColumnCount() {
			return COLUMN_NAMES.length;
		}

		@Override public int getRowCount() {
			return count;
		}
		
		@Override public String getColumnName(int columnIndex) {
	        return COLUMN_NAMES[columnIndex];
	    }
		
		@Override public Class<?> getColumnClass(int columnIndex) {
			return COLUMN_TYPES[columnIndex];
		}

		@Override public Object getValueAt(final int rowIndex, final int columnIndex) {
			switch (columnIndex) {
				case 0: return bookingList.get(rowIndex).getMemberid();
				case 1: return bookingList.get(rowIndex).getBookingno();
				case 2: return bookingList.get(rowIndex).getVenue();
				case 3: return bookingList.get(rowIndex).getTime();
						
				default: return "Error";
			}
		}

		@Override
		public void addTableModelListener(TableModelListener l) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void removeTableModelListener(TableModelListener l) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			
		}	
	}

	


