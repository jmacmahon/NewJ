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
			//new class
		}
		else if(action.equals("compile")){
			//compile
		}
		
	}

}
