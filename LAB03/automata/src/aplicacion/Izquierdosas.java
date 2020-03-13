package src.aplicacion;
import java.awt.Color;
/**
 * Write a description of class Izquierdosas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Izquierdosas extends Celula
{        
    int tipo;
    public Izquierdosas(AutomataCelular ac,int fila, int columna)
    {
        // initialise instance variables
        super(ac,fila,columna);
        estadoActual='v';
        estadoSiguiente='m';
        color=Color.red;
    }    
}
