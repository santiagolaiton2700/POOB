package aplicacion;

import java.awt.Rectangle;
import java.io.Serializable;

public class Raquetas implements Serializable{
	private int x;
	private int y;
	private int width;
	private int height;
	private Rectangle figura;
	private String nombreImg;
	private int distancia = 2; 
	
	public Raquetas(int x, int y, int width, int height, String nombreImg) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.nombreImg = nombreImg;
		this.figura = new Rectangle(x, y, width, height);
	}
	public Rectangle getShape() {
		return figura;
	}
	public void moverDerecha() {
		x+=distancia;
		figura.setLocation(this.x, this.y);
	}
	public int getXPosition() {
		return x;
	}
	public int getDistancia() {
		return distancia;
	}
	public int getWidth() {
		return width;
	}
	public void moverDerecha(int x) {
		this.x += x;
		figura.setLocation(this.x, this.y);
	}
	public void moverIzquierda() {
		x -= distancia;
		figura.setLocation(this.x, this.y);
	}
	
	public void moverIzquierda(int x) {
		this.x -= x;
		figura.setLocation(this.x, this.y);
	}

}
