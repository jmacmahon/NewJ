package phm1.NewJ;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * This class extends JMenuBar, and contains all the code for how the menus look. It has a corresponding menu listener to implement any actions performed from the menus
 * @author Phoebe
 *
 */
public class Menus extends JMenuBar{

	JMenu mainMenu, helpMenu;
	EditMenu editMenu;
	JMenuItem saveProject, loadProject, exportProject, exitProgram;
	JMenuItem helpNew, helpDelete, helpDelAll;
	MyMenuListener mML;
	GUI gui;
	
	/**
	 * gets the edit menu
	 * @return The EditMenu stored in the Menu class
	 */
	public EditMenu getEditMenu(){
		return editMenu;
	}
	
	/**
	 * gets the listener for the menu
	 * @return the MyMenuListener stored in the Menu class
	 */
	public MyMenuListener getmML() {
		return mML;
	}

	/**
	 * gets the GUI object
	 * @return the GUI stored in the Menu class
	 */
	public GUI getGui() {
		return gui;
	}

	/**
	 * Create a new Menu
	 * @param g
	 */
	public Menus(GUI g){
		this.gui = g;
		mML = new MyMenuListener(gui);

		mainMenu = new JMenu("File");
		helpMenu = new JMenu("Help");
		editMenu = new EditMenu(gui);

		saveProject = new JMenuItem("Save");
		loadProject = new JMenuItem("Open");
		exportProject = new JMenuItem("Export as .java files");
		exitProgram = new JMenuItem("Exit");

		helpNew = new JMenuItem("\"New Class\" Help");
		helpDelete = new JMenuItem("\"Delete Selected\" Help");
		helpDelAll = new JMenuItem("\"Delete All\" Help");

		this.add(mainMenu);
		this.add(editMenu);
		this.add(helpMenu);

		mainMenu.add(saveProject);
		mainMenu.add(loadProject);
		mainMenu.add(exportProject);
		mainMenu.add(exitProgram);
		
		helpMenu.add(helpNew);
		helpMenu.add(helpDelete);
		helpMenu.add(helpDelAll);
		
		saveProject.addActionListener(mML);
		loadProject.addActionListener(mML);
		exportProject.addActionListener(mML);
		exitProgram.addActionListener(mML);

		helpNew.addActionListener(mML);
		helpDelete.addActionListener(mML);
		helpDelAll.addActionListener(mML);
	}
}
