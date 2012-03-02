package phm1.NewJ;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menus extends JMenuBar{
	
	//TODO HEY JOE WHAT OTHER BUTTONS DO YOU WANT IN THE MENU - p
	JMenu mainMenu, editMenu;
	JMenuItem saveProject, loadProject, exitProgram;
	MyMenuListener mML;
	Model model;
	
		public Menus(Model m){
			model = m;
			mML = new MyMenuListener(this, model);
			
			mainMenu = new JMenu("File");
			editMenu = new JMenu("Edit");
			
			saveProject = new JMenuItem("Save");
			loadProject = new JMenuItem("Load");
			exitProgram = new JMenuItem("Exit");
			
			this.add(mainMenu);
			this.add(editMenu);
			
			mainMenu.add(saveProject);
			mainMenu.add(loadProject);
			mainMenu.add(exitProgram);
			
			saveProject.addActionListener(mML);
			loadProject.addActionListener(mML);
			exitProgram.addActionListener(mML);
		}
}
