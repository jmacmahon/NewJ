package phm1.NewJ;
import javax.swing.*;

import java.awt.*;

public class DiagramPanel extends JPanel{
	private GUI gui;
	private NJClass selected;
	private boolean inheriting;
	private NJInheritance tempInheritance;
	
	public boolean getInheriting(){
		return inheriting;
	}
	
	public void setInheriting(boolean inheriting){
		this.inheriting = inheriting;
		if(inheriting)
			standByForInheritance();
		/*else
			dropInheritance();*/
	}
	
	public NJClass getSelected() {
		return selected;
	}

	public void setSelected(NJClass selected) {
		this.selected = selected;
	}
	
	public NJInheritance getTempInheritance() {
		return tempInheritance;
	}

	public DiagramPanel(GUI g){
		this.gui = g;
		this.inheriting = false;
		this.setLayout(new BorderLayout());	
		this.setBackground(Color.WHITE);
	}
	
	public void standByForInheritance(){
		if(selected != null){
			tempInheritance = new NJInheritance();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		gui.drawAll(g);
		/*if(tempInheritance != null)
			tempInheritance.draw(g, );*/
	}
	
	private void addInheritance(NJClass a, NJClass b) {
		a.setInherits(new NJInheritance(b));
	}
	
	public NJClass findNearestClass(int x, int y) {
		NJClass c;
		//calls a method in vector of boxes to find which box the mouse is inside, then returns that box
		c = gui.clickedInBox(x, y);
		repaint();
		return c;
	}
	
	public void unselectAll() {
		gui.unselectAll();
	}
	
	
}
