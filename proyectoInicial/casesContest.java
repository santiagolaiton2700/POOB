import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class casesContest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class casesContest
{
    /**
     * Default constructor for test class casesContest
     */
    private checkersContest tablero;
    public casesContest()
    {
        tablero= new checkersContest(8);
    }
    @Test
    public void contest1(){    
        String [] lista = new String[3];
        lista[0]="21-17";
        lista[1]="13x22x31x24";
        lista[2]="19x28";
        tablero.solved('W',lista); 
        String [] move = new String[5];
        move[0]="2-7";
        move[1]="9x2";
        move[2]="32-27";
        move[3]="2x11x18";
        move[4]="5-9";
        tablero.solved('W',move);
    }
}
