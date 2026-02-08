package model;

import java.io.Serializable;
import java.util.Date;

public class ProductOrder implements Serializable{
	private int ID;
	private String order_no;
	private String product_no;
	private String order_date;
	private int product_item1;
	private int product_item2;
	private int product_item3;
	private int sum;
	
	public ProductOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductOrder(int product_item1, int product_item2, int product_item3) {
		super();
		this.product_item1 = product_item1;
		this.product_item2 = product_item2;
		this.product_item3 = product_item3;
		Date d=new Date();		
		order_date=(1900+d.getYear())+"-"+(1+d.getMonth())+"-"+d.getDay();
		sum=product_item1*299+product_item2*599+product_item3*399;		
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public String getProduct_no() {
		return product_no;
	}
	public void setProduct_no(String product_no) {
		this.product_no = product_no;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public int getProduct_item1() {
		return product_item1;
	}
	public void setProduct_item1(int product_item1) {
		this.product_item1 = product_item1;
	}
	public int getProduct_item2() {
		return product_item2;
	}
	public void setProduct_item2(int product_item2) {
		this.product_item2 = product_item2;
	}
	public int getProduct_item3() {
		return product_item3;
	}
	public void setProduct_item3(int product_item3) {
		this.product_item3 = product_item3;
	}
	
	

}
