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
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;

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
		lblNewLabel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblNewLabel.setForeground(new Color(255, 204, 204));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(153, 51, 102));
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
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(145, 253, 164, 73);
		add(lblNewLabel);
		
		JLabel lblEvents = new JLabel("Events");
		lblEvents.setOpaque(true);
		lblEvents.setBackground(new Color(153, 51, 102));
		lblEvents.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
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
		lblEvents.setForeground(new Color(255, 204, 204));
		lblEvents.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEvents.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvents.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEvents.setBounds(483, 253, 164, 73);
		add(lblEvents);
		
		JLabel lblUpdate = new JLabel("Update");
		lblUpdate.setForeground(Color.BLACK);
		lblUpdate.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUpdate.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate.setBounds(401, 0, 299, 47);
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
		lblJdayLogo.setIcon(new ImageIcon(AUpdate.class.getResource("/images/110jday_logo.png")));
		lblJdayLogo.setBounds(55, 31, 115, 125);
		add(lblJdayLogo);
		
	}
}
