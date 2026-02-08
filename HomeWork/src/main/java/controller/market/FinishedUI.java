package controller.market;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.ProductPage;
import util.Tool;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.Font;

public class FinishedUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinishedUI frame = new FinishedUI();
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
	public FinishedUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 462, 267);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea finalshow = new JTextArea();
		finalshow.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		finalshow.setBackground(new Color(235, 235, 235));
		finalshow.setBounds(10, 10, 442, 206);
		panel.add(finalshow);
		
		//在final頁顯示產品需求內容
				ProductPage readproductpage=(ProductPage)Tool.readObjectFile("product");
				String productOutput="以下為新增的商品:"+"\n產品名"+readproductpage.getProductname()+"\n價格"+readproductpage.getPrice()
				+"\n數量"+readproductpage.getAmount()+"\n內容"+readproductpage.getContent();
				
				finalshow.setText(productOutput);
				
				
		/*************event*******************/
		
		JButton btnNewButton = new JButton("列印");
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					finalshow.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}
		});
		btnNewButton.setBounds(31, 226, 87, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("離開");
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(180, 226, 87, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("回商品頁");
		btnNewButton_2.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ProductPageUI productpageUI=new ProductPageUI();
				productpageUI.setVisible(true);
				dispose();
				}
		});
		btnNewButton_2.setBounds(331, 226, 87, 23);
		panel.add(btnNewButton_2);

	}

}
