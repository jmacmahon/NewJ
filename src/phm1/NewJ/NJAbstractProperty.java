package phm1.NewJ;

/**
 * Describes a property of a class within NewJ: it is an NJObject with an access modifier.
 * @author n3hima
 *
 */
public abstract class NJAbstractProperty extends NJObject {
	
	private NJAccessModifier accessModifier;

	public NJAccessModifier getAccessModifier() {
		return accessModifier;
	}

	public void setAccessModifier(NJAccessModifier accessModifier) {
		this.accessModifier = accessModifier;
	}
	
	/**
	 * Gives a String representing this property in a class diagram
	 * @return String representation
	 */
	public String getDisplayString(){
		String out = "";
		switch(this.getAccessModifier()){
		case PUBLIC:
			out += "+";
			break;
		case PROTECTED:
			out += "#";
			break;
		case PRIVATE:
			out += "-";
			break;
		}
		out += this.getName();
		return out;
	}
	
	public String jRepresent(){
		String out = "";
		switch(this.getAccessModifier()){
		case PUBLIC:
			out += "public ";
			break;
		case PROTECTED:
			out += "protected ";
			break;
		case PRIVATE:
			out += "private ";
			break;
		}
		out += this.getType() + " ";
		out += this.getName();
		return out;
	}
}
