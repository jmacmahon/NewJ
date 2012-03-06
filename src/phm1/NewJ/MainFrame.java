package phm1.NewJ;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
	//not much that is too confusing going on in here hopefully - P
	DiagramPanel dPanel;
	ButtonPanel bPanel;
	MyMouseListener mL;
	Model m;
	Menus menus;
	MyMenuListener mmL;
	
	MainFrame() {
		//initalise everything - p
		m = new Model();
		dPanel = new DiagramPanel(m);
		bPanel = new ButtonPanel(dPanel, m);
		menus = new Menus(dPanel, m);

		
		
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
		mL= new MyMouseListener(dPanel, bPanel);
		dPanel.addMouseListener(mL);
		dPanel.addMouseMotionListener(mL);
		//dPopup.addPopupMenuListener(mL);
		
		//menu shit - p
		// I don't quite understand why you're creating this twice and never using this one, could you put a reason in the comments so I understand what I'm debugging? - J
		mmL = new MyMenuListener(menus, dPanel, m);
		
		
		//TODO work out where to add the listener for the menu - doesn't seem to be on the menu bar, maybe on each menu- p
	}

}
