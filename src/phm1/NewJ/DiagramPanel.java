package phm1.NewJ;
import javax.swing.*;

import java.awt.*;

public class DiagramPanel extends JPanel{
	private GUI gui;
	private NJClass selected;
	private boolean inheriting;
	private boolean aggregating;
	
	public boolean getInheriting(){
		return inheriting;
	}
	
	public boolean getAggregating(){
		return aggregating;
	}
	
	public void setInheriting(boolean inheriting){
		this.inheriting = (selected != null) && inheriting;
		if(this.inheriting){
			selected.setInheritance(new NJInheritance());
		}
	}
	
	public void setAggregating(boolean aggregating){
		this.aggregating = (selected != null) && aggregating;
		if(this.aggregating){
			selected.setTempAggregation(new NJAggregation());
		}
	}
	
	public NJClass getSelected() {
		return selected;
	}

	public void setSelected(NJClass selected) {
		if(inheriting){
			if(selected == null && this.selected != null){
				this.selected.setInheritance(null);
			} else if(selected != null && this.selected.getInheritance() != null){
				this.selected.getInheritance().setTo(selected);
			}
		}
		if(aggregating){
			if(selected == null && this.selected != null){
				this.selected.setTempAggregation(null);
			} else if(selected != null && this.selected.getTempAggregation() != null){
				this.selected.getTempAggregation().setTo(selected);
				// This method moves the NJAggregation in tempAggregation into the aggregation ArrayList.
				this.selected.fixTempAggregation();
			}
		}
		this.selected = selected;
	}

	public DiagramPanel(GUI g){
		this.gui = g;
		this.inheriting = false;
		this.aggregating = false;
		this.setLayout(new BorderLayout());	
		this.setBackground(Color.WHITE);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		gui.drawAll(g);
	}
	
	public NJClass findNearestClass(int x, int y) {
		NJClass c;
		//calls a method in vector of boxes to find which box the mouse is inside, then returns that box
		c = gui.clickedInBox(x, y);
		repaint();
		return c;
	}
	
	public void unselectAll() {
		setSelected(null);
		gui.populateEditMenu();
	}
	
	
}
