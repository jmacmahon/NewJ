package phm1.NewJ;

import java.awt.Graphics;

public class NJInheritance extends NJConnection {
	public NJInheritance(NJClass to){
		super(to);
	}
	public NJInheritance(){}
	
	public void draw (Graphics g, NJClass from){
		super.draw(g, from, true);
		int vertexAX, vertexAY, vertexBX, vertexBY, vertexCX, vertexCY;
		vertexAX = vertexAY = vertexBX = vertexBY = vertexCX = vertexCY = 0;
		
		if(this.getTo() == null){
			//TODO
		} else {
			if(this.getTo().getY() < this.getYFrom() && (this.getTo().getY() + this.getTo().getB()) > this.getYFrom()){
				// Actually hitting the horizontal side
				if(this.getXTo() < this.getXFrom()){
					// Arrow pointing left
					vertexAX = this.getTo().getX() + this.getTo().getA();
					vertexAY = this.getYFrom();

					vertexBX = vertexAX + 10;
					vertexBY = vertexAY - 5;

					vertexCX = vertexAX + 10;
					vertexCY = vertexAY + 5;
				} else {
					// Arrow pointing right
					vertexAX = this.getTo().getX();
					vertexAY = this.getYFrom();

					vertexBX = vertexAX - 10;
					vertexBY = vertexAY + 5;

					vertexCX = vertexAX - 10;
					vertexCY = vertexAY - 5;
				}
			} else if(this.getYTo() < this.getYFrom()){
				// Hitting the bottom
				vertexAX = this.getXTo();
				vertexAY = this.getTo().getY() + this.getTo().getB();

				vertexBX = vertexAX + 5;
				vertexBY = vertexAY + 10;

				vertexCX = vertexAX - 5;
				vertexCY = vertexAY + 10;
			} else {
				// Hitting the top
				vertexAX = this.getXTo();
				vertexAY = this.getTo().getY();

				vertexBX = vertexAX - 5;
				vertexBY = vertexAY - 10;

				vertexCX = vertexAX + 5;
				vertexCY = vertexAY - 10;
			}
		}
		g.drawLine(vertexAX, vertexAY, vertexBX, vertexBY);
		g.drawLine(vertexBX, vertexBY, vertexCX, vertexCY);
		g.drawLine(vertexAX, vertexAY, vertexCX, vertexCY);
	}
}
