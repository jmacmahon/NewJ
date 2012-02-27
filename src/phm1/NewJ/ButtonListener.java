package phm1.NewJ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
	private ButtonPanel bP;
	private DiagramPanel dP;
	
	public ButtonListener(ButtonPanel b, DiagramPanel d) {
		bP=b;
		dP=d;
	}
	
	public void actionPerformed(ActionEvent a) {
		String action = a.getActionCommand();
		
		if(action.equals("newClass")){ 
			//this is the shit that happens when you click the new class button
			dP.addClass(100, 100, 100, 100);
			//TODO put the box somewhere useful - maybe work out where is blank on the screen
			//TODO work out a sensible size for the box based on input text
			//TODO add an input dialog for taking input text
		}
		else if(action.equals("compile")){
			//this is the shit that happens when you click the compile button
			System.out.println("compile");
			//compile the code, duh
		}
		else if(action.equals("clear")){ //change to delete all
			
			//this is the shit that happens when you click the clear button
			//TODO clear the screen of all classes - delete files as well? or separate delete button
		}
		
	}

}
