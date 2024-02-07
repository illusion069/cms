package JavaPro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class ReportCard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		lblEmail.setBounds(139, 185, 138, 24);
		contentPane.add(lblEmail);
		
		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		lblCourse.setBounds(139, 233, 138, 24);
		contentPane.add(lblCourse);
		
		JLabel lblLevel = new JLabel("Level:");
		lblLevel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		lblLevel.setBounds(139, 282, 138, 24);
		contentPane.add(lblLevel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(276, 134, 646, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(276, 184, 646, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(276, 232, 646, 33);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(276, 281, 646, 33);
		contentPane.add(lblNewLabel_4);
		
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
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(165, 411, 89, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("New label");
		lblNewLabel_5_1.setBounds(165, 471, 100, 13);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("New label");
		lblNewLabel_5_2.setBounds(165, 544, 100, 13);
		contentPane.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("New label");
		lblNewLabel_5_3.setBounds(654, 411, 80, 13);
		contentPane.add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_5_4 = new JLabel("New label");
		lblNewLabel_5_4.setBounds(654, 471, 72, 13);
		contentPane.add(lblNewLabel_5_4);
		
		JLabel lblNewLabel_5_5 = new JLabel("New label");
		lblNewLabel_5_5.setBounds(654, 544, 72, 13);
		contentPane.add(lblNewLabel_5_5);
		
		JLabel lblNewLabel_5_6 = new JLabel("New label");
		lblNewLabel_5_6.setBounds(304, 620, 72, 13);
		contentPane.add(lblNewLabel_5_6);
		
		JLabel lblNewLabel_5_7 = new JLabel("New label");
		lblNewLabel_5_7.setBounds(244, 665, 72, 13);
		contentPane.add(lblNewLabel_5_7);
	}
}
