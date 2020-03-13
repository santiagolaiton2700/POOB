package src.aplicacion;
import java.awt.Color;

/**
 * Write a description of class Barrera here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Barrera extends Celula
{
    /**
     * Constructor for objects of class Barrera
     */
    public Barrera(AutomataCelular ac,int fila, int columna)
    {
        // initialise instance variables
        super(ac,fila,columna);
        estadoActual='m';
        estadoSiguiente='m';
        color=Color.black;
    }  
    public int getForma(){
      return 2;      
    }
}
