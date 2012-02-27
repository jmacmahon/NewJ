package phm1.NewJ;

public abstract class NJAbstractProperty extends NJObject {
	
	private NJAccessModifier accessModifier;

	public NJAccessModifier getAccessModifier() {
		return accessModifier;
	}

	public void setAccessModifier(NJAccessModifier accessModifier) {
		this.accessModifier = accessModifier;
	}
}
