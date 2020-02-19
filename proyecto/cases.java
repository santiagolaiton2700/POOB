

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
    public void  move(){
        checkers tablero=new checkers(4);
        tablero.add(true,1,2,"j1");
        tablero.select(1,2);
        tablero.move("izqarriba");
    }
    @Test
        public void  jump(){
        checkers tablero=new checkers(8);
        tablero.add(true,3,4,"j1");
        tablero.add(true,2,5,"j2");
        tablero.select(3,4);
        tablero.jump(true,true);
    }
    @Test
        public void fallar(){
            checkers tablero=new checkers(8);
            tablero.add(true,5,6,"j1");
            tablero.add(true,4,5,"j2");
            tablero.select(5,6);
            tablero.jump(true,false);
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
