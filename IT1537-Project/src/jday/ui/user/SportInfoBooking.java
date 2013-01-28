package jday.ui.user;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import jday.entities.BookingNo;
import jday.entities.Member;
import jday.entities.SportBooking;
import jday.entities.dao.SportBookingDAO;
import jday.util.BackgroundPanel;
import jday.util.EmailSender;

import org.freixas.jcalendar.DateEvent;
import org.freixas.jcalendar.DateListener;
import org.freixas.jcalendar.JCalendar;
import java.awt.Cursor;


public class SportInfoBooking extends BackgroundPanel{
	private SportBooking sportbooking = new SportBooking();
	private JComboBox sport;
	private JComboBox time;
	private JComboBox court;
	
	public SportInfoBooking() {
		super();
		initialize();
	}
	
	public SportInfoBooking(JFrame f, Member m){
		this();
		myFrame = f;
		this.m = m;
		this.m.retrieveMemberInfo();
				
	}
	
	private void initialize(){
		setSize(new Dimension(750, 500));
		setLayout(null);
		
		JLabel lblDearMemberThe = new JLabel("Dear member, please choose your date");
		lblDearMemberThe.setBounds(66, 44, 486, 25);
		lblDearMemberThe.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		add(lblDearMemberThe);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BookingNo bookno = new BookingNo();
				bookno.setBookingNo();
				
				int timeSelected = time.getSelectedIndex();
				System.out.println("selected index = " + timeSelected);
				String selectedTime = (String) (time.getItemAt(timeSelected));
				System.out.println("Selected time = " + time);
				
				
				int courtSelected = court.getSelectedIndex();
				System.out.println("selected index = " + courtSelected);
				int selectedCourt = Integer.parseInt(court.getItemAt(courtSelected).toString());
				System.out.println("Selected court = " + court);
				
				
				int sportSelected = sport.getSelectedIndex();
				System.out.println("selected index = " + sportSelected);
				String selectedSport = (String) (sport.getItemAt(sportSelected));
				System.out.println("Selected sport = " + sport);
				
				
				sportbooking.setTime(selectedTime);
				sportbooking.setCourt(selectedCourt);
				sportbooking.setSport(selectedSport);
				sportbooking.setBookingno(bookno.getBookingNo());
				
				
				SportBooking sportbk = new SportBooking();
				sportbk=SportBookingDAO.sportbooking(sportbooking,m);
				
				EmailSender email = new EmailSender(bookno.getBookingNo(),m);
				JOptionPane.showMessageDialog(null, "Booking number is "+bookno.getBookingNo());
				

				JPanel panel = new SportInfo(myFrame, m);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		
		btnConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		/*button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				BookingNo bookno = new BookingNo();
				bookno.setBookingNo();
					sportbooking.setMemberid(m.getMemberid());
					
					sportbooking.setSport(comboBox_2.selectedTime);
					sportbooking.setTime();
					sportbooking.setTime();
					sportbooking.setBookingno(bookno.getBookingNo());
					
					SportBookingDAO.CreateSportBooking(sportbooking);
				
					EmailSender email = new EmailSender(bookno.getBookingNo(),m);
					JOptionPane.showMessageDialog(null, "Booking number is "+bookno.getBookingNo());
				
			}
		});
		*/
		btnConfirm.setBounds(609, 446, 87, 23);
		add(btnConfirm);
	
		JLabel label_2 = new JLabel("Booking time:");
		label_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		label_2.setBounds(66, 343, 129, 25);
		add(label_2);
		
		JLabel lblCourtNo = new JLabel("Court No.:");
		lblCourtNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCourtNo.setBounds(346, 377, 83, 25);
		add(lblCourtNo);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTime.setBounds(86, 418, 57, 23);
		add(lblTime);
		

		JLabel lblSports = new JLabel("Sports:");
		lblSports.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSports.setBounds(76, 376, 57, 25);
		add(lblSports);
		
		time = new JComboBox();
		time.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		time.setModel(new DefaultComboBoxModel(new String[] {"0900-1000", "1000-1100", "1100-1200", "1200-1300", "1300-1400", "1400-1500", "1500-1600", "1600-1700", "1700-1800", "1800-1900"}));
		time.setToolTipText("");
		time.setBounds(151, 418, 101, 20);
		add(time);
		
		
		court = new JComboBox();
		court.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		court.setToolTipText("");
		court.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		court.setBounds(441, 381, 70, 20);
		add(court);
	
		
		sport = new JComboBox();
		sport.setModel(new DefaultComboBoxModel(new String[] {"Basketball", "Tennis", "Bowling", "Badminton", "Volleyball", "Table Tennis"}));
		sport.setToolTipText("");
		sport.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sport.setMaximumRowCount(7);
		sport.setBounds(152, 380, 100, 20);
		add(sport);
		
		final JCalendar calendar = new JCalendar();
		calendar.setBorder(new LineBorder(new Color(0, 0, 0)));
		calendar.setBackground(new Color(221, 160, 221));
		//current date is selected if no data had been selected
		Date date = new Date();
		date = calendar.getDate();
		sportbooking.setDate(date.toString());

		calendar.addDateListener(new DateListener() {
			public void dateChanged(DateEvent arg0) {
				// save date into a variable
				Date date = new Date();
				date = calendar.getDate();
				sportbooking.setDate((date.toString()));
				System.out.println(date);

			}

		});

		calendar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		calendar.setBounds(66, 81, 630, 251);
		add(calendar);
		
	}

}
