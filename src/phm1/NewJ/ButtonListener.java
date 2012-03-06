package phm1.NewJ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ButtonListener implements ActionListener {
	private DiagramPanel dP;
	private GUI g;

	public ButtonListener(GUI g) {
		this.g = g;
	}

	public void actionPerformed(ActionEvent a) {
		String action = a.getActionCommand();

		if(action.equals("New Class")){ 
			String className;
			//this is the shit that happens when you click the new class button - p

			className = JOptionPane.showInputDialog("enter class name");
			//pops up a dialog box to get the name for the new class

			if (className == null || className.length() == 0) { 
				className = "Untitled" + Integer.toString(g.getModel().getClassCount() + 1);
			}
			NJClass c = new NJClass(className, 100, 100, 100, 100);
			g.addClass(c);

			//TODO put the box somewhere useful - maybe work out where is blank on the screen
			//TODO work out a sensible size for the box based on input text
		}


		else if(action.equals("New Connection")){
			ConnectionComboBox createConnection = new ConnectionComboBox();
			createConnection.addActionListener(this);
			/*
			 * the idea here is to pop up a combo box with 3 dropdown lists
			 */
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
