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

public class AddStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Studentname;
	private JTextField email;
	private JTextField course;
	private JTextField pass;
	private JTextField level;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent frame = new AddStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void addStudent1( String Name, String email, String course, String pass, int Level) {
        String url = "jdbc:mysql://localhost:3306/CMS";
         String dbUsername = "root";
         String dbPassword = "";

         try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword)) {
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO students (StudentName, Email, Course, PASSWORD, StudentLevel) VALUES (?, ?, ?, ?, ?);");
             preparedStatement.setString(1,Name);
             preparedStatement.setString(2,email);
             preparedStatement.setString(3,course);
             preparedStatement.setString(4,pass);
              preparedStatement.setInt(5, Level);
              
              preparedStatement.executeUpdate();
              
             JOptionPane.showMessageDialog(null, "Added successfully");
             
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
	/**
	 * Create the frame.
	 */
	public AddStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Studentname = new JTextField();
		Studentname.setBounds(154, 79, 245, 33);
		contentPane.add(Studentname);
		Studentname.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("StudentName");
		lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		lblNewLabel.setBounds(21, 80, 138, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		lblNewLabel_1.setBounds(71, 143, 73, 16);
		contentPane.add(lblNewLabel_1);
		
		email = new JTextField();
		email.setBounds(154, 138, 245, 33);
		contentPane.add(email);
		email.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studentN = Studentname.getText();
				String Em = email.getText();
				String Scourse = course.getText();
				String Spassword = pass.getText();
				String Slevel = level.getText();
				if(!studentN.isEmpty() && !Em.isEmpty() && !Scourse.isEmpty() && !Spassword.isEmpty() && !Slevel.isEmpty()) {
					int lvl = Integer.parseInt(Slevel);
				    addStudent1(studentN, Em, Scourse, Spassword, lvl);	
				}else {
					JOptionPane.showMessageDialog(null, "Input cannot be Empty!!");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 16));
		btnNewButton.setBounds(151, 388, 97, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 15));
		btnNewButton_1.setBounds(297, 389, 102, 41);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("ADD STUDENT");
		lblNewLabel_2.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2.setBounds(136, 10, 214, 51);
		contentPane.add(lblNewLabel_2);
		
		course = new JTextField();
		course.setColumns(10);
		course.setBounds(154, 203, 245, 33);
		contentPane.add(course);
		
		pass = new JTextField();
		pass.setColumns(10);
		pass.setBounds(154, 263, 245, 33);
		contentPane.add(pass);
		
		level = new JTextField();
		level.setColumns(10);
		level.setBounds(154, 333, 245, 33);
		contentPane.add(level);
		
		JLabel lblNewLabel_1_1 = new JLabel("Course");
		lblNewLabel_1_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(71, 213, 73, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Password");
		lblNewLabel_1_2.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(51, 268, 90, 16);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("StudedntLevel");
		lblNewLabel_1_3.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(10, 343, 134, 23);
		contentPane.add(lblNewLabel_1_3);
	}
}
