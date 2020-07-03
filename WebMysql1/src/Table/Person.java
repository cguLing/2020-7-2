package Table;

public class Person {
	private String username;
    private String name;
    private String age;
    private String telenum;
    public String getUserName() { 
        return username;
    }
    public void setUserName(String username) {
        this.username = username;
    }
    public String getName() { 
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() { 
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getTelenum() { 
        return telenum;
    }
    public void setTelenum(String telenum) {
        this.telenum = telenum;
    }
    public void PersonShow(String username,String name,String age,String telenum) {
    	this.username=username;
    	this.name=name;
    	this.age=age;
    	this.telenum=telenum;
    }
}
