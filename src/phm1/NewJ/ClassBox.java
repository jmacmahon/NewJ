package phm1.NewJ;
import java.awt.*;

import javax.swing.*;

public class ClassBox extends JComponent {
	
	private double x;
	private double y;
	
	public ClassBox(double x, double y) {
		this.x=x;
		this.y=y;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.ORANGE);
		g.drawRect(10, 10, 100, 100);
		g.fillRect(10, 10, 100, 100);
	}
	
	public double distanceTo(double x, double y) {
		return (Math.abs(this.x-x) + Math.abs(this.y-y));
	}

}
