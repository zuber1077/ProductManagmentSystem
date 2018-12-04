<%@page import="dao.ProjectManagmentDAO"%>
<%@page import="pojo.Product"%>

<%
/* take value user enter  */
String productId = request.getParameter("prodId");
String productName = request.getParameter("prodName");
String productCategory = request.getParameter("prodCategory");
Integer productPrice = Integer.parseInt(request.getParameter("prodPrice"));

Product product = new Product(productId,productName,productCategory,productPrice); /* Constracting product Obj  */

int status = ProjectManagmentDAO.addProduct(product); 
if(status == 1)
{
	response.sendRedirect("viewProducts.jsp"); 
}
else
{
	response.sendRedirect("error.jsp"); 
}

%>