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
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Font;
import java.awt.Color;
public class login extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 2000, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label1 = new JLabel("Username");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label1.setForeground(new Color(255, 255, 255));
		label1.setBounds(495, 139, 99, 29);
		contentPane.add(label1);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(495, 287, 99, 29);
		contentPane.add(lblNewLabel);
		
		user = new JTextField();
		user.setBounds(755, 139, 170, 34);
		contentPane.add(user);
		user.setColumns(10);
		
		pas = new JPasswordField();
		pas.setBounds(762, 287, 163, 34);
		contentPane.add(pas);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBackground(new Color(47, 79, 79));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/feereport1","root","");
					//System.out.println("Connected");
				Statement stmt = con.createStatement();
					String sql = "select * from admin where Username ='"+user.getText()+"' and Password = '"+pas.getText().toString()+"'";
				//	System.out.println(user.getText() +" PAssword "+pas.getPassword().toString() );
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next())
					{
						Adminsec obj = new Adminsec();
						obj.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null,"Invalid Username Or Password");
					con.close();
				}
				catch(Exception p) {System.out.print(p);}
				/*finally {
					System.out.println("heyy");
				}*/
			}
		});
		btnNewButton.setBounds(683, 476, 170, 34);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("ADMIN LOGIN");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 26));
		lblNewLabel_1.setBounds(669, 25, 238, 29);
		contentPane.add(lblNewLabel_1);
	}
}
