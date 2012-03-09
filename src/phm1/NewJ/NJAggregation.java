package phm1.NewJ;

import java.awt.*;

public class NJAggregation extends NJConnection {
	private boolean many;
	
	public boolean isMany() {
		return many;
	}
	public void setMany(boolean many) {
		this.many = many;
	}
	public NJAggregation(NJClass to, boolean many){
		super(to);
		this.many = many;
	}
	public NJAggregation(){}

	public void draw(Graphics g, NJClass from){
		super.draw(g,  from, false);

		int vertexAX, vertexAY, vertexBX, vertexBY, vertexCX, vertexCY, vertexDX, vertexDY, textX, textY;
		vertexAX = vertexAY = vertexBX = vertexBY = vertexCX = vertexCY = vertexDX = vertexDY = textX = textY = 0;
		// These go clockwise from the one that touches the box

		if(this.getTo() == null){
			// TODO
		} else if(this.getTo().getY() < this.getYFrom() && (this.getTo().getY() + this.getTo().getB()) > this.getYFrom()){
			// Actually hitting the horizontal side
			if(this.getXTo() < this.getXFrom()){
				// Diamond pointing right
				vertexAX = from.getX();
				vertexAY = this.getYTo();
				
				vertexBX = vertexAX - 5;
				vertexBY = vertexAY + 5;
				
				vertexCX = vertexAX - 10;
				vertexCY = vertexAY;
				
				vertexDX = vertexAX - 5;
				vertexDY = vertexAY - 5;
				
				textX = vertexAX - 40;
				textY = vertexAY - 5;
			} else {
				// Diamond pointing left
				vertexAX = from.getX() + from.getA();
				vertexAY = this.getYTo();
				
				vertexBX = vertexAX + 5;
				vertexBY = vertexAY + 5;
				
				vertexCX = vertexAX + 10;
				vertexCY = vertexAY;
				
				vertexDX = vertexAX + 5;
				vertexDY = vertexAY - 5;
				
				textX = vertexAX + 10;
				textY = vertexAY - 5;
			}
		} else if(this.getYTo() < from.getY()){
			// We are drawing the line coming out of the top of the class box
			vertexAX = this.getXFrom();
			vertexAY = from.getY();

			vertexBX = vertexAX - 5;
			vertexBY = vertexAY - 5;

			vertexCX = vertexAX;
			vertexCY = vertexAY - 10;

			vertexDX = vertexAX + 5;
			vertexDY = vertexAY - 5;
			
			textX = vertexAX + 5;
			textY = vertexAY - 10;
		} else {
			// We are drawing the line coming out of the bottom of the class box
			vertexAX = this.getXFrom();
			vertexAY = from.getY() + from.getB();

			vertexBX = vertexAX - 5;
			vertexBY = vertexAY + 5;

			vertexCX = vertexAX;
			vertexCY = vertexAY + 10;

			vertexDX = vertexAX + 5;
			vertexDY = vertexAY + 5;

			textX = vertexAX + 10;
			textY = vertexAY + 20;
		}

		g.drawLine(vertexAX, vertexAY, vertexBX, vertexBY);
		g.drawLine(vertexBX, vertexBY, vertexCX, vertexCY);
		g.drawLine(vertexCX, vertexCY, vertexDX, vertexDY);
		g.drawLine(vertexDX, vertexDY, vertexAX, vertexAY);
		
		String number;
		if(many)
			number = "0..*";
		else
			number = "0..1";
		g.drawString(number, textX, textY);

		g.setColor(Color.WHITE);
		g.drawLine(vertexAX, vertexAY, vertexCX, vertexCY);
		g.setColor(Color.BLACK);
	}
}
