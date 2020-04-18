package presentacion;
import aplicacion.MarbelGame;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;
import java.util.*;
/**
 * Esta clase permite crear la capa de presentacion de juego MarbelGame
 * @author Lina Buitrago - Santiago Laiton
 * @version 1.0 17 de Abril 2020
 */
public class MarbelGUI extends JFrame{
	private Container contentPane;
	private JPanel opciones;
	private JPanel controles;
	private JPanel tablero;	
	private JMenuBar options;
	private JMenu menu;
	private JMenuItem opcionNuevo;
	private JMenuItem opcionAbrir;
	private JMenuItem opcionSalvar;
	private JMenuItem opcionSalvarComo;
	private JMenuItem opcionSalir;
	private JMenuItem cambioColor;
	private JButton arriba;
	private JButton abajo;
	private JButton derecha;
	private JButton izquierda;
	private GridLayout cuadrados;
	private int tamano=4;
	private Color color;
	private MarbelGame marbel;
	private int [][] matriz;
	/**
     * Crea un marco para el juego MarbelGame
     */
	public MarbelGUI() {
		marbel=new MarbelGame(4,4,1);
		color = Color.BLUE;
		prepareElementos();
		prepareAcciones();
		
	}
	/**
     * Prepara los elementos necesarios para la implementacio del juego
     */
	public void prepareElementos() {
		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		setTitle("MarbelGame");
		definirTamano();
		centrar();
		opciones=new JPanel();
		controles=new JPanel();
		tablero=new JPanel();
		contentPane.add(opciones,BorderLayout.NORTH);
		contentPane.add(tablero,BorderLayout.CENTER);
		contentPane.add(controles, BorderLayout.EAST);
		opciones.setLayout(new GridLayout(1,3));
		controles.setLayout(new BorderLayout());
		prepareElementosMenu();
		prepareElementosTablero();
	}
	/**
     * Prepara los elementos para los botones del menu del juego 
     */
	public void prepareElementosMenu() {
		options = new JMenuBar();
		menu = new JMenu("Archivo");
		opcionNuevo =  new JMenuItem("Nuevo"); 
		opcionAbrir =  new JMenuItem("Abrir"); 
		opcionSalvar =  new JMenuItem("Guardar");
		cambioColor=new JMenuItem("CambioColor");
		opcionSalvarComo =  new JMenuItem("Guardar Como"); 
		opcionSalir =  new JMenuItem("Salir");  
		menu.add(opcionNuevo);
		menu.add(cambioColor);
		menu.add(opcionAbrir);
		menu.add(opcionSalvar);
		menu.add(opcionSalvarComo);
		menu.add(opcionSalir);
		options.add(menu);
		opciones.add(options);
	}
	/**
     * Prepara los metodos que atienden los botones
     */
	public void prepareAcciones() {
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { 
				salga();
			}
		});
		/**Salga*/
		opcionSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salga();
			}
		});
		/**Salvar*/
		opcionSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		/**Abrir Archivo*/
		opcionAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirArchivo();
			}
		});
		/**Abajo*/
		abajo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moverAbajo();
			}
		});
		/**Arriba*/
		arriba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//moverArriba();
			}
		});
		/**Derecha*/
		derecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//moverDerecha();
			}
		});
		/**Izquierda*/
		izquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//moverIzquierda();
			}
		});
		/**Cambiar color*/
		cambioColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambioColor();
			}
		});
		
	}
	/**
     * Prepara los elementos del tablero
     */
	public void prepareElementosTablero() {
		ponerBotones();
		ponerTablero();
	}
	/**
     * Crea los botones necesarios para el juego
     */
	public void ponerBotones() {
		arriba=new JButton("Arriba");
		abajo  = new JButton("Abajo");
		derecha = new JButton("Derecha");
		izquierda = new JButton("Izquierda");
		controles.add(arriba,BorderLayout.NORTH);
		controles.add(abajo,BorderLayout.WEST);
		controles.add(derecha,BorderLayout.EAST);
		controles.add(izquierda,BorderLayout.SOUTH);
	}
	/**
     * Crea lo necesario para implementar el tablero
     */
	public void ponerTablero() {
		cuadrados=new GridLayout(tamano,tamano,5,5);
		tablero=new JPanel(cuadrados);
		this.add(tablero);
		tablero.setBackground(Color.blue);
		dibujarTablero();
	}
	/**
     * Dibuja el tablero
     */
	public void dibujarTablero() {
		matriz=new int [tamano][tamano];
		matriz=marbel.getMatriz();
		for (int i=0;i<tamano;i++) {
			for(int j=0;j<tamano;j++) {
				if(matriz[i][j]!=0) {
					if(matriz[i][j]==1) {
						tablero.add(new Canicas(Color.RED,true,true,'1','0'));
					}else if(matriz[i][j]==2) {
						tablero.add(new Canicas(Color.GREEN,false,true,'2','2'));
					}else if(matriz[i][j]==3) {
						tablero.add(new Canicas(Color.magenta,true,true,'3','3'));
					}
				
				}else {
					tablero.add(new Canicas(Color.BLUE,false,false,'0','0'));
				}
			}
		}
		
	}
	/**
     * Cambia el color del  tablero y sus componentes
     */
	private void cambioColor() {
		Color colorp = JColorChooser.showDialog(null,"Change Marbel Color",color);
		if (colorp!=null && colorp!=Color.BLACK) {
			color=colorp;
			pintarCanicas();
		}
	}
	/**
     * pinta las canicas sobre el tablero
     */
	private void pintarCanicas() {
		Canicas c;
		for (int i=0;i<tamano*tamano;i++) {
			c=(Canicas)tablero.getComponent(i);
			c.setColor(color);
		}
	}
	/**
     * Atiende el boton salga
     */
	private void salga(){
		int confirma= JOptionPane.showConfirmDialog(null, "Esta seguro que desea salir?");			
		if(confirma== 0) {
			System.exit(1);
		}
	}
	/**
     * Atiende el boton abrir archivo
     */
	private void abrirArchivo() {
		JFileChooser file= new JFileChooser();
		file.setDialogTitle("archivos a elegir");
		file.setFileSelectionMode(JFileChooser.FILES_ONLY);
		if(file.showOpenDialog(opcionAbrir)== JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "Lo sentimos esta funcion no esta disponible ahora");
		}
	}
	/**
     * atiende el boton guardar
     */
	private void guardar(){
		JOptionPane.showMessageDialog(this,"Lo sentimos esta funcion no esta disponible ahora","Guardar",JOptionPane.OK_OPTION);
	}
	public void definirTamano() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int x = pantalla.width / 2;
		int y = pantalla.height / 2;
		setSize(x,y);
	}
	public void centrar() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (pantalla.width - getSize().width) / 2;
		int y = (pantalla.height - getSize().height) / 2;
		setLocation(x,y);
	}
	/**
     * atiende el boton abajo
     */
	public void moverAbajo() {
		marbel.moverAbajo();
		dibujarTablero();
	}
	public static void main(String[] args ){
		MarbelGUI se= new MarbelGUI();
		se.setVisible(true);
	}
	
}

