package phm1.NewJ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ButtonListener implements ActionListener {
	private ButtonPanel bP;
	private DiagramPanel dP;
	private Model m;
	
	public ButtonListener(ButtonPanel b, DiagramPanel d, Model m) {
		this.m = m;
		bP=b;
		dP=d;
	}
	
	public void actionPerformed(ActionEvent a) {
		String action = a.getActionCommand();
		
		if(action.equals("New Class")){ 
			String className;
			do {
				//this is the shit that happens when you click the new class button - p
				
				className = JOptionPane.showInputDialog("enter class name");
				//pops up a dialog box to get the name for the new class
							
					if (className != null && className.length() > 0) { 
					//if they cancel or don't enter anything then no new class is created
						NJClass c = new NJClass(className + Integer.toString(m.getClassCount() + 1), new ArrayList<NJField>(), new ArrayList<NJMethod>(), 100, 100, 100, 100);
						// what does this line of code do? ^^^^^ - p
						m.addClass(c);
						dP.addClass(c);
					}
				
			
		
			//TODO put the box somewhere useful - maybe work out where is blank on the screen
			//TODO work out a sensible size for the box based on input text
			
		}while(className != null && className.length()==0);
			//keeps asking until they click cancel or enter a name for the class
		}
		else if(action.equals("Compile")){
			//this is the shit that happens when you click the compile button
			System.out.println("compile");
			//compile the code, duh
		}
		else if(action.equals("Delete Selected")){
			dP.deleteSelected();
			//deletes selected box
		}
		
		else if (action.equals("Delete All")) {
			dP.deleteAll();
			//deletes all boxes
		}
//moved save and load to the menu - p
		
		
		
		
	}

}
