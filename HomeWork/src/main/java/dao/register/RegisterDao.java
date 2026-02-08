package dao.register;

import java.util.List;

import model.Register;

public interface RegisterDao {
	//create
	void addRegister(Register register);
	boolean addbooleanRegister(Register register);	
	//(String member, String tel, String password, String address,String passwordcheck,String account) ;
	
	//read
	List<Register> selectAll();
	List<Register> select_by_account_password(String account, String password);
	
	//update
	void updateRegister(Register register);
	
	//delete
	void delete_by_account(String account);
	

}
