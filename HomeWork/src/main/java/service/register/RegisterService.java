package service.register;

import model.Register;

public interface RegisterService {
	
	//create
		boolean addRegister(Register register);
		
	//read
		Register read_find_by_account_password(String account, String password);
		
	//update
		
	//delete	

}
