<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page pageEncoding="UTF-8" %>
<%
String cookies123 = null;
Cookie cookie = null;
Cookie[] cookies = null;
cookies = request.getCookies();
 if( cookies != null)
   {
   for (int i = 0; i < cookies.length; i++){
      cookie = cookies[i];
      String b = cookie.getValue();
      
      if(cookie.getName().equals("myStrCookie")){
  
    	
      
    	  cookies123 = cookie.getValue();
      }
      
  }
  
  }

String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://remotemysql.com:3306/";
String database = "UkfOir9In3";
String userid = "UkfOir9In3";
String password = "mTRtSyvOkw";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link rel="icon" href="images/favicon.ico?" type="image/favicon.ico" />
    <style><%@include file="WEB-INF/styleCart.css"%></style>
   
    <script src="JS/scriptCart.js"></script>
   
    <title>Кошница</title>
</head>
<body>



    <div>
        <header>
            <h1>КОШНИЦА</h1>
        </header>
<form action="http://localhost:8081/Duner/rest/delete/cart" method="post" onsubmit="return ready()">

        <table id="table_cart" border="1" align="center">
           
            <tr>
                <th>ИМЕ</th>
                <th>КАКВО СЪДЪРЖА</th>
                <th>ЦЕНА</th>
                
                
            </tr>
           
           
           <%
                      	try{
                      connection = DriverManager.getConnection(connectionUrl+database, userid, password);
                      statement=connection.createStatement();
                      String sql ="select ar.`id`,ar.`title` as 'име', ca.`ketchup`, ca.`mayonnaise`, ca.`chili`, ca.`spotted_salt`,ar.`price` from `cart` as ca left join `articles` as ar on ar.`id` = ca.`article_id` where session_id="+cookies123;
                      resultSet = statement.executeQuery(sql);
                      		int i = 0;
                      		while (resultSet.next()) {
                      %>
<tr>
<td><%=resultSet.getString("име") %></td>
<td><textarea readonly id="" cols="40" rows="3">кетчуп:<%=resultSet.getString("ketchup") %>,майонеза:<%=resultSet.getString("mayonnaise") %>,чили:<%=resultSet.getString("chili") %>,шарена сол:<%=resultSet.getString("spotted_salt") %></textarea></td>
<td><%=resultSet.getString("price")+"лв" %></td>
<td><button type="submit" name="button" value=<%=resultSet.getString("id") %>>Изтрий</button></td>
</tr>


<%
i++;
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
           
           
           
           
        </table>

     
    </form>
    
    <p><a href="https://diaydoner.000webhostapp.com/">Начало</a></p>
	<p><a href="https://diaydoner.000webhostapp.com/order.html">Поръчай</a></p>

    </div>
    
</body>
</html>