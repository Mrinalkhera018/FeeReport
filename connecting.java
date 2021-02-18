import java.sql.*;
public class Connecting {
   public static void main(String args[]) {
	   try {
	     Class.forName("com.mysql.cj.jdbc.Driver");
	     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC","root","");
	     system.out.print(con);
	     }
	     catch(Exception e){}
	     }
	     }