package jday.ui.user;

import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import jday.entities.SpaBookingDetails;
import jday.entities.dao.SpaBookingDetailsDAO;
import jday.util.BackgroundPanel;
import javax.swing.JTextField;

public class SpaConfirmation extends BackgroundPanel {


	private SpaBookingDetails spaBookingDetails;
	
	public SpaConfirmation(JFrame myFrame, SpaBookingDetails bookingDetails) {
		super();
		spaBookingDetails = bookingDetails;
		this.myFrame = myFrame;
		initialize();
	}

	/*public SpaConfirmation(JFrame f) {
		this();
		myFrame = f;
		
	}
	
	public void setBookingDetails(SpaBookingDetails bookingDetails) {
		spaBookingDetails = bookingDetails;
	}*/
	
	private void initialize(){
		setSize(750,500);
		setLayout(null);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//SpaBookingDetailsDao.save(spaBookingDetails);
				JPanel panel = new SpaPackages(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
				
			}
		});
		btnNewButton.setOpaque(false);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(316, 309, 89, 23);
		add(btnNewButton);
		
		JTextPane txtpnDearMemberYou = new JTextPane();
		txtpnDearMemberYou.setBorder(new LineBorder(new Color(123, 104, 238), 4));
		
		String dateDetails = spaBookingDetails.getDay() + "." + spaBookingDetails.getMonth() + ". " + spaBookingDetails.getYear();
		String sessionDetails = spaBookingDetails.getSession();
		String timeDetails = spaBookingDetails.getTime();
		
		txtpnDearMemberYou.setText("      \r\n    Dear member, you have booked the following:\r\n\r\n\r\n\tDate:       " + dateDetails + "\r\n\tTime:       " + timeDetails + "\r\n\tSession: " + sessionDetails + " \r\n\t\r\n\t\tYour booking No. is 5634A\r\n\r\n    Please present the booking number upon\r\n    arrival.       \r\n\t\r\n    Thank you!\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t");
		txtpnDearMemberYou.setOpaque(false);
		txtpnDearMemberYou.setEditable(false);
		txtpnDearMemberYou.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtpnDearMemberYou.setForeground(new Color(0, 0, 0));
		txtpnDearMemberYou.setBounds(53, 32, 387, 341);
		add(txtpnDearMemberYou);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(58, 233, 382, 2);
		add(separator);
	}
}
