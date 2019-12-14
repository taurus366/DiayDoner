package apiControllers;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import databases.ArticleDB;

@Path("/")
public class ArticleController {

	ArticleDB articleDB = new ArticleDB();
	
	
	
	@Path("/articles")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getArticlesName() throws ClassNotFoundException, SQLException {
		
		
		return articleDB.getAllArticlesNameFromDB();
		
	}

}
