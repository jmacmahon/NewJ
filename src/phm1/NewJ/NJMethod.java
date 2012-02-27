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
	
	NJMethod(String name, String type, NJAccessModifier accessModifier, ArrayList<NJArgument> arguments){
		this.setName(name);
		this.setType(type);
		this.setAccessModifier(accessModifier);
		this.setArguments(arguments);
	}
	public NJMethod(){}
}
