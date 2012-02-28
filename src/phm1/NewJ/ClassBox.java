package phm1.NewJ;
import java.awt.*;

import javax.swing.*;

public class ClassBox extends JComponent {
	
	private int x;
	private int y;
	private int a;
	private int b;
	private NJClass c;
	
	public ClassBox(int x, int y, int a, int b, NJClass c) {
		this.x=x; //x position in diagram panel of top left corner of box
		this.y=y; //y position in diagram panel of top left corner of box
		this.a=a; //horizontal length of box
		this.b=b; //vertical height of box
		this.c = c; // The actual NJClass object that this ClassBox represents
	}
	
	public void draw(Graphics g){
		//draw the rectangle
		g.setColor(Color.ORANGE);
		g.drawRect(this.x, this.y, this.a, this.b);
		g.fillRect(this.x, this.y, this.a, this.b);
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
	//TODO fix this so it doesn't freak out
	public int getMX(int x) {
		int i = x - this.x;
		return i;
	}
	//TODO same as getMX
	public int getMY(int y) {
		int i = y - this.y;
		return i;
	}
	
	
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
