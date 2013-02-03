package jday.util;

//package modrcon;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import jday.entities.Member;

/**
 * GradientPanel is a class with a gradient background.
 * Put your non-opaque objects over it and enjoy.
 *
 * @author Pyrite[1up]
 */
public class BackgroundPanel extends JPanel {
	  protected Member m = null;
	  protected JFrame myFrame = null;
	  private ImageIcon	imageicon =
	  new ImageIcon(getClass().getResource("/images/bg3.png"));
	  private Image backgroundImage;

	  public BackgroundPanel()  {
		  super();
	  }

	  public void paintComponent(Graphics g) {
		  backgroundImage = imageicon.getImage();
	    super.paintComponent(g);

	    // Draw the background image.
	    g.drawImage(backgroundImage, 0, 0, null);
	    setOpaque(false);
	  }
	}




 
  