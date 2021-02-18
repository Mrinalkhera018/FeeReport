package exp;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

public class Editstudent extends JFrame {

	private JPanel contentPane;
	private JTextField rollno;
	private JTable table;
	private JTextField name;
	private JTextField rf;
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
					Editstudent frame = new Editstudent();
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
	public Editstudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 2000, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Roll No.");
		lblNewLabel.setBounds(793, 10, 69, 13);
		contentPane.add(lblNewLabel);
		
		rollno = new JTextField();
		rollno.setBounds(1095, 13, 212, 19);
		contentPane.add(rollno);
		rollno.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Load Record");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/feereport1","root","");
					String r = rollno.getText();
					int ro = Integer.parseInt(r);
					String sql = "select * from addstudent where RollNo = "+ ro+ "";
					PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs = pst.executeQuery(sql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));						
				    con.close();
				}
				catch(Exception p) {System.out.print(p);}
			}
		});
		btnNewButton.setBounds(1363, 13, 156, 21);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(10, 42, 1509, 49);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/feereport1","root","");
					Statement stmt = con.createStatement();
				//	JOptionPane.showMessageDialog(null,"Connected");
					String fee1 = fee.getText();
					int feee = Integer.parseInt(fee1);
					//System.out.println(feee);
					String p = paid.getText();
					int pa = Integer.parseInt(p);
					//System.out.println(pa);
					String d = due.getText();
					int da = Integer.parseInt(d);
					//System.out.println(da);
					String c = contact.getText();
					int ca = Integer.parseInt(c);
					//System.out.println(ca);
					String ro = rf.getText();
					int r = Integer.parseInt(ro);
					//System.out.println(r);
					String r1 = rollno.getText();
					int rol = Integer.parseInt(r1);
					//System.out.println(rol);
String sql="update addstudent set Name='"+name.getText()+"',RollNo="+r+",Course='"+course.getText()+"',Fee="+feee+",Paid="+pa+",Due="+da+",Address='"+address.getText()+"',City='"+city.getText()+"',State='"+state.getText()+"',Country='"+country.getText()+"',ContactNo="+ca+" where RollNo="+rol+"";
/*System.out.println("Name " +name.getText());
System.out.println("Name " +name.getText());
System.out.println("Name " +name.getText());
System.out.println("Name " +name.getText());
System.out.println("Name " +name.getText());
System.out.println("Name " +name.getText());
System.out.println("Name " +name.getText());
System.out.println("Name " +name.getText());*/
                    stmt.executeUpdate(sql);
                  //  System.out.println(sql);
                   JOptionPane.showMessageDialog(null,"Record Updated");
					con.close();
				}
				catch(Exception h) {}
			}
		});
		btnNewButton_1.setBounds(632, 698, 127, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(632, 118, 69, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("RollNo.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(632, 169, 69, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Course");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(632, 216, 69, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fee");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(632, 273, 69, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Paid");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(632, 323, 69, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Due");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(632, 386, 69, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Address");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(632, 454, 69, 13);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("City");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(632, 528, 69, 13);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("State");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(632, 585, 69, 13);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Country");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(632, 624, 69, 13);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("ContactNo.");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_11.setBounds(632, 657, 105, 13);
		contentPane.add(lblNewLabel_11);
		
		name = new JTextField();
		name.setBounds(812, 112, 161, 19);
		contentPane.add(name);
		name.setColumns(10);
		
		rf = new JTextField();
		rf.setBounds(812, 169, 161, 19);
		contentPane.add(rf);
		rf.setColumns(10);
		
		course = new JTextField();
		course.setBounds(812, 213, 161, 19);
		contentPane.add(course);
		course.setColumns(10);
		
		fee = new JTextField();
		fee.setBounds(812, 270, 161, 19);
		contentPane.add(fee);
		fee.setColumns(10);
		
		paid = new JTextField();
		paid.setBounds(812, 323, 161, 19);
		contentPane.add(paid);
		paid.setColumns(10);
		
		due = new JTextField();
		due.setBounds(812, 383, 161, 19);
		contentPane.add(due);
		due.setColumns(10);
		
		address = new JTextField();
		address.setBounds(812, 441, 161, 40);
		contentPane.add(address);
		address.setColumns(10);
		
		city = new JTextField();
		city.setBounds(812, 525, 161, 19);
		contentPane.add(city);
		city.setColumns(10);
		
		state = new JTextField();
		state.setBounds(812, 582, 161, 19);
		contentPane.add(state);
		state.setColumns(10);
		
		country = new JTextField();
		country.setBounds(812, 621, 161, 19);
		contentPane.add(country);
		country.setColumns(10);
		
		contact = new JTextField();
		contact.setBounds(812, 654, 161, 19);
		contentPane.add(contact);
		contact.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Accountantsec obj = new Accountantsec();
				obj.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(868, 698, 115, 21);
		contentPane.add(btnNewButton_2);
	}
}
