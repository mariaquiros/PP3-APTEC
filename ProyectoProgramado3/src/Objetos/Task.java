package Objetos;

public class Task {
	// Attributes of the class
	private String Type;
	private String ID;
	private String Description;
	private String Effort;
	private String Responsible;
	
	public Task(String Type, String ID, String Description, String Effort, String Responsible) {
		this.Type= Type;
		this.ID= ID;
		this.Description= Description;
		this.Effort= Effort;
		this.Responsible= Responsible;
	}
	
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getEffort() {
		return Effort;
	}
	public void setEffort(String effort) {
		Effort = effort;
	}
	public String getResponsible() {
		return Responsible;
	}
	public void setResponsible(String responsible) {
		Responsible = responsible;
	}
	
	
	


}
