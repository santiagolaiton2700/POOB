package aplicacion;

import java.util.ArrayList;
/**
 * Esta es la clase principal ,encargada de delegar las acciones del juego 
 * @author Santiago Laiton - Lina Buitrago
 * @version 1.0 Abril 24 de 2020
 */

public class Pong {
	private int width;
	private int heigth;
	private int jugadores;
	private boolean enJuego=true;
	private boolean estaEnInicio;
	private boolean estaDetenida;
	private String color1,color2;
	private Bola bola;
	private String bolaString;
	private ArrayList<Raquetas> raquetas;
	/**
	 * Constructor del juego PONG
	 * @param width Ancho del tablero
	 * @param height Alto del tablero
	 * @param jugadores Número de jugadores del juego
	 * @param nombre1 Nombre de la raqueta 1
	 * @param nombre2 Nombre de la raqueta 2
	 */
	public Pong(int width,int height,int jugadores,String nombre1, String nombre2) {
		this.width=width;
		this.heigth=height;
		this.jugadores=jugadores;
		this.enJuego=true;
		raquetas = new ArrayList<Raquetas>();
		this.estaEnInicio=true;
		this.estaDetenida=false;
		this.color1=nombre1;
		this.color2=nombre2;
		elegirCondicionesJuego(nombre1,nombre2);
		addBola(300, 650, 0.5, 1.2, width, height);
		
	}
	/**
	 * Añade una bola basada en parametros
	 * @param x posicion en x
	 * @param y posicion en y 
	 * @param dx distancia de mover en x
	 * @param dy distancia de mover en y
	 * @param width ancho del tablero
	 * @param height alto del tablero
	 */
	public void addBola(double x,double y,double dx,double dy,int width,int height) {
		if (jugadores==1) {
			bola=new Bola(x,y,dx,dy,width,height);
		}else {
			bola=new Bola(x,y,dx,dy,width,height);
		}
	}
	/**
	 * Este metodo elige las condiciones del juego, por ahora solo añade raquetas
	 * @param nombre1 Nombre plataforma 1
	 * @param nombre2 Nombre plataforma 2
	 */
	public void elegirCondicionesJuego(String nombre1,String nombre2) {
		
		addRaquetas(476,660,132,23,nombre1);
		addRaquetas(476,20,132,23,nombre2);
	}
	/**
	 * Añade raquetas 
	 * @param x posicion en x
	 * @param y posicion en y 
	 * @param width ancho
	 * @param height alto
	 * @param nombreImg nombre de la imagen
	 */
	public void addRaquetas(int x, int y, int width, int height, String nombreImg) {
		raquetas.add(new Raquetas(x,y,width,height,nombreImg));
	}
	/**
	 * Retorna una bola de la clase bola
	 * @return bola
	 */
	public Bola getBola() {
		return bola;
	}
	/**
	 * Mueve la bola de un lado al otro del tablero 
	 */
	public void moverBola() {
		chocaRaquetas();
		bola.muevePelotaca();
	}
	/**
	 * Retorna un ArrayList de raquetas
	 * @return raquetas
	 */
	public ArrayList<Raquetas>getRaquetas() {
		return raquetas;
	}
	/**
	 * Mueve la raqueta hacia su lado derecho
	 * @param i Raqueta a mover
	 */
	public void moverRaquetaDerecha(int i) {
		Raquetas r=raquetas.get(i);
		if(r.getXPosition()+ r.getDistancia()>=width-150-r.getWidth()) {
			raquetas.get(i).moverDerecha(Math.abs(r.getXPosition() - (width -150-r.getWidth())));
			auxMoverAlInicio(r);
		}else {
		raquetas.get(i).moverDerecha();}		
	}
	/**
	 * Mueve la raqueta hacia su lado izquierda 
	 * @param i Raqueta a mover
	 */
	public void moverRaquetaIzquierda(int i) {
		Raquetas r = raquetas.get(i);
		if (r == null || r.getXPosition() - r.getDistancia() <= 200) {
	 		raquetas.get(i).moverIzquierda(Math.abs(r.getXPosition() - 200));
			auxMoverAlInicio(r);
			return;
		}
		raquetas.get(i).moverIzquierda();
		auxMoverAlInicio(r);
	}
	/**
	 * Verifica si la bola se choca con la raqueta , de ser asi rebota en la raqueta
	 */
	private void chocaRaquetas() {
		for(Raquetas r:raquetas) {
			if(bola.getShape().getBounds().intersects(r.getShape())) {
				bola.choqueRaqueta(r.getXPosition(),r.getYPosition(),r.getWidth(),r.getHeight());
			}else {
				//System.out.println(bola.getYPosition());
			}
		}
	}
	
	public void auxMoverAlInicio(Raquetas r) {
		
	}
	public void moverPelotaInicio() {	
		
	}
	/**
	 * Cambia el estado del juego
	 */
	public void setEnJuego() {
		if(enJuego) {
			enJuego=false;
		}else {
			enJuego=true;
		}
	}
	/**
	 * Retorna si actualmente esta en juego
	 * @return enJuego
	 */
	public boolean getEnJuego() {
		return enJuego;
	}
}
