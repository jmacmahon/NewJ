package phm1.NewJ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MyMenuListener implements ActionListener{
	private GUI gui;
	
	public MyMenuListener(GUI g){
		this.gui = g;
	}
	
	public void actionPerformed(ActionEvent a) {
		String action = a.getActionCommand();
		String fileName;
		JFileChooser chooser = new JFileChooser();
		
		
		if (action.equals("Save")) {
			gui.chooseAndSave();
		}
	
		
		else if(action.equals("Load")){
			gui.chooseAndLoad();
		}
		
		else if(action.equals("Exit")) {
			System.exit(0); // 0 means success
		}
		
		else if(action.equals("\"New Class\" Help")){
			JOptionPane.showMessageDialog(null, "Click the \"New Class\" button to create a new class. You will be able to enter a custom name for the class", 
					"Help", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(action.equals("\"Delete Selected\" Help")) {
			JOptionPane.showMessageDialog(null, "Click the \"Delete Selected\" button to delete the currently selected (orange outlined) class",
					"Help", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(action.equals("\"Delete All\" Help")) {
			JOptionPane.showMessageDialog(null,  "Click the \"Delete All\" button to clear all classes and connections from the screen",
					"Help", JOptionPane.INFORMATION_MESSAGE);
		}

	}
}
