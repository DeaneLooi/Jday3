package jday.ui.user;

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
import jday.util.FnBTableModel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;

public class FnBOrderQuantity extends BackgroundPanel{


	public FnBOrderQuantity(){
		super();

	} 
	public FnBOrderQuantity(JFrame f,ArrayList<FnB>fnb, Member mem){ 
		super();
		myFrame = f;
		ArrayList<FnB>list = new ArrayList<FnB>(fnb);
		this.m = mem;
		setSize(750,500);
		setLayout(null);
		final JTable tableList = new JTable(new FnBTableModel(list));
		tableList.setBackground(new Color(216, 191, 216));;
		tableList.setRowHeight(30);
		tableList.setBounds(0,0,510,165);
		tableList.setShowGrid(false);
		tableList.setShowVerticalLines(false);
		tableList.setShowGrid(false);
		tableList.setShowHorizontalLines(false);
		JScrollPane scrollPane = new JScrollPane(tableList);
		scrollPane.setBounds(140, 110, 490, 300);
		add(scrollPane);
	
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<FnB>fnb = new ArrayList<FnB>();
				for(int i=0; i<tableList.getRowCount();i++){
					FnB fnb1 = new FnB();
					String fnborder = (String)tableList.getValueAt(i, 0);
					int quantity = 0;
					if(tableList.isEditing()){
						String quant = (String) tableList.getValueAt(i, 1);
						if(quant != null)
						quantity = Integer.parseInt(quant);
					}
					else if(tableList.isEditing()!=true){
					quantity =((Integer)(tableList.getValueAt(i,1))).intValue();
					}
					fnb1.setFnborder(fnborder);
					fnb1.setQuantity(quantity);
					fnb.add(fnb1);
				}
				JPanel panel = new FnBDelivery(myFrame,fnb, m);
				myFrame .getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		btnConfirm.setFont(new Font("Candara", Font.BOLD, 16));
		btnConfirm.setBounds(535, 440, 95, 30);
		add(btnConfirm);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JPanel panel = new FnBMain(myFrame,m);
				myFrame .getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		btnBack.setFont(new Font("Candara", Font.BOLD, 16));
		btnBack.setBounds(400, 440, 95, 30);
		add(btnBack);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setForeground(Color.BLACK);
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblQuantity.setBounds(430, 5, 228, 39);
		add(lblQuantity);

	}
}
