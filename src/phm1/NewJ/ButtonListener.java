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
			dP.addClass(100, 200); //TODO put the box somewhere useful
		}
		else if(action.equals("compile")){
			System.out.println("compile");
			//compile the code, duh
		}
		else if(action.equals("clear")){
			
			//TODO clear the screen of all classes - delete files as well? or separate delete button
		}
		
	}

}
