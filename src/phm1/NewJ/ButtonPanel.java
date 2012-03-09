package phm1.NewJ;
import javax.swing.*;

import java.awt.*;

public class ButtonPanel extends JPanel{

	JButton newClassButton, clearButton, deleteButton;
	
	public JButton getNewClassButton() {
		return newClassButton;
	}

	public JButton getClearButton() {
		return clearButton;
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}

	public ButtonPanel(GUI g) {
		this.setLayout(new GridLayout(10, 1));
		this.setSize(100, 200);
		ButtonListener bList = new ButtonListener(g);
		
		//create buttons
		newClassButton = new JButton("New Class");
		deleteButton = new JButton("Delete Selected");
		clearButton = new JButton("Delete All");
		

		
		
//moved the save and load functionality to the menu - p
		
		//add the buttons 
		this.add(newClassButton);
		this.add(deleteButton);
		this.add(clearButton);

		
		//add the listeners
		newClassButton.addActionListener(bList);
		deleteButton.addActionListener(bList);
		clearButton.addActionListener(bList);

	}
	

	
}
