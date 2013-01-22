package jday.ui.user;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



import jday.entities.Class;
import jday.entities.Member;
import jday.util.BackgroundPanel;
import jday.util.ClassTableModel;

public class Classes extends BackgroundPanel{



	private Member m;
	
	public Classes() {
		super();
		initialize();
	}
	
	public Classes(JFrame f){
		this();
		myFrame = f;
	}
	
	public Classes(JFrame f,Member m){
		super();
		myFrame = f;
		this.m = m;
		initialize();
	}
	private void initialize(){
		setSize(750,500);
		setLayout(null);

		
		final JTable tableList = new JTable();
		ClassTableModel model = new ClassTableModel(Class.retrieveClasses());
		tableList.setModel(model);
		tableList.setBounds(0,0,850,165);
		tableList.getColumnModel().getColumn(0).setPreferredWidth(75);
		tableList.getColumnModel().getColumn(1).setPreferredWidth(300);
		tableList.getColumnModel().getColumn(2).setPreferredWidth(300);
		tableList.getColumnModel().getColumn(3).setPreferredWidth(200);
		tableList.getColumnModel().getColumn(4).setPreferredWidth(300);
		tableList.getSelectionModel().addListSelectionListener(new
				ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						// TODO Auto-generated method stub
						int dialog = JOptionPane.YES_NO_OPTION;
						JOptionPane.showConfirmDialog(null, "Register?","Register", dialog);
						if(dialog == JOptionPane.YES_OPTION){
									
							String classtype;	 
						    classtype = (String)tableList.getValueAt(tableList.getSelectedRow(), 0);  
								System.out.println(classtype);
							Class c = new Class(m.getMemberid(),classtype);
							JPanel panel = new ClassesRegister(myFrame,m,c);
							myFrame.getContentPane().removeAll();
							myFrame.getContentPane().add(panel);
							myFrame.getContentPane().validate();
							myFrame.getContentPane().repaint();
						}
					} 
			
		});
		JScrollPane scrollPane = new JScrollPane(tableList);
		scrollPane.setBounds(0, 75, 750, 165);
		add(scrollPane);

	}
}
