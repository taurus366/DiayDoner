package databases;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class SessionDB {
	DBconnectionLink connectLink = new DBconnectionLink();
	PreparedStatement myStmt = null;
	Connection conn = null;
	ResultSet rs = null;
	
	
	public void addToSession(String sessionID) throws ClassNotFoundException, SQLException {
		
		try {
			conn = connectLink.getConnectionLink();
			myStmt = (PreparedStatement) conn.prepareStatement("INSERT INTO `"+ connectLink.schema +"`.`sessions` (`int`, `session`, `created_date`, `last_activity_date`) VALUES (default,?,now(),now())");
			myStmt.setString(1,sessionID.toString());
			

			myStmt.executeUpdate();
		} finally {
			// TODO: handle finally clause
			if(conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					// TODO: handle exception
					//ignore!
				}
				conn = null;
			}
			if(myStmt != null) {
				try {
					myStmt.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
				myStmt = null;
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
				rs = null;
			}
		}
		
		
	}
}
