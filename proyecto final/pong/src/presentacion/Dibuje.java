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
import aplicacion.Raquetas;
/**
 * Esta clase es la encargada de todos los metodos paraa dibujar tablero
 * @author Mary
 *
 */
public class Dibuje extends JPanel{
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
	
	/**
	 * Constructor clase dibuje
	 */
	public Dibuje(int jugadores, int width,int height,String nombre1,String nombre2,String bola) {
		this.jugadores=jugadores;
	 	this.width=width;
		this.height=height;
		this.nombre1=nombre1;
		this.nombre2=nombre2;
		this.bola=bola;
		prepareJuego();
		prepareAcciones();
		prepareMarco();
		//hilos();	
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
		for(Raquetas p:game.getRaquetas()) {
			g2.setColor(Color.green);
			g2.fill(p.getShape());
		}
		g2.setColor(Color.red);
		g2.fill(game.getBola().getShape());
		
	}
	private void hilos() {
		pelota = new Thread() {
			public void run() {
				while (game.getEnJuego()&&(game.getScore1()<=45||game.getScore2()<=45)) {
					movimientosRaquetas();
					game.moverBola();
					try {
						this.sleep(1);
					} catch (InterruptedException e) {
					}
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
			hilos();
		}
		if(id==KeyEvent.VK_P) {
			detenerHilos();
		}
		
	}
	public void detenerHilos() {
		if (game.getEnJuego()) {
			pelota.stop();
			game.setEnJuego();
		} else {
			game.setEnJuego();
			pelota.start();
		}
	}
	}

