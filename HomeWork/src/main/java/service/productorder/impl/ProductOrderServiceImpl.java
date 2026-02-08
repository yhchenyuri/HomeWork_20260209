package service.productorder.impl;

import java.util.Date;
import java.util.List;

import dao.productorder.impl.ProductOrderDaoImpl;
import model.ProductOrder;
import service.productorder.ProductOrderService;

public class ProductOrderServiceImpl implements ProductOrderService{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}	
	ProductOrderDaoImpl productorderdaoimpl=new ProductOrderDaoImpl ();

	@Override
	public void addProductOrder(ProductOrder productOrder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addbooleanProductOrder(ProductOrder productOrder) {
		
		return productorderdaoimpl.addboolean(productOrder);
	}

	@Override
	public List<ProductOrder> allProductOrder() {		
		return productorderdaoimpl.selectAll();
		
		
	}

	@Override
	public List<ProductOrder> findByID(int id) {	
		return productorderdaoimpl.selectByID(id);		
	}

	@Override
	public boolean updateProductOrder(ProductOrder productOrder) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProductOrderByID(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String allProductOrderString() {
		// TODO Auto-generated method stub
		//List<Order_reporter_01> order_reporter_01=order_reporter01_daoimpl.findAll();
		List<ProductOrder> product_order=productorderdaoimpl.selectAll();
		String show_item="";
		Date d=new Date();			
		//order_date=(1900+d.getYear())+"-"+(1+d.getMonth())+"-"+d.getDay();
		
		for (ProductOrder p:product_order)
		{
			show_item=show_item+"訂單編號"+p.getOrder_no()+"\tFan:"+p.getProduct_item1()+"\tDoll:"+p.getProduct_item2()
			+"\tCup:"+p.getProduct_item3()+"\t時間"+((1900+d.getYear())+"-"+(1+d.getMonth())+"-"+d.getDay())+"\n"; 	

		}
		return show_item;
	}

	@Override
	public String findProductOrderAmonts(int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
