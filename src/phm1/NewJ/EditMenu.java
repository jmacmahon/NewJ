package phm1.NewJ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EditMenu extends JMenu {
	JMenuItem renameClass;
	JMenu fields;
	GUI gui;
	NJClass njClass;
	
	EditMenu(GUI g){
		super("Edit");
		gui = g;
	}
	public void populate(final NJClass c){
		this.removeAll();
		this.njClass = c;
		
		fields = new JMenu("Fields");
		for (NJField f : c.getFields()){
			fields.add(new FieldMenu(gui, f));
		}
		JMenuItem addField = new JMenuItem("Add Field");
		// Anonymous ActionListener class, this is some pretty cool stuff. - J
		addField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String fname = JOptionPane.showInputDialog("Enter the name of the new field.");
				c.addField(new NJField(fname, "Object", NJAccessModifier.PRIVATE));
				gui.getdPanel().repaint();
				gui.populateEditMenu();
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

		FieldMenu(GUI g, final NJField f){
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
			
			// ActionListeners (in Anonymous Classes for epic win) - J
			delete.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					njClass.deleteField(f);
					gui.getdPanel().repaint();
					gui.populateEditMenu();
				}
			});
			rename.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String newName = JOptionPane.showInputDialog("Rename the field:", f.getName());
					f.setName(newName);
					gui.getdPanel().repaint();
					gui.populateEditMenu();
				}
			});
			priv.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					f.setAccessModifier(NJAccessModifier.PRIVATE);
					gui.getdPanel().repaint();
				}
			});
			prot.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					f.setAccessModifier(NJAccessModifier.PROTECTED);
					gui.getdPanel().repaint();
				}
			});
			publ.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					f.setAccessModifier(NJAccessModifier.PUBLIC);
					gui.getdPanel().repaint();
				}
			});
			changeType.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String newType = JOptionPane.showInputDialog("Enter the new type:", f.getType());
					f.setType(newType);
					gui.getdPanel().repaint();
				}
			});
			
			this.add(delete);
			this.add(rename);
			this.add(changeAM);
			this.add(changeType);
		}
	}
}
