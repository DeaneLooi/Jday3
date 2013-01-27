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
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import jday.entities.Booking;
import jday.entities.Member;
import jday.entities.dao.AdminViewBookingDAO;
import jday.entities.dao.MemberDAO;
import jday.util.BackgroundPanel;
import jday.util.JTableModel;

import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class AProfile extends BackgroundPanel{
	private JTable table;
	private JTextField textField;
	private JTable table_1;
	private Object name;
	private Member membersearch = new Member();

	/**
	 * Create the panel.
	 */
	public AProfile() {
		super();
		initialize();
	}
	
	public AProfile(JFrame f){
		this();
		myFrame = f;
		
		JTable table = new JTable(new JTableModel()); 
        JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);	
		table.setCellSelectionEnabled(true);

		add(scrollPane);
	
	class JTableModel extends AbstractTableModel {
		private final long serialVersionUID = 1L;
		private final String[] COLUMN_NAMES = new String[] {"memberid", "name", "birthdate" , "contactnoH", "contactnoM", "email" , "address"};
		private final Class<?>[] COLUMN_TYPES = new Class<?>[] {String.class, String.class, String.class, int.class, int.class, String.class,  String.class};
		
		ArrayList<Member> memberList = MemberDAO.retrieveAll();
		int count = memberList.size();
		
		@Override public int getColumnCount() {
			return COLUMN_NAMES.length;
		}

		@Override public int getRowCount() {
			return count;
		}
		
		@Override public String getColumnName(int columnIndex) {
	        return COLUMN_NAMES[columnIndex];
	    }
		
		@Override public Class<?> getColumnClass(int columnIndex) {
			return COLUMN_TYPES[columnIndex];
		}

		@Override public Object getValueAt(final int rowIndex, final int columnIndex) {
			switch (columnIndex) {
				case 0: return memberList.get(rowIndex).getMemberid();
				case 1: return memberList.get(rowIndex).getName();
				case 2: return memberList.get(rowIndex).getBirthdate();
				case 3: return memberList.get(rowIndex).getContactnoH();
				case 4: return memberList.get(rowIndex).getContactnoM();
				case 5: return memberList.get(rowIndex).getEmail();
				case 6: return memberList.get(rowIndex).getAddress();
						
				default: return "Error";
			}
		}	
	}
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
		
		
		
		label.setIcon(new ImageIcon(AProfile.class.getResource("/images/90logo.png")));
		label.setBounds(10, 11, 94, 102);
		add(label);
		
		JLabel lblMemberIdname = new JLabel("Member's name");
		lblMemberIdname.setBounds(59, 399, 85, 25);
		add(lblMemberIdname);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name =textField.getText();
				membersearch.getName();
				MemberDAO.searchByName(membersearch.getName());
				
				ArrayList <Member> memberList = MemberDAO.retrieveAll();
				
				//JTableModel model = new JTableModel (memberList);
				//table_1.setModel(model);
			}
		});
		btnSearch.setBounds(330, 400, 89, 23);
		add(btnSearch);
		
		JLabel label_1 = new JLabel("JDAY Members Profile");
		label_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		label_1.setBounds(114, 43, 312, 42);
		
		
		textField = new JTextField();
		textField.setBounds(154, 401, 147, 23);
		add(textField);
		textField.setColumns(10);
		
		 

	}
}
