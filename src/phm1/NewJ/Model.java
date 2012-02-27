package phm1.NewJ;

import java.beans.*;
import java.io.*;
import java.util.*;

public class Model {
	private ArrayList<NJClass> classes;

	public ArrayList<NJClass> getClasses() {
		return classes;
	}

	public void setClasses(ArrayList<NJClass> classes) {
		this.classes = classes;
	}
	
	public void addClass(NJClass c){
		classes.add(c);
	}
	
	public void save(String filename) throws FileNotFoundException, IOException {
		FileOutputStream f = new FileOutputStream(filename);
		XMLEncoder xe = new XMLEncoder(f);
		xe.writeObject(this.classes);
		xe.close();
		f.close();
	}
	
	public void load(String filename) throws FileNotFoundException, IOException {
		FileInputStream f = new FileInputStream(filename);
		XMLDecoder xd = new XMLDecoder(f);
		this.classes = (ArrayList<NJClass>)xd.readObject();
		xd.close();
		f.close();
	}
}
