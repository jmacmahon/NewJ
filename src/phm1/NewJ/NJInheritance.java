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
		int vertexAX, vertexAY, vertexBX, vertexBY, vertexCX, vertexCY;
		vertexAX = vertexAY = vertexBX = vertexBY = vertexCX = vertexCY = 0;
		
		// TODO For fuck's sake put all of this shit in java.awt.Point objects... - J
		if(this.getTo() == null){
			//TODO
		} else {
			if(this.isHorizontal()){
				// Vertical
				if(this.getyTo() < this.getyFrom()){
					vertexAX = this.getxTo();
					vertexAY = this.getTo().getY() + this.getTo().getB();
					
					vertexBX = this.getxTo() + 5;
					vertexBY = this.getTo().getY() + this.getTo().getB() + 10;
					
					vertexCX = this.getxTo() - 5;
					vertexCY = this.getTo().getY() + this.getTo().getB() + 10;
				}
			}
		}
		g.drawLine(vertexAX, vertexAY, vertexBX, vertexBY);
		g.drawLine(vertexBX, vertexBY, vertexCX, vertexCY);
		g.drawLine(vertexAX, vertexAY, vertexCX, vertexCY);
	}
}
