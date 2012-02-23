package phm1.NewJ;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
	DiagramPanel dPanel = new DiagramPanel();
	ButtonPanel bPanel = new ButtonPanel();
	MyMouseListener mL;
	
	MainFrame() {
		this.setSize(200,200);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("The Worlds Greatest IDE");
		this.add(dPanel, BorderLayout.CENTER);
		this.add(bPanel, BorderLayout.WEST);
		
		mL= new MyMouseListener(dPanel, bPanel);
		dPanel.addMouseListener(mL);
	}

}
