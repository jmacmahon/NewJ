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
	
	public String getDisplayString(){
		String out = super.getDisplayString();
		if(arguments.size() == 0){
			out += "(";
		} else {
			for(NJArgument a : arguments){
				if(a == arguments.get(0)){
					out += "(";
				} else {
					out += ", ";
				}
				out += a.getName();
				out += " : ";
				out += a.getType();
			}
		}
		out += ") : ";
		out += this.getType();
		return out;
	}
	
	public void addArgument(NJArgument a){
		arguments.add(a);
	}
	
	public void deleteArgument(NJArgument a){
		arguments.remove(a);
	}
}
