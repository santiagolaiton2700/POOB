package src.presentacion;
import src.aplicacion.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.JFrame;
import java.awt.geom.*;
import java.util.*;

public class AutomataGUI extends JFrame{    

    private JButton botonReloj;
    private JLabel lFila;
    private JLabel lColumna;
    private JTextField tFila;
    private JTextField tColumna;
    private JPanel panelControl;
    private JPanel panelNueva;
    private JPanel panelBNueva;
    private JButton botonVreiva;
    private JButton botonLatente;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem abra;
    private JMenuItem salve;
    private JMenuItem importe;
    private JMenuItem exporte;
    private JPanel c;

    private FotoAutomata foto;
    private AutomataCelular automata=null;

    public AutomataGUI(AutomataCelular ac) {
        super("Automata celular");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        automata=ac;
        foto=new FotoAutomata(automata);
        setSize(new Dimension(802,700)); 
        prepareElementos();
        prepareAcciones();
        prepareElementosMenu();
        prepareAccionesMenu();

    }
    private void prepareElementosMenu() {
    	menuBar = new JMenuBar();
	menu = new JMenu("Menu");
	abra = new JMenuItem("Abrir");
	salve = new JMenuItem("Salvar");
	importe = new JMenuItem("Importar");
	exporte = new JMenuItem("Exportar");
    	
	menu.add(abra);
	menu.add(salve);
	menu.add(importe);
	menu.add(exporte);
	menuBar.add(menu);
	setJMenuBar(menuBar);
		
    }

    private void prepareElementos() {
        setResizable(false);

        botonReloj=new JButton("Tic-tac");

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(foto,BorderLayout.NORTH);
        getContentPane().add(botonReloj,BorderLayout.SOUTH);

        foto.repaint();
    }

    private void prepareAcciones(){

        botonReloj.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    botonRelojAccion();
                }
             });

    }
    private void prepareAccionesMenu(){
       setDefaultCloseOperation(AutomataGUI.DISPOSE_ON_CLOSE);
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE );
            addWindowListener(new WindowAdapter() {
               public void windowClosing(WindowEvent e) { 
				Salir();
			}
		});
	abra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrir();
			}
		});	
}
    public void Salir(){
	int c = JOptionPane.showConfirmDialog(null,"Desea salir?","EXIT",JOptionPane.YES_NO_OPTION);
	if (JOptionPane.YES_OPTION == c) {
	    System.exit(1);
	       }
	}
    public void abrir() {
	JFileChooser file = new JFileChooser();
	int result = file.showOpenDialog(this);
	if (result == JFileChooser.APPROVE_OPTION) {
	    File selectedFile = file.getSelectedFile();
	    JOptionPane.showMessageDialog(this, "Funcion en construccion");
		}	
	}
    private void botonRelojAccion() {
        automata.ticTac();
        foto.repaint();
    }

    public static void main(String[] args) {
        AutomataCelular ac=new AutomataCelular();
        AutomataGUI ca=new AutomataGUI(ac);
        ca.setVisible(true);
    }  
}

class FotoAutomata extends JPanel{
    public static int TAMANO=40;
    private AutomataCelular automata;
    public FotoAutomata(AutomataCelular ac) {
        setBackground(Color.white);
        automata=ac;
        setPreferredSize(new Dimension(800,800));       
    }

    public void setAutomata(AutomataCelular automata){
        this.automata=automata;
    }
    	
	
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        for (int f=0;f<=automata.getLongitud();f++){
            g.drawLine(f*TAMANO,0,f*TAMANO,automata.getLongitud()*TAMANO);
        }
        for (int c=0;c<=automata.getLongitud();c++){
            g.drawLine(0,c*TAMANO,automata.getLongitud()*TAMANO,c*TAMANO);
        }       
        for (int f=0;f<automata.getLongitud();f++){
            for(int c=0;c<automata.getLongitud();c++){
                if (automata.getElemento(f,c)!=null){
                    g.setColor(automata.getElemento(f,c).getColor());
                    if (automata.getElemento(f,c).getForma()==Elemento.CUADRADA){                  
                        if (automata.getElemento(f,c).isVivo()){
                            g.drawRoundRect(TAMANO*c+3,TAMANO*f+3,35,35,5,5);
                        }else{
                            g.fillRoundRect(TAMANO*c+3,TAMANO*f+3,35,35,5,5);    

                        }
                    }else {
                        if (automata.getElemento(f,c).isVivo()){
                            g.fillOval(TAMANO*c+10,TAMANO*f+10,20,20);
                        } else {
                            g.drawOval(TAMANO*c+10,TAMANO*f+10,20,20);
                        }
                    }
                }
            }
        }
    }
}