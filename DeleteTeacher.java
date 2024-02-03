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

public class DeleteTeacher extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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

	private void deleteTeacher1(int Id) {
	    String url = "jdbc:mysql://localhost:3306/CMS";
	    String dbUsername = "root";
	    String dbPassword = "";

	    try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword)) {
	        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM teacher WHERE TeacherId=?");
	        preparedStatement.setInt(1, Id);
	        int rowsAffected = preparedStatement.executeUpdate();

	        if (rowsAffected > 0) {
	            JOptionPane.showMessageDialog(null, "Delete successfully");
	        } else {
	            JOptionPane.showMessageDialog(null, "No records deleted. ID not found.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

    
	/**
	 * Create the frame.
	 */
	public DeleteTeacher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Id = new JTextField();
		Id.setBounds(135, 200, 223, 33);
		contentPane.add(Id);
		Id.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		lblNewLabel.setBounds(93, 201, 119, 24);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("DELETE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String TId = Id.getText(); 
				if(!TId.isEmpty()) {
				
					int TeacherID = Integer.parseInt(TId);
				    deleteTeacher1(TeacherID);	
				}else {
					JOptionPane.showMessageDialog(null, "Input cannot be Empty!!");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 16));
		btnNewButton.setBounds(195, 264, 97, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 15));
		btnNewButton_1.setBounds(195, 315, 97, 41);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("DELETE TEACHER");
		lblNewLabel_2.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2.setBounds(120, 100, 259, 51);
		contentPane.add(lblNewLabel_2);
	}
}
