package jday.ui.user;

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

import jday.entities.KaraokeBookingEntities;
import jday.entities.Member;
import jday.util.BackgroundPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class KaraokeConfirmation extends BackgroundPanel {

	private KaraokeBookingEntities karaokeBookingEntities;
	
	public KaraokeConfirmation(JFrame myFrame, KaraokeBookingEntities bookingDetails, Member m) {
		super();
		karaokeBookingEntities = bookingDetails;
		this.myFrame = myFrame;
		this.m = m;
		initialize();
	}

	/*public KaraokeConfirmation(JFrame f) {
		this();
		myFrame = f;
		
	}
	
	public KaraokeConfirmation(JFrame myFrame,
			KaraokeBookingEntities bookingDetails) {
		// TODO Auto-generated constructor stub
	}*/
	
	private void initialize(){
		setSize(750,500);
		setLayout(null);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//KaraokeBookingDetailsDao.save(karaokeBookingEntities);
				JPanel panel = new KaraokeRegular(myFrame, m);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
				
			}
		});
		btnNewButton.setOpaque(false);
		btnNewButton.setFont(new Font("Candara", Font.PLAIN, 17));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(599, 421, 60, 23);
		add(btnNewButton);
		
		JTextPane txtpnDearMemberYou = new JTextPane();
		txtpnDearMemberYou.setBorder(new LineBorder(new Color(153, 0, 102), 4));
		
		String dateDetails = karaokeBookingEntities.getDay() + "." + karaokeBookingEntities.getMonth() + ". " + karaokeBookingEntities.getYear();
		String roomsDetails = karaokeBookingEntities.getSession();
		String timeDetails = karaokeBookingEntities.getTime();
		//String memberId = karaokeBookingEntities.getMemberId();
		
		txtpnDearMemberYou.setText("      \r\n    Dear member, you have booked the following:\r\n\r\n\r\n\r\n\tDate:      "+dateDetails+"\r\n\tTime:       "+timeDetails+"\r\n\tSession:"+roomsDetails+"\r\n\r\n\t\r\n\r\n                                             \t\t         Your booking No. is "+karaokeBookingEntities.getBookingNo()+" \r\n\r\n\r\n   Please present your booking number upon arrival, thank you!");
		txtpnDearMemberYou.setOpaque(false);
		txtpnDearMemberYou.setEditable(false);
		txtpnDearMemberYou.setFont(new Font("Candara", Font.PLAIN, 17));
		txtpnDearMemberYou.setForeground(new Color(0, 0, 0));
		txtpnDearMemberYou.setBounds(103, 89, 592, 386);
		add(txtpnDearMemberYou);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(104, 381, 592, 2);
		add(separator);
		
		JLabel label = new JLabel("BOOKING SUMMARY");
		label.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		label.setBounds(482, 11, 162, 28);
		add(label);
	}
}
