package db;

//Java IO Classes
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
// Java SQL Classes
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public class DBManager {
	public static Connection conn = null;
	
	public static Properties loadProperties() {
		Properties props = new Properties();
		
		try(FileInputStream fileReader = new FileInputStream("db.properties")) {
			props.load(fileReader);
		} catch (FileNotFoundException e) {
			throw new DBException("Unexpected Error: " + e.getMessage());
		} catch (IOException e) {
			throw new DBException("Unexpected Error:" + e.getMessage());
		}
		return props;
	}
	
	public static Connection getConnection() {
		
		if(conn == null) {
			Properties connProps = loadProperties();
			try {
				conn = DriverManager.getConnection(connProps.getProperty("db-url"), connProps);
			} catch (SQLException e) {
				throw new DBException("Unexpected Error: " + e.getMessage());
			}
		}
		return conn;
	}
	
	public static void closeConnection(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DBException("Unexpected Error:" + e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DBException("Unexpected Error:" + e.getMessage());
			}
		}
	}
	
	public static void closeStatement(Statement st) {
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DBException("Unexpected Error:" + e.getMessage());
			}
		}
	}
}
