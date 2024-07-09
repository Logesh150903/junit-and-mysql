package mysqlex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Checkconnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver"); // registering driver
//        Statement stmt;
        String url = "jdbc:mysql://localhost:3308/employee";
        Connection con = DriverManager.getConnection(url, "root", "root");// establish connection
        //System.out.println(con);
        System.out.println("Database dbemp connection suceesfully establish");

        Statement stmt = con.createStatement();
//        stmt.executeUpdate("insert into employee values(7,'logeshkumar','developer',20,'chennai',60000,'2018-11-23',2415.65)");
//        System.out.println( "records insert....");
//        stmt.executeUpdate("update employee set ejdate=\"2018-10-13\" where eid = 7;");
//        System.out.println( "records update....");
        stmt.executeUpdate("delete from employee where eid=7");
        System.out.println( "records delete....");
//        ResultSet rs = stmt.executeQuery("select * from employee");
//       
//        System.out.println("Get employee records:");
//        while (rs.next()) {
//                System.out.println("EmpId:"+rs.getInt(1));
//                System.out.println("EmpName:"+rs.getString(2));
//                System.out.println("EmpDesignation:"+rs.getString(3));
//                System.out.println("EmpAge:"+rs.getInt(4));
//                System.out.println("EmpCity:"+rs.getString(5));
//                System.out.println("Empsalary:"+rs.getInt(6));
//                System.out.println("EmpJoinDate:"+rs.getDate(7));
//                System.out.println("EmpTax:"+rs.getFloat(8));
//
//	}
        ResultSet rs1 = stmt.executeQuery("select count(*) from employee");
		int count = rs1.getInt(1);
          System.out.println("Number of records in table: "+count);

	}

}
