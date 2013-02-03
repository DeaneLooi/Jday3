package jday.ui.user;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jday.entities.Member;
import jday.util.BackgroundPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;


public class SportInfo extends BackgroundPanel {

	/**
	 * Create the panel.
	 */
	
	
	public SportInfo() {
		super();
		initialize();
	}
	
	public SportInfo(JFrame f,Member m){
		this();
		myFrame = f;
		this.m = m;
	}
	
	private void initialize(){
		setSize(new Dimension(750, 500));
		setLayout(null);
		
		JLabel lblbadminton = new JLabel("Badminton");
		lblbadminton.setBounds(519, 165, 73, 36);
		add(lblbadminton);
		
		JLabel lblbasketball = new JLabel("Basketball");
		lblbasketball.setBounds(189, 173, 76, 21);
		add(lblbasketball);
		
		JLabel lblbowling = new JLabel("Bowling");
		lblbowling.setBounds(201, 457, 46, 14);
		add(lblbowling);
		
		JLabel lbltennis = new JLabel("Tennis");
		lbltennis.setBounds(201, 322, 46, 14);
		add(lbltennis);
		
		JLabel lblVolleyball = new JLabel("Volleyball");
		lblVolleyball.setBounds(519, 318, 56, 14);
		add(lblVolleyball);
		
		JLabel lblIcon = new JLabel("iconbadminton");
		lblIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel panel = new SportInfoBooking(myFrame, m);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		lblIcon.setIcon(new ImageIcon(SportInfo.class.getResource("/images/badminton.png")));
		lblIcon.setBounds(489, 69, 103, 101);
		add(lblIcon);
		
		JLabel lblNewLabel_4 = new JLabel("iconBasketball");
		lblNewLabel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JPanel panel = new SportInfoBooking(myFrame, m);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		lblNewLabel_4.setIcon(new ImageIcon(SportInfo.class.getResource("/images/basketball.png")));
		lblNewLabel_4.setBounds(169, 69, 103, 108);
		add(lblNewLabel_4);
		
		JLabel lblIcontennis = new JLabel("iconTennis");
		lblIcontennis.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblIcontennis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel panel = new SportInfoBooking(myFrame, m);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		lblIcontennis.setIcon(new ImageIcon(SportInfo.class.getResource("/images/tennis.png")));
		lblIcontennis.setBounds(169, 219, 103, 102);
		add(lblIcontennis);
		
		JLabel lblIconvolley = new JLabel("iconVolley");
		lblIconvolley.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblIconvolley.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel panel = new SportInfoBooking(myFrame, m);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		lblIconvolley.setIcon(new ImageIcon(SportInfo.class.getResource("/images/volleyball.png")));
		lblIconvolley.setBounds(489, 216, 103, 101);
		add(lblIconvolley);
		
		JLabel lblIconbowling = new JLabel("iconBowling");
		lblIconbowling.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblIconbowling.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel panel = new SportInfoBooking(myFrame, m);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		lblIconbowling.setIcon(new ImageIcon(SportInfo.class.getResource("/images/bowling.png")));
		lblIconbowling.setBounds(169, 347, 103, 108);
		add(lblIconbowling);
		
		JButton btnViewDetails_1 = new JButton("Details");
		btnViewDetails_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnViewDetails_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new SportViewDetail(myFrame,m);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		btnViewDetails_1.setOpaque(false);
		btnViewDetails_1.setBounds(621, 453, 76, 23);
		add(btnViewDetails_1);
		
		JLabel lblTableTennis = new JLabel("Table tennis");
		lblTableTennis.setBounds(519, 441, 76, 14);
		add(lblTableTennis);
		
		JLabel lblNewLabel_5 = new JLabel("iconTTennis");
		lblNewLabel_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel panel = new SportInfoBooking(myFrame, m);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		lblNewLabel_5.setIcon(new ImageIcon(SportInfo.class.getResource("/images/ttennis.png")));
		lblNewLabel_5.setBounds(489, 348, 103, 106);
		add(lblNewLabel_5);
		
		JLabel lblTheseAreThe = new JLabel("Available Court");
		lblTheseAreThe.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTheseAreThe.setBounds(457, 0, 207, 39);
		add(lblTheseAreThe);

	}
}
