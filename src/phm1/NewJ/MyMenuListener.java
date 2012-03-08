package phm1.NewJ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
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
			fileName = JOptionPane.showInputDialog("Enter name to save file as:");
			
			if (fileName != null && !fileName.contains("/") && !fileName.isEmpty()) {
				try {
					gui.getModel().save(fileName+ ".xml");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
		
		else if(action.equals("Load")){
			// This actually works now - J
			fileName = JOptionPane.showInputDialog("Enter name of file to load from:");
			
			//int returnVal = chooser.showOpenDialog();
		    //if(returnVal == JFileChooser.APPROVE_OPTION) {
		    //	loadFile = chooser.getSelectedFile().getName();
		    //}
			//if (loadFile != null)
			
			//TODO this file chooser will work eventually promise
			try {
				gui.getModel().load(fileName);
				gui.getdPanel().repaint();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
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
