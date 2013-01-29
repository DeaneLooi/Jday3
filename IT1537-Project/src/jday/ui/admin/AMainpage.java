package jday.ui.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import jday.entities.Member;
import jday.ui.user.MainFrame;
import jday.util.BackgroundPanel;

public class AMainpage extends BackgroundPanel {

	/**
	 * Create the panel.
	 */
	public AMainpage() {
		super();
		initialize();
	}
	
	public AMainpage(JFrame f){
		this();
		myFrame = f;
	}
	public AMainpage(JFrame f,Member m){
		this();
		myFrame = f;
		this.m = m;

	}
	private void initialize(){
		setSize(new Dimension(750, 500));
		setLayout(null);
		
		JLabel label = new JLabel("logo");
		label.setIcon(new ImageIcon(AMainpage.class.getResource("/images/110jday_logo.png")));
		label.setBounds(303, 11, 112, 118);
		add(label);
		
		JLabel lblWelcomeToJday = new JLabel("Welcome to JDAY Admin");
		lblWelcomeToJday.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		lblWelcomeToJday.setBounds(195, 116, 386, 42);
		add(lblWelcomeToJday);
		
		JLabel lblProfile = new JLabel("Profile");
		lblProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel panel = new AProfile(myFrame,m);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		lblProfile.setForeground(new Color(0, 0, 0));
		lblProfile.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblProfile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProfile.setHorizontalTextPosition(SwingConstants.CENTER);
		lblProfile.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblProfile.setVerticalAlignment(SwingConstants.TOP);
		lblProfile.setHorizontalAlignment(SwingConstants.LEFT);
		lblProfile.setIcon(new ImageIcon(AMainpage.class.getResource("/images/_profile.png")));
		lblProfile.setBounds(303, 169, 135, 118);
		add(lblProfile);
		
		JLabel lblUpdate = new JLabel("Update");
		lblUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel panel = new AUpdate(myFrame,m);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
				
				
			}
		});
		lblUpdate.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblUpdate.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblUpdate.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUpdate.setVerticalAlignment(SwingConstants.TOP);
		lblUpdate.setHorizontalAlignment(SwingConstants.LEFT);
		lblUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpdate.setIcon(new ImageIcon(AMainpage.class.getResource("/images/_update.png")));
		lblUpdate.setBounds(192, 315, 139, 113);
		add(lblUpdate);
		
		JLabel lblBooking = new JLabel("Booking");
		lblBooking.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel panel = new ABooking(myFrame,m);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		lblBooking.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblBooking.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBooking.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblBooking.setVerticalAlignment(SwingConstants.TOP);
		lblBooking.setHorizontalTextPosition(SwingConstants.CENTER);
		lblBooking.setHorizontalAlignment(SwingConstants.LEFT);
		lblBooking.setIcon(new ImageIcon(AMainpage.class.getResource("/images/_r2.png")));
		lblBooking.setBounds(419, 315, 135, 113);
		add(lblBooking);
		
		JLabel lblMi = new JLabel("Member Interface");
		lblMi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myFrame.setVisible(false);
				myFrame = new MainFrame(m);
				JPanel panel = new AMainpage(myFrame,m);
				myFrame.setContentPane(panel);
				myFrame.setVisible(true);
			
			}
		});
		lblMi.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblMi.setForeground(new Color(0, 0, 0));
		lblMi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMi.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblMi.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMi.setVerticalAlignment(SwingConstants.TOP);
		lblMi.setHorizontalAlignment(SwingConstants.LEFT);
		lblMi.setIcon(new ImageIcon(AMainpage.class.getResource("/images/_group.png")));
		lblMi.setBounds(511, 169, 139, 112);
		add(lblMi);
		
		JLabel lblRestaurant_1 = new JLabel("Register");
		lblRestaurant_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblRestaurant_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JPanel panel = new ARegister(myFrame,m);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		lblRestaurant_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRestaurant_1.setVerticalAlignment(SwingConstants.TOP);
		lblRestaurant_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblRestaurant_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblRestaurant_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblRestaurant_1.setIcon(new ImageIcon(AMainpage.class.getResource("/images/rsz_mdsvbmb.png")));
		lblRestaurant_1.setBounds(100, 169, 139, 112);
		add(lblRestaurant_1);

	}
}
