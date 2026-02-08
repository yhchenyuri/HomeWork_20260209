package dao.register.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.register.RegisterDao;
import model.Register;
import util.Tool;

public class RegisterDaoImpl implements RegisterDao{

	public static void main(String[] args) {
		//	new RegisterDaoImpl().addRegister(new Register("dao","09123","123","taipei","123","oooo"));

	}
	Connection conn=Tool.getDb();
	
	@Override
	public void addRegister(Register register) {
		// TODO Auto-generated method stub
		String sql="insert into register(member,tel,password,address,passwordcheck,account) values(?,?,?,?,?,?)";
		try {
			PreparedStatement prepareregister=conn.prepareStatement(sql);
			
			prepareregister.setString(1, register.getMember());
			prepareregister.setString(2,register.getTel());
			prepareregister.setString(3,register.getPassword());
			prepareregister.setString(4, register.getAddress());
			prepareregister.setString(5, register.getPasswordcheck());
			prepareregister.setString(6, register.getAccount());
			
			prepareregister.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Register> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Register> select_by_account_password(String account, String password) {
		// TODO Auto-generated method stub
		String sql=" select * from register where account=? and password=?";
		List<Register> list_by_account_password=new ArrayList<>();
		try {
			PreparedStatement preparebyAccountPassword=conn.prepareStatement(sql);
			preparebyAccountPassword.setString(1, account);
			preparebyAccountPassword.setString(2,password);					
			ResultSet result_account_password=preparebyAccountPassword.executeQuery();
			
			if(result_account_password.next())
			{
					Register register=new Register();
					//productpage.setId(resultbyID.getInt("ID"));
					register.setID(result_account_password.getInt("ID"));
					register.setAccount(result_account_password.getString("account"));
					register.setMember(result_account_password.getString("member"));
					register.setTel(result_account_password.getString("tel"));
					register.setPassword(result_account_password.getString("password"));
					register.setPasswordcheck(result_account_password.getString("passwordcheck"));
					register.setAddress(result_account_password.getString("address"));
					list_by_account_password.add(register);				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list_by_account_password;
	}

	@Override
	public void updateRegister(Register register) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete_by_account(String account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addbooleanRegister(Register register) {
		// TODO Auto-generated method stub		
		String sql="insert into register(member,tel,password,address,passwordcheck,account) values(?,?,?,?,?,?)";
		try {
			PreparedStatement prepareregister=conn.prepareStatement(sql);
			
			prepareregister.setString(1, register.getMember());
			prepareregister.setString(2,register.getTel());
			prepareregister.setString(3,register.getPassword());
			prepareregister.setString(4, register.getAddress());
			prepareregister.setString(5, register.getPasswordcheck());
			prepareregister.setString(6, register.getAccount());			
			return prepareregister.executeUpdate()>0;	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("失敗", e);
			
		}
	}


}
