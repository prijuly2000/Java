package sun.krd.polling;

import java.util.ArrayList;

public class LoginValidateBean {
	private String username;
	private String password;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginValidateBean() {
		super();
	}
	
	public boolean getValidation(){
		boolean result=false;
		LoginDao dao= new LoginDao();
		result = dao.validate(username,password);
		System.out.println(result);
		return result;
	}
	
}
