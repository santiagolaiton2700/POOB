package aplicacion;
import java.awt.Rectangle;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Timer;
import java.lang.*;

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
	private ArrayList<Raqueta> raquetas;
	private ArrayList<Poder> poderes;
	private ArrayList<Poder> currentPoderes;
	private Timer tiempo;
	private ArrayList<Target>objetivos;
	

	private String[] listaPoderes;
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
		raquetas = new ArrayList<Raqueta>();
		poderes=new ArrayList<Poder>();
		currentPoderes = new ArrayList<Poder>();
		objetivos=new ArrayList<Target>();
		this.estaEnInicio=true;
		this.estaDetenida=false;
		this.color1=nombre1;
		this.color2=nombre2;
		elegirCondicionesJuego(nombre1,nombre2);
		addBola(300, 650, 0.5, 1.2, width, height);

		this.listaPoderes = new String[]{ "Fastball","Freezer","Flash","Turtle","Cold Racket", "Phantom Racket","Energy"};
		
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
		raquetas.add(new Raqueta(x,y,width,height,nombreImg));
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
		//System.out.println("mover Pelota");
		chocaRaquetas();
		//soltarPoder();
		bola.muevePelotaca();
		
	}
	
	public void crearPoder() {
		//int random = (int)(Math.random() * 7 + 1);
		int random =0;
		if(random>=0 && random<8) {
			if (listaPoderes[random].equals("Fastball")) {
				poderes.add(new Fastball(300,300));
			}else if(listaPoderes[random].equals("Freezer")){
				poderes.add(new Freezer(300,300));
			}else if(listaPoderes[random].equals("Energy")) {
				poderes.add(new Energy(300,300));
			}else if(listaPoderes[random].equals("Turtle")) {
				poderes.add(new Turtle(300,300));
			}
				
		}
	}
	public void crearTarget() {
		objetivos.add(new Target(100,30,50,50));
	}
		
	
	
	public int getPoderXPosition(int i) {
		return poderes.get(i).getX();
	}
	
	public int getPoderYPosition(int i) {
		return poderes.get(i).getY();
	}
	
	public int getTargetXPosition() {
		return objetivos.get(0).getX();
	}
	public int getTargetyPosition() {
		return objetivos.get(0).getY();
	}
	public String getPoder(int i) {
		
		var p = poderes.get(i);
		return p.getClass().getName().substring(11,p.getClass().getName().length());
		
	}
	public String getTarget() {
		return objetivos.get(0).getImagen();
	}
	public String getPoderActual(int i) {
		
		var p = currentPoderes.get(i);
		return p.getClass().getName().substring(11,p.getClass().getName().length());
		
	}
	public int getNumPoderes() {
		return poderes.size();
	}

	public int getRaquetaXPosition(int i) {
		return raquetas.get(i).getXPosition();
	}
	
	public int 	getRaquetaYPosition(int i) {
		return raquetas.get(i).getYPosition();
	}
	
	public void moverTodo() {
		moverBola();
		var b= false;
		var f=false;
		for(int i=0;i<poderes.size();i++) {
			if(!b || !f) {
				System.out.println(poderes.get(i).getX()+" "+poderes.get(i).getY()+" "+bola.getX()+" "+bola.getY());
				b = poderImpactado(bola);
				f=targetImpactado(bola);
				if(!b) poderes.get(i).mover();
			}
		}
		
	}
	public boolean targetImpactado(Bola bola) {
		Target t=objetivos.get(0);
		if (objetivos.get(0).TargetImpactado(bola)) {
			t.iniciar(bola);
			return true;
		}
		return false;
	}
	public int getPuntajeRaqueta(int i) {
		return raquetas.get(i).getPuntaje();
	}
	public int getFortalezaRaqueta(int i) {
		return raquetas.get(i).getFortaleza();
	}
	public boolean poderImpactado(Bola bola) {
		int posPoderImpactado = -1;
		for(int i=0;i<poderes.size();i++) {
			if(poderes.get(i).impactado(bola)) {
				posPoderImpactado= i;
			}
		}
		
		if(posPoderImpactado!=-1) {
			Poder p = poderes.get(posPoderImpactado);
			if(getPoder(posPoderImpactado).equals("FastBall")) {
				p.iniciar(bola);
			}else if(getPoder(posPoderImpactado).equals("Freezer")||getPoder(posPoderImpactado).equals("Turtle")){
				if(bola.getQuien().equals("jugador1")) {
					p.iniciar(raquetas.get(1));
				}else {
					p.iniciar(raquetas.get(0));
				}
			}else if(getPoder(posPoderImpactado).equals("Energy")) {
				if(bola.getQuien().equals("jugador1")) {
					p.iniciar(raquetas.get(0));
				}else {
					p.iniciar(raquetas.get(1));
				}
			}
			poderes.remove(posPoderImpactado);
			currentPoderes.add(p);
			return true;
		}
		return false;
		
	}
	public void quitarTarget() {
		objetivos.remove(0);
	}
	
	public void quitarPoder() {
		Poder p = currentPoderes.get(0);
		if(getPoderActual(0).equals("FastBall")) {
			p.detener(bola);
		}else if(getPoderActual(0).equals("Freezer")||getPoderActual(0).equals("Turtle")) {
			if(bola.getQuien().equals("jugador1")) {
				p.detener(raquetas.get(1));
			}else {
				p.detener(raquetas.get(0));
			}
		}
		currentPoderes.remove(0);
	}
	public int getNumCurrentPoderes() {
		return currentPoderes.size();
	}
	public int getSizeTarget() {
		return objetivos.size();
	}
	
	/**
	 * Verifica si la bola se choca con la raqueta , de ser asi rebota en la raqueta
	 */
	private void chocaRaquetas() {
		for(Raqueta r:raquetas) {
			if(bola.getShape().getBounds().intersects(r.getShape())) {
				bola.setQuien(r.getImagen());
				bola.choqueRaqueta(r.getXPosition(),r.getYPosition(),r.getWidth(),r.getHeight());
			}else {
				moverPelotaInicio(salio());
			}
		}
	}
	
	public void auxMoverAlInicio(Raqueta r) {
		
	}
	/**
	 * Mueve la pelota a una posicion especifica despues de que esta alla salido del tablero
	 * @param x  lado del tablero por el que salio la pelota
	 */
	public void moverPelotaInicio(String x) {
		if(x=="arriba") {
			bola.setPosition(476, 650);
		}else if (x=="abajo") {
			bola.setPosition(476, 30);
		}
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

	/**
	 * Indica por donde sale la bola del tablero
	 * @return salio 
	 */
	public String salio() {
		String salio="";
		
		if(bola.getYPosition()>heigth) {
			
			sumarPuntaje("abajo");
			salio="abajo";
		}else if(bola.getYPosition()<0) {
			sumarPuntaje("arriba");
			salio="arriba";
		}
		return salio;
	}
	


	
	/**
	 * Suma el puntaje de cada jugador
	 * @param salio indica por donde salio la bola para saber a quien asignarle el puntaje
	 */
	private void sumarPuntaje(String salio) {
		if(raquetas.get(1).getPuntaje()<=45||raquetas.get(0).getPuntaje()<=45) {
			if (salio=="abajo") {
				raquetas.get(1).setPuntaje(raquetas.get(1).getAvancePuntaje());
			}else if(salio=="arriba") {
				raquetas.get(0).setPuntaje(raquetas.get(0).getAvancePuntaje());
			}
		}
	}
	

	/**
	 * Indica si la bola esta en el inicio
	 * @return estaEnInicio true o false
	 */
	public boolean esta() {
		return estaEnInicio;
	}
	/**
	 * Mueve la raqueta hacia su lado derecho
	 * @param i Raqueta a mover
	 */
	public void moverRaquetaDerecha(int i) {
		Raqueta r=raquetas.get(i);
		if(!r.getBloqueada()) {
			if(r.getXPosition()+ r.getDistancia()>=width-150-r.getWidth()) {
				raquetas.get(i).moverDerecha(Math.abs(r.getXPosition() - (width -150-r.getWidth())));
				auxMoverAlInicio(r);
			}else {
				raquetas.get(i).moverDerecha();}
				r.setFortaleza(1);
		}
	}
	/**
	 * Mueve la raqueta hacia su lado izquierda 
	 * @param i Raqueta a mover
	 */
	public void moverRaquetaIzquierda(int i) {
		Raqueta r = raquetas.get(i);
		if(!r.getBloqueada()) {
			if (r == null || r.getXPosition() - r.getDistancia() <= 200) {
				raquetas.get(i).moverIzquierda(Math.abs(r.getXPosition() - 200));
				auxMoverAlInicio(r);
				return;
			}
			raquetas.get(i).moverIzquierda();
			auxMoverAlInicio(r);
			r.setFortaleza(1);
		}
	}
	/**
	 * 
	 * @param nombreArchivo
	 * @throws PongException
	 */
	public void salvar(String nombreArchivo) throws PongException {
		try {
			ObjectOutputStream archivo=new ObjectOutputStream(new FileOutputStream(nombreArchivo));
			archivo.writeObject(this);
			archivo.close();
		}catch (IOException e) {
			throw new PongException(PongException.NO_GUARDADO);
		}
	}
	
}
