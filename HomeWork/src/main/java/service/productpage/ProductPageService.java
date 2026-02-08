package service.productpage;

import java.util.List;

import model.ProductPage;

public interface ProductPageService {
	//create
	void addProductPage(ProductPage productPage);
	//create
	boolean addbooleanProductPage(ProductPage productPage);
		
	//read
	List<ProductPage> allProductPage();
	List<ProductPage> findByID(int id);
	
	//update
	boolean updateProductPage(ProductPage productPage);
	
	//delete
	boolean deleteProductPageByID(int id);
	
}
