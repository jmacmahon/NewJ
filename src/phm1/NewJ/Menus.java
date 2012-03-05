package phm1.NewJ;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menus extends JMenuBar{
	
	//TODO HEY JOE WHAT OTHER BUTTONS DO YOU WANT IN THE MENU - p
	JMenu mainMenu, editMenu, helpMenu;
	JMenuItem saveProject, loadProject, exitProgram;
	JMenuItem helpNew, helpCompile, helpDelete, helpDelAll;
	MyMenuListener mML;
	Model model;
	
		public Menus(Model m){
			model = m;
			mML = new MyMenuListener(this, model);
			
			mainMenu = new JMenu("File");
			editMenu = new JMenu("Edit");
			helpMenu = new JMenu("Help");
			
			saveProject = new JMenuItem("Save");
			loadProject = new JMenuItem("Load");
			exitProgram = new JMenuItem("Exit");
			
			helpNew = new JMenuItem("New Class Help");
			helpCompile = new JMenuItem("Compile Help");
			helpDelete = new JMenuItem("Delete Selected Help");
			helpDelAll = new JMenuItem("Delete All Help");
			
			this.add(mainMenu);
			this.add(editMenu);
			this.add(helpMenu);
			
			mainMenu.add(saveProject);
			mainMenu.add(loadProject);
			mainMenu.add(exitProgram);
			
			helpMenu.add(helpNew);
			helpMenu.add(helpCompile);
			helpMenu.add(helpDelete);
			helpMenu.add(helpDelAll);
			
			saveProject.addActionListener(mML);
			loadProject.addActionListener(mML);
			exitProgram.addActionListener(mML);
			
			helpNew.addActionListener(mML);
			helpCompile.addActionListener(mML);
			helpDelete.addActionListener(mML);
			helpDelAll.addActionListener(mML);
		}
}
