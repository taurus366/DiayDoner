package apiControllers;

import java.net.URISyntaxException;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import booleanCheck.ValidSessionCheck;
import databases.ArticleDB;
import databases.CartDB;
import databases.DBconnectionLink;
import databases.OrderDB;
import databases.SessionDB;
import databases.SessionDelete;
import generators.SessionGenerator;

@Path("/")
public class OrderController {
	DBconnectionLink connectLink = new DBconnectionLink();
	PreparedStatement myStmt = null;
	Connection conn = null;
	ResultSet rs = null;
	ValidSessionCheck isboolean = new ValidSessionCheck();
	SessionGenerator sessionGenerator = new SessionGenerator();
	CartDB cartDB = new CartDB();
	SessionDB sessionDB = new SessionDB();
	OrderDB orderDb = new OrderDB();
	ArticleDB articleDB = new ArticleDB();
	SessionDelete sessionDelete = new SessionDelete();

	@SuppressWarnings("unused")
	@Path("/order")
	@POST
	public Response postOrder(@CookieParam(value = "myStrCookie") String sessionId,
			@FormParam("firstname") String firstName, @FormParam("secondname") String secondName,
			@FormParam("thirdname") String thirdName, @FormParam("address") String address,
			@FormParam("telephone") String telephone, @FormParam("city") String city)
			throws ClassNotFoundException, SQLException, URISyntaxException {

		if (sessionId == null) {
			java.net.URI url = new java.net.URI("/index.html");
			return Response.temporaryRedirect(url).build();
		} else if (sessionId != null) {

			if (isboolean.isvalidGuestsSessionID(sessionId)) {
				try {
					orderDb.postOrder(firstName, secondName, thirdName, address, telephone, city, sessionId);
					sessionDelete.deleteSesssionFromDB(sessionId);
				} catch (Exception e) {
					// TODO: handle exception
					return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
				} 

			} else {
				java.net.URI url = new java.net.URI("https://diaydoner.000webhostapp.com/index.html");
				return Response.temporaryRedirect(url).build();
			}

		}

		return Response.status(Response.Status.OK).build();
	}
}
