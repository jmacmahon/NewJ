package phm1.NewJ;
import javax.swing.*;

import java.awt.*;

public class ButtonPanel extends JPanel{

	JButton newClassButton, compileButton, clearButton, saveButton, loadButton;
	
	public ButtonPanel(DiagramPanel d, Model m) {
		this.setLayout(new GridLayout(10, 1));
		this.setSize(100, 200);
		ButtonListener bList = new ButtonListener(this, d, m);
		
		//create buttons
		newClassButton = new JButton("newClass");
		compileButton = new JButton("compile");
		clearButton = new JButton("clear");
		saveButton = new JButton("Save");
		loadButton = new JButton("Load");
		
		

		
		//add the buttons 
		this.add(newClassButton);
		this.add(compileButton);
		this.add(clearButton);
		this.add(saveButton);
		this.add(loadButton);
		
		//add the listeners
		newClassButton.addActionListener(bList);
		compileButton.addActionListener(bList);
		clearButton.addActionListener(bList);
		saveButton.addActionListener(bList);
		loadButton.addActionListener(bList);
	}
	

	
}
