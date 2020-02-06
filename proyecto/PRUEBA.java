

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PRUEBA.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PRUEBA
{
    /**
     * Default constructor for test class PRUEBA
     */
    public PRUEBA()
    {
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
    @Test
    public void gg(){
        checkers prueba = new checkers(8);
        prueba.add(true,5,2,"j1");
        prueba.select(5,2);
        prueba.move("izq");
        prueba.finish();
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
