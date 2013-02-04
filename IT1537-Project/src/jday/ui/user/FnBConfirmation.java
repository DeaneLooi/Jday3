package jday.ui.user;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import jday.entities.FnB;
import jday.entities.Member;
import jday.util.BackgroundPanel;
import jday.util.FnBViewTableModel;

public class FnBConfirmation extends BackgroundPanel {


	public FnBConfirmation() {
		super();
	}

	public FnBConfirmation(JFrame f,Member mem,ArrayList<FnB>fnb) {
		this();
		myFrame = f;
		this.m = mem;
		

		setSize(750,500);
		setLayout(null);
		
		JLabel lbl = new JLabel("Summary");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lbl.setForeground(new Color(0,0,0));
		lbl.setBounds(480,-15,198,78);
		add(lbl);
		JTable table = new JTable();
		table.setBackground(new Color(216, 191, 216));;
		table.setRowHeight(30);
		ArrayList<FnB>list = new ArrayList<FnB>(fnb);
		FnBViewTableModel model = new FnBViewTableModel(list);
		table.setModel(model);
		table.setBounds(0,0,600,400);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(140, 110, 490, 300);
		add(scrollPane);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new FnBMain(myFrame,m);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
				
			}
		});
		btnNewButton.setOpaque(false);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(535, 440, 95, 30);
		add(btnNewButton);
	}
}
