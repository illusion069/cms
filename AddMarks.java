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

public class AddMarks extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Id;
	private JTextField level;
	private JTextField module1;
	private JTextField module2;
	private JTextField module3;
	private JTextField marks1;
	private JTextField marks2;
	private JTextField marks3;
	private JTextField percentage;
	private JTextField result;

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
	public AddMarks() {
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
		
		Id = new JTextField();
		Id.setBounds(293, 103, 96, 45);
		contentPane.add(Id);
		Id.setColumns(10);
		
		level = new JTextField();
		level.setBounds(601, 103, 96, 45);
		level.setColumns(10);
		contentPane.add(level);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 888, 82);
		panel.setBackground(new Color(192, 192, 192));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("ADD MARKS");
		lblNewLabel_3_1_1.setBounds(349, 23, 176, 35);
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
		
		module1 = new JTextField();
		module1.setBounds(187, 277, 96, 45);
		module1.setColumns(10);
		contentPane.add(module1);
		
		module2 = new JTextField();
		module2.setBounds(437, 277, 96, 45);
		module2.setColumns(10);
		contentPane.add(module2);
		
		module3 = new JTextField();
		module3.setBounds(699, 277, 96, 45);
		module3.setColumns(10);
		contentPane.add(module3);
		
		marks1 = new JTextField();
		marks1.setBounds(187, 441, 96, 45);
		marks1.setColumns(10);
		contentPane.add(marks1);
		
		marks2 = new JTextField();
		marks2.setBounds(437, 441, 96, 45);
		marks2.setColumns(10);
		contentPane.add(marks2);
		
		marks3 = new JTextField();
		marks3.setBounds(699, 441, 96, 45);
		marks3.setColumns(10);
		contentPane.add(marks3);
		
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
		
		percentage = new JTextField();
		percentage.setColumns(10);
		percentage.setBounds(437, 531, 96, 45);
		contentPane.add(percentage);
		
		result = new JTextField();
		result.setColumns(10);
		result.setBounds(437, 595, 96, 45);
		contentPane.add(result);
		
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "");
                    
                    String query = "INSERT INTO result (student_id	, module1, mark1, module2, mark2, module3, mark3,percentage,result) VALUES (?,?,?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement pstmt = con.prepareStatement(query);
                    
                    int studentId = Integer.parseInt(Id.getText());
                    String modul1 = module1.getText();
                    int mark1 = Integer.parseInt(marks1.getText());
                    String modul2 = module2.getText();
                    int mark2 = Integer.parseInt(marks2.getText());
                    String modul3 = module3.getText();
                    int mark3 = Integer.parseInt(marks3.getText());
                    float percentage1=Float.parseFloat(percentage.getText());
                    String result1 = result.getText();

                    pstmt.setInt(1, studentId);
                    pstmt.setString(2, modul1);
                    pstmt.setInt(3, mark1);
                    pstmt.setString(4, modul2);
                    pstmt.setInt(5, mark2);
                    pstmt.setString(6, modul3);
                    pstmt.setInt(7, mark3);
                    pstmt.setFloat(8, percentage1);
                    pstmt.setString(9, result1);

                    pstmt.executeUpdate();
                    
                    pstmt.close();
                    con.close();
                    
                    JOptionPane.showMessageDialog(null,"Marks added successfully.");
                    
                } catch (SQLException ex) {
                    ex.printStackTrace();
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
