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
		btnNewButton.setBounds(65, 150, 143, 63);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Courses");
		btnNewButton_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnNewButton_1.setBounds(65, 246, 143, 63);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Student");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(65, 345, 143, 63);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Teachers");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		btnNewButton_3.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		btnNewButton_3.setBounds(65, 447, 143, 63);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Logout");
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
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(287, 10, 738, 749);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Home", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 128, 128));
		tabbedPane.addTab("Courses", null, panel_2, null);
		tabbedPane.setBackgroundAt(1, Color.YELLOW);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Course Name:");
		lblNewLabel_1.setBounds(22, 117, 148, 34);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_2.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(171, 117, 237, 34);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(192, 192, 192));
		panel_6.setBounds(0, 0, 733, 90);
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Courses");
		lblNewLabel.setBounds(303, 26, 122, 37);
		lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 30));
		panel_6.add(lblNewLabel);
		
		JButton btnNewButton_5 = new JButton("Add Course");
		btnNewButton_5.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		btnNewButton_5.setBounds(405, 117, 99, 34);
		panel_2.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Edit Course");
		btnNewButton_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_6.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		btnNewButton_6.setBounds(504, 117, 99, 34);
		panel_2.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Delete Course");
		btnNewButton_7.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		btnNewButton_7.setBounds(601, 117, 106, 34);
		panel_2.add(btnNewButton_7);
		
		Display= new CourseDisplay();
		Display.setBounds(29, 191, 678, 331);
		panel_2.add(Display);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(128, 128, 128));
		tabbedPane.addTab("Student", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(192, 192, 192));
		panel_7.setBounds(0, 0, 733, 91);
		panel_3.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Student details");
		lblNewLabel_3.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_3.setBounds(250, 28, 218, 38);
		panel_7.add(lblNewLabel_3);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Teachers", null, panel_5, null);
	}
}
