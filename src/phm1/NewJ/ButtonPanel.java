package phm1.NewJ;
import javax.swing.*;

import java.awt.*;

public class ButtonPanel extends JPanel{

	JButton newClassButton, compileButton, clearButton; 
	
	public ButtonPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setSize(100, 200);
		ButtonListener bList = new ButtonListener(this);
		
		//create buttons
		newClassButton = new JButton("newClass");
		compileButton = new JButton("compile");
		clearButton = new JButton("clear");
		
		//put the buttons in the middle of the panel
		newClassButton.setAlignmentX(this.CENTER_ALIGNMENT);
		compileButton.setAlignmentX(this.CENTER_ALIGNMENT);
		clearButton.setAlignmentX(this.CENTER_ALIGNMENT);
		
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
