package databases;

import java.sql.ResultSet;
import java.sql.SQLException;



import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class AdminDB {

	DBconnectionLink connectLink = new DBconnectionLink();
	PreparedStatement myStmt = null;
	Connection conn = null;
	ResultSet rs = null;
	
	
	public  void putAdminSession(String sessionID) throws ClassNotFoundException, SQLException {
		try {
			conn = connectLink.getConnectionLink();
			myStmt = (PreparedStatement) conn.prepareStatement("INSERT INTO `" + connectLink.schema
					+ "`.`sessions` (`int`, `session`, `created_date`, `last_activity_date`) VALUES (default,?,now(),now())");
			myStmt.setString(1, sessionID);
			
			myStmt.executeUpdate();
			
		} finally {
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

		
		
	}
	
	public void addArticle(String title,String price) throws ClassNotFoundException, SQLException {
		try {
			conn = connectLink.getConnectionLink();
			myStmt = (PreparedStatement) conn.prepareStatement("INSERT INTO `" + connectLink.schema
					+ "`.`articles` (`id`, `title`, `price`) VALUES (default,?,?)");
			myStmt.setString(1, title);
			myStmt.setString(2, price);
			
			myStmt.executeUpdate();
			
		} finally {
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
		
	}
	
	public void deleteArticle (String id) throws ClassNotFoundException, SQLException {
		try {
			conn = connectLink.getConnectionLink();
			myStmt = (PreparedStatement) conn.prepareStatement("DELETE FROM `" + connectLink.schema
					+ "`.`articles` where `id`=?");
			myStmt.setString(1, id);
			myStmt.executeUpdate();
			
		} finally {
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
		
		
		
	}
	
	public void deleteOrder (String id) throws ClassNotFoundException, SQLException {
		try {
			conn = connectLink.getConnectionLink();
			myStmt = (PreparedStatement) conn.prepareStatement("DELETE FROM `" + connectLink.schema
					+ "`.`orders_address` where `id`=? ");
			myStmt.setString(1, id);
			myStmt.executeUpdate();
			
			myStmt = (PreparedStatement) conn.prepareStatement("DELETE FROM `" + connectLink.schema
					+ "`.`orders_article` where `order_id`=? ");
			myStmt.setString(1, id);
			myStmt.executeUpdate();
		} finally {
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
	}
	
}
