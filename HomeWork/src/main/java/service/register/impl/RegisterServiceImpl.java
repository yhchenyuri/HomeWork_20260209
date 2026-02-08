package service.register.impl;

import java.util.List;

import dao.register.impl.RegisterDaoImpl;
import model.Register;
import service.register.RegisterService;


public class RegisterServiceImpl implements RegisterService{

	public static void main(String[] args) {
		//System.out.println (new RegisterServiceImpl().addRegister(new Register("service","09123","123","taipei","123","service")));

	}
	RegisterDaoImpl registerdaoimpl=new RegisterDaoImpl();
	
	@Override
	public boolean addRegister(Register register) {
		// TODO Auto-generated method stub
		if(register.getMember().isEmpty()||register.getTel().isEmpty()||register.getAccount().isEmpty()||register.getPassword().isEmpty()||register.getPasswordcheck().isEmpty()) 
		{ 
			return false;			
			}
		//if(Password != null && Password.equals(Passwordcheck))			
		return registerdaoimpl.addbooleanRegister(register);
		
	}

	@Override
	public Register read_find_by_account_password(String account, String password) {
		// TODO Auto-generated method stub
			Register register=null;
			List<Register> list=registerdaoimpl. select_by_account_password(account, password);
			if(list.size()!=0)
			{
				register=list.get(0);
			}			
			return register;		
	}
	
	
	
	
	
	
}
