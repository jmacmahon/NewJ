package phm1.NewJ;

import java.awt.*;

import java.util.Vector;

public class VectorOfBoxes {
	//store x and y co-ordinates of boxes
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
		ClassBox currentClassBox;

		for(int i=0; i < boxes.size(); i++) {
			currentClassBox = (ClassBox)(boxes.get(i));
			currentClassBox.draw(g);
		}
	}
	
	public void deleteAll() {
		for(int i=0; i < boxes.size(); i++){
			boxes.remove(i); //still doesn't work
		}
	}
	
	public ClassBox findNearestBox(int x, int y){
		ClassBox c;
		double minDist = Double.MAX_VALUE;
		int minDistIndex = -1;

		for(int i=0; i < boxes.size(); i++) {
			c = (ClassBox)(boxes.get(i));
			if(c.distanceTo(x,y) < minDist) {
				minDist = c.distanceTo(x,y);
				minDistIndex = i;
			}
		}
		if((minDistIndex >= 0) && (minDist < 30)) {
			return boxes.get(minDistIndex);
			
		}
		else {
			return null;
		}
	}
}
