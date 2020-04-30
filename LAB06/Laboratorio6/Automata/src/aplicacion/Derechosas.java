package aplicacion;
import java.awt.Color;
/**
 * Son celulas con propiedades opuestas a las izquierdosas.
 * 
 * @author (Lina Buitrago - Santiago Laiton) 
 * @version (12 de marzo de 2020)
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
    /** Retorna la forma de la celula
     * 
     */
     public int getForma(){
      return 2;
      
    }
}
