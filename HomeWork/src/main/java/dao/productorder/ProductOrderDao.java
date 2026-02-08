package dao.productorder;

import java.util.List;

import model.ProductOrder;

public interface ProductOrderDao {

	//create新增
	void add(ProductOrder productOrder);
	
	//create新增
	boolean addboolean(ProductOrder productOrder);
	
	//read查詢
	List<ProductOrder> selectAll();
	
	List<ProductOrder> selectByID(int id);
	
	//update修改
	void update(ProductOrder productOrder);
	
		
	//delete刪除
	void deleteByID(int id);
	
}
