package booleanCheck;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import databases.DBconnectionLink;
import models.Admin;


public class AdminCheck {
	DBconnectionLink connectLink = new DBconnectionLink();
	PreparedStatement myStmt = null;
	Connection conn = null;
	ResultSet rs = null;
	
	public boolean checkAdminPassword(String name,String password) throws ClassNotFoundException, SQLException {
		
		ArrayList<Admin> userInfo = new ArrayList<>();
		
		try {
			conn = connectLink.getConnectionLink();
			myStmt = (PreparedStatement) conn.prepareStatement("select * from admins where name =? and password=?");
			myStmt.setString(1, name);
			myStmt.setString(2, password);

			rs = myStmt.executeQuery();
			
			while (rs.next()) {

				Admin userinfo = new Admin();

				userinfo.id = rs.getInt(1);
				userinfo.name = rs.getString(2);
				userinfo.password = rs.getString(3);
				userInfo.add(userinfo);

			}
			
			
			
		}  
		finally {
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
		
		if(userInfo.size()> 0) {
			return true;
		}
		
		return false;
		
	}
	
	public boolean isAdminSessionId(String sessionID) throws ClassNotFoundException, SQLException {
ArrayList<Admin> adminInfo = new ArrayList<>();
		
		try {
			conn = connectLink.getConnectionLink();
			myStmt = (PreparedStatement) conn.prepareStatement("select * from sessions where session=?");
			myStmt.setString(1, sessionID);
			

			rs = myStmt.executeQuery();
			
			while (rs.next()) {

				Admin userinfo = new Admin();

				userinfo.id = rs.getInt(1);
				adminInfo.add(userinfo);

			}
		
			
			
		}  
		finally {
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
		if(adminInfo.size()> 0) {
			return true;
		}
		
		return false;
	}
}
