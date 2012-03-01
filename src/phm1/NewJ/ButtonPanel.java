package phm1.NewJ;
import javax.swing.*;

import java.awt.*;

public class ButtonPanel extends JPanel{

	JButton newClassButton, compileButton, clearButton;
	
	public ButtonPanel(DiagramPanel d, Model m) {
		this.setLayout(new GridLayout(10, 1));
		this.setSize(100, 200);
		ButtonListener bList = new ButtonListener(this, d, m);
		
		//create buttons
		newClassButton = new JButton("New Class");
		compileButton = new JButton("Compile");
		clearButton = new JButton("Delete");

		
		
//moved the save and load functionality to the menu - p
		
		//add the buttons 
		this.add(newClassButton);
		this.add(compileButton);
		this.add(clearButton);

		
		//add the listeners
		newClassButton.addActionListener(bList);
		compileButton.addActionListener(bList);
		clearButton.addActionListener(bList);

	}
	

	
}
