package phm1.NewJ;

import java.util.ArrayList;

public class NJClass {
	private String name;
	private ArrayList<NJField> fields;
	private ArrayList<NJMethod> methods;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<NJField> getFields() {
		return fields;
	}
	public void setFields(ArrayList<NJField> fields) {
		this.fields = fields;
	}
	public ArrayList<NJMethod> getMethods() {
		return methods;
	}
	public void setMethods(ArrayList<NJMethod> methods) {
		this.methods = methods;
	}
	
	NJClass(String name, ArrayList<NJField> fields, ArrayList<NJMethod> methods){
		this.setName(name);
		this.setFields(fields);
		this.setMethods(methods);
	}
	
	public NJClass(){}
}
