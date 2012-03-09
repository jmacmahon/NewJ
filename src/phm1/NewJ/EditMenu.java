package phm1.NewJ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EditMenu extends JMenu {
	JMenu fields;
	JMenu methods;
	GUI gui;
	NJClass njClass;
	
	EditMenu(GUI g){
		super("Edit");
		gui = g;
	}
	
	public void populate(){
		this.removeAll();
		JMenuItem disabled = new JMenuItem("There is no class selected");
		disabled.setEnabled(false);
		this.add(disabled);
	}
	
	public void populate(final NJClass c){
		this.removeAll();
		this.njClass = c;
		
		fields = new JMenu("Fields");
		for (NJField f : c.getFields()){
			fields.add(new FieldMenu(f));
		}
		JMenuItem addField = new JMenuItem("Add Field");
		
		methods = new JMenu("Methods");
		for (NJMethod m : c.getMethods()){
			methods.add(new MethodMenu(m));
		}
		JMenuItem addMethod = new JMenuItem("Add Method");
		
		// Anonymous ActionListener class, this is some pretty cool stuff. - J
		addField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String fname = JOptionPane.showInputDialog("Enter the name of the new field.");
				if(fname == null)
					return;
				c.addField(new NJField(fname, "Object", NJAccessModifier.PRIVATE));
				gui.getdPanel().repaint();
				gui.populateEditMenu();
			}
		});
		addMethod.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String mname = JOptionPane.showInputDialog("Enter the name of the new method.");
				if(mname == null)
					return;
				c.addMethod(new NJMethod(mname, "void", NJAccessModifier.PRIVATE));
				gui.getdPanel().repaint();
				gui.populateEditMenu();
			}
		});
		fields.add(addField);
		methods.add(addMethod);
		this.add(fields);
		this.add(methods);
		JMenuItem renameClass = new JMenuItem("Rename Class");
		renameClass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String newName = JOptionPane.showInputDialog("Enter the new name of the class:", c.getName());
				if(newName == null)
					return;
				c.setName(newName);
				gui.getdPanel().repaint();
				gui.populateEditMenu();
			}
		});
		this.add(renameClass);
		
		if(c.getInherits() == null){
			JMenuItem addInheritance = new JMenuItem("Add inherits from");
			addInheritance.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					gui.getdPanel().setInheriting(true);
				}
			});
			this.add(addInheritance);
		} else {
			JMenuItem removeInheritance = new JMenuItem("Delete inherits from");
			removeInheritance.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					c.setInherits(null);
					gui.getdPanel().repaint();
					gui.populateEditMenu();
				}
			});
			this.add(removeInheritance);
		}
	}
	
	private abstract class AbstractPropertyMenu extends JMenu {
		protected JMenuItem delete;
		protected JMenuItem rename;
		protected JMenu changeAM;
		protected JMenuItem changeType;
		
		AbstractPropertyMenu(final NJAbstractProperty p){
			super(p.getName());
			
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
			priv.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					p.setAccessModifier(NJAccessModifier.PRIVATE);
					gui.getdPanel().repaint();
				}
			});
			prot.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					p.setAccessModifier(NJAccessModifier.PROTECTED);
					gui.getdPanel().repaint();
				}
			});
			publ.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					p.setAccessModifier(NJAccessModifier.PUBLIC);
					gui.getdPanel().repaint();
				}
			});
			changeType.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String newType = JOptionPane.showInputDialog("Enter the new type:", p.getType());
					if(newType == null)
						return;
					p.setType(newType);
					gui.getdPanel().repaint();
				}
			});
		}
	}
	
	private class MethodMenu extends AbstractPropertyMenu {
		private NJMethod method;
		
		MethodMenu(final NJMethod m){
			super(m);
			this.method = m;
			
			JMenu arguments = new JMenu("Arguments");
			for(NJArgument a : method.getArguments()){
				arguments.add(new ArgumentMenu(a));
			}
			JMenuItem addArgument = new JMenuItem("Add Argument");
			arguments.add(addArgument);
			
			addArgument.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String aname = JOptionPane.showInputDialog("Enter the name of the new argument.");
					if(aname == null)
						return;
					method.addArgument(new NJArgument(aname, "Object"));
					gui.getdPanel().repaint();
					gui.populateEditMenu();
				}
			});
			this.add(arguments);

			delete.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					njClass.deleteMethod(m);
					gui.getdPanel().repaint();
					gui.populateEditMenu();
				}
			});
			rename.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String newName = JOptionPane.showInputDialog("Rename the method:", m.getName());
					if(newName == null)
						return;
					m.setName(newName);
					gui.getdPanel().repaint();
					gui.populateEditMenu();
				}
			});
			this.add(delete);
			this.add(rename);
			this.add(changeAM);
			this.add(changeType);
		}
		
		private class ArgumentMenu extends JMenu {
			private NJArgument argument;
			private JMenuItem delete, rename, changeType;
			
			ArgumentMenu(final NJArgument a){
				super(a.getName());
				this.argument = a;
				
				delete = new JMenuItem("Delete");
				rename = new JMenuItem("Rename");
				changeType = new JMenuItem("Change Type");

				delete.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						method.deleteArgument(a);
						gui.getdPanel().repaint();
						gui.populateEditMenu();
					}
				});
				rename.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String newName = JOptionPane.showInputDialog("Rename the argument:", a.getName());
						if(newName == null)
							return;
						a.setName(newName);
						gui.getdPanel().repaint();
						gui.populateEditMenu();
					}
				});
				changeType.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String newType = JOptionPane.showInputDialog("Enter the new type:", a.getType());
						if(newType == null)
							return;
						a.setType(newType);
						gui.getdPanel().repaint();
					}
				});
				this.add(delete);
				this.add(rename);
				this.add(changeType);
			}
		}
	}
	
	private class FieldMenu extends AbstractPropertyMenu {
		private NJField field;

		FieldMenu(final NJField f){
			super(f);
			this.field = f;

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
					if(newName == null)
						return;
					f.setName(newName);
					gui.getdPanel().repaint();
					gui.populateEditMenu();
				}
			});
			this.add(delete);
			this.add(rename);
			this.add(changeAM);
			this.add(changeType);
		}
	}
}
