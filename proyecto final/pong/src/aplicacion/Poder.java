package aplicacion;

import java.awt.Rectangle;
import java.io.Serializable;

public abstract class Poder implements Serializable{
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected Rectangle figura;
	protected String imagen;
	protected boolean esVivo;
	protected int tipo;
	public static Poder CrearPoder (int x,int y, int width,int heigth,int llave) {
		Poder poderReturn = null;
		switch (llave) {
		case 1: {
			poderReturn=new AumentarVelocidad(x,y,width,heigth,llave);
		}
	}
		return poderReturn;
	}
	public abstract String getImagen();
	
	public abstract void activarPoder(Pong game ,int indice);
	
	//public Rectangle getShape() {
		//return figura;
	//}
	public void descender() {
		y+=1;
		figura.setLocation(this.x, this.y);
	}
	public int getYPositon() {
		return y;
	}
	public boolean esVivo() {
		return esVivo;
	}
	public abstract Rectangle getShape();
	public abstract void quitarPoder(Pong game,int indice);
}
