package src.aplicacion;
import java.awt.Color;
/**
 * Las celulas izquierdosas son celulas rojas que cumplen una unica propiedad.
 * 
 * @author (Lina Buitrago- Santiago Laiton ) 
 * @version (12 de marzo 2020)
 */
public class Izquierdosas extends Celula
{        
    int tipo;
    public Izquierdosas(AutomataCelular ac,int fila, int columna)
    {
        super(ac,fila,columna);
        estadoActual='v';
        estadoSiguiente='m';
        color=Color.red;
    }    
}
