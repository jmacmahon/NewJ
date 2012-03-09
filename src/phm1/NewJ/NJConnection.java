package phm1.NewJ;

import java.awt.Graphics;

import javax.swing.JComponent;

public abstract class NJConnection extends JComponent {
	private NJClass to;
	private int xTo;
	private int yTo;
	private int xFrom;
	private int yFrom;

	public NJClass getTo() {
		return to;
	}

	public void setTo(NJClass to) {
		this.to = to;
	}

	public int getXTo() {
		return xTo;
	}

	public void setXTo(int xTo) {
		this.xTo = xTo;
	}

	public int getYTo() {
		return yTo;
	}

	public void setYTo(int yTo) {
		this.yTo = yTo;
	}

	public int getXFrom() {
		return xFrom;
	}

	public void setXFrom(int xFrom) {
		this.xFrom = xFrom;
	}

	public int getYFrom() {
		return yFrom;
	}

	public void setYFrom(int yFrom) {
		this.yFrom = yFrom;
	}

	public NJConnection(){}

	public NJConnection(NJClass to) {
		this.to = to;
	}
	
	public void draw (Graphics g, NJClass from, boolean horizontal) {
		if(to != null){
			xTo = to.getX() + (to.getA() / 2);
			yTo = to.getY() + (to.getB() / 2);
		}
		xFrom = from.getX() + (from.getA() / 2);
		yFrom = from.getY() + (from.getB() / 2);
		if(horizontal){
			g.drawLine(xFrom, yFrom, xTo, yFrom);
			g.drawLine(xTo, yFrom, xTo, yTo);
		} else {
			g.drawLine(xFrom, yFrom, xFrom, yTo);
			g.drawLine(xFrom, yTo, xTo, yTo);
		}
	}

	public void setXYto(int x, int y){
		this.xTo = x;
		this.yTo = y;
	}
}
