package jday.util;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.AbstractTableModel;

import jday.entities.FnB;

public class FnBTableModel extends AbstractTableModel{
	
	JSpinner spinner;
	JTable table;
	
	private ArrayList<FnB>list = new ArrayList<FnB>();
	private static final long serialVersionUID = 1L;
    private int rowCount, colCount;
    private String[] columnNames = {"Orders", "Quantity"};
    private Object [][] data;
    Class[] types = new Class [] {  
            java.lang.Object.class, java.lang.Integer.class 
    		};  

    public FnBTableModel(ArrayList<FnB> listOfObjects) {
    	
        rowCount = listOfObjects.size();
        for(int i=0; i<rowCount; i++){
        	FnB fnb1 = listOfObjects.get(i);
        	list.add(fnb1);
        }
        colCount = columnNames.length;
        data = new Object[rowCount][colCount];
        
		for(int i=0; i<list.size();i++){
			FnB fnb = list.get(i);
			   data[i][0] = fnb.getFnborder();  
			   data[i][1] = fnb.getQuantity();
	           //SpinnerModel model = new SpinnerNumberModel(fnb.getQuantity(),0,100,1);
	           // spinner = new JSpinner(model);
	           // data[i][1] = spinner;
		}
    } 
    
    @SuppressWarnings("unchecked")
	@Override
    public Class getColumnClass(int columnIndex){
    	
    	return types[columnIndex];
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
    
	public boolean isCellEditable(int row, int col) {
        
        if (col == 1) {
            return true;
        } else {
            return false;
        }
	}
	
	public void setValueAt(Object value, int row, int col){
		data[row][col] = value;
		fireTableDataChanged();
	}

}
