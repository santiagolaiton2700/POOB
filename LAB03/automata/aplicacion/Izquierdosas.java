package aplicacion;
import java.awt.Color;
/**
 * Write a description of class Izquierdosas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Izquierdosas extends Celula
{    
    /**
     * Constructor for objects of class Izquierdosas
     */
    int tipo;
    public Izquierdosas(AutomataCelular ac,int fila, int columna)
    {
        // initialise instance variables
        super(ac,fila,columna);
        color=Color.red;
    }
}
