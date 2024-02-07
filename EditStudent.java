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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class EditStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Studentname;
	private JTextField email;
	private JTextField pass;
	private JTextField Id;
	private JComboBox coursename;
	private JComboBox years;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditStudent frame = new EditStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void EditStudent1(int Id, String Name, String email, String course, String pass, int Level) {
        String url = "jdbc:mysql://localhost:3306/CMS";
         String dbUsername = "root";
         String dbPassword = "";

         try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword)) {
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE students SET Fullname=?, Email=?, Course=?, Password=?, StudentLevel=? WHERE ID=?");
             preparedStatement.setString(1,Name);
             preparedStatement.setString(2,email);
             preparedStatement.setString(3,course);
             preparedStatement.setString(4,pass);
              preparedStatement.setInt(5, Level);
              preparedStatement.setInt(6, Id);
              
              preparedStatement.executeUpdate();
              
             JOptionPane.showMessageDialog(null, "Edited successfully");
             
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
	/**
	 * Create the frame.
	 */
	public EditStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Studentname = new JTextField();
		Studentname.setBounds(154, 130, 245, 33);
		contentPane.add(Studentname);
		Studentname.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("StudentName");
		lblNewLabel.setBounds(10, 131, 138, 24);
		lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(71, 200, 73, 16);
		lblNewLabel_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1);
		
		email = new JTextField();
		email.setBounds(154, 195, 245, 33);
		contentPane.add(email);
		email.setColumns(10);
		
		JButton btnNewButton = new JButton("EDIT");
		btnNewButton.setBounds(152, 442, 97, 41);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SId = Id.getText();
				String studentN = Studentname.getText();
				String Em = email.getText();
				String Scourse = (String)coursename.getSelectedItem(); 
				String Spassword = pass.getText();
				String Slevel = (String)years.getSelectedItem();
				if(!SId.isEmpty() && !studentN.isEmpty() && !Em.isEmpty() && !Scourse.isEmpty() && !Spassword.isEmpty() && !Slevel.isEmpty()) {
					int lvl = Integer.parseInt(Slevel);
					int StuId = Integer.parseInt(SId);
				    EditStudent1(StuId, studentN, Em, Scourse, Spassword, lvl);	
				}else {
					JOptionPane.showMessageDialog(null, "Input cannot be Empty!!");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 16));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(297, 443, 102, 41);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 15));
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("EDIT STUDENT");
		lblNewLabel_2.setBounds(136, 10, 214, 51);
		lblNewLabel_2.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 30));
		contentPane.add(lblNewLabel_2);
		
		pass = new JTextField();
		pass.setBounds(154, 323, 245, 33);
		pass.setColumns(10);
		contentPane.add(pass);
		
		JLabel lblNewLabel_1_1 = new JLabel("Course");
		lblNewLabel_1_1.setBounds(71, 265, 73, 16);
		lblNewLabel_1_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Password");
		lblNewLabel_1_2.setBounds(51, 328, 90, 16);
		lblNewLabel_1_2.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("StudedntLevel");
		lblNewLabel_1_3.setBounds(10, 385, 134, 23);
		lblNewLabel_1_3.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1_3);
		
		Id = new JTextField();
		Id.setColumns(10);
		Id.setBounds(152, 74, 245, 33);
		contentPane.add(Id);
		
		JLabel lblNewLabel_1_4 = new JLabel("Id");
		lblNewLabel_1_4.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		lblNewLabel_1_4.setBounds(75, 84, 73, 16);
		contentPane.add(lblNewLabel_1_4);
		
		coursename = new JComboBox();
		coursename.setModel(new DefaultComboBoxModel(new String[] {"BSc(hons) Computer Science", "BSc(hons) Computer Application", "BIBM"}));
		coursename.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 14));
		coursename.setBounds(154, 259, 245, 33);
		contentPane.add(coursename);

		years = new JComboBox();
		years.setModel(new DefaultComboBoxModel(new String[] {"4", "5", "6"}));
		years.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 14));
		years.setBounds(154, 375, 245, 33);
		contentPane.add(years);
     }
}