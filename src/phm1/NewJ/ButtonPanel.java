package phm1.NewJ;
import javax.swing.*;

import java.awt.*;

public class ButtonPanel extends JPanel{

	JButton newClassButton, compileButton, clearButton; 
	
	public ButtonPanel(DiagramPanel d) {
		this.setLayout(new GridLayout(10, 1));
		this.setSize(100, 200);
		ButtonListener bList = new ButtonListener(this, d);
		
		//create buttons
		newClassButton = new JButton("newClass");
		compileButton = new JButton("compile");
		clearButton = new JButton("clear");
		
		

		
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
