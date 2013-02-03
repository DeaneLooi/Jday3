package jday.ui.admin;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import jday.util.BackgroundPanel;
import jday.util.EmailSender;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Random;

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
import javax.swing.SwingConstants;

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
	private JLabel lblErrorMessage;
	private JLabel lblNameError;
	private JLabel lblEmailError;
	private JLabel lblContactError;
	private JLabel lblMemberTypeError;

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
				int contactnoM = 0;
				int contactnoH = 0;
				String memberid = tfmemberid.getText();
				String email = tfemail.getText();
				String address = taaddress.getText();
				String pin = pwdPin.getText();
				if(tfnoM.getText().equals("") || tfnoh.getText().equals("")){
					lblErrorMessage.setText("<html><p>Contact numbers cannot be blank</p></html>");
				}

				else if(tfnoM.getText()!="" || tfnoh.getText()!=""){
				contactnoM = Integer.parseInt(tfnoM.getText());
				contactnoH = Integer.parseInt(tfnoh.getText());
				}


				if(name.equals(""))
					lblNameError.setText("<html><p>Please fill in name.</p></html>");
				
				if(name.length() != 0)
					lblNameError.setText("");
				
				if(email.equals(""))
					lblEmailError.setText("<html><p>Please fill in Email.</p></html>");
				
				if(email.length() != 0)
					lblEmailError.setText("");
				
				if(contactnoM == 0)
					lblContactError.setText("<html><p>Please fill in contact number.</p></html>");
				
				else if(contactnoM != 0)
					lblContactError.setText("");
				
				if(memberSelected == 0)
					lblMemberTypeError.setText("<html><p>Please choose member type.</p></html>");
				
				else if(memberSelected != 0)
					lblMemberTypeError.setText("");
				
				if(name != null && email != null && contactnoM != 0 && memberSelected != 0){
				memberregister.setName(name);
				memberregister.setBirthdate(birthdate);
				memberregister.setContactnoM(contactnoM);
				memberregister.setContactnoH(contactnoH);
				memberregister.setMemberid(memberid);
				memberregister.setEmail(email);
				memberregister.setAddress(address);
				memberregister.setPin(pin);
				
				
					EmailSender emailSender = new EmailSender(memberregister);
					try {
						boolean valid = emailSender.sendValidation();
						System.out.println(valid);
						if(valid == false)
							lblEmailError.setText("<html><p>Email address is not valid</p></html>");
						else if(valid){

							try {
						memberregister.createMember();
						memberregister.createMemberInfo();
						emailSender.sendMemberId();
							} catch (SQLException e) {
						JOptionPane.showMessageDialog(null,"Registration failed");
						e.printStackTrace();
							}
							JOptionPane.showMessageDialog(null, "Member created");
							JPanel panel = new AMainpage(myFrame,m);
							myFrame.getContentPane().removeAll();
							myFrame.getContentPane().add(panel);
							myFrame.getContentPane().validate();
							myFrame.getContentPane().repaint();
						}
						

							
					} catch (AddressException e) {
						lblEmailError.setText("<html><p>Email address is not valid</p></html>");
						e.printStackTrace();
					} catch (HeadlessException e) {
						lblEmailError.setText("<html><p>Email address is not valid</p></html>");
						e.printStackTrace();
					} catch (MessagingException e) {
						lblEmailError.setText("<html><p>Email address is not valid</p></html>");
						e.printStackTrace();
					}
				}
			}
		});
		add(btnCreate);
		
		JLabel lblJdayRegister = new JLabel("JDAY Register");
		lblJdayRegister.setBounds(124, 46, 222, 43);
		lblJdayRegister.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		add(lblJdayRegister);
		
		JLabel lblName = new JLabel("<html>\r\n<span style=\"color:red\">*</span>Name:\r\n</html>");
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
		
		JLabel lblContactNumberm = new JLabel("<html>\r\n<span style=\"color:red\">*</span>Contact number (M):\r\n</html>");
		lblContactNumberm.setBounds(64, 282, 158, 29);
		lblContactNumberm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblContactNumberm);
		
		JLabel lblEmail = new JLabel("<html>\r\n<span style=\"color:red\">*</span>E-mail:\r\n</html>");
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
		
		tfnoM = new JTextField("0");
		tfnoM.setBounds(226, 285, 140, 23);
		tfnoM.setColumns(10);
		add(tfnoM);
        tfnoM.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                    char ch = e.getKeyChar();
                    if ((ch >= '0' && ch <= '9')|| ch =='\b') {
                           tfnoM.setEditable(true);
                    } else {
                    		tfnoM.setText("0");
                    		tfnoM.setEditable(false);
                            lblErrorMessage.setText("<html><p>Only numbers can be input</p></html>");
 
                            
                    }
            }
    });
		
		tfnoh = new JTextField("0");
		tfnoh.setBounds(226, 336, 140, 23);
		tfnoh.setColumns(10);
		add(tfnoh);
        tfnoh.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                    char ch = e.getKeyChar();
                    if ((ch >= '0' && ch <= '9')|| ch =='\b') {
                           tfnoh.setEditable(true);
                    } else {
                    		tfnoh.setText("0");
                    		tfnoh.setEditable(false);
                            lblErrorMessage.setText("<html><p>Only numbers can be input</p></html>");
 
                            
                    }
            }
    });
		
		tfmemberid = new JTextField(getMemberid());
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

		pwdPin = new JPasswordField(Integer.toString(getPin()));
		pwdPin.setEchoChar('*');
		pwdPin.setBounds(226, 384, 140, 23);
		pwdPin.setEditable(false);
		add(pwdPin);
		
		cbbmembertype = new JComboBox();
		cbbmembertype.setModel(new DefaultComboBoxModel(new String[] {"Choose member type","Basic member", "Premium member", "Admin", "Kitchen admin"}));
		cbbmembertype.setBounds(226, 426, 167, 23);
		cbbmembertype.setMaximumRowCount(3);
		add(cbbmembertype);
		
		JLabel lblmembertype = new JLabel("<html>\r\n<span style=\"color:red\">*</span>Member type:\r\n</html>");
		lblmembertype.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblmembertype.setBounds(113, 422, 140, 25);
		add(lblmembertype);
		
		lblErrorMessage = new JLabel("<html>\r\n<p>All fields with * cannot be blank</p>\r\n</html>");
		lblErrorMessage.setVerticalAlignment(SwingConstants.TOP);
		lblErrorMessage.setFont(new Font("Candara", Font.PLAIN, 16));
		lblErrorMessage.setForeground(Color.RED);
		lblErrorMessage.setBounds(361, 27, 360, 29);
		add(lblErrorMessage);
		
		lblNameError = new JLabel();
		lblNameError.setVerticalAlignment(SwingConstants.TOP);
		lblNameError.setForeground(Color.RED);
		lblNameError.setFont(new Font("Candara", Font.PLAIN, 16));
		lblNameError.setBounds(361, 55, 360, 29);
		add(lblNameError);
		
		lblEmailError = new JLabel();
		lblEmailError.setVerticalAlignment(SwingConstants.TOP);
		lblEmailError.setForeground(Color.RED);
		lblEmailError.setFont(new Font("Candara", Font.PLAIN, 16));
		lblEmailError.setBounds(361, 84, 360, 29);
		add(lblEmailError);
		
		lblContactError = new JLabel();
		lblContactError.setVerticalAlignment(SwingConstants.TOP);
		lblContactError.setForeground(Color.RED);
		lblContactError.setFont(new Font("Candara", Font.PLAIN, 16));
		lblContactError.setBounds(361, 112, 360, 29);
		add(lblContactError);
		
		lblMemberTypeError = new JLabel();
		lblMemberTypeError.setVerticalAlignment(SwingConstants.TOP);
		lblMemberTypeError.setForeground(Color.RED);
		lblMemberTypeError.setFont(new Font("Candara", Font.PLAIN, 16));
		lblMemberTypeError.setBounds(361, 135, 360, 29);
		add(lblMemberTypeError);

	}
	
	
	public String getMemberid(){
		Random randomNumber = new Random();
		int randomNo = (int)randomNumber.nextInt(9999999);
		char c = (char)(randomNumber.nextInt(26) + 'a');
		String memberid = Integer.toString(randomNo) + Character.toUpperCase(c);
		return memberid;
	}
	
	public int getPin(){
		Random random = new Random();
		int pin = (int)random.nextInt(999999);
		return pin;
	}
}
