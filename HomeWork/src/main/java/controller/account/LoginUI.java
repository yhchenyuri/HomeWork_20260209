package controller.account;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Register;
import service.register.impl.RegisterServiceImpl;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField login_account;
	private JPasswordField login_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 307, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 272, 225);
		contentPane.add(panel);
		panel.setLayout(null);		
	
		login_account = new JTextField();
		login_account.setForeground(new Color(192, 192, 192));
		login_account.setText("(default)(1234)");
		login_account.setBounds(104, 58, 96, 21);
		panel.add(login_account);
		login_account.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("帳號");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		lblNewLabel.setBounds(61, 59, 46, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密碼");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(61, 108, 46, 15);
		panel.add(lblNewLabel_1);
		
		login_password = new JPasswordField();
		login_password.setForeground(new Color(192, 192, 192));
		login_password.setBounds(104, 105, 96, 21);
		panel.add(login_password);
		
		JLabel lblNewLabel_2 = new JLabel("Your Turn to Use");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(51, 10, 169, 31);
		panel.add(lblNewLabel_2);				

		
		/************************events************************/

		RegisterServiceImpl registerserviceimpl=new RegisterServiceImpl();
		
		JButton btnNewButton_1 = new JButton("會員登入");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String Account=login_account.getText();
				String Password=login_password.getText();
				
				Register register=registerserviceimpl.read_find_by_account_password(Account, Password);
				
				if(register!=null)
				{
				MarketSelectUI marketselectUI=new MarketSelectUI();
				marketselectUI.setVisible(true);
				dispose();}
			}
			
				
			/*	
				if(Account.equals("aaa")&&Password.equals("1234"))
				{
					CartUI cart=new CartUI();
					cart.setVisible(true);
					dispose();
				}
				else
				{
					System.out.println("預設帳號: aaa  預設密碼:1234");
				}
			*/
				
		
		});
		btnNewButton_1.setForeground(Color.GRAY);
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(10, 157, 122, 31);
		panel.add(btnNewButton_1);
		
		
		JButton btnNewButton = new JButton("會員註冊");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegisterUI register=new RegisterUI();
				register.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setForeground(new Color(128, 128, 128));
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton.setBounds(145, 157, 116, 31);
		panel.add(btnNewButton);
		
		JLabel Timer = new JLabel("");
		Timer.setBounds(0, 210, 272, 15);
		panel.add(Timer);
		
		Timer timer = new Timer(1000, new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		        Timer.setText("Current Time " + time);
		    }
		});
		timer.start();		

	}
}
