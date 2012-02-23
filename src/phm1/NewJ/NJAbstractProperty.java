package phm1.NewJ;

public abstract class NJAbstractProperty extends NJObject {
	public static final int PUBLIC = 0;
	public static final int PRIVATE = 1;
	public static final int PROTECTED = 2;
	
	private int accessModifier;

	public int getAccessModifier() {
		return accessModifier;
	}

	public void setAccessModifier(int accessModifier) {
		this.accessModifier = accessModifier;
	}
}
