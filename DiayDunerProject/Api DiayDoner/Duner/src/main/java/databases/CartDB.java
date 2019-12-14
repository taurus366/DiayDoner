package databases;

import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.core.Response;



import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import databases.DBconnectionLink;

public class CartDB {
	DBconnectionLink connectLink = new DBconnectionLink();
	PreparedStatement myStmt = null;
	Connection conn = null;
	ResultSet rs = null;

	public void addToCart(String session, int clientSelectedForEat, String ketchup, String mayonnaise, String chili,
			String spotted_salt) throws ClassNotFoundException, SQLException {
try {
	conn = connectLink.getConnectionLink();
	myStmt = (PreparedStatement) conn.prepareStatement("INSERT INTO `" + connectLink.schema
			+ "`.`cart` (`id`, `session_id`, `article_id`, `added_time`, `ketchup`, `mayonnaise`, `chili`, `spotted_salt`) VALUES (default,?,?,now(),?,?,?,?)");
	myStmt.setString(1, session.toString());
	myStmt.setInt(2, clientSelectedForEat);
	myStmt.setString(3, ketchup);
	myStmt.setString(4, mayonnaise);
	myStmt.setString(5, chili);
	myStmt.setString(6, spotted_salt);

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

//	@SuppressWarnings("unchecked")
//	public Response readFromCart(String session) throws ClassNotFoundException, SQLException {
//
//		JSONArray cartInfo = new JSONArray();
//
//		conn = connectLink.getConnectionLink();

//		myStmt = (PreparedStatement) conn.prepareStatement(
//				"select ar.`title` as 'име', ca.`ketchup`, ca.`mayonnaise`, ca.`chili`, ca.`spotted_salt` from `cart` as ca left join `articles` as ar on ar.`id` = ca.`article_id`" + "where session_id = ?");
//		myStmt = (PreparedStatement) conn.prepareStatement(
//				"select ar.`id`,ar.`title` as 'име', ca.`ketchup`, ca.`mayonnaise`, ca.`chili`, ca.`spotted_salt`,ar.`price` from `cart` as ca left join `articles` as ar on ar.`id` = ca.`article_id` where session_id=?");
//		myStmt.setString(1, session);
//		rs = myStmt.executeQuery();
//
//		while (rs.next()) {
//
//			JSONObject info = new JSONObject();
//			info.put("article_id", rs.getInt(1));
//			info.put("product_name", rs.getString(2));
//			info.put("ketchup", rs.getString(3));
//			info.put("mayonnaise", rs.getString(4));
//			info.put("chili", rs.getString(5));
//			info.put("spotted_salt", rs.getString(6));
//			info.put("price", rs.getDouble(7));
//
//			cartInfo.add(info);
//
//		}
//		if (rs != null) {
//			try {
//				rs.close();
//			} catch (SQLException sqlEx) {
//			} // ignore
//
//			rs = null;
//		}
//
//		if (myStmt != null) {
//			try {
//				myStmt.close();
//			} catch (SQLException sqlEx) {
//			} // ignore
//
//			myStmt = null;
//		}
//		
//		if (conn != null) {
//			try {
//				conn.close();
//				
//			} catch (Exception e) {
//				// TODO: handle exception
//				// ignore
//			}
//		}
//		
//		

//		if (cartInfo.size() == 0) {
//
//			return Response.status(Response.Status.NOT_FOUND).entity("Your cart is empty!").build();
//
//		}
//		return Response.status(Response.Status.OK).header("Access-Control-Allow-Origin", "*")
//			      .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
//			      .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").entity(cartInfo.toString()).build();
		//return Response.status(Response.Status.OK).entity(cartInfo.toString()).build();

//	}

	public Response deleteFromCart(int itemID, String sessionID)
			throws ClassNotFoundException, SQLException, URISyntaxException {
		try {
			conn = connectLink.getConnectionLink();
			myStmt = (PreparedStatement) conn.prepareStatement("DELETE FROM `" + connectLink.schema
					+ "`.`cart` WHERE (`article_id` =?) and (`session_id`=?) LIMIT 1");
			myStmt.setInt(1, itemID);
			myStmt.setString(2, sessionID.toString());

			myStmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
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
		java.net.URI url = new java.net.URI("http://test-env.atf4k3jipr.us-east-2.elasticbeanstalk.com/cart.jsp");

		return Response.temporaryRedirect(url).build();

	}
}
