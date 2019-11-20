package Objetos;

public class Resource {
	// Attributes of the class
	private String ID;
	private String Name;
	private String Type;
	private String Capacity;
	private String Quantity;
	private String Responsable;
	
	public Resource(String ID,String Name,String Type,String Capacity, String Quantity,String Responsable) {
		this.ID=ID;
		this.Name=Name;
		this.Type=Type;
		this.Capacity=Capacity;
		this.Quantity=Quantity;
		this.Responsable=Responsable;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getCapacity() {
		return Capacity;
	}

	public void setCapacity(String capacity) {
		Capacity = capacity;
	}

	public String getQuantity() {
		return Quantity;
	}

	public void setQuantity(String quantity) {
		Quantity = quantity;
	}

	public String getResponsable() {
		return Responsable;
	}

	public void setResponsable(String responsable) {
		Responsable = responsable;
	}

}
