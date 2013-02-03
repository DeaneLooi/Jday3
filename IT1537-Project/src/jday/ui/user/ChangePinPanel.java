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

import jday.entities.Admin;
import jday.entities.KitchenAdmin;
import jday.entities.Member;
import jday.ui.admin.AMainpage;
import jday.ui.admin.AdminMainframe;
import jday.ui.admin.Kitchen;
import jday.util.BackgroundPanel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChangePinPanel extends BackgroundPanel {
	
	private Member m = null;
	private JPasswordField pfCurrent;
	private JPasswordField pfNew;
	private JPasswordField pfConfirm;
	private JLabel lblChangePin;
	private JLabel lblCurrentError;
	private JLabel lblConfirmError;
	private JLabel lblErrorMessage;

	
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
		
		lblChangePin = new JLabel("Changing Of Pin");
		lblChangePin.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangePin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblChangePin.setForeground(new Color(0, 0, 0));
		lblChangePin.setBounds(334, -11, 343, 77);
		add(lblChangePin);
		
		JLabel lblNewPin = new JLabel("New Pin:");
		lblNewPin.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewPin.setFont(new Font("Candara", Font.PLAIN, 16));
		lblNewPin.setBounds(192, 268, 157, 41);
		add(lblNewPin);
		
		JLabel lblConfirmpin = new JLabel("Confirm Pin:");
		lblConfirmpin.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmpin.setFont(new Font("Candara", Font.PLAIN, 16));
		lblConfirmpin.setBounds(192, 320, 157, 41);
		add(lblConfirmpin);
		
		JLabel lblCurrentPin = new JLabel("Current Pin:");
		lblCurrentPin.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentPin.setFont(new Font("Candara", Font.PLAIN, 16));
		lblCurrentPin.setBounds(192, 216, 157, 41);
		add(lblCurrentPin);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setOpaque(false);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean authenticate;
				boolean authenticate1;
				authenticate = authenticateMember(pfCurrent.getText());
				String pin  = pfNew.getText();
				String pin2 = pfConfirm.getText();
				if(authenticate == false)
					lblCurrentError.setText("Current pin is wrong");
				
				else if(authenticate == true)
					lblCurrentError.setText("");
				
				if(!pin.equals(pin2))
					lblConfirmError.setText("The passwords do not match");
				
				else if(pin.equals(pin2))
					lblConfirmError.setText("");
				
				if(pin.equals(pfCurrent.getText()))
					lblErrorMessage.setText("New pin should not be the same as current pin");
				
				else if(pin!=pfCurrent.getText())
					lblErrorMessage.setText("");
				
				if(pfNew.getText().equals(pfConfirm.getText()) && authenticate == true && pfNew.getText()!=pfCurrent.getText()){

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
						JPanel panel = new EventCalendar(myFrame,m);
						myFrame.getContentPane().removeAll();
						myFrame.getContentPane().add(panel);
						myFrame.getContentPane().validate();
						myFrame.getContentPane().repaint();
					}
					
					else if(myFrame instanceof AdminMainframe){
						if(m instanceof Admin){
							JPanel panel = new AMainpage(myFrame,m);
							myFrame.getContentPane().removeAll();
							myFrame.getContentPane().add(panel);
							myFrame.getContentPane().validate();
							myFrame.getContentPane().repaint();
						}
						
						else if(m instanceof KitchenAdmin){
							JPanel panel = new Kitchen(myFrame);
							myFrame.getContentPane().removeAll();
							myFrame.setContentPane(panel);
							myFrame.setVisible(false);
							myFrame.getContentPane().validate();
							myFrame.getContentPane().repaint();
							myFrame.setVisible(true);
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				}
					
			}
		});
		btnConfirm.setForeground(new Color(0, 0, 0));
		btnConfirm.setFont(new Font("Candara", Font.PLAIN, 16));
		btnConfirm.setBounds(465, 377, 89, 23);
		add(btnConfirm);
		
		pfCurrent = new JPasswordField();
		pfCurrent.setEchoChar('*');
		pfCurrent.setForeground(new Color(0, 0, 0));
		pfCurrent.setFont(new Font("Candara", Font.PLAIN, 16));
		pfCurrent.setBounds(345, 226, 209, 20);
		add(pfCurrent);
		
		pfNew = new JPasswordField();
		pfNew.setEchoChar('*');
		pfNew.setForeground(Color.BLACK);
		pfNew.setFont(new Font("Candara", Font.PLAIN, 16));
		pfNew.setBounds(345, 278, 209, 20);
		add(pfNew);
		
		pfConfirm = new JPasswordField();
		pfConfirm.setEchoChar('*');
		pfConfirm.setForeground(Color.BLACK);
		pfConfirm.setFont(new Font("Candara", Font.PLAIN, 16));
		pfConfirm.setBounds(345, 330, 209, 20);
		add(pfConfirm);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					if(myFrame instanceof LoginFrame){
						JPanel panel = new LoginPage(myFrame);
						myFrame.getContentPane().removeAll();
						myFrame.getContentPane().add(panel);
						myFrame.getContentPane().validate();
						myFrame.getContentPane().repaint();
					}
					else if(myFrame instanceof MainFrame){
						JPanel panel = new EventCalendar(myFrame,m);
						myFrame.getContentPane().removeAll();
						myFrame.getContentPane().add(panel);
						myFrame.getContentPane().validate();
						myFrame.getContentPane().repaint();
					}
					
					else if(myFrame instanceof AdminMainframe){
						if(m instanceof Admin){
						JPanel panel = new AMainpage(myFrame,m);
						myFrame.getContentPane().removeAll();
						myFrame.getContentPane().add(panel);
						myFrame.getContentPane().validate();
						myFrame.getContentPane().repaint();
						}
						
						else if(m instanceof KitchenAdmin){
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
		lblLogo.setIcon(new ImageIcon(ChangePinPanel.class.getResource("/images/110jday_logo.png")));
		lblLogo.setBounds(56, 51, 132, 127);
		add(lblLogo);

		lblCurrentError = new JLabel("");
		lblCurrentError.setForeground(Color.RED);
		lblCurrentError.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCurrentError.setBounds(294, 127, 411, 20);
		add(lblCurrentError);
		
		lblConfirmError = new JLabel("");
		lblConfirmError.setForeground(Color.RED);
		lblConfirmError.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConfirmError.setBounds(294, 158, 411, 20);
		add(lblConfirmError);
		
		lblErrorMessage = new JLabel("");
		lblErrorMessage.setForeground(Color.RED);
		lblErrorMessage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblErrorMessage.setBounds(294, 91, 411, 20);
		add(lblErrorMessage);
		
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
