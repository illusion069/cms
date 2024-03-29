package JavaPro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class EditMarks extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMarks frame = new AddMarks();
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
	public EditMarks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 770);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Student Id:");
		lblNewLabel_1_1_1_1.setBounds(155, 105, 128, 34);
		lblNewLabel_1_1_1_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 25));
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Level :");
		lblNewLabel_1_1_1_1_1.setBounds(506, 105, 85, 34);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 25));
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		textField = new JTextField();
		textField.setBounds(293, 103, 96, 45);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(601, 103, 96, 45);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 888, 82);
		panel.setBackground(new Color(192, 192, 192));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("EDIT MARKS");
		lblNewLabel_3_1_1.setBounds(334, 23, 195, 35);
		panel.add(lblNewLabel_3_1_1);
		lblNewLabel_3_1_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 30));
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Modules:");
		lblNewLabel_3_1_1_1.setBounds(10, 207, 133, 35);
		lblNewLabel_3_1_1_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 25));
		contentPane.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Marks:");
		lblNewLabel_3_1_1_1_1.setBounds(10, 382, 102, 35);
		lblNewLabel_3_1_1_1_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 25));
		contentPane.add(lblNewLabel_3_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1_1 = new JLabel("1 :");
		lblNewLabel_3_1_1_1_1_1.setBounds(73, 287, 102, 35);
		lblNewLabel_3_1_1_1_1_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 25));
		contentPane.add(lblNewLabel_3_1_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1_2 = new JLabel("2 :");
		lblNewLabel_3_1_1_1_1_2.setBounds(356, 287, 102, 35);
		lblNewLabel_3_1_1_1_1_2.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 25));
		contentPane.add(lblNewLabel_3_1_1_1_1_2);
		
		JLabel lblNewLabel_3_1_1_1_1_3 = new JLabel("3 :");
		lblNewLabel_3_1_1_1_1_3.setBounds(613, 287, 102, 35);
		lblNewLabel_3_1_1_1_1_3.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 25));
		contentPane.add(lblNewLabel_3_1_1_1_1_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(187, 277, 96, 45);
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(437, 277, 96, 45);
		textField_3.setColumns(10);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(699, 277, 96, 45);
		textField_4.setColumns(10);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setBounds(187, 441, 96, 45);
		textField_5.setColumns(10);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setBounds(437, 441, 96, 45);
		textField_6.setColumns(10);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setBounds(699, 441, 96, 45);
		textField_7.setColumns(10);
		contentPane.add(textField_7);
		
		JLabel lblNewLabel_3_1_1_1_1_1_1 = new JLabel("1 :");
		lblNewLabel_3_1_1_1_1_1_1.setBounds(73, 451, 102, 35);
		lblNewLabel_3_1_1_1_1_1_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 25));
		contentPane.add(lblNewLabel_3_1_1_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1_1_2 = new JLabel("2 :");
		lblNewLabel_3_1_1_1_1_1_2.setBounds(356, 451, 102, 35);
		lblNewLabel_3_1_1_1_1_1_2.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 25));
		contentPane.add(lblNewLabel_3_1_1_1_1_1_2);
		
		JLabel lblNewLabel_3_1_1_1_1_1_3 = new JLabel("3 :");
		lblNewLabel_3_1_1_1_1_1_3.setBounds(613, 451, 102, 35);
		lblNewLabel_3_1_1_1_1_1_3.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 25));
		contentPane.add(lblNewLabel_3_1_1_1_1_1_3);
		
		JLabel lblNewLabel_3_1_1_1_1_4 = new JLabel("Precentage:");
		lblNewLabel_3_1_1_1_1_4.setBounds(278, 541, 152, 35);
		lblNewLabel_3_1_1_1_1_4.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 25));
		contentPane.add(lblNewLabel_3_1_1_1_1_4);
		
		JLabel lblNewLabel_3_1_1_1_1_5 = new JLabel("Result:");
		lblNewLabel_3_1_1_1_1_5.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_3_1_1_1_1_5.setBounds(330, 605, 85, 35);
		contentPane.add(lblNewLabel_3_1_1_1_1_5);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(437, 531, 96, 45);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(437, 595, 96, 45);
		contentPane.add(textField_9);
		
		JButton btnNewButton = new JButton("EDIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "");
                    
                    String query = "UPDATE result SET module1=?, mark1=?, module2=?, mark2=?, module3=?, mark3=?, percentage=?, result=? WHERE student_id=?";
                    PreparedStatement pstmt = con.prepareStatement(query);
                    
                    String module1 = textField_2.getText();
                    int mark1 = Integer.parseInt(textField_5.getText());
                    String module2 = textField_3.getText();
                    int mark2 = Integer.parseInt(textField_6.getText());
                    String module3 = textField_4.getText();
                    int mark3 = Integer.parseInt(textField_7.getText());
                    float percentage = Float.parseFloat(textField_8.getText());
                    String result = textField_9.getText();
                    int studentId = Integer.parseInt(textField.getText()); 
                    
                    pstmt.setString(1, module1);
                    pstmt.setInt(2, mark1);
                    pstmt.setString(3, module2);
                    pstmt.setInt(4, mark2);
                    pstmt.setString(5, module3);
                    pstmt.setInt(6, mark3);
                    pstmt.setFloat(7, percentage);
                    pstmt.setString(8, result);
                    pstmt.setInt(9, studentId);
                    
                    int rowsAffected = pstmt.executeUpdate();
                    
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Marks updated successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No records found for the provided Student ID.");
                    }
                    
                    pstmt.close();
                    con.close();
                    
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error updating marks: " + ex.getMessage());
                }
			}
		});
		btnNewButton.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		btnNewButton.setBounds(391, 667, 107, 45);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		btnBack.setBounds(769, 678, 96, 34);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("--->");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(718, 688, 45, 13);
		contentPane.add(lblNewLabel);
	}
}
