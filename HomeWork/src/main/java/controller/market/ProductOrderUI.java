package controller.market;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.account.LoginUI;
import controller.account.MarketSelectUI;
import service.productorder.impl.ProductOrderServiceImpl;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

public class ProductOrderUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField item1_fan;
	private JTextField item2_doll;
	private JTextField item3_cup;
	
	ProductOrderServiceImpl productorderserviceimpl=new ProductOrderServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductOrderUI frame = new ProductOrderUI();
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
	public ProductOrderUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 764, 405);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fan");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel.setBounds(27, 52, 46, 32);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Doll");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1.setBounds(27, 93, 46, 32);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cup");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_2.setBounds(27, 135, 46, 32);
		panel.add(lblNewLabel_2);
		
		item1_fan = new JTextField();
		item1_fan.setBounds(211, 52, 96, 32);
		panel.add(item1_fan);
		item1_fan.setColumns(10);
		
		item2_doll = new JTextField();
		item2_doll.setBounds(211, 93, 96, 32);
		panel.add(item2_doll);
		item2_doll.setColumns(10);
		
		item3_cup = new JTextField();
		item3_cup.setBounds(211, 135, 96, 32);
		panel.add(item3_cup);
		item3_cup.setColumns(10);
		
		JTextArea show_items = new JTextArea();
		show_items.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		show_items.setBounds(27, 177, 718, 82);
		panel.add(show_items);
		
		JTextArea show_all_order = new JTextArea();
		show_all_order.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		show_all_order.setBounds(27, 281, 718, 82);
		panel.add(show_all_order);
		
		
		JLabel lblNewLabel_3 = new JLabel("299元/個");
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_3.setBounds(123, 52, 78, 32);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("599元/個");
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(123, 93, 78, 32);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("399元/個");
		lblNewLabel_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(123, 135, 78, 32);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_4 = new JLabel("歡迎選購平台商品");
		lblNewLabel_4.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_4.setBounds(27, 10, 153, 32);
		panel.add(lblNewLabel_4);

		/***************************events*****************************/
		

		JButton btnNewButton = new JButton("確認訂購");
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {		
				
				/*
				 * 1.擷取Fan,Doll,Cup
				 * 2.new ProductOrder(int product_item1, int product_item2, int product_item3)
				 * 3.存成 Order.txt
				 * 4.直接顯示
				 */
				
				int Fan=Integer.parseInt(item1_fan.getText());
				int Doll=Integer.parseInt(item2_doll.getText());
				int Cup=Integer.parseInt(item3_cup.getText());
				
				int sum;	
				Date d=new Date();		
				sum=Fan*299+Doll*599+Cup*399;
				
				show_items.setText("本次訂單"+"\tFan:"+Fan+"\tDoll:"+Doll
				+"\tCup:"+Cup+"\t總額"+sum+"\t時間"+((1900+d.getYear())+"-"+(1+d.getMonth())+"-"+d.getDay())+"\n");
				
				show_all_order.setText("所有訂單如下\n"+productorderserviceimpl.allProductOrderString());
			}
		});
		btnNewButton.setBounds(336, 134, 102, 32);
		panel.add(btnNewButton);
		
		
		
		JButton btnNewButton_1 = new JButton("回我的賣場");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ProductPageUI productpageUI=new ProductPageUI();
				productpageUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton_1.setBounds(620, 93, 120, 32);
		panel.add(btnNewButton_1);
		
		
		JButton btnNewButton_1_2 = new JButton("回登入頁");
		btnNewButton_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI loginUI=new LoginUI();
				loginUI.setVisible(true);
				dispose();				
			}
		});
		btnNewButton_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton_1_2.setBounds(620, 12, 120, 32);
		panel.add(btnNewButton_1_2);

		JButton btnNewButton_1_1 = new JButton("離開");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton_1_1.setBounds(620, 135, 120, 32);
		panel.add(btnNewButton_1_1);	
		
		JButton btnNewButton_1_2_1 = new JButton("回選擇平台頁");
		btnNewButton_1_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MarketSelectUI marketselctUI=new MarketSelectUI();
				 marketselctUI.setVisible(true);
				dispose(); 
			}
		});
		btnNewButton_1_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton_1_2_1.setBounds(620, 52, 120, 32);
		panel.add(btnNewButton_1_2_1);
	

	}

}
