package jday.ui.user;

import java.awt.Color;
import java.awt.Font;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import jday.entities.Member;
import jday.util.BackgroundPanel;

public class Gym  extends BackgroundPanel{


	private Member m = null;
	private JList list;
	private JTextPane txtpnPersonal;
	private JTextPane txtpnPartner;
	private JTextPane txtpnWeight;
	
	public Gym(){
		super();
		initialize();
	}
	
	public Gym(JFrame f,Member m){
		this();
		this.m = m;
		myFrame = f;
	}
	private void initialize(){
		setSize(750,500);
		setLayout(null);
		
		JLabel lblGymProgrammes = new JLabel("Gym Programmes");
		lblGymProgrammes.setForeground(new Color(0, 0, 0));
		lblGymProgrammes.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblGymProgrammes.setBounds(426, 0, 253, 46);
		add(lblGymProgrammes);
		
		list = new JList();
		list.setForeground(new Color(0, 0, 0));
		list.setOpaque(false);
		list.setBounds(51, 103, 193, 92);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setLocation(81, 68);
		scrollPane.setSize(160, 70);
		add(scrollPane);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Personal Training","Partner Training","Weight Loss Program"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.setFont(new Font("Candara", Font.PLAIN, 16));
		list.setVisibleRowCount(3);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		txtpnPersonal = new JTextPane();
		txtpnPersonal.setOpaque(false);
		txtpnPersonal.setVisible(false);
		txtpnPersonal.setEditable(false);
		txtpnPersonal.setForeground(new Color(0, 0, 0));
		txtpnPersonal.setText("Fees: \t\r\n1 hour session $65\r\n1/2 hour session $40\r\nFitness Assessment $45\r\nPartner and group training sessions available\r\n\r\nFitness packages:\r\n(12 session package includes FREE fitness assessment and re-assessment after 36 sessions)\r\n(12) 1 hour sessions\t\t$655\r\n(12) 1/2 hour sessions\t$355\r\n\r\n(8) 1 hour session\t$475\r\n(8) 1/2 hour session $275\r\n\r\n(4) 1 hour sessions $255\r\n(4) 1/2 hour sessions $155");
		txtpnPersonal.setFont(new Font("Candara", Font.PLAIN, 16));
		txtpnPersonal.setBounds(337, 76, 342, 381);

		add(txtpnPersonal);
		
		txtpnPartner = new JTextPane();
		txtpnPartner.setOpaque(false);
		txtpnPartner.setVisible(false);
		txtpnPartner.setEditable(false);
		txtpnPartner.setForeground(new Color(0, 0, 0));
		txtpnPartner.setText("Partner Nutrition Counseling:\r\nInitial Visit \t\t$150\r\nFollow-up visit\t$75\r\n\r\nPartner Personal Training Packages (per person)\r\n(12 session package includes FREE fitness assessment and re-assessment after 36 sessions)\r\n(12) 1 hour sessions\t\t$325\r\n(12) 1/2 hour sessions\t$175\r\n\r\n(8) 1 hour session\t$235\r\n(8) 1/2 hour session $135\r\n\r\n(4) 1 hour sessions $125\r\n(4) 1/2 hour sessions $75");
		txtpnPartner.setFont(new Font("Candara", Font.PLAIN, 16));
		txtpnPartner.setBounds(337, 76, 342, 381);
		add(txtpnPartner);
		
		txtpnWeight = new JTextPane();
		txtpnWeight.setOpaque(false);
		txtpnWeight.setVisible(false);
		txtpnWeight.setText("Lose 1-3 Pounds per week with this successful program designed by Registered Dietitions and a Certified Personal Trainer. Receive a meal plan, exercise plan, education and exercise demonstrations. Weekly weigh-in and prizes for top 3 participants.\r\n\r\nEvery Tuesday Beginning March 13, 2012\r\n7.00-8.00pm Every Tuesday\r\n\r\n$25 per week or $200 if paid in full at first session ($50 savings)");
		txtpnWeight.setForeground(new Color(0, 0, 0));
		txtpnWeight.setFont(new Font("Candara", Font.PLAIN, 16));
		txtpnWeight.setEditable(false);
		txtpnWeight.setBounds(337, 76, 342, 381);
		add(txtpnWeight);
		
		JTextPane txtpnGymInformation = new JTextPane();
		txtpnGymInformation.setOpaque(false);
		txtpnGymInformation.setFont(new Font("Candara", Font.PLAIN, 16));
		txtpnGymInformation.setEditable(false);
		txtpnGymInformation.setForeground(new Color(0, 0, 0));
		txtpnGymInformation.setText("Gym Information:\r\n\r\nIsland Gym Operating Hours\r\nDaily,\t7:00am to 9:00pm\r\n\r\nBukit Gym Operating Hours\r\nMonday, Wednesday & Friday  -  6.30am to 9.30pm\r\nTuesday & Thursday - 7.00am to 9.30pm\r\nWeekends, eve of Public Holiday - 7.00am to 9.00pm");
		txtpnGymInformation.setBounds(81, 170, 200, 287);
		add(txtpnGymInformation);
		
		list.addListSelectionListener(
				new ListSelectionListener(){
					public void valueChanged(ListSelectionEvent e){
						
						if( list.getSelectedIndex()==0){
							txtpnPartner.setVisible(false);
							txtpnWeight.setVisible(false);
							txtpnPersonal.setVisible(true);
						}
						if(list.getSelectedIndex()==1){
							txtpnWeight.setVisible(false);
							txtpnPersonal.setVisible(false);
							txtpnPartner.setVisible(true);
						}
								if(list.getSelectedIndex()==2){
									txtpnPersonal.setVisible(false);
									txtpnPartner.setVisible(false);
									txtpnWeight.setVisible(true);
								}
					}
				}
				);

	}
}
