package databases;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class ArticleDB {
	DBconnectionLink connectLink = new DBconnectionLink();
	PreparedStatement myStmt = null;
	Connection conn = null;
	ResultSet rs = null;

	@SuppressWarnings("unchecked")
	public Response getAllArticlesNameFromDB() throws ClassNotFoundException, SQLException {

		// String sql = "SELECT name FROM articles";
		String sql = "SELECT * FROM articles";
		JSONArray articlesName = new JSONArray();

		try {

			conn = connectLink.getConnectionLink();

			Statement stm = (Statement) conn.createStatement();

			rs = stm.executeQuery(sql);
			while (rs.next()) {

				JSONObject articleInfo = new JSONObject();
				articleInfo.put("Id", rs.getInt(1));
				articleInfo.put("title", rs.getString(2));
				articleInfo.put("price", rs.getBigDecimal(3));

				articlesName.add(articleInfo);

			}
			

		} catch (Exception ex) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();

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

		return Response.status(Status.OK).entity(articlesName.toString()).build();

	}

}
