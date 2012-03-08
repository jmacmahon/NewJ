package phm1.NewJ;

import java.beans.*;
import java.io.*;
import java.util.*;

public class Model {
	private ArrayList<NJClass> classes;
	private GUI gui;

	public ArrayList<NJClass> getClasses() {
		return classes;
	}

	public void setClasses(ArrayList<NJClass> classes) {
		this.classes = classes;
	}
	
	Model(){
		setClasses(new ArrayList<NJClass>());
	}
	
	public int getClassCount(){
		return classes.size();
	}
	
	public void addClass(NJClass c){
		classes.add(c);
	}
	
	public NJClass getClassByName(String name){
		for(NJClass c : classes){
			if(c.getName().equals(name))
				return c;
		}
		return null;
	}
	
	public void removeClass(NJClass c){
		classes.remove(c);
	}
	
	public void clear(){
		classes.clear();
	}
	
	public void save(String filename) throws FileNotFoundException, IOException {
		XMLEncoder xe = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)));
		xe.writeObject(this.classes);
		xe.close();
	}
	
	public void load(String filename) throws FileNotFoundException, IOException {
		FileInputStream f = new FileInputStream(filename);
		XMLDecoder xd = new XMLDecoder(f);
		this.classes = (ArrayList<NJClass>)xd.readObject();
		xd.close();
		f.close();
	}
}
