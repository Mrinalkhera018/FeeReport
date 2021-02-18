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
import java.sql.*;
import java.awt.Color;
import java.awt.Font;
public class Login1 extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JTextField pas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login1 frame = new Login1();
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
	public Login1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 2000, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Accountant Login");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 26));
		lblNewLabel.setBounds(624, 22, 260, 58);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(437, 171, 120, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(437, 314, 120, 33);
		contentPane.add(lblNewLabel_2);
		
		user = new JTextField();
		user.setBounds(663, 167, 221, 33);
		contentPane.add(user);
		user.setColumns(10);
		
		pas = new JTextField();
		pas.setBounds(663, 316, 221, 33);
		contentPane.add(pas);
		pas.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new Color(47, 79, 79));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/feereport1","root","");
					//System.out.println("Connected");
				Statement stmt = con.createStatement();
					String sql = "select * from addaccountant where Username ='"+user.getText()+"' and Password = '"+pas.getText().toString()+"'";
				//	System.out.println(user.getText() +" PAssword "+pas.getPassword().toString() );
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next())
					{
						Accountantsec obj = new Accountantsec();
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
		btnNewButton.setBounds(663, 483, 158, 33);
		contentPane.add(btnNewButton);
	}

}
