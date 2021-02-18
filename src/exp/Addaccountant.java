package exp;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Font;
import java.awt.Color;
public class Addaccountant extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField user;
	private JPasswordField pas;
	private JTextField email;
	private JTextField contact;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addaccountant frame = new Addaccountant();
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
	public Addaccountant() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 2000, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Accountant");
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 26));
		lblNewLabel.setBounds(695, 25, 228, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(558, 121, 65, 13);
		contentPane.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setBounds(756, 118, 180, 28);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(558, 246, 85, 13);
		contentPane.add(lblNewLabel_2);
		
		user = new JTextField();
		user.setBounds(756, 243, 180, 28);
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(558, 396, 85, 13);
		contentPane.add(lblNewLabel_3);
		
		pas = new JPasswordField();
		pas.setBounds(757, 393, 179, 28);
		contentPane.add(pas);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(558, 509, 65, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("Contact No.");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(559, 615, 99, 13);
		contentPane.add(lblNewLabel_6);
		
		email = new JTextField();
		email.setBounds(756, 506, 180, 28);
		contentPane.add(email);
		email.setColumns(10);
		
		contact = new JTextField();
		contact.setBounds(756, 612, 180, 28);
		contentPane.add(contact);
		contact.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/feereport1","root","");
					//System.out.println("Connected");
				Statement stmt = con.createStatement();
				
				String p = pas.getText();
				int pa = Integer.parseInt(p);
				
				String c = contact.getText();
				int ca = Integer.parseInt(c);
String sql="insert into Addaccountant values('"+name.getText()+"','"+user.getText()+"',"+pa+",'"+email.getText()+"',"+ca+")";					
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"Accountant Added");
					
					con.close();
				}
				catch(Exception p) {System.out.print(p);}
			}
		});
		btnNewButton.setBounds(1103, 327, 105, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adminsec obj = new Adminsec();
				obj.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(1103, 416, 105, 37);
		contentPane.add(btnNewButton_1);
	}

}
