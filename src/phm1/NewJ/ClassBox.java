package phm1.NewJ;
import java.awt.*;

import javax.swing.*;

public class ClassBox extends JComponent {
	
	private int x;
	private int y;
	private int a;
	private int b;
	
	public ClassBox(int x, int y, int a, int b) {
		this.x=x;
		this.y=y;
		this.a=a;
		this.b=b;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.ORANGE);
		g.drawRect(this.x, this.y, this.a, this.b);
		g.fillRect(this.x, this.y, this.a, this.b);
	}
	
	public int distanceTo(int x, int y) {
		return (Math.abs(this.x-x) + Math.abs(this.y-y));
	}
	
	public void update(int x, int y){
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
