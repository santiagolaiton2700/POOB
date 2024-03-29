import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The test class cases.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class cases
{
    @Test
    public void  CICLO1(){
        checkers tablero=new checkers(4);
        tablero.add(true,4,1,"j1",1);
        tablero.add(false,3,2,"j2",1);
        tablero.makeInvisible();
        tablero.makeVisible();
        tablero.swap();
        tablero.select(4,1);
        tablero.jump(true,true);
        tablero.move("izqarriba");
        tablero.select(1,2);
        tablero.swap();
        assertTrue("deberia quedar en la posicion 1,2",true); 
        
    }
     @Test
        public void CICLO2SAVERECOVERY(){
        checkers tablero=new checkers(5);
        tablero.add(false,1,2,"j2",1);
        tablero.add(true,2,3,"j2",1);
        tablero.add(true,4,3,"j1",1); 
        tablero.add(false,3,4,"j1",1);
        tablero.save("hola");
        tablero.add(false,1,4,"j2",1);
        tablero.recovery("hola");
        
    }
     @Test
    public void CICLO2READANDWRITE(){
        checkers tablero=new checkers(3);
        tablero.read("-b-W-.-.-");
        tablero.write();
        assertTrue("deberia adicionar dos fichas en la matriz",true);



    }
    @Test
    public void CICLO4LIBERTARIAN(){
        checkers tablero=new checkers(4);
        tablero.add(true,1,2,"j1",2);
        tablero.add(false,2,3,"j2",1);
        tablero.jump(false,true);
        assertFalse("La ficha tuvo que ser removida",false);
    }
    /**
     * Default constructor for test class cases
     */
    @Test
    public void  deberiaMoverseSoloEnCuadradosNegrosDesocupados(){
        checkers tablero=new checkers(4);
        tablero.add(true,1,2,"j1",1);
   
        tablero.select(1,2);
        tablero.move("derabajo");
    }
    
    
    @Test
    public void  noDeberiaMoverseEnCuadradosNegrosOcupados(){
        checkers tablero=new checkers(4);
        tablero.add(true,1,2,"j1",1);
        tablero.add(true,2,3,"j2",1);
        tablero.select(1,2);
        tablero.move("derabajo");
    }
   
    @Test
        public void  deberiaAdicionarFichasEnElTableroDeConfiguracion(){
        checkers tablero=new checkers(5);
        tablero.add(false,1,2,"j1",1);
        tablero.add(false,2,3,"j1",1);
    }
    @Test
        public void  noDeberiaAdicionarFichasEnElTableroDeJuego(){
        checkers tablero=new checkers(5);
        tablero.add(false,1,2,"j1",1);
        tablero.swap();
        tablero.add(false,5,2,"j1",1);
        
    }
    
  
    @Test
    public void contest1(){
        checkers tablero= new checkers(8);
        tablero.add(false,1,2,"j2",1);
        tablero.add(true,4,1,"j2",1);
        tablero.add(false,4,5,"j1",1);
        tablero.add(true,5,6,"j1",1);
        tablero.add(false,6,1,"j1",1);
        tablero.add(false,7,4,"j1",1);
        tablero.add(false,7,6,"j1",1);
        tablero.save("hola");
        tablero.recovery("hola");
        tablero.swap();
    }
    @Test
    public void crearFicha(){
        checkers tablero= new checkers(8);
        tablero.add(true,1,2,"j2",2);
        tablero.add(false,2,3,"j2",2);
        tablero.add(true,2,1,"j2",3);
    }
    @Test
    public void contest2(){
        checkers tablero= new checkers(8);
        tablero.add(false,1,4,"j2",1);
        tablero.add(true,1,8,"j1",1);
        tablero.add(false,2,1,"j2",1);
        tablero.add(false,2,3,"j2",1);
        tablero.add(false,3,2,"j1",1);
        tablero.add(true,4,1,"j2",1);
        tablero.add(false,4,3,"j1",1);
        tablero.add(false,4,5,"j2",1);
        tablero.add(true,8,7,"j2",1);
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
