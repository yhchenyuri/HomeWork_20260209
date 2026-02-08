package model;

import java.io.Serializable;

public class ProductPage implements Serializable {
	private int id;
	private String productname;
	private int price;
	private int amount;
	private String content;
	private boolean selected;

	public ProductPage()
	{
		super();
	}
	
	public ProductPage(String productname, int price, int amount, String content) {
		super();
		this.productname = productname;
		this.price = price;
		this.amount = amount;
		this.content = content;		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}


}
