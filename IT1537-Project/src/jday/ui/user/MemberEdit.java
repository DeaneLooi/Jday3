package jday.ui.user;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import jday.entities.Member;
import jday.util.BackgroundPanel;

public class MemberEdit extends BackgroundPanel {
	private JTextField txtname;
	private JTextField txtbirthDate;
	private JTextField txtcontactNumberhp;
	private JTextField txtcontactPhoneh;
	private JTextField txtemail;
	private JTextField txtmembersId;
	private JTextField txtgivenPin;
	private JTextField txtnewPin;
	private JTextField txtaddress;

	/**
	 * Create the panel.
	 */
	public MemberEdit() {
		super();
		initialize();
	}
	
	public MemberEdit(JFrame f,Member m){
		this();
		myFrame = f;
		this.m = m;
	}
	
	private void initialize(){
		setSize(750,500);
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setOpaque(false);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Edit/Update Particulars", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(47, 38, 678, 405);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblBirthdate = new JLabel("Birth Date :");
		lblBirthdate.setBounds(51, 140, 60, 14);
		panel.add(lblBirthdate);
		lblBirthdate.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblContactNoh = new JLabel("Contact No (H) :");
		lblContactNoh.setBounds(32, 259, 79, 14);
		panel.add(lblContactNoh);
		
		JLabel lblContactNohp = new JLabel("Contact No (HP) :");
		lblContactNohp.setBounds(25, 202, 86, 14);
		panel.add(lblContactNohp);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(64, 85, 47, 14);
		panel.add(lblName);
		lblName.setHorizontalAlignment(SwingConstants.TRAILING);
		
		txtname = new JTextField();
		txtname.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtname.setBounds(137, 78, 146, 28);
		panel.add(txtname);
		txtname.setText("[Name]");
		txtname.setColumns(10);
		
		txtbirthDate = new JTextField();
		txtbirthDate.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtbirthDate.setBounds(137, 133, 128, 28);
		panel.add(txtbirthDate);
		txtbirthDate.setText("[Birth Date]");
		txtbirthDate.setColumns(10);
		
		txtcontactNumberhp = new JTextField();
		txtcontactNumberhp.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtcontactNumberhp.setBounds(137, 195, 128, 28);
		panel.add(txtcontactNumberhp);
		txtcontactNumberhp.setText("[Contact Number (hp)]");
		txtcontactNumberhp.setColumns(10);
		
		txtcontactPhoneh = new JTextField();
		txtcontactPhoneh.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtcontactPhoneh.setBounds(137, 252, 128, 28);
		panel.add(txtcontactPhoneh);
		txtcontactPhoneh.setText("[Contact phone (h)]");
		txtcontactPhoneh.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtemail.setBounds(137, 323, 146, 32);
		panel.add(txtemail);
		txtemail.setText("[Email]");
		txtemail.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail :");
		lblEmail.setBounds(76, 323, 35, 14);
		panel.add(lblEmail);
		
		JLabel lblNewPin = new JLabel("New PIN :");
		lblNewPin.setBounds(340, 195, 79, 14);
		panel.add(lblNewPin);
		
		JLabel lblAddress = new JLabel("Address  :");
		lblAddress.setBounds(340, 259, 79, 14);
		panel.add(lblAddress);
		
		JLabel lblMembersId = new JLabel("Member ID :");
		lblMembersId.setBounds(327, 85, 60, 14);
		panel.add(lblMembersId);
		
		JLabel lblGivenPin = new JLabel("Current PIN  :");
		lblGivenPin.setBounds(320, 140, 67, 14);
		panel.add(lblGivenPin);
		
		txtmembersId = new JTextField();
		txtmembersId.setBounds(416, 79, 128, 26);
		panel.add(txtmembersId);
		txtmembersId.setText("[Member's ID]");
		txtmembersId.setColumns(10);
		
		txtgivenPin = new JTextField();
		txtgivenPin.setBounds(416, 134, 139, 27);
		panel.add(txtgivenPin);
		txtgivenPin.setText("[Given PIN]");
		txtgivenPin.setColumns(10);
		
		txtnewPin = new JTextField();
		txtnewPin.setBounds(415, 196, 140, 26);
		panel.add(txtnewPin);
		txtnewPin.setText("[New PIN]");
		txtnewPin.setColumns(10);
		
		txtaddress = new JTextField();
		txtaddress.setBounds(415, 252, 226, 116);
		panel.add(txtaddress);
		txtaddress.setText("[Address]");
		txtaddress.setColumns(10);
		
		JButton button = new JButton("Confirm");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new EventCalendar(myFrame,m);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setBounds(625, 454, 86, 32);
		add(button);
		button.setOpaque(false);

	}
}
