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
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import jday.entities.Member;
import jday.util.BackgroundPanel;

public class ChangePinPanel extends BackgroundPanel {
	
	private Member m = null;
	private JPasswordField pfCurrent;
	private JPasswordField pfNew;
	private JPasswordField pfConfirm;
	
	public ChangePinPanel(){
		super();
		initialize();
	}
	
	public ChangePinPanel(JFrame f, Member m){
		this();
		myFrame = f;
		this.m = m;
		this.m.retrieveMemberInfo();
	}

	private void initialize(){
		setSize(750,500);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dear member, please change your pin");
		lblNewLabel.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(161, 11, 343, 77);
		add(lblNewLabel);
		
		JLabel lblNewPin = new JLabel("New Pin:");
		lblNewPin.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewPin.setFont(new Font("Candara", Font.PLAIN, 16));
		lblNewPin.setBounds(121, 128, 157, 41);
		add(lblNewPin);
		
		JLabel lblConfirmpin = new JLabel("Confirm Pin:");
		lblConfirmpin.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmpin.setFont(new Font("Candara", Font.PLAIN, 16));
		lblConfirmpin.setBounds(121, 180, 157, 41);
		add(lblConfirmpin);
		
		JLabel lblCurrentPin = new JLabel("Current Pin:");
		lblCurrentPin.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentPin.setFont(new Font("Candara", Font.PLAIN, 16));
		lblCurrentPin.setBounds(121, 76, 157, 41);
		add(lblCurrentPin);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setOpaque(false);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean authenticate;
				boolean authenticate1;
				authenticate = authenticateMember(pfCurrent.getText());
				authenticate1 = authenticateMember(pfNew.getText());
				if(pfNew.getText().equals(pfConfirm.getText()) && authenticate == true && authenticate1 == false){

				try {
					String newpin = pfNew.getText();
					boolean b= m.changePin(newpin);
					if(b = false)
						JOptionPane.showMessageDialog(null, "Pin has not been changed");
					else if(b = true)
						JOptionPane.showMessageDialog(null, "Pin has been changed");
					if(myFrame instanceof LoginFrame){
					JPanel panel = new EditProfilePanel(myFrame, m);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
					}
					
					else if(myFrame instanceof MainFrame){
						JPanel panel = new Courses(myFrame,m);
						myFrame.getContentPane().removeAll();
						myFrame.getContentPane().add(panel);
						myFrame.getContentPane().validate();
						myFrame.getContentPane().repaint();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				}
				else
					JOptionPane.showMessageDialog(null, "Incorrect pin entered");
			}
		});
		btnConfirm.setForeground(new Color(0, 0, 0));
		btnConfirm.setFont(new Font("Candara", Font.PLAIN, 16));
		btnConfirm.setBounds(438, 232, 89, 23);
		add(btnConfirm);
		
		pfCurrent = new JPasswordField();
		pfCurrent.setForeground(new Color(0, 0, 0));
		pfCurrent.setFont(new Font("Candara", Font.PLAIN, 16));
		pfCurrent.setBounds(274, 86, 209, 20);
		add(pfCurrent);
		
		pfNew = new JPasswordField();
		pfNew.setForeground(Color.BLACK);
		pfNew.setFont(new Font("Candara", Font.PLAIN, 16));
		pfNew.setBounds(274, 138, 209, 20);
		add(pfNew);
		
		pfConfirm = new JPasswordField();
		pfConfirm.setForeground(Color.BLACK);
		pfConfirm.setFont(new Font("Candara", Font.PLAIN, 16));
		pfConfirm.setBounds(274, 190, 209, 20);
		add(pfConfirm);
		
	}
	
	private boolean authenticateMember(String pin){
		boolean authenticate;
		Member m1 = new Member();
		m1.setMemberid(m.getMemberid());
		m1.setPin(pin);
		authenticate = m1.retrieveMember();
		System.out.println(authenticate);
		if (authenticate == true)
		return true;
		else
			return false;
		
	}
}
