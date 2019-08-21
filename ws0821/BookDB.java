package afternoon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BookDB {
	
	public static String driver="com.mysql.cj.jdbc.Driver";
	public static String url="jdbc:mysql://localhost:3306/ahyeon?useUniCode=yes&characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
	public static String user="ssafy2";
	public static String password="ssafy";
	
	private boolean isDebug = true; 
	
	
	public boolean isDebug() {
		return isDebug;
	}
	public void setDebug(boolean isDebug) {
		this.isDebug = isDebug;
	}
	public void log(String msg)
	{
		if( isDebug )
		{
			System.out.println(msg);
		}
	}
	
	public void log(String msg, Exception e)
	{
		if( isDebug )
		{
			System.out.println(msg+ ":" + e);
		}
	}
	
	public BookDB() {
		try {
			Class.forName(driver);
			log("1/6 S"+ getClass());
		} catch (ClassNotFoundException e) {
			log("1/6 F"+ getClass(),e);
		}
	}
	public Connection getConnection() throws SQLException {
		Connection conn=null;
		conn=DriverManager.getConnection(url,user,password);
		return conn;
	}
	public void close(Connection conn, PreparedStatement psmt, ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				
			}
		}
		if(psmt!=null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				
			}
		}
	}
	
	
	
}











