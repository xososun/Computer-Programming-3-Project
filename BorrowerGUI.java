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

public class BorrowerGUI extends JFrame {

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
					BorrowerGUI frame = new BorrowerGUI();
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
	public BorrowerGUI() {
		setFont(new Font("Dialog", Font.PLAIN, 11));
		setTitle("Borrower Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lblUsername.setBounds(103, 48, 87, 29);
		contentPane.add(lblUsername);
		
		JLabel lblWelcome = new JLabel("Welcome, ");
		lblWelcome.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcome.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lblWelcome.setBounds(20, 42, 87, 40);
		contentPane.add(lblWelcome);
		
		JPanel panelButtons = new JPanel();
		panelButtons.setToolTipText("");
		panelButtons.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelButtons.setBounds(20, 81, 176, 176);
		contentPane.add(panelButtons);
		panelButtons.setLayout(null);
		
		JButton btnSearchBooks = new JButton("Search Books");
		btnSearchBooks.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		btnSearchBooks.setBounds(6, 7, 164, 93);
		panelButtons.add(btnSearchBooks);
		btnSearchBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BorrowerLibraryGUI();
			}
		});
		
		JButton btnViewBorrowedBooks = new JButton("View Borrowed Books");
		btnViewBorrowedBooks.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		btnViewBorrowedBooks.setBounds(6, 110, 164, 23);
		panelButtons.add(btnViewBorrowedBooks);
		
		JButton btnPayFine = new JButton("Pay Fine");
		btnPayFine.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		btnPayFine.setBounds(6, 143, 164, 23);
		panelButtons.add(btnPayFine);
		
		JPanel panelFine = new JPanel();
		panelFine.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelFine.setBounds(206, 81, 202, 54);
		contentPane.add(panelFine);
		panelFine.setLayout(null);
		
		JLabel lblFineText = new JLabel("Fine");
		lblFineText.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblFineText.setBounds(10, 11, 46, 14);
		panelFine.add(lblFineText);
		
		JLabel lblFineAmount = new JLabel("PHP 0.00");
		lblFineAmount.setBounds(37, 11, 153, 36);
		panelFine.add(lblFineAmount);
		lblFineAmount.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		lblFineAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JPanel panelNotif = new JPanel();
		panelNotif.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelNotif.setBounds(206, 146, 202, 111);
		contentPane.add(panelNotif);
		panelNotif.setLayout(null);
		
		tableNotifications = new JTable();
		tableNotifications.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		tableNotifications.setBounds(10, 36, 182, 64);
		panelNotif.add(tableNotifications);
		
		JLabel lblNotif = new JLabel("Notifications");
		lblNotif.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNotif.setBounds(10, 11, 120, 14);
		panelNotif.add(lblNotif);
		btnPayFine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnViewBorrowedBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		setVisible(true);
	}
}
