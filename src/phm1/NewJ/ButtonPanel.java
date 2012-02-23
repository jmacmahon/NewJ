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
		this.add(newClassButton, BorderLayout.NORTH);
		this.add(compileButton, BorderLayout.CENTER);
		this.add(clearButton, BorderLayout.SOUTH);
		newClassButton.addActionListener(bList);
		compileButton.addActionListener(bList);
		clearButton.addActionListener(bList);
		
	}
}
