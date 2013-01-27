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

import jday.util.BackgroundPanel;

public class AUpdate extends BackgroundPanel {

	public AUpdate() {
		super();
		initialize();
	}
	
	public AUpdate(JFrame f){
		this();
		myFrame = f;
	}
	private void initialize(){
		setSize(new Dimension(750, 500));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Courses");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JPanel panel = new AUpdateCourse(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
				
				
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(131, 234, 133, 110);
		add(lblNewLabel);
		
		JLabel lblEvents = new JLabel("Events");
		lblEvents.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel panel = new AUpdateEvent(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		lblEvents.setForeground(new Color(0, 0, 0));
		lblEvents.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEvents.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvents.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEvents.setBounds(472, 234, 133, 110);
		add(lblEvents);
		
		JLabel lblUpdate = new JLabel("Update");
		lblUpdate.setForeground(new Color(102, 0, 102));
		lblUpdate.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUpdate.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate.setBounds(131, 60, 133, 61);
		add(lblUpdate);
		
		JLabel lblJdayLogo = new JLabel("");
		lblJdayLogo.setIcon(new ImageIcon(AUpdate.class.getResource("/images/110jday_logo.png")));
		lblJdayLogo.setBounds(10, 27, 115, 125);
		add(lblJdayLogo);
		
	}
}
