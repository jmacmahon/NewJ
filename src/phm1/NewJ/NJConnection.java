package phm1.NewJ;

import java.awt.Graphics;

import javax.swing.JComponent;

public abstract class NJConnection extends JComponent {
	NJClass to;

	public NJClass getTo() {
		return to;
	}

	public void setTo(NJClass to) {
		this.to = to;
	}
	
	public NJConnection(){}

	public NJConnection(NJClass to) {
		this.to = to;
	}
	
	public void draw (Graphics g, NJClass from) {
		g.drawLine(from.getX(), from.getY(), to.getX(), to.getY()); //TODO change to stick to better parts of the class
	}

}
