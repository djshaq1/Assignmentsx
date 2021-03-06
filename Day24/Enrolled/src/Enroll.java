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
	//insert2();
	//fetchData();
	registration();
	
}
public static void display() throws SQLException{
	Statement stmt2 = myConn.createStatement();
	
			
	//while(myRs.next()){
		String fName= myRs.getString("first_name");
		String lName= myRs.getString("last_name");
	String majorDescript= myRs.getString("description");
		int reqSat= myRs.getInt("req_sat");
		double GPA=myRs.getDouble("gpa");
		int SAT= myRs.getInt("sat");
		
		int studentId = myRs.getInt("id");
		
		ResultSet myRs2 = stmt2.executeQuery("select * from student_class_relationship where student_id = " + studentId + ";");
		
		
		System.out.println("Education System - Enrollment Process");
		System.out.println("======================================");
		System.out.println();
		System.out.println("Enrolled " + fName + " as a new student.");
		System.out.println(fName + " "+ lName + " has an SAT score of " + SAT);
		System.out.println("Assigned "+ fName + " "+ lName + " to the " + majorDescript+ " major which requires a SAT score of " +reqSat );
		System.out.println("Enrolled "+ fName + " "+ lName+ " in the following four classes:");
		
		while(myRs2.next()) {
			int Subject = myRs2.getInt("id");
			int section = myRs2.getInt("class_id");
			if(myRs2.getInt("class_id") == 10101 || myRs2.getInt("class_id")== 10102){
		System.out.println(section+ " required for major");
			}else{
				System.out.println(section);
			}
				
		
		//System.out.println(section);
		}
		System.out.println();
//}
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
      if(myRs.getInt("req_sat") > myRs.getInt("sat")){
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
		
myStmt= myConn.prepareStatement("select * from student, major where (student.id between 990 and 994) and (student.major_id = major.id);");

		
		
		//myStmt.setInt(1,899);
			//Execute the Query
			
			myRs= myStmt.executeQuery();
			
			//Process my ResultSet
			while(myRs.next()){
				 if(myRs.getInt("req_sat") > myRs.getInt("sat")){
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
	myStmt.executeUpdate();
	myStmt.setInt(1, 991);
	myStmt.setString(2, "Graham");
	myStmt.setString(3, "Krakir");
	myStmt.setInt(4, 500);
	myStmt.setDouble(5, 2.5);
	myStmt.setInt(6, 7);
	myStmt.executeUpdate();
	myStmt.setInt(1, 992);
	myStmt.setString(2, "Ella");
	myStmt.setString(3, "Vader");
	myStmt.setInt(4, 800);
	myStmt.setDouble(5, 3.0);
	myStmt.setInt(6, 2);
	myStmt.executeUpdate();
	myStmt.setInt(1, 993);
	myStmt.setString(2, "Stanley");
	myStmt.setString(3, "Kupp");
	myStmt.setInt(4, 1350 );
	myStmt.setDouble(5, 3.5);
	myStmt.setInt(6, 5);
	myStmt.executeUpdate();
	myStmt.setInt(1, 994);
	myStmt.setString(2, "Lou");
	myStmt.setString(3, "Zar");
	myStmt.executeUpdate();
	myStmt.setInt(4, 950 );
	myStmt.setDouble(5, 3.0);
	myStmt.setInt(6, 6);
	
	
	myStmt.executeUpdate();
	}catch(Exception ex){
	}finally{
		
	}
}

private static void insert2() throws SQLException{
	myStmt= myConn.prepareStatement("INSERT student_class_relationship (student_id, class_id) values (?,?)");
	myStmt.setInt(1, 990);
	myStmt.setInt(2, 10101);
	myStmt.executeUpdate();
	myStmt.setInt(1, 990);
	myStmt.setInt(2, 10102);
	myStmt.executeUpdate();
	myStmt.setInt(1, 991);
	myStmt.setInt(2, 10101);
	myStmt.executeUpdate();
	myStmt.setInt(1, 991);
	myStmt.setInt(2, 10102);
	myStmt.executeUpdate();
	myStmt.setInt(1, 992);
	myStmt.setInt(2, 10101);
	myStmt.executeUpdate();
	myStmt.setInt(1, 992);
	myStmt.setInt(2, 10102);
	myStmt.executeUpdate();
	myStmt.setInt(1, 993);
	myStmt.setInt(2, 10101);
	myStmt.executeUpdate();
	myStmt.setInt(1, 993);
	myStmt.setInt(2, 10102);
	myStmt.executeUpdate();
	myStmt.setInt(1, 994);
	myStmt.setInt(2, 10101);
	myStmt.executeUpdate();
	myStmt.setInt(1, 994);
	myStmt.setInt(2, 10102);
	myStmt.executeUpdate();
	
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
