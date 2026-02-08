package service.productorder;

import java.util.List;

import model.ProductOrder;


public interface ProductOrderService {
	//create
	void addProductOrder(ProductOrder productOrder);
	//create
	boolean addbooleanProductOrder(ProductOrder productOrder);
		
	//read
	List<ProductOrder> allProductOrder();
	List<ProductOrder> findByID(int id);
	String allProductOrderString();
	String findProductOrderAmonts(int start,int end);
	
	//update
	boolean updateProductOrder(ProductOrder productOrder);
	
	//delete
	boolean deleteProductOrderByID(int id);
}
