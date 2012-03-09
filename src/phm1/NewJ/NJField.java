package phm1.NewJ;

public class NJField extends NJAbstractProperty {
	NJField(String name, String type, NJAccessModifier accessModifier){
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
