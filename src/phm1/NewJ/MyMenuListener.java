package phm1.NewJ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

public class MyMenuListener implements ActionListener{
	JMenuBar jMB;
	Model m;
	
	public MyMenuListener(JMenuBar b, Model m){
		jMB = b;
		this.m = m;
	}
	
	public void actionPerformed(ActionEvent a) {
		String action = a.getActionCommand();
		String fileName;
		String loadFile = "loadfile.xml";
		JFileChooser chooser = new JFileChooser();
		
		
		if (action.equals("Save")) {
			fileName = JOptionPane.showInputDialog("Enter name to save file as:");
			
			if (fileName != null && !fileName.contains(".") && !fileName.contains("/") && !fileName.isEmpty()) {
				try {
					m.save("fileName"+ ".xml");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
		
		else if(action.equals("Load")){
			
			// Note this won't actually work properly because of the ArrayList<NJClass> and the VectorOfBoxes clusterfuck of code duplication
			// TODO Sort that shit out man
			
			//int returnVal = chooser.showOpenDialog();
		    //if(returnVal == JFileChooser.APPROVE_OPTION) {
		    //	loadFile = chooser.getSelectedFile().getName();
		    //}
			//if (loadFile != null)
			
			//TODO this file chooser will work eventually promise
			try {
				m.load(loadFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

	}
}
