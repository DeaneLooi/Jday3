package jday.ui.user;

import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Rectangle;
import javax.swing.JInternalFrame;

public class LoginFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private JFrame myFrame = null;
	private JPanel jContentPane = null;
	public LoginFrame(){
		super();
		myFrame=this;
		initialize();
	}

	public static void main(String[] args){
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				LoginFrame thisClass= new LoginFrame();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
				
				
			}

				
			
		});
	}


	private void initialize() {
		this.setBounds(25, 50, 750, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/images/90logo.png")));
		this.setContentPane(getJContentPane());
		this.setTitle("JDAY");
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane= new LoginPage(myFrame);
			jContentPane.setLayout(null);

		}
		return jContentPane;
	}


}
