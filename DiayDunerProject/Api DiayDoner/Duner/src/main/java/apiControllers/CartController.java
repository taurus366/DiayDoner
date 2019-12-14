package apiControllers;

import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.ws.rs.CookieParam;

import javax.ws.rs.FormParam;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import booleanCheck.ValidSessionCheck;
import databases.ArticleDB;
import databases.CartDB;
import databases.DBconnectionLink;
import databases.SessionDB;
import generators.SessionGenerator;

@Path("/")
public class CartController {
	DBconnectionLink connectLink = new DBconnectionLink();
	PreparedStatement myStmt = null;
	Connection conn = null;
	ResultSet rs = null;
	ValidSessionCheck isboolean = new ValidSessionCheck();
	SessionGenerator sessionGenerator = new SessionGenerator();
	CartDB cartDB = new CartDB();
	SessionDB sessionDB = new SessionDB();

	ArticleDB articleDB = new ArticleDB();

	
	
	
	
	@SuppressWarnings("unused")
	@Path("/cart")
	@POST
	public Response postToCart(@CookieParam(value = "myStrCookie") String sessionId, @FormParam("select") int selectID,
			@FormParam("ketchup") String ketchup, @FormParam("mayonnaise") String mayonnaise,
			@FormParam("chili") String chili, @FormParam("spotted_salt") String spotted_salt)
			throws ClassNotFoundException, SQLException, URISyntaxException {
//		java.net.URI url = new java.net.URI("https://diaydoner.000webhostapp.com/index.html");
		String generatedSession = sessionGenerator.sessionGenerator();
//		NewCookie newSession = new NewCookie("myStrCookie", generatedSession.toString(), "/", "","comment",43200, false);
//		return Response.temporaryRedirect(url).cookie(newSession).build();
		
		if (ketchup == null) {
			ketchup = "не";
		} else {
			ketchup = "да";
		}
		if (mayonnaise == null) {
			mayonnaise = "не";
		} else {
			mayonnaise = "да";
		}
		if (chili == null) {
			chili = "не";
		} else {
			chili = "да";
		}
		if (spotted_salt == null) {
			spotted_salt = "не";
		} else {
			spotted_salt = "да";
		}

		

		if (sessionId == null) {
			
			try {
				sessionDB.addToSession(generatedSession);
				cartDB.addToCart(generatedSession, selectID, ketchup, mayonnaise, chili, spotted_salt);

			} catch (Exception e) {
				// TODO: handle exception
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
			}
			java.net.URI url = new java.net.URI("https://diaydoner.000webhostapp.com/index.html");
			NewCookie newSession = new NewCookie("myStrCookie", generatedSession.toString(), "/", "","comment",604800, false);
			return Response.temporaryRedirect(url).cookie(newSession).build();

		} else if (sessionId != null) {

			if (isboolean.isvalidGuestsSessionID(sessionId)) {

				try {
					cartDB.addToCart(sessionId, selectID, ketchup, mayonnaise, chili, spotted_salt);
					

				} catch (Exception e) {
					// TODO: handle exception
					return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
				}
				java.net.URI url = new java.net.URI("https://diaydoner.000webhostapp.com/index.html");
				return Response.temporaryRedirect(url).build();

			} else {

				try {
					sessionDB.addToSession(generatedSession);
					cartDB.addToCart(generatedSession, selectID, ketchup, mayonnaise, chili, spotted_salt);
					
				} catch (Exception e) {
					// TODO: handle exception
					return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
				}
				
			    
				java.net.URI url = new java.net.URI("https://diaydoner.000webhostapp.com/index.html");
				NewCookie newSession = new NewCookie("myStrCookie", generatedSession.toString(), "/", "","comment",604800, false);
	
				
				return Response.temporaryRedirect(url).cookie(newSession).build();
			}

		}

		return Response.status(Response.Status.BAD_REQUEST).build();
	}

//	@SuppressWarnings("unused")
//	@Path("/cart")
//	@GET
//	public Response readFromCart(@CookieParam(value = "myStrCookie") String sessionId) throws URISyntaxException, ClassNotFoundException, SQLException {
		// SESSION ID!
		//System.out.println(sessionId);
		
		//return cartDB.readFromCart(sessionId);
		//return null;
//		if (sessionId == null) {
//			java.net.URI url = new java.net.URI("https://diaydoner.000webhostapp.com/index.html");
//			return Response.temporaryRedirect(url).build();
//		} else if (sessionId != null) {
//
//			if(isboolean.isvalidGuestsSessionID(sessionId)) {
//				try {
//					
//					return cartDB.readFromCart(sessionId);
//					
//				} catch (Exception e) {
//					// TODO: handle exception
//					return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
//				}
//			}else {
//				java.net.URI url = new java.net.URI("https://diaydoner.000webhostapp.com/index.html");
//				return Response.temporaryRedirect(url).build();
//			}
//		
//
//		}
//		try {
//			return cartDB.readFromCart(sessionId);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
//	}

	@SuppressWarnings("unused")
	@Path("/delete/cart")
	@POST
	public Response deleteFromCart(@FormParam("button") int itemID,@CookieParam(value = "myStrCookie") String sessionId) throws ClassNotFoundException, SQLException, URISyntaxException {

		if (sessionId == null) {
			java.net.URI url = new java.net.URI("https://diaydoner.000webhostapp.com/1111.html");
			return Response.temporaryRedirect(url).build();
		} else if (sessionId != null) {

			if (isboolean.isvalidGuestsSessionID(sessionId)) {

				return cartDB.deleteFromCart(itemID, sessionId);

				// TODO: handle exception

			}else {
				java.net.URI url = new java.net.URI("https://diaydoner.000webhostapp.com/11112.html");
				return Response.temporaryRedirect(url).build();
			}

		}

		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();

	}

}
