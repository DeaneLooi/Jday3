package jday.ui.user;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import jday.entities.FnB;
import jday.entities.Member;
import jday.util.BackgroundPanel;
import jday.util.FnBViewTableModel;

public class FnBViewOrder extends BackgroundPanel {

	
	public FnBViewOrder() {
		super();

	}
	public FnBViewOrder(JFrame f, Member mem) {
		this();
		myFrame = f;
		this.m = mem;
		setSize(750,500);
		setLayout(null);
		
		JTable table = new JTable();

		ArrayList<FnB>list = FnB.searchFnbOrder(mem.getMemberid());
		FnBViewTableModel model = new FnBViewTableModel(list);
		table.setModel(model);
		table.setBounds(0,0,600,400);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50,50,600,400);
		add(scrollPane);
		JButton btnClose = new JButton("close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new FnBMain(myFrame,m);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		btnClose.setOpaque(false);
		btnClose.setFont(new Font("Candara", Font.PLAIN, 16));
		btnClose.setForeground(new Color(0, 0, 0));
		btnClose.setBounds(342, 11, 89, 23);
		add(btnClose);
	}



}
