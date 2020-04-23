package aplicacion;

import java.util.ArrayList;

public class Pong {
	private int width;
	private int heigth;
	private int jugadores;
	private boolean enJuego;
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
		addBola(0, 0, 0.5, 1.7, width, height);
		
	}
	public void addBola(double x,double y,double dx,double dy,int width,int height) {
		if (jugadores==1) {
			bola=new Bola(x,y,dx,dy,width,height);
		}else {
			bola=new Bola(x,y,dx,dy,width,height);
		}
	}
	public void elegirCondicionesJuego(String nombre1,String nombre2) {
		
		addRaquetas(325,655,132,23,nombre1);
		addRaquetas(325,0,132,23,nombre2);
	}
	public void addRaquetas(int x, int y, int width, int height, String nombreImg) {
		raquetas.add(new Raquetas(x,y,width,height,nombreImg));
	}
	public Bola getBola() {
		return bola;
	}
	public void moverBola() {
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
		Raquetas p = raquetas.get(i);
		if (p == null || p.getXPosition() - p.getDistancia() <= 20) {
			raquetas.get(i).moverIzquierda(Math.abs(p.getXPosition() - 20));
			auxMoverAlInicio(p);
			return;
		}
		raquetas.get(i).moverIzquierda();
		auxMoverAlInicio(p);
	}
	
	
	public void auxMoverAlInicio(Raquetas r) {
		
	}
	
}
