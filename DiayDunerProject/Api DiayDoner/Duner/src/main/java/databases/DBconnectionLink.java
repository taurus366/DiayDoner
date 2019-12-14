package databases;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBconnectionLink {

	public String schema = "UkfOir9In3";
	public String name = "UkfOir9In3";
	public String password = "mTRtSyvOkw";

	public Connection getConnectionLink() throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");

		return (Connection) DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/" + schema, name, password);
	}
}
