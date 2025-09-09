import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_select {
    public static void main(String[] args) throws Exception {
        // Get connection from DBConn class
        Connection con = DBConn.getConn();
        Statement stmt = con.createStatement();

        // Execute SELECT query
        ResultSet rs = stmt.executeQuery("SELECT * FROM emp1");

        // Display column headers
        System.out.println("ID\tName\t\tDepartment\tSalary");
        System.out.println("----------------------------------------------");

        // Loop through the ResultSet and print each record
        while (rs.next()) {
            String id = rs.getString("id");  // 'id' is empid
            String name = rs.getString("name");
            String dept = rs.getString("department");
            double salary = rs.getDouble("salary");

            System.out.println(id + "\t" + name + "\t\t" + dept + "\t\t" + salary);
        }

        // Close resources
        rs.close();
        stmt.close();
        con.close();
    }
}