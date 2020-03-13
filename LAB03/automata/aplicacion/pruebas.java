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
public class pruebas
{
    
    /**
     * Default constructor for test class Test
     */
    public pruebas()
    {
        AutomataCelular at = new AutomataCelular();
    }
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @Test 
    public void celulas(){
        AutomataCelular at = new AutomataCelular();
        Elemento indiana=Elemento.crearElemento(at,2,2,1);
        Elemento oo7=Elemento.crearElemento(at,2,2,1);
        at.ticTac();
        assertFalse("deberia estar muerta",at.getElemento(1,1).isVivo());
        assertFalse("deberia estar muerta",at.getElemento(2,2).isVivo());
        at.ticTac();
        assertFalse("deberia estar muerta",at.getElemento(1,1).isVivo());
        assertFalse("deberia estar muerta",at.getElemento(2,2).isVivo());
        at.ticTac();
        assertFalse("deberia estar muerta",at.getElemento(1,1).isVivo());
        assertFalse("deberia estar muerta",at.getElemento(2,2).isVivo());
        
    }
    @Test
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
        at.ticTac();    
        assertFalse("deberia estar muerta",at.getElemento(6,6).isVivo());
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
        assertFalse("deberia estar muerta",at.getElemento(15,1).isVivo());
        assertFalse("deberia estar muerta",at.getElemento(1,15).isVivo());
        at.ticTac();
        assertFalse("deberia estar muerta",at.getElemento(15,1).isVivo());
        assertFalse("deberia estar muerta",at.getElemento(1,15).isVivo());
        at.ticTac();
        assertFalse("deberia estar muerta",at.getElemento(15,1).isVivo());
        assertFalse("deberia estar muerta",at.getElemento(1,15).isVivo());
                  
    }
    public void caso1Derechosas(){
        //Cuando tiene una vecina revive
        AutomataCelular at = new AutomataCelular();
        Derechosas lina = new Derechosas(at,10,1);
        Derechosas santiago = new Derechosas(at,10,2);
        at.ticTac();
        assertFalse("deberia estar muerta",at.getElemento(10,1).isVivo());
        assertFalse("deberia estar muerta",at.getElemento(10,2).isVivo());
    }
    public void caso2Derechosas(){
        //Cuando tiene tres vecinas revive
        AutomataCelular at = new AutomataCelular();
        Derechosas lina = new Derechosas(at,10,1);
        Derechosas santiago = new Derechosas(at,10,2);
        Derechosas otra = new Derechosas(at,11,1);
        Derechosas otra1 = new Derechosas(at,11,2); 
        at.ticTac();
        assertFalse("deberia estar muerta",at.getElemento(10,1).isVivo());
        assertFalse("deberia estar muerta",at.getElemento(10,2).isVivo());
        assertFalse("deberia estar muerta",at.getElemento(11,1).isVivo());
        assertFalse("deberia estar muerta",at.getElemento(11,2).isVivo());
    }
    
    public void conway2(){
        AutomataCelular at = new AutomataCelular();
        Conway q = new Conway(at,13,1);
        Conway p = new Conway(at,13,2);
        at.ticTac();
        assertFalse("deberia estar muerta",at.getElemento(13,1).isVivo());
        assertFalse("deberia estar muerta",at.getElemento(13,2).isVivo());
        
    }
    public void conway3(){
        AutomataCelular at = new AutomataCelular();
        Conway q = new Conway(at,5,1);
        Conway p = new Conway(at,5,2);
        at.ticTac();
        assertFalse("deberia estar muerta",at.getElemento(5,1).isVivo());
        assertFalse("deberia estar muerta",at.getElemento(5,2).isVivo());
    }
    public void bloque(){
        AutomataCelular at = new AutomataCelular();
        Barrera suroeste = new Barrera(at,15,1);
        Barrera noroeste = new Barrera(at,15,2);
        Barrera bloque1 = new Barrera(at,16,1);
        Barrera bloque = new Barrera(at,16,2);
        at.ticTac();
        assertFalse("deberia estar muerta",at.getElemento(14,2).isVivo());
        assertFalse("deberia estar muerta",at.getElemento(14,1).isVivo());
        assertFalse("deberia estar muerta",at.getElemento(15,1).isVivo());
        assertFalse("deberia estar muerta",at.getElemento(15,2).isVivo());
        
    }
    
}