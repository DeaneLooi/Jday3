package jday.ui.user;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import jday.util.BackgroundPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class KaraokeRegular extends BackgroundPanel /* BackgroundPanel */{
	private final ButtonGroup buttonGroup = new ButtonGroup();
	protected static final JComponent txtpnRoomTypeCorporate = null;
	protected static final JComponent txtpnRoomTypeFamily = null;
	protected static final JComponent txtpnRoomTypeFriends = null;
	
	/**
	 * Create the panel.
	 */
	public KaraokeRegular() {
		super();
		initialize();
	}

	public KaraokeRegular(JFrame f) {
		this();
		myFrame = f;
	}

	private void initialize() {
		setSize(new Dimension(750, 500));
		setLayout(null);

		JLabel lblKaraokeRooms = new JLabel("KARAOKE ROOMS");
		lblKaraokeRooms.setIcon(new ImageIcon(KaraokeRegular.class
				.getResource("/images/microphone.png")));
		lblKaraokeRooms.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblKaraokeRooms.setBounds(12, -14, 286, 155);
		add(lblKaraokeRooms);

		JButton button = new JButton("Book Now!");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel panel = new KaraokeBooking(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setOpaque(false);
		button.setBounds(116, 445, 95, 32);
		add(button);
		
				final JTextPane txtpnRoomTypeCorporate_1 = new JTextPane();
				txtpnRoomTypeCorporate_1.setText("\r\nRoom Type\t: \tCorporate Room\r\nNo. of Person :\t5 - 7 pax\r\n\r\nJDAY Lunch :  11 pm - 2 pm\r\n$15++ or  $20++\r\n3 set Lunch + 3 Soft Drinks/Hot Drinks\r\n\r\nJDAY Happy : 2 pm - 7 pm\r\n$14++ or $19++\r\n4 Standard Drinks Per Pax\r\n\r\nJDAY Dinner : 6 pm - 10 pm\r\n$30++ or $54 ++\r\n4 set Dinner + 4 Standard Drink");
				txtpnRoomTypeCorporate_1.setFont(new Font("Candara", Font.PLAIN, 15));
				txtpnRoomTypeCorporate_1.setEditable(false);
				txtpnRoomTypeCorporate_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED,null, null, null, null));
				txtpnRoomTypeCorporate_1.setBackground(new Color(250, 235, 215));
				txtpnRoomTypeCorporate_1.setAlignmentY(5.0f);
				txtpnRoomTypeCorporate_1.setAlignmentX(3.0f);
				txtpnRoomTypeCorporate_1.setBounds(12, 125, 286, 312);
				add(txtpnRoomTypeCorporate_1);

		final JTextPane txtpnRoomTypeFamily = new JTextPane();
		txtpnRoomTypeFamily.setText("\r\nRoom Type\t: \tFamily Room\r\nNo. of Person :\t4 - 6 pax\r\n\r\nJDAY Lunch :  11 pm - 2 pm\r\n$13++ or  $18++\r\n2 set Lunch + 3 Soft Drinks/Hot Drinks\r\n\r\nJDAY Happy : 2 pm - 7 pm\r\n$10++ or $14++\r\n2 Standard Drinks Per Pax\r\n\r\nJDAY Dinner : 6 pm - 10 pm\r\n$30++ or $54 ++\r\n4 set Dinner + 4 Standard Drink");
		txtpnRoomTypeFamily.setFont(new Font("Candara", Font.PLAIN, 15));
		txtpnRoomTypeFamily.setEditable(false);
		txtpnRoomTypeFamily.setBorder(new SoftBevelBorder(BevelBorder.LOWERED,null, null, null, null));
		txtpnRoomTypeFamily.setBackground(new Color(250, 235, 215));
		txtpnRoomTypeFamily.setAlignmentY(5.0f);
		txtpnRoomTypeFamily.setAlignmentX(3.0f);
		txtpnRoomTypeFamily.setBounds(12, 125, 286, 312);
		add(txtpnRoomTypeFamily);

		final JTextPane txtpnRoomTypeFriends = new JTextPane();
		txtpnRoomTypeFriends.setText("\r\nRoom Type\t: \tFriends Room\r\nNo. of Person :\t2 - 4 pax\r\n\r\nJDAY Lunch :  11 pm - 2 pm\r\n$9++ or  $12++\r\n1 set Lunch + 1 Soft Drinks/Hot Drinks\r\n\r\nJDAY Happy : 2 pm - 7 pm\r\n$13++ or $16++\r\n2 Standard Drinks Per Pax\r\n\r\nJDAY Dinner : 6 pm - 10 pm\r\n$19++ or $23 ++\r\n1 set Dinner + 1 Standard Drink");
		txtpnRoomTypeFriends.setFont(new Font("Candara", Font.PLAIN, 15));
		txtpnRoomTypeFriends.setEditable(false);
		txtpnRoomTypeFriends.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtpnRoomTypeFriends.setBackground(new Color(250, 235, 215));
		txtpnRoomTypeFriends.setAlignmentY(5.0f);
		txtpnRoomTypeFriends.setAlignmentX(3.0f);
		txtpnRoomTypeFriends.setBounds(12, 125, 286, 312);
		add(txtpnRoomTypeFriends);

		JRadioButton rdbtnCorporateRoom = new JRadioButton("            Corporate Room");
		rdbtnCorporateRoom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtpnRoomTypeCorporate_1.setVisible(true);
				txtpnRoomTypeFamily.setVisible(false);
				txtpnRoomTypeFriends.setVisible(false);
			}
		});
		rdbtnCorporateRoom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonGroup.add(rdbtnCorporateRoom);
		rdbtnCorporateRoom.setFont(new Font("Candara", Font.PLAIN, 16));
		rdbtnCorporateRoom.setOpaque(false);
		rdbtnCorporateRoom.setIcon(new ImageIcon(KaraokeRegular.class.getResource("/images/BusinessRoom.png")));
		rdbtnCorporateRoom.setBounds(329, 18, 385, 150);
		add(rdbtnCorporateRoom);

		JRadioButton rdbtnFamilyRoom = new JRadioButton("           Family Room");
		rdbtnFamilyRoom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtpnRoomTypeCorporate_1.setVisible(false);
				txtpnRoomTypeFamily.setVisible(true);
				txtpnRoomTypeFriends.setVisible(false);
			}
		});
		rdbtnFamilyRoom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonGroup.add(rdbtnFamilyRoom);
		rdbtnFamilyRoom.setOpaque(false);
		rdbtnFamilyRoom.setIcon(new ImageIcon(KaraokeRegular.class.getResource("/images/FamilyRoom.png")));
		rdbtnFamilyRoom.setFont(new Font("Candara", Font.PLAIN, 16));
		rdbtnFamilyRoom.setBounds(329, 178, 385, 150);
		add(rdbtnFamilyRoom);

		JRadioButton rdbtnFriendsRoom = new JRadioButton("           Friends Room");
		rdbtnFriendsRoom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtpnRoomTypeCorporate_1.setVisible(false);
				txtpnRoomTypeFamily
				.setVisible(false);
				txtpnRoomTypeFriends.setVisible(true);
			}
		});
		rdbtnFriendsRoom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonGroup.add(rdbtnFriendsRoom);
		rdbtnFriendsRoom.setIcon(new ImageIcon(KaraokeRegular.class.getResource("/images/FriendsRoom.png")));
		rdbtnFriendsRoom.setFont(new Font("Candara", Font.PLAIN, 16));
		rdbtnFriendsRoom.setOpaque(false);
		rdbtnFriendsRoom.setBounds(329, 343, 385, 144);
		add(rdbtnFriendsRoom);

		// changing info
		/*final JRadioButton rdbtn = new JRadioButton();
		rdbtn.addSelectionListener(new SelectionListener() {
			public void valueChanged(rdbtnSelectionEvent e) {

				if (rdbtn.getSelectedIndex() == 0) {
					txtpnRoomTypeCorporate.setVisible(true);
					txtpnRoomTypeFamily.setVisible(false);
					txtpnRoomTypeFriends.setVisible(false);
				}
				if (rdbtn.getSelectedIndex() == 1) {
					txtpnRoomTypeCorporate.setVisible(false);
					txtpnRoomTypeFamily.setVisible(true);
					txtpnRoomTypeFriends.setVisible(false);
				}
				if (rdbtn.getSelectedIndex() == 2) {
					txtpnRoomTypeCorporate.setVisible(false);
					txtpnRoomTypeFamily.setVisible(false);
					txtpnRoomTypeFriends.setVisible(true);
				}
			}
		});*/

	}

}
