package phm1.NewJ;

public abstract class NJAbstractProperty extends NJObject {
	
	private NJAccessModifier accessModifier;

	public NJAccessModifier getAccessModifier() {
		return accessModifier;
	}

	public void setAccessModifier(NJAccessModifier accessModifier) {
		this.accessModifier = accessModifier;
	}
	
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
		out += "";
		out += this.getName();
		return out;
	}
}
