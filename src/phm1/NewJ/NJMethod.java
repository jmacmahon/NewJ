package phm1.NewJ;

import java.util.ArrayList;

/**
 * Represents a method of a class within NewJ: has a name, a type, an access modifier and an ArrayList of arguments
 * @author n3hima
 */
public class NJMethod extends NJAbstractProperty {
	private ArrayList<NJArgument> arguments;

	public ArrayList<NJArgument> getArguments() {
		return arguments;
	}

	public void setArguments(ArrayList<NJArgument> arguments) {
		this.arguments = arguments;
	}
	
	/**
	 * Construct a new NJMethod with no arguments
	 * @param name
	 * @param type
	 * @param accessModifier
	 */
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
	
	/**
	 * Adds an argument to the method
	 * @param a The argument to add
	 */
	public void addArgument(NJArgument a){
		arguments.add(a);
	}
	
	/**
	 * Removes an argument from thie method
	 * @param a The argument to be removed
	 */
	public void deleteArgument(NJArgument a){
		arguments.remove(a);
	}
	
	public String jRepresent(){
		String out = super.jRepresent() + " ";
		if(arguments.size() == 0){
			out += "(";
		} else {
			for(NJArgument a : arguments){
				if(a == arguments.get(0))
					out += "(";
				else
					out += ", ";
				out += a.jRepresent();
			}
		}
		out += ") { }";
		return out;
	}
}
