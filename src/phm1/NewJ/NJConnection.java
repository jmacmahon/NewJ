package phm1.NewJ;

import java.awt.Graphics;

import javax.swing.JComponent;

public class NJConnection extends JComponent {
	NJClass to;
	ConnectionType c;

	public NJClass getTo() {
		return to;
	}

	public void setTo(NJClass to) {
		this.to = to;
	}

	public ConnectionType getC() {
		return c;
	}

	public void setC(ConnectionType c) {
		this.c = c;
	}
	public NJConnection(){}

	public NJConnection(NJClass to, ConnectionType c) {
		this.to = to;
		this.c=c;
	}
	
	public void draw (Graphics g, NJClass from) {
		g.drawLine(from.getX(), from.getY(), to.getX(), to.getY()); //TODO change to stick to better parts of the class
	}

}
