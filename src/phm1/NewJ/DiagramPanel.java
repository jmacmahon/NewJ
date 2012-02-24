package phm1.NewJ;
import javax.swing.*;
import java.awt.*;

public class DiagramPanel extends JPanel{
	private VectorOfBoxes vOfB;
	
	public DiagramPanel(){
		this.setLayout(new BorderLayout());	
		this.setBackground(Color.WHITE);
	
	}
	
	public void addClass(int x, int y) {
		vOfB.addBox(new ClassBox(x, y));
		repaint();
	}
	
	
}
