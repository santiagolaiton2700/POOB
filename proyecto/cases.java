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
   @Test
    public void deberiaCrearTablero(){
        checkers tablero=new checkers(8);
        tablero.add(false,1,2,"j2");
        tablero.add(true,4,1,"j2");
        tablero.add(false,4,5,"j1");
        tablero.add(true,5,6,"j1");
        tablero.add(false,6,1,"j1");
        tablero.add(false,7,4,"j1");
        tablero.add(false,7,6,"j1");
        tablero.swap();
        tablero.moveArena("21-17");    
        tablero.moveArena("13x22x31x24");    
        tablero.moveArena("19x28");    
        tablero.swap();
        tablero.write();
    }
    @Test
    public void contest1(){
        checkers tablero= new checkers(8);
        tablero.add(false,1,2,"j2");
        tablero.add(true,4,1,"j2");
        tablero.add(false,4,5,"j1");
        tablero.add(true,5,6,"j1");
        tablero.add(false,6,1,"j1");
        tablero.add(false,7,4,"j1");
        tablero.add(false,7,6,"j1");
        tablero.save("hola");
        tablero.recovery("hola");
        tablero.swap();
    }
    @Test
    public void contest2(){
        checkers tablero= new checkers(8);
        tablero.add(false,1,4,"j2");
        tablero.add(true,1,8,"j1");
        tablero.add(false,2,1,"j2");
        tablero.add(false,2,3,"j2");
        tablero.add(false,3,2,"j1");
        tablero.add(true,4,1,"j2");
        tablero.add(false,4,3,"j1");
        tablero.add(false,4,5,"j2");
        tablero.add(true,8,7,"j2");
        tablero.write();
        tablero.swap();
        tablero.moveArena("2-7");
        tablero.moveArena("9x2");
        tablero.moveArena("32-27");
        tablero.moveArena("2x11x18");
        tablero.moveArena("5-9");
        tablero.swap();
        tablero.write();
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
