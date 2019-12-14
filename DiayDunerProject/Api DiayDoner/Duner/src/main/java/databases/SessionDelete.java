package databases;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class SessionDelete {
	DBconnectionLink connectLink = new DBconnectionLink();
	PreparedStatement myStmt = null;
	Connection conn = null;
	ResultSet rs = null;
	
	public void deleteSesssionFromDB(String sessionId) throws ClassNotFoundException, SQLException {
		
		try {
			conn = connectLink.getConnectionLink();
			myStmt = (PreparedStatement) conn.prepareStatement("DELETE FROM `"+connectLink.schema+"`.`sessions` WHERE session=?");
			myStmt.setString(1, sessionId);
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
