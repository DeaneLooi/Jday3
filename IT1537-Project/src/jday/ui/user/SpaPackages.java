package jday.ui.user;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import jday.util.BackgroundPanel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ButtonGroup;

public class SpaPackages extends BackgroundPanel {

	protected static final JComponent txtpnHarmonisingTheBody = null;
	protected static final JComponent textPane_3 = null;
	protected static final JComponent textPane_2 = null;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public SpaPackages() {
		super();
		initialize();
	}
	
	public SpaPackages(JFrame f){
		this();
		myFrame = f;
	}
	
	private void initialize(){
		setSize(new Dimension(750, 500));
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setLayout(null);
		
		JButton btnBookNow = new JButton("Book Now!");
		btnBookNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel panel = new SpaBooking(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		
		JLabel label = new JLabel("DESCRIPTION");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		label.setBackground(Color.BLACK);
		label.setBounds(461, 130, 103, 14);
		add(label);
		
		final JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setText("\r\n    Harmonising the body by unblocking the vital\r\n    energy, qi, experience the powerful effects of \r\n    Ginseng and feel the Balancing effects of this\r\n    traditional Chinese based treatment.\r\n\r\n \r\n    4 hours: SGD 460.00 (exclusive of taxes)");
		textPane_1.setFont(new Font("Candara", Font.PLAIN, 15));
		textPane_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textPane_1.setBackground(new Color(250, 235, 215));
		textPane_1.setAlignmentY(5.0f);
		textPane_1.setAlignmentX(3.0f);
		textPane_1.setBounds(358, 167, 320, 208);
		add(textPane_1);
		
		final JTextPane textPane_2 = new JTextPane();
		textPane_2.setText("\r\n  Based on Malay jamu philosophy, jamu herbal\r\n  remedies and massages emphasise on healing\r\n  from within. Be treated to traditional Indonesian\r\n  and Malay spa therapies.\r\n\r\n \r\n  2 hours 30 minutes: SGD 320.00 \r\n  (exclusive oftaxes)");
		textPane_2.setFont(new Font("Candara", Font.PLAIN, 15));
		textPane_2.setEditable(false);
		textPane_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textPane_2.setBackground(new Color(255, 204, 204));
		textPane_2.setAlignmentY(5.0f);
		textPane_2.setAlignmentX(3.0f);
		textPane_2.setBounds(358, 167, 320, 208);
		add(textPane_2);
		
		final JTextPane textPane_3 = new JTextPane();
		textPane_3.setText("\r\n Create your own Damai Experience from our a la carte menu. Choose from our a la carte  menu your preferred body scrub and massage, and complete your holistic treatment with  a healthy spa lunch at JDay Restaurant.\r\n\r\n \r\n 2 hours 30 minutes: SGD 300.00\r\n (exclusive of taxes)");
		textPane_3.setFont(new Font("Candara", Font.PLAIN, 15));
		textPane_3.setEditable(false);
		textPane_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textPane_3.setBackground(new Color(250, 235, 215));
		textPane_3.setAlignmentX(3.0f);
		textPane_3.setBounds(359, 167, 319, 208);
		add(textPane_3);
		
		final JTextPane textPane_4 = new JTextPane();
		textPane_4.setText("\r\n Unwind with luxurious treatments with your loved\r\n one in our exclusive couple\u2019s suite featuring an\r\n  indoor stone tub bathed in natural daylight. \r\n- Lemon Sugar Body Polish\r\n- Tranquility Bath\r\n- Targeted Healing Treatment\r\n\r\n  2 hours 30 minutes: SGD 600.00 per couple\r\n  (exclusive of taxes)");
		textPane_4.setFont(new Font("Candara", Font.PLAIN, 15));
		textPane_4.setEditable(false);
		textPane_4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textPane_4.setBackground(new Color(255, 204, 204));
		textPane_4.setAlignmentY(5.0f);
		textPane_4.setAlignmentX(3.0f);
		textPane_4.setBounds(358, 167, 320, 208);
		add(textPane_4);
		
		final JTextPane textPane_5 = new JTextPane();
		textPane_5.setText("\r\n  Planning a day at the spa? The Best of Friends\r\n  package is the perfect choice as both of you will\r\n  enjoy Damai\u2019s signature massage and facial, and\r\n  complete your afternoon with a healthy spa\r\n  lunch at JDay Restaurant.\r\n\r\n\r\n  3 hours: SGD 750.00 per couple\r\n  (exclusive of taxes)");
		textPane_5.setFont(new Font("Candara", Font.PLAIN, 15));
		textPane_5.setEditable(false);
		textPane_5.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textPane_5.setBackground(new Color(250, 235, 215));
		textPane_5.setAlignmentY(5.0f);
		textPane_5.setAlignmentX(3.0f);
		textPane_5.setBounds(359, 167, 319, 208);
		add(textPane_5);
		btnBookNow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBookNow.setOpaque(false);
		btnBookNow.setBounds(580, 431, 103, 35);
		add(btnBookNow);
		
		JLabel lblJdaysJourneyIndex = new JLabel("JDAY's Journey Index");
		lblJdaysJourneyIndex.setForeground(Color.BLACK);
		lblJdaysJourneyIndex.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblJdaysJourneyIndex.setBounds(37, 154, 173, 19);
		add(lblJdaysJourneyIndex);
		
		JLabel lblJdaysCoupleJourney = new JLabel("JDAY's Couple Journey Index");
		lblJdaysCoupleJourney.setForeground(Color.BLACK);
		lblJdaysCoupleJourney.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblJdaysCoupleJourney.setBounds(37, 298, 220, 19);
		add(lblJdaysCoupleJourney);
		
		JLabel lblSpaPackages = new JLabel("   SPA PACKAGES\r\n");
		lblSpaPackages.setIcon(new ImageIcon(SpaPackages.class.getResource("/images/Logo.png")));
		lblSpaPackages.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblSpaPackages.setBounds(26, 11, 265, 121);
		add(lblSpaPackages);
		
		JRadioButton rdbtnBalancingSpaPackage = new JRadioButton("Balancing Spa Package");
		rdbtnBalancingSpaPackage.setForeground(new Color(0, 0, 0));
		rdbtnBalancingSpaPackage.setBackground(new Color(250, 235, 215));
		rdbtnBalancingSpaPackage.setIcon(new ImageIcon(SpaPackages.class.getResource("/images/spa_and_wellness-horz.png")));
		rdbtnBalancingSpaPackage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnBalancingSpaPackage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textPane_1.setVisible(true);
				textPane_2.setVisible(false);
				textPane_3.setVisible(false);
				textPane_4.setVisible(false);
				textPane_5.setVisible(false);
			}
		});
		buttonGroup.add(rdbtnBalancingSpaPackage);
		rdbtnBalancingSpaPackage.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, null));
		rdbtnBalancingSpaPackage.setFont(new Font("Candara", Font.ITALIC, 16));
		rdbtnBalancingSpaPackage.setBounds(73, 194, 232, 29);
		add(rdbtnBalancingSpaPackage);
		
		JRadioButton rdbtnHealingSpaPackage = new JRadioButton("Healing Spa Package");
		rdbtnHealingSpaPackage.setForeground(new Color(0, 0, 0));
		rdbtnHealingSpaPackage.setBackground(new Color(255, 204, 255));
		rdbtnHealingSpaPackage.setIcon(new ImageIcon(SpaPackages.class.getResource("/images/spa_and_wellness-horz.png")));
		rdbtnHealingSpaPackage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnHealingSpaPackage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textPane_1.setVisible(false);
				textPane_2.setVisible(true);
				textPane_3.setVisible(false);
				textPane_4.setVisible(false);
				textPane_5.setVisible(false);
			}
		});
		buttonGroup.add(rdbtnHealingSpaPackage);
		rdbtnHealingSpaPackage.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		rdbtnHealingSpaPackage.setFont(new Font("Candara", Font.ITALIC, 16));
		rdbtnHealingSpaPackage.setBounds(73, 219, 232, 29);
		add(rdbtnHealingSpaPackage);
		
		JRadioButton rdbtnJdayExperience = new JRadioButton("JDAY Experience");
		rdbtnJdayExperience.setForeground(new Color(0, 0, 0));
		rdbtnJdayExperience.setBackground(new Color(250, 235, 215));
		rdbtnJdayExperience.setIcon(new ImageIcon(SpaPackages.class.getResource("/images/spa_and_wellness-horz.png")));
		rdbtnJdayExperience.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnJdayExperience.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textPane_1.setVisible(false);
				textPane_2.setVisible(false);
				textPane_3.setVisible(true);
				textPane_4.setVisible(false);
				textPane_5.setVisible(false);
			}
		});
		buttonGroup.add(rdbtnJdayExperience);
		rdbtnJdayExperience.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		rdbtnJdayExperience.setFont(new Font("Candara", Font.ITALIC, 16));
		rdbtnJdayExperience.setBounds(73, 245, 232, 29);
		add(rdbtnJdayExperience);
		
		JRadioButton rdbtnBerduadua = new JRadioButton("Berdua-Dua");
		rdbtnBerduadua.setForeground(new Color(0, 0, 0));
		rdbtnBerduadua.setBackground(new Color(250, 235, 215));
		rdbtnBerduadua.setIcon(new ImageIcon(SpaPackages.class.getResource("/images/spa_and_wellness-horz.png")));
		rdbtnBerduadua.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnBerduadua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textPane_1.setVisible(false);
				textPane_2.setVisible(false);
				textPane_3.setVisible(false);
				textPane_4.setVisible(true);
				textPane_5.setVisible(false);
			}
		});
		buttonGroup.add(rdbtnBerduadua);
		rdbtnBerduadua.setFont(new Font("Candara", Font.ITALIC, 16));
		rdbtnBerduadua.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		rdbtnBerduadua.setBounds(73, 340, 232, 29);
		add(rdbtnBerduadua);
		
		JRadioButton rdbtnBestOfFriends = new JRadioButton("Best of Friends");
		rdbtnBestOfFriends.setForeground(new Color(0, 0, 0));
		rdbtnBestOfFriends.setBackground(new Color(255, 204, 255));
		rdbtnBestOfFriends.setIcon(new ImageIcon(SpaPackages.class.getResource("/images/spa_and_wellness-horz.png")));
		rdbtnBestOfFriends.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnBestOfFriends.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textPane_1.setVisible(false);
				textPane_2.setVisible(false);
				textPane_3.setVisible(false);
				textPane_4.setVisible(false);
				textPane_5.setVisible(true);
			}
		});
		buttonGroup.add(rdbtnBestOfFriends);
		rdbtnBestOfFriends.setFont(new Font("Candara", Font.ITALIC, 16));
		rdbtnBestOfFriends.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		rdbtnBestOfFriends.setBounds(73, 367, 232, 29);
		add(rdbtnBestOfFriends);

	}
}
