package source;

public class login {
	protected String id;
	protected String emailaddress;
	protected String password;
	protected String number;
	
	public login() {
		
	}
	
	public login(String id, String emailaddress, String password, String number) {
		super();
		this.id = id;
		this.emailaddress = emailaddress;
		this.password = password;
		this.number = number;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
