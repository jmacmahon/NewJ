package phm1.NewJ;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
	//not much that is too confusing going on in here hopefully - P
	private GUI gui;
	
	MainFrame(GUI g) {	
		this.gui = g;
		
		//set the frame size an shit - p
		this.setSize(600,400);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("The Worlds Greatest IDE");
		
		//add shit to the frame - p
		this.add(gui.getdPanel(), BorderLayout.CENTER);
		this.add(gui.getbPanel(), BorderLayout.WEST);
		this.add(gui.getMenus(), BorderLayout.NORTH);
		
		//mouse listener stuff - p
		gui.getdPanel().addMouseListener(gui.getMouseListener());
		gui.getdPanel().addMouseMotionListener(gui.getMouseListener());
		//dPopup.addPopupMenuListener(mL);		
		
		//TODO work out where to add the listener for the menu - doesn't seem to be on the menu bar, maybe on each menu- p
	}

}
