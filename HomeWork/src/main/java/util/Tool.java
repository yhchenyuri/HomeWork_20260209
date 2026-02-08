package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.ProductPage;

public class Tool {
	public static void main(String[] args) {
		//System.out.println(Tool.getDb());
		/*ProductPage getproductpage=new ProductPage("11",1,1,"11");
		Tool.saveProduct(getproductpage);
		*/
		/*
		//撈檔案
		ProductPage readproductpage=Tool.readProduct();
		System.out.println(readproductpage.getProductname());
		*/
	}
	
	public static Connection getDb()
	{
		String url="jdbc:mysql://localhost:3306/homework";//主機名+資料庫名
		String user="root";
		String password="1234";
		Connection conn=null;//java不能宣告沒有值的變數 //所以給一個null
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url, user, password);			
			
		} catch (ClassNotFoundException e) {
			System.out.println("no driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("no connection");
			e.printStackTrace();
		}
				
		return conn;
	}
	
	/*
		//存檔 writeObject
		public static void saveProduct(ProductPage getproductpage )
		{
			try {
				FileOutputStream fos = new FileOutputStream("product.txt");
				ObjectOutputStream oos=new ObjectOutputStream(fos);
				oos.writeObject(getproductpage);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		*/
		
	/*
	 	//讀檔 readObject
	 	public static ProductPage readProduct()
		{
			ProductPage productpage=null;
			try {
				FileInputStream fis=new FileInputStream("product.txt");
				ObjectInputStream ois=new ObjectInputStream(fis);
				productpage=(ProductPage)(ois.readObject());
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return productpage;
		}
	 */
	
		//存檔-->writeObject
		public static void saveObjectFile(Object object, String saveFile)
		{
			try {
				FileOutputStream fos=new FileOutputStream(saveFile+".txt");
				ObjectOutputStream oos=new ObjectOutputStream(fos);
				oos.writeObject(object);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//讀檔-->readObject
		public static Object readObjectFile(String readFile)
		{
			Object object=null;
			try {
				FileInputStream fis=new FileInputStream(readFile+".txt");
				ObjectInputStream ois=new ObjectInputStream(fis);
				
				object=ois.readObject();
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return object;
		}

}