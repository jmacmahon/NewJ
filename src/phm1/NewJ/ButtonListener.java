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
		}
		else if(action.equals("compile")){
			System.out.println("compile");
		}
		else if(action.equals("clear")){
			System.out.println("cleaaaaar");
		}
		
	}

}
