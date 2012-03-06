package phm1.NewJ;
import java.awt.event.*;

import javax.swing.SwingUtilities;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

public class MyMouseListener implements MouseListener, MouseMotionListener, PopupMenuListener {

	private DiagramPanel dP;
	private ButtonPanel bP;
	private NJClass box;
	private NJClass box2;
	private ConnectionType connection;
	//private DiagramPopup dPup;
	private int offsetX;
	private int offsetY;
	
	
	MyMouseListener(DiagramPanel d, ButtonPanel b) {
		dP = d;
		bP = b;
		//dPup = p;
	}
		
	public void mouseClicked(MouseEvent e) {
		// made selected box look different -P
		//calls a method to find the box that has been clicked in - P
		NJClass box = dP.findNearestClass(e.getX(), e.getY());
		//if the mouse is clicked inside a box, it sets this.box to that box so other methods can use it - P
		if(box !=null && SwingUtilities.isLeftMouseButton(e) && box2==null){
			dP.unselectAll();
			box.setSelected(true);
			this.box = box;
		}
		else if (box !=null && SwingUtilities.isRightMouseButton(e)) {
			dP.unselectAll();
			box.setSelected(true);
			this.box2=box;
			//dPup.popBoxMenu();	
		}
		
		else if (box !=null && SwingUtilities.isLeftMouseButton(e) && box2 !=null) {
			connection = ConnectionType.extendsConnection;
			dP.addConnection(box, box2, connection);
		}
		else {
			dP.unselectAll();
			//dPup.popBackgroundMenu();
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
			this.offsetX = e.getX() - box.getX();
			this.offsetY = e.getY() - box.getY();
			// Works out where the cursor is within the box so we can move the box relative to the mouse - J
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
			int newX = e.getX() - this.offsetX;
			int newY = e.getY() - this.offsetY;
			// Moves relative to the cursor - J
			box.update(newX, newY);
			dP.repaint();
		}
		else {
			dP.unselectAll();
		}
	}

	public void mouseMoved(MouseEvent arg0) {
		//don't need anything here yet
	}

	@Override
	public void popupMenuCanceled(PopupMenuEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	
	

}
