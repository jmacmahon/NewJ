package phm1.NewJ;

import java.awt.*;

import java.util.Vector;

public class VectorOfBoxes {
	//store name of class
	//more text - eg methods and attributes - don't worry about what is in the text box - can improve later if there is time
	private Vector<ClassBox> boxes;
	
	VectorOfBoxes() {
		boxes = new Vector<ClassBox>();
	}
	
	public void addBox(ClassBox c) {
		boxes.add(c);
	}
	
	public int getNoBoxes() {
		return boxes.size();
	}
	
	public void drawAll(Graphics g) {
		for (ClassBox c : boxes) {
			c.draw(g);
		}
	}
	
	public void deleteAll() {
		boxes.clear();
	}
	
	public ClassBox clickedInBox(int x, int y) {
		//finds the box that has been clicked on, if any - p
		int xPlusA;
		int yPlusB;
		for (ClassBox c : boxes){ //loop through boxes - p

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
