package jday.ui.admin;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jday.entities.Member;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class UpdateFrame extends JFrame{
	
	private JPanel contentPane;
	private JFrame myFrame = null;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateFrame frame = new UpdateFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdateFrame() {
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateFrame.class.getResource("/images/110jday_logo.png")));
		myFrame = this;
		initialize();
	}
	

	
	private void initialize(){
		setBounds(175, 100, 450, 400);
		contentPane = new AddCourse(myFrame);
		contentPane.setSize(new Dimension(750, 500));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
