package phm1.NewJ;
import javax.swing.*;
import java.awt.*;

public class DiagramPanel extends JPanel{
	private VectorOfBoxes vOfB;
	
	public DiagramPanel(){
		vOfB=new VectorOfBoxes();
		this.setLayout(new BorderLayout());	
		this.setBackground(Color.WHITE);
	
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		vOfB.drawAll(g);
	}
	public void addClass(int x, int y, int a, int b) {
		vOfB.addBox(new ClassBox(x, y, a, b));
		repaint();
	}
	
	public void deleteAll() {
		vOfB.deleteAll();
		repaint(); //TODO this doesn't work yet
	}
	
	public ClassBox findNearestClass(int x, int y) {
		ClassBox c;
		c = vOfB.clickedInBox(x, y);
		repaint();
		return c;
	}
	
	
}
