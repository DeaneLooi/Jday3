package jday.ui.user;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import jday.entities.BookingNo;
import jday.entities.GolfingBooking;
import jday.entities.Member;
import jday.entities.dao.BookingNoDAO;
import jday.entities.dao.GolfingBookingDAO;
import jday.util.BackgroundPanel;

import org.freixas.jcalendar.DateEvent;
import org.freixas.jcalendar.DateListener;
import org.freixas.jcalendar.JCalendar;
import javax.swing.ButtonGroup;

public class GolfingInfoBooking extends BackgroundPanel {
	private final ButtonGroup buttonGroupTime = new ButtonGroup();
	private final ButtonGroup buttonGroupGreenfee = new ButtonGroup();
	private GolfingBooking golfingbooking = new GolfingBooking();

	public GolfingInfoBooking() {
		super();
		initialize();
	}

	public GolfingInfoBooking(JFrame f, Member m) {
		this();
		myFrame = f;
		this.m = m;
	}

	/**
	 * Create the panel.
	 */
	public void initialize() {
		setSize(new Dimension(750, 500));
		setLayout(null);

		JButton btnBack = new JButton("Confirm");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String choice = buttonGroupTime.getSelection()
						.getActionCommand();
				System.out.println("test: " + choice);

				String choice2 = buttonGroupGreenfee.getSelection()
						.getActionCommand();
				System.out.println("test: " + choice2);

				/*BookingNo bookno = new BookingNo();
				bookno.setBookingno();
				
				BookingNoDAO.saveBookingNo(bookingno); 
				GolfingInfoBooking golfbooking = new GolfingInfoBooking();
				golfbooking.setBookingno();

				golfingbooking.setMemberid("1212312");
				golfingbooking.setGreenFees(choice2);
				golfingbooking.setTime(choice);
				golfingbooking.setBookingno(bookno.getBookingno());
*/
				// store in DAO
				GolfingBookingDAO.CreateBooking(golfingbooking);

				JPanel panel = new GolfingInfo(myFrame, m);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();

			}
		});
		btnBack.setBounds(598, 466, 89, 23);
		add(btnBack);

		JLabel lblPleaseChooseYour = new JLabel("Please  choose your date");
		lblPleaseChooseYour.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblPleaseChooseYour.setBounds(89, 25, 246, 23);
		add(lblPleaseChooseYour);

		JLabel label = new JLabel("Please choose the time and Green fees");
		label.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		label.setBounds(89, 321, 329, 23);
		add(label);

		JLabel label_1 = new JLabel("Time:");
		label_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		label_1.setBounds(92, 366, 57, 23);
		add(label_1);

		// time
		JRadioButton radioButton = new JRadioButton("Morning");
		radioButton.setActionCommand("morning");
		buttonGroupTime.add(radioButton);
		radioButton.setOpaque(false);
		radioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radioButton.setBounds(143, 398, 109, 23);
		add(radioButton);

		JRadioButton radioButton_1 = new JRadioButton("Afternoon");
		radioButton_1.setActionCommand("afternoon");
		buttonGroupTime.add(radioButton_1);
		radioButton_1.setOpaque(false);
		radioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radioButton_1.setBounds(143, 426, 109, 23);
		add(radioButton_1);

		JRadioButton radioButton_2 = new JRadioButton("Evening");
		radioButton_2.setActionCommand("evening");
		buttonGroupTime.add(radioButton_2);
		radioButton_2.setOpaque(false);
		radioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radioButton_2.setBounds(143, 454, 109, 23);
		add(radioButton_2);

		// green fees
		JLabel label_2 = new JLabel("Green Fees:");
		label_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		label_2.setBounds(380, 362, 102, 31);
		add(label_2);

		JRadioButton radioButton_3 = new JRadioButton("9 Holes");
		radioButton_3.setActionCommand("9 holes");
		buttonGroupGreenfee.add(radioButton_3);
		radioButton_3.setOpaque(false);
		radioButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radioButton_3.setBounds(466, 398, 102, 23);
		add(radioButton_3);

		JRadioButton radioButton_4 = new JRadioButton("18 Holes");
		radioButton_4.setActionCommand("18 holes");
		buttonGroupGreenfee.add(radioButton_4);
		radioButton_4.setOpaque(false);
		radioButton_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radioButton_4.setBounds(466, 426, 102, 23);
		add(radioButton_4);

		final JCalendar calendar = new JCalendar();
		calendar.setBorder(new LineBorder(new Color(0, 0, 0)));
		calendar.setBackground(new Color(221, 160, 221));

		Date date = new Date();
		date = calendar.getDate();
		golfingbooking.setDate(date.toString());

		calendar.addDateListener(new DateListener() {
			public void dateChanged(DateEvent arg0) {
				// save date into a variable
				Date date = new Date();
				date = calendar.getDate();
				golfingbooking.setDate((date.toString()));
				System.out.println(date);

			}

		});

		calendar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		calendar.setBounds(57, 59, 630, 251);
		add(calendar);

	}
}
