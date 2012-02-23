package phm1.NewJ;
import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel{

	JButton newClassButton, compileButton, clearButton; 
	
	public ButtonPanel() {
		this.setLayout(new BorderLayout());
		ButtonListener bList = new ButtonListener(this);
		
		newClassButton = new JButton("newClass");
		compileButton = new JButton("compile");
		clearButton = new JButton("clear");
		this.add(newClassButton);
		this.add(compileButton);
		this.add(clearButton);
		newClassButton.addActionListener(bList);
		compileButton.addActionListener(bList);
		clearButton.addActionListener(bList);
		
	}
}
