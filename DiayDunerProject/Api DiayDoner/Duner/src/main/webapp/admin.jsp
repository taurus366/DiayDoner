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
if(cookies != null){
    for(int i = 0; i < cookies.length; i++){
        cookie = cookies[i];
        String b =cookie.getValue();

        if(cookie.getName().equals("myStrAdmin")){

            cookies123 = cookie.getValue();
        }
    }
}else {
    
    String redirectURL = "http://diaydoner.000webhostapp.com/login.html";
    response.sendRedirect(redirectURL);

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
    <link rel="icon" href="images/favicon.ico">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="CSS/styleAdmin.css">
    <title>Админ панел</title>
</head>
<body>

    <div>

        <header>
            <h1>АДМИН ПАНЕЛ</h1>
        </header>

        
           <form action="http://diaydunerservice-env.65m77q8cqk.eu-central-1.elasticbeanstalk.com/rest/admin/order_id" method="post">
           
                <table  border="1" align="center" style="width: fit-content;">
                    <tr>
                    <th class="th1">Време на поръчка</th>
                    <th class="th1">Адрес</th>
                    <th class="th1">Телефон</th>
                    <th class="th1">Име</th>
                    <th class="th1">Презиме</th>
                    <th class="th1">Фамилия</th>
                    <th class="th1">Място</th> 
                    <th class="th1">Храна</th>
                    <th class="th1">Потвърди</th>
					</tr>
                    <%
                      	try{
                      connection = DriverManager.getConnection(connectionUrl+database, userid, password);
                      statement=connection.createStatement();
                      String sql ="select or_ad.`id`, or_ad.`firstname` as 'name', or_ad.`secondname` as 'secondname', or_ad.`thirdname` as 'thirdname', or_ad.`address` as 'address', or_ad.`phone` as 'phone', or_ad.`city` as 'city', or_ad.`ordered_time` as 'order_time', GROUP_CONCAT( ar.`title`, '~== ', 'кетчуп:', or_ar.`ketchup`, '/ ', 'майонеза:', or_ar.`mayonnaise` , '/ ', 'чили:', or_ar.`chili`  , '/ ', 'шарена сол:', or_ar.`spotted_salt`   SEPARATOR ' (!,!) ' ) as 'zakuska' from `orders_address` as or_ad left join `orders_article` as or_ar on or_ad.`id` = or_ar.`order_id` left join `articles` as ar on or_ar.`article_id` = ar.`id` group by  or_ad.`id` ORDER BY day(or_ad.`ordered_time`) , hour(or_ad.`ordered_time`) asc";
                      resultSet = statement.executeQuery(sql);
                      		int i = 0;
                      		while (resultSet.next()) {
                      %>

                      <tr>
                        <td><textarea readonly id="" cols="21" rows="4"><%=resultSet.getString("order_time") %></textarea></td>
                        <td><textarea readonly id="" cols="17" rows="4"><%=resultSet.getString("address") %></textarea></td>
                        <td><textarea readonly id="" cols="17" rows="4"><%=resultSet.getString("phone") %></textarea></td>
                        <td><textarea readonly id="" cols="17" rows="4"><%=resultSet.getString("name") %></textarea></td>
                        <td><textarea readonly id="" cols="17" rows="4"><%=resultSet.getString("secondname") %></textarea></td>
                        <td><textarea readonly id="" cols="17" rows="4"><%=resultSet.getString("thirdname") %></textarea></td>
                        <td><textarea readonly id="" cols="17" rows="4"><%=resultSet.getString("city") %></textarea></td>
                        <td><textarea readonly id="" cols="60" rows="4"><%=resultSet.getString("zakuska") %></textarea></td>
                        <td><button type="submit" name="id" value=<%=resultSet.getString("id") %>>Потвърди</button></td>


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
           

           <div class="article-table">
                <h2>Добавяне на нов Артикул в базата данни</h2>
                <form action="http://diaydunerservice-env.65m77q8cqk.eu-central-1.elasticbeanstalk.com/rest/admin/Adarticle" method="post">
                       
                    
                    <p>Име <input type="text" name="title"></p>
                    
                    <p>Цена <input type="text" name="price"></p>
    
                    <button type="submit">Добави</button>
                   </form>
                </div>
        

       <div class="delete-table">

        <h2>Изтриване артикул от базата данни</h2>
		<form action="http://diaydunerservice-env.65m77q8cqk.eu-central-1.elasticbeanstalk.com/rest/admin/article" method="post">
        <table  border="1" align="center" style="width: fit-content;">
           <tr>
            <th>Име</th>
            <th>Цена</th>
            <th></th>
</tr>
<%
                      	try{
                      connection = DriverManager.getConnection(connectionUrl+database, userid, password);
                      statement=connection.createStatement();
                      String sql ="select * from articles";
                      resultSet = statement.executeQuery(sql);
                      		int i = 0;
                      		while (resultSet.next()) {
                      %>
                      <tr>
                       <td><%=resultSet.getString("title") %></td>
                       <td><%=resultSet.getString("price") %></td>
                       <td><button type="submit" name="id" value=<%=resultSet.getString("id") %>>Изтрий</button></td>
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
       </div>
                
              




            



    </div>
    
</body>
</html>