package jday.ui.user;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import jday.entities.Admin;
import jday.entities.Member;
import jday.ui.admin.AdminMainframe;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private JFrame myFrame = null;
	private JPanel jContentPane = null;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenuServices = null;
	private JMenu jMenuFacilities = null;
	private JMenu jMenuLifestyle = null;
	private JMenu jMenuGolf = null;
	private JMenu jMenuBanquet = null;
	private JMenu jMenuEvent = null;
	private JMenu jMenuLogout;
	private JMenu jMenuMemberId;
	private JMenuItem jMenuItemChangePin;
	private JMenuItem jMenuItemRooms;
	private JMenuItem jMenuItemPackages;
	private JMenuItem jMenuItemCourses;
	private JMenuItem jMenuItemSPA;
	private JMenuItem jMenuItemKaraoke;
	private JMenuItem jMenuItemSports;
	private JMenuItem jMenuItemGym;
	private JMenuItem jMenuItemPool;
	private JMenuItem jMenuItemRoomService;
	private JMenuItem jMenuItemFB;
	private JMenuItem jMenuItemDayCare;
	private JMenuItem jMenuItemTaxi;
	private JMenuBar menuBar;
	private JMenu menu;
	private JSeparator separator;
	private Member m = null;
	private JMenuItem mntmProfile;
	private JMenuItem mntmBooking;
	
	public MainFrame(){
		super();
		myFrame=this;
		initialize();
	}
	
	public MainFrame(Member m){
		super();
		myFrame = this;
		this.m = m;
		initialize();
	}

	private void initialize() {
		this.setBounds(0, 0, 800, 600);
		this.setJMenuBar(getJJMenuBar());
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/images/90logo.png")));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("JDAY");
	}


	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame thisClass= new MainFrame();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				thisClass.setVisible(true);
				
				
			}

				
			
		});
	}


	
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			jContentPane = new EventCalendar(myFrame,m);


		}
		return jContentPane;
	}

	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.setBackground(Color.DARK_GRAY);
			jJMenuBar.setMargin(new Insets(5, 50, 5, 50));
			jJMenuBar.add(getJMenuServices());
			jJMenuBar.add(getJMenuFacilities());
			jJMenuBar.add(getJMenuLifestyle());
			jJMenuBar.add(getJMenuGolf());
			jJMenuBar.add(getJMenuBanquet());
			jJMenuBar.add(getJMenuEvent());
			jJMenuBar.add(getSeparator());
			jJMenuBar.add(getJMenuMemberId());
			jJMenuBar.add(getJMenuLogout());


		}
		return jJMenuBar;
	}
	


	private JMenu getJMenuServices() {
		if (jMenuServices == null) {
			jMenuServices = new JMenu();
			jMenuServices.setForeground(new Color(255, 255, 255));
			jMenuServices.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
			jMenuServices.setText("Services");
			//jMenuServices.add(getJMenuItemRoomService());
			jMenuServices.add(getJMenuItemFB());
			//jMenuServices.add(getJMenuItemDayCare());
			jMenuServices.add(getJMenuItemTaxi());
		}
		return jMenuServices;
	}

	private JMenu getJMenuFacilities() {
		if (jMenuFacilities == null) {
			jMenuFacilities = new JMenu();
			jMenuFacilities.setForeground(new Color(255, 255, 255));
			jMenuFacilities.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
			jMenuFacilities.setText("Facilities");
			jMenuFacilities.add(getJMenuItemSports());
			jMenuFacilities.add(getJMenuItemGym());
			jMenuFacilities.add(getJMenuItemPool());
		}
		return jMenuFacilities;
	}

	private JMenu getJMenuLifestyle() {
		if (jMenuLifestyle == null) {
			jMenuLifestyle = new JMenu();
			jMenuLifestyle.setForeground(new Color(255, 255, 255));
			jMenuLifestyle.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
			jMenuLifestyle.setText("Lifestyle");
			jMenuLifestyle.add(getJMenuItemCourses());
			jMenuLifestyle.add(getJMenuItemSPA());
			jMenuLifestyle.add(getJMenuItemKaraoke());
		}
		return jMenuLifestyle;
	}

	private JMenu getJMenuGolf() {
		if (jMenuGolf == null) {
			jMenuGolf = new JMenu();
			jMenuGolf.setForeground(new Color(255, 255, 255));
			jMenuGolf.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
			jMenuGolf.setText("Golf");
			jMenuGolf.addMenuListener(new MenuListener(){
				public void menuSelected(MenuEvent e){
					JPanel panel = new GolfingInfo(myFrame,m);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
					
				}

				@Override
				public void menuCanceled(MenuEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void menuDeselected(MenuEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			}
		return jMenuGolf;
		
	}

	private JMenu getJMenuBanquet() {
		if (jMenuBanquet == null) {
			jMenuBanquet = new JMenu();
			jMenuBanquet.setForeground(new Color(255, 255, 255));
			jMenuBanquet.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
			jMenuBanquet.setText("Banquet");
			jMenuBanquet.add(getJMenuItemRooms());
			jMenuBanquet.add(getJMenuItemPackages());
		}
		return jMenuBanquet;
	}

	private JMenu getJMenuEvent() {
		if (jMenuEvent == null) {
			jMenuEvent = new JMenu();
			jMenuEvent.setForeground(new Color(255, 255, 255));
			jMenuEvent.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
			jMenuEvent.setText("Event");
			jMenuEvent.addMenuListener(new MenuListener(){
				public void menuSelected(MenuEvent e){
					JPanel panel = new EventCalendar();
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
					
				}

				@Override
				public void menuCanceled(MenuEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void menuDeselected(MenuEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			

		}
		return jMenuEvent;
	}

	
	private JMenu getJMenuLogout() {
		if (jMenuLogout == null) {
			jMenuLogout = new JMenu("Logout");
			jMenuLogout.setForeground(new Color(255, 255, 255));
			jMenuLogout.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
			jMenuLogout.addMenuListener(new MenuListener(){
				public void menuSelected(MenuEvent e){
					myFrame.setVisible(false);
					myFrame = new LoginFrame();
					myFrame.setVisible(true);
				}

				@Override
				public void menuCanceled(MenuEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void menuDeselected(MenuEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		return jMenuLogout;
	}
	private JMenu getJMenuMemberId() {
		if (jMenuMemberId == null) {
			jMenuMemberId = new JMenu(m.getMemberid());
			jMenuMemberId.setForeground(new Color(255, 255, 255));
			jMenuMemberId.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
			jMenuMemberId.add(getMntmProfile());
			jMenuMemberId.add(getJMenuItemChangePin());
			jMenuMemberId.addMenuListener(new MenuListener(){
				public void menuSelected(MenuEvent e){
					if(m instanceof Admin){
					myFrame.setVisible(false);
					myFrame = new AdminMainframe(m);
					myFrame.setVisible(true);
					}
				}
				@Override
				public void menuCanceled(MenuEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void menuDeselected(MenuEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			
			//jMenuMemberId.add(getMntmBooking());
		}
		return jMenuMemberId;
	}



	private JMenuItem getJMenuItemRoomService() {
		if (jMenuItemRoomService == null) {
			jMenuItemRoomService = new JMenuItem("Room Service");
			jMenuItemRoomService.setForeground(new Color(0, 0, 0));
			jMenuItemRoomService.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));

		}
		return jMenuItemRoomService;
	}
	private JMenuItem getJMenuItemFB() {
		if (jMenuItemFB == null) {
			jMenuItemFB = new JMenuItem("F & B");
			jMenuItemFB.setForeground(new Color(0, 0, 0));
			jMenuItemFB.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
			jMenuItemFB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel panel = new FnBMain(myFrame,m);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint(); 
				}
			});
		}
		return jMenuItemFB;
	}
	private JMenuItem getJMenuItemDayCare() {
		if (jMenuItemDayCare == null) {
			jMenuItemDayCare = new JMenuItem("Day Care");
			jMenuItemDayCare.setForeground(new Color(0, 0, 0));
			jMenuItemDayCare.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));

		}
		return jMenuItemDayCare;
	}
	private JMenuItem getJMenuItemTaxi() {
		if (jMenuItemTaxi == null) {
			jMenuItemTaxi = new JMenuItem("Taxi");
			jMenuItemTaxi.setBackground(new Color(221, 160, 221));
			jMenuItemTaxi.setForeground(new Color(0, 0, 0));
			jMenuItemTaxi.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
			jMenuItemTaxi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel panel = new TaxiBooking(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint(); 
				}
			});
			}
		return jMenuItemTaxi;
	}
	
	private JMenuItem getJMenuItemSports() {
		if (jMenuItemSports == null) {
			jMenuItemSports = new JMenuItem("Sports");
			jMenuItemSports.setForeground(new Color(0, 0, 0));
			jMenuItemSports.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
			jMenuItemSports.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel panel = new SportInfo(myFrame,m);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint(); 
				}
			});
	
		}
		return jMenuItemSports;
	}
	private JMenuItem getJMenuItemGym() {
		if (jMenuItemGym == null) {
			jMenuItemGym = new JMenuItem("Gym");
			jMenuItemGym.setBackground(new Color(221, 160, 221));
			jMenuItemGym.setForeground(new Color(0, 0, 0));
			jMenuItemGym.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
			jMenuItemGym.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JPanel panel = new Gym(myFrame,m);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
		}
		return jMenuItemGym;
	}
	private JMenuItem getJMenuItemPool() {
		if (jMenuItemPool == null) {
			jMenuItemPool = new JMenuItem("Pool");
			jMenuItemPool.setForeground(new Color(0, 0, 0));
			jMenuItemPool.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
			jMenuItemPool.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel panel = new Pools(myFrame);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint(); 
				}
			});

		}
		return jMenuItemPool;
	}
	
	private JMenuItem getJMenuItemCourses() {
		if (jMenuItemCourses == null) {
			jMenuItemCourses = new JMenuItem("Courses");
			jMenuItemCourses.setForeground(new Color(0, 0, 0));
			jMenuItemCourses.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
			jMenuItemCourses.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel panel = new Courses(myFrame,m);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
		}
		return jMenuItemCourses;
	}
	private JMenuItem getJMenuItemSPA() {
		if (jMenuItemSPA == null) {
			jMenuItemSPA = new JMenuItem("SPA");
			jMenuItemSPA.setBackground(new Color(221, 160, 221));
			jMenuItemSPA.setForeground(new Color(0, 0, 0));
			jMenuItemSPA.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
			jMenuItemSPA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel panel = new SpaPackages(myFrame,m);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint(); 
				}
			});

		}
		return jMenuItemSPA;
	}
	private JMenuItem getJMenuItemKaraoke() {
		if (jMenuItemKaraoke == null) {
			jMenuItemKaraoke = new JMenuItem("Karaoke");
			jMenuItemKaraoke.setForeground(new Color(0, 0, 0));
			jMenuItemKaraoke.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
			jMenuItemKaraoke.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel panel = new KaraokeRegular(myFrame,m);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint(); 
				}
			});

		}
		return jMenuItemKaraoke;
	}
	
	private JMenuItem getJMenuItemRooms() {
		if (jMenuItemRooms == null) {
			jMenuItemRooms = new JMenuItem("Rooms");
			jMenuItemRooms.setForeground(new Color(0, 0, 0));
			jMenuItemRooms.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
			jMenuItemRooms.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel panel = new Rooms(myFrame,m);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint(); 
				}
			});
		}
		return jMenuItemRooms;
	}
	private JMenuItem getJMenuItemPackages() {
		if (jMenuItemPackages == null) {
			jMenuItemPackages = new JMenuItem("Packages");
			jMenuItemPackages.setBackground(new Color(221, 160, 221));
			jMenuItemPackages.setForeground(new Color(0, 0, 0));
			jMenuItemPackages.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
			jMenuItemPackages.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel panel = new Packages(myFrame,m);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint(); 
				}
			});
		}
		return jMenuItemPackages;
	}
	
	private JMenuItem getJMenuItemChangePin() {
		if (jMenuItemChangePin == null) {
			jMenuItemChangePin = new JMenuItem("Change Pin");
			jMenuItemChangePin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel panel = new ChangePinPanel(myFrame,m);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint();
				}
			});
			jMenuItemChangePin.setBackground(new Color(221, 160, 221));
			jMenuItemChangePin.setForeground(new Color(0, 0, 0));
			jMenuItemChangePin.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		}
		return jMenuItemChangePin;
	}


	private JMenuItem getMntmProfile() {
		if (mntmProfile == null) {
			mntmProfile = new JMenuItem("Profile");

			mntmProfile.setForeground(new Color(0, 0, 0));
			mntmProfile.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
			mntmProfile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JPanel panel = new EditProfilePanel(myFrame,m);
					myFrame.getContentPane().removeAll();
					myFrame.getContentPane().add(panel);
					myFrame.getContentPane().validate();
					myFrame.getContentPane().repaint(); 
				}
			});
		}
		return mntmProfile;
	}
	private JMenuItem getMntmBooking() {
		if (mntmBooking == null) {
			mntmBooking = new JMenuItem("Booking");

			mntmBooking.setForeground(new Color(0, 0, 0));
			mntmBooking.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
			
		}
		return mntmBooking;
	}
	
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setOrientation(SwingConstants.VERTICAL);
		}
		return separator;
	}
	
	
}
