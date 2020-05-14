package aplicacion;

import java.awt.Rectangle;
import java.io.Serializable;

public abstract class Bloque implements Serializable {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected Rectangle figura;
	
	
	
	public Rectangle getShape() {
		return figura;
	} 
	public int getXPosition() {
		return x;
	}
	public int getYPosition() {
		return y;
	}
	public void setPosition(int x, int y) {
		this.x=x;
		this.y=y;
		figura.setLocation(this.x, this.y);
	}
}
