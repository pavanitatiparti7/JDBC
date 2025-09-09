import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC_updation {
	public static void main(String args[]) throws Exception {
        Connection con = DBConn.getConn(); //Accessing connection from DBConn
        Statement stmt = con.createStatement(); //statement to transfer data from DBMS to java 
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.println("Enter empid to update: ");
        String empid = sc.nextLine();

        //System.out.println("Enter new empname: ");
        //String empname = sc.nextLine();

        //System.out.println("Enter new department: ");
        //String dept = sc.nextLine();

        System.out.println("Enter new salary: ");
        double newSalary = sc.nextDouble();

        // Build and execute update query
        int rowsAffected = stmt.executeUpdate(
            "UPDATE emp SET sal=" +newSalary + " WHERE empid = '"+ empid + "'");
        
        //show result
       
        if (rowsAffected > 0)
            System.out.println("Record updated successfully.");
        else
            System.out.println("Updation failed. Record not found.");

        // Closing resources
        stmt.close();
        con.close();
        sc.close();
    }
}
