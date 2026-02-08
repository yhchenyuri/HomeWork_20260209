package controller.market;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.account.LoginUI;
import controller.account.MarketSelectUI;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ProductPageUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductPageUI frame = new ProductPageUI();
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
	public ProductPageUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 270, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 235, 203);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("我的賣場功能");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 10, 219, 40);
		panel.add(lblNewLabel);
		
		/**************events****************/
		JButton btnNewButton_2 = new JButton("回登入頁");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI loginUI=new LoginUI();
				loginUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton_2.setBounds(44, 126, 153, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("回平台選擇頁");
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MarketSelectUI marketselectUI = new MarketSelectUI();
				marketselectUI.setVisible(true);
				dispose();				
			}
		});
		btnNewButton_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton_2_1.setBounds(44, 159, 153, 23);
		panel.add(btnNewButton_2_1);
		
		
		JButton btnNewButton = new JButton("新增商品");
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddProductUI addproductUI=new AddProductUI();
				addproductUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(44, 60, 153, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("編輯修改商品資訊");
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EditUI editUI=new EditUI();
				editUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(44, 93, 153, 23);
		panel.add(btnNewButton_1);
		

	}

}
