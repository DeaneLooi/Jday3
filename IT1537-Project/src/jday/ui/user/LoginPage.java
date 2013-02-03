package jday.ui.user;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
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
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class LoginPage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelMemberID = null;
	private JLabel jLabelPin = null;
	private JTextField jTextFieldMemberID = null;
	private JButton jButtonLogin = null;
	private JPasswordField jPasswordFieldPin = null;
	private JFrame myFrame = null;
	private JLabel lblForgotPin;
	private JLabel lblLogo;
	private JLabel lblBgcolor;
	private JLabel lblBg;
	  private ImageIcon	imageicon = new ImageIcon(getClass().getResource("/images/purplebg.jpg"));
	  private Image backgroundImage;

	  public void paintComponent(Graphics g) {
		  backgroundImage = imageicon.getImage();
	    super.paintComponent(g);

	    // Draw the background image.
	    g.drawImage(backgroundImage, 0, 0, null);
	    setOpaque(false);
	  }
	  
	/**
	 * This is the default constructor
	 */
	  
	 
	public LoginPage() {
		super();
	}
	
	private void initialize(){
		this.setSize(750,500);
		this.setLayout(null);
		this.setFont(new Font("Arial", Font.BOLD, 18));
		add(getLblLogo());
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(298, 27, 361, 415);
		add(panel);
		panel.setLayout(null);
		
		
				jLabelPin = new JLabel();
				jLabelPin.setBounds(27, 230, 150, 60);
				panel.add(jLabelPin);
				jLabelPin.setForeground(new Color(112, 128, 144));
				jLabelPin.setHorizontalAlignment(SwingConstants.CENTER);
				jLabelPin.setFont(new Font("Candara", Font.BOLD, 16));
				jLabelPin.setText("Pin:");
		panel.add(getLblForgotPin());
		panel.add(getJPasswordFieldPin());
		panel.add(getJTextFieldMemberID());
		panel.add(getJButtonLogin());
		panel.add(getJLabelMemberID());
		panel.add(getLblBgcolor());
		panel.add(getLblBg());
	}

	/**
	 * This method initializes jLabelMemberID	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JLabel getJLabelMemberID() {
		if (jLabelMemberID == null) {
			jLabelMemberID = new JLabel();
			jLabelMemberID.setBounds(0, 189, 150, 60);
			jLabelMemberID.setForeground(new Color(112, 128, 144));
			jLabelMemberID.setText("Member ID:");
			jLabelMemberID.setFont(new Font("Candara", Font.BOLD, 16));
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
			jTextFieldMemberID.setBounds(146, 209, 200, 20);
		}
		return jTextFieldMemberID;
	}
	
	private JPasswordField getJPasswordFieldPin() {
		if (jPasswordFieldPin == null) {
			jPasswordFieldPin = new JPasswordField();
			jPasswordFieldPin.setEchoChar('*');
			jPasswordFieldPin.setBounds(146, 250, 200, 20);
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
			jButtonLogin.setBounds(242, 294, 104, 29);
			jButtonLogin.setBackground(new Color(128, 0, 128));
			jButtonLogin.setForeground(new Color(0, 0, 0));
			jButtonLogin.setFocusPainted(false);
			jButtonLogin.setContentAreaFilled(false);
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
	private JLabel getLblForgotPin() {
		if (lblForgotPin == null) {
			lblForgotPin = new JLabel("Forgot pin?");
			lblForgotPin.setBounds(89, 298, 123, 21);
			lblForgotPin.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					JPanel panel = new ForgotPasswordPanel(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
			lblForgotPin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblForgotPin.setForeground(new Color(0, 0, 255));
			lblForgotPin.setHorizontalAlignment(SwingConstants.CENTER);
			lblForgotPin.setFont(new Font("Candara", Font.PLAIN, 16));
		}
		return lblForgotPin;
	}
	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setBackground(new Color(255, 255, 255));
			lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogo.setIcon(new ImageIcon(LoginPage.class.getResource("/images/newlogo.png")));
			lblLogo.setBounds(45, 113, 217, 200);
		}
		return lblLogo;
	}
	private JLabel getLblBgcolor() {
		if (lblBgcolor == null) {
			lblBgcolor = new JLabel("");
			lblBgcolor.setBounds(7, 391, 342, 13);
			lblBgcolor.setOpaque(true);
			lblBgcolor.setBackground(SystemColor.inactiveCaptionText);
		}
		return lblBgcolor;
	}
	private JLabel getLblBg() {
		if (lblBg == null) {
			lblBg = new JLabel("Welcome!");
			lblBg.setHorizontalAlignment(SwingConstants.CENTER);
			lblBg.setFont(new Font("Candara", Font.BOLD, 26));
			lblBg.setForeground(new Color(255, 255, 255));
			lblBg.setBackground(SystemColor.inactiveCaptionText);
			lblBg.setOpaque(true);
			lblBg.setBounds(10, 11, 339, 146);
		}
		return lblBg;
	}
}
