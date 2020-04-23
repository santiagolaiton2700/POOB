package presentacion;

import java.awt.*;

import javax.swing.*;

public class PantallaJuego extends JFrame {
	private Dibuje dibuje;
	private int jugadores;
	private String nombre1,nombre2,bola;
	
	
	public PantallaJuego(int jugadores,String nombre1,String nombre2,boolean configuracion,String bola) {
		super("PONG GAME");
		this.jugadores=jugadores;
		this.nombre1=nombre1;
		this.nombre2=nombre2;
		this.bola=bola;
		prepareElementos();
	}
	private void prepareElementos() {
		setTitle("Pong Game");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = screenSize.width;
		int alto = screenSize.height;
		this.setLayout(new GridLayout(1,3));
		dibuje=new Dibuje(jugadores,ancho,alto,nombre1,nombre2,bola);
		dibuje.setBackground(Color.white);
		add(dibuje);
		setResizable(false);
		this.setBounds(0, 0, 651, 953);
		
	}
}
