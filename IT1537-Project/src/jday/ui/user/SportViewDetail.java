package jday.ui.user;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import jday.entities.Member;
import jday.util.BackgroundPanel;
import java.awt.Rectangle;


public class SportViewDetail extends BackgroundPanel {

	/**
	 * Create the panel.
	 */
	public SportViewDetail() {
		super();
		initialize();
	}
	
	public SportViewDetail(JFrame f,Member m){
		this();
		myFrame = f;
		this.m = m;
	}
	
	private void initialize(){
		setSize(new Dimension(750, 500));
		setLayout(null);
		
		JLabel lblBadminton = new JLabel("badminton");
		lblBadminton.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblBadminton.setIcon(new ImageIcon(SportViewDetail.class.getResource("/images/badminton.png")));
		lblBadminton.setBounds(394, 74, 100, 100);
		add(lblBadminton);
		
		JLabel lblTennis = new JLabel("tennis");
		lblTennis.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblTennis.setIcon(new ImageIcon(SportViewDetail.class.getResource("/images/tennis.png")));
		lblTennis.setBounds(53, 197, 100, 100);
		add(lblTennis);
		
		JLabel lblBasketball = new JLabel("basketball");
		lblBasketball.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblBasketball.setIcon(new ImageIcon(SportViewDetail.class.getResource("/images/basketball.png")));
		lblBasketball.setBounds(53, 74, 100, 100);
		add(lblBasketball);
		
		JLabel lblTtennis = new JLabel("ttennis");
		lblTtennis.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblTtennis.setIcon(new ImageIcon(SportViewDetail.class.getResource("/images/ttennis.png")));
		lblTtennis.setBounds(394, 323, 100, 100);
		add(lblTtennis);
		
		JLabel lblBowling = new JLabel("volleyball");
		lblBowling.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblBowling.setIcon(new ImageIcon(SportViewDetail.class.getResource("/images/volleyball.png")));
		lblBowling.setBounds(394, 197, 100, 100);
		add(lblBowling);
		
		JLabel lblVolleyball = new JLabel("bowling");
		lblVolleyball.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblVolleyball.setIcon(new ImageIcon(SportViewDetail.class.getResource("/images/bowling.png")));
		lblVolleyball.setBounds(53, 323, 100, 100);
		add(lblVolleyball);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new SportInfo(myFrame,m);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		btnBack.setOpaque(false);
		btnBack.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnBack.setBounds(606, 448, 89, 23);
		add(btnBack);
		
		JTextArea txtrBasketball = new JTextArea();
		txtrBasketball.setFont(new Font("Candara", Font.PLAIN, 13));
		txtrBasketball.setOpaque(false);
		txtrBasketball.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtrBasketball.setText("Basketball court\r\nSurface: concrete\r\nArea: 28.65m X 15.24m\r\nOpen Hours: 0900-1900\r\nConditions: Booking is require\r\nAvailable Court: 3\r\n\r\n");
		txtrBasketball.setBounds(152, 74, 200, 100);
		add(txtrBasketball);
		
		JTextArea txtrTennis = new JTextArea();
		txtrTennis.setFont(new Font("Candara", Font.PLAIN, 13));
		txtrTennis.setOpaque(false);
		txtrTennis.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtrTennis.setName("");
		txtrTennis.setText("Tennis court\r\nSurface: Concrete\r\nArea: 23.78m X 10.97\r\nOpen Hours: 0900-1900\r\nConditions: Booking is require\r\nAvailable Court: 3");
		txtrTennis.setBounds(152, 197, 200, 100);
		add(txtrTennis);
		
		JTextArea txtrBadminton = new JTextArea();
		txtrBadminton.setFont(new Font("Candara", Font.PLAIN, 13));
		txtrBadminton.setOpaque(false);
		txtrBadminton.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtrBadminton.setText("Badminton court\r\nSurface: Concrete\r\nArea: 13m X 6m\r\nOpen Hours: 0900-1900\r\nConditions: Booking is require\r\nAvailable Court: 3");
		txtrBadminton.setBounds(493, 74, 202, 100);
		add(txtrBadminton);
		
		JTextArea txtrVolleyball = new JTextArea();
		txtrVolleyball.setFont(new Font("Candara", Font.PLAIN, 13));
		txtrVolleyball.setOpaque(false);
		txtrVolleyball.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtrVolleyball.setText("Volleyball court\r\nSurface: Concrete\r\nArea: 18m X 9m\r\nOpen Hours: 0900-1900\r\nConditions: Booking is require\r\nAvailable Court: 3");
		txtrVolleyball.setBounds(493, 197, 202, 100);
		add(txtrVolleyball);
		
		JTextArea txtrTtennis = new JTextArea();
		txtrTtennis.setFont(new Font("Candara", Font.PLAIN, 13));
		txtrTtennis.setOpaque(false);
		txtrTtennis.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtrTtennis.setText("Bowling court\r\nOpen Hours: 0900-1900\r\nConditions: Booking is require\r\nAvailable Court: 3");
		txtrTtennis.setBounds(152, 323, 200, 100);
		add(txtrTtennis);
		
		JTextArea txtrBowling = new JTextArea();
		txtrBowling.setFont(new Font("Candara", Font.PLAIN, 13));
		txtrBowling.setOpaque(false);
		txtrBowling.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtrBowling.setText("Table tennis room\r\nArea: 10m X 5m\r\nOpen Hours: 0900-1900\r\nConditions: Booking is require\r\nAvailable Court: 3");
		txtrBowling.setBounds(493, 323, 202, 100);
		add(txtrBowling);
		
		JButton button = new JButton("Book Now");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel panel = new SportInfoBooking(myFrame, m);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		button.setOpaque(false);
		button.setBounds(new Rectangle(0, 0, 117, 0));
		button.setBounds(475, 448, 100, 23);
		add(button);

	}
}
