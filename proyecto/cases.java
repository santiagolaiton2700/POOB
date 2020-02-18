

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
        tablero.add(true,2,1,"j2");
        tablero.select(1,2);
        tablero.move("derabajo");
    }
    @Test
        public void  jump(){
        checkers tablero=new checkers(8);
        tablero.add(true,3,4,"j1");
        tablero.add(true,2,5,"j2");
        tablero.select(3,4);
        tablero.jump(true,true);
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
