package controller.market;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.account.LoginUI;
import model.ProductPage;
import service.productpage.impl.ProductPageServiceImpl;


import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;


import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;


public class EditUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField updateName;
	private JTextField updatePrice;
	private JTextField updateAmount;
	private JTextField updateContent;
	private ProductPageServiceImpl productpageserviceimpl=new ProductPageServiceImpl();
	private JTextField deleteID;
	private JTextField updateID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditUI frame = new EditUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EditUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 732, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 698, 486);
		contentPane.add(panel);
		panel.setLayout(null);
		
		updateName = new JTextField();
		updateName.setBounds(150, 299, 96, 21);
		panel.add(updateName);
		updateName.setColumns(10);
		
		updatePrice = new JTextField();
		updatePrice.setColumns(10);
		updatePrice.setBounds(358, 299, 96, 21);
		panel.add(updatePrice);
		
		JLabel lblNewLabel = new JLabel("產品名");
		lblNewLabel.setBounds(81, 302, 38, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("價格");
		lblNewLabel_1.setBounds(302, 302, 46, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("數量");
		lblNewLabel_1_1.setBounds(81, 347, 46, 15);
		panel.add(lblNewLabel_1_1);
		
		updateAmount = new JTextField();
		updateAmount.setColumns(10);
		updateAmount.setBounds(150, 344, 96, 21);
		panel.add(updateAmount);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("內容");
		lblNewLabel_1_1_1.setBounds(302, 344, 46, 15);
		panel.add(lblNewLabel_1_1_1);
		
		updateContent = new JTextField();
		updateContent.setColumns(10);
		updateContent.setBounds(358, 341, 96, 21);
		panel.add(updateContent);
		
		deleteID = new JTextField();
		deleteID.setBounds(122, 429, 96, 21);
		panel.add(deleteID);
		deleteID.setColumns(10);
		
		JLabel totalcount = new JLabel("訂單數量:");
		totalcount.setBounds(129, 215, 194, 15);
		panel.add(totalcount);
		
		JLabel totalprice = new JLabel("總計金額:");
		totalprice.setBounds(390, 215, 148, 15);
		panel.add(totalprice);
		
		JTextArea editoutput = new JTextArea();
		editoutput.setBounds(129, 11, 499, 189);
		panel.add(editoutput);
		
		
		/************event****************/
		
		JButton btnNewButton = new JButton("查詢現況");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				List<ProductPage> proguctpagelist=productpageserviceimpl.allProductPage();
				String list="";
				int count=0;
				int sum=0;
				
				for(ProductPage finallist:proguctpagelist)
				{									
					int amounts=finallist.getPrice()*finallist.getAmount();
										
					list=list+"ID"+finallist.getId()+"\t產品名"+finallist.getProductname()+"\t價格"+finallist.getPrice()
					+"\t數量"+finallist.getAmount()+"\t內容"+finallist.getContent()+"\n";
					count++;					
					sum=sum+amounts;					
				}				
				editoutput.setText(list);
				totalcount.setText("你的訂單數量為"+String.valueOf(count)+"筆"); 
				totalprice.setText("總計金額為"+sum+"元"); 
			}
		});
		btnNewButton.setBounds(32, 13, 87, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("修改並更新");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.擷取ID,ProductName,Price,Amount,Content  -->getText()-->String , Id轉型-->int
				 * 2.id-->調閱-->資料庫--> ProductPage(產品名,價格,數量,內容)
				 * 3.判斷--輸入-->ProductName,Price,Amount,Content-->沒有輸入-->不做set修改
				 * 4.執行update方法
				 * 5.更新 表內容
				 */
				
				int ID=Integer.parseInt(updateID.getText());
				String productName=updateName.getText();
				String productPrice=updatePrice.getText();
				String productAmount=updateAmount.getText();
				String productContent=updateContent.getText();
				//int productPrice=Integer.parseInt(updatePrice.getText());
				//int productAmount=Integer.parseInt(updateAmount.getText());
				
				List<ProductPage> productpagelist=productpageserviceimpl.findByID(ID);
				ProductPage productpagefix=productpagelist.get(0);
				
				if(!productName.equals("")) productpagefix.setProductname(productName);		
				if(!productPrice.equals("")) {
					int Price=Integer.parseInt(productPrice);
					productpagefix.setPrice(Price);					
				}
				if(!productAmount.equals("")) {
					int Amount=Integer.parseInt(productAmount);
					productpagefix.setAmount(Amount);
				}
				if(!productContent.equals("")) productpagefix.setContent(productContent);
				
				productpageserviceimpl.updateProductPage(productpagefix);
				
									
						List<ProductPage> proguctpagelist=productpageserviceimpl.allProductPage();
						String list="";
						int count=0;
						int sum=0;
						
						for(ProductPage finallist:proguctpagelist)
						{									
							int amounts=finallist.getPrice()*finallist.getAmount();
												
							list=list+"ID"+finallist.getId()+"\t產品名"+finallist.getProductname()+"\t價格"+finallist.getPrice()
							+"\t數量"+finallist.getAmount()+"\t內容"+finallist.getContent()+"\n";
							count++;					
							sum=sum+amounts;					
						}				
						editoutput.setText(list);
						totalcount.setText("你的訂單數量為"+String.valueOf(count)+"筆"); 
						totalprice.setText("總計金額為"+sum+"元"); 
							
				
			}
		});
		btnNewButton_1.setBounds(226, 250, 116, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("確認刪除");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ID=Integer.parseInt(deleteID.getText());
				productpageserviceimpl.deleteProductPageByID(ID);
				
			}
		});
		btnNewButton_2.setBounds(241, 428, 87, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("回我的賣場");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ProductPageUI productpageUI=new ProductPageUI();
				productpageUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(428, 455, 132, 23);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("輸入要刪除的ID");
		lblNewLabel_2.setBounds(16, 432, 96, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblId = new JLabel("請先輸入修改ID");
		lblId.setBounds(10, 254, 109, 15);
		panel.add(lblId);
		
		updateID = new JTextField();
		updateID.setColumns(10);
		updateID.setBounds(105, 251, 96, 21);
		panel.add(updateID);
		
		JButton btnNewButton_3_1 = new JButton("回登入頁");
		btnNewButton_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI log=new LoginUI();
				log.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3_1.setBounds(570, 455, 109, 23);
		panel.add(btnNewButton_3_1);
		

		
		

	}
}
