import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC_BatchInsertion {

  public static void main(String[] args) throws Exception {
    Connection con = DBConn.getConn();
    Statement stmt = con.createStatement();
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter how many employees you want to insert: ");
    int n = sc.nextInt();
    sc.nextLine();
    
    for(int i = 1; i <= n; i++) {
      System.out.println("\nEnter details for Employee" + i + ":");
      
      System.out.print("Enter empid: ");
      String empid = sc.nextLine();
      
      System.out.print("Enter empname: ");
      String empname = sc.nextLine();
      
      System.out.print("Enter department: ");
      String dept = sc.nextLine();
      
      System.out.print("Enter salary: ");
      double sal = sc.nextDouble();
      sc.nextLine();   //consume new Line
      
      //Add SQL query to batch
      String query = "INSERT INTO emp(empid, empname, dept, sal) VALUES ('" + empid + "', '" + empname + "', '" + dept + "', " + sal + ")";
      stmt.addBatch(query);
    }

    //Execute all queries as a Batch
    int[] result = stmt.executeBatch();
    
    //output message
    System.out.println("\n" + result.length + "records inserted successfully.");
    
    //close resources
    stmt.close();
    con.close();
    sc.close();
  }

}