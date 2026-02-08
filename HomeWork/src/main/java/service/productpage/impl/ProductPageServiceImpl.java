package service.productpage.impl;

import java.util.List;

import dao.productpage.impl.ProductPageDaoImpl;
import model.ProductPage;
import service.productpage.ProductPageService;

public class ProductPageServiceImpl implements ProductPageService{

	public static void main(String[] args) {
		//System.out.println (new ProductPageServiceImpl().addbooleanProductPage(new ProductPage("boolean",10,10,"new")));			
	}
	
	ProductPageDaoImpl productpageDaoImpl=new ProductPageDaoImpl();

//create
	@Override
	public void addProductPage(ProductPage productPage) {
		// TODO Auto-generated method stub		
		}

	//create	
		@Override
		public boolean addbooleanProductPage(ProductPage productPage) 
		{ 		if(productPage.getAmount() <0 ||productPage.getPrice()<0)
					{
				return false;					
					}
				return productpageDaoImpl.addboolean(productPage);					
			}
	
//read
	@Override
	public List<ProductPage> allProductPage() {
		return productpageDaoImpl.selectAll();
	}
	
//read
	@Override
	public List<ProductPage> findByID(int id) {
		return productpageDaoImpl.selectByID(id);
	}

//update
	@Override
	public boolean updateProductPage(ProductPage productPage) {
		// TODO Auto-generated method stub
		boolean update=false;
		if(productPage.getAmount() >=0 &&productPage.getPrice()>=0)
		{
			productpageDaoImpl.update(productPage);
			update=true;			
		}
		return update;
	}
	
//delete
	@Override
	public boolean deleteProductPageByID(int id) {
		// TODO Auto-generated method stub
		boolean delete=false;
		if(id>0)
		{
			productpageDaoImpl.deleteByID(id);
			delete=true;
		}
		return delete;
	}

	}		


