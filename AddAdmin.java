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

public class AddAdmin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField Adimname;
    private JTextField email;
    private JTextField pass;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddAdmin frame = new AddAdmin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void addAdmin1(String name, String email, String password) {
        String url = "jdbc:mysql://localhost:3306/CMS";
        String dbUsername = "root";
        String dbPassword = "";

        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword)) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO admin (Fullname, Email, Password) VALUES (?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);

            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Admin added successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public AddAdmin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 454, 495);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        Adimname = new JTextField();
        Adimname.setBounds(154, 138, 245, 33);
        contentPane.add(Adimname);
        Adimname.setColumns(10);

        JLabel lblNewLabel = new JLabel("AdminName");
        lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
        lblNewLabel.setBounds(28, 139, 138, 24);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Email");
        lblNewLabel_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
        lblNewLabel_1.setBounds(68, 198, 73, 16);
        contentPane.add(lblNewLabel_1);

        email = new JTextField();
        email.setBounds(154, 193, 245, 33);
        contentPane.add(email);
        email.setColumns(10);

        JButton btnNewButton = new JButton("ADD");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String AdminN = Adimname.getText();
                String Em = email.getText();
                String Apassword = pass.getText();
                if (!AdminN.isEmpty() && !Em.isEmpty() && !Apassword.isEmpty()) {
                    addAdmin1(AdminN, Em, Apassword);
                } else {
                    JOptionPane.showMessageDialog(null, "Input cannot be Empty!!");
                }

            }
        });
        btnNewButton.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 16));
        btnNewButton.setBounds(155, 326, 97, 41);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Cancel");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnNewButton_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 15));
        btnNewButton_1.setBounds(298, 327, 102, 41);
        contentPane.add(btnNewButton_1);

        JLabel lblNewLabel_2 = new JLabel("ADD ADMIN");
        lblNewLabel_2.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 30));
        lblNewLabel_2.setBounds(136, 10, 214, 51);
        contentPane.add(lblNewLabel_2);

        pass = new JTextField();
        pass.setColumns(10);
        pass.setBounds(154, 263, 245, 33);
        contentPane.add(pass);

        JLabel lblNewLabel_1_2 = new JLabel("Password");
        lblNewLabel_1_2.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 20));
        lblNewLabel_1_2.setBounds(51, 268, 90, 16);
        contentPane.add(lblNewLabel_1_2);
    }
}
