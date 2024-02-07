package JavaPro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

public class dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTabbedPane tabbedPane;
    private CourseDisplay Display;
    private StudentDisplay Disp;
    private TeacherDisplay Tdisplay;
    private AdminDisplay Adisplay;
    private JTextField Fn;
    private JTextField email;
    private ResultDisplay RDisp;
    //private static String userRole;
	/**
	 * Launch the application.
	 */
    private static String loggedEmail;
    private static String loggedRole;
	private static String loggedName;
	private static String loggedOpass;
	private static int loggedId;
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboard frame = new dashboard(loggedEmail,loggedRole,loggedName,loggedOpass,loggedId);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	String url = "jdbc:mysql://localhost:3306/CMS";
    String dbUsername = "root";
    String dbPassword = "";
    private JPasswordField Old;
    private JPasswordField New;
    
    /**
     * @wbp.nonvisual location=782,-23
     */
//    private final JLabel label = new JLabel("New label");


	/**
	 * Create the frame.
	 */
    
    
    public int updateUserData(String oldEmail, String newFirstName , String newEmail, String newPassword) {
        String url = "jdbc:mysql://localhost:3306/CMS";
        String dbUsername = "root";
        String dbPassword = "";

        String query = "UPDATE admin SET firstname = ?, lastname = ?, email = ?, password = ? WHERE  email = ?";

        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, newFirstName);
            preparedStatement.setString(3, newEmail);
            preparedStatement.setString(4, newPassword);
            preparedStatement.setString(5, oldEmail);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                // Display success message
                JOptionPane.showMessageDialog(null,"Profile updated successfully. Please re-login !!");
                Login logIn = new Login();;
                logIn.setVisible(true);
                dispose();
            }else {
                JOptionPane.showMessageDialog(null,"Failed to update profile !!");
            }

            return rowsAffected;

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return 0; // Return 0 if something went wrong
    }
	public dashboard(String userEmail, String userRole,String fullname,String pass,int id){
		
		loggedEmail=userEmail;
		loggedRole=userRole;
		loggedName=fullname;
		loggedOpass = pass;
		loggedId = id;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1039, 806);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(10, 10, 272, 749);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnNewButton.setBounds(65, 107, 143, 53);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Courses");
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnNewButton_1.setBounds(65, 193, 143, 53);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Student");
		btnNewButton_2.setBackground(new Color(192, 192, 192));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(65, 434, 143, 53);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Teachers");
		btnNewButton_3.setBackground(new Color(192, 192, 192));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		btnNewButton_3.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		btnNewButton_3.setBounds(65, 354, 143, 53);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Logout");
		btnNewButton_4.setBackground(new Color(180, 16, 32));
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 19));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
        		dispose();
			}
		});
		btnNewButton_4.setBounds(85, 700, 101, 24);
		panel.add(btnNewButton_4);
		
		JLabel lblNewLabel_2 = new JLabel("CMS");
		lblNewLabel_2.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2.setBounds(100, 44, 75, 53);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton_3_1 = new JButton("Admin");
		btnNewButton_3_1.setBackground(new Color(192, 192, 192));
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);
			}
		});
		btnNewButton_3_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		btnNewButton_3_1.setBounds(65, 272, 143, 53);
		panel.add(btnNewButton_3_1);
		
		JButton btnNewButton_8_4 = new JButton("Setting");
		btnNewButton_8_4.setBackground(new Color(102, 153, 204));
		btnNewButton_8_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(6);
			}
		});
		btnNewButton_8_4.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_8_4.setBounds(85, 666, 101, 24);
		panel.add(btnNewButton_8_4);
		
		JLabel lblNewLabel_5 = new JLabel("User:");
		lblNewLabel_5.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_5.setBounds(100, 22, 143, 24);
		panel.add(lblNewLabel_5);
		
		lblNewLabel_5.setText("User: "+loggedRole);
		
		JButton btnNewButton_8_4_2 = new JButton("Std Report");
		btnNewButton_8_4_2.setBackground(new Color(220, 220, 220));
		btnNewButton_8_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(5);
			}
			
		});
		btnNewButton_8_4_2.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		btnNewButton_8_4_2.setBounds(65, 541, 143, 40);
		panel.add(btnNewButton_8_4_2);
		
		JButton btnNewButton_8_4_2_1 = new JButton("\r\nReportCard");
		btnNewButton_8_4_2_1.setBackground(new Color(220, 220, 220));
		btnNewButton_8_4_2_1.setBounds(65, 582, 143, 40);
		panel.add(btnNewButton_8_4_2_1);
		btnNewButton_8_4_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchCard Rcard = new SearchCard();
				Rcard.setVisible(true);
			}
		});
		btnNewButton_8_4_2_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(292, 10, 738, 749);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 128));
		tabbedPane.addTab("Home", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBounds(10, 10, 162, 130);
		panel_1.add(panel_12);
		
		JLabel lblNewLabel_2_1 = new JLabel("Admin");
		lblNewLabel_2_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 30));
		panel_12.add(lblNewLabel_2_1);
		
		JPanel panel_12_1 = new JPanel();
		panel_12_1.setBounds(287, 10, 162, 130);
		panel_1.add(panel_12_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Teacher");
		lblNewLabel_2_2.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 30));
		panel_12_1.add(lblNewLabel_2_2);
		
		JPanel panel_12_2 = new JPanel();
		panel_12_2.setBounds(556, 10, 162, 130);
		panel_1.add(panel_12_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Student");
		lblNewLabel_2_3.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 30));
		panel_12_2.add(lblNewLabel_2_3);
		
		JPanel panel_12_1_1 = new JPanel();
		panel_12_1_1.setBounds(287, 190, 162, 130);
		panel_1.add(panel_12_1_1);
		
		JLabel lblNewLabel_2_4 = new JLabel("Course");
		lblNewLabel_2_4.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 30));
		panel_12_1_1.add(lblNewLabel_2_4);
		
		JButton btnNewButton_8 = new JButton("Refresh");
		btnNewButton_8.setBackground(new Color(51, 102, 102));
		btnNewButton_8.setBounds(10, 679, 115, 33);
		panel_1.add(btnNewButton_8);
		btnNewButton_8.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 16));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 128, 128));
		tabbedPane.addTab("Courses", null, panel_2, null);
		tabbedPane.setBackgroundAt(1, Color.YELLOW);
		panel_2.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 0, 733, 88);
		panel_6.setBackground(new Color(192, 192, 192));
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Courses");
		lblNewLabel.setBounds(293, 22, 122, 37);
		lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 30));
		panel_6.add(lblNewLabel);
		
		JButton btnNewButton_5 = new JButton("Add \r\nCourse");
		btnNewButton_5.setBackground(new Color(211, 211, 211));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCourse Add = new AddCourse();
				Add.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(10, 98, 125, 50);
		btnNewButton_5.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		panel_2.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Edit Course");
		btnNewButton_6.setBackground(new Color(211, 211, 211));
		btnNewButton_6.setBounds(306, 98, 125, 50);
		btnNewButton_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EditCourse Edit = new EditCourse();
					Edit.setVisible(true);
			}
		});
		btnNewButton_6.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		panel_2.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Delete Course");
		btnNewButton_7.setBackground(new Color(211, 211, 211));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteCourse Delete = new DeleteCourse();
				Delete.setVisible(true);
			}
		});
		btnNewButton_7.setBounds(598, 98, 125, 50);
		btnNewButton_7.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		panel_2.add(btnNewButton_7);
		
		Display= new CourseDisplay();
		Display.setBounds(10, 158, 713, 391);
		panel_2.add(Display);
		
		JButton btnNewButton_9 = new JButton("Refresh");
		btnNewButton_9.setBackground(new Color(51, 102, 102));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_2.remove(Display);

		        // Create a new CourseDisplay and add it to the panel
		        Display = new CourseDisplay();
		        Display.setBounds(29, 191, 678, 331);
		        panel_2.add(Display);
		        // Repaint the panel to reflect the changes
		        panel_2.revalidate();
		        panel_2.repaint();
	             
			}
		});
		btnNewButton_9.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 16));
		btnNewButton_9.setBounds(10, 679, 115, 33);
		panel_2.add(btnNewButton_9);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(128, 128, 128));
		tabbedPane.addTab("Student", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(192, 192, 192));
		panel_7.setBounds(0, 0, 733, 88);
		panel_3.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Student details");
		lblNewLabel_3.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_3.setBounds(243, 24, 218, 38);
		panel_7.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(10, 141, 45, 13);
		panel_3.add(lblNewLabel_4);
		
		JButton btnNewButton_5_1 = new JButton("Add Student");
		btnNewButton_5_1.setBackground(new Color(211, 211, 211));
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudent SAdd = new AddStudent();
				SAdd.setVisible(true);
			}
		});
		btnNewButton_5_1.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		btnNewButton_5_1.setBounds(10, 98, 125, 50);
		panel_3.add(btnNewButton_5_1);
		
		JButton btnNewButton_6_1 = new JButton("Edit Student");
		btnNewButton_6_1.setBackground(new Color(211, 211, 211));
		btnNewButton_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditStudent SEdit = new EditStudent();
				SEdit.setVisible(true);
			}
		});
		btnNewButton_6_1.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		btnNewButton_6_1.setBounds(306, 98, 125, 50);
		panel_3.add(btnNewButton_6_1);
		
		JButton btnNewButton_7_1 = new JButton("Delete Student");
		btnNewButton_7_1.setBackground(new Color(211, 211, 211));
		btnNewButton_7_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteStudent Sdel = new DeleteStudent();
				Sdel.setVisible(true);
			}
		});
		btnNewButton_7_1.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		btnNewButton_7_1.setBounds(598, 98, 125, 50);
		panel_3.add(btnNewButton_7_1);
		
		Disp = new StudentDisplay();
		Disp.setBounds(10, 160, 713, 399);
		panel_3.add(Disp); 
		
		JButton btnNewButton_8_2 = new JButton("Refresh");
		btnNewButton_8_2.setBackground(new Color(51, 102, 102));
		btnNewButton_8_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.remove(Disp);

		        // Create a new CourseDisplay and add it to the panel
		        Disp = new StudentDisplay();
		        Disp.setBounds(29, 191, 678, 331);
		        panel_3.add(Disp);
		        // Repaint the panel to reflect the changes
		        panel_3.revalidate();
		        panel_3.repaint();
			}
		});
		btnNewButton_8_2.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 16));
		btnNewButton_8_2.setBounds(10, 679, 115, 33);
		panel_3.add(btnNewButton_8_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(128, 128, 128));
		tabbedPane.addTab("Teachers", null, panel_5, null);
		panel_5.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(192, 192, 192));
		panel_8.setBounds(0, 0, 733, 88);
		panel_5.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_3_1 = new JLabel("Teacher details");
		lblNewLabel_3_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_3_1.setBounds(254, 24, 228, 38);
		panel_8.add(lblNewLabel_3_1);
		
		JButton btnNewButton_5_1_1 = new JButton("Add Teacher");
		btnNewButton_5_1_1.setBackground(new Color(211, 211, 211));
		btnNewButton_5_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTeacher Add = new AddTeacher();
				Add.setVisible(true);
			}
		});
		btnNewButton_5_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		btnNewButton_5_1_1.setBounds(10, 98, 125, 50);
		panel_5.add(btnNewButton_5_1_1);
		
		JButton btnNewButton_6_1_1 = new JButton("Edit Teacher");
		btnNewButton_6_1_1.setBackground(new Color(211, 211, 211));
		btnNewButton_6_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditTeacher Edit = new EditTeacher();
				Edit.setVisible(true);
			}
		});
		btnNewButton_6_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		btnNewButton_6_1_1.setBounds(305, 98, 125, 50);
		panel_5.add(btnNewButton_6_1_1);
		
		JButton btnNewButton_7_1_1 = new JButton("Delete Teacher");
		btnNewButton_7_1_1.setBackground(new Color(211, 211, 211));
		btnNewButton_7_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteTeacher Delete = new DeleteTeacher();
				Delete.setVisible(true);
			}
		});
		btnNewButton_7_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		btnNewButton_7_1_1.setBounds(603, 98, 120, 50);
		panel_5.add(btnNewButton_7_1_1);
		
		Tdisplay = new TeacherDisplay();
		Tdisplay.setBounds(10, 158, 713, 410);
		panel_5.add(Tdisplay); 
		
		JButton btnNewButton_8_1 = new JButton("Refresh");
		btnNewButton_8_1.setBackground(new Color(51, 102, 102));
		btnNewButton_8_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_5.remove(Tdisplay);

		        Tdisplay = new TeacherDisplay();
		        Tdisplay.setBounds(29, 191, 678, 331);
		        panel_5.add(Tdisplay);
		        panel_5.revalidate();
		        panel_5.repaint();
			}
		});
		btnNewButton_8_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 16));
		btnNewButton_8_1.setBounds(10, 679, 115, 33);
		panel_5.add(btnNewButton_8_1);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(128, 128, 128));
		tabbedPane.addTab("Admin", null, panel_9, null);
		panel_9.setLayout(null);
		
		JPanel panel_8_1 = new JPanel();
		panel_8_1.setLayout(null);
		panel_8_1.setBackground(Color.LIGHT_GRAY);
		panel_8_1.setBounds(0, 0, 733, 88);
		panel_9.add(panel_8_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Admin details");
		lblNewLabel_3_1_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_3_1_1.setBounds(242, 23, 201, 38);
		panel_8_1.add(lblNewLabel_3_1_1);
		
		JButton btnNewButton_5_1_1_1 = new JButton("Add Admin");
		btnNewButton_5_1_1_1.setBackground(new Color(211, 211, 211));
		btnNewButton_5_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAdmin AAdd = new AddAdmin();
				AAdd.setVisible(true);
			}
		});
		btnNewButton_5_1_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		btnNewButton_5_1_1_1.setBounds(10, 98, 125, 50);
		panel_9.add(btnNewButton_5_1_1_1);
		
		JButton btnNewButton_6_1_1_1 = new JButton("Edit Admin");
		btnNewButton_6_1_1_1.setBackground(new Color(211, 211, 211));
		btnNewButton_6_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditAdmin Aedit = new EditAdmin();
				Aedit.setVisible(true);
			}
		});
		btnNewButton_6_1_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		btnNewButton_6_1_1_1.setBounds(305, 98, 125, 50);
		panel_9.add(btnNewButton_6_1_1_1);
		
		JButton btnNewButton_7_1_1_1 = new JButton("Delete Admin");
		btnNewButton_7_1_1_1.setBackground(new Color(211, 211, 211));
		btnNewButton_7_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteAdmin Adel = new DeleteAdmin();
				Adel.setVisible(true);
			}
		});
		btnNewButton_7_1_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		btnNewButton_7_1_1_1.setBounds(598, 98, 125, 50);
		panel_9.add(btnNewButton_7_1_1_1);
		
		Adisplay = new AdminDisplay();
		Adisplay.setBounds(10, 158, 713, 413);
		panel_9.add(Adisplay);
		
		JButton btnNewButton_8_3 = new JButton("Refresh");
		btnNewButton_8_3.setBackground(new Color(51, 102, 102));
		btnNewButton_8_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_9.remove(Adisplay);

		        // Create a new CourseDisplay and add it to the panel
		        Adisplay = new AdminDisplay();
		        Adisplay.setBounds(29, 191, 678, 331);
		        panel_9.add(Adisplay);
		        // Repaint the panel to reflect the changes
		        panel_9.revalidate();
		        panel_9.repaint();
			}
		});
		btnNewButton_8_3.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 16));
		btnNewButton_8_3.setBounds(10, 679, 115, 33);
		panel_9.add(btnNewButton_8_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(128, 128, 128));
		tabbedPane.addTab("Report", null, panel_4, null);
		panel_4.setLayout(null);
		
		JPanel panel_8_2 = new JPanel();
		panel_8_2.setBounds(0, 0, 733, 88);
		panel_8_2.setLayout(null);
		panel_8_2.setBackground(Color.LIGHT_GRAY);
		panel_4.add(panel_8_2);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Result");
		lblNewLabel_3_1_2.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_3_1_2.setBounds(303, 23, 106, 38);
		panel_8_2.add(lblNewLabel_3_1_2);
		
		JButton btnNewButton_5_1_1_1_1 = new JButton("Add Marks");
		btnNewButton_5_1_1_1_1.setBackground(new Color(211, 211, 211));
		btnNewButton_5_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddMarks MAdd = new AddMarks();
				MAdd.setVisible(true);
			}
		});
		btnNewButton_5_1_1_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		btnNewButton_5_1_1_1_1.setBounds(132, 98, 130, 65);
		panel_4.add(btnNewButton_5_1_1_1_1);
		
		JButton btnNewButton_6_1_1_1_1 = new JButton("Edit Marks");
		btnNewButton_6_1_1_1_1.setBackground(new Color(211, 211, 211));
		btnNewButton_6_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    EditMarks MEdit = new EditMarks();
				MEdit.setVisible(true);
			}
		});
		btnNewButton_6_1_1_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		btnNewButton_6_1_1_1_1.setBounds(459, 98, 130, 65);
		panel_4.add(btnNewButton_6_1_1_1_1);
		
		RDisp = new ResultDisplay();
		RDisp.setBounds(10, 173, 713, 376);
		panel_4.add(RDisp);
		
		JButton btnNewButton_8_3_1 = new JButton("Refresh");
		btnNewButton_8_3_1.setBackground(new Color(51, 102, 102));
		btnNewButton_8_3_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 16));
		btnNewButton_8_3_1.setBounds(10, 679, 115, 33);
		panel_4.add(btnNewButton_8_3_1);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(128, 128, 128));
		tabbedPane.addTab("Setting", null, panel_10, null);
		panel_10.setLayout(null);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(192, 192, 192));
		panel_11.setBounds(0, 0, 733, 88);
		panel_10.add(panel_11);
		panel_11.setLayout(null);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Setting");
		lblNewLabel_3_1_1_1.setBounds(303, 21, 122, 35);
		lblNewLabel_3_1_1_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 30));
		panel_11.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_6 = new JLabel(loggedName);
		lblNewLabel_6.setFont(new Font("Franklin Gothic Demi", Font.ITALIC, 14));
		lblNewLabel_6.setBounds(10, 10, 88, 27);
		panel_11.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(loggedEmail);
		lblNewLabel_7.setFont(new Font("Franklin Gothic Demi", Font.ITALIC, 14));
		lblNewLabel_7.setBounds(10, 39, 141, 27);
		panel_11.add(lblNewLabel_7);
		
		Fn = new JTextField();
		Fn.setColumns(10);
		Fn.setBounds(202, 143, 485, 34);
		panel_10.add(Fn);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Full Name:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_1.setBounds(47, 143, 124, 34);
		panel_10.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Email:");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_1_1.setBounds(96, 205, 63, 34);
		panel_10.add(lblNewLabel_1_1_1_1_1_1);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(202, 210, 485, 34);
		panel_10.add(email);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Security");
		lblNewLabel_3_1_1_1_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_3_1_1_1_1.setBounds(334, 294, 122, 35);
		panel_10.add(lblNewLabel_3_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Old Password:");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(47, 369, 150, 34);
		panel_10.add(lblNewLabel_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_2 = new JLabel("New Password:");
		lblNewLabel_1_1_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_1_1_2.setBounds(32, 438, 163, 34);
		panel_10.add(lblNewLabel_1_1_1_1_1_1_2);
		
		Old = new JPasswordField();
		Old.setBounds(202, 371, 480, 34);
		panel_10.add(Old);
		
		New = new JPasswordField();
		New.setBounds(207, 438, 480, 34);
		panel_10.add(New);
		
		JButton btnNewButton_8_4_1 = new JButton("Update");
		btnNewButton_8_4_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_8_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Oldpassword = Old.getText();
				boolean checkpass = Oldpassword.equals(loggedOpass);
				String fname = Fn.getText();
				String Em = email.getText();
				
				if(checkpass==true) {
					String newpassword = New.getText();
					try {
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "");

                        String query = "UPDATE "+ loggedRole + " SET Password=?, Fullname=?, Email=? WHERE ID="+loggedId;
                        
                        
                        PreparedStatement stmt = connection.prepareStatement(query);

                        stmt.setString(1, newpassword);
                        stmt.setString(2, fname);
                        stmt.setString(3, Em);
                        

                        int changed = stmt.executeUpdate();

                        if (changed > 0) {
                            JOptionPane.showMessageDialog(null, "Password Changed!!!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed !!!.");
                        }
                        stmt.close();
                        connection.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
				}else {
					JOptionPane.showMessageDialog(null, "Incorrect old password");
				}
				dispose();
				Login log = new Login();
				log.setVisible(true);
			}
		});
		btnNewButton_8_4_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		btnNewButton_8_4_1.setBounds(334, 536, 131, 33);
		panel_10.add(btnNewButton_8_4_1);
		
		if(userRole == "students") {
			btnNewButton_7_1.setVisible(false);
			 btnNewButton_5 .setVisible(false);
			 btnNewButton_6.setVisible(false);
			 btnNewButton_7.setVisible(false);
			 btnNewButton_5_1.setVisible(false);
			 btnNewButton_6_1.setVisible(false);
			 btnNewButton_5_1_1 .setVisible(false);
			 btnNewButton_6_1_1.setVisible(false);
			 btnNewButton_7_1_1.setVisible(false);
			 btnNewButton_5_1_1_1.setVisible(false);
			 btnNewButton_6_1_1_1.setVisible(false); 
			 btnNewButton_7_1_1_1 .setVisible(false);
			 btnNewButton_5_1_1_1_1.setVisible(false);
			 btnNewButton_6_1_1_1_1.setVisible(false);
			 
		}
		if(userRole == "teacher") {
			btnNewButton_7_1.setVisible(false);
			 btnNewButton_5 .setVisible(false);
			 btnNewButton_6.setVisible(false);
			 btnNewButton_7.setVisible(false);
			 btnNewButton_5_1.setVisible(false);
			 btnNewButton_6_1.setVisible(false);
			 btnNewButton_5_1_1 .setVisible(false);
			 btnNewButton_6_1_1.setVisible(false);
			 btnNewButton_7_1_1.setVisible(false);
			 btnNewButton_5_1_1_1.setVisible(false);
			 btnNewButton_6_1_1_1.setVisible(false); 
			 btnNewButton_7_1_1_1 .setVisible(false);
			 btnNewButton_5_1_1_1_1.setVisible(true);
			 btnNewButton_6_1_1_1_1.setVisible(true);
			 
		}
		
		
	}
}
