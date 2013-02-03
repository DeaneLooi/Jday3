package jday.ui.user;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import jday.entities.Admin;
import jday.entities.BasicMember;
import jday.entities.Member;
import jday.entities.PremiumMember;
import jday.util.BackgroundPanel;
import javax.swing.ImageIcon;


public class GolfingInfo extends BackgroundPanel {
	private JTable tblweekday;
	private JTable tblweekend;
	private JLabel lblWeekdays;
	private JLabel lblWeekends;

	public GolfingInfo() {
		super();
		initialize();
	}
	
	public GolfingInfo(JFrame f, Member m){
		this();
		myFrame = f;
		this.m = m;
	}
	
	private void initialize(){
		setSize(new Dimension(750, 500));
		setLayout(null);
		
		tblweekday = new JTable();
		tblweekday.setFont(new Font("Candara", Font.PLAIN, 16));
		tblweekday.setBackground(new Color(216, 191, 216));
		tblweekday.setRowHeight(30);
		tblweekday.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblweekday.setModel(new DefaultTableModel(
			new Object[][] {
				{"9 Holes", "S$75.00", "Morning, Afternoon, Evening"},
				{"18 Holes", "S$85.00", "Morning, Afternoon, Evening"},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		tblweekday.getColumnModel().getColumn(0).setPreferredWidth(155);
		tblweekday.getColumnModel().getColumn(1).setPreferredWidth(155);
		tblweekday.getColumnModel().getColumn(2).setPreferredWidth(155);
		tblweekday.setBounds(85, 290, 619, 60);
		add(tblweekday);
		
		tblweekend = new JTable();
		tblweekend.setFont(new Font("Candara", Font.PLAIN, 16));
		tblweekend.setBackground(new Color(216, 191, 216));
		tblweekend.setModel(new DefaultTableModel(
			new Object[][] {
				{"9 Holes", "S$80.00", "Morning, Afternoon,Evening"},
				{"18 Holes", "S$100.00", "Morning, Afternoon ,Evening "},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		tblweekend.getColumnModel().getColumn(0).setPreferredWidth(115);
		tblweekend.getColumnModel().getColumn(1).setPreferredWidth(115);
		tblweekend.getColumnModel().getColumn(2).setPreferredWidth(115);
		tblweekend.setRowHeight(30);
		tblweekend.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblweekend.setBounds(85, 373, 619, 60);
		add(tblweekend);
	
		JButton btnbook = new JButton("Book");
		btnbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					if(m instanceof PremiumMember ||m instanceof Admin){
					JPanel panel = new GolfingInfoBooking(myFrame,m);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
					}
					
					else if (m instanceof BasicMember){
						JOptionPane.showMessageDialog(null, "Only premium members are allowed to book for golf");
					}
			}
			
		});
		btnbook.setBounds(615, 455, 89, 23);
		add(btnbook);
		
		JLabel lblNewLabel = new JLabel("Green Fees");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(468, 0, 181, 42);
		add(lblNewLabel);
		
		lblWeekdays = new JLabel("Weekdays");
		lblWeekdays.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblWeekdays.setBackground(new Color(199, 21, 133));
		lblWeekdays.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeekdays.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblWeekdays.setBounds(85, 267, 619, 24);
		add(lblWeekdays);
		
		lblWeekends = new JLabel("Weekends");
		lblWeekends.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblWeekends.setBackground(new Color(199, 21, 133));
		lblWeekends.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblWeekends.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeekends.setBounds(85, 349, 619, 24);
		add(lblWeekends);
		
		JLabel lblPic = new JLabel("pic");
		lblPic.setIcon(new ImageIcon(GolfingInfo.class.getResource("/images/Picture1.png")));
		lblPic.setBounds(85, 74, 625, 182);
		add(lblPic);
		
				 
	}
}
