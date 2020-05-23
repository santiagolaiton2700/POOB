package presentacion;

import java.awt.*;


import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.AbstractAction;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

import javax.imageio.ImageIO;
import javax.swing.*;

import aplicacion.Pong;
import aplicacion.Raqueta;
/**
 * Esta clase es la encargada de todos los metodos paraa dibujar tablero
 * @author Mary
 *
 */
public class Boceto extends JPanel{
	private Pong game;
	private int width;
	private int height;
	private int jugadores;
	private Image fondoPuntos;
	private Image cancha;
	private Thread pelota;
	private String recursos="src/Recursos/";
	private String nombre1,nombre2;
	private String bola;
	private boolean moverRightAbajo;
	private boolean moverLeftAbajo;
	private boolean moverRightArriba;
	private boolean moverLeftArriba;
	private boolean pausa = false;
	private boolean bloquearP = false;
	private boolean bloquearEsc = false;
	
	/**
	 * Constructor clase bosquejo
	 */
	public Boceto(int jugadores, int width,int height,String nombre1,String nombre2,String bola) {
		this.jugadores=jugadores;
	 	this.width=width;
		this.height=height;
		this.nombre1=nombre1;
		this.nombre2=nombre2;
		this.bola=bola;
		prepareJuego();
		prepareAcciones();
		prepareMarco();
	}
	/**
	 * Crea un nuevo pong
	 */
	private void prepareJuego() {
		game = new Pong(600 + width / 5, height, jugadores, nombre1, nombre2);
	}
	/** 
	 * Prepara los elementos necesario para el diseño del marco
	 */
	private void prepareMarco() {
		try {
			fondoPuntos = ImageIO.read(new File("src/Recursos/fondo.png"));
		}catch (IOException e) {
			System.out.println("La imagen no se encuentra");
		}
	}
	/** 
	 * Retorna imagen
	 * @param objeto
	 */
	private Image generarImagen(String objeto) {
		return new ImageIcon(recursos+objeto).getImage();
	}
	/**
	 * Dibuja
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		g2.drawImage(fondoPuntos, 0, 0, null);
		/*
		for(Raqueta p:game.getRaquetas()) {
			g2.setColor(Color.green);
			g2.fill(p.getShape());
		}*/
		
		for(int i=0;i<2;i++) {
			//no olvidar cambiar nombre
			//System.out.println("go to draw raqueta");
			g2.drawImage(generarImagen("personaje.png"),game.getRaquetaXPosition(i),game.getRaquetaYPosition(i),120,60,this);
		}
		g2.setColor(Color.red);
		//g2.fill(game.getBola().getShape());
		g2.drawImage(generarImagen("bolaUno.png"),game.getBola().getXPosition(),game.getBola().getYPosition(),this);
		
		for(int i=0;i<game.getNumPoderes();i++) {
			//System.out.println("go to draw poder");
			g2.drawImage(generarImagen(game.getPoder(i)+".gif"),game.getPoderXPosition(i),game.getPoderYPosition(i),50,50,this);
		}
		dibujarElementosJugadorDos(g2);
		
	}
	private void hilos() {
		//game.quitarPoder();
		pelota = new Thread() {
			public void run() {
				Long startTime = System.currentTimeMillis();
				Long quitarPoderTime = System.currentTimeMillis();
				System.out.println(game.getEnJuego()&&(game.getPuntajeRaqueta(1)<=45 && game.getPuntajeRaqueta(0)<=45 ));
				while (game.getEnJuego()&&(game.getPuntajeRaqueta(1)<=45 && game.getPuntajeRaqueta(0)<=45 )) {
					//System.out.println("Jugando");
					
		
					game.moverTodo();
					
					try {
						this.sleep(5);
					} catch (InterruptedException e) {
					}
					if((System.currentTimeMillis() - startTime)>20000 ) {
						
						System.out.println("Poder generador");
						game.crearPoder();
						
						startTime = System.currentTimeMillis();
						quitarPoderTime = System.currentTimeMillis();
						
					}
					
					repaint();
					if((game.getNumCurrentPoderes()>0) && ((System.currentTimeMillis() - startTime)>10000) ) {
						System.out.println("quitar poder");
						game.quitarPoder();
						quitarPoderTime = System.currentTimeMillis();
						
					}
					
					movimientosRaquetas();
					repaint();
				}
			}
		};
		pelota.start();
	}
	/** 
	 * Llama a los metodos necesarios para mover las raquetas
	 */
	private void movimientosRaquetas() {
		if(moverRightAbajo) {
			game.moverRaquetaDerecha(0);
		}
		if (moverRightArriba) {
			game.moverRaquetaDerecha(1);
		}
		if(moverLeftAbajo) {
			game.moverRaquetaIzquierda(0);
		}
		if(moverLeftArriba) {
			game.moverRaquetaIzquierda(1);
		}
	}
	/**
	 * Prepara las acciones para mover las raquetas
	 */
	private void prepareAcciones() {
		setFocusable(true);
		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "right1down");
		getActionMap().put("right1down", new AbstractAction() {
			public void actionPerformed(ActionEvent arg0) {
				moverRightAbajo = true;				
			}
			
		});
		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "right1up");
		getActionMap().put("right1up", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				moverRightAbajo = false;
			}
		});
		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "left1down");
		getActionMap().put("left1down", new AbstractAction() {
			public void actionPerformed(ActionEvent arg0) {
				moverLeftAbajo = true;				
			}
		});

		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "left1up");
		getActionMap().put("left1up", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				moverLeftAbajo = false;
			}
		});
		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "r1down");
		getActionMap().put("r1down", new AbstractAction() {
			public void actionPerformed(ActionEvent arg0) {
				moverRightArriba = true;				
			}
		});
		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "r1up");
		getActionMap().put("r1up", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				moverRightArriba = false;
			}
		});
		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "l1down");
		getActionMap().put("l1down", new AbstractAction() {
			public void actionPerformed(ActionEvent arg0) {
				moverLeftArriba = true;				
			}
		});

		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "l1up");
		getActionMap().put("l1up", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				moverLeftArriba = false;
			}
		});
		
		addKeyListener(new KeyAdapter() {
			
			public void keyTyped(KeyEvent e) {
				moverJuego(e);
			}

			public void keyReleased(KeyEvent e) {
				
			}
			
			public void keyPressed(KeyEvent e) {
				moverJuego(e);
			}
		});	
	}
	/**
	 * Mueve el juego
	 */
	private void moverJuego(KeyEvent e) {
		int id=e.getKeyCode();
		
		if(id==KeyEvent.VK_SPACE) {
			if(!bloquearEsc) {
				hilos();
				setBloquearP();
			}
		}
		if(id==KeyEvent.VK_P) {
			if(!bloquearP) {
				detenerHilos();
				cambiarPausa();
			}
			
		}
		
	}
	public void setBloquearP() {
		if(bloquearP) {
			bloquearP=false;
		}else {
			bloquearP=true;
		}
	}
	
	private void cambiarPausa() {
		if(pausa) {
			pausa=false;
		}else {
			pausa=true;
		}
	}
	
	public void detenerHilos() {
		if (game.getEnJuego()) {
			pelota.stop();
			game.setEnJuego();
		} else if(!game.getEnJuego()){
			game.setEnJuego();
			pelota.start();
		}
	}
	private void dibujarElementosJugadorDos(Graphics2D g) {
			Font puntos =new Font("Serif",Font.BOLD,25);
			g.setFont(puntos);
			g.setColor(Color.BLUE);
			g.drawString("Score J2 :", 750, 40);
			g.drawString("Fortaleza J2 :", 10, 40);
			g.setColor(Color.magenta);
			g.drawString("Score J1 :", 750, 680);
			g.drawString("Fortaleza J1 :", 10, 680);
			g.setColor(Color.blue);
			g.drawString(Integer.toString(game.getPuntajeRaqueta(1)),860,40);
			g.drawString(Integer.toString(game.getFortalezaRaqueta(1)),160,40);
			g.setColor(Color.magenta);
			g.drawString(Integer.toString(game.getPuntajeRaqueta(0)),860,680);
			g.drawString(Integer.toString(game.getFortalezaRaqueta(0)),160,680);
	}
	
}

