package phm1.NewJ;
import javax.swing.*;
import java.awt.*;

public class DiagramPanel extends JPanel{
	private VectorOfBoxes vOfB;
	
	public DiagramPanel(){
		vOfB=new VectorOfBoxes();
		//the problem here is that creating the vector of boxes inside the diagram panel means some of the other stuff can't see it
		
		this.setLayout(new BorderLayout());	
		this.setBackground(Color.WHITE);
	
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		vOfB.drawAll(g);
	}
	public void addClass(int x, int y, int a, int b) {
		//add a class box to vector of boxes with specified position and dimensions
		vOfB.addBox(new ClassBox(x, y, a, b));
		repaint();
	}
	
	public void deleteAll() {
		vOfB.deleteAll();
		repaint();
	}
	
	public ClassBox findNearestClass(int x, int y) {
		ClassBox c;
		//calls a method in vector of boxes to find which box the mouse is inside, then returns that box
		c = vOfB.clickedInBox(x, y);
		repaint();
		return c;
	}
	
	
}
