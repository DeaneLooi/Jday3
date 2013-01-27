package jday.util;



	import javax.swing.table.AbstractTableModel;
	import java.util.ArrayList;
	import jday.entities.CourseBooking;

	public class ClassTableModel extends AbstractTableModel{
		private static final long serialVersionUID = 1L;
	    private int rowCount, colCount;
	    private String[] columnNames = {"Course", "Fees", "Timing", "Venue","Description"};
	    private Object [][] data;

	    public ClassTableModel(ArrayList<CourseBooking> listOfObjects) {
	        rowCount = listOfObjects.size();
	        colCount = columnNames.length;
	        data = new Object[rowCount][colCount];
	        for (int i = 0; i < rowCount; i++) {
	           /*Copy an ArrayList element to an instance of MyObject*/
	            CourseBooking c1 = listOfObjects.get(i); 
	            c1.retrieveCourse();
	            data[i][0] = c1.getCoursetype();          
	            data[i][1] = c1.getFees();
	            data[i][2] = c1.getTiming();
	            data[i][3] = c1.getVenue();
	            data[i][4] = c1.getDescription();
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
