package phm1.NewJ;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.*;

public class GUI {
	// TODO clean this up. Put things in the relevant JPanel objects if they don't coordinate the whole thing. - J
	private Model model;
	private DiagramPanel dPanel;
	private ButtonPanel bPanel;
	private MyMouseListener mouseListener;
	private Menus menus;
	private MyMenuListener menuListener;
	private MainFrame mainFrame;
	private JFileChooser saveLoadChooser;
	private JFileChooser exportChooser;
	
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
	
	public MainFrame getMainFrame(){
		return mainFrame;
	}

	public JFileChooser getSaveLoadChooser() {
		return saveLoadChooser;
	}

	public JFileChooser getExportChooser() {
		return exportChooser;
	}

	GUI(Model m) {
		this.model = m;
	}
	
	public void addClass(NJClass c) {
		model.addClass(c);
		dPanel.repaint();
	}
	
	public boolean classNameInUse(String name){
		return model.getClassByName(name) != null;
	}
	
	public void initialise(){
		//initalise everything - p
		model = new Model();
		dPanel = new DiagramPanel(this);
		bPanel = new ButtonPanel(this);
		menus = new Menus(this);
		mouseListener= new MyMouseListener(this);
		mainFrame = new MainFrame(this);
		populateEditMenu();
		saveLoadChooser = new JFileChooser();
		saveLoadChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		saveLoadChooser.setFileFilter(new FileNameExtensionFilter("XML files (.xml)", "xml"));
		exportChooser = new JFileChooser();
		exportChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		mainFrame.setVisible(true);
	}
	
	public void drawAll(Graphics g) {
		for (NJClass c : model.getClasses()) {
			c.drawConnections(g);
		}
		for (NJClass c : model.getClasses()) {
			c.draw(g, c == dPanel.getSelected());
		}
	}
	
	public void deleteAll() {
		model.clear();
		dPanel.repaint();
		populateEditMenu();
	}
	
	public void deleteSelected() {
		model.removeClass(dPanel.getSelected());
		dPanel.repaint();
		populateEditMenu();
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
	
	public String classNamePrompt(){
		String className;

		className = JOptionPane.showInputDialog("Enter class name");
		//pops up a dialog box to get the name for the new class
		if(classNameInUse(className)){
			JOptionPane.showMessageDialog(getMainFrame(), "That class name is already in use.", "Error", JOptionPane.ERROR_MESSAGE);
			className = classNamePrompt();
		}
		if (className == null || className.length() == 0) { 
			className = "Untitled" + Integer.toString(getModel().getClassCount() + 1);
		}
		return className;
	}
	
	public void populateEditMenu(NJClass c){
		getMenus().getEditMenu().populate(c);
	}
	
	public void populateEditMenu(){
		if(dPanel.getSelected() != null){
			populateEditMenu(dPanel.getSelected());
		} else {
			getMenus().getEditMenu().populate();
		}
	}
	
	public void chooseAndLoad(){
		if(this.saveLoadChooser.showOpenDialog(this.mainFrame) == JFileChooser.APPROVE_OPTION){
			try {
				this.model.load(this.saveLoadChooser.getSelectedFile());
				dPanel.repaint();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this.mainFrame, "There was an error loading the file.", "IOException", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void chooseAndSave(){
		if(this.saveLoadChooser.showSaveDialog(this.mainFrame) == JFileChooser.APPROVE_OPTION){
			try {
				this.model.save(this.saveLoadChooser.getSelectedFile());
				dPanel.repaint();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this.mainFrame, "There was an error saving to the file.", "IOException", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void chooseAndExport(){
		if(this.exportChooser.showDialog(this.mainFrame, "Export") == JFileChooser.APPROVE_OPTION){
			try {
				this.model.export(this.exportChooser.getSelectedFile());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this.mainFrame, "There was an error exporting the project. Are you exporting to a real directory?", "IOException", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
