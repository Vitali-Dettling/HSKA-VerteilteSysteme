package hska.iwi.eShopMaster.model.database.dataobjects;


public class xRole implements java.io.Serializable {

	private int id;

	private String typ;

	private int level;

	
	
	public xRole() {
	}

	public xRole(String typ, int level) {
		this.typ = typ;
		this.level = level;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTyp() {
		return this.typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
