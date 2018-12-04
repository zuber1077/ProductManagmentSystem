<%@page import="dao.LoginDAO"%>
<%@page import="pojo.LoginInfo"%>
<%

String userName = request.getParameter("userName");
String password = request.getParameter("password");

if(LoginDAO.isUserValid(new LoginInfo(userName,password))) // obj populate from the user input
{
	session.setAttribute("userName",userName); // name value pair
	session.setMaxInactiveInterval(200); // set session for 2 min to expired
	response.sendRedirect("home.jsp"); 
}
else 
{
	response.sendRedirect("loginFailed.jsp"); 
}
%>