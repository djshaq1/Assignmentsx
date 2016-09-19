import java.sql.*;
import java.util.*;

public class students extends HashMap<Integer, student> {
	private static final long serialVersionUID = 1L;
	connect db = null;

	public void delete(int id) {
		String sql = String.format("DELETE from student where id = %d", id);
		try {
			db.executeSqlUpdate(sql);
		} catch (SQLException ex) { ex.printStackTrace(); }
	}
	public void insert(student student) {
		String sql = String.format("INSERT student (first_name, last_name, gpa, sat) values ('%s', '%s', %f, %d)",
				student.firstName, student.lastName, student.gpa, student.sat);
		try {
			db.executeSqlUpdate(sql);
		} catch (SQLException ex) { ex.printStackTrace(); }
	}
	public void update(student student) {
		String sql = String.format("UPDATE student set first_name = '%s', last_name = '%s', gpa = %f, sat = %d where id = %d",
				student.firstName, student.lastName, student.gpa, student.sat, student.id);
		try {
			db.executeSqlUpdate(sql);
		} catch (SQLException ex) { ex.printStackTrace(); }
	}
	public student get(int id) {
		List<student> students = select("SELECT * from student where id = " + id);
		if(students.isEmpty())
			return null;
		return students.get(0);
	}
	public List<student> getAllStudents() {
		return select("SELECT * from student");
	}
	public List<student> select(String sql) {
		ArrayList<student> students = new ArrayList<student>();
		try {
			ResultSet rs = db.executeSqlQuery(sql);
			while(rs.next()) {
				student student = loadStudent(rs);
				students.add(student);
			}
			return students;
		} catch (Exception ex) { ex.printStackTrace(); }
		return null;
	}
	public student createInstance() {
		student student = new student();
		return student;
	}
	public students() {
		super();
		makeSqlConnection();
	}
	private student loadStudent(ResultSet rs) {
		student student = new student();
		try {
			student.id = rs.getInt("id");
			student.firstName = rs.getString("first_name");
			student.lastName = rs.getString("last_name");
			student.gpa = rs.getDouble("gpa");
			student.sat = rs.getInt("sat");
			return student;
		} catch (SQLException ex) { ex.printStackTrace(); }
		return null;
	}
	private void makeSqlConnection() {
		try {
			Properties prop = new Properties();
			prop.load(new java.io.FileInputStream("Props.property"));
			String dburl = prop.getProperty("dburl");
			String user = prop.getProperty("user");
			String password = prop.getProperty("password");
			db = new connect(dburl, user, password);
		} catch (Exception ex) { ex.printStackTrace(); }
	}


{

}
}
