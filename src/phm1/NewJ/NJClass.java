package phm1.NewJ;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class NJClass extends JComponent{
	
	//non graphics variables
	private String name;
	private ArrayList<NJField> fields;
	private ArrayList<NJMethod> methods;
	
	//graphics variables
	private int x;
	private int y;
	private int a;
	private int b;
	//private NJClass c; obselete  - p
	private boolean selected;
	private char[] nameChars;
	
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
	
	NJClass(String name, ArrayList<NJField> fields, ArrayList<NJMethod> methods, int x, int y, int a, int b){
		this.setName(name);
		this.setFields(fields);
		this.setMethods(methods);
		
		this.x=x; //x position in diagram panel of top left corner of box
		this.y=y; //y position in diagram panel of top left corner of box
		this.a=a; //horizontal length of box
		this.b=b; //vertical height of box
		//this.c = c; // The actual NJClass object that this ClassBox represents - obslete - p
		
		this.selected = false;
		nameChars = new char[name.length()];
		for (int i=0; i< name.length(); i++) {
			nameChars[i]= name.charAt(i);
		}
	}
	
	
	public NJClass() {}
	
	public boolean getSelected() {
		return selected;
	}
	
	public void setSelected(boolean a) {
		selected = a;
	}
	public void draw(Graphics g){
		//draw the rectangle
		
		if (selected){
			g.setColor(Color.ORANGE);	
		}
		else {
			g.setColor(Color.BLACK);
		}
		g.drawRect(this.x, this.y, this.a, this.b);
		g.setColor(Color.WHITE);
		g.fillRect(this.x+1, this.y+1, this.a-1, this.b-1);
		g.setColor(Color.BLACK);
		g.getFontMetrics(); //use this to find font height etc
		g.drawChars(nameChars, 0, name.length(), this.x, this.y);
		
		
	}
	
	public int distanceTo(int x, int y) {
		//work out the distance between the mouse and the top left corner of the box
		return (Math.abs(this.x-x) + Math.abs(this.y-y));
	}
	
	public void update(int x, int y){
		//update the position of the box as it is dragged
		this.x = x;
		this.y = y;
		repaint();
	}
//TODO write something so the box doesn't jump to the mouse when dragged
	
	
	//the below should be fairly obvious
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getA() {
		return this.a;
	}
	
	public int getB() {
		return this.b;
	}
	
}
