package jday.util;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import jday.entities.FnB;
import jday.entities.Member;

public class FnBViewTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
    private int rowCount, colCount;
    private String[] columnNames = {"Order", "Quantity", "Order Number","Venue"};
    private Object [][] data;

    public FnBViewTableModel(ArrayList<FnB> listOfObjects) {
        rowCount = listOfObjects.size();
        colCount = columnNames.length;
        data = new Object[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
           /*Copy an ArrayList element to an instance of MyObject*/
            FnB fnb = listOfObjects.get(i); 
            data[i][0] = fnb.getFnborder();          
            data[i][1] = fnb.getQuantity();
            data[i][2] = fnb.getBookingno();
            data[i][3] = fnb.getVenue();

        }              
    } 
    @Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colCount;
	}
    @Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rowCount;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data[rowIndex][columnIndex];
	}
    public String getColumnName(int col) {
        return columnNames[col];
    }
}