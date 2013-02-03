
package jday.ui.user;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.Font;

import jday.util.BackgroundPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Pools2 extends BackgroundPanel {

	/**
	 * Create the panel.
	 */
	public Pools2() {
		super();
		initialize();
	}
	
	public Pools2(JFrame f){
		this();
		myFrame = f;
	}
	
	private void initialize(){
		setSize(new Dimension(750, 500));
		setLayout(null);
		
		JLabel label = new JLabel("poolPic");
		label.setIcon(new ImageIcon(Pools2.class.getResource("/images/pooldiving.png")));
		label.setBorder(new LineBorder(new Color(0, 0, 0)));
		label.setBackground(Color.WHITE);
		label.setBounds(97, 81, 582, 262);
		add(label);
		
		JTextArea txtrDescription = new JTextArea();
		txtrDescription.setOpaque(false);
		txtrDescription.setFont(new Font("Candara", Font.PLAIN, 16));
		txtrDescription.setText("This is a pool with diving board. the height between the springboard and \r\nthe water surface is 1m (3.3 ft).");
		txtrDescription.setEditable(false);
		txtrDescription.setBounds(97, 390, 582, 55);
		add(txtrDescription);
		
		JButton button = new JButton("Previous");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new Pools(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		button.setBounds(97, 443, 89, 23);
		add(button);
		
		JButton button_1 = new JButton("Next");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new Pools3(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		button_1.setBounds(590, 443, 89, 23);
		add(button_1);
		
		JLabel lblPoolDiving = new JLabel("Pool - Diving");
		lblPoolDiving.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPoolDiving.setBounds(465, 0, 181, 38);
		add(lblPoolDiving);
		
		JLabel label_1 = new JLabel("Description");
		label_1.setOpaque(true);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBackground(new Color(153, 51, 153));
		label_1.setBounds(97, 357, 157, 23);
		add(label_1);

	}

}
