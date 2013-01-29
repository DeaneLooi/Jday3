package jday.ui.admin;
import javax.swing.JPanel;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import jday.util.BackgroundPanel;
import jday.util.BookingTableModel;
import jday.util.ProfileTableModel;
import jday.entities.*;
import jday.entities.dao.AdminViewBookingDAO;
import jday.entities.dao.MemberDAO;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

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
        scrollPane.setBounds(80, 120, 580, 250);
		
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
		label.setBounds(10, 11, 94, 102);
		label.setIcon(new ImageIcon(ABooking.class.getResource("/images/90logo.png")));
		add(label);
		
		JLabel lblJdayBooking = new JLabel("JDAY View Booking");
		lblJdayBooking.setBounds(125, 42, 277, 42);
		lblJdayBooking.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		add(lblJdayBooking);

		add(table);
	}
}
