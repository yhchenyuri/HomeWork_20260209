package controller.market;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.ProductPage;
import util.Tool;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.Font;

public class AddProductUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField productname;
	private JTextField price;
	private JTextField amount;
	private JTextField content;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProductUI frame = new AddProductUI();
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
	public AddProductUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 411, 392);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("產品名");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel.setBounds(34, 82, 46, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("價格");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1.setBounds(34, 128, 46, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("數量");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_2.setBounds(34, 179, 46, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("內容");
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_3.setBounds(34, 231, 46, 15);
		panel.add(lblNewLabel_3);
		
		productname = new JTextField();
		productname.setBounds(108, 82, 261, 21);
		panel.add(productname);
		productname.setColumns(10);
		
		price = new JTextField();
		price.setBounds(108, 128, 261, 21);
		panel.add(price);
		price.setColumns(10);
		
		amount = new JTextField();
		amount.setBounds(108, 179, 261, 21);
		panel.add(amount);
		amount.setColumns(10);
		
		content = new JTextField();
		content.setBounds(108, 231, 261, 78);
		panel.add(content);
		content.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("商品新增");
		lblNewLabel_4.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_4.setBounds(34, 20, 351, 35);
		panel.add(lblNewLabel_4);
		
		JLabel failmsg = new JLabel("");
		failmsg.setBounds(108, 319, 261, 15);
		panel.add(failmsg);		
		
		/**************events****************/

		JButton btnNewButton = new JButton("確定");
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 使用者輸入字串(String productname, int price, int amount, String content) 
				 * 將字串轉換成對應model的int				 * 
				 * new ProductPage(String productname, int price, int amount, String content)
				 * Tool --> 存成product.txt檔				 * 
				 * 使用者按下確定 跳到下一個頁面
				 */
				String getname=productname.getText();
				int getprice=Integer.parseInt(price.getText());			
				int getamount=Integer.parseInt(amount.getText());	
				String getcontent=content.getText();
				
				ProductPage getproductpage=new ProductPage(getname,getprice,getamount,getcontent);			
	
				//Tool.saveProduct(getproductpage);	
				Tool.saveObjectFile(getproductpage, "product");		
				
				ConfirmUI confirmUI=new ConfirmUI();
				confirmUI.setVisible(true);
				dispose();
							
			/*	if(getname!=null ||getcontent!=null||price!=null||amount!=null)
				{					
					failmsg.setText("商品更新成功");
				}
				else
				{
					failmsg.setText("請填寫商品資訊");
				}
			*/
				
			}
		});
		btnNewButton.setBounds(49, 347, 87, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回上一頁");
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			ProductPageUI productpageUI=new ProductPageUI();
			productpageUI.setVisible(true);
			dispose();
			}
			
		});
		btnNewButton_1.setBounds(220, 347, 131, 23);
		panel.add(btnNewButton_1);
		

	}

}
