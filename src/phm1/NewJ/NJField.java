package phm1.NewJ;

public class NJField extends NJAbstractProperty {
	NJField(String name, String type, NJAccessModifier accessModifier){
		this.setName(name);
		this.setType(type);
		this.setAccessModifier(accessModifier);
	}
	
	public NJField(){}
}
