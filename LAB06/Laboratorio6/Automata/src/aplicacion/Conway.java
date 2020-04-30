package aplicacion;
import java.awt.Color;


/**
 * Las celulas conway son celulas del juego de la vida que cumplen con ciertas condiciones; son azules su estado inicial es VIVA.
 * 
 * @author (Lina Buitrago- Santiago Laiton ) 
 * @version (12 de marzo 2020)
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
