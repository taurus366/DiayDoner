<%@page language="java" import="java.sql.*" contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%>
<%
Class.forName( "com.mysql.jdbc.Driver" );
java.sql.Connection con = DriverManager.getConnection(
    "jdbc:mysql://remotemysql.com:3306/UkfOir9In3",
    "UkfOir9In3",
    "mTRtSyvOkw"
);
out.println( con.toString() );
%>