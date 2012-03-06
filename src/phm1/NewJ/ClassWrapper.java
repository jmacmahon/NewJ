package phm1.NewJ;

import java.awt.*;

import java.util.Vector;

public class ClassWrapper {
	// This really is a bit useless now but getting rid of it would break things, so I'll take the hacky approach now and clean up later :P - J
	Model m;
	
	ClassWrapper(Model m) {
		this.m = m;
	}
	
	public void addBox(NJClass c) {
		m.addClass(c);
	}
	
	/*public int getNoBoxes() {
		return boxes.size();
	}*/
	
	public void drawAll(Graphics g) {
		for (NJClass c : m.getClasses()) {
			c.draw(g);
			c.drawConnections(g);
		}
		/*for (NJConnection c : connections) {
			c.draw(g);
		}*/
	}
	
	public void deleteAll() {
		m.clear();
	}
	
	public void deleteSelected() {
		for(NJClass c : m.getClasses()){
			if(c.getSelected()){
				m.removeClass(c);
				return;
			}
		}
	}
	public void unselectAll() {
		for (NJClass c : m.getClasses()) {
			c.setSelected(false);
		}
	}
	
	public NJClass clickedInBox(int x, int y) {
		//finds the box that has been clicked on, if any - p
		int xPlusA;
		int yPlusB;
		for (NJClass c : m.getClasses()){ //loop through boxes - p

			xPlusA = c.getX()+c.getA();
			yPlusB = c.getY()+c.getB();
			
			if ((c.getX() < x) && (x < xPlusA) && (c.getY() < y) && (y < yPlusB)) {
				// We found it! Let's get outta here - J
				return c;
			}
		}
		// Just return null if we didn't return earlier - J
		return null;
	}
}
