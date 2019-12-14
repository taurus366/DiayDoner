package booleanCheck;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import databases.DBconnectionLink;
import models.ForSession;

public class ValidSessionCheck {
	DBconnectionLink connectLink = new DBconnectionLink();
	PreparedStatement myStmt = null;
	Connection conn = null;
	ResultSet rs = null;

	/**
	 * Check if the Guest's session ID is valid
	 * 
	 * @param session Guest's session ID
	 * @return send back if true or false
	 * @throws ClassNotFoundException if class did not found
	 * @throws SQLException           if query to SQL is not successful
	 */
	public Boolean isvalidGuestsSessionID(String session) throws ClassNotFoundException, SQLException {
		try {
			
			conn = connectLink.getConnectionLink();

			myStmt = (PreparedStatement) conn.prepareStatement("Select * from `sessions` where `session`=?");
			myStmt.setString(1, session);
			rs = myStmt.executeQuery();

			ArrayList<ForSession> sessioninfo = new ArrayList<>();
			
			while (rs.next()) {

				ForSession sessionID = new ForSession();
				sessionID.session_id = rs.getString(2);
				sessioninfo.add(sessionID);

			}
			if (sessioninfo.size() > 0) {
				return true;
			}

			
			
		} finally {
			// TODO: handle finally clause

			// TODO: handle finally clause
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
				} // ignore

				rs = null;
			}

			if (myStmt != null) {
				try {
					myStmt.close();
				} catch (SQLException sqlEx) {
				} // ignore

				myStmt = null;
			}
			
			if (conn != null) {
				try {
					conn.close();
					
				} catch (Exception e) {
					// TODO: handle exception
					// ignore
				}
				conn = null;
			}
		}
		
	
		
		return false;
	}

}
