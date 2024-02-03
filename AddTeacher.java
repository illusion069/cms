package JavaPro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddTeacher extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField teachername;
	private JTextField email;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCourse frame = new AddCourse();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void addTeacher1( String Name, String email, String password) {
        String url = "jdbc:mysql://localhost:3306/CMS";
         String dbUsername = "root";
         String dbPassword = "";

         try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword)) {
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO teacher (TeacherName, email, password) VALUES (?, ?, ?);");
             preparedStatement.setString(1,Name);
              preparedStatement.setString(2, email);
              preparedStatement.setString(3, password);
              preparedStatement.executeUpdate();
              
             JOptionPane.showMessageDialog(null, "Added successfully");
             
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
	/**
	 * Create the frame.
	 */
	public AddTeacher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		teachername = new JTextField();
		teachername.setBounds(154, 79, 245, 33);
		contentPane.add(teachername);
		teachername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("TeacherName");
		lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		lblNewLabel.setBounds(21, 80, 138, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		lblNewLabel_1.setBounds(71, 163, 73, 16);
		contentPane.add(lblNewLabel_1);
		
		email = new JTextField();
		email.setBounds(154, 158, 245, 33);
		contentPane.add(email);
		email.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String teacherN = teachername.getText();
				String Em = email.getText();
				String pass = password.getText();
				if(!teacherN.isEmpty() && !Em.isEmpty()) {
				    addTeacher1(teacherN,Em,pass);	
				}else {
					JOptionPane.showMessageDialog(null, "Input cannot be Empty!!");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 16));
		btnNewButton.setBounds(154, 314, 97, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 15));
		btnNewButton_1.setBounds(275, 315, 102, 41);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("ADD TEACHER");
		lblNewLabel_2.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2.setBounds(136, 10, 214, 51);
		contentPane.add(lblNewLabel_2);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(154, 232, 245, 33);
		contentPane.add(password);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(49, 237, 95, 16);
		contentPane.add(lblNewLabel_1_1);
	}
}
