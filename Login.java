package JavaPro;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	private boolean checkLogin(String user, String username, String password) {
	    String url = "jdbc:mysql://localhost:3306/CMS";
	    String dbUsername = "root";
	    String dbPassword = "";

	    try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
	         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + user + " WHERE email = ? AND password = ?")) {

	        preparedStatement.setString(1, username);
	        preparedStatement.setString(2, password);

	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            return resultSet.next();
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	public Login() {
		setBackground(new Color(255, 250, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 654);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(177, 183, 186));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 18));
		lblNewLabel.setBounds(258, 223, 69, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LOG IN");
		lblNewLabel_1.setFont(new Font("Franklin Gothic Demi", Font.ITALIC, 40));
		lblNewLabel_1.setBounds(348, 70, 136, 39);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(258, 245, 293, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 18));
		lblNewLabel_2.setBounds(258, 306, 99, 26);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("LOG IN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String select = (String) comboBox.getSelectedItem();
				String username = textField.getText();
				String password = textField_1.getText();
				
				if(!username.isEmpty() && !password.isEmpty()) {
					if(checkLogin(select,username, password)) {
						JOptionPane.showMessageDialog(null, "Login Successful!!");
						dashboard db = new dashboard();
						db.setVisible(true);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Unable to login!!");
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Fill the from!!");
				}
				
//				if(checkLogin(username,password)) {
//					
//					JOptionPane.showMessageDialog(null, "Login Successful!!");
//					dashboard db = new dashboard(username);
//					db.setVisible(true);
//					dispose();
//				}
				
			}
		});
		btnNewButton.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 16));
		btnNewButton.setBounds(258, 390, 293, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JavaProject l = new JavaProject();
				l.setVisible(true);
        		dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 15));
		btnNewButton_1.setBounds(373, 485, 89, 33);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Create New Account?");
		lblNewLabel_3.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 15));
		lblNewLabel_3.setBounds(336, 460, 153, 21);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(258, 331, 293, 39);
		contentPane.add(textField_1);
		
		comboBox =  new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"students", "teacher", "admin"}));
		comboBox.setBounds(258, 174, 293, 33);
		contentPane.add(comboBox);
	}
}
