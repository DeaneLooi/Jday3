/*******************************************************************************
 * Program Name: 			ABooking
 * Purpose:					for admin staff to view booking that user booked 
 * Name of Author:			Di Yuwen
 * Admin No. of Author:		120923R
 * Module Group: 			IS1201
 * *****************************************************************************/
package jday.ui.admin;
import javax.swing.JPanel;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import jday.util.BackgroundPanel;
import jday.util.BookingTableModel;
import jday.util.ClassTableModel;
import jday.util.ProfileTableModel;
import jday.entities.*;
import jday.entities.dao.AdminViewBookingDAO;
import jday.entities.dao.MemberDAO;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class ABooking extends BackgroundPanel {
	private JTable table = new JTable();

	public ABooking() {
		super();
		initialize();
	}
	
	public ABooking(JFrame f,Member m){
		this();
		myFrame = f;
		this.m = m;
		BookingTableModel model = new BookingTableModel(AdminViewBookingDAO.retrieveAll());
		
		table.setModel(model);
		table.setBounds(0, 0, 400, 450);
		table.setBackground(new Color(216, 191, 216));
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setRowHeight(30);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100, 140, 600, 320);
		
		add(scrollPane);
		

	}
	
	private void initialize(){
		
		setSize(new Dimension(750, 500));
		setLayout(null);
		
		JLabel label = new JLabel("logo");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel panel = new AMainpage(myFrame,m);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		label.setBounds(50, 31, 94, 102);
		label.setIcon(new ImageIcon(ABooking.class.getResource("/images/90logo.png")));
		add(label);
		
		JLabel lblJdayBooking = new JLabel("View Booking");
		lblJdayBooking.setBounds(454, 0, 204, 42);
		lblJdayBooking.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(lblJdayBooking);

		add(table);
		
		/*JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					deleteBooking();
				}catch (SQLException e){
					e.printStackTrace();
			}
			}
		});
		btnDelete.setBounds(572, 448, 89, 23);
		add(btnDelete);
	}
	///////////////////
	public void deleteBooking() throws SQLException{
		int rowSelected = table.getSelectedRow();
		System.out.println(rowSelected);
		if(rowSelected>=0){
		String book = table.getValueAt(rowSelected, 3).toString();
		Booking bookings = new Booking(Integer.parseInt(book));
		int dialog = JOptionPane.showConfirmDialog(null,"Are you sure to remove this booking?");
		if(dialog == JOptionPane.YES_OPTION)
		bookings.deleteBooking();
		else
			bookings = null;
		
		
		BookingTableModel model = new BookingTableModel(AdminViewBookingDAO.retrieveAll());
		table.setModel(model);
		
		}
		
		else 
			JOptionPane.showMessageDialog(null,"No record Selected", "Alert",
					JOptionPane.ERROR_MESSAGE);
	}*/
}}
