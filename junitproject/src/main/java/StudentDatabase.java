

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDatabase {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver"); // registering driver
//      Statement stmt;
      String url = "jdbc:mysql://localhost:3308/class";
      Connection con = DriverManager.getConnection(url, "root", "root");// establish connection
      //System.out.println(con);
      System.out.println("Database dbemp connection suceesfully establish");
      int s_no;
      String sname,address;
      Scanner s= new Scanner(System.in);
      Statement stmt= con.createStatement();
      while(true)
      {
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
			System.out.println("Enter the s number :");
			s_no=s.nextInt();
			
			System.out.println("Enter the s name :");
			sname=s.next();
			System.out.println("Enter the s address :");
			address=s.next();
			
			stmt.executeUpdate("INSERT INTO student values( "+s_no+", "+"'"+sname+"', '"+ address+"')");
			System.out.println("record insert.....");
			break;
		}
		case 2: {
			System.out.println("Enter the s number :");
			s_no=s.nextInt();
			ResultSet rs = stmt.executeQuery("select * from student where s_no ="+ s_no);
		       if(rs.next()) {
		    	   System.out.println("s_no:"+rs.getInt(1));
	                System.out.println("s Name:"+rs.getString(2));
	                System.out.println("s address:"+rs.getString(3));
		    	 
		       }
			        else {
			        	System.err.println("No Data found with that id ");
			        }

	
			break;
		}
		case 3: {
			System.out.println("Enter the s number :");
			s_no=s.nextInt();
			
			System.out.println("Enter the s name :");
			sname=s.next();
			System.out.println("Enter the s address :");
			address=s.next();
			
			
			int updatecount=stmt.executeUpdate("update student set name= "+"'"+sname+"', address= '"+ address+"' where s_no="+ s_no);
            if(updatecount>0)
            {
                System.err.println("Data deleted successfully");
            }
            else
            {
                System.err.println("No Data found with that id ");
            }
			break;
		}
		case 4: {
			System.out.println("Enter the s number :");
			s_no=s.nextInt();
//			stmt.executeUpdate("delete from student where s_no ="+ s_no);
			int deletecount=stmt.executeUpdate("delete from student where s_no ="+ s_no);
            if(deletecount>0)
            {
                System.err.println("Data deleted successfully");
            }
            else
            {
                System.err.println("No Data found with that id ");
            }
//			System.out.println("delete student records....");
			break;
		}
		case 5: {
			ResultSet rs = stmt.executeQuery("select * from student ");
		       
	        System.out.println("Get student records:");
	        while (rs.next()) {
	                System.out.println("s_no:"+rs.getInt(1));
	                System.out.println("s Name:"+rs.getString(2));
	                System.out.println("s address:"+rs.getString(3));	                
		}
			break;
		}
		case 6: {
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM student");
            rs.next();
                int count = rs.getInt(1);
                System.out.println("Number of students: " + count);
            
            break;
		}
		case 7: {		
			ResultSet rs = stmt.executeQuery("select name from student order by name");
			System.out.println("order by name :");
		        while (rs.next()) {
		                
		                System.out.println(rs.getString(1));
		        } 
			break;
		}

		case 8: {
			 System.out.println("Exiting...");
			System.exit(0);;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
      }
	}
   }
