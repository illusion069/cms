package JavaPro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReportCard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel fullname;
	private JLabel course;
	private JLabel level;
	private JLabel module1;
	private JLabel marks1;
	private JLabel module2;
	private JLabel marks2;
	private JLabel module3;
	private JLabel marks3;
	private JLabel percentage;
	private JLabel result;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportCard frame = new ReportCard();
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
	public ReportCard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 982, 731);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(0, 0, 968, 74);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("ReportCard");
		lblNewLabel_2.setBounds(425, 10, 163, 35);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 30));
		
		JLabel lblFullname = new JLabel("Fullname:");
		lblFullname.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		lblFullname.setBounds(139, 136, 138, 24);
		contentPane.add(lblFullname);
		
		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		lblCourse.setBounds(139, 210, 138, 24);
		contentPane.add(lblCourse);
		
		JLabel lblLevel = new JLabel("Level:");
		lblLevel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		lblLevel.setBounds(139, 282, 138, 24);
		contentPane.add(lblLevel);
		
		 fullname = new JLabel("New label");
		fullname.setBounds(276, 134, 646, 33);
		contentPane.add(fullname);
		
		 course = new JLabel("New label");
		course.setBounds(276, 209, 646, 33);
		contentPane.add(course);
		
		 level = new JLabel("New label");
		level.setBounds(276, 281, 646, 33);
		contentPane.add(level);
		
		JLabel lblNewLabel_2_1 = new JLabel("Modules");
		lblNewLabel_2_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2_1.setBounds(139, 347, 163, 35);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Marks");
		lblNewLabel_2_2.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2_2.setBounds(638, 347, 163, 35);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Result:");
		lblNewLabel_2_2_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_2_2_1.setBounds(139, 649, 115, 35);
		contentPane.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Percentage:");
		lblNewLabel_2_2_2.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_2_2_2.setBounds(139, 604, 177, 35);
		contentPane.add(lblNewLabel_2_2_2);
		
		module1 = new JLabel("New label");
		module1.setBounds(165, 411, 89, 13);
		contentPane.add(module1);
		
		module2 = new JLabel("New label");
		module2.setBounds(165, 471, 100, 13);
		contentPane.add(module2);
		
		module3 = new JLabel("New label");
		module3.setBounds(165, 544, 100, 13);
		contentPane.add(module3);
		
		marks1 = new JLabel("New label");
		marks1.setBounds(654, 411, 80, 13);
		contentPane.add(marks1);
		
		marks2 = new JLabel("New label");
		marks2.setBounds(654, 471, 72, 13);
		contentPane.add(marks2);
		
		marks3 = new JLabel("New label");
		marks3.setBounds(654, 544, 72, 13);
		contentPane.add(marks3);
		
		percentage = new JLabel("New label");
		percentage.setBounds(304, 620, 72, 13);
		contentPane.add(percentage);
		
		result = new JLabel("New label");
		result.setBounds(244, 665, 72, 13);
		contentPane.add(result);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		btnBack.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		btnBack.setBounds(862, 649, 96, 34);
		contentPane.add(btnBack);
		
		
	}
	public void displayresult(int StudentId) {
		try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "");

            String query = "SELECT * FROM students s JOIN Result r ON s.ID = r.student_id WHERE s.ID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, StudentId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                fullname.setText(resultSet.getString("Fullname"));
                level.setText(resultSet.getString("StudentLevel"));
                course.setText(resultSet.getString("Course"));

                module1.setText(resultSet.getString("module1"));
                marks1.setText(Integer.toString(resultSet.getInt("mark1")));
                module2.setText(resultSet.getString("module2"));
                marks2.setText(Integer.toString(resultSet.getInt("mark2")));
                module3.setText(resultSet.getString("module3"));
                marks3.setText(Integer.toString(resultSet.getInt("mark3")));

                percentage.setText(resultSet.getString("percentage"));
                result.setText(resultSet.getString("result"));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
       
        }
	}
}
	
	

