package presentacion;

import java.awt.*;

import javax.swing.*;
/**
 * Esta clase crea la pantalla de juego 
 * @author Santiago Laiton - Lina Buitrago
 * @version 1.0 Abril 24 de 2020
 */
public class PantallaJuego extends JFrame {
	private Boceto dibuje;
	private int jugadores;
	private String nombre1,nombre2,bola;
	
	/**
	 * Constructor de la clase PantallaJuego
	 * @param jugadores numero de jugadores
	 * @param nombre1 nombre raqueta 1
	 * @param nombre2 nombre raqueta 2
	 * @param configuracion
	 * @param bola bola en juego
	 */
	public PantallaJuego(int jugadores,String nombre1,String nombre2,boolean configuracion,String bola) {
		super("PONG GAME");
		this.jugadores=jugadores;
		this.nombre1=nombre1;
		this.nombre2=nombre2;
	 	this.bola=bola;
		prepareElementos();
	}
	/** 
	 * Prepara los elementos necesarios para crear la pantalla de juego(dimensiones, titulos, tama�os)
	 */
	private void prepareElementos() {
		setTitle("Pong Game");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = screenSize.width;
		int alto = screenSize.height;
		this.setLayout(new GridLayout(1,3));
		dibuje=new Boceto(jugadores,ancho,alto,nombre1,nombre2,bola);
		dibuje.setBackground(Color.white);
		add(dibuje);
		//setResizable(false);
		this.setBounds(0, 0,953,750);
	}
}
