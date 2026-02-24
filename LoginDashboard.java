package pckExer;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
*/
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.SwingConstants;

public class LoginDashboard {

    private JFrame frmLibraryManagementSystem;
    private JTextField txtUsername;
    private JComboBox<String> comboRole;
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/librarymanagementsystem";
    private static final String DB_USER = "java";
    private static final String DB_PASS = "password";
    private JTextField txtempID;
    

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginDashboard window = new LoginDashboard();
                    window.frmLibraryManagementSystem.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmLibraryManagementSystem = new JFrame();
        frmLibraryManagementSystem.setTitle("Library Management System Login");
        frmLibraryManagementSystem.setBounds(100, 100, 450, 300);
        frmLibraryManagementSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmLibraryManagementSystem.getContentPane().setLayout(null);
        frmLibraryManagementSystem.setLocationRelativeTo(null); // Center window

        JLabel lblTitle = new JLabel("System Authentication");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setLabelFor(frmLibraryManagementSystem.getContentPane());
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitle.setBounds(95, 21, 250, 30);
        frmLibraryManagementSystem.getContentPane().add(lblTitle);

        JLabel lblUserId = new JLabel("Username:");
        lblUserId.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblUserId.setBounds(56, 79, 100, 22);
        frmLibraryManagementSystem.getContentPane().add(lblUserId);

        txtUsername = new JTextField();
        txtUsername.setBounds(166, 79, 173, 22);
        frmLibraryManagementSystem.getContentPane().add(txtUsername);
        txtUsername.setColumns(10);

        JLabel lblEmpID = new JLabel("Employee ID:");
        lblEmpID.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblEmpID.setBounds(56, 119, 100, 22);
        frmLibraryManagementSystem.getContentPane().add(lblEmpID);

        JLabel lblRole = new JLabel("Role:");
        lblRole.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblRole.setBounds(56, 159, 100, 22);
        frmLibraryManagementSystem.getContentPane().add(lblRole);

        comboRole = new JComboBox<String>();
        comboRole.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		String role = comboRole.getSelectedItem().toString();
        		txtempID.setText("");
        		if (role.equals("Librarian")) {
        			txtempID.setEditable(true);
                } else {
                	txtempID.setEditable(false);
                }
        	}
        });
        comboRole.setModel(new DefaultComboBoxModel<String>(new String[] {"Borrower", "Librarian"}));
        comboRole.setBounds(166, 159, 173, 22);
        frmLibraryManagementSystem.getContentPane().add(comboRole);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                authenticateUser();
            }
        });
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnLogin.setBounds(167, 208, 100, 30);
        frmLibraryManagementSystem.getContentPane().add(btnLogin);
        
        txtempID = new JTextField();
        txtempID.setEditable(false);
        txtempID.setBounds(166, 122, 173, 18);
        frmLibraryManagementSystem.getContentPane().add(txtempID);
        txtempID.setColumns(10);
    }
    
    /**
     * Create the application.
     */
    public LoginDashboard() {
        initialize();
    }
    
    // Now you can run your other queries

    /**
     * Handles JDBC SQL authentication
     */
    private void authenticateUser() {
        String username = txtUsername.getText().trim();
        String empID = new String(txtempID.getText());
        String role = comboRole.getSelectedItem().toString();
        
        if (role.equals("Librarian") && empID.isEmpty()) {
        	JOptionPane.showMessageDialog(frmLibraryManagementSystem, "Please enter employee ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }

        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(frmLibraryManagementSystem, "Please enter username.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String query;
        
        if (role.equals("Librarian")) {
        	query = "SELECT * FROM User u INNER JOIN Librarian l ON u.userID = l.userID WHERE username = ? AND employeeID = ?";
        } else {
        	query = "SELECT * FROM User WHERE username = ? AND userType = ?";
        }
        
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
        	
        	pstmt.setString(1, username);

        	if (role.equals("Librarian")) {
                pstmt.setString(2, empID);
            } else {
                pstmt.setString(2, role);
            }
        	
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Login successful
                JOptionPane.showMessageDialog(frmLibraryManagementSystem, "Login Successful! Welcome " + rs.getString("name"), "Success", JOptionPane.INFORMATION_MESSAGE);
                
                // Route to appropriate dashboard based on userType 
                if (role.equals("Librarian")) {
                	new LibrarianGUI();
                } else {
                	new BorrowerGUI();
                }
                frmLibraryManagementSystem.dispose(); // Close login window

            } else {
                // Login failed
                JOptionPane.showMessageDialog(frmLibraryManagementSystem, "Invalid Credentials or Role mismatch.", "Authentication Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frmLibraryManagementSystem, "Database Connection Error: " + ex.getMessage(), "DB Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}