package JavaPro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchCard extends JFrame {

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
					SearchCard frame = new SearchCard();
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
	public SearchCard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Id = new JTextField();
		Id.setColumns(10);
		Id.setBounds(154, 117, 112, 48);
		contentPane.add(Id);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Student Id:");
		lblNewLabel_1_1_1_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 25));
		lblNewLabel_1_1_1_1.setBounds(151, 55, 128, 34);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportCard Rcard = new ReportCard();
				Rcard.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
		btnNewButton.setBounds(154, 193, 112, 45);
		contentPane.add(btnNewButton);
	}
}
