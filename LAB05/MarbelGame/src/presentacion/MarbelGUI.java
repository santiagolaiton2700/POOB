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
	
	public MarbelGUI() {
		marbel=new MarbelGame(4,4,1);
		color = Color.BLUE;
		prepareElementos();
		prepareAcciones();
		
	}
	
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
	public void prepareAcciones() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { 
				salga();
			}
		});
		opcionSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salga();
			}
		});
		opcionSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		opcionAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirArchivo();
			}
		});
		abajo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moverAbajo();
			}
		});
		arriba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//moverArriba();
			}
		});
		derecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//moverDerecha();
			}
		});
		izquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//moverIzquierda();
			}
		});
		cambioColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambioColor();
			}
		});
		
	}
	public void prepareElementosTablero() {
		ponerBotones();
		ponerTablero();
	}
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
	public void ponerTablero() {
		cuadrados=new GridLayout(tamano,tamano,5,5);
		tablero=new JPanel(cuadrados);
		this.add(tablero);
		tablero.setBackground(Color.blue);
		dibujarTablero();
	}
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
	private void cambioColor() {
		Color colorp = JColorChooser.showDialog(null,"Change Marble Color",color);
		if (colorp!=null && colorp!=Color.BLACK) {
			color=colorp;
			pintarBolas();
		}
	}
	private void pintarBolas() {
		Canicas c;
		for (int i=0;i<tamano*tamano;i++) {
			c=(Canicas)tablero.getComponent(i);
			c.setColor(color);
		}
	}

	private void salga(){
		int confirma= JOptionPane.showConfirmDialog(null, "Esta seguro que desea salir?");			
		if(confirma== 0) {
			System.exit(1);
		}
	}
	private void abrirArchivo() {
		JFileChooser file= new JFileChooser();
		file.setDialogTitle("archivos a elegir");
		file.setFileSelectionMode(JFileChooser.FILES_ONLY);
		if(file.showOpenDialog(opcionAbrir)== JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "Lo sentimos esta funcion no esta disponible ahora");
		}
	}
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
	public void moverAbajo() {
		marbel.moverAbajo();
		dibujarTablero();
	}
	public static void main(String[] args ){
		MarbelGUI se= new MarbelGUI();
		se.setVisible(true);
	}
	
}

