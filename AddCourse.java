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

public class AddCourse extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> coursename;
    private JComboBox<String> years;

    private void addCourse1(String Name, int years) {
        String url = "jdbc:mysql://localhost:3306/CMS";
        String dbUsername = "root";
        String dbPassword = "";

        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword)) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO courses (Name, years) VALUES (?, ?);");
            preparedStatement.setString(1, Name);
            preparedStatement.setInt(2, years);

            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Added successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the frame.
     */
    public AddCourse() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 454, 495);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("CourseName");
        lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
        lblNewLabel.setBounds(25, 165, 119, 24);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Years");
        lblNewLabel_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
        lblNewLabel_1.setBounds(71, 241, 73, 16);
        contentPane.add(lblNewLabel_1);

        JButton btnNewButton = new JButton("ADD");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String courseN = (String) coursename.getSelectedItem();
                String year = (String) years.getSelectedItem();
                if (!courseN.isEmpty() && !year.isEmpty()) {
                    int Year = Integer.parseInt(year);
                    addCourse1(courseN, Year);
                } else {
                    JOptionPane.showMessageDialog(null, "Input cannot be Empty!!");
                }

            }
        });
        btnNewButton.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 16));
        btnNewButton.setBounds(154, 314, 97, 41);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Cancel");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnNewButton_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 15));
        btnNewButton_1.setBounds(275, 315, 102, 41);
        contentPane.add(btnNewButton_1);

        JLabel lblNewLabel_2 = new JLabel("ADD COURSE");
        lblNewLabel_2.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 30));
        lblNewLabel_2.setBounds(135, 61, 199, 51);
        contentPane.add(lblNewLabel_2);

        // Corrected initialization to use class-level fields
        coursename = new JComboBox<String>();
        coursename.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 14));
        coursename.setModel(new DefaultComboBoxModel<String>(new String[] { "BSc(hons)Computer Science", "BIBM" }));
        coursename.setBounds(154, 160, 223, 33);
        contentPane.add(coursename);

        // Corrected initialization to use class-level fields
        years = new JComboBox<String>();
        years.setModel(new DefaultComboBoxModel<String>(new String[] { "4", "5", "6" }));
        years.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 14));
        years.setBounds(154, 235, 223, 33);
        contentPane.add(years);
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddCourse frame = new AddCourse();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
