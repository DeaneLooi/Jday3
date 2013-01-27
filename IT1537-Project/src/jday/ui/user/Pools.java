package jday.ui.user;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import jday.util.BackgroundPanel;


public class Pools extends BackgroundPanel {

	/**
	 * Create the panel.
	 */
	public Pools() {
		super();
		initialize();
	}
	
	public Pools(JFrame f){
		this();
		myFrame = f;
	}
	
	private void initialize(){
		setOpaque(false);
		setSize(new Dimension(750, 500));
		setLayout(null);
		
		JLabel lblPoolSlide = new JLabel("poolPic");
		lblPoolSlide.setIcon(new ImageIcon(Pools.class.getResource("/images/poolslide.jpg")));
		lblPoolSlide.setBackground(Color.WHITE);
		lblPoolSlide.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblPoolSlide.setBounds(86, 99, 582, 250);
		add(lblPoolSlide);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new Pools2(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		btnNewButton.setOpaque(false);
		btnNewButton.setBounds(579, 426, 89, 23);
		add(btnNewButton);
		
		JTextArea txtrDescription = new JTextArea();
		txtrDescription.setOpaque(false);
		txtrDescription.setFont(new Font("Candara", Font.PLAIN, 16));
		txtrDescription.setEditable(false);
		txtrDescription.setText("The height of the slide is 2.5m. The length is 3.5m. The pool with slide is \r\nthe best place for kids.");
		txtrDescription.setBounds(86, 394, 582, 55);
		add(txtrDescription);
		
		JLabel lblPoolSlide_1 = new JLabel("Pool - Slide");
		lblPoolSlide_1.setForeground(new Color(0, 0, 0));
		lblPoolSlide_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblPoolSlide_1.setBounds(86, 61, 115, 27);
		add(lblPoolSlide_1);
		
		JLabel lblNewLabel = new JLabel("Description");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(153, 51, 153));
		lblNewLabel.setBounds(86, 360, 157, 23);
		add(lblNewLabel);

	}
}
