package jday.ui.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import jday.entities.Member;
import jday.util.BackgroundPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Date;

import org.freixas.jcalendar.JCalendar;
import javax.swing.border.MatteBorder;
import org.freixas.jcalendar.DateListener;
import org.freixas.jcalendar.DateEvent;

public class AUpdateEvent extends BackgroundPanel {
	private JFrame myFrame = null;

	/**
	 * Create the panel.
	 */
	public AUpdateEvent() {
		super();
	
	}

	public AUpdateEvent(JFrame f, Member m) {
		this();
		myFrame = f;
		this.m = m;
		initialize();
	}

	private void initialize() {
		setForeground(new Color(255, 255, 255));
		setFont(new Font("Arial", Font.PLAIN, 14));
		setBackground(new Color(204, 51, 153));
		setSize(new Dimension(750, 500));
		setLayout(null);

		JLabel label = new JLabel("logo");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JPanel panel = new AMainpage(myFrame,m);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();

			}
		});
		label.setIcon(new ImageIcon(AUpdateEvent.class.getResource("/images/90logo.png")));
		label.setBounds(45, 25, 94, 102);
		add(label);

		final JCalendar calendar = new JCalendar();
		calendar.addDateListener(new DateListener() {
			public void dateChanged(DateEvent arg0) {
				// when date clicked, get date and open panel
				Date date3 = calendar.getDate();
				// open next panel
				JPanel panel = new JPanel();
				try {
					panel = new AUpdateEvent2(myFrame, date3,m);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		calendar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 128, 128)));
		calendar.setBounds(61, 135, 666, 360);
		add(calendar);

		JLabel lblNewLabel = new JLabel("Edit Events");
		lblNewLabel.setForeground(new Color(102, 0, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(399, 0, 300, 45);
		add(lblNewLabel);

	}
}
