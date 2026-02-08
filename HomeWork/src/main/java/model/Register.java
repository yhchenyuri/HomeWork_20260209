package model;

public class Register {
	private int ID;	
	private String member;
	private String tel;
	private String password;
	private String address;
	private String passwordcheck;
	private String account;
		
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Register(String member, String tel, String password, String address,String passwordcheck,String account) {
		super();
		this.member = member;
		this.tel = tel;
		this.password = password;
		this.address = address;
		this.passwordcheck=passwordcheck;
		this.account=account;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPasswordcheck() {
		return passwordcheck;
	}
	public void setPasswordcheck(String passwordcheck) {
		this.passwordcheck = passwordcheck;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	
	
}
