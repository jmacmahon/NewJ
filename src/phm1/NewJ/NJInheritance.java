package phm1.NewJ;

import java.awt.Graphics;

public class NJInheritance extends NJConnection {
	NJInheritance(NJClass to){
		super(to);
	}
	NJInheritance(){
		super();
	}
	
	public void draw (Graphics g, NJClass from){
		super.draw(g, from);
		if(from != null){
			
		}
	}
}
