package dao.productorder.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.productorder.ProductOrderDao;
import model.ProductOrder;
import util.Tool;

public class ProductOrderDaoImpl implements ProductOrderDao{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Connection conn=Tool.getDb();

	@Override
	public void add(ProductOrder productOrder) {
		String sql="insert into productorder(int product_item1, int product_item2, int product_item3) values(?,?,?)";
		
		try {
			PreparedStatement prepareadd=conn.prepareStatement(sql);
			//prepareadd.setString(1,productOrder.getOrder_date());
			prepareadd.setInt(1,productOrder.getProduct_item1());
			prepareadd.setInt(2,productOrder.getProduct_item2());
			prepareadd.setInt(3,productOrder.getProduct_item3());
			
			prepareadd.executeUpdate();					
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean addboolean(ProductOrder productOrder) {
		String sql="insert into productorder(int product_item1, int product_item2, int product_item3) values(?,?,?)";
		try {
			PreparedStatement prepareadd=conn.prepareStatement(sql);
			//prepareadd.setString(1,productOrder.getOrder_date());
			prepareadd.setInt(1,productOrder.getProduct_item1());
			prepareadd.setInt(2,productOrder.getProduct_item2());
			prepareadd.setInt(3,productOrder.getProduct_item3());
			
			return prepareadd.executeUpdate()>0;		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("新增商品失敗", e);
		}
		
	}

	@Override
	public List<ProductOrder> selectAll() {
		String sql="select * from productorder";
		List<ProductOrder> productorderlist=new ArrayList<>();
		
		try {
			PreparedStatement prepareall=conn.prepareStatement(sql);
			ResultSet resultall=prepareall.executeQuery();
			
			while(resultall.next())
			{
			ProductOrder productorder=new ProductOrder();
			productorder.setProduct_item1(resultall.getInt("product_item1"));
			productorder.setProduct_item2(resultall.getInt("product_item2"));
			productorder.setProduct_item3(resultall.getInt("product_item3"));
			productorder.setOrder_date(resultall.getString("Order_date"));
			productorder.setID(resultall.getInt("ID"));
			productorder.setOrder_no(resultall.getString("Order_no"));
			productorder.setProduct_no(resultall.getString("Product_no"));
			
			productorderlist.add(productorder);			
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return productorderlist;
	}

	@Override
	public List<ProductOrder> selectByID(int id) {
		String sql="select * from productorder where ID=?";
		List<ProductOrder> productorderlist=new ArrayList<>();
		
		try {
			PreparedStatement preparebyID=conn.prepareStatement(sql);
			preparebyID.setInt(1, id);
			ResultSet resultbyID=preparebyID.executeQuery();
			
			if(resultbyID.next())
			{
				ProductOrder productorder=new ProductOrder();
				productorder.setProduct_item1(resultbyID.getInt("product_item1"));
				productorder.setProduct_item2(resultbyID.getInt("product_item2"));
				productorder.setProduct_item3(resultbyID.getInt("product_item3"));
				productorder.setOrder_date(resultbyID.getString("Order_date"));
				productorder.setID(resultbyID.getInt("ID"));
				productorder.setOrder_no(resultbyID.getString("Order_no"));
				productorder.setProduct_no(resultbyID.getString("Product_no"));
				
				productorderlist.add(productorder);	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productorderlist ;
	}

	@Override
	public void update(ProductOrder productOrder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByID(int id) {
		// TODO Auto-generated method stub
		
	}

}
