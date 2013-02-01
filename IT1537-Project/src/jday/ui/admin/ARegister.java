package jday.ui.admin;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import jday.util.BackgroundPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import jday.entities.Admin;
import jday.entities.BasicMember;
import jday.entities.KitchenAdmin;
import jday.entities.Member;
import jday.entities.PremiumMember;
import jday.entities.dao.MemberDAO;

import javax.swing.JScrollPane;
import java.awt.Rectangle;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ARegister extends BackgroundPanel {
	private JTextField tfname;
	private JTextField tfbirthdate;
	private JTextField tfnoh;
	private JTextField tfnoM;
	private JTextField tfmemberid;
	private JTextField tfemail;
	private JTextArea taaddress;
	private Member memberregister = null;
	private JPasswordField pwdPin;
	private JComboBox cbbmembertype;

	/**
	 * Create the panel.
	 */
	public ARegister() {
		super();
		initialize();
	}
	
	public ARegister(JFrame f,Member m){
		this();
		myFrame = f;
		this.m = m;
	}
	
	private void initialize(){
		setSize(new Dimension(750, 500));
		
		JLabel label = new JLabel("logo");
		label.setBounds(10, 11, 94, 102);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JPanel panel = new AMainpage(myFrame,m);
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
		btnCreate.setBounds(540, 425, 132, 23);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				int memberSelected = cbbmembertype.getSelectedIndex();
				
				if(memberSelected == 1)
				memberregister = new BasicMember();
				if(memberSelected == 2)
					memberregister = new PremiumMember();
				if(memberSelected ==3)
					memberregister= new Admin();
				if(memberSelected ==4)
					memberregister = new KitchenAdmin();
				String name = tfname.getText();
				String birthdate = tfbirthdate.getText();
				int contactnoM = Integer.parseInt(tfnoM.getText());
				int contactnoH = Integer.parseInt(tfnoh.getText());
				String memberid = tfmemberid.getText();
				String email = tfemail.getText();
				String address = taaddress.getText();
				String pin = pwdPin.getText();
				
				
				
				memberregister.setName(name);
				memberregister.setBirthdate(birthdate);
				memberregister.setContactnoM(contactnoM);
				memberregister.setContactnoH(contactnoH);
				memberregister.setMemberid(memberid);
				memberregister.setEmail(email);
				memberregister.setAddress(address);
				memberregister.setPin(pin);
				
				try {
					memberregister.createMember();
					memberregister.createMemberInfo();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "Member created");
				JPanel panel = new AMainpage(myFrame,m);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
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
		
		JLabel lbldetails = new JLabel("Please enter your details:");
		lbldetails.setBounds(44, 125, 246, 29);
		lbldetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lbldetails);
		
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
		
		JLabel lblPin = new JLabel("PIN:");
		lblPin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPin.setBounds(179, 381, 37, 23);
		add(lblPin);
		
		
		tfname = new JTextField();
		tfname.setBounds(226, 194, 140, 23);
		add(tfname);
		tfname.setColumns(10);
		
		tfbirthdate = new JTextField();
		tfbirthdate.setBounds(226, 237, 140, 23);
		tfbirthdate.setColumns(10);
		add(tfbirthdate);
		
		tfnoh = new JTextField("");
		tfnoh.setBounds(226, 285, 140, 23);
		tfnoh.setColumns(10);
		add(tfnoh);
		
		tfnoM = new JTextField("");
		tfnoM.setBounds(226, 336, 140, 23);
		tfnoM.setColumns(10);
		add(tfnoM);
		
		tfmemberid = new JTextField();
		tfmemberid.setBounds(531, 192, 141, 23);
		tfmemberid.setColumns(10);
		add(tfmemberid);
		
		tfemail = new JTextField();
		tfemail.setBounds(532, 237, 140, 23);
		tfemail.setColumns(10);
		add(tfemail);
		
		taaddress = new JTextArea();
		taaddress.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		taaddress.setBounds(531, 286, 141, 75);
		add(taaddress);

		pwdPin = new JPasswordField();
		pwdPin.setBounds(226, 384, 140, 23);
		add(pwdPin);
		
		cbbmembertype = new JComboBox();
		cbbmembertype.setModel(new DefaultComboBoxModel(new String[] {"Choose member type","Basic member", "Premium member", "Admin", "Kitchen admin"}));
		cbbmembertype.setBounds(226, 426, 167, 23);
		cbbmembertype.setMaximumRowCount(3);
		add(cbbmembertype);
		
		JLabel lblmembertype = new JLabel("Member type:");
		lblmembertype.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblmembertype.setBounds(113, 422, 140, 25);
		add(lblmembertype);

	}
}
