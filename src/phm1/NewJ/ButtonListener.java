package phm1.NewJ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ButtonListener implements ActionListener {
	private DiagramPanel dP;
	private GUI g;
	private NJClass c;

	public ButtonListener(GUI g) {
		this.g = g;
	}

	public void actionPerformed(ActionEvent a) {
		String action = a.getActionCommand();

		if(action.equals("New Class")){ 
			NJClass c = new NJClass(g.classNamePrompt(), 100, 100, 100, 100);
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
		
		else if (action.equals("Add Method")) {
			c=g.getSelected();
			String methodName;
			if (c!=null) {
				methodName = JOptionPane.showInputDialog("enter method name");
				g.newMethod(c, methodName);
			}
		}




	}

}
