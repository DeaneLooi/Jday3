package jday.ui.admin;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import jday.entities.Member;
import jday.ui.user.ChangePinPanel;
import jday.ui.user.EditProfilePanel;
import jday.ui.user.LoginFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;


public class AdminMainframe extends JFrame {

	private JPanel contentPane;
	private JFrame myFrame = null;
	private Member m = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMainframe frame = new AdminMainframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminMainframe() {
		super();
		myFrame = this;
		initialize();
	}
	
	public AdminMainframe(Member m){
		super();
		myFrame = this;
		this.m = m;
		initialize();
	}
	
	private void initialize(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminMainframe.class.getResource("/images/jday_logo.png")));
		setTitle("Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(128, 0, 128));
		menuBar.setBackground(Color.DARK_GRAY);
		setJMenuBar(menuBar);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(new Color(128, 0, 128));
		separator_5.setBackground(Color.DARK_GRAY);
		separator_5.setOpaque(true);
		menuBar.add(separator_5);
		
		JMenu mnNewMenu = new JMenu(m.getMemberid());
		mnNewMenu.setBackground(Color.DARK_GRAY);
		mnNewMenu.setForeground(new Color(255, 255, 255));
		mnNewMenu.setOpaque(true);
		mnNewMenu.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		mnNewMenu.setHorizontalTextPosition(SwingConstants.CENTER);
		mnNewMenu.setHorizontalAlignment(SwingConstants.RIGHT);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmViewProfile = new JMenuItem("View profile");
		mntmViewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel panel = new EditProfilePanel(myFrame,m);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		mntmViewProfile.setBorder(new LineBorder(new Color(0, 0, 0)));
		mntmViewProfile.setBackground(new Color(255, 255, 255));
		mnNewMenu.add(mntmViewProfile);
		
		JMenuItem mntmChangePin = new JMenuItem("Change PIN");
		mntmChangePin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new ChangePinPanel(myFrame,m);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		mntmChangePin.setBorder(new LineBorder(new Color(0, 0, 0)));
		mntmChangePin.setOpaque(true);
		mntmChangePin.setBackground(new Color(250, 235, 215));
		mnNewMenu.add(mntmChangePin);
		
		JMenu mnLogout = new JMenu("Logout");
		mnLogout.addMenuListener(new MenuListener(){
			public void menuSelected(MenuEvent e){
				myFrame.setVisible(false);
				myFrame = new LoginFrame();
				myFrame.setVisible(true);
			}

			@Override
			public void menuCanceled(MenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void menuDeselected(MenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		mnLogout.setOpaque(true);
		mnLogout.setForeground(new Color(255, 255, 255));
		mnLogout.setBackground(Color.DARK_GRAY);
		mnLogout.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		menuBar.add(mnLogout);
		contentPane = new AMainpage(myFrame,m);
		contentPane.setSize(new Dimension(750, 500));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
