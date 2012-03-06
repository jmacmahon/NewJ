package phm1.NewJ;

import java.util.ArrayList;

public class NJMethod extends NJAbstractProperty {
	private ArrayList<NJArgument> arguments;

	public ArrayList<NJArgument> getArguments() {
		return arguments;
	}

	public void setArguments(ArrayList<NJArgument> arguments) {
		this.arguments = arguments;
	}
	
	NJMethod(String name, String type, NJAccessModifier accessModifier){
		this.setName(name);
		this.setType(type);
		this.setAccessModifier(accessModifier);
		this.setArguments(new ArrayList<NJArgument>());
	}
	public NJMethod(){}
	
	public void addArgument(NJArgument a){
		arguments.add(a);
	}
}
