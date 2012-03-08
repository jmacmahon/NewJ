package phm1.NewJ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EditMenu extends JMenu {
	JMenuItem renameClass;
	JMenu fields;
	GUI gui;
	
	EditMenu(GUI g){
		super("Edit");
		gui = g;
	}
	public void populate(final NJClass c){
		this.removeAll();
		
		fields = new JMenu("Fields");
		for (NJField f : c.getFields()){
			fields.add(new FieldMenu(f));
		}
		JMenuItem addField = new JMenuItem("Add Field");
		addField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String fname = JOptionPane.showInputDialog("Enter the name of the new field.");
				c.addField(new NJField(fname, "Object", NJAccessModifier.PRIVATE));
				gui.getdPanel().repaint();
			}
		});
		fields.add(addField);
		this.add(fields);
		renameClass = new JMenuItem("Rename Class");
		this.add(renameClass);
	}
	
	private class FieldMenu extends JMenu {
		NJField field;
		JMenuItem delete;
		JMenuItem rename;
		JMenuItem changeAM;
		JMenuItem changeType;

		public NJField getField() {
			return field;
		}

		FieldMenu(NJField f){
			super(f.getName());
			this.field = f;
			
			delete = new JMenuItem("Delete");
			rename = new JMenuItem("Rename");
			changeAM = new JMenu("Change Access Modifier");
			JMenuItem priv = new JMenuItem("Private");
			JMenuItem prot = new JMenuItem("Protected");
			JMenuItem publ = new JMenuItem("Public");
			changeAM.add(priv);
			changeAM.add(prot);
			changeAM.add(publ);
			changeType = new JMenuItem("Change Type");
			
			this.add(delete);
			this.add(rename);
			this.add(changeAM);
			this.add(changeType);
		}
	}
}
