package jday.ui.user;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import jday.entities.CourseBooking;
import jday.entities.Member;
import jday.entities.Register;
import jday.util.BackgroundPanel;
import jday.util.EmailSender;

public class CoursesRegister extends BackgroundPanel{


	private JTextField Name;
	private JTextField Birthdate;
	private JTextField ContactNoH;
	private JTextField ContactNoM;
	private JTextField Email;
	private JTextField MemberID;
	private JTextField Address;
	private CourseBooking c = null;
	private Member m = null;
	
	
	public CoursesRegister() {
		super();
		initialize();
	}
	
	public CoursesRegister(JFrame f){
		this();
		myFrame = f;
	}
	
	public CoursesRegister(JFrame f, Member m, CourseBooking c){
		super();
		this.c = c;
		this.m = m;
		m.retrieveMemberInfo();
		myFrame = f;
		initialize();
		
	}
	private void initialize(){
		setSize(750,500);
		setLayout(null);
		
		JLabel lblCheck = new JLabel("Please check your particulars:");
		lblCheck.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheck.setBackground(Color.BLACK);
		lblCheck.setFont(new Font("Candara", Font.BOLD, 17));
		lblCheck.setForeground(new Color(0, 0, 0));
		lblCheck.setBounds(94, 85, 600, 36);
		add(lblCheck);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(new Color(0, 0, 0));
		lblName.setBackground(Color.BLACK);
		lblName.setFont(new Font("Candara", Font.BOLD, 16));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(106, 132, 232, 22);
		add(lblName);
		
		JLabel lblBirthdate = new JLabel("Birthdate:");
		lblBirthdate.setForeground(new Color(0, 0, 0));
		lblBirthdate.setFont(new Font("Candara", Font.BOLD, 16));
		lblBirthdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirthdate.setBounds(106, 165, 232, 22);
		add(lblBirthdate);
		
		JLabel lblContactNoh = new JLabel("Contact No (H):");
		lblContactNoh.setForeground(new Color(0, 0, 0));
		lblContactNoh.setFont(new Font("Candara", Font.BOLD, 16));
		lblContactNoh.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactNoh.setBounds(106, 198, 232, 22);
		add(lblContactNoh);
		
		JLabel lblContactNom = new JLabel("Contact No (M):");
		lblContactNom.setForeground(new Color(0, 0, 0));
		lblContactNom.setFont(new Font("Candara", Font.BOLD, 16));
		lblContactNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactNom.setBounds(106, 231, 232, 22);
		add(lblContactNom);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(0, 0, 0));
		lblEmail.setFont(new Font("Candara", Font.BOLD, 16));
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(106, 264, 232, 22);
		add(lblEmail);
		
		JLabel lblMemberId = new JLabel("Member ID");
		lblMemberId.setForeground(new Color(0, 0, 0));
		lblMemberId.setFont(new Font("Candara", Font.BOLD, 16));
		lblMemberId.setHorizontalAlignment(SwingConstants.CENTER);
		lblMemberId.setBounds(106, 297, 232, 22);
		add(lblMemberId);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setForeground(new Color(0, 0, 0));
		lblAddress.setFont(new Font("Candara", Font.BOLD, 16));
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setBounds(106, 330, 232, 22);
		add(lblAddress);
		
		Name = new JTextField(m.getName());
		Name.setFont(new Font("Candara", Font.PLAIN, 16));
		Name.setForeground(new Color(0, 0, 0));
		Name.setBounds(348, 132, 296, 20);
		add(Name);
		Name.setColumns(10);
		
		Birthdate = new JTextField(m.getBirthdate());
		Birthdate.setForeground(new Color(0, 0, 0));
		Birthdate.setFont(new Font("Candara", Font.PLAIN, 16));
		Birthdate.setColumns(10);
		Birthdate.setBounds(348, 168, 296, 20);
		add(Birthdate);
		
		ContactNoH = new JTextField(Integer.toString(m.getContactnoH()));
		ContactNoH.setForeground(new Color(0, 0, 0));
		ContactNoH.setFont(new Font("Candara", Font.PLAIN, 16));
		ContactNoH.setColumns(10);
		ContactNoH.setBounds(348, 201, 296, 20);
		add(ContactNoH);
		
		ContactNoM = new JTextField(Integer.toString(m.getContactnoM()));
		ContactNoM.setFont(new Font("Candara", Font.PLAIN, 16));
		ContactNoM.setForeground(new Color(0, 0, 0));
		ContactNoM.setColumns(10);
		ContactNoM.setBounds(348, 234, 296, 20);
		add(ContactNoM);
		
		Email = new JTextField(m.getEmail());
		Email.setForeground(new Color(0, 0, 0));
		Email.setFont(new Font("Candara", Font.PLAIN, 16));
		Email.setColumns(10);
		Email.setBounds(348, 267, 296, 20);
		add(Email);
		
		MemberID = new JTextField(m.getMemberid());
		MemberID.setEditable(false);
		MemberID.setFont(new Font("Candara", Font.PLAIN, 16));
		MemberID.setForeground(new Color(0, 0, 0));
		MemberID.setColumns(10);
		MemberID.setBounds(348, 300, 296, 20);
		add(MemberID);
		
		Address = new JTextField(m.getAddress());
		Address.setForeground(new Color(0, 0, 0));
		Address.setFont(new Font("Candara", Font.PLAIN, 16));
		Address.setColumns(10);
		Address.setBounds(348, 330, 296, 36);
		add(Address);
		
		JButton btnEdit = new JButton("edit");
		btnEdit.setOpaque(false);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.setName(Name.getText());
				m.setBirthdate(Birthdate.getText());
				m.setContactnoH(Integer.parseInt(ContactNoH.getText()));
				m.setContactnoM(Integer.parseInt(ContactNoM.getText()));
				m.setEmail(Email.getText());
				m.setAddress(Address.getText());

				try {
					m.updateMemberInfo();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEdit.setFont(new Font("Candara", Font.PLAIN, 16));
		btnEdit.setForeground(new Color(0, 0, 0));
		btnEdit.setBounds(348, 377, 89, 23);
		add(btnEdit);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setOpaque(false);
		btnConfirm.setFont(new Font("Candara", Font.PLAIN, 16));
		btnConfirm.setForeground(new Color(0, 0, 0));
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Register r = new Register(m);
				r.setEventclass(c.getCoursetype());
				try {
					r.register(r);
					EmailSender email = new EmailSender(m);
					email.sendRegisterNumber(r.getRegisterno());
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Register failed");
					e2.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Register successfull. An email has been sent containing your register number.");
				/*
				JPanel panel = new CoursesConfirmation(myFrame,m,c,r);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
				*/
			}
		});
		btnConfirm.setBounds(465, 377, 89, 23);
		add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setOpaque(false);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel panel = new Courses(myFrame,m);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		btnCancel.setForeground(new Color(0, 0, 0));
		btnCancel.setFont(new Font("Candara", Font.PLAIN, 16));
		btnCancel.setBounds(579, 377, 89, 23);
		add(btnCancel);
		
		JLabel lblCourseRegister = new JLabel("Course Register");
		lblCourseRegister.setForeground(new Color(0, 0, 0));
		lblCourseRegister.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCourseRegister.setBounds(434, 0, 287, 47);
		add(lblCourseRegister);
	}
}
