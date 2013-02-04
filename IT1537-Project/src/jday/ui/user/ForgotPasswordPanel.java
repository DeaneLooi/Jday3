package jday.ui.user;

import javax.swing.JFrame;

import jday.entities.Member;
import jday.util.BackgroundPanel;
import jday.util.EmailSender;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ForgotPasswordPanel extends BackgroundPanel{
	private JTextField tfMemberId;
	private JTextField tfEmailAddress;
	private JLabel lblErrorMessage;
	
	public ForgotPasswordPanel(){
		super();
		initialize();
	}
	
	public ForgotPasswordPanel(JFrame f){
		this();
		myFrame = f;
	}
	
	private void initialize(){
		setLayout(null);
		setSize(750,500);
		
		JLabel lblForgotYourPassword = new JLabel("Forgot your password?");
		lblForgotYourPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblForgotYourPassword.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblForgotYourPassword.setBounds(340, -11, 417, 61);
		add(lblForgotYourPassword);
		
		JLabel lblMemberId = new JLabel("Member Id:");
		lblMemberId.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMemberId.setFont(new Font("Candara", Font.PLAIN, 16));
		lblMemberId.setBounds(-18, 188, 202, 47);
		add(lblMemberId);
		
		JLabel lblEmailAddress = new JLabel("Email Address:");
		lblEmailAddress.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmailAddress.setFont(new Font("Candara", Font.PLAIN, 16));
		lblEmailAddress.setBounds(-18, 238, 202, 47);
		add(lblEmailAddress);
		
		tfMemberId = new JTextField();
		tfMemberId.setBounds(194, 195, 235, 32);
		add(tfMemberId);
		tfMemberId.setColumns(10);
		
		tfEmailAddress = new JTextField();
		tfEmailAddress.setColumns(10);
		tfEmailAddress.setBounds(194, 245, 235, 32);
		add(tfEmailAddress);
		
		lblErrorMessage = new JLabel("");
		lblErrorMessage.setForeground(Color.RED);
		lblErrorMessage.setFont(new Font("Candara", Font.PLAIN, 16));
		lblErrorMessage.setBounds(439, 195, 286, 104);
		add(lblErrorMessage);
		
		
		JButton btnReset = new JButton("Reset");
		btnReset.setOpaque(false);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String memberid = tfMemberId.getText();
				String email = tfEmailAddress.getText();
				
				Member m = new Member(memberid);
				m.retrieveMemberInfo();
				if(m.getEmail() == null){
					lblErrorMessage.setText("*Member Id entered is not registered");
				}
				
				else if(memberid.equalsIgnoreCase(m.getMemberid()) && email.equals(m.getEmail())){
					lblErrorMessage.setText("");
					Random randomNumber = new Random();
					String pin = Integer.toString((int)randomNumber.nextInt(999999));
					try {
						m.changePin(pin);
						EmailSender emailSender = new EmailSender(m);
						emailSender.sendPin(pin);
						JOptionPane.showMessageDialog(null, "An email has been sent with your new password. ");
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Reset password failed");
						e.printStackTrace();
					}
					
					JPanel panel = new LoginPage(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
				
				else if(memberid.equalsIgnoreCase(m.getMemberid()) && email!=m.getEmail() ){
					lblErrorMessage.setText("<html><p>*Email does not correspond to </p><p> email of the member entered</p></html>");
				}
				

			}
		});
		btnReset.setFont(new Font("Candara", Font.PLAIN, 16));
		btnReset.setBounds(340, 304, 89, 23);
		add(btnReset);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JPanel panel = new LoginPage(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		lblLogo.setIcon(new ImageIcon(ForgotPasswordPanel.class.getResource("/images/90logo.png")));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(24, 27, 168, 122);
		add(lblLogo);
		

		
	}
}
