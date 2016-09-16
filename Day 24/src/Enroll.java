import java.sql.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class Enroll {
	
public static Connection myConn=null;
public static PreparedStatement myStmt=null, myStmt2=null;
public static ResultSet myRs=null;

public static void main(String[] args) throws SQLException {
	//display();
	//fetchData();
	//insert();
	//fetchData();
	registration();
	
}
public static void display() throws SQLException{
	while(myRs.next()){
		String fName= myRs.getString("first_name");
		String lName= myRs.getString("last_name");
	String majorDescript= myRs.getString("description");
		int reqSat= myRs.getInt("req_sat");
		double GPA=myRs.getDouble("gpa");
		int SAT= myRs.getInt("sat");
		String Subject = myRs.getString("subject");
		int section = myRs.getInt("section");
		System.out.println("Education System - Enrollment Process");
		System.out.println("======================================");
		System.out.println();
		System.out.println("Enrolled " + fName + " as a new student.");
		System.out.println(fName + " "+ lName + " has an SAT score of " + SAT);
		System.out.println("Assigned "+ fName + " "+ lName + " to the " + majorDescript+ " major which requires a SAT score of " +reqSat );
		System.out.println("Enrolled "+ fName + " "+ lName+ " in the following four classes:");
		System.out.println(Subject + " "+ section+ " required for major"); 
		System.out.println();
}
}
private static void fetchData() throws SQLException{
	try{
		makeConnection();	
		
myStmt= myConn.prepareStatement("select student.first_name, student.last_name,student.gpa, student.sat, major.req_sat, major.description from student join major on student.major_id=major.id where student.id > ?");
	
myStmt.setInt(1,899);
	//Execute the Query
	
	myRs= myStmt.executeQuery();
	
	//Process my ResultSet
	while(myRs.next()){
	            if(myRs.getInt("req_sat") < myRs.getInt("sat")){
		               System.out.println("Sorry, you must choose another major " );
	          }else{
	               display();
         }
		}
	
}catch(Exception ex){
	ex.printStackTrace();
}finally{
	
	close();
}
}
private static void registration() throws SQLException{
	try{
		makeConnection();	
myStmt= myConn.prepareStatement("select major.description, major.req_sat, table2.* from major join ("
		+ "select table1.*, class.subject,class.section from ("
		+ "select student.*,student_class_relationship.class_id from student join "
		+ "student_class_relationship on student.id = student_class_relationship.student_id) as table1"
		+ " join class on table1.class_id=class.id where table1.id > ?) as table2 "
		+ "on major.id=table2.major_id");
		
		
		myStmt.setInt(1,1);
			//Execute the Query
			
			myRs= myStmt.executeQuery();
			
			//Process my ResultSet
			
			            
			                display();System.out.println("Friday is over");
			              
				
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			
			close();
		}
		}

private static void makeConnection() throws FileNotFoundException, IOException, SQLException{
	Properties prop= new Properties();
	prop.load(new FileInputStream("jdb.properties"));
	String dburl= prop.getProperty("dburl");
	String user=prop.getProperty("user");
	String pass=prop.getProperty("password");
	myConn=DriverManager.getConnection(dburl, user, pass);
}
private static void insert() throws SQLException{
	try{
		makeConnection();
		
		myStmt= myConn.prepareStatement("insert into student values(?,?,?,?,?,?)");
	myStmt.setInt(1, 990);
	myStmt.setString(2, "Adam");
	myStmt.setString(3, "Zapel");
	myStmt.setInt(4, 1200);
	myStmt.setDouble(5, 3.0);
	myStmt.setInt(6, 3);
	myStmt.setInt(1, 991);
	myStmt.setString(2, "Graham");
	myStmt.setString(3, "Krakir");
	myStmt.setInt(4, 500);
	myStmt.setDouble(5, 2.5);
	myStmt.setInt(6, 7);
	myStmt.setInt(1, 992);
	myStmt.setString(2, "Ella");
	myStmt.setString(3, "Vader");
	myStmt.setInt(4, 800);
	myStmt.setDouble(5, 3.0);
	myStmt.setInt(6, 2);
	myStmt.setInt(1, 993);
	myStmt.setString(2, "Stanley");
	myStmt.setString(3, "Kupp");
	myStmt.setInt(4, 1350 );
	myStmt.setDouble(5, 3.5);
	myStmt.setInt(6, 5);
	myStmt.setInt(1, 994);
	myStmt.setString(2, "Lou");
	myStmt.setString(3, "Zar");
	myStmt.setInt(4, 950 );
	myStmt.setDouble(5, 3.0);
	myStmt.setInt(6, 6);
	
	
	myStmt.executeUpdate();
	}catch(Exception ex){
	}finally{
		
	}
}

public static void update() throws SQLException{
	
}

public static void close() throws SQLException{
	if(myConn!=null)
		myConn.close();
	if(myStmt !=null)
		myStmt.close();
	if(myRs!=null)
		myRs.close();
}
}
