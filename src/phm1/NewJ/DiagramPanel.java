package phm1.NewJ;
import javax.swing.*;

import java.awt.*;

public class DiagramPanel extends JPanel{
	private ClassWrapper vOfB;
	
	public DiagramPanel(Model m){
		vOfB=new ClassWrapper(m);
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
	
	public void deleteAll() {
		vOfB.deleteAll();
		repaint();
	}
	
	public void deleteSelected() {
		vOfB.deleteSelected();
		repaint();
		//TODO also delete relevant connections
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
