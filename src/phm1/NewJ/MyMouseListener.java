package phm1.NewJ;
import java.awt.event.*;

public class MyMouseListener implements MouseListener, MouseMotionListener{

	private DiagramPanel dP;
	private ButtonPanel bP;
	private ClassBox box;
	
	MyMouseListener(DiagramPanel d, ButtonPanel b) {
		dP = d;
		bP = b;
	}
		
	public void mouseClicked(MouseEvent e) {
		//TODO make selected box look different -P
		//calls a method to find the box that has been clicked in - P
		ClassBox box = dP.findNearestClass(e.getX(), e.getY());
		//if the mouse is inside a box, it sets this.box to that box so other methods can use it - P
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
		//stops the selected box jumping to the mouse when you click on blank space - P
		box = null;
	}

	public void mouseDragged(MouseEvent e) {
		//lets you drag a box around if it is selected - P
		//you have to click the box before you can drag it around -p
		if (box !=null){
		box.update(e.getX(), e.getY());
		dP.repaint();
		}
	}

	public void mouseMoved(MouseEvent arg0) {
		//don't need anything here yet
	}
	
	

}
