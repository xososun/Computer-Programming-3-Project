package pckExer;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class LibrarianGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableNotifications;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarianGUI frame = new LibrarianGUI();
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
	public LibrarianGUI() {
		setFont(new Font("Dialog", Font.PLAIN, 11));
		setTitle("Librarian Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lblUsername.setBounds(109, 36, 87, 29);
		contentPane.add(lblUsername);
		
		JLabel lblWelcome = new JLabel("Welcome, ");
		lblWelcome.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcome.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lblWelcome.setBounds(22, 30, 87, 40);
		contentPane.add(lblWelcome);
		
		JPanel panelButtons = new JPanel();
		panelButtons.setToolTipText("");
		panelButtons.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelButtons.setBounds(20, 81, 176, 145);
		contentPane.add(panelButtons);
		panelButtons.setLayout(null);
		
		JButton btnSearchBooks = new JButton("Search Books");
		btnSearchBooks.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		btnSearchBooks.setBounds(6, 7, 164, 93);
		panelButtons.add(btnSearchBooks);
		btnSearchBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LibrarianLibraryGUI();
			}
		});
		
		JButton btnViewRecords = new JButton("View Records");
		btnViewRecords.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		btnViewRecords.setBounds(6, 110, 164, 23);
		panelButtons.add(btnViewRecords);
		
		JPanel panelNotif = new JPanel();
		panelNotif.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelNotif.setBounds(206, 81, 202, 145);
		contentPane.add(panelNotif);
		panelNotif.setLayout(null);
		
		tableNotifications = new JTable();
		tableNotifications.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		tableNotifications.setBounds(10, 36, 182, 99);
		panelNotif.add(tableNotifications);
		
		JLabel lblNotif = new JLabel("Notifications");
		lblNotif.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNotif.setBounds(10, 11, 120, 14);
		panelNotif.add(lblNotif);
		btnViewRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		setVisible(true);
	}
}
