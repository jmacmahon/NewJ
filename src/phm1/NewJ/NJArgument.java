package phm1.NewJ;

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
