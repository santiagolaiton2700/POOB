package presentacion;
//import aplicacion.Marbel;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;
import java.util.*;

public class MarbelGUI extends JFrame{
	private JMenuBar menuBar;
	private JMenu menu,nuevo;
	private JMenuItem abrir,guardar,guardarComo,salir,normal,personalizar;
	private JTextField height,width;
	//private Marbel marbel;
	private Color colorC;

	public MarbelGUI(){
		super("MarbelGame"); 
		this.setLayout(new BorderLayout());
		prepareElementos();
		prepareAcciones();
	}
	private void prepareAcciones(){
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { 
				salga();
			}
		});
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salga();
			}
		});
		guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		abrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirArchivo();
			}
		});
	}
	private void salga(){
		int confirma= JOptionPane.showConfirmDialog(null, "Esta seguro que desea salir?");			
		if(confirma== 0) {
			System.exit(1);
		}
	}
	private void guardar(){
		JOptionPane.showMessageDialog(this,"Lo sentimos esta funcion no esta disponible ahora","Guardar",JOptionPane.OK_OPTION);
	}
	private void abrirArchivo() {
		JFileChooser file= new JFileChooser();
		file.setDialogTitle("archivos a elegir");
		file.setFileSelectionMode(JFileChooser.FILES_ONLY);
		if(file.showOpenDialog(abrir)== JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "Lo sentimos esta funcion no esta disponible ahora");
		}
	}
	public static void main(String[] args ){
		MarbelGUI se= new MarbelGUI();
		se.setVisible(true);
	}
	private void prepareElementosMenu(){
		menuBar=new JMenuBar();
		menu=new JMenu("Menu");
		nuevo=new JMenu("Nuevo");
		menu.add(nuevo);
		abrir=new JMenuItem("Abrir");
		menu.add(abrir);
		guardar=new JMenuItem("Guardar");
		menu.add(guardar);
		guardarComo=new JMenuItem("Guardar Como");
		menu.add(guardarComo);
		salir=new JMenuItem("Salir");
		menu.add(salir);
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
	}
	
	private void prepareElementos(){         
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();         
		setSize(screenSize.width/2, screenSize.height/2);         
		setLocationRelativeTo(null);         
		//reinicio = new JButton("Reiniciar :)");         
		this.getContentPane().setLayout(new BorderLayout());         
		//this.getContentPane().add(reinicio,BorderLayout.SOUTH);
		prepareElementosMenu();
	}
		
}
