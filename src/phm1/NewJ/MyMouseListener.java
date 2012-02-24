package phm1.NewJ;
import java.awt.event.*;

public class MyMouseListener implements MouseListener, MouseMotionListener{
//TODO add mouse position listener
	private DiagramPanel dP = new DiagramPanel();
	private ButtonPanel bP = new ButtonPanel(dP);
	
	MyMouseListener(DiagramPanel d, ButtonPanel b) {
		dP = d;
		bP = b;
	}
		
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseDragged(MouseEvent e) {
		ClassBox box = dP.findNearestClass(e.getX(), e.getY());
		if(box !=null){
			box.update(e.getX(), e.getY());
		}
	}

	public void mouseMoved(MouseEvent arg0) {
		//don't need anything here yet
	}
	
	

}
