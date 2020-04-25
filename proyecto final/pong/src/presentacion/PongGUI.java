package presentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class PongGUI extends JFrame{
	private JPanel panelPantalla;
	private JButton botonJugar,botonCargar,botonImportar,botonConfiguracion,botonSalir,cpuVsCpu,twoPlayer,playerVsCPU,volver;
	private ImageIcon inicio =new ImageIcon("src/Recursos/inicio.png");;
	private String maquina;
	private MenuConfiguracion configuracion;
	private PantallaJuego  PJuego;
	private String color1 = "hola";
	private String color2 = "chao";
	private String bola = "bolaGris.gif";
	public PongGUI(){
		super("PONG GAME");
		setResizable(false);
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = screenSize.width/2;
		int alto = screenSize.height/2 + screenSize.height/10 ;
		setBounds((screenSize.width - ancho) / 2, (screenSize.height - alto) / 2, 960, 670);
		prepareElementos();
		prepareAcciones();
	}
	public static void main(String[] args) {
		PongGUI pantallaPrincipal  = new PongGUI();
		pantallaPrincipal.setVisible(true);
		
	}
	public void prepareElementos() {
		getContentPane().setLayout(null);
		
		botonJugar=new JButton("");
		ImageIcon icono=new ImageIcon("src/Recursos/jugar.png");
		botonJugar.setIcon(icono);
		botonJugar.setBounds(110, 500, 200, 50);
		getContentPane().add(botonJugar);
		
		botonCargar=new JButton("");
		ImageIcon icono2=new ImageIcon("src/Recursos/cargar.png");
		botonCargar.setIcon(icono2);
		botonCargar.setBounds(110, 580, 230, 50);
		getContentPane().add(botonCargar);
		
		botonImportar=new JButton("");
		ImageIcon icono3=new ImageIcon("src/Recursos/importar.png");
		botonImportar.setIcon(icono3);
	 	botonImportar.setBounds(350, 430, 230, 50);
		getContentPane().add(botonImportar);
		
		botonConfiguracion=new JButton("");
		ImageIcon icono4=new ImageIcon("src/Recursos/configuracion.png");
		botonConfiguracion.setIcon(icono4);
		botonConfiguracion.setBounds(350, 500, 230, 50);
		getContentPane().add(botonConfiguracion);
		
		botonSalir=new JButton("");
		ImageIcon icono5=new ImageIcon("src/Recursos/salir.png");
		botonSalir.setIcon(icono5);  
		botonSalir.setBounds(350, 570, 230, 50);
		getContentPane().add(botonSalir);
		
		panelPantalla=new JPanel();
		panelPantalla.setBounds(0, -10, 953, 651);
		JLabel fondo=new JLabel(inicio);
		panelPantalla.add(fondo);
		getContentPane().add(panelPantalla);
		
	}
	public void prepareAcciones() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                salir();
            }
        });
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
			});
		botonJugar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					prepareElementosjugar();
				}				
			});
		botonCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//abrir();
				}
			});
	        
	        botonImportar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//importar();
				}
			});
	        
	        botonConfiguracion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//configuracion();
				}
			});  
	}
	private void salir() {
		int siNo = JOptionPane.showConfirmDialog(null, "Esta seguro que desea salir?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
		if (siNo == 0) {
			System.exit(0);
		} 		
	}
	private void prepareElementosjugar() {
		refresque();
		cpuVsCpu=new JButton("");
		cpuVsCpu.setBounds(110, 410, 200, 50);
		getContentPane().add(cpuVsCpu);
		ImageIcon icono=new ImageIcon("src/Recursos/CpuVsCpu.png");
		cpuVsCpu.setIcon(icono);  
		
		twoPlayer=new JButton("");
		twoPlayer.setBounds(650, 410, 200, 50);
		getContentPane().add(twoPlayer);
		ImageIcon icono1=new ImageIcon("src/Recursos/dosJugadores.png");
		twoPlayer.setIcon(icono1); 
		
		playerVsCPU=new JButton("");
		playerVsCPU.setBounds(380, 410, 200, 50);
		getContentPane().add(playerVsCPU);
		ImageIcon icono2=new ImageIcon("src/Recursos/jugadorVScpu.png");
		playerVsCPU.setIcon(icono2); 
		
		volver=new JButton("");
		volver.setBounds(380, 510, 200, 50);
		getContentPane().add(volver);
		ImageIcon icono3=new ImageIcon("src/Recursos/volver.png");
		volver.setIcon(icono3); 
		
		getContentPane().add(panelPantalla);
		prepareAccionesJuego();
		
	}
	public void prepareAccionesJuego() {
		twoPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 iniciarJuego(1);
				
			}
		});
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}					
		});
	}
private void volver() {
		
		botonSalir.setVisible(true);
		botonJugar.setVisible(true);
		botonCargar.setVisible(true);
		botonImportar.setVisible(true);
		botonConfiguracion.setVisible(true);
		cpuVsCpu.setVisible(false);
		twoPlayer.setVisible(false);
		playerVsCPU.setVisible(false);
		volver.setVisible(false);
		
	}
	private void refresque() {
		//this.removeAll();
		botonSalir.setVisible(false);
		//getContentPane().remove(botonSalir);
		botonJugar.setVisible(false);
		//getContentPane().remove(botonJugar);
		botonCargar.setVisible(false);
		//getContentPane().remove(botonCargar);
		botonImportar.setVisible(false);
		
		botonConfiguracion.setVisible(false);
		
		this.revalidate();
	}
	private void configuracion() {
		configuracion= new MenuConfiguracion(this);
		configuracion.setVisible(true);
	}
	
	private void iniciarJuego(int i) {
		dispose();
		PJuego=new PantallaJuego(i,color1,color2,true,bola);
		PJuego.setVisible(true);
	}
}