package jday.ui.user;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import jday.entities.Admin;
import jday.entities.BasicMember;
import jday.entities.KitchenAdmin;
import jday.entities.Member;
import jday.entities.PremiumMember;
import jday.ui.admin.AdminMainframe;
import jday.ui.admin.Kitchen;
import jday.util.BackgroundPanel;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPage extends BackgroundPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelMemberID = null;
	private JLabel jLabelPin = null;
	private JTextField jTextFieldMemberID = null;
	private JButton jButtonLogin = null;
	private JPasswordField jPasswordFieldPin = null;
	private JFrame myFrame = null;
	private JLabel lblForgotPassword;

	/**
	 * This is the default constructor
	 */
	public LoginPage() {
		super();
	}


	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabelPin = new JLabel();
		jLabelPin.setForeground(new Color(0, 0, 0));
		jLabelPin.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelPin.setFont(new Font("Candara", Font.BOLD, 16));
		jLabelPin.setLocation(new Point(139, 225));
		jLabelPin.setSize(new Dimension(150, 60));
		jLabelPin.setText("Pin:");
		this.setSize(750,500);
		this.setLayout(null);
		this.setFont(new Font("Arial", Font.BOLD, 18));
		this.add(getJLabelMemberID(), null);
		this.add(jLabelPin, null);
		this.add(getJTextFieldMemberID(), null);
		this.add(getJButtonLogin(), null);
		this.add(getJPasswordFieldPin(), null);
		add(getLblForgotPassword());
	}

	/**
	 * This method initializes jLabelMemberID	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JLabel getJLabelMemberID() {
		if (jLabelMemberID == null) {
			jLabelMemberID = new JLabel();
			jLabelMemberID.setForeground(new Color(0, 0, 0));
			jLabelMemberID.setText("Member ID:");
			jLabelMemberID.setFont(new Font("Candara", Font.BOLD, 16));
			jLabelMemberID.setLocation(new Point(139, 154));
			jLabelMemberID.setSize(new Dimension(150, 60));
			jLabelMemberID.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return jLabelMemberID;
	}

	/**
	 * This method initializes jTextFieldMemberID	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldMemberID() {
		if (jTextFieldMemberID == null) {
			jTextFieldMemberID = new JTextField();
			jTextFieldMemberID.setLocation(new Point(299, 164));
			jTextFieldMemberID.setSize(new Dimension(200, 40));
		}
		return jTextFieldMemberID;
	}
	
	private JPasswordField getJPasswordFieldPin() {
		if (jPasswordFieldPin == null) {
			jPasswordFieldPin = new JPasswordField();
			jPasswordFieldPin.setSize(200,40);
			jPasswordFieldPin.setLocation(new Point(299, 235));
		}
		return jPasswordFieldPin;
	}

	public LoginPage(JFrame f){
		this();
		myFrame=f;
		initialize();
	}
	/**
	 * This method initializes jButtonLogin	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonLogin() {
		if (jButtonLogin == null) {
			jButtonLogin = new JButton();
			jButtonLogin.setOpaque(false);
			jButtonLogin.setForeground(new Color(0, 0, 0));
			jButtonLogin.setBounds(new Rectangle(399, 286, 100, 40));
			jButtonLogin.setText("Log In");
			jButtonLogin.setFont(new Font("Candara", Font.BOLD, 16));
			jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					boolean check = authenticateMember();
					System.out.println("Check is "+check);
					myFrame.setVisible(false);
					
					if(check == false){
			
					String id = getJTextFieldMemberID().getText();
					Member m1 = new Member(id);
					String memtype;
					try {
						memtype = m1.getMembertype();
						System.out.println("memtype ="+memtype);
						if(memtype.equals("Admin") && memtype != null)
							m1 = new Admin();
						if(memtype.equals("Kitchen Admin") & memtype != null)
							m1 = new KitchenAdmin();
						if(memtype.equals("Basic Member") && memtype != null)
							m1 = new BasicMember();
						if(memtype.equals("Premium Member") && memtype != null)
							m1 = new PremiumMember();
						m1.setMemberid(id);

				
						if(m1 instanceof Admin){
							myFrame = new AdminMainframe(m1);
							myFrame.setVisible(true);
						}
						else if(m1 instanceof KitchenAdmin){
							myFrame = new AdminMainframe(m1);
							JPanel panel = new Kitchen(myFrame);
							myFrame.setContentPane(panel);
							myFrame.setVisible(true);
						}
						else{
						int count =m1.getCount();
						System.out.println(count);
						if(count == 0){
							m1.setCount();
							JPanel panel = new ChangePinPanel(myFrame,m1);
							myFrame.getContentPane().removeAll();
							myFrame.getContentPane().add(panel);
							myFrame.getContentPane().validate();
							myFrame.getContentPane().repaint();
							myFrame.setVisible(true);
						}
						else{
						JFrame myFrame = new MainFrame(m1);
						myFrame.setVisible(true);
								}
							}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					}
					if(check == true) {
						myFrame = new LoginFrame();
						myFrame.setVisible(true);
						JOptionPane.showMessageDialog(null, "Invalid Member ID or password");
					} 
					
				}
			});
			
			
			
		}
		
		return jButtonLogin;
	}

	private boolean authenticateMember(){
		String id = getJTextFieldMemberID().getText();
		String pin = getJPasswordFieldPin().getText();
		boolean authenticate;
		Member m1 = new Member();
		m1.setMemberid(id);
		m1.setPin(pin);
		authenticate = m1.retrieveMember();
		System.out.println(authenticate);
		if (authenticate == true)
		return false;
		else
			return true;
	}
	private JLabel getLblForgotPassword() {
		if (lblForgotPassword == null) {
			lblForgotPassword = new JLabel("Forgot password?");
			lblForgotPassword.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					JPanel panel = new ForgotPasswordPanel(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
			lblForgotPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblForgotPassword.setForeground(new Color(0, 0, 255));
			lblForgotPassword.setHorizontalAlignment(SwingConstants.CENTER);
			lblForgotPassword.setFont(new Font("Candara", Font.PLAIN, 16));
			lblForgotPassword.setBounds(240, 296, 150, 19);
		}
		return lblForgotPassword;
	}
}
