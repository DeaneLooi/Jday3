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

import jday.entities.Member;
import jday.entities.SpaBookingDetails;
import jday.entities.dao.SpaBookingDetailsDAO;
import jday.entities.BookingNo;
import jday.util.BackgroundPanel;
import jday.util.EmailSender;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Cursor;

public class SpaConfirmation extends BackgroundPanel {


	private SpaBookingDetails spaBookingDetails;
	
	public SpaConfirmation(JFrame myFrame, SpaBookingDetails bookingDetails,Member m) {
		super();
		spaBookingDetails = bookingDetails;
		this.myFrame = myFrame;
		this.m = m;
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
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				JPanel panel = new SpaPackages(myFrame,m);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
		            
				
				
			}
		});
		btnNewButton.setOpaque(false);
		btnNewButton.setFont(new Font("Candara", Font.PLAIN, 17));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(599, 406, 73, 29);
		add(btnNewButton);
		
		JTextPane txtpnDearMemberYou = new JTextPane();
		txtpnDearMemberYou.setBorder(new LineBorder(new Color(153, 0, 102), 4));
		
		String dateDetails = spaBookingDetails.getDay() + "." + spaBookingDetails.getMonth() + ". " + spaBookingDetails.getYear();
		String sessionDetails = spaBookingDetails.getSession();
		String timeDetails = spaBookingDetails.getTime();
		
		
		/* EMAIL
		 * SpaBookingDetails bookingDetails = new SpaBookingDetails();
		 * SpaBookingDetails bookDetails = new SpaBookingDetails();
		 * bookDetails = SpaBookingDetailsDAO.spaBooking(bookingDetails, m);
		 * EmailSender email = new EmailSender(m);
		 * email.sendBookingNumber(bookDetails.getBookingNo());
		 */
		
		txtpnDearMemberYou.setText("      \r\n    Dear member, you have booked the following:\r\n\r\n\r\n\r\n\tDate:      "+dateDetails+"\r\n\tTime:       "+timeDetails+"\r\n\tSession:"+sessionDetails+"\r\n\r\n\t\r\n\r\n                                             \t\t         Your booking No. is "+spaBookingDetails.getBookingNo()+" \r\n\r\n\r\n   Please present your booking number upon arrival, thank you!");
		txtpnDearMemberYou.setOpaque(false);
		txtpnDearMemberYou.setEditable(false);
		txtpnDearMemberYou.setFont(new Font("Candara", Font.PLAIN, 17));
		txtpnDearMemberYou.setForeground(new Color(0, 0, 0));
		txtpnDearMemberYou.setBounds(106, 86, 598, 386);
		add(txtpnDearMemberYou);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(106, 381, 594, 2);
		add(separator);
		
		JLabel lblSummary = new JLabel("Booking Summary");
		lblSummary.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblSummary.setBounds(428, 0, 244, 39);
		add(lblSummary);
	}
}
