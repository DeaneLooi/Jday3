
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

import jday.util.BackgroundPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Pools3 extends BackgroundPanel {

	/**
	 * Create the panel.
	 */
	public Pools3() {
		super();
		initialize();
	}
	
	public Pools3(JFrame f){
		this();
		myFrame = f;
	}
	
	private void initialize(){
		setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		setSize(new Dimension(750, 500));
		setLayout(null);
		
		JLabel label = new JLabel("poolPic");
		label.setIcon(new ImageIcon(Pools3.class.getResource("/images/pool.png")));
		label.setBorder(new LineBorder(new Color(0, 0, 0)));
		label.setBackground(Color.WHITE);
		label.setBounds(91, 75, 582, 259);
		add(label);
		
		JTextArea txtrDescriptionTheLength = new JTextArea();
		txtrDescriptionTheLength.setOpaque(false);
		txtrDescriptionTheLength.setFont(new Font("Candara", Font.PLAIN, 16));
		txtrDescriptionTheLength.setText("The length of the swimming pool is 50m (164 ft) and the width is 25m (82ft). \r\nThis is a standard Olympic size swimming pool. ");
		txtrDescriptionTheLength.setEditable(false);
		txtrDescriptionTheLength.setBounds(91, 379, 582, 55);
		add(txtrDescriptionTheLength);
		
		JButton button = new JButton("Previous");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new Pools2(myFrame);
				myFrame.getContentPane().removeAll();
				myFrame.getContentPane().add(panel);
				myFrame.getContentPane().validate();
				myFrame.getContentPane().repaint();
			}
		});
		button.setBounds(91, 445, 89, 23);
		add(button);
		
		JLabel lblPool = new JLabel("Pool");
		lblPool.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPool.setBounds(519, 0, 80, 38);
		add(lblPool);
		
		JLabel label_1 = new JLabel("Description");
		label_1.setOpaque(true);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBackground(new Color(153, 51, 153));
		label_1.setBounds(91, 345, 157, 23);
		add(label_1);

	}

}
