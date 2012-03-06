package phm1.NewJ;

import java.awt.*;

import java.util.Vector;

public class GUI {
	// This really is a bit useless now but getting rid of it would break things, so I'll take the hacky approach now and clean up later :P - J
	Model model;
	DiagramPanel dPanel;
	ButtonPanel bPanel;
	MyMouseListener mouseListener;
	Menus menus;
	MyMenuListener menuListener;
	
	public Model getModel() {
		return model;
	}

	public DiagramPanel getdPanel() {
		return dPanel;
	}

	public ButtonPanel getbPanel() {
		return bPanel;
	}

	public MyMouseListener getMouseListener() {
		return mouseListener;
	}

	public Menus getMenus() {
		return menus;
	}

	public MyMenuListener getMenuListener() {
		return menuListener;
	}

	GUI(Model m) {
		this.model = m;
	}
	
	public void addClass(NJClass c) {
		model.addClass(c);
		dPanel.repaint();
	}
	
	public void initialise(){
		//initalise everything - p
		model = new Model();
		dPanel = new DiagramPanel(this);
		bPanel = new ButtonPanel(this);
		menus = new Menus(dPanel, model);
		mouseListener= new MyMouseListener(dPanel, bPanel);
		MainFrame f = new MainFrame(model, dPanel, bPanel, menus, mouseListener);
		f.setVisible(true);
	}
	
	public void drawAll(Graphics g) {
		for (NJClass c : model.getClasses()) {
			c.draw(g);
			c.drawConnections(g);
		}
	}
	
	public void deleteAll() {
		model.clear();
		dPanel.repaint();
	}
	
	public void deleteSelected() {
		for(NJClass c : model.getClasses()){
			if(c.getSelected()){
				model.removeClass(c);
				return;
			}
		}
		dPanel.repaint();
	}
	
	public NJClass getSelected() {
		for(NJClass c : model.getClasses()) {
			if(c.getSelected()) {
				return c;
			}
		}
		return null;
	}
	public void unselectAll() {
		for (NJClass c : model.getClasses()) {
			c.setSelected(false);
		}
	}
	
	public NJClass clickedInBox(int x, int y) {
		//finds the box that has been clicked on, if any - p
		int xPlusA;
		int yPlusB;
		for (NJClass c : model.getClasses()){ //loop through boxes - p

			xPlusA = c.getX()+c.getA();
			yPlusB = c.getY()+c.getB();
			
			if ((c.getX() < x) && (x < xPlusA) && (c.getY() < y) && (y < yPlusB)) {
				// We found it! Let's get outta here - J
				return c;
			}
		}
		// Just return null if we didn't return earlier - J
		return null;
	}
	
	public void newMethod(NJClass c, String s) {
		
	}
}
