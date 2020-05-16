package aplicacion;

import java.awt.Rectangle;
import java.io.Serializable;

public abstract class Poder implements Serializable{
	protected int x;
	protected int y;
	protected double dx;
	protected Rectangle figura;

	
	
	public void mover() {
		this.x+=dx;
		if(x<200) {
			x=200;
			dx=-dx;
		}
		if(x >= 730) {
			x=730;
			dx=-dx;
		}
		x+=dx;
		figura.setFrame(x,y,50,50);
	}
	
	public boolean impactado(Bola bola) {
		return ( bola.getShape().intersects(figura))? true: false; 
	}



	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}
	public abstract void iniciar(Object o);
	public abstract void detener(Object o);
}
