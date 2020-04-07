package presentacion;
import aplicacion.Marbel;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;
import java.util.*;

public class MarbelGUI extends JFrame{
	
	private JMenuBar menuBar;
	private JMenuItem salir;
	private JTextField height,width;
	private Marbel marbel;
	private Color colorC;

	public MarbelGUI(){
		super("Marbel"); 
		colorC=Color.WHITE;
		prepareElementos();
		prepareElementosMenu();
		prepareElementosTablero();
		prepareAcciones();
	}
	
	private void prepareElementosMenu(){
		menuBar = new JMenuBar();
		salir = new JMenuItem("Salir");
		height = new JTextField(); 
		width = new JTextField();
		menu.add(salir);
		menuBar.add(menu);
		height.setBounds(120,18,90,30);
		nuevo.add(height);
		nuevo.add(width);
	
	
	private void prepareElementos(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width/4, screenSize.height/4);
		setLocationRelativeTo(null);
		
	}
	private void prepareAcciones(){
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE );
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

	}	
 
	private void prepareElementosTablero() {
		Marbel = new Senku(defectH,defectW);
		grid();
		revalidate();
	}
	;
	}
	p
		
	private void salga(){
	       int c = JOptionPane.showConfirmDialog(null,"Desea salir?","EXIT",JOptionPane.YES_NO_OPTION);
	       if (JOptionPane.YES_OPTION == c) {
	    	   System.exit(1);
	       }
	}
	
	
}
