import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC_insertion {
	public static void main(String args[]) throws Exception{
		Connection con=DBConn.getConn();
		Statement stmt=con.createStatement();
		Scanner sc=new Scanner(System.in);
		//Taking user input
		System.out.println("Enter empid: ");
		String empid=sc.nextLine();
		
		System.out.println("Enter empname: ");
		String empname=sc.nextLine();
		
		System.out.println("Enter deptarment: ");
		String dept=sc.nextLine();
		
		System.out.println("Enter salary: ");
		double sal=sc.nextDouble();
		
		int i=stmt.executeUpdate("INSERT INTO emp(empid, empname, dept, sal) VALUES ('" +empid+ "','" +empname+ "','" +dept+ "'," +sal+ ")");
		//o/p message 
		if(i==1)
			System.out.println("Record inserted successfully.");
		else
			System.out.println("Insertion failed.");
		
		//closing resources 
		stmt.close();
		con.close();
		sc.close();
		
	}
}
