package jday.ui.admin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.lang.reflect.Member;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import jday.entities.FnB;
import jday.util.BackgroundPanel;
import jday.util.FnBViewTableModel;

import javax.swing.JToggleButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ItemListener;

public class Kitchen extends BackgroundPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
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
		panel.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(-6, -16, 762, 523);
		add(panel);
		panel.setLayout(null);
		
		ArrayList<FnB>list = FnB.searchFnbOrder(null);
		FnBViewTableModel model = new FnBViewTableModel(list);

		JLabel lblMembersParticular = new JLabel("RESTAURANT ORDER SUMMARY");
		lblMembersParticular.setForeground(new Color(0, 0, 0));
		lblMembersParticular.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblMembersParticular.setBounds(225, 30, 268, 46);
		panel.add(lblMembersParticular);
		lblMembersParticular.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setOpaque(false);
		btnRefresh.setFont(new Font("Candara", Font.PLAIN, 12));
		btnRefresh.setBounds(52, 444, 86, 23);
		panel.add(btnRefresh);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setOpaque(false);
		btnDelete.setFont(new Font("Candara", Font.PLAIN, 12));
		btnDelete.setBounds(153, 444, 86, 23);
		panel.add(btnDelete);
		
		JTable table_1 = new JTable();
		table_1.setModel(model);
		table_1.setBounds(0,0,600,400);
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(52, 100, 653, 319);
		panel.add(scrollPane);

	}
}
