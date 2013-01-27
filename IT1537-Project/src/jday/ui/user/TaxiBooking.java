package jday.ui.user;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.UIManager;
import java.awt.Dimension;
import java.io.IOException;

import jday.util.BackgroundPanel;

public class TaxiBooking  extends BackgroundPanel /*BackgroundPanel*/ {
	
	private JTable table;

	/**
	 * Create the panel.
	 */
	public TaxiBooking() {
		super();
		initialize();
	}
	
	public TaxiBooking(JFrame f){
		this();
		myFrame = f;
	}
	
	private void initialize(){
		setSize(new Dimension(750, 500));
		setLayout(null);
		
		JLabel lblImgComfort = new JLabel("");

		
		JLabel lblComfortDelgroWeb = new JLabel("Comfort Delgro");
		lblComfortDelgroWeb.setFocusable(false);
		lblComfortDelgroWeb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblComfortDelgroWeb.setForeground(new Color(51, 51, 255));
		lblComfortDelgroWeb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Runtime.getRuntime().exec("C:\\Program Files (x86)\\Internet Explorer\\iexplore.exe http://www.cdgtaxi.com.sg/commuters_service_rates.mvn");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JLabel lblSmrt_1 = new JLabel("SMRT");
		lblSmrt_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSmrt_1.setForeground(new Color(51, 51, 255));
		lblSmrt_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Runtime.getRuntime().exec("C:\\Program Files (x86)\\Internet Explorer\\iexplore.exe http://www.smrt.com.sg/Taxis/FaresSurcharges.aspx");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JLabel lblPremierTaxis_1 = new JLabel("Premier Taxis");
		lblPremierTaxis_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPremierTaxis_1.setForeground(new Color(51, 51, 255));
		lblPremierTaxis_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Runtime.getRuntime().exec("C:\\Program Files (x86)\\Internet Explorer\\iexplore.exe http://www.premiertaxi.com/our_commuters/taxi_fare.asp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		lblPremierTaxis_1.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 13));
		lblPremierTaxis_1.setBounds(607, 175, 84, 14);
		add(lblPremierTaxis_1);
		lblSmrt_1.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 13));
		lblSmrt_1.setBounds(414, 175, 38, 14);
		add(lblSmrt_1);
		lblComfortDelgroWeb.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 13));
		lblComfortDelgroWeb.setBounds(186, 175, 106, 14);
		add(lblComfortDelgroWeb);
		lblImgComfort.setIcon(new ImageIcon(TaxiBooking.class.getResource("/images/comfortCity.jpg")));
		lblImgComfort.setBounds(131, 26, 221, 112);
		add(lblImgComfort);
		
		JLabel lblImgSMRT = new JLabel("");
		lblImgSMRT.setBounds(334, 26, 204, 112);
		lblImgSMRT.setIcon(new ImageIcon(TaxiBooking.class.getResource("/images/SMRT.jpg")));
		add(lblImgSMRT);
		
		JLabel lblImgPremier = new JLabel("");
		lblImgPremier.setIcon(new ImageIcon(TaxiBooking.class.getResource("/images/PremierTaxi.jpg")));
		lblImgPremier.setBounds(536, 26, 190, 112);
		add(lblImgPremier);
		
		JLabel lblBookingNumber = new JLabel("Telephone No.");
		lblBookingNumber.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblBookingNumber.setForeground(UIManager.getColor("MenuItem.foreground"));
		lblBookingNumber.setBounds(36, 154, 84, 14);
		add(lblBookingNumber);
		
		JLabel lblWebsite = new JLabel("Website");
		lblWebsite.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblWebsite.setForeground(UIManager.getColor("MenuItem.foreground"));
		lblWebsite.setBounds(76, 174, 44, 14);
		add(lblWebsite);
		
		JLabel label_1 = new JLabel("Current Booking");
		label_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		label_1.setForeground(UIManager.getColor("MenuItem.foreground"));
		label_1.setBounds(28, 278, 94, 14);
		add(label_1);
		
		JLabel label_2 = new JLabel("Current Booking");
		label_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		label_2.setForeground(UIManager.getColor("MenuItem.foreground"));
		label_2.setBounds(26, 440, 94, 14);
		add(label_2);
		
		JLabel label_3 = new JLabel("Advance Booking");
		label_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		label_3.setForeground(UIManager.getColor("MenuItem.foreground"));
		label_3.setBounds(25, 310, 100, 14);
		add(label_3);
		
		JLabel label_4 = new JLabel("Advance Booking");
		label_4.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		label_4.setForeground(UIManager.getColor("MenuItem.foreground"));
		label_4.setBounds(24, 456, 93, 14);
		add(label_4);
		
		JLabel label_5 = new JLabel("Normal Taxis");
		label_5.setFont(new Font("Candara", Font.BOLD, 13));
		label_5.setBounds(177, 195, 84, 14);
		add(label_5);
		
		JLabel label_6 = new JLabel("Normal Taxis");
		label_6.setFont(new Font("Candara", Font.BOLD, 13));
		label_6.setBounds(395, 195, 84, 14);
		add(label_6);
		
		JLabel label_7 = new JLabel("Normal Taxis [SilverCab]");
		label_7.setFont(new Font("Candara", Font.BOLD, 13));
		label_7.setBounds(566, 195, 139, 14);
		add(label_7);
		
		JLabel label_8 = new JLabel("Limousine Taxis");
		label_8.setFont(new Font("Candara", Font.BOLD, 13));
		label_8.setBounds(183, 340, 99, 14);
		add(label_8);
		
		JLabel label_9 = new JLabel("Limousine Taxis");
		label_9.setFont(new Font("Candara", Font.BOLD, 13));
		label_9.setBounds(380, 340, 99, 14);
		add(label_9);
		
		JLabel label_10 = new JLabel("Limousine Taxis");
		label_10.setFont(new Font("Candara", Font.BOLD, 13));
		label_10.setBounds(574, 340, 99, 14);
		add(label_10);
		
		table = new JTable();
		table.setEnabled(false);
		table.setRequestFocusEnabled(false);
		table.setRowSelectionAllowed(false);
		table.setFont(new Font("Candara", Font.PLAIN, 12));
		table.setShowGrid(false);
		table.setShowHorizontalLines(false);
		table.setBackground(new Color(245, 245, 245));
		table.setShowVerticalLines(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{"                          6552 1111", "                         6555 3333", "                           6363 6888"},
				{"", "", ""},
				{null, null, null},
				{null, null, null},
				{"     Nissan Cedric", "    Nissan Cedric ", "    Nissan Cedric"},
				{"     Toyota Crown", "    Toyota Crown", "    Toyota Crown"},
				{"     Hyundai Sonata CRDI", "    SsyangYong Rodhius SV270 XDI", "    Toyota Wish"},
				{null, null, null},
				{"     $3.30 (Peak)", "    $3.30 (Peak)", "    $3.50 (Peak)"},
				{"     $2.30 (Non Peak)", "    $2.30 (Non Peak)", "    $2.50 (Non Peak)"},
				{"     $8.00", "    $8.00", "    $8.00"},
				{"", null, null},
				{null, null, null},
				{null, null, null},
				{"     Mercedes Benz E220 CDI (Prestige)", "    Mercedes Benz E220 CDI (Prestige)", "    SilverArrow Skoda Superb"},
				{"     Mercedes Benz 115 CDI [7-Seater]", "    London", "    SilverStarMercedes Benz E-220"},
				{null, null, "    SilverLux [MPV] Kia Carnival"},
				{null, "", null},
				{"     $10.00", "    $10.00", "    $10.00"},
				{"     $18.00", "    $18.00", "    $18.00"},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table.setBounds(131, 137, 596, 352);
		add(table);
		
		JLabel lblPremierTaxis = new JLabel("Premier Taxis");
		lblPremierTaxis.setForeground(SystemColor.textHighlight);
		lblPremierTaxis.setFont(new Font("Candara", Font.BOLD, 12));
		lblPremierTaxis.setBounds(613, 181, 114, 14);
		add(lblPremierTaxis);
		
		JLabel lblComfortDelgro = new JLabel("Comfort Delgro");
		lblComfortDelgro.setForeground(UIManager.getColor("Menu.selectionBackground"));
		lblComfortDelgro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblComfortDelgro.setFont(new Font("Candara", Font.BOLD, 12));
		lblComfortDelgro.setBounds(188, 181, 94, 14);
		add(lblComfortDelgro);
		
		JLabel lblSmrt = new JLabel("SMRT");
		lblSmrt.setForeground(SystemColor.textHighlight);
		lblSmrt.setFont(new Font("Candara", Font.BOLD, 12));
		lblSmrt.setBounds(422, 181, 94, 14);
		add(lblSmrt);

	}
}
