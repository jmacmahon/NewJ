package phm1.NewJ;
import java.awt.event.*;

public class MyMouseListener implements MouseListener, MouseMotionListener{

	private DiagramPanel dP = new DiagramPanel();
	private ButtonPanel bP = new ButtonPanel(dP);
	private ClassBox box = null;
	
	MyMouseListener(DiagramPanel d, ButtonPanel b) {
		dP = d;
		bP = b;
	}
		
	public void mouseClicked(MouseEvent e) {
		//TODO make selected box look different
		ClassBox box = dP.findNearestClass(e.getX(), e.getY());
		if(box !=null){
			this.box = box;			
		}
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

	public void mouseReleased(MouseEvent e) {
		box = null;
	}

	public void mouseDragged(MouseEvent e) {
		if (box !=null){
		box.update(e.getX(), e.getY());
		dP.repaint();
		}
	}

	public void mouseMoved(MouseEvent arg0) {
		//don't need anything here yet
	}
	
	

}
