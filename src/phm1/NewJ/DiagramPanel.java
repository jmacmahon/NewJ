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
	public void addClass(int x, int y) {
		vOfB.addBox(new ClassBox(x, y));
		repaint();
	}
	
	public void deleteAll() {
		vOfB.deleteAll();
		repaint(); //TODO this doesn't work yet
	}
	
	public ClassBox findNearestClass(int x, int y) {
		ClassBox c = vOfB.findNearestBox(x, y);
		repaint();
		return c;
	}
	
	
}
