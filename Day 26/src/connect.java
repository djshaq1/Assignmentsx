import java.sql.*;
public class connect {
	String dburl = null;
	String user = null;
	String password = null;
	public Connection conn = null;
	
	public int executeSqlUpdate(String sql) throws SQLException {
		Statement stmt = conn.createStatement();
		try {
			int recsAffected = stmt.executeUpdate(sql);
			return recsAffected;
		} catch(SQLException ex) { throw ex; }
	}
	public ResultSet executeSqlQuery(String sql) throws SQLException {
		Statement stmt = conn.createStatement();
		try {
			ResultSet rs = stmt.executeQuery(sql);
			return rs;
		} catch(SQLException ex) { throw ex; }
	}
	public connect(String dburl, String user, String password) throws SQLException {
		conn = DriverManager.getConnection(dburl, user, password);
	}
	public void close() throws SQLException {
		if(conn != null) { conn.close(); conn = null; }
	}
}



