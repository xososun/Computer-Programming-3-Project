package pckExer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;

public class BorrowerLibraryView {

	private JFrame frmLibrary;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowerLibraryView window = new BorrowerLibraryView();
					window.frmLibrary.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BorrowerLibraryView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLibrary = new JFrame();
		frmLibrary.setFont(new Font("Arial Black", Font.PLAIN, 12));
		frmLibrary.setTitle("Library Book Borrowing System");
		frmLibrary.setBounds(100, 100, 630, 450);
		frmLibrary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLibrary.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		frmLibrary.getContentPane().add(panel_1);
		
		table = new JTable();
		table.setBounds(15, 98, 430, 300);
		table.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Title", "Author", "Pages", "ISBN", "Dewey", "Status"
			}
		));
		table.getColumnModel().getColumn(3).setMinWidth(40);
		panel_1.setLayout(null);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel_1.add(table);
		
		JButton btnNewButton = new JButton("Borrow");
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		btnNewButton.setBounds(472, 94, 110, 25);
		panel_1.add(btnNewButton);
		
		JButton btnUpdate = new JButton("Reserve");
		btnUpdate.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		btnUpdate.setBounds(472, 129, 110, 25);
		panel_1.add(btnUpdate);
		
		JButton btnNewButton_1_1 = new JButton("Request New");
		btnNewButton_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		btnNewButton_1_1.setBounds(472, 310, 110, 25);
		panel_1.add(btnNewButton_1_1);
		
		JLabel lblNewLabel = new JLabel("Title");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNewLabel.setBounds(15, 17, 46, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ISBN");
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(15, 42, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		textField.setBounds(52, 14, 130, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		textField_1.setBounds(52, 39, 130, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Author");
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(211, 17, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		textField_2.setColumns(10);
		textField_2.setBounds(257, 14, 130, 20);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		textField_3.setColumns(10);
		textField_3.setBounds(257, 39, 130, 20);
		panel_1.add(textField_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Dewey");
		lblNewLabel_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNewLabel_1_1.setBounds(211, 42, 46, 14);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("Pages");
		lblNewLabel_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(419, 17, 46, 14);
		panel_1.add(lblNewLabel_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		textField_4.setColumns(10);
		textField_4.setBounds(465, 14, 130, 20);
		panel_1.add(textField_4);
		
		JLabel lblNewLabel_1_2 = new JLabel("Status");
		lblNewLabel_1_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNewLabel_1_2.setBounds(419, 42, 46, 14);
		panel_1.add(lblNewLabel_1_2);
		
		JButton btnNewButton_1_1_1 = new JButton("Back");
		btnNewButton_1_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_1.setBounds(472, 345, 110, 25);
		panel_1.add(btnNewButton_1_1_1);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		textField_6.setColumns(10);
		textField_6.setBounds(52, 70, 295, 20);
		panel_1.add(textField_6);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		btnNewButton_1.setBounds(356, 69, 70, 23);
		panel_1.add(btnNewButton_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		comboBox.setBounds(465, 38, 130, 22);
		panel_1.add(comboBox);
	}
}
