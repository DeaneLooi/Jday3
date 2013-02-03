package jday.ui.user;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import jday.entities.KaraokeBookingEntities;
import jday.entities.Member;
import jday.entities.dao.KaraokeBookingEntitiesDao;
import jday.util.BackgroundPanel;
import jday.util.EmailSender;

import javax.swing.ButtonGroup;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class KaraokeBooking extends BackgroundPanel implements ActionListener {
	private JRadioButton rdbtnpm;
	private JRadioButton rdbtnEveningPm;
	private JRadioButton rdbtnNoonPm;

	private final ButtonGroup buttonGroup = new ButtonGroup();
	private KaraokeBookingEntities karaokeBookingEntities;
	// private final Action action = new SwingAction();

	private JSpinner day;
	private JComboBox month;
	private JSpinner year;

	private JComboBox rooms;
	
	private String time; 

	public KaraokeBooking() {
		super();
		setOpaque(false);
		initialize();
	}

	public KaraokeBooking(JFrame f, Member m) {
		this();
		myFrame = f;
		this.m = m;
		this.m.retrieveMemberInfo();
	}

	private void initialize() {
		setSize(new Dimension(750, 500));
		setLayout(null);

		/*************************** Select Time ****************************/

		rdbtnpm = new JRadioButton("JDAY Lunch (11 am - 2 pm)");
		rdbtnpm.setActionCommand("JDAY Lunch (11 am - 2 pm)");
		buttonGroup.add(rdbtnpm);
		rdbtnpm.setOpaque(false);
		rdbtnpm.setBounds(517, 286, 205, 23);
		add(rdbtnpm);

		rdbtnNoonPm = new JRadioButton("JDAY Happy (2 pm - 7 pm)");
		rdbtnNoonPm.setActionCommand("JDAY Happy (2 pm - 7 pm)");
		buttonGroup.add(rdbtnNoonPm);
		rdbtnNoonPm.setOpaque(false);
		rdbtnNoonPm.setBounds(517, 318, 205, 23);
		add(rdbtnNoonPm);

		rdbtnEveningPm = new JRadioButton("JDAY Dinner (6 pm - 10 pm)");
		rdbtnEveningPm.setActionCommand("JDAY Dinner (6 pm - 10 pm)");
		buttonGroup.add(rdbtnEveningPm);
		rdbtnEveningPm.setOpaque(false);
		rdbtnEveningPm.setBounds(517, 353, 205, 23);
		add(rdbtnEveningPm);

		/*************************** Terms & Condition ****************************/

		/*************************** Labels ****************************/
		JLabel lblSession = new JLabel("ROOM TYPE :");
		lblSession.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblSession.setBounds(390, 171, 105, 14);
		add(lblSession);

		JLabel lblDate = new JLabel("DATE :");
		lblDate.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblDate.setBounds(434, 229, 49, 23);
		add(lblDate);

		JLabel lblTime = new JLabel("TIME :");
		lblTime.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblTime.setBounds(437, 284, 46, 23);
		add(lblTime);

		/*************************** Select Day ****************************/
		day = new JSpinner();
		day.setOpaque(false);
		day.setFocusable(false);
		day.setModel(new SpinnerNumberModel(1, 1, 30, 1));
		day.setBounds(517, 231, 46, 22);
		add(day);

		/*************************** Select Month ****************************/
		month = new JComboBox();
		month.setOpaque(false);
		month.setFont(new Font("Candara", Font.PLAIN, 14));
		month.setModel(new DefaultComboBoxModel(new String[] { "  Jan","  Feb", "  Mar", "  Apr", "  May", "  Jun", "  Jul", "  Aug","  Sep", "  Oct", "  Nov", "  Dec" }));
		month.setToolTipText("");
		month.setBounds(573, 229, 56, 25);
		add(month);

		/*************************** Select Year ****************************/
		year = new JSpinner();
		year.setOpaque(false);
		year.setFocusable(false);
		year.setModel(new SpinnerListModel(new String[] { "2012", "2013","2014", "2015" }));
		year.setBounds(634, 231, 56, 22);
		add(year);

		/*************************** Select Session ****************************/
		rooms = new JComboBox();
		rooms.setOpaque(false);
		rooms.setModel(new DefaultComboBoxModel(new String[] {"   JDay's Karaoke", "   Corporate Room", "   Family Room", "   Friend Room" }));
		rooms.setFont(new Font("Candara", Font.PLAIN, 14));
		rooms.setToolTipText("");
		rooms.setBounds(517, 167, 173, 25);
		add(rooms);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setOpaque(false);
		btnConfirm.addActionListener(this);
		btnConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirm.setBounds(587, 404, 89, 23);
		add(btnConfirm);
		
		JLabel lblKaraokeBooking = new JLabel("Karaoke Booking");
		lblKaraokeBooking.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblKaraokeBooking.setBounds(456, 0, 205, 44);
		add(lblKaraokeBooking);
		
				JLabel lblTermsCondition = new JLabel("Terms & Condition :");
				lblTermsCondition.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
				lblTermsCondition.setBounds(82, 59, 163, 14);
				add(lblTermsCondition);
				JTextPane txtpnAvailableForGroup = new JTextPane();
				txtpnAvailableForGroup.setFont(new Font("Candara", Font.PLAIN, 15));
				txtpnAvailableForGroup.setEditable(false);
				txtpnAvailableForGroup.setBackground(SystemColor.menu);
				txtpnAvailableForGroup.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
				txtpnAvailableForGroup.setText("All charges are subject to 10% service charge and 7% GST*.\r\n\r\nRooms are subject to availability.\r\n\r\nPlease adhere to the timing generated from the booking system to avoid any inconvenience.\r\n\r\nA grace period of 15 minutes is given from the timing of your booked session.\r\n\r\nAll bookings made cannot be cancelled.\r\n\r\nAll payments made are non refundable.\r\n\r\nAll transactions are in Singapore Dollars (SGD).\r\n\r\nBooking number is sent to your email, present them upon arrival. ");
				txtpnAvailableForGroup.setBounds(82, 84, 275, 405);
				add(txtpnAvailableForGroup);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int selectedDay = (int) day.getValue();

		int selected = month.getSelectedIndex();
		System.out.println("selected index = " + selected);
		String selectedMonth = (String) (month.getItemAt(selected));
		System.out.println("Selected month = " + month);

		String selectedYear = (String) year.getValue();

		String selectedT = buttonGroup.getSelection().getActionCommand();
		System.out.println("Selected time = " + time);

		int selectedR = rooms.getSelectedIndex();
		System.out.println("selected index = " + selectedR);
		String selectedRoom = (String) (rooms.getItemAt(selectedR));
		System.out.println("Selected room = " + rooms);

		KaraokeBookingEntities bookingDetails = new KaraokeBookingEntities();
		bookingDetails.setDay(selectedDay);
		bookingDetails.setMonth(selectedMonth);
		bookingDetails.setYear(selectedYear);
		bookingDetails.setDate();
		
		bookingDetails.setTime(selectedT);

		bookingDetails.setSession(selectedRoom);

		KaraokeBookingEntities bookDetails = new KaraokeBookingEntities();
		bookDetails = KaraokeBookingEntitiesDao.karaokeBooking(bookingDetails, m);

		EmailSender email = new EmailSender(m);
		email.sendBookingNumber(bookDetails.getBookingNo());
		
		KaraokeConfirmation panel = new KaraokeConfirmation(myFrame, bookDetails, m);

		/*String dateDetails = karaokeBookingEntities.getDay() + "." + karaokeBookingEntities.getMonth() + ". " + karaokeBookingEntities.getYear();
		String roomsDetails = karaokeBookingEntities.getSession();
		String timeDetails = karaokeBookingEntities.getTime();*/
		
		JOptionPane.showMessageDialog(null, "Booking is successful! Your booking number "+ bookDetails.getBookingNo());
		
		/*
		 * myFrame.getContentPane().removeAll();
		 * myFrame.getContentPane().add(panel);
		 * myFrame.getContentPane().validate();
		 * myFrame.getContentPane().repaint();
		 */
	}
	
}
