import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class cases.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class cases
{
    /**
     * Default constructor for test class cases
     */
    @Test
    public void  deberiaMoverseSoloEnCuadradosNegrosDesocupados(){
        checkers tablero=new checkers(4);
        tablero.add(true,1,2,"j1");
        tablero.select(1,2);
        tablero.move("derabajo");
    }
    
    @Test
    public void  noDeberiaMoverseEnCuadradosNegrosOcupados(){
        checkers tablero=new checkers(4);
        tablero.add(true,1,2,"j1");
        tablero.add(true,2,3,"j2");
        tablero.select(1,2);
        tablero.move("derabajo");
    }
   
    @Test
        public void  deberiaAdicionarFichasEnElTableroDeConfiguracion(){
        checkers tablero=new checkers(5);
        tablero.add(false,1,2,"j1");
        tablero.add(false,2,3,"j1");
    }
    @Test
        public void  noDeberiaAdicionarFichasEnElTableroDeJuego(){
        checkers tablero=new checkers(5);
        tablero.add(false,1,2,"j1");
        tablero.swap();
        tablero.add(false,5,2,"j1");
        
    }
     @Test
        public void  pruebaSave(){
        checkers tablero=new checkers(5);
        tablero.add(false,1,2,"j2");
        tablero.add(true,2,3,"j2");
        tablero.add(true,4,3,"j1"); 
        tablero.add(false,3,4,"j1");
        tablero.save("hola");
        tablero.add(false,1,4,"j2");
        tablero.recovery("hola");
    }
  
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
