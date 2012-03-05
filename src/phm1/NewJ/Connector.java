package phm1.NewJ;

import java.awt.Graphics;

import javax.swing.JComponent;

public class Connector extends JComponent {
	NJClass a, b;
	ConnectionType c;
	public Connector(NJClass a, NJClass b, ConnectionType c) {
		this.a=a;
		this.b=b;
		this.c=c;
	}
	
	public void draw (Graphics g) {
		g.drawLine(a.getX(), a.getY(), b.getX(), b.getY()); //TODO change to stick to better parts of the class
	}

}
