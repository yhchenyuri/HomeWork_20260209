package dao.productpage;

import java.util.List;

import model.ProductPage;

public interface ProductPageDao {
	
	//create新增
	void add(ProductPage productPage);
	
	//create新增
	boolean addboolean(ProductPage productPage);
	
	//read查詢
	List<ProductPage> selectAll();
	
	List<ProductPage> selectByID(int id);
	
	//update修改
	void update(ProductPage productPage);
	
		
	//delete刪除
	void deleteByID(int id);
	

}
