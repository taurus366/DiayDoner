package databases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import models.Order_address;
import models.Cart;

public class OrderDB {
	DBconnectionLink connectLink = new DBconnectionLink();
	PreparedStatement myStmt = null;
	Connection conn = null;
	ResultSet rs = null;

	@SuppressWarnings("unused")
	public void postOrder(String firstName, String secondName, String thirdName, String address, String telephone,
			String city, String sessionId) throws ClassNotFoundException, SQLException {
		
		
		try {
			conn = connectLink.getConnectionLink();
			myStmt = (PreparedStatement) conn.prepareStatement("INSERT INTO `" + connectLink.schema
					+ "`.`orders_address` (`id`, `session_id`, `firstname`, `secondname`, `thirdname`, `address`, `phone`, `city`, `ordered_time`) VALUES (default,?,?,?,?,?,?,?,now())");
			myStmt.setString(1, sessionId.toString());
			myStmt.setString(2, firstName);
			myStmt.setString(3, secondName);
			myStmt.setString(4, thirdName);
			myStmt.setString(5, address);
			myStmt.setString(6, telephone);
			myStmt.setString(7, city);

			myStmt.executeUpdate();

			ArrayList<Order_address> userInfo = new ArrayList<>();

			//conn = connectLink.getConnectionLink();
			myStmt = (PreparedStatement) conn
					.prepareStatement("select id,session_id from orders_address where session_id=? LIMIT 1");
			myStmt.setString(1, sessionId);
			rs = myStmt.executeQuery();

			while (rs.next()) {

				Order_address userinfo = new Order_address();

				userinfo.order_id = rs.getInt(1);
				userinfo.session_id = rs.getString(2);
				userInfo.add(userinfo);

			}
			@SuppressWarnings("unused")
			int order_id = 0; // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GOT ORDER ID FROM ORDER_ADDRESS
			String order_sessionId = null; // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GOT ORDER SESSION ID FROM
											// ORDER_ADDRESS

			for (int i = 0; i < userInfo.size(); i++) {
				Order_address user = userInfo.get(i);
				order_id = user.order_id;
				order_sessionId = user.session_id;
			}
			
			
			
			
	//>>>>>>>
			
			
			//conn = connectLink.getConnectionLink();
			myStmt = (PreparedStatement) conn.prepareStatement(
					"select session_id,article_id,ketchup,mayonnaise,chili,spotted_salt from cart where session_id=?");
			myStmt.setString(1, sessionId);
			rs = myStmt.executeQuery();

			ArrayList<Cart> cartInfo = new ArrayList<>();

			while (rs.next()) {

				Cart info = new Cart();

				info.session_id = rs.getInt(1);
				info.article_id = rs.getInt(2);
				info.ketchup = rs.getString(3);
				info.mayonnaise = rs.getString(4);
				info.chili = rs.getString(5);
				info.spotted_salt = rs.getString(6);
				cartInfo.add(info);

			}
			int session = 0;
			for (int i = 0; i < cartInfo.size(); i++) {
				Cart get = cartInfo.get(i);
				
				//conn = connectLink.getConnectionLink();
				myStmt = (PreparedStatement) conn.prepareStatement("INSERT INTO `" + connectLink.schema
						+ "`.`orders_article` (`id`, `order_id`, `article_id`, `ketchup`, `mayonnaise`, `chili`, `spotted_salt`) VALUES (default,?,?,?,?,?,?)");
				myStmt.setInt(1, order_id);
				myStmt.setInt(2, get.article_id);
				myStmt.setString(3, get.ketchup);
				myStmt.setString(4, get.mayonnaise);
				myStmt.setString(5, get.chili);
				myStmt.setString(6, get.spotted_salt);
				myStmt.executeUpdate();

				session = get.session_id;

			}
			myStmt = (PreparedStatement) conn.prepareStatement(
					"DELETE FROM `" + connectLink.schema + "`.`cart` WHERE session_id=" + session );
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
					if(conn != null) {
						try {
							conn.close();
						} catch (Exception e) {
							// TODO: handle exception
							//ignore
						}
						conn = null;
					}

				}
			
		
	
		}

	}

