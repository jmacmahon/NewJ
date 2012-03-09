package phm1.NewJ;

import java.beans.*;
import java.io.*;
import java.util.*;

/**
 * The Model singleton. Keeps track of all the classes and handles saving, loading and exporting.
 * @author n3hima
 */
public class Model {
	private ArrayList<NJClass> classes;
	private GUI gui;

	public ArrayList<NJClass> getClasses() {
		return classes;
	}

	public void setClasses(ArrayList<NJClass> classes) {
		this.classes = classes;
	}
	
	/**
	 * Creates an empty model
	 */
	public Model(){
		setClasses(new ArrayList<NJClass>());
	}
	
	/**
	 * Gets how many classes we are storing
	 * @return The number of classes we are storing
	 */
	public int getClassCount(){
		return classes.size();
	}
	
	/**
	 * Adds a new class to the list
	 * @param c The class to be added
	 */
	public void addClass(NJClass c){
		classes.add(c);
	}
	
	/**
	 * Finds a class based on comparing its name to a String
	 * @param name The string to be compared to
	 * @return The class whose name matches, or null
	 */
	public NJClass getClassByName(String name){
		for(NJClass c : classes){
			if(c.getName().equals(name))
				return c;
		}
		return null;
	}
	
	/**
	 * Removes a class from the list
	 * @param c The class to be removed
	 */
	public void removeClass(NJClass c){
		classes.remove(c);
	}
	
	/**
	 * Removes all classes from the list -- starts afresh
	 */
	public void clear(){
		classes.clear();
	}
	
	/**
	 * Saves the state to the passed filename
	 * @param filename The filename to be saved to
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void save(String filename) throws FileNotFoundException, IOException {
		save(new FileOutputStream(filename));
	}
	
	/**
	 * Saves the state to the passed File object
	 * @param file The File object to be saved to
	 * @throws IOException
	 */
	public void save(File file) throws IOException {
		save(new FileOutputStream(file));
	}
	
	/**
	 * Saves the state to the passed FileOutputStream object
	 * @param f The FileOutputStream object to be saved to
	 * @throws IOException
	 */
	public void save(FileOutputStream f) throws IOException {
		XMLEncoder xe = new XMLEncoder(new BufferedOutputStream(f));
		xe.writeObject(this.classes);
		xe.close();
	}
	
	/**
	 * Loads a state from the specified filename
	 * @param filename The specified filename
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void load(String filename) throws FileNotFoundException, IOException {
		load(new FileInputStream(filename));
	}
	
	/**
	 * Loads a state from the specified File object
	 * @param file The specified File object
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void load(File file) throws IOException {
		load(new FileInputStream(file));
	}
	
	/**
	 * Loads a state from the specified FileInputStream object
	 * @param f The specified FileInputStream object
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void load(FileInputStream f) throws IOException {
		XMLDecoder xd = new XMLDecoder(f);
		this.classes = (ArrayList<NJClass>)xd.readObject();
		xd.close();
		f.close();
	}
	
	/**
	 * Exports each class to a .java file in the directory specified
	 * @param file The specified directory
	 * @throws IOException
	 */
	public void export(File file) throws IOException {
		for(NJClass c : classes){
			c.export(file);
		}
	}
}
