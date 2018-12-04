<%
session.invalidate(); // invalidate sessions
response.sendRedirect("login.jsp");
%>