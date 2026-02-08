package controller.market;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.ProductPage;
import service.productpage.impl.ProductPageServiceImpl;
import util.JTableModel;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.account.LoginUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;


public class BuySellUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTableModel productTable;
	private JTable table_2;
	private JTextField textField;
	private JTextField textField_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuySellUI frame = new BuySellUI();
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
	public BuySellUI() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 727, 446);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			panel.setBounds(10, 10, 691, 387);
			contentPane.add(panel);
			panel.setLayout(null);
		
			JLabel msg = new JLabel("");
			msg.setFont(new Font("微軟正黑體", Font.BOLD, 14));
	       msg.setBounds(444, 265, 223, 23);
	       panel.add(msg);

			JLabel lblNewLabel = new JLabel("歡迎到二手交易平台");
			lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
			lblNewLabel.setBounds(20, 3, 263, 37);
			panel.add(lblNewLabel);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 43, 647, 181);
			panel.add(scrollPane);		
		
			scrollPane.setColumnHeaderView(table_2);
	        
	        textField = new JTextField();
	        textField.setBounds(309, 234, 96, 21);
	        panel.add(textField);
	        textField.setColumns(10);
	        
	        JLabel lblNewLabel_1 = new JLabel("選擇產品編號");
	        lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
	        lblNewLabel_1.setBounds(193, 234, 104, 18);
	        panel.add(lblNewLabel_1);     
	        
	        JTextArea textArea = new JTextArea();
	        textArea.setBackground(new Color(227, 227, 227));
	        textArea.setBounds(20, 298, 647, 72);
	        panel.add(textArea);
	        
	        JLabel lblNewLabel_2 = new JLabel("選購商品如下:");
	        lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 12));
	        lblNewLabel_2.setBounds(20, 273, 105, 15);
	        panel.add(lblNewLabel_2);
	        
	        textField_1 = new JTextField();
	        textField_1.setColumns(10);
	        textField_1.setBounds(309, 265, 96, 21);
	        panel.add(textField_1);
	        
	        JLabel lblNewLabel_1_1 = new JLabel("輸入產品數量");
	        lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
	        lblNewLabel_1_1.setBounds(193, 265, 104, 18);
	        panel.add(lblNewLabel_1_1);
	        

	        
	        /*********************events*******************/
	        
			table_2 = new JTable();
			scrollPane.setViewportView(table_2);

		        // 初始化：把 List 丟進 TableModel → setModel
				
				List<ProductPage> list = new ProductPageServiceImpl().allProductPage();
		        productTable = new JTableModel(list);
		        table_2.setModel(productTable);
		        
		        JButton btnNewButton_1 = new JButton("回登入頁");
		        btnNewButton_1.addMouseListener(new MouseAdapter() {
		        	@Override
		        	public void mouseClicked(MouseEvent e) {
		        		LoginUI loginUI= new LoginUI();
		        		loginUI.setVisible(true);
		        		dispose();
		        		
		        	}
		        });
		        btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		        btnNewButton_1.setBounds(562, 10, 105, 24);
		        panel.add(btnNewButton_1);
		        
		        JButton btnNewButton_2_1 = new JButton("離開");
		        btnNewButton_2_1.addMouseListener(new MouseAdapter() {
		        	@Override
		        	public void mouseClicked(MouseEvent e) {
		        		System.exit(0);
		        	}
		        });
		        btnNewButton_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		        btnNewButton_2_1.setBounds(546, 232, 105, 23);
		        panel.add(btnNewButton_2_1);
		        
		        JButton btnNewButton_2 = new JButton("確定訂購");
		        btnNewButton_2.addMouseListener(new MouseAdapter() {
		        	@Override
		        	public void mouseClicked(MouseEvent e) {
		        		
		        		msg.setText("系統待更新, 抱歉, 暫時無法購買"); 
		        	}
		        });
		        btnNewButton_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		        btnNewButton_2.setBounds(431, 232, 105, 23);
		        panel.add(btnNewButton_2);
		        
				
				JButton btnNewButton = new JButton("我的賣場");
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						ProductPageUI productpageUI=new ProductPageUI();
						productpageUI.setVisible(true);
						dispose();
					}
				});
				btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 16));
				btnNewButton.setBounds(444, 10, 105, 24);
				panel.add(btnNewButton); 
	     
	}
}
