package dao.productpage.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.productpage.ProductPageDao;
import model.ProductPage;
import util.Tool;

public class ProductPageDaoImpl implements ProductPageDao{

	//測試功能
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new ProductPageDaoImpl().add(new ProductPage("test3",1,1,"likenew"));
		//System.out.println(new ProductPageDaoImpl().selectAll());
		//System.out.println(new ProductPageDaoImpl().selectbyID(5).size());
		//new ProductPageDaoImpl().deleteByID(6);		
	/*	List<ProductPage> productpageE=new ProductPageDaoImpl().selectbyID(5);
		System.out.println(productpageE);
		ProductPage productpage=productpageE.get(0);
		productpage.setContent("old");
		new  ProductPageDaoImpl().update(productpage);		
	*/
		//new ProductPageDaoImpl().addboolean(new ProductPage("addboolean",1,-11,"likenew"));
		
	}	
	//先連上mysql
	Connection conn=Tool.getDb();
	
	//create
	@Override
	public void  add(ProductPage productPage) {
		// TODO Auto-generated method stub
		String sql="insert into productpage(productname,price,amount,content) values(?,?,?,?)";
		try {
			PreparedStatement prepareadd=conn.prepareStatement(sql);
			prepareadd.setString(1,productPage.getProductname());
			prepareadd.setInt(2,productPage.getPrice());
			prepareadd.setInt(3,productPage.getAmount());
			prepareadd.setString(4,productPage.getContent());
			
			prepareadd.executeUpdate();			
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//read
	@Override
	public List<ProductPage> selectAll() {
		String sql="select * from productpage";
		List<ProductPage> productpagelist=new ArrayList<>();
		
		try {
			PreparedStatement prepareall=conn.prepareStatement(sql);
			ResultSet resultall=prepareall.executeQuery();
			
			while(resultall.next())
			{
				ProductPage productpage=new ProductPage();
				productpage.setId(resultall.getInt("ID"));
				productpage.setProductname(resultall.getString("productname"));
				productpage.setPrice(resultall.getInt("price"));
				productpage.setAmount(resultall.getInt("amount"));
				productpage.setContent(resultall.getString("content"));
				
				productpagelist.add(productpage);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return productpagelist ;
	}
	
	//read
	@Override
	public List<ProductPage> selectByID(int id) {
		String sql="select * from productpage where ID=?";
		List<ProductPage> productpagelist=new ArrayList<>();
		
		try {
			PreparedStatement preparebyID=conn.prepareStatement(sql);
			preparebyID.setInt(1, id);
			ResultSet resultbyID=preparebyID.executeQuery();
			
			if(resultbyID.next())
			{
				ProductPage productpage=new ProductPage();
				productpage.setId(resultbyID.getInt("ID"));
				productpage.setProductname(resultbyID.getString("productname"));
				productpage.setPrice(resultbyID.getInt("price"));
				productpage.setAmount(resultbyID.getInt("amount"));
				productpage.setContent(resultbyID.getString("content"));
				productpagelist.add(productpage);						
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return productpagelist;
	}
	
	//update
	@Override
	public void update(ProductPage productPage) {
		// TODO Auto-generated method stub
	String sql="update productpage set productname=?,price=?, amount=?,content=? where id=?";
		try {
			PreparedStatement prepareupdate=conn.prepareStatement(sql);
			prepareupdate.setString(1, productPage.getProductname());
			prepareupdate.setInt(2, productPage.getPrice());
			prepareupdate.setInt(3, productPage.getAmount());
			prepareupdate.setString(4, productPage.getContent());
			prepareupdate.setInt(5, productPage.getId());
			
			prepareupdate.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//delete
	@Override
	public void deleteByID(int id) {
		// TODO Auto-generated method stub
		String sql="delete from productpage where ID=?";
		try {
			PreparedStatement preparedelete=conn.prepareStatement(sql);
			preparedelete.setInt(1,id);
			preparedelete.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//create by boolean
	@Override
	public boolean addboolean(ProductPage productPage) {
		String sql="insert into productpage(productname,price,amount,content) values(?,?,?,?)";
		try {
			PreparedStatement prepareadd=conn.prepareStatement(sql);
			prepareadd.setString(1,productPage.getProductname());
			prepareadd.setInt(2,productPage.getPrice());
			prepareadd.setInt(3,productPage.getAmount());
			prepareadd.setString(4,productPage.getContent());			
			return prepareadd.executeUpdate()>0;									
		} catch (SQLException e) {
			throw new RuntimeException("新增商品失敗", e);
			}
	
	}

}
