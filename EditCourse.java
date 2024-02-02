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

public class EditCourse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField coursename;
	private JTextField years;
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

	private void editCourse1(int ID, String Name, int years) {
	    String url = "jdbc:mysql://localhost:3306/CMS";
	    String dbUsername = "root";
	    String dbPassword = "";

	    try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword)) {
	        // Use a PreparedStatement with a WHERE clause to specify the record to update
	        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE courses SET name=?, years=? WHERE id=?");
	        preparedStatement.setString(1, Name);
	        preparedStatement.setInt(2, years);
	        preparedStatement.setInt(3, ID); // Add the ID parameter to the WHERE clause

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
	public EditCourse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		coursename = new JTextField();
		coursename.setBounds(154, 221, 223, 33);
		contentPane.add(coursename);
		coursename.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CourseName");
		lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		lblNewLabel.setBounds(25, 222, 119, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Years");
		lblNewLabel_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		lblNewLabel_1.setBounds(71, 283, 73, 16);
		contentPane.add(lblNewLabel_1);
		
		years = new JTextField();
		years.setBounds(154, 278, 223, 33);
		contentPane.add(years);
		years.setColumns(10);
		
		JButton btnNewButton = new JButton("EDIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cId = Id.getText(); 
				String courseN = coursename.getText();
				String year = years.getText();
				if(!cId.isEmpty() && !courseN.isEmpty() && !year.isEmpty()) {
					int Year = Integer.parseInt(year);
					int courseID = Integer.parseInt(cId);
				    editCourse1(courseID,courseN,Year);	
				}else {
					JOptionPane.showMessageDialog(null, "Input cannot be Empty!!");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 16));
		btnNewButton.setBounds(154, 348, 97, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 15));
		btnNewButton_1.setBounds(261, 349, 102, 41);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("EDIT COURSE");
		lblNewLabel_2.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2.setBounds(135, 61, 199, 51);
		contentPane.add(lblNewLabel_2);
		
		Id = new JTextField();
		Id.setColumns(10);
		Id.setBounds(154, 164, 223, 33);
		contentPane.add(Id);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		lblId.setBounds(25, 164, 119, 24);
		contentPane.add(lblId);
	}
}
