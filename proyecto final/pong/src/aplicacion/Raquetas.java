package aplicacion;

import java.awt.Rectangle;
import java.io.Serializable;
/**
 * Las raquetas son las encargadas de hacer rebotar la pelota
 */
public class Raquetas implements Serializable{
	private int x;
	private int y;
	private int width;
	private int height;
	private Rectangle figura;
	private String nombreImg;
	private int distancia = 2; 
	/**
	 * Constructor de la clase raquetas
	 * @param x posicion en x
	 * @param y posicioen en y
	 * @param width ancho
	 * @param height alto
	 * @param nombreImg nombre de la imagen
	 */
	public Raquetas(int x, int y, int width, int height, String nombreImg) {
		this.x = x;
		this.y = y;
		this.width = width;
	 	this.height = height;
		this.nombreImg = nombreImg;
		this.figura = new Rectangle(x, y, width, height);
	}
	/**
	 * Retorna la figura de la raqueta
	 * @return figura ( rectangulo)
	 */
	public Rectangle getShape() {
		return figura;
	}
	/**
	 * Mueve la raqueta a la derecha
	 */
	
	public void moverDerecha() {
		x+=distancia;
		figura.setLocation(this.x, this.y);
	}
	/**
	 * Retorna posicion en x de la raqueta
	 * @return int x
	 */
	public int getXPosition() {
		return x;
	}
	/**
	 * Retorna posicion en y de la raqueta
	 * @return int 
	 */
	public int getYPosition() {
		return y;
	}
	/**
	 * Retorna la distancia que se mueven las raquetas
	 * @return int x
	 */
	public int getDistancia() {
		return distancia;
	}
	/** 
	 * Retorna el tamaño
	 * @return int width
	 */
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
	public int getHeight() {
		return height;
	}
	
}
