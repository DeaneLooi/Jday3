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
	private JTable table;

	public ABooking() {
		super();
		initialize();
	}
	
	public ABooking(JFrame f){
		this();
		myFrame = f;
		
		JTable table = new JTable();
		
		BookingTableModel model = new BookingTableModel(AdminViewBookingDAO.retrieveAll());
		table.setBounds(0, 0, 400, 450);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(80, 100, 580, 280);
		//table.setFillsViewportHeight(true);	
		//table.setCellSelectionEnabled(true);
		table.setModel(model);
		add(scrollPane);
	}
	
	private void initialize(){
		setSize(new Dimension(750, 500));
		setLayout(null);
		
		JLabel label = new JLabel("logo");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel panel = new AMainpage(myFrame);
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

		table.setBounds(84, 124, 583, 240);
		table.setBackground(new Color(216, 191, 216));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setRowHeight(30);
		
		
		
		/*table.setModel(bookingList);
		ViewBookingList[] viewBooking= new ViewBookingList[];
			 viewBooking.setMemberid(memberid());
		
			for(int i=0; i<viewBooking.length; i++){
				
			}
		ArrayList <viewBooking> bookingList = new ArrayList<String>();
		bookingList.add("");
		*/

		add(table);
	}
}
