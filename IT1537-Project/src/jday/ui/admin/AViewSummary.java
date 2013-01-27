package jday.ui.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import jday.util.BackgroundPanel;

public class AViewSummary extends BackgroundPanel{
	private JTable table;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public AViewSummary() {
		super();
		initialize();
	}
	
	public AViewSummary(JFrame f){
		this();
		myFrame = f;
	}
	
	private void initialize(){
		setSize(new Dimension(750, 500));
		setLayout(null);
		
		JLabel label = new JLabel("logo");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel panel = new AMainpage(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		label.setIcon(new ImageIcon(AViewSummary.class.getResource("/images/90logo.png")));
		label.setBounds(10, 11, 94, 102);
		add(label);
		
		JLabel lblJdayMembersPayment = new JLabel("JDAY Members payment summary");
		lblJdayMembersPayment.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		lblJdayMembersPayment.setBounds(126, 44, 485, 42);
		add(lblJdayMembersPayment);
		
		JLabel lblThisIsThe = new JLabel("This is the payment summary of 123456A:");
		lblThisIsThe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblThisIsThe.setBounds(94, 138, 312, 28);
		add(lblThisIsThe);
		
		table = new JTable();
		table.setBackground(new Color(216, 191, 216));
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Services", null},
				{"Lifestyles", null},
				{"Golfing", null},
				{"Event", null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		table.setRowHeight(40);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(95, 177, 584, 196);
		add(table);
		
		JLabel lblTotalAmount = new JLabel("Total Amount:");
		lblTotalAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotalAmount.setBounds(94, 387, 112, 28);
		add(lblTotalAmount);
		
		textField = new JTextField();
		textField.setBounds(204, 389, 144, 29);
		add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new AProfile(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		button.setBounds(569, 395, 89, 23);
		add(button);

	}
}
