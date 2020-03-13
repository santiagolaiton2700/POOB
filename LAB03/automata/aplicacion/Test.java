package aplicacion;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.awt.Color;



/**
 * The test class Test.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Test
{
    @Test
    /**
     * Default constructor for test class Test
     */
    public Test()
    {
        AutomataCelular at = new AutomataCelular();
    }

    

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    public void celulasIzquierdosas1(){
        AutomataCelular at = new AutomataCelular();
        Izquierdosas  izquierdosa1 = new Izquierdosas(at,6,6);
        Izquierdosas  izquierdosa2 = new Izquierdosas(at,6,7);
       
        
        assertTrue("deberia ser de color roja",at.getElemento(6,6).getColor() == Color.red);
        assertTrue("deberia ser de color roja",at.getElemento(6,7).getColor() == Color.red);
  
        
        assertTrue("deberia estar viva",at.getElemento(6,6).isVivo());
        assertTrue("deberia estar viva",at.getElemento(6,7).isVivo());
        at.ticTac();    
        assertFalse("deberia estar muerta",at.getElemento(6,6).isVivo());
        assertTrue("deberia estar viva",at.getElemento(6,7).isVivo());
        
    }
    
    public void celulasIzquierdosas2(){
        AutomataCelular at = new AutomataCelular();
        Izquierdosas  marx = new Izquierdosas(at,3,6);
        Izquierdosas  hegel = new Izquierdosas(at,3,7);
       
        
        assertTrue("deberia ser de color roja",at.getElemento(3,6).getColor() == Color.red);
        assertTrue("deberia ser de color roja",at.getElemento(3,7).getColor() == Color.red);
        
        assertTrue("deberia estar viva",at.getElemento(3,6).isVivo());
        assertTrue("deberia estar viva",at.getElemento(3,7).isVivo());
        at.ticTac();    
        assertFalse("deberia estar muerta",at.getElemento(3,6).isVivo());
        assertTrue("deberia estar viva",at.getElemento(3,7).isVivo());
        at.ticTac();    
        assertFalse("deberia estar muerta",at.getElemento(3,6).isVivo());
        assertTrue("deberia estar viva",at.getElemento(3,7).isVivo());
        at.ticTac();    
        assertFalse("deberia estar muerta",at.getElemento(3,6).isVivo());
        assertTrue("deberia estar viva",at.getElemento(3,7).isVivo());
        
        
        
    }
    public void noDeberianVivirBarreras(){
        AutomataCelular at = new AutomataCelular();
        Barrera noroeste = new Barrera(at,15,1);
        Barrera  suroeste= new Barrera(at,1,15);
        at.ticTac();
        assertTrue("deberia estar muerta",at.getElemento(15,1).isVivo());
        assertTrue("deberia estar muerta",at.getElemento(1,15).isVivo());
        at.ticTac();
        assertTrue("deberia estar muerta",at.getElemento(15,1).isVivo());
        assertTrue("deberia estar muerta",at.getElemento(1,15).isVivo());
        at.ticTac();
        assertTrue("deberia estar muerta",at.getElemento(15,1).isVivo());
        assertTrue("deberia estar muerta",at.getElemento(1,15).isVivo());
                  
    }
    public void caso1Derechosas(){
        
        
    }
}
