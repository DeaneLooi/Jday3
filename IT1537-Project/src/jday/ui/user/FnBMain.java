package jday.ui.user;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import jday.entities.FnB;
import jday.entities.Member;
import jday.util.BackgroundPanel;

public class FnBMain extends BackgroundPanel{


	private Member m = null;
	private JList list;
	private JPanel All;
	private JPanel Vegetarian;
	private JPanel Beef;
	private JPanel Chicken;
	private JPanel Fish;
	
	private JCheckBox chckbxMushroomSoup = new JCheckBox("Mushroom Soup");
	private JCheckBox chckbxChickenSoup = new JCheckBox("Chicken Soup");
	private JCheckBox chckbxChickenChop = new JCheckBox("Chicken Chop");
	private JCheckBox chckbxChickenCutlet = new JCheckBox("Chicken Cutlet");
	private JCheckBox chckbxFishNChips = new JCheckBox("Fish n Chips");
	private JCheckBox chckbxGrilledfish = new JCheckBox("GrilledFish");
	private JCheckBox chckbxRoastBeef = new JCheckBox("Roast Beef");
	private JCheckBox chckbxBeefSpaghetti = new JCheckBox("Beef Spaghetti");
	private JCheckBox chckbxBeeHoon = new JCheckBox("Bee Hoon");
	private JCheckBox chckbxFriedRice = new JCheckBox("Fried Rice");
	private JCheckBox chckbxCoke = new JCheckBox("Coke");
	private JCheckBox chckbxCheesecake = new JCheckBox("Cheesecake");
	
	public FnBMain() {
		super();
		initialize();
	
	}
	
	public FnBMain(JFrame f){
	this();
	myFrame = f;
}
	
	public FnBMain(JFrame f, Member m){
		super();
		myFrame = f;
		this.m = m;
		initialize();
	}
	
	private void initialize(){
		setSize(750,500);
		setLayout(null);
		JLabel lblFoodAndBeverages = new JLabel("Food and Beverages");
		lblFoodAndBeverages.setForeground(new Color(0, 0, 0));
		lblFoodAndBeverages.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoodAndBeverages.setFont(new Font("Trebuchet MS", Font.ITALIC, 18));
		lblFoodAndBeverages.setBounds(81, 22, 574, 39);
		add(lblFoodAndBeverages);
		
		JLabel lblPromotions = new JLabel("Promotions:");
		lblPromotions.setForeground(new Color(0, 0, 0));
		lblPromotions.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblPromotions.setHorizontalAlignment(SwingConstants.CENTER);
		lblPromotions.setBounds(48, 22, 168, 39);
		add(lblPromotions);
		
		
		JLabel lblpekingDuckbefore = new JLabel("<html>\r\n<style>\r\nspan{\r\ncolor :blue;\r\n}\r\n</style>\r\n<p>Peking Duck</p>\r\n<u>Before: $32.00<br>\r\n<p><span>After: <b>$27.00</b></u></p\r\n</html>");
		lblpekingDuckbefore.setForeground(new Color(0, 0, 0));
		lblpekingDuckbefore.setHorizontalTextPosition(SwingConstants.CENTER);
		lblpekingDuckbefore.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblpekingDuckbefore.setFont(new Font("Candara", Font.PLAIN, 16));
		lblpekingDuckbefore.setHorizontalAlignment(SwingConstants.LEFT);
		lblpekingDuckbefore.setVerticalAlignment(SwingConstants.TOP);
		lblpekingDuckbefore.setIcon(new ImageIcon(FnBMain.class.getResource("/images/pekingduck.jpg")));
		lblpekingDuckbefore.setBounds(34, 72, 206, 167);
		add(lblpekingDuckbefore);
		
		list = new JList();
		list.setForeground(new Color(0, 0, 0));
		list.setFont(new Font("Candara", Font.PLAIN, 16));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"All", "Vegetarian", "Beef", "Chicken", "Fish"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectedIndex(0);
		list.setVisibleRowCount(3);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setOpaque(false);
		list.setBounds(59, 233, 168, 186);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setOpaque(false);
		scrollPane.setLocation(48, 270);
		scrollPane.setSize(160, 100);
		add(scrollPane);

		
		JLabel lblMainMenu = new JLabel("Main Menu:");
		lblMainMenu.setForeground(new Color(0, 0, 0));
		lblMainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainMenu.setFont(new Font("Candara", Font.BOLD, 16));
		lblMainMenu.setBounds(34, 238, 174, 32);
		add(lblMainMenu);
		
		final JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<FnB>list = new ArrayList<FnB>();
				String scb = "";
				
				if(chckbxMushroomSoup.isSelected()){
					scb += chckbxMushroomSoup.getText()+"\n";
					FnB fnb1 = new FnB();
					fnb1.setFnborder(chckbxMushroomSoup.getText());
					fnb1.setQuantity(1);
					list.add(fnb1);
				}
				if(chckbxChickenSoup.isSelected()){
					scb += chckbxChickenSoup.getText()+"\n";
					FnB fnb1 = new FnB();
					fnb1.setFnborder(chckbxChickenSoup.getText());
					fnb1.setQuantity(1);
					list.add(fnb1);
				}
				if(chckbxChickenChop.isSelected()){
					scb += chckbxChickenChop.getText()+"\n";
					FnB fnb1 = new FnB();
					fnb1.setFnborder(chckbxChickenChop.getText());
					fnb1.setQuantity(1);
					list.add(fnb1);
				}
				if(chckbxChickenCutlet.isSelected()){
					scb += chckbxChickenCutlet.getText()+"\n";
					FnB fnb1 = new FnB();
					fnb1.setFnborder(chckbxChickenCutlet.getText());
					fnb1.setQuantity(1);
					list.add(fnb1);
				}
				if(chckbxFishNChips.isSelected()){
					scb += chckbxFishNChips.getText()+"\n";
					FnB fnb1 = new FnB();
					fnb1.setFnborder(chckbxFishNChips.getText());
					fnb1.setQuantity(1);
					list.add(fnb1);
				}
				if(chckbxGrilledfish.isSelected()){
					scb += chckbxGrilledfish.getText()+"\n";
					FnB fnb1 = new FnB();
					fnb1.setFnborder(chckbxGrilledfish.getText());
					fnb1.setQuantity(1);
					list.add(fnb1);
				}
				if(chckbxRoastBeef.isSelected()){
					scb += chckbxRoastBeef.getText()+"\n";
					FnB fnb1 = new FnB();
					fnb1.setFnborder(chckbxRoastBeef.getText());
					fnb1.setQuantity(1);
					list.add(fnb1);
				}
				if(chckbxBeefSpaghetti.isSelected()){
					scb += chckbxBeefSpaghetti.getText()+"\n";
					FnB fnb1 = new FnB();
					fnb1.setFnborder(chckbxBeefSpaghetti.getText());
					fnb1.setQuantity(1);
					list.add(fnb1);
				}
				if(chckbxBeeHoon.isSelected()){
					scb += chckbxBeeHoon.getText()+"\n";
					FnB fnb1 = new FnB();
					fnb1.setFnborder(chckbxBeeHoon.getText());
					fnb1.setQuantity(1);
					list.add(fnb1);
				}
				if(chckbxFriedRice.isSelected()){
					scb += chckbxFriedRice.getText()+"\n";
					FnB fnb1 = new FnB();
					fnb1.setFnborder(chckbxFriedRice.getText());
					fnb1.setQuantity(1);
					list.add(fnb1);
				}
				if(chckbxCoke.isSelected()){
					scb += chckbxCoke.getText()+"\n";
					FnB fnb1 = new FnB();
					fnb1.setFnborder(chckbxCoke.getText());
					fnb1.setQuantity(1);
					list.add(fnb1);
				}
				if(chckbxCheesecake.isSelected()){
					scb += chckbxCheesecake.getText()+"\n";
					FnB fnb1 = new FnB();
					fnb1.setFnborder(chckbxCheesecake.getText());
					fnb1.setQuantity(1);
					list.add(fnb1);
				}
			
				scb = new String("");

				JPanel panel = new FnBOrderQuantity(myFrame,list,m);
				myFrame .getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
		
			}
		});
		btnNext.setOpaque(false);
		btnNext.setForeground(new Color(0, 0, 0));
		btnNext.setFont(new Font("Candara", Font.PLAIN, 16));
		btnNext.setBounds(638, 347, 89, 23);
		add(btnNext);
		
		JButton btnViewMyOrder = new JButton("View my order");
		btnViewMyOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new FnBViewOrder(myFrame,m);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		btnViewMyOrder.setOpaque(false);
		btnViewMyOrder.setForeground(new Color(0, 0, 0));
		btnViewMyOrder.setFont(new Font("Candara", Font.PLAIN, 16));
		btnViewMyOrder.setBounds(552, 30, 160, 23);
		add(btnViewMyOrder);
		
		Vegetarian = new JPanel();
		Vegetarian.setOpaque(false);
		Vegetarian.setVisible(false);
		
		All = new JPanel();
		All.setBounds(272, 232, 356, 201);
		add(All);
		All.setOpaque(false);
		All.setVisible(true);
		All.setBackground(new Color(255, 255, 255));
		All.setLayout(null);
		
		chckbxMushroomSoup.setOpaque(false);
		chckbxChickenSoup.setOpaque(false);
		chckbxChickenChop.setOpaque(false);
		chckbxChickenCutlet.setOpaque(false);
		chckbxFishNChips.setOpaque(false);
		chckbxGrilledfish.setOpaque(false);
		chckbxRoastBeef.setOpaque(false);
		chckbxBeefSpaghetti.setOpaque(false);
		chckbxBeeHoon.setOpaque(false);
		chckbxFriedRice.setOpaque(false);
		chckbxCoke.setOpaque(false);
		chckbxCheesecake.setOpaque(false);
		
		chckbxMushroomSoup.setBounds(45, 10, 125, 23);
		chckbxChickenSoup.setBounds(45, 36, 115, 23);
		chckbxChickenChop.setBounds(45, 64, 115, 23);
		chckbxChickenCutlet.setBounds(45, 90, 115, 23);
		chckbxFishNChips.setBounds(45, 116, 115, 23);
		chckbxGrilledfish.setBounds(45, 142, 115, 23);
		chckbxRoastBeef.setBounds(201, 10, 115, 23);
		chckbxBeefSpaghetti.setBounds(201, 37, 115, 23);
		chckbxBeeHoon.setBounds(201, 65, 115, 23);
		chckbxFriedRice.setBounds(201, 91, 115, 23);
		chckbxCoke.setBounds(201, 117, 115, 23);
		chckbxCheesecake.setBounds(201, 143, 115, 23);
		All.add(chckbxMushroomSoup);
		All.add(chckbxChickenSoup);
		All.add(chckbxChickenChop);
		All.add(chckbxChickenCutlet);
		All.add(chckbxFishNChips);
		All.add(chckbxGrilledfish);
		All.add(chckbxRoastBeef);
		All.add(chckbxBeefSpaghetti);
		All.add(chckbxBeeHoon);
		All.add(chckbxFriedRice);
		All.add(chckbxCoke);
		All.add(chckbxCheesecake);
		Vegetarian.setBounds(272, 232, 356, 201);
		add(Vegetarian);
		Vegetarian.setLayout(null);

		Beef = new JPanel();
		Beef.setOpaque(false);
		Beef.setVisible(false);
		Beef.setBounds(272, 232, 356, 201);
		add(Beef);
		Beef.setLayout(null);
	
		Chicken = new JPanel();
		Chicken.setOpaque(false);
		Chicken.setVisible(false);
		Chicken.setBounds(272, 232, 356, 201);
		add(Chicken);
		Chicken.setLayout(null);

		Fish = new JPanel();
		Fish.setVisible(false);
		Fish.setOpaque(false);
		Fish.setBounds(272, 232, 356, 201);
		add(Fish);
		Fish.setLayout(null);

		list.addListSelectionListener(
				new ListSelectionListener(){
					public void valueChanged(ListSelectionEvent e){
						
						if( list.getSelectedIndex()==0){
							Vegetarian.setVisible(false);
							Beef.setVisible(false);
							Chicken.setVisible(false);
							Fish.setVisible(false);
							All.setVisible(true);
							chckbxMushroomSoup.setBounds(45, 10, 125, 23);
							chckbxChickenSoup.setBounds(45, 36, 115, 23);
							chckbxChickenChop.setBounds(45, 64, 115, 23);
							chckbxChickenCutlet.setBounds(45, 90, 115, 23);
							chckbxFishNChips.setBounds(45, 116, 115, 23);
							chckbxGrilledfish.setBounds(45, 142, 115, 23);
							chckbxRoastBeef.setBounds(201, 10, 115, 23);
							chckbxBeefSpaghetti.setBounds(201, 37, 115, 23);
							chckbxBeeHoon.setBounds(201, 65, 115, 23);
							chckbxFriedRice.setBounds(201, 91, 115, 23);
							chckbxCoke.setBounds(201, 117, 115, 23);
							chckbxCheesecake.setBounds(201, 143, 115, 23);
							All.add(chckbxMushroomSoup);
							All.add(chckbxChickenSoup);
							All.add(chckbxChickenChop);
							All.add(chckbxChickenCutlet);
							All.add(chckbxFishNChips);
							All.add(chckbxGrilledfish);
							All.add(chckbxRoastBeef);
							All.add(chckbxBeefSpaghetti);
							All.add(chckbxBeeHoon);
							All.add(chckbxFriedRice);
							All.add(chckbxCoke);
							All.add(chckbxCheesecake);
						}
						if(list.getSelectedIndex()==1){
							Vegetarian.setVisible(true);
							chckbxMushroomSoup.setBounds(45, 10, 125, 23);
							chckbxBeeHoon.setBounds(45, 38, 115, 23);
							chckbxFriedRice.setBounds(45, 66, 115, 23);
							Vegetarian.add(chckbxMushroomSoup);
							Vegetarian.add(chckbxBeeHoon);
							Vegetarian.add(chckbxFriedRice);
							Beef.setVisible(false);
							Chicken.setVisible(false);
							Fish.setVisible(false);
							All.setVisible(false);
						}
								if(list.getSelectedIndex()==2){
									Vegetarian.setVisible(false);
									Beef.setVisible(true);
									chckbxRoastBeef.setBounds(47, 10, 115, 23);
									chckbxBeefSpaghetti.setBounds(47, 37, 115, 23);
									Beef.add(chckbxRoastBeef);
									Beef.add(chckbxBeefSpaghetti);
									Chicken.setVisible(false);
									Fish.setVisible(false);
									All.setVisible(false);
								}
									if(list.getSelectedIndex()==3){
										Vegetarian.setVisible(false);
										Beef.setVisible(false);
										Chicken.setVisible(true);
										chckbxChickenSoup.setBounds(47, 9, 115, 23);
										chckbxChickenChop.setBounds(47, 37, 115, 23);
										chckbxChickenCutlet.setBounds(47, 65, 115, 23);
										Chicken.add(chckbxChickenChop);
										Chicken.add(chckbxChickenSoup);
										Chicken.add(chckbxChickenCutlet);
										Fish.setVisible(false);
										All.setVisible(false);
									}
										if(list.getSelectedIndex()==4){
											Vegetarian.setVisible(false);
											Beef.setVisible(false);
											Chicken.setVisible(false);
											Fish.setVisible(true);
											chckbxFishNChips.setBounds(47, 10, 115, 23);
											chckbxGrilledfish.setBounds(47, 37, 115, 23);
											Fish.add(chckbxFishNChips);
											Fish.add(chckbxGrilledfish);
											All.setVisible(false);
										}
					}
				}
				);

	}
}
