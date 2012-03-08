package phm1.NewJ;
import java.awt.event.*;

import javax.swing.SwingUtilities;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

public class MyMouseListener implements MouseListener, MouseMotionListener, PopupMenuListener {

	private NJClass box;
	private NJClass box2;
	private int offsetX;
	private int offsetY;
	private GUI gui;
	
	MyMouseListener(GUI g) {
		this.gui = g;
	}
		
	public void mouseClicked(MouseEvent e) {
		// made selected box look different -P
		//calls a method to find the box that has been clicked in - P
		NJClass box = gui.getdPanel().findNearestClass(e.getX(), e.getY());
		//if the mouse is clicked inside a box, it sets this.box to that box so other methods can use it - P
		if(box !=null && SwingUtilities.isLeftMouseButton(e) && box2==null){
			// TODO Code duplication here, put it in a function - J
			gui.getdPanel().unselectAll();
			gui.getdPanel().setSelected(box);
			this.box = box;
		}
		else if (box !=null && SwingUtilities.isRightMouseButton(e)) {
			// TODO Code duplication here, put it in a function - J
			gui.getdPanel().unselectAll();
			gui.getdPanel().setSelected(box);
			this.box2=box;
			//dPup.popBoxMenu();	
		}
		
		else if (box !=null && SwingUtilities.isLeftMouseButton(e) && box2 !=null) {
			//gui.getdPanel().addConnection(box, box2);
		}
		else {
			gui.unselectAll();
			//dPup.popBackgroundMenu();
		}
	}

	public void mouseEntered(MouseEvent arg0) {
		//gui.drawTempConnection();
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		NJClass box = gui.getdPanel().findNearestClass(e.getX(), e.getY());
		//if the mouse is clicked inside a box, it sets this.box to that box so other methods can use it - P
		if(box !=null){
			// TODO Code duplication here, put it in a function - J
			gui.unselectAll();
			gui.getdPanel().setSelected(box);
			this.box = box;
			this.offsetX = e.getX() - box.getX();
			this.offsetY = e.getY() - box.getY();
			// Works out where the cursor is within the box so we can move the box relative to the mouse - J
		}
		else {
			gui.unselectAll();
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
			gui.getdPanel().repaint();
		}
		else {
			gui.unselectAll();
		}
	}

	public void mouseMoved(MouseEvent e) {
		if(gui.getdPanel().getInheriting() && gui.getdPanel().getTempInheritance() != null){
			
		}
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
