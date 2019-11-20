package Objetos;

public class Employee {
	// Attributes of the class
	private String Name;
	private String ID;
	private String Password;
	
	public Employee(String Name, String ID, String Password) {
		this.Name= Name;
		this.ID= ID;
		this.Password= Password;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	

}
