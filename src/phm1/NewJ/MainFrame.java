package phm1.NewJ;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
	//not much that is too confusing going on in here hopefully - P
	private GUI g;
	
	MainFrame(Model m, DiagramPanel dPanel, ButtonPanel bPanel, Menus menus, MyMouseListener mL) {		
		//set the frame size an shit - p
		this.setSize(600,400);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("The Worlds Greatest IDE");
		
		//add shit to the frame - p
		this.add(dPanel, BorderLayout.CENTER);
		this.add(bPanel, BorderLayout.WEST);
		this.add(menus, BorderLayout.NORTH);
		
		//mouse listener stuff - p
		dPanel.addMouseListener(mL);
		dPanel.addMouseMotionListener(mL);
		//dPopup.addPopupMenuListener(mL);		
		
		//TODO work out where to add the listener for the menu - doesn't seem to be on the menu bar, maybe on each menu- p
	}

}
