package phm1.NewJ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ButtonListener implements ActionListener {
	private GUI g;
	private NJClass c;
	private boolean inheritance;

	public ButtonListener(GUI g) {
		this.g = g;
		this.inheritance = false;
	}

	public void actionPerformed(ActionEvent a) {
		String action = a.getActionCommand();

		if(action.equals("New Class")){ 
			NJClass c = new NJClass(g.classNamePrompt(), 100, 100);
			g.addClass(c);

			//TODO put the box somewhere useful - maybe work out where is blank on the screen
			//TODO work out a sensible size for the box based on input text
		}


		else if(action.equals("Delete Selected")){
			g.deleteSelected();
			//deletes selected box
		}

		else if (action.equals("Delete All")) {
			g.deleteAll();
			//deletes all boxes
		}
		//moved save and load to the menu - p
	}

}
