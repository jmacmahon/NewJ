package phm1.NewJ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
	private ButtonPanel bP;
	
	public ButtonListener(ButtonPanel b) {
		bP=b;
	}
	
	public void actionPerformed(ActionEvent a) {
		String action = a.getActionCommand();
		
		if(action.equals("newClass")){
			System.out.println("newwwwww");
			//pop up box asking for name of class
		}
		else if(action.equals("compile")){
			System.out.println("compile");
			//compile the code, duh
		}
		else if(action.equals("clear")){
			System.out.println("cleaaaaar");
			//TODO clear the screen of all classes - delete files as well? or separate delete button
		}
		
	}

}
