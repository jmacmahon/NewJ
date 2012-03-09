package phm1.NewJ;

/**
 * Represents an argument to a method of a class in NewJ: has a name and a type
 * @author n3hima
 */
public class NJArgument extends NJObject {
	NJArgument(String name, String type){
		this.setName(name);
		this.setType(type);
	}
	public NJArgument(){}
	
	public String jRepresent(){
		return this.getType() + " " + this.getName();
	}
}
