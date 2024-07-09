package mysqlex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDPEX {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver"); // registering driver
//      Statement stmt;
		String url = "jdbc:mysql://localhost:3308/class";
		Connection con = DriverManager.getConnection(url, "root", "root");// establish connection
		// System.out.println(con);
		System.out.println("Database dbemp connection suceesfully establish");
		int s_no;
		String sname, address;
		Scanner s = new Scanner(System.in);
		
		while (true) {
			System.out.println();
			System.out.println("Click the 1 - Add details");
			System.out.println("Click the 2 - displaying of Students details by ID");
			System.out.println("Click the 3 - Update of Students details");
			System.out.println("Click the 4 - Delete of Students details");
			System.out.println("Click the 5 - displaying of Students details");
			System.out.println("Click the 6 - displaying of Students count");
			System.out.println("Click the 7 - displaying of Students name order");
			System.out.println("Click the 8- exit");
			System.out.println("Enter the choice :");
			int choice = s.nextInt();
			switch (choice) {
			case 1: {
				System.out.println();
				System.out.println("Enter the s number :");
				s_no = s.nextInt();
				System.out.println();
				System.out.println("Enter the s name :");
				sname = s.next();
				System.out.println();
				System.out.println("Enter the s address :");
				address = s.next();
				System.out.println();
				String q1 = "insert into student values (?,?,?)";  
				PreparedStatement ps = con.prepareStatement(q1);
	              ps.setInt(1, s_no);
	              ps.setString(2, sname);
	              ps.setString(3, address);
	              int n1 = ps.executeUpdate(); 
	              System.out.println(n1);
	              if (n1 > 0)  
	               System.out.println(n1 + " Records Successfully Inserted");  
	              else  
	               System.out.println("Invalid student number");
				break;
			}
			case 2: {
				System.out.println();
				System.out.println("Enter the s number :");
				s_no = s.nextInt();
				System.out.println();
				String q="select * from student where s_no =?";
				PreparedStatement ps =con.prepareStatement(q);
				 ps.setInt(1, s_no);
				 ResultSet rs = ps.executeQuery();	             
			       if(rs.next()) {
			    	   System.out.println("s_no:"+rs.getInt(1));
		                System.out.println("s Name:"+rs.getString(2));
		                System.out.println("s address:"+rs.getString(3));
				break;
			}
			}
			case 3: {
				System.out.println();
				System.out.println("Enter the s number :");
				s_no = s.nextInt();
				System.out.println();
				System.out.println("Enter the s name :");
				sname = s.next();
				System.out.println();
				System.out.println("Enter the s address :");
				address = s.next();
				System.out.println();
				String q1 = "update student set name=?, address=? where s_no=?";  
				PreparedStatement ps = con.prepareStatement(q1);             
	              ps.setString(1, sname);
	              ps.setString(2, address);
	              ps.setInt(3, s_no);
	              int n1 = ps.executeUpdate(); 
	              System.out.println(n1);
	              if (n1 > 0)  
	               System.out.println(n1 + " Records Successfully updated");  
	              else  
	               System.out.println("Invalid student number");
				break;
			}
			case 4: {
				System.out.println();
				System.out.println("Enter the s number :");
				s_no = s.nextInt();
				System.out.println();
				String q ="delete from student where s_no=?";
				PreparedStatement ps =con.prepareStatement(q);
				ps.setInt(1, s_no);
				int n1 = ps.executeUpdate(); 
	              System.out.println(n1);
	              if (n1 > 0)  
	               System.out.println(n1 + " Records deleted Successfully ");  
	              else  
	               System.out.println("Invalid student number");
				break;
			}
			case 5: {
				System.out.println();
				PreparedStatement ps =con.prepareStatement("select * from student ");
				ResultSet rs = ps.executeQuery();
				System.out.println("Get student records:");
				while (rs.next()) {
					System.out.println("s_no:" + rs.getInt(1));
					System.out.println("s Name:" + rs.getString(2));
					System.out.println("s address:" + rs.getString(3));
				}
				break;
			}
			case 6: {
			System.out.println();
			PreparedStatement ps =con.prepareStatement("SELECT COUNT(*) FROM student");
				ResultSet rs = ps.executeQuery();
				rs.next();
				int count = rs.getInt(1);
				System.out.println("Number of students: " + count);
				break;
			}
			case 7: {
				PreparedStatement ps =con.prepareStatement("select name from student order by name");
				ResultSet rs = ps.executeQuery();
				System.out.println("order by name :");
				while (rs.next()) {
					System.out.println(rs.getString(1));
				}
				break;
			}
			case 8: {
				System.out.println("Exiting...");
				System.exit(0);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}

}
