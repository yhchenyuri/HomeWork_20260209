package controller.market;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.ProductPage;
import service.productpage.impl.ProductPageServiceImpl;
import util.Tool;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class ConfirmUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmUI frame = new ConfirmUI();
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
	public ConfirmUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 462, 267);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea confirmshow = new JTextArea();
		confirmshow.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		confirmshow.setBackground(new Color(235, 235, 235));
		confirmshow.setBounds(10, 10, 442, 206);
		panel.add(confirmshow);
		
		/**************events****************/
		
		//先在confirm頁顯示產品需求內容
		//ProductPage readproductpage=Tool.readProduct();
		ProductPage readproductpage=(ProductPage)Tool.readObjectFile("product");		
		
		String productOutput="新增商品如下:"+"\n產品名"+readproductpage.getProductname()+"\n價格"+readproductpage.getPrice()
		+"\n數量"+readproductpage.getAmount()+"\n內容"+readproductpage.getContent();
		
		confirmshow.setText(productOutput);
		
		JButton btnNewButton = new JButton("確定");
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ProductPageServiceImpl().addbooleanProductPage(readproductpage);
								
				FinishedUI finishedUI=new FinishedUI();
				finishedUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(31, 226, 87, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("重新選購");
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddProductUI addproductUI=new AddProductUI();
				addproductUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(180, 226, 87, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("回首頁");
		btnNewButton_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ProductPageUI productpageUI=new ProductPageUI();
				productpageUI.setVisible(true);
				dispose();
				}
		});
		btnNewButton_1_1.setBounds(331, 226, 87, 23);
		panel.add(btnNewButton_1_1);

	}

}
