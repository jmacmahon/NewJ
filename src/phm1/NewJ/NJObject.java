package phm1.NewJ;

/**
 * Describes an object within NewJ: it has a name and a type.
 * @author n3hima
 *
 */
public abstract class NJObject {
	private String name;
	private String type;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Represents this object as interpretable Java code. This is used when exporting to .java files.
	 * @return Java code
	 */
	public abstract String jRepresent();
}
