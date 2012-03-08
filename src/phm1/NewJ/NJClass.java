package phm1.NewJ;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;


// TODO Separate the JComponent-inheriting parts from the parts which store the actual class data, because mixing GUI and Model is a Bad Thing (tm)
public class NJClass extends JComponent{

	//non graphics variables
	private String name;
	private ArrayList<NJField> fields;
	private ArrayList<NJMethod> methods;
	private ArrayList<NJConnection> aggregations;
	private NJInheritance inherits;
	
	//graphics variables
	private int x;
	private int y;
	private int a;
	private int b;
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
	public ArrayList<NJConnection> getAggregations() {
		return aggregations;
	}
	public void setConnections(ArrayList<NJConnection> aggregations) {
		this.aggregations = aggregations;
	}
	public NJInheritance getInherits() {
		return inherits;
	}
	public void setInherits(NJInheritance inherits) {
		this.inherits = inherits;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public char[] getNameChars() {
		return nameChars;
	}
	public void setNameChars(char[] nameChars) {
		this.nameChars = nameChars;
	}
	
	NJClass(String name, int x, int y, int a, int b){
		this.setName(name);
		this.setFields(new ArrayList<NJField>());
		this.setMethods(new ArrayList<NJMethod>());

		this.x=x; //x position in diagram panel of top left corner of box
		this.y=y; //y position in diagram panel of top left corner of box
		this.a=a; //horizontal length of box
		this.b=b; //vertical height of box
		
		this.aggregations = new ArrayList<NJConnection>();
		this.inherits = null;

		nameChars = new char[name.length()];
		for (int i=0; i< name.length(); i++) {
			nameChars[i]= name.charAt(i);
		}
	}

	public NJClass() {}

	public void addField(NJField f){
		this.fields.add(f);
	}
	
	public void addMethod(NJMethod m){
		this.methods.add(m);
	}
	
	public void draw(Graphics g, boolean selected){
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
		g.drawChars(nameChars, 0, name.length(), this.x+5, this.y+11);
		g.drawLine(this.x, this.y+12, this.x+this.a, this.y+12);
		g.drawLine(this.x, this.y+50, this.x+this.a, this.y+50);

	}
	
	public void drawConnections(Graphics g){
		for (NJConnection c : aggregations){
			c.draw(g, this);
		}
		if(this.inherits != null){
			this.inherits.draw(g, this);
		}
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
}
