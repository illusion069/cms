package JavaPro;

import java.awt.BorderLayout;
import java.util.regex.*;
import java.awt.EventQueue;

import javax.swing.JOptionPane;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class JavaProject extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel confirmPassw;
    private JTextField firstName;
    private JTextField email;
    private JPasswordField password;
    private JPasswordField passwordConfi;
    private JComboBox comboBox;
    private JComboBox comboBox_1;
    private JComboBox comboBox_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	JavaProject frame = new  JavaProject();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    private void registerUser(String email, String password, String role, String firstname,String level,String course ) {
        String url = "jdbc:mysql://localhost:3306/Cms";
        String dbUsername = "root";
        String dbPassword = "";

        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword)){
        	switch (role) {
        	case "Student":
        		try(PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO students (Email,PASSWORD, StudentName, StudentLevel, Course ) VALUES (?,?,?,?,?)")){
        			preparedStatement.setString(1, email);
        			preparedStatement.setString(2, password);
        			preparedStatement.setString(3, firstname);
                    preparedStatement.setString(4, level);
                    preparedStatement.setString(5, course);

                    preparedStatement.executeUpdate();
        		}
        		break;
        	case "Admin":
        		try(PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO admin (email,password, name ) VALUES (?,?,?)")){
        			preparedStatement.setString(1, email);
        			preparedStatement.setString(2, password);
        			preparedStatement.setString(3, firstname);

                    preparedStatement.executeUpdate();
        		}
        		break;
            case "Teacher":
            	try(PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO admin (Email,Password, TeacherName ) VALUES (?,?,?)")){
        			preparedStatement.setString(1, email);
        			preparedStatement.setString(2, password);
        			preparedStatement.setString(3, firstname);

                    preparedStatement.executeUpdate();
        		}
        		break;
        	default:
        		JOptionPane.showMessageDialog(null, "Invalid role !!!");
        		return;
        	}

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred during registration.");
        }
    }
public  JavaProject() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 925, 734);
        confirmPassw = new JPanel();
        confirmPassw.setBackground(new Color(124, 136, 141));
        confirmPassw.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(confirmPassw);
        confirmPassw.setLayout(null);
        
        JLabel lblRegistration = new JLabel("Sign Up");
        lblRegistration.setBounds(402, 44, 114, 55);
        lblRegistration.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 30));
        confirmPassw.add(lblRegistration);
        
        JLabel lblFirstName = new JLabel("Fullname");
        lblFirstName.setBounds(56, 140, 101, 25);
        lblFirstName.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 18));
        confirmPassw.add(lblFirstName);
        
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(56, 195, 101, 25);
        lblEmail.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 18));
        confirmPassw.add(lblEmail);
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(56, 248, 101, 32);
        lblPassword.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 18));
        confirmPassw.add(lblPassword);
        
        JLabel lblConfirmPassword = new JLabel("Confirm Password");
        lblConfirmPassword.setBounds(55, 305, 164, 25);
        lblConfirmPassword.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 18));
        confirmPassw.add(lblConfirmPassword);
        
        firstName = new JTextField();
        firstName.setBounds(225, 139, 676, 33);
        confirmPassw.add(firstName);
        firstName.setColumns(10);
        
        email = new JTextField();
        email.setBounds(225, 194, 676, 33);
        email.setColumns(10);
        confirmPassw.add(email);
        
        password = new JPasswordField();
        password.setBounds(225, 251, 337, 33);
        confirmPassw.add(password);
        
        passwordConfi = new JPasswordField();
        passwordConfi.setBounds(225, 303, 337, 35);
        confirmPassw.add(passwordConfi);
JButton registerBtn = new JButton("Sign Up");
registerBtn.setBounds(441, 488, 179, 55);
registerBtn.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 18));
        registerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstname = firstName.getText();
                String eMail = email.getText();
                String newPass = password.getText();
                String confirmPass = passwordConfi.getText();
                String role=(String)comboBox.getSelectedItem();
                String level=(String)comboBox_1.getSelectedItem();
                String course=(String)comboBox_2.getSelectedItem();
                
                  // Regex for FirstName
                String regexFN = "[a-zA-Z]+";
                Pattern Fname = Pattern.compile(regexFN);
                
                Matcher FN = Fname.matcher(firstname);
                boolean fname = FN.matches();
                
                
                //for emailverification
             
                String regexEmail =  "^[a-zA-Z0-9_+&-]+(?:\\.[a-zA-Z0-9_+&-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
                Pattern verifyEmail = Pattern.compile(regexEmail);
                
                Matcher eM = verifyEmail.matcher(eMail);
                boolean checkEmail = eM.matches();
                
                // Regex for New password
                String regexP = "[a-zA-Z0-9]+";
                Pattern passN = Pattern.compile(regexP);
                
                Matcher pN = passN.matcher(newPass);
                boolean passNew = pN.matches();
                
                // Regex for Confirm password
                String regexPC = "[a-zA-Z0-9]+";
                Pattern passC = Pattern.compile(regexPC);
                
                Matcher pC = passC.matcher(confirmPass);
                boolean passConfirm = pC.matches();
                
                
                if(!firstname.equals("") && !eMail.equals("") && !newPass.equals("") && !confirmPass.equals(" ")) {
					if(fname==true && checkEmail == true &&  passNew== true && newPass.equals(confirmPass) ) {
						registerUser(eMail,newPass,role,firstname,level,course);
						JOptionPane.showMessageDialog(null, "Sign Up success");
					}else {
						JOptionPane.showMessageDialog(null, "Failed...");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Inputs cannot be empty !!");
				}
				
				}
                
            
        });
        confirmPassw.add(registerBtn);
        
        JButton btnNewButton = new JButton("Log In");
        btnNewButton.setBounds(586, 553, 73, 25);
        btnNewButton.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 13));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Login l = new Login();
        		l.setVisible(true);
        		dispose();
        	}
        });
        confirmPassw.add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("Already have an account?");
        lblNewLabel.setBounds(385, 551, 206, 28);
        lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 15));
        confirmPassw.add(lblNewLabel);
        
        comboBox = new JComboBox();
        comboBox.setBounds(225, 363, 337, 33);
        comboBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Student", "Admin", "Teacher"}));
        confirmPassw.add(comboBox);
        
        
        
        comboBox_1 = new JComboBox();
        comboBox_1.setFont(new Font("Arial Black", Font.BOLD, 15));
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"BSc(hons) Computer Science", "BSc(hons) Computer Application"}));
        comboBox_1.setBounds(225, 422, 337, 32);
        confirmPassw.add(comboBox_1);
        
        JLabel level = new JLabel("Level");
        level.setBounds(583, 435, 69, 23);
        level.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 18));
        confirmPassw.add(level);
        
        JLabel course = new JLabel("Courses");
        course.setBounds(56, 423, 78, 25);
        course.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 18));
        confirmPassw.add(course);
        
        comboBox.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedRole = (String) comboBox.getSelectedItem();
                    if (selectedRole.equals("Student")) {
                        comboBox_1.setVisible(true);
                        comboBox_2.setVisible(true);
                        course.setVisible(true);
                        level.setVisible(true);
                        
                    } else {
                        comboBox_1.setVisible(false);
                        comboBox_2.setVisible(false);
                        course.setVisible(false);
                        level.setVisible(false);
                    }
                }
				
			}
        });
        
        comboBox_2 = new JComboBox();
        comboBox_2.setFont(new Font("Arial Black", Font.BOLD, 15));
        comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"4", "5", "6"}));
        comboBox_2.setBounds(645, 431, 223, 32);
        confirmPassw.add(comboBox_2);
        
        JLabel lblNewLabel_3 = new JLabel("Register As");
        lblNewLabel_3.setBounds(57, 368, 114, 21);
        lblNewLabel_3.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 18));
        confirmPassw.add(lblNewLabel_3);
    }
}

