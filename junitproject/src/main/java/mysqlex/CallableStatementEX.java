package mysqlex;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CallableStatementEX {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver"); // registering driver
//      Statement stmt;
		String url = "jdbc:mysql://localhost:3308/employee";
		Connection con = DriverManager.getConnection(url, "root", "root");// establish connection
		// System.out.println(con);
		System.out.println("Database dbemp connection suceesfully establish");
		Scanner s =new Scanner(System.in);
		String city = s.next();
		CallableStatement statement = con.prepareCall("{call  empcity_procedure(?)}");
		statement.setString(1, city);		
		statement.execute();
		ResultSet rs = statement.executeQuery();
		System.out.println("id" + "     " + "name" + "     " + "address");
		while (rs.next()) {
			System.out.println("s_no:" + rs.getInt(1)+"  "+"s_Name:" + rs.getString(2)+"  "+"s_address:" + rs.getString(3));			
		}
	}

}
