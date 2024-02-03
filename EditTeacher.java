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

public class EditTeacher extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField teachername;
	private JTextField password;
	private JTextField Email;
	private JTextField Id;

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

	private void editTeacher1(int ID, String Name, String email, String password) {
	    String url = "jdbc:mysql://localhost:3306/CMS";
	    String dbUsername = "root";
	    String dbPassword = "";

	    try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword)) {
	        // Use a PreparedStatement with a WHERE clause to specify the record to update
	        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE teacher SET TeacherName=?, Email=?, Password=? WHERE TeacherId=?");
	        preparedStatement.setString(1, Name);
	        preparedStatement.setString(2, email);
	        preparedStatement.setString(3, password);
	        preparedStatement.setInt(4, ID);

	        int rowsAffected = preparedStatement.executeUpdate();

	        if (rowsAffected > 0) {
	            JOptionPane.showMessageDialog(null, "Updated successfully");
	        } else {
	            JOptionPane.showMessageDialog(null, "No records updated. ID not found.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


    
	/**
	 * Create the frame.
	 */
	public EditTeacher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		teachername = new JTextField();
		teachername.setBounds(154, 181, 223, 33);
		contentPane.add(teachername);
		teachername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("TeacherName");
		lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 190, 134, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		lblNewLabel_1.setBounds(71, 245, 73, 16);
		contentPane.add(lblNewLabel_1);
		
		password = new JTextField();
		password.setBounds(154, 298, 223, 33);
		contentPane.add(password);
		password.setColumns(10);
		
		JButton btnNewButton = new JButton("EDIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Tid = Id.getText();
				String teacherN = teachername.getText();
				String Em = Email.getText(); 
				String pass = password.getText();
				if(!Tid.isEmpty() && !teacherN.isEmpty() && !Em.isEmpty() && !pass.isEmpty()) {
					int teacherId = Integer.parseInt(Tid);
					editTeacher1(teacherId,teacherN,Em,pass);	
				}else {
					JOptionPane.showMessageDialog(null, "Input cannot be Empty!!");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 16));
		btnNewButton.setBounds(154, 354, 97, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 15));
		btnNewButton_1.setBounds(275, 355, 102, 41);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("EDIT TEACHER");
		lblNewLabel_2.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2.setBounds(133, 29, 212, 51);
		contentPane.add(lblNewLabel_2);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(154, 240, 223, 33);
		contentPane.add(Email);
		
		JLabel lblId = new JLabel("Password");
		lblId.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		lblId.setBounds(41, 299, 108, 24);
		contentPane.add(lblId);
		
		Id = new JTextField();
		Id.setColumns(10);
		Id.setBounds(154, 127, 223, 33);
		contentPane.add(Id);
		
		JLabel lblId_1 = new JLabel("ID");
		lblId_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		lblId_1.setBounds(93, 128, 38, 24);
		contentPane.add(lblId_1);
	}
}
