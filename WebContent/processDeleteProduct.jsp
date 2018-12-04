<%@page import="dao.ProjectManagmentDAO"%>
<%@page import="pojo.Product"%>

<%

String productId = request.getParameter("prodId");

int status = ProjectManagmentDAO.deleteProduct(productId);
if(status == 1)
{
	response.sendRedirect("viewProducts.jsp"); 
}
else
{
	response.sendRedirect("error.jsp"); 
}

%>