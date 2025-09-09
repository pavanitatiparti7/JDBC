import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

class Employee{
	String empid;
	String empname;
	String dept;
	double sal;
	
	public Employee(String empid, String empname, String dept, double sal) {
		this.empid = empid;
		this.empname = empname;
		this.dept = dept;
		this.sal = sal;
	}
}

public class JDBC_insertion_Arraylist {
	public static void main(String[] args) throws Exception{
		Connection con = DBConn.getConn();
		String sql = "INSERT INTO emp(empid, empname, dept, sal) VALUES (?, ?, ?, ?)";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		//Employee list
		ArrayList<Employee> employees = new ArrayList<>();
		employees.add(new Employee("16", "q", "HR", 50000));
		employees.add(new Employee("17", "r", "IT", 60000));
		employees.add(new Employee("18", "s", "Finance", 70000));
		
		for(Employee emp : employees) {
			//Check if ID already exists
			PreparedStatement checkStmt = con.prepareStatement("SELECT COUNT(*) FROM emp WHERE empid = ?");
			checkStmt.setString(1,  emp.empid);
			ResultSet rs = checkStmt.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			rs.close();
			checkStmt.close();
			
			if(count == 0) { //only add if not exists
				pstmt.setString(1, emp.empid);
				pstmt.setString(2, emp.empname);
				pstmt.setString(3, emp.dept);
				pstmt.setDouble(4, emp.sal);
				pstmt.addBatch();				
			}else {
                System.out.println(" Employee " + emp.empname + " already exists. Skipping insert.");
            }			
		}
		
		//Execute batch
		 int[] results = pstmt.executeBatch();
	        for (int i = 0; i < results.length; i++) {
	            if (results[i] >= 0)
	                System.out.println(" Employee " + employees.get(i).empname + " inserted successfully.");
	        }

	        pstmt.close();
	        con.close();
	}
}
