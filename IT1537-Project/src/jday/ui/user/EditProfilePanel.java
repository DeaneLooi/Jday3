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

import jday.entities.Member;
import jday.ui.admin.AMainpage;
import jday.ui.admin.AdminMainframe;
import jday.ui.admin.Kitchen;
import jday.util.BackgroundPanel;

public class EditProfilePanel extends BackgroundPanel {
	
	private Member m = null;
	private JTextField tfName;
	private JTextField tfBirthdate;
	private JTextField tfContactNoH;
	private JTextField tfContactNoM;
	private JTextField tfEmail;
	private JTextField tfMemberID;
	private JTextField tfAddress;
	
	public EditProfilePanel(){
		super();
		initialize();
	}
	
	public EditProfilePanel(JFrame f, Member m){
		super();
		myFrame = f;
		this.m = m;
		this.m.retrieveMemberInfo();
		initialize();
	}
	
	private void initialize(){
		setSize(750,500);
		setLayout(null);
		
		JLabel lblCheckingOfParticulars = new JLabel("Checking of particulars");
		lblCheckingOfParticulars.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckingOfParticulars.setFont(new Font("Candara", Font.BOLD, 16));
		lblCheckingOfParticulars.setForeground(new Color(0, 0, 0));
		lblCheckingOfParticulars.setBounds(206, 11, 253, 45);
		add(lblCheckingOfParticulars);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Candara", Font.PLAIN, 16));
		lblName.setBounds(10, 70, 178, 36);
		add(lblName);
		
		JLabel lblBirthdate = new JLabel("Birthdate:");
		lblBirthdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirthdate.setFont(new Font("Candara", Font.PLAIN, 16));
		lblBirthdate.setBounds(10, 117, 178, 36);
		add(lblBirthdate);
		
		JLabel lblContactNoh = new JLabel("Contact No (H):");
		lblContactNoh.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactNoh.setFont(new Font("Candara", Font.PLAIN, 16));
		lblContactNoh.setBounds(10, 164, 178, 36);
		add(lblContactNoh);
		
		JLabel lblContactNom = new JLabel("Contact No (M):");
		lblContactNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactNom.setFont(new Font("Candara", Font.PLAIN, 16));
		lblContactNom.setBounds(10, 211, 178, 36);
		add(lblContactNom);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Candara", Font.PLAIN, 16));
		lblEmail.setBounds(10, 258, 178, 36);
		add(lblEmail);
		
		JLabel lblMemberId = new JLabel("Member ID:");
		lblMemberId.setHorizontalAlignment(SwingConstants.CENTER);
		lblMemberId.setFont(new Font("Candara", Font.PLAIN, 16));
		lblMemberId.setBounds(359, 67, 178, 36);
		add(lblMemberId);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Candara", Font.PLAIN, 16));
		lblAddress.setBounds(359, 128, 178, 36);
		add(lblAddress);
		
		tfName = new JTextField();
		tfName.setFont(new Font("Candara", Font.PLAIN, 16));
		tfName.setForeground(new Color(0, 0, 0));
		tfName.setBounds(162, 70, 198, 36);
		tfName.setColumns(10);
		tfName.setText(m.getName());
		add(tfName);


		
		tfBirthdate = new JTextField();
		tfBirthdate.setForeground(Color.BLACK);
		tfBirthdate.setFont(new Font("Candara", Font.PLAIN, 16));
		tfBirthdate.setColumns(10);
		tfBirthdate.setBounds(162, 117, 198, 36);
		tfBirthdate.setText(m.getBirthdate());
		add(tfBirthdate);
		
		tfContactNoH = new JTextField();
		tfContactNoH.setForeground(Color.BLACK);
		tfContactNoH.setFont(new Font("Candara", Font.PLAIN, 16));
		tfContactNoH.setColumns(10);
		tfContactNoH.setBounds(162, 164, 198, 36);
		tfContactNoH.setText(Integer.toString(m.getContactnoH()));
		add(tfContactNoH);
		
		tfContactNoM = new JTextField();
		tfContactNoM.setForeground(Color.BLACK);
		tfContactNoM.setFont(new Font("Candara", Font.PLAIN, 16));
		tfContactNoM.setColumns(10);
		tfContactNoM.setBounds(162, 211, 198, 36);
		tfContactNoM.setText(Integer.toString(m.getContactnoM()));
		add(tfContactNoM);
		
		tfEmail = new JTextField();
		tfEmail.setForeground(Color.BLACK);
		tfEmail.setFont(new Font("Candara", Font.PLAIN, 16));
		tfEmail.setColumns(10);
		tfEmail.setBounds(162, 258, 198, 36);
		tfEmail.setText(m.getEmail());
		add(tfEmail);
		
		tfMemberID = new JTextField();
		tfMemberID.setEditable(false);
		tfMemberID.setForeground(Color.BLACK);
		tfMemberID.setFont(new Font("Candara", Font.PLAIN, 16));
		tfMemberID.setColumns(10);
		tfMemberID.setBounds(502, 70, 198, 36);
		tfMemberID.setText(m.getMemberid());
		add(tfMemberID);
		
		tfAddress = new JTextField();
		tfAddress.setForeground(Color.BLACK);
		tfAddress.setFont(new Font("Candara", Font.PLAIN, 16));
		tfAddress.setColumns(10);
		tfAddress.setBounds(502, 125, 198, 56);
		tfAddress.setText(m.getAddress());
		add(tfAddress);
		
		
		JButton btnEdit = new JButton("edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.setName(tfName.getText());
				m.setBirthdate(tfBirthdate.getText());
				m.setContactnoH(Integer.parseInt(tfContactNoH.getText()));
				m.setContactnoM(Integer.parseInt(tfContactNoM.getText()));
				m.setEmail(tfEmail.getText());
				m.setAddress(tfAddress.getText());
				try {
					boolean b = m.updateMemberInfo();
					if(b = false)
						JOptionPane.showMessageDialog(null, "Profile has not been changed");
					if(b = true)
						JOptionPane.showMessageDialog(null, "Profile has been changed");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEdit.setOpaque(false);
		btnEdit.setFont(new Font("Candara", Font.PLAIN, 16));
		btnEdit.setForeground(new Color(0, 0, 0));
		btnEdit.setBounds(448, 265, 89, 23);
		add(btnEdit);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(myFrame instanceof LoginFrame){
				myFrame.setVisible(false);
				JFrame myFrame = new MainFrame(m);
				myFrame.setVisible(true);
				}
				
				else if(myFrame instanceof MainFrame){
					JPanel panel = new EventCalendar(myFrame,m);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
				
				else if(myFrame instanceof AdminMainframe){
					if(m.getMemberid().contains("au")){
						JPanel panel = new AMainpage(myFrame,m);
						myFrame.getContentPane().removeAll();
						myFrame.getContentPane().add(panel);
						myFrame.getContentPane().validate();
						myFrame.getContentPane().repaint();
					}
					
					else if(m.getMemberid().contains("ar")){
						JPanel panel = new Kitchen(myFrame);
						myFrame.getContentPane().removeAll();
						myFrame.setContentPane(panel);
						myFrame.setVisible(false);
						myFrame.getContentPane().validate();
						myFrame.getContentPane().repaint();
						myFrame.setVisible(true);
					
					}
				}
			}
		});
		btnConfirm.setOpaque(false);
		btnConfirm.setForeground(Color.BLACK);
		btnConfirm.setFont(new Font("Candara", Font.PLAIN, 16));
		btnConfirm.setBounds(547, 265, 89, 23);
		add(btnConfirm);
		
		
	}

}
