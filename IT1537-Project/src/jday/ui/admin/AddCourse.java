package jday.ui.admin;

import javax.swing.JFrame;

import jday.entities.CourseBooking;
import jday.util.BackgroundPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCourse extends BackgroundPanel {
	private JTextField tfCourse;
	private JTextField tfFees;
	private JTextField tfTiming;
	private JTextField tfVenue;
	private JTextField tfDescription;
	public AddCourse() {
		super();
		initialize();
	}
	
	public AddCourse(JFrame f){
		this();
		myFrame =f;
	}
	
	private void initialize(){
		
		setLayout(null);
		
		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setFont(new Font("Candara", Font.BOLD, 16));
		lblCourse.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourse.setBounds(10, 11, 153, 38);
		add(lblCourse);
		
		JLabel lblFees = new JLabel("Fees:");
		lblFees.setHorizontalAlignment(SwingConstants.CENTER);
		lblFees.setFont(new Font("Candara", Font.BOLD, 16));
		lblFees.setBounds(10, 65, 153, 38);
		add(lblFees);
		
		JLabel lblTiming = new JLabel("Timing:");
		lblTiming.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiming.setFont(new Font("Candara", Font.BOLD, 16));
		lblTiming.setBounds(10, 114, 153, 38);
		add(lblTiming);
		
		JLabel lblVenue = new JLabel("Venue:");
		lblVenue.setHorizontalAlignment(SwingConstants.CENTER);
		lblVenue.setFont(new Font("Candara", Font.BOLD, 16));
		lblVenue.setBounds(10, 163, 153, 38);
		add(lblVenue);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setFont(new Font("Candara", Font.BOLD, 16));
		lblDescription.setBounds(10, 212, 153, 38);
		add(lblDescription);
		
		tfCourse = new JTextField();
		tfCourse.setBounds(155, 11, 230, 29);
		add(tfCourse);
		tfCourse.setColumns(10);
		
		tfFees = new JTextField();
		tfFees.setColumns(10);
		tfFees.setBounds(155, 65, 230, 29);
		add(tfFees);
		
		tfTiming = new JTextField();
		tfTiming.setColumns(10);
		tfTiming.setBounds(155, 114, 230, 29);
		add(tfTiming);
		
		tfVenue = new JTextField();
		tfVenue.setColumns(10);
		tfVenue.setBounds(155, 163, 230, 29);
		add(tfVenue);
		
		tfDescription = new JTextField();
		tfDescription.setColumns(10);
		tfDescription.setBounds(155, 212, 230, 29);
		add(tfDescription);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setOpaque(false);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String course = tfCourse.getText();
				String fees = tfFees.getText();
				String timing = tfTiming.getText();
				String venue = tfVenue.getText();
				String description = tfDescription.getText();
				CourseBooking cb = new CourseBooking(course,fees,timing,venue,description);
				CourseBooking cb1 = new CourseBooking();
				cb1 = cb.createClass(cb);
				if(cb1 !=null)
					JOptionPane.showMessageDialog(null, "Course Added");
				else
					JOptionPane.showMessageDialog(null, "Course has not been added");
				myFrame.setVisible(false);

			}
		});
		btnAdd.setBounds(299, 252, 89, 23);
		add(btnAdd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				myFrame.dispose();
			}
		});
		btnCancel.setOpaque(false);
		btnCancel.setBounds(187, 252, 89, 23);
		add(btnCancel);
		
	}
}
