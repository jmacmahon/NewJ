package phm1.NewJ;

/**
 * Represents a field of a class within NewJ: it has a type, a name and an access modifier
 * @author n3hima
 *
 */
public class NJField extends NJAbstractProperty {
	public NJField(String name, String type, NJAccessModifier accessModifier){
		this.setName(name);
		this.setType(type);
		this.setAccessModifier(accessModifier);
	}
	
	public String getDisplayString(){
		String out = super.getDisplayString();
		out += " : ";
		out += this.getType();
		return out;
	}
	
	public NJField(){}
	
	public String jRepresent(){
		return super.jRepresent() + ";";
	}
}
