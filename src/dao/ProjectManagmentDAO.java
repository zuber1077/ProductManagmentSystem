package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dbutil.DBUtil;
import pojo.Product;

public class ProjectManagmentDAO {
	
	/* GET PRODUCT */

	public static List<Product> getAllProducts()
	{
		List<Product> productList = new ArrayList<Product>();
		try
		{
			Connection conn = DBUtil.getConnection();
			Statement st= conn.createStatement();
			ResultSet rs= st.executeQuery("SELECT * FROM product");
			while(rs.next())
			{
				Product product = new Product(rs.getString("prod_id"),
						rs.getString("prod_name"),
						rs.getString("prod_category"),
						rs.getInt("prod_price"));
				productList.add(product);
			}
			
			DBUtil.closeConnection(conn);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return productList;
	}
	
	/* ADD PRODUCT */
	
	public static int addProduct(Product product)
	{
		int status = 0;
		try
		{
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement("INSERT INTO product VALUES(?,?,?,?)"); //parametrise query
			ps.setString(1, product.getProductId()); // set parameter
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getProductCategory());
			ps.setInt(4, product.getProductPrice());
			status = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
}
