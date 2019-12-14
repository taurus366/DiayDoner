package apiControllers;




import java.net.URISyntaxException;

import java.sql.SQLException;


import javax.ws.rs.CookieParam;

import javax.ws.rs.FormParam;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import booleanCheck.AdminCheck;
import databases.AdminDB;
import generators.MD5Generator;
import generators.SessionGenerator;





@Path("/")
public class AdminController {
 
	static AdminCheck isAdmin = new AdminCheck();
	 static SessionGenerator sessionGenerator = new SessionGenerator();
	 static AdminDB adminDB = new AdminDB();
	 static MD5Generator genMD5 = new MD5Generator();

	@Path("admin/login")
	@POST
	public Response adminLogin(@FormParam("name") String name, @FormParam("password") String password) throws URISyntaxException {
		try {
			
		
		if(isAdmin.checkAdminPassword(name, genMD5.GenerateMd5(password))) {
			String generatedSession = sessionGenerator.sessionGenerator();
			
			// http://diaydunerservice-env.65m77q8cqk.eu-central-1.elasticbeanstalk.com/rest/admin/login
			java.net.URI url = new java.net.URI("http://diaydunerservice-env.65m77q8cqk.eu-central-1.elasticbeanstalk.com/admin.jsp");
			NewCookie newSession = new NewCookie("myStrAdmin", generatedSession.toString(), "/", "","comment",86400, false);
			adminDB.putAdminSession(generatedSession);
			return Response.temporaryRedirect(url).cookie(newSession).build();
		}
		} catch (Exception e) {
			// TODO: handle exception
			
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		//diaydoner.000webhostapp.com/login.html
		java.net.URI url = new java.net.URI("diaydoner.000webhostapp.com/login.html");
		return Response.temporaryRedirect(url).build();
		
		
	}
	
	@Path("admin/Adarticle")
	@POST
	public Response addArticle(@CookieParam(value = "myStrAdmin") String sessionId,@FormParam("title") String title,@FormParam("price") String price) throws ClassNotFoundException, SQLException, URISyntaxException {
		if(sessionId == null) {
			java.net.URI url = new java.net.URI("www.diaydoner.000webhostapp.com/login.html"); // admin panel !
			return Response.temporaryRedirect(url).build();
		}
	
		try {
			if(isAdmin.isAdminSessionId(sessionId)) {
			adminDB.addArticle(title, price);
			}else {
				String text = "Трябва да се логнете! www.diaydoner.000webhostapp.com/login.html";
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(text).build();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		
	
	java.net.URI url = new java.net.URI("http://diaydunerservice-env.65m77q8cqk.eu-central-1.elasticbeanstalk.com/admin.jsp"); // admin panel !
	return Response.temporaryRedirect(url).build();
	}
	
	@Path("admin/article")
	@POST
	public Response removeArticle(@CookieParam(value = "myStrAdmin") String sessionId,@FormParam("id") String id) throws URISyntaxException {
		try {
			adminDB.deleteArticle(id);
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		
		if(sessionId == null) {
			java.net.URI url = new java.net.URI("www.diaydoner.000webhostapp.com/login.html");
			return Response.temporaryRedirect(url).build();
		}
		
		try {
			
			if(isAdmin.isAdminSessionId(sessionId)) {
				
				adminDB.deleteArticle(id);
				
			} else {
				String text = "Трябва да се логнете! www.diaydoner.000webhostapp.com/login.html";
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(text).build();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		
		
		java.net.URI url = new java.net.URI("http://diaydunerservice-env.65m77q8cqk.eu-central-1.elasticbeanstalk.com/admin.jsp"); // admin panel !
		return Response.temporaryRedirect(url).build();
	}
	
	@Path("admin/order_id")
	@POST
	public Response CompleteOrder(@CookieParam(value = "myStrAdmin") String sessionId,@FormParam("id")String id) throws URISyntaxException {
		if(sessionId == null) {
			java.net.URI url = new java.net.URI("www.diaydoner.000webhostapp.com/login.html");
			return Response.temporaryRedirect(url).build();
		}
		
		try {
			if(isAdmin.isAdminSessionId(sessionId)) {
				
				//Should Create DB to remove article-order  or order-addres together order-articles!
				adminDB.deleteOrder(id);
				
				
				
			} else {
				String text = "Трябва да се логнете! www.diaydoner.000webhostapp.com/login.html";
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(text).build();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		java.net.URI url = new java.net.URI("http://diaydunerservice-env.65m77q8cqk.eu-central-1.elasticbeanstalk.com/admin.jsp"); // admin panel !
		return Response.temporaryRedirect(url).build();
	}
	
}
