package aplicacion;

import java.awt.Rectangle;
import java.io.Serializable;
/**
 * Las raquetas son las encargadas de hacer rebotar la pelota
 */
public class Raqueta implements Serializable{
	private int x;
	private int y;
	private int width;
	private int height;
	private Rectangle figura;
	private String nombreImg;
	private int distancia;
	private int puntaje;
	private int fortaleza;
	private boolean isBLoqueada;
	private int avancePuntaje;
	/**
	 * Constructor de la clase raquetas
	 * @param x posicion en x
	 * @param y posicioen en y
	 * @param width ancho
	 * @param height alto
	 * @param nombreImg nombre de la imagen
	 */
	public Raqueta(int x, int y, int width, int height, String nombreImg) {
		this.x = x;
		this.y = y;
		this.width = width;
	 	this.height = height;
		this.nombreImg = nombreImg;
		this.figura = new Rectangle(x, y, width, height);
		this.puntaje=0;
		this.fortaleza=10000;
		this.isBLoqueada=false;
		this.distancia=2;
		avancePuntaje=10;
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
	/**
	 * 	Mueve la raqueta cierta distancia a la derecha
	 * @param x distancia que se movera
	 */
	public void moverDerecha(int x) {
		this.x += x;
		figura.setLocation(this.x, this.y);
	}
	/**
	 * Mueve la raqueta a la izquierda
	 */
	public void moverIzquierda() {
		x -= distancia;
		figura.setLocation(this.x, this.y);
	}
	/**
	 * 	Mueve la raqueta cierta distancia a la izquierda
	 * @param x distancia que se movera
	 */
	
	public void moverIzquierda(int x) {
		this.x -= x;
		figura.setLocation(this.x, this.y);
	}
	/**
	 * Retorna altura
	 * @return int height
	 */
	public int getHeight() {
		return height;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public int getFortaleza() {
		return fortaleza;
	}
	public void setFortaleza(int nuevo) {
		fortaleza-=nuevo;
	}
	public void setPuntaje(int nuevo) {
		puntaje+=nuevo;
	}
	public String getImagen() {
		return nombreImg;
	}
	public void setBloqueada() {
		if(isBLoqueada) {
			isBLoqueada=false;
		}else {
			isBLoqueada=true;
		}
	}
	public boolean getBloqueada() {
		return isBLoqueada;
	}
	public void setDistancia(int cambiar) {
		distancia=cambiar;	
	}
	public int getAvancePuntaje() {
		return avancePuntaje;
	}
	public void setAvancePuntaje(int nuevo) {
		avancePuntaje=nuevo;
	}
}
