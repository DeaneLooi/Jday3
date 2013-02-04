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
import javax.swing.JTable;
import javax.swing.SwingConstants;

import jday.entities.Member;
import jday.util.BackgroundPanel;
import javax.swing.border.LineBorder;

public class AUpdate extends BackgroundPanel {
	
	public AUpdate() {
		super();
		initialize();
	}
	
	public AUpdate(JFrame f, Member m){
		this();
		myFrame = f;
		this.m = m;
	}
	private void initialize(){
		setSize(new Dimension(750, 500));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Courses");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		lblNewLabel.setIcon(new ImageIcon(AUpdate.class.getResource("/images/background.png")));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JPanel panel = new AUpdateCourse(myFrame,m);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
				
				
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(153, 234, 133, 110);
		add(lblNewLabel);
		
		JLabel lblEvents = new JLabel("Events");
		lblEvents.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		lblEvents.setIcon(new ImageIcon(AUpdate.class.getResource("/images/background.png")));
		lblEvents.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel panel = new AUpdateEvent(myFrame,m);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		lblEvents.setForeground(Color.BLACK);
		lblEvents.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblEvents.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvents.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEvents.setBounds(492, 234, 133, 110);
		add(lblEvents);
		
		JLabel lblUpdate = new JLabel("Update");
		lblUpdate.setForeground(Color.BLACK);
		lblUpdate.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblUpdate.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate.setBounds(492, 0, 133, 40);
		add(lblUpdate);
		
		JLabel lblJdayLogo = new JLabel("");
		lblJdayLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JPanel panel = new AMainpage(myFrame,m);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		lblJdayLogo.setIcon(new ImageIcon(AUpdate.class.getResource("/images/90logo.png")));
		lblJdayLogo.setBounds(49, 30, 97, 110);
		add(lblJdayLogo);
		
	}
}
