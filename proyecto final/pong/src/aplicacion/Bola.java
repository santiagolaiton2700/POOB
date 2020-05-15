package aplicacion;


import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
/**
 * Es la pelota o bola que rebota de lado a lado en las raquetas
 */

public class Bola {
	private static final int TAMX=22;
	private static final int TAMY=22;
	private double x;
	private double y;
	private double dx;
	private double dy;
	private double dy0;
	private double dx0;
	private Ellipse2D figura;
	private int width;
	private double height;
	private boolean isFast=false;
	private boolean isSlow=false;
	private boolean diagonal = false;
	private boolean salio = false;
	/**
	 *  Constructor de la clase bola
	 * @param x posicion en x
	 * @param y posicion en y
	 * @param dx distancia que se mueve en x
	 * @param dy distancia que se mueve en y
	 * @param width ancho tablero
	 * @param height alto tablero
	 */
	public Bola(double x, double y, double dx, double dy, int width, int height) {
		this.x=x;
		this.y=y;
		this.dx=dx;
		this.dy=dy;
		this.dx0=dx;
		this.dy0=dy;
		this.width=width;
		this.height=height;
		figura=new Ellipse2D.Double(x, y, TAMX, TAMY);
		
		
	}
	/**
	 * Mueve la pelota en los limites del tablero
	 */
	public void muevePelotaca() {
		x+=dx;
		y-=dy;
		if(x<200) {
			x=200;
			dx=-dx;
		}
		if(x+TAMX >=750) {
			x=750-TAMX;
			dx=-dx;
		}
		/*
		if(y<20) {
			y=20;
			dy=-dy;
		}
		if(y>650) {
			y=650;
			dy=-dy;
		}
		*/
		figura.setFrame(x,y,TAMX, TAMY);
	}
	/**
	 * Cambia la posicion en x de la bola
	 * @param x Posicion a cambiar
	 */
	public void setXPosition(int x) {
		this.x=x;
		figura.setFrame(this.x,this.y,TAMX,TAMY);
	}
	/**
	 * Cambia posicion en x
	 * @param x nueva posicion
	 */
	public void cambiePosition(int x) {
		this.x += x;
		figura.setFrame(this.x , this.y, TAMX, TAMY);
	}
	/**
	 * Retorna la figura de la pelota
	 * @return figura (elipse)
	 */
	public Ellipse2D getShape(){
		return figura; 
	}
	/**
	 * Retorna posicion en y de la bola
	 * @return  y es posicion en y
	 */
	public int getYPosition() {
		return (int) y;
	}
	public int getXPosition() {
		return (int) x;
	}
	/**
	 * Hace rebotar la pelota en las raquetas
	 * @param xPos posicion en x de la raqueta
	 * @param yPos posicion en y de la raqueta
	 * @param width ancho
	 * @param height alto
	 */
	public void choqueRaqueta(int xPos,int yPos,int width,int height) {
		Rectangle r=new Rectangle(xPos,yPos,width,height/9);
		if(figura.intersects(r)) {
			dy=-dy;
		}
	
	}
	/**
	 * Cambia la posicion de la bola 
	 * @param x posicion en x a cambiar
	 * @param y posicion en y a cambiar
	 */
	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
		figura.setFrame(x , y, TAMX, TAMY);
	}
	public void aumentarVelocidad(double multiplicidad) {
		if (isSlow) {
			dx = dx * multiplicidad;
			dy = dy * multiplicidad;
			dx0 = dx0 * multiplicidad;
			dy0 = dy0 * multiplicidad;
			isSlow = false;
		}
		if (!isFast) {
			int signo = 1;
			if (dy > 0) signo = 1;
			if (dy < 0) signo = -1;
			if (dx > 0) signo = 1;
			if (dx < 0) signo = -1;
			dy = dy * multiplicidad ;
			dx = dx * multiplicidad ;
			dx0 = dx0 * multiplicidad;
			dy0 = dy0 * multiplicidad;
			isFast = true;
			isSlow = false;
		}
	}
	public void disminuirVelocidad(double multiplicidad) {
		if (isFast) {
			dx = dx / multiplicidad;
			dy = dy / multiplicidad;
			dx0 = dx0 / multiplicidad;
			dy0 = dy0 / multiplicidad;
			isFast = false;
		}
		if (!isSlow) {
			int signo = 1;
			if (dy > 0) signo = 1;
			if (dy < 0) signo = -1;
			if (dx > 0) signo = 1;
			if (dx < 0) signo = -1;
			dx = dx / multiplicidad ;
			dy = dy / multiplicidad ;
			dx0 = dx0 / multiplicidad;
			dy0 = dy0 / multiplicidad;
			isSlow = true;
		}
	}
	public double getDx() {
		return dx;
	}
	public void setDx(double dx) {
		this.dx = dx;
	}
	public double getDy() {
		return dy;
	}
	public void setDy(double dy) {
		this.dy = dy;
	}
	public double getDy0() {
		return dy0;
	}
	public void setDy0(double dy0) {
		this.dy0 = dy0;
	}
	public double getDx0() {
		return dx0;
	}
	public void setDx0(double dx0) {
		this.dx0 = dx0;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	

	
}
