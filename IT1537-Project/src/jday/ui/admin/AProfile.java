package jday.ui.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import jday.entities.Booking;
import jday.entities.Member;
import jday.entities.dao.AdminViewBookingDAO;
import jday.entities.dao.MemberDAO;
import jday.util.*;

import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class AProfile extends BackgroundPanel{
	private JTable table = new JTable();
	private JTextField tfsearch;
	
	/**
	 * Create the panel.
	 */
	public AProfile() {
		super();
		initialize();
	}
	
	public AProfile(JFrame f,Member m){
		this();
		myFrame = f;
		this.m = m;
		
	
		ProfileTableModel model = new ProfileTableModel(MemberDAO.retrieveAll());
		table.setBounds(0, 0, 400, 450);
		table.setRowHeight(30);
		table.setBackground(new Color(216, 191, 216));
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(180);
		table.getColumnModel().getColumn(1).setPreferredWidth(180);
		table.getColumnModel().getColumn(2).setPreferredWidth(180);
		table.getColumnModel().getColumn(3).setPreferredWidth(180);
		table.getColumnModel().getColumn(4).setPreferredWidth(180);
		table.getColumnModel().getColumn(5).setPreferredWidth(400);
		table.getColumnModel().getColumn(6).setPreferredWidth(400);
		
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(70, 140, 650, 290);
		
        
		add(scrollPane);
	

	}
	
	private void initialize(){
		setSize(new Dimension(750, 500));
		setLayout(null);
		
		JLabel label = new JLabel("logo");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel panel = new AMainpage(myFrame,m);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		
	
		label.setIcon(new ImageIcon(AProfile.class.getResource("/images/90logo.png")));
		label.setBounds(52, 31, 94, 102);
		add(label);
		
		JLabel lblname = new JLabel("Member's name");
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblname.setBounds(68, 444, 106, 25);
		add(lblname);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name =tfsearch.getText();
				ArrayList <Member> mlist = MemberDAO.searchByName(name);
				ProfileTableModel model = new ProfileTableModel(mlist);
				table.setModel(model);
				table.getColumnModel().getColumn(0).setPreferredWidth(180);
				table.getColumnModel().getColumn(1).setPreferredWidth(180);
				table.getColumnModel().getColumn(2).setPreferredWidth(180);
				table.getColumnModel().getColumn(3).setPreferredWidth(180);
				table.getColumnModel().getColumn(4).setPreferredWidth(180);
				table.getColumnModel().getColumn(5).setPreferredWidth(400);
				table.getColumnModel().getColumn(6).setPreferredWidth(400);
			}
		});
		btnSearch.setBounds(345, 445, 89, 23);
		add(btnSearch);
		
		
		JLabel label_1;
		label_1 = new JLabel("JDAY Members Profile");
		label_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		label_1.setBounds(114, 43, 312, 42);
		
		
		tfsearch = new JTextField();
		tfsearch.setBounds(188, 446, 147, 23);
		add(tfsearch);
		tfsearch.setColumns(10);
		
		JLabel lblHeader = new JLabel("Member Profile");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblHeader.setBounds(455, 0, 211, 44);
		add(lblHeader);
		
		JButton btndelete = new JButton("Delete");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					deleteMember();
				}catch (SQLException e){
					e.printStackTrace();
				}
			}
		});
		btndelete.setBounds(611, 445, 89, 23);
		add(btndelete);
	}
	
	 ///////////////////////////
	   public void deleteMember() throws SQLException{
		
			int rowSelected = table.getSelectedRow();
			System.out.println(rowSelected);
			
			if(rowSelected>=0){
			String mem = table.getValueAt(rowSelected, 0).toString();
			Member member = new Member(mem);
			member.deleteMemberInfo();
			
			ProfileTableModel model = new ProfileTableModel(MemberDAO.retrieveAll());
			table.setModel(model);
			
			}
			
			else 
				JOptionPane.showMessageDialog(null,"No record Selected", "Alert",
						JOptionPane.ERROR_MESSAGE);
		}
}
