package JavaPro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Color;

public class dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTabbedPane tabbedPane;
    private JTextField textField;
    private CourseDisplay Display;
    private JTextField textField_1;
    private StudentDisplay Disp;
    private JTextField textField_2;
    private TeacherDisplay Tdisplay;
    private JTextField textField_3;
    private AdminDisplay Adisplay;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboard frame = new dashboard();
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
	public dashboard() {
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
		btnNewButton.setBounds(65, 107, 143, 63);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Courses");
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnNewButton_1.setBounds(65, 203, 143, 63);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Student");
		btnNewButton_2.setBackground(new Color(192, 192, 192));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(65, 492, 143, 63);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Teachers");
		btnNewButton_3.setBackground(new Color(192, 192, 192));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		btnNewButton_3.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		btnNewButton_3.setBounds(65, 395, 143, 63);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Logout");
		btnNewButton_4.setBackground(new Color(180, 16, 32));
		btnNewButton_4.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
        		dispose();
			}
		});
		btnNewButton_4.setBounds(77, 693, 131, 33);
		panel.add(btnNewButton_4);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 616, 10, 10);
		panel.add(panel_4);
		
		JLabel lblNewLabel_2 = new JLabel("CMS");
		lblNewLabel_2.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2.setBounds(100, 44, 75, 53);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton_8 = new JButton("Refresh");
		btnNewButton_8.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_8.setBounds(77, 650, 131, 33);
		panel.add(btnNewButton_8);
		
		JButton btnNewButton_3_1 = new JButton("Admin");
		btnNewButton_3_1.setBackground(new Color(192, 192, 192));
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);
			}
		});
		btnNewButton_3_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		btnNewButton_3_1.setBounds(65, 301, 143, 63);
		panel.add(btnNewButton_3_1);
		
		JButton btnNewButton_8_4 = new JButton("Setting");
		btnNewButton_8_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(5);
			}
		});
		btnNewButton_8_4.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		btnNewButton_8_4.setBounds(77, 607, 131, 33);
		panel.add(btnNewButton_8_4);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(292, 10, 738, 749);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 128));
		tabbedPane.addTab("Home", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 128, 128));
		tabbedPane.addTab("Courses", null, panel_2, null);
		tabbedPane.setBackgroundAt(1, Color.YELLOW);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Course Name:");
		lblNewLabel_1.setBounds(13, 98, 148, 34);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_2.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(168, 103, 237, 34);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 0, 733, 88);
		panel_6.setBackground(new Color(192, 192, 192));
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Courses");
		lblNewLabel.setBounds(273, 22, 122, 37);
		lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 30));
		panel_6.add(lblNewLabel);
		
		JButton btnNewButton_5 = new JButton("Add Course");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCourse Add = new AddCourse();
				Add.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(404, 103, 99, 34);
		btnNewButton_5.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		panel_2.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Edit Course");
		btnNewButton_6.setBounds(503, 103, 99, 34);
		btnNewButton_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EditCourse Edit = new EditCourse();
					Edit.setVisible(true);
			}
		});
		btnNewButton_6.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		panel_2.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Delete Course");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteCourse Delete = new DeleteCourse();
				Delete.setVisible(true);
			}
		});
		btnNewButton_7.setBounds(601, 103, 106, 34);
		btnNewButton_7.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		panel_2.add(btnNewButton_7);
		
		Display= new CourseDisplay();
		Display.setBounds(29, 178, 678, 331);
		panel_2.add(Display);
		
		JButton btnNewButton_9 = new JButton("Refresh");
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
		btnNewButton_9.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 15));
		btnNewButton_9.setBounds(32, 659, 99, 27);
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
		
		JLabel lblNewLabel_1_1 = new JLabel("Course Name:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(29, 98, 148, 34);
		panel_3.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(173, 98, 237, 34);
		panel_3.add(textField_1);
		
		JButton btnNewButton_5_1 = new JButton("Add ");
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudent SAdd = new AddStudent();
				SAdd.setVisible(true);
			}
		});
		btnNewButton_5_1.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		btnNewButton_5_1.setBounds(410, 98, 99, 34);
		panel_3.add(btnNewButton_5_1);
		
		JButton btnNewButton_6_1 = new JButton("Edit ");
		btnNewButton_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditStudent SEdit = new EditStudent();
				SEdit.setVisible(true);
			}
		});
		btnNewButton_6_1.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		btnNewButton_6_1.setBounds(508, 98, 99, 34);
		panel_3.add(btnNewButton_6_1);
		
		JButton btnNewButton_7_1 = new JButton("Delete ");
		btnNewButton_7_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteStudent Sdel = new DeleteStudent();
				Sdel.setVisible(true);
			}
		});
		btnNewButton_7_1.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		btnNewButton_7_1.setBounds(606, 98, 106, 34);
		panel_3.add(btnNewButton_7_1);
		
		Disp = new StudentDisplay();
		Disp.setBounds(29, 164, 683, 358);
		panel_3.add(Disp); 
		
		JButton btnNewButton_8_2 = new JButton("Refresh");
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
		btnNewButton_8_2.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		btnNewButton_8_2.setBounds(29, 655, 131, 33);
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
		lblNewLabel_3_1.setBounds(243, 23, 228, 38);
		panel_8.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Course Name:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(22, 98, 148, 34);
		panel_5.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(180, 98, 237, 34);
		panel_5.add(textField_2);
		
		JButton btnNewButton_5_1_1 = new JButton("Add ");
		btnNewButton_5_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTeacher Add = new AddTeacher();
				Add.setVisible(true);
			}
		});
		btnNewButton_5_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		btnNewButton_5_1_1.setBounds(416, 98, 99, 34);
		panel_5.add(btnNewButton_5_1_1);
		
		JButton btnNewButton_6_1_1 = new JButton("Edit ");
		btnNewButton_6_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditTeacher Edit = new EditTeacher();
				Edit.setVisible(true);
			}
		});
		btnNewButton_6_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		btnNewButton_6_1_1.setBounds(514, 98, 99, 34);
		panel_5.add(btnNewButton_6_1_1);
		
		JButton btnNewButton_7_1_1 = new JButton("Delete ");
		btnNewButton_7_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteTeacher Delete = new DeleteTeacher();
				Delete.setVisible(true);
			}
		});
		btnNewButton_7_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		btnNewButton_7_1_1.setBounds(606, 98, 106, 34);
		panel_5.add(btnNewButton_7_1_1);
		
		Tdisplay = new TeacherDisplay();
	    Tdisplay.setBounds(29, 191, 683, 331);
		panel_5.add(Tdisplay); 
		
		JButton btnNewButton_8_1 = new JButton("Refresh");
		btnNewButton_8_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_5.remove(Tdisplay);

		        // Create a new CourseDisplay and add it to the panel
		        Tdisplay = new TeacherDisplay();
		        Tdisplay.setBounds(29, 191, 678, 331);
		        panel_5.add(Tdisplay);
		        // Repaint the panel to reflect the changes
		        panel_5.revalidate();
		        panel_5.repaint();
			}
		});
		btnNewButton_8_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		btnNewButton_8_1.setBounds(29, 652, 131, 33);
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
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Course Name:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1.setBounds(10, 98, 148, 34);
		panel_9.add(lblNewLabel_1_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(156, 98, 237, 34);
		panel_9.add(textField_3);
		
		JButton btnNewButton_5_1_1_1 = new JButton("Add ");
		btnNewButton_5_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAdmin AAdd = new AddAdmin();
				AAdd.setVisible(true);
			}
		});
		btnNewButton_5_1_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		btnNewButton_5_1_1_1.setBounds(392, 98, 99, 34);
		panel_9.add(btnNewButton_5_1_1_1);
		
		JButton btnNewButton_6_1_1_1 = new JButton("Edit ");
		btnNewButton_6_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditAdmin Aedit = new EditAdmin();
				Aedit.setVisible(true);
			}
		});
		btnNewButton_6_1_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		btnNewButton_6_1_1_1.setBounds(488, 98, 99, 34);
		panel_9.add(btnNewButton_6_1_1_1);
		
		JButton btnNewButton_7_1_1_1 = new JButton("Delete ");
		btnNewButton_7_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteAdmin Adel = new DeleteAdmin();
				Adel.setVisible(true);
			}
		});
		btnNewButton_7_1_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		btnNewButton_7_1_1_1.setBounds(586, 98, 106, 34);
		panel_9.add(btnNewButton_7_1_1_1);
		
		Adisplay = new AdminDisplay();
		Adisplay.setBounds(29, 191, 683, 331);
		panel_9.add(Adisplay);
		
		JButton btnNewButton_8_3 = new JButton("Refresh");
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
		btnNewButton_8_3.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		btnNewButton_8_3.setBounds(29, 646, 131, 33);
		panel_9.add(btnNewButton_8_3);
		
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
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(202, 143, 485, 34);
		panel_10.add(textField_4);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Full Name:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_1.setBounds(47, 143, 124, 34);
		panel_10.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Email:");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_1_1.setBounds(96, 205, 63, 34);
		panel_10.add(lblNewLabel_1_1_1_1_1_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(202, 210, 485, 34);
		panel_10.add(textField_5);
		
		JButton btnNewButton_8_4_1 = new JButton("Update Profile");
		btnNewButton_8_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_8_4_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 15));
		btnNewButton_8_4_1.setBounds(317, 503, 139, 40);
		panel_10.add(btnNewButton_8_4_1);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Security");
		lblNewLabel_3_1_1_1_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_3_1_1_1_1.setBounds(317, 297, 122, 35);
		panel_10.add(lblNewLabel_3_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Old Password:");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(47, 369, 150, 34);
		panel_10.add(lblNewLabel_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_2 = new JLabel("New Password:");
		lblNewLabel_1_1_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_1_1_2.setBounds(32, 438, 163, 34);
		panel_10.add(lblNewLabel_1_1_1_1_1_1_2);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(202, 369, 485, 34);
		panel_10.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(202, 438, 485, 34);
		panel_10.add(textField_7);
		
	}
}
