package exp;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Addstudent extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField roll;
	private JTextField course;
	private JTextField fee;
	private JTextField paid;
	private JTextField due;
	private JTextField address;
	private JTextField city;
	private JTextField state;
	private JTextField country;
	private JTextField contact;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addstudent frame = new Addstudent();
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
	public Addstudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,2000,800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Student");
		lblNewLabel.setBackground(new Color(32, 178, 170));
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 26));
		lblNewLabel.setBounds(736, 10, 194, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(530, 86, 67, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("RollNo.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(530, 150, 67, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Course");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(530, 216, 67, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fee");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(530, 268, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Paid");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(530, 337, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Due");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(530, 403, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Address");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(530, 479, 67, 13);
		contentPane.add(lblNewLabel_7);
		
		name = new JTextField();
		name.setBounds(761, 83, 182, 19);
		contentPane.add(name);
		name.setColumns(10);
		
		roll = new JTextField();
		roll.setBounds(764, 147, 179, 19);
		contentPane.add(roll);
		roll.setColumns(10);
		
		course = new JTextField();
		course.setBounds(761, 213, 182, 19);
		contentPane.add(course);
		course.setColumns(10);
		
		fee = new JTextField();
		fee.setBounds(766, 265, 177, 19);
		contentPane.add(fee);
		fee.setColumns(10);
		
		paid = new JTextField();
		paid.setBounds(764, 334, 179, 19);
		contentPane.add(paid);
		paid.setColumns(10);
		
		due = new JTextField();
		due.setBounds(767, 400, 176, 19);
		contentPane.add(due);
		due.setColumns(10);
		
		address = new JTextField();
		address.setBounds(771, 464, 172, 44);
		contentPane.add(address);
		address.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("city");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(530, 560, 45, 13);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("State");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(530, 612, 45, 13);
		contentPane.add(lblNewLabel_9);
		
		city = new JTextField();
		city.setBounds(771, 557, 172, 19);
		contentPane.add(city);
		city.setColumns(10);
		
		state = new JTextField();
		state.setBounds(771, 609, 172, 19);
		contentPane.add(state);
		state.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Country");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(530, 661, 67, 13);
		contentPane.add(lblNewLabel_10);
		
		country = new JTextField();
		country.setBounds(777, 658, 166, 19);
		contentPane.add(country);
		country.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Contact No.");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_11.setBounds(521, 710, 96, 19);
		contentPane.add(lblNewLabel_11);
		
		contact = new JTextField();
		contact.setBounds(777, 710, 166, 19);
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
				String fee1 = fee.getText();
				int feee = Integer.parseInt(fee1);
				String p = paid.getText();
				int pa = Integer.parseInt(p);
				String d = due.getText();
				int da = Integer.parseInt(d);
				String c = contact.getText();
				int ca = Integer.parseInt(c);
				String ro = roll.getText();
				int r = Integer.parseInt(ro);
String sql="insert into Addstudent values('"+name.getText()+"',"+r+",'"+course.getText()+"',"+feee+","+pa+","+da+",'"+address.getText()+"','"+city.getText()+"','"+state.getText()+"','"+country.getText()+"',"+ca+")";					
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"Student Added");
					
					con.close();
				}
				catch(Exception p) {System.out.print(p);}
			}
		});
		btnNewButton.setBounds(1114, 266, 96, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Accountantsec obj = new Accountantsec();
				obj.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(1114, 371, 96, 45);
		contentPane.add(btnNewButton_1);
	}

}
