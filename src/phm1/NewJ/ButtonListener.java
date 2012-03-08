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
			NJMethod meth = new NJMethod("asd", "String", NJAccessModifier.PUBLIC);
			c.addMethod(meth);
			c.getMethods().get(0).addArgument(new NJArgument("test", "int"));
			c.addMethod(meth);
			g.addClass(c);

			//TODO put the box somewhere useful - maybe work out where is blank on the screen
			//TODO work out a sensible size for the box based on input text
		}


		else if(action.equals("Add Inheritance")){
			g.getdPanel().setInheriting(g.getbPanel().getInheritanceButton().getModel().isSelected());
			if(g.getdPanel().getInheriting() != g.getbPanel().getInheritanceButton().getModel().isSelected()){
				JOptionPane.showMessageDialog(g.getMainFrame(), "You must select a class first!", "Error", JOptionPane.ERROR_MESSAGE);
			}
			g.getbPanel().getInheritanceButton().getModel().setSelected(g.getdPanel().getInheriting());
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
			c=g.getdPanel().getSelected();
			String methodName;
			if (c!=null) {
				methodName = JOptionPane.showInputDialog("enter method name");
				g.newMethod(c, methodName);
			}
		}
	}

}
