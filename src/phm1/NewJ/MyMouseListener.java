package phm1.NewJ;
import java.awt.event.*;

public class MyMouseListener implements MouseListener, MouseMotionListener{

	private DiagramPanel dP;
	private ButtonPanel bP;
	private NJClass box;
	
	MyMouseListener(DiagramPanel d, ButtonPanel b) {
		dP = d;
		bP = b;
	}
		
	public void mouseClicked(MouseEvent e) {
		// made selected box look different -P
		//calls a method to find the box that has been clicked in - P
		NJClass box = dP.findNearestClass(e.getX(), e.getY());
		//if the mouse is clicked inside a box, it sets this.box to that box so other methods can use it - P
		if(box !=null){
			dP.unselectAll();
			box.setSelected(true);
			this.box = box;
		}
		else {
			dP.unselectAll();
		}
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		NJClass box = dP.findNearestClass(e.getX(), e.getY());
		//if the mouse is clicked inside a box, it sets this.box to that box so other methods can use it - P
		if(box !=null){
			dP.unselectAll();
			box.setSelected(true);
			this.box = box;
		}
		else {
			dP.unselectAll();
		}
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
		else {
			dP.unselectAll();
		}
	}

	public void mouseMoved(MouseEvent arg0) {
		//don't need anything here yet
	}
	
	

}
