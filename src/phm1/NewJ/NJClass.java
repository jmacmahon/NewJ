package phm1.NewJ;

import java.awt.*;
import java.io.*;
import java.util.*;

import javax.swing.JComponent;


// TODO Separate the JComponent-inheriting parts from the parts which store the actual class data, because mixing GUI and Model is a Bad Thing (tm)
public class NJClass extends JComponent{

	//non graphics variables
	private String name;
	private ArrayList<NJField> fields;
	private ArrayList<NJMethod> methods;
	private ArrayList<NJAggregation> aggregations;
	private NJInheritance inheritance;
	
	private transient NJAggregation tempAggregation;
	
	//graphics variables
	private int x;
	private int y;
	private int a;
	private int b;

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
	public ArrayList<NJAggregation> getAggregations() {
		return aggregations;
	}
	public void setAggregations(ArrayList<NJAggregation> aggregations) {
		this.aggregations = aggregations;
	}
	public NJInheritance getInheritance() {
		return inheritance;
	}
	public void setInheritance(NJInheritance inheritance) {
		this.inheritance = inheritance;
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
	
	public NJAggregation getTempAggregation() {
		return tempAggregation;
	}
	public void setTempAggregation(NJAggregation tempAggregation) {
		this.tempAggregation = tempAggregation;
	}
	NJClass(String name, int x, int y){
		this.setName(name);
		this.setFields(new ArrayList<NJField>());
		this.setMethods(new ArrayList<NJMethod>());

		this.x=x; //x position in diagram panel of top left corner of box
		this.y=y; //y position in diagram panel of top left corner of box
		
		this.aggregations = new ArrayList<NJAggregation>();
		this.inheritance = null;
	}

	public NJClass() {}

	public void addField(NJField f){
		this.fields.add(f);
	}
	
	public void deleteField(NJField f){
		this.fields.remove(f);
	}
	
	public void deleteMethod(NJMethod m){
		this.methods.remove(m);
	}
	
	public void addMethod(NJMethod m){
		this.methods.add(m);
	}
	
	public void addAggregation(NJAggregation a){
		this.aggregations.add(a);
	}
	
	public void deleteAggregation(NJAggregation a){
		this.aggregations.remove(a);
	}
	
	public void fixTempAggregation(){
		this.aggregations.add(this.tempAggregation);
		this.tempAggregation = null;
	}
	
	public void draw(Graphics g, boolean selected){
		Font font = new Font("Courier New", Font.PLAIN, 12);
		String max = "";
		String tmp;
		for(NJField f : fields){
			tmp = f.getDisplayString();
			if(tmp.length() > max.length())
				max = tmp;
		}
		for(NJMethod m : methods){
			tmp = m.getDisplayString();
			if(tmp.length() > max.length())
				max = tmp;
		}
		tmp = name;
		if(tmp.length() > max.length())
			max = tmp;
		
		FontMetrics metrics = g.getFontMetrics();
		int maxWidth = metrics.stringWidth(max);
		this.a = maxWidth + 10;
		this.b = 13*fields.size() + 13*methods.size() + 13 + 7;
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
		g.drawString(name, this.x+5, this.y+12);
		
		g.drawLine(this.x, this.y + 14, this.x + this.a, this.y + 14);
		NJField f;
		for(int i = 1; i <= fields.size(); i++){
			f = fields.get(i - 1);
			g.drawString(f.getDisplayString(), this.x + 5, this.y + 14 + 13*i);
		}
		g.drawLine(this.x, this.y + 17 + 13*fields.size(), this.x + this.a, this.y + 17 + 13*fields.size());
		NJMethod m;
		for(int i = 1; i <= methods.size(); i++){
			m = methods.get(i - 1);
			g.drawString(m.getDisplayString(), this.x + 5, this.y + 16 + 13*fields.size() + 13*i);
		}

	}
	
	public void drawConnections(Graphics g){
		for (NJAggregation c : aggregations){
			c.draw(g, this);
		}
		if(this.inheritance != null){
			this.inheritance.draw(g, this);
		}
		if(this.tempAggregation != null){
			this.tempAggregation.draw(g, this);
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
	
	public void export(File directoryHandler) throws IOException{
		// Exports the class into a .java file
		File javaFile = new File(directoryHandler, this.getName() + ".java");
		FileWriter fW = new FileWriter(javaFile);
		BufferedWriter bW = new BufferedWriter(fW);
		bW.write(this.jRepresent());
		bW.close();
	}
	
	public String jRepresent(){
		String out = "public class " + getName();
		if(this.inheritance != null){
			out += " extends " + this.inheritance.getTo().getName();
		}
		out += " {\n";
		for (NJField f : fields){
			out += "\t" + f.jRepresent() + "\n";
		}
		for (NJMethod m : methods){
			out += "\t" + m.jRepresent() + "\n";
		}
		out += "}\n";
		return out;
	}
}
