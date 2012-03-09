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
		save(new FileOutputStream(filename));
	}
	
	public void save(File file) throws IOException {
		save(new FileOutputStream(file));
	}
	
	public void save(FileOutputStream f) throws IOException {
		XMLEncoder xe = new XMLEncoder(new BufferedOutputStream(f));
		xe.writeObject(this.classes);
		xe.close();
	}
	
	public void load(String filename) throws FileNotFoundException, IOException {
		load(new FileInputStream(filename));
	}
	
	public void load(File file) throws IOException {
		load(new FileInputStream(file));
	}
	
	public void load(FileInputStream f) throws IOException {
		XMLDecoder xd = new XMLDecoder(f);
		this.classes = (ArrayList<NJClass>)xd.readObject();
		xd.close();
		f.close();
	}
	
	public void export(File file) throws IOException {
		for(NJClass c : classes){
			c.export(file);
		}
	}
}
