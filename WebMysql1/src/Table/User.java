package Table;

public class User {
	private String username;
    private String password;
    public String getUserName() { 
        return username;
    }
    public void setUserName(String username) {
        this.username = username;
    }
    public String getPassword() { 
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void UserShow(String username,String password) {
    	this.username=username;
    	this.password=password;
    }
}
