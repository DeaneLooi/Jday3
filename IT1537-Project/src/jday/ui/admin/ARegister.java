//yw's register
package jday.ui.admin;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import jday.util.BackgroundPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import jday.entities.Member;
import jday.entities.dao.MemberDAO;

import javax.swing.JScrollPane;
import java.awt.Rectangle;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;

public class ARegister extends BackgroundPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextArea textArea;
	private Member memberregister = new Member();

	/**
	 * Create the panel.
	 */
	public ARegister() {
		super();
		setToolTipText("");
		initialize();
	}
	
	public ARegister(JFrame f){
		this();
		myFrame = f;
	}
	
	private void initialize(){
		setSize(new Dimension(750, 500));
		
		JLabel label = new JLabel("logo");
		label.setBounds(10, 11, 94, 102);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JPanel panel = new AMainpage(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
				
			}
		});
		setLayout(null);
		label.setIcon(new ImageIcon(ARegister.class.getResource("/images/90logo.png")));
		add(label);
		
		JButton btnCreate = new JButton("Create member");
		btnCreate.setBounds(565, 425, 107, 23);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField.getText();
				String birthdate = textField_1.getText();
				int contactnoM = Integer.parseInt(textField_2.getText());
				int contactnoH = Integer.parseInt(textField_2.getText());
				String memberid = textField_4.getText();
				String email = textField_5.getText();
				String address = textArea.getText();
				
				memberregister.setName(name);
				memberregister.setBirthdate(birthdate);
				memberregister.setContactnoM(contactnoM);
				memberregister.setContactnoH(contactnoH);
				memberregister.setMemberid(memberid);
				memberregister.setEmail(email);
				memberregister.setAddress(address);
				
				MemberDAO.register(memberregister);
				
				/*
				//Member member =new Member(name, birthdate, contactnoM, contactnoH, memberid, email, address);
				try {
					member.register(Member);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
			}
		});
		add(btnCreate);
		
		JLabel lblJdayRegister = new JLabel("JDAY Register");
		lblJdayRegister.setBounds(124, 46, 222, 43);
		lblJdayRegister.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		add(lblJdayRegister);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(162, 192, 54, 23);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblName);
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter your details:");
		lblPleaseEnterThe.setBounds(44, 125, 246, 29);
		lblPleaseEnterThe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblPleaseEnterThe);
		
		JLabel lblMemberId = new JLabel("Member ID:");
		lblMemberId.setBounds(418, 192, 89, 24);
		lblMemberId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblMemberId);
		
		JLabel lblContactNumberh = new JLabel("Contact number (H):");
		lblContactNumberh.setBounds(64, 336, 158, 23);
		lblContactNumberh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblContactNumberh);
		
		JLabel lblContactNumberm = new JLabel("Contact number (M):");
		lblContactNumberm.setBounds(64, 282, 158, 29);
		lblContactNumberm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblContactNumberm);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(454, 237, 54, 22);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblEmail);
		
		JLabel lblBirthDate = new JLabel("Birth date:");
		lblBirthDate.setBounds(138, 237, 81, 23);
		lblBirthDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblBirthDate);
		
		JLabel lblAddress = new JLabel("Address: ");
		lblAddress.setBounds(439, 284, 68, 24);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblAddress);
		
		textField = new JTextField();
		textField.setBounds(226, 194, 140, 23);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(226, 237, 140, 23);
		textField_1.setColumns(10);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(226, 285, 140, 23);
		textField_2.setColumns(10);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(226, 336, 140, 23);
		textField_3.setColumns(10);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(531, 192, 141, 23);
		textField_4.setColumns(10);
		add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setBounds(532, 237, 140, 23);
		textField_5.setColumns(10);
		add(textField_5);
		
		textArea = new JTextArea();
		textArea.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		textArea.setBounds(531, 286, 141, 75);
		add(textArea);

	}
}
