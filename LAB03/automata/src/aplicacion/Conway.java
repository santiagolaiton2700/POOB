package src.aplicacion;
import java.awt.Color;


/**
 * Write a description of class Conway here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
 public class Conway extends Celula
{        
    int tipo;
    public Conway(AutomataCelular ac,int fila, int columna)
    {
        // initialise instance variables
        super(ac,fila,columna);
        estadoActual='v';
        estadoSiguiente='m';
        color=Color.blue;
    }    
}

