package controller.account;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Register;
import service.register.impl.RegisterServiceImpl;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class RegisterUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField member;
	private JTextField tel;
	private JTextField account;
	private JPasswordField password;
	private JPasswordField passwordcheck;
	private JTextField address;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterUI frame = new RegisterUI();
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
	public RegisterUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 414, 248);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("會員資料填寫");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 0, 404, 29);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 39, 46, 15);
		panel.add(lblNewLabel_1);
		
		member = new JTextField();
		member.setBounds(87, 38, 96, 21);
		panel.add(member);
		member.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("電話");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 64, 46, 15);
		panel.add(lblNewLabel_2);
		
		tel = new JTextField();
		tel.setBounds(87, 63, 96, 21);
		panel.add(tel);
		tel.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("地址");
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 164, 46, 15);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("密碼");
		lblNewLabel_4.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(10, 114, 46, 15);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("重輸密碼");
		lblNewLabel_5.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(10, 139, 96, 15);
		panel.add(lblNewLabel_5);
		
		JLabel Label = new JLabel("帳號名稱");
		Label.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		Label.setBounds(10, 89, 65, 15);
		panel.add(Label);
		
		account = new JTextField();
		account.setColumns(10);
		account.setBounds(87, 88, 96, 21);
		panel.add(account);
		
		password = new JPasswordField();
		password.setBounds(87, 113, 96, 21);
		panel.add(password);
		
		passwordcheck = new JPasswordField();
		passwordcheck.setBounds(87, 138, 96, 21);
		panel.add(passwordcheck);
		
		JTextArea failmsg = new JTextArea();
		failmsg.setBackground(new Color(255, 255, 255));
		failmsg.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		failmsg.setBounds(210, 39, 194, 45);
		panel.add(failmsg);
		
		JTextArea failmsg_1 = new JTextArea();
		failmsg_1.setFont(new Font("微軟正黑體", Font.PLAIN, 10));
		failmsg_1.setBackground(new Color(255, 255, 255));
		failmsg_1.setBounds(210, 138, 194, 21);
		panel.add(failmsg_1);
		
		address = new JTextField();
		address.setBounds(87, 163, 317, 43);
		panel.add(address);
		address.setColumns(10);
		
		
		/**************events****************/
		
		JButton btnNewButton = new JButton("確認註冊");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				String getmember=member.getText();
				String gettel=tel.getText();
				String getpassword=password.getText();
				String getaddress=address.getText();
				String getpasswordcheck=passwordcheck.getText();
				String getaccount=account.getText();
				
				Register getregister=new Register(getmember, gettel, getpassword, getaddress,getpasswordcheck,getaccount);
				new RegisterServiceImpl().addRegister(getregister);
				if(getmember.isEmpty()||gettel.isEmpty()||getaccount.isEmpty()||getpassword.isEmpty()||getaddress.isEmpty()) 
				{ failmsg.setText("姓名,電話,帳號名稱,密碼,地址不能為空"); 
				return;} 				
				if(getpassword != null && getpassword.equals(getpasswordcheck))
				{			
					LoginUI log=new LoginUI();
						log.setVisible(true);
						dispose();
				}
				else
				{
					failmsg_1.setText("密碼不一致, 請重新輸入.");
				}			
				
			}
		});
		btnNewButton.setBounds(87, 216, 96, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("放棄註冊");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(308, 216, 96, 23);
		panel.add(btnNewButton_1);
	
		
		
		}
}	
		
		
		
		

