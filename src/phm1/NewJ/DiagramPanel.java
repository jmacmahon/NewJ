package phm1.NewJ;
import javax.swing.*;

import java.awt.*;

public class DiagramPanel extends JPanel{
	private GUI gui;
	
	public DiagramPanel(GUI g){
		this.gui = g;
		this.setLayout(new BorderLayout());	
		this.setBackground(Color.WHITE);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		gui.drawAll(g);
	}
	
	public void addConnection(NJClass a, NJClass b, ConnectionType c) {
		a.addConnection(new NJConnection(b, c));
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
