package aplicacion;
import java.awt.Color;
/**
 * Write a description of class Derechosas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Derechosas extends Celula
{
    int tipo;
    public Derechosas(AutomataCelular ac,int fila, int columna)
    {
        // initialise instance variables
        super(ac,fila,columna);
        estadoActual='m';
        estadoSiguiente='v';
        color=Color.green;
    } 
     public int getForma(){
      return 2;
      
    }
}
