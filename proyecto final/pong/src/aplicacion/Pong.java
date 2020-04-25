package aplicacion;

import java.util.ArrayList;

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
	public void addBola(double x,double y,double dx,double dy,int width,int height) {
		if (jugadores==1) {
			bola=new Bola(x,y,dx,dy,width,height);
		}else {
			bola=new Bola(x,y,dx,dy,width,height);
		}
	}
	public void elegirCondicionesJuego(String nombre1,String nombre2) {
		
		addRaquetas(476,660,132,23,nombre1);
		addRaquetas(476,20,132,23,nombre2);
	}
	public void addRaquetas(int x, int y, int width, int height, String nombreImg) {
		raquetas.add(new Raquetas(x,y,width,height,nombreImg));
	}
	public Bola getBola() {
		return bola;
	}
	public void moverBola() {
		chocaRaquetas();
		bola.muevePelotaca();
	}
	public ArrayList<Raquetas>getRaquetas() {
		return raquetas;
	}
	public void moverRaquetaDerecha(int i) {
		Raquetas r=raquetas.get(i);
		if(r.getXPosition()+ r.getDistancia()>=width-150-r.getWidth()) {
			raquetas.get(i).moverDerecha(Math.abs(r.getXPosition() - (width -150-r.getWidth())));
			auxMoverAlInicio(r);
		}else {
		raquetas.get(i).moverDerecha();}		
	}
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
	public void setEnJuego() {
		if(enJuego) {
			enJuego=false;
		}else {
			enJuego=true;
		}
	}
	public boolean getEnJuego() {
		return enJuego;
	}
}
