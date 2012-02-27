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
		ClassBox currentClassBox;

		for(int i=0; i < boxes.size(); i++) {
			currentClassBox = (ClassBox)(boxes.get(i));
			currentClassBox.draw(g);
		}
	}
	
	public void deleteAll() {
		for(int i=0; i < boxes.size(); i++){
			boxes.remove(i); //still doesn't work - p
		}
	}
	
	public ClassBox clickedInBox(int x, int y) {
		//finds the box that has been clicked on, if any - p
		int xPlusA;
		int yPlusB;
		ClassBox c;
		int index = -1;
		for (int i = 0; i < boxes.size(); i++){ //loop through boxes - p
			c= boxes.get(i);

			xPlusA = c.getX()+c.getA();
			yPlusB = c.getY()+c.getB();
			
			if ((c.getX() < x) && (x < xPlusA) && (c.getY() < y) && (y < yPlusB)) {
				//sets index to the position of the box in the vector if one is clicked on - p
				index = i;				
			}
		}
		
		//return a box if there is one, or null if clicked in blank space - p
		if ( index >=0) {
			return boxes.get(index);
		}
		else {
			return null;
		}		
	}
	
	
	
/*	public ClassBox findNearestBox(int x, int y){
		ClassBox c;
		int minDist = 2;
		int minDistIndex = -1;

		for(int i=0; i < boxes.size(); i++) {
			c = (boxes.get(i));
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
	*/
}
