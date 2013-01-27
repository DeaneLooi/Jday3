package jday.ui.admin;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;

import jday.entities.CourseBooking;
import jday.util.BackgroundPanel;
import jday.util.ClassTableModel;
import javax.swing.JButton;



import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class AUpdateCourse extends BackgroundPanel{
	
	final JTable tableList = new JTable();
	
	public AUpdateCourse(){
		super();
		initialize();
	}
	
	public AUpdateCourse(JFrame f){
		this();
		myFrame = f;
	}
	
	private void initialize(){
		setSize(750,500);
		setLayout(null);
		
		JButton btnAddCourse = new JButton("Add Course");
		btnAddCourse.setOpaque(false);
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateFrame frame = new UpdateFrame();
				frame.setVisible(true);
				
				Timer timer = new Timer(10000, new ActionListener() {
					  @Override
					  public void actionPerformed(ActionEvent arg0) {
							ClassTableModel model = new ClassTableModel(CourseBooking.retrieveCourses());
							tableList.setModel(model);
					  }
					});
					timer.setRepeats(false);
					timer.start(); 
			}
		});
		btnAddCourse.setFont(new Font("Candara", Font.PLAIN, 16));
		btnAddCourse.setBounds(41, 405, 130, 37);
		add(btnAddCourse);
		
		JButton btnRemoveCourse = new JButton("Remove Course");
		btnRemoveCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					actionPerformedDelete();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});
		btnRemoveCourse.setOpaque(false);
		btnRemoveCourse.setFont(new Font("Candara", Font.PLAIN, 16));
		btnRemoveCourse.setBounds(210, 405, 161, 37);
		add(btnRemoveCourse);
		

		ClassTableModel model = new ClassTableModel(CourseBooking.retrieveCourses());
		tableList.setModel(model);
		tableList.setBounds(0,0,850,165);
		tableList.getColumnModel().getColumn(0).setPreferredWidth(75);
		tableList.getColumnModel().getColumn(1).setPreferredWidth(300);
		tableList.getColumnModel().getColumn(2).setPreferredWidth(300);
		tableList.getColumnModel().getColumn(3).setPreferredWidth(200);
		tableList.getColumnModel().getColumn(4).setPreferredWidth(300);
		
		JScrollPane scrollPane = new JScrollPane(tableList);
		scrollPane.setBounds(0, 75, 750, 165);
		add(scrollPane);

	}
	
	public void actionPerformedDelete() throws SQLException{
		int rowSelected = tableList.getSelectedRow();
		System.out.println(rowSelected);
		if(rowSelected>=0){
		String course = tableList.getValueAt(rowSelected, 0).toString();
		CourseBooking cb1 = new CourseBooking(course);
		int dialog = JOptionPane.showConfirmDialog(null,"Are you sure you want to remove course?");
		if(dialog == JOptionPane.YES_OPTION)
		cb1.deleteCourse();
		else
			cb1 = null;
		
		
		ClassTableModel model = new ClassTableModel(CourseBooking.retrieveCourses());
		tableList.setModel(model);
		
		}
		
		else 
			JOptionPane.showMessageDialog(null,"No record Selected", "Alert",
					JOptionPane.ERROR_MESSAGE);
	}
	
}
