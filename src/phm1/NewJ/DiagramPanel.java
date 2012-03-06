package phm1.NewJ;
import javax.swing.*;

import java.awt.*;

public class DiagramPanel extends JPanel{
	private GUI vOfB;
	
	public DiagramPanel(Model m){
		vOfB=new GUI(m);
		this.setLayout(new BorderLayout());	
		this.setBackground(Color.WHITE);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		vOfB.drawAll(g);
	}
	public void addClass(NJClass c) {
		//add a class box to vector of boxes with specified position and dimensions
		vOfB.addBox(c);
		repaint();
	}
	
	public void addConnection(NJClass a, NJClass b, ConnectionType c) {
		a.addConnection(new NJConnection(b, c));
	}
	
	public NJClass findNearestClass(int x, int y) {
		NJClass c;
		//calls a method in vector of boxes to find which box the mouse is inside, then returns that box
		c = vOfB.clickedInBox(x, y);
		repaint();
		return c;
	}
	
	public void unselectAll() {
		vOfB.unselectAll();
	}
	
	
}
