package jday.ui.admin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.lang.reflect.Member;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import jday.entities.FnB;
import jday.entities.FnB;
import jday.util.BackgroundPanel;
import jday.util.FnBTableModel;
import jday.util.FnBViewTableModel;

import javax.swing.JToggleButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ItemListener;

public class Kitchen extends BackgroundPanel {
	private JTable table;
	final JTable tableList = new JTable();

	public Kitchen() {
		super();
		initialize();
	}

	public Kitchen(JFrame f) {
		super();
		myFrame = f;
		initialize();
	}

	public Kitchen(JFrame f, Member m) {
		this();
		myFrame = f;
	}

	private void initialize() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(new TitledBorder(null, "JPanel title",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(-6, -16, 762, 523);
		add(panel);
		panel.setLayout(null);

		ArrayList<FnB> list = FnB.searchFnbOrder(null);
		FnBViewTableModel model = new FnBViewTableModel(list);

		JLabel lblMembersParticular = new JLabel("RESTAURANT ORDER SUMMARY");
		lblMembersParticular.setForeground(new Color(0, 0, 0));
		lblMembersParticular.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblMembersParticular.setBounds(419, 21, 268, 36);
		panel.add(lblMembersParticular);
		lblMembersParticular.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Timer timer = new Timer(3000, new ActionListener(){
					public void actionPerformed (ActionEvent arg0) {
						FnBViewTableModel model = new FnBViewTableModel(FnB.searchFnbOrder(null));
						tableList.setModel(model);
					}
				});
				timer.setRepeats(false);
				timer.start();
			}
		});
		btnRefresh.setOpaque(false);
		btnRefresh.setFont(new Font("Candara", Font.PLAIN, 12));
		btnRefresh.setBounds(90, 453, 86, 23);
		panel.add(btnRefresh);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					actionPerformedDelete();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDelete.setOpaque(false);
		btnDelete.setFont(new Font("Candara", Font.PLAIN, 12));
		btnDelete.setBounds(186, 453, 86, 23);
		panel.add(btnDelete);


		tableList.setModel(model);
		tableList.setBounds(0, 0, 600, 400);
		JScrollPane scrollPane = new JScrollPane(tableList);
		scrollPane.setBounds(78, 109, 642, 319);
		panel.add(scrollPane);
	}

	public void actionPerformedDelete() throws SQLException {
		int rowSelected = tableList.getSelectedRow();
		System.out.println(rowSelected);
		if (rowSelected >= 0) {
			String fnborder = tableList.getValueAt(rowSelected, 2).toString();
			int orderno = Integer.parseInt(fnborder);
			FnB orders = new FnB();
			orders.setBookingno(orderno);
			int dialog = JOptionPane.showConfirmDialog(null,"Are you sure you want to remove order?");
			if (dialog == JOptionPane.YES_OPTION)
				orders.deleteOrder();
			else
				orders = null;

			FnBViewTableModel model = new FnBViewTableModel(FnB.searchFnbOrder(null));
			tableList.setModel(model);

		}

		else
			JOptionPane.showMessageDialog(null, "No record Selected", "Alert", JOptionPane.ERROR_MESSAGE);
	}
}
