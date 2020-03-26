package aplicacion;

import java.util.*;
import java.util.LinkedList;
import java.util.ArrayList;
import excepcion.*;
import java.lang.Object;
import registro.*;
import excepcion.*;
import aplicacion.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;

    
    public class SinapTest{
    public SinapTest(){
    }


    @Before
    public void setUp(){
    }

    @After
    public void tearDown(){
    }
    @Test
    public void deberiaAdicionar() throws SinapExcepcion{
        
        Sinap s= new Sinap();
        int size= s.numeroAreas();
        s.adicione("Tuparro","Tuparro Natural Park","Vichada","548.000","Es una extensa sabana verde surcada por grandes ríos con potentes raudales y playas doradas, pequeños caños de aguas cristalinas, bosques de galería, morichales y saladillales, además de enormes rocas cristalinas en forma de cerros redondeados.");
        assertTrue(size+1== s.numeroAreas());
    }
    @Test
    public void deberiaListar() throws SinapExcepcion{
        Sinap s= new Sinap();
        String consulta1=s.toString();
        s.adicione("Tuparro","Tuparro Natural Park","Vichada","548.000","Es una extensa sabana verde surcada por grandes ríos con potentes raudales y playas doradas, pequeños caños de aguas cristalinas, bosques de galería, morichales y saladillales, además de enormes rocas cristalinas en forma de cerros redondeados.");
        String consulta2=s.toString();
        assertFalse(consulta1==consulta2);
    }
   @Test
    public void pruebaDeUnidad() throws SinapExcepcion{
        Sinap s= new Sinap();
        int size= s.numeroAreas();
        s.adicione("Tuparro","Tuparro Natural Park","Vichada","-4","Es una extensa sabana verde surcada por grandes ríos con potentes raudales y playas doradas, pequeños caños de aguas cristalinas, bosques de galería, morichales y saladillales, además de enormes rocas cristalinas en forma de cerros redondeados.");
        s.adicione("Jaime Duque","Jaime Duque Park","Cundinamarca","700.000mt2","es un parque temático dedicado a la recreación familiar.");
        s.adicione("Mundo Aventura","Mundo Aventura Park","Bogota","13 hectareas","es un parque de atracciones que se encuentra ubicado en la ciudad de Bogota, en la localidad de Kennedy");
        
        assertTrue(size+3== s.numeroAreas());
        
    }	
    @Test
    public void deberiaFallarSinNombreInternacional(){
        Sinap s= new Sinap();
        try {
             s.adicione("Tuparro","","Vichada","548.000","Es una extensa sabana verde surcada por grandes ríos con potentes raudales y playas doradas, pequeños caños de aguas cristalinas, bosques de galería, morichales y saladillales, además de enormes rocas cristalinas en forma de cerros redondeados.");
             fail("No lanzo excepcion");
        }
        catch(SinapExcepcion e) { 
             assertEquals(e.getMessage(), SinapExcepcion.VACIO);
        }
    }
    @Test
    public void deberiaFallarConAreaRepetida(){
        Sinap s= new Sinap();
        try {
            s.adicione("Tuparro","Tuparro Natural Park","Vichada","548.000","Es una extensa sabana verde surcada por grandes ríos con potentes raudales y playas doradas, pequeños caños de aguas cristalinas, bosques de galería, morichales y saladillales, además de enormes rocas cristalinas en forma de cerros redondeados.");
            s.adicione("Tuparro","Tuparro Natural Park","Vichada","548.000","Es una extensa sabana verde surcada por grandes ríos con potentes raudales y playas doradas, pequeños caños de aguas cristalinas, bosques de galería, morichales y saladillales, además de enormes rocas cristalinas en forma de cerros redondeados.");
            fail("No lanzo excepcion");
        }
        catch(SinapExcepcion e) {
            assertEquals(e.getMessage(), SinapExcepcion.REPETIDO);
        }
    }
    @Test()
    public void deberiaFallarConAreaMenorACero(){
        Sinap s= new Sinap();
        try {
            s.adicione("Tuparro","Tuparro Natural Park","Vichada","-4","Es una extensa sabana verde surcada por grandes ríos con potentes raudales y playas doradas, pequeños caños de aguas cristalinas, bosques de galería, morichales y saladillales, además de enormes rocas cristalinas en forma de cerros redondeados.");
            fail("No lanzo excepcion");
        }
        catch(SinapExcepcion e) {
            assertEquals(e.getMessage(), SinapExcepcion.MAYOR);
        }
    }
 
    @Test 
    public void deberiaFallarBusque() throws SinapExcepcion{
	Sinap s= new Sinap();
	ArrayList<Area> resultados=new ArrayList<Area>();
	s.adicione("Tuparro","Tuparro Natural Park","Vichada","548.000","Es una extensa sabana verde surcada por grandes ríos con potentes raudales y playas doradas, pequeños caños de aguas cristalinas, bosques de galería, morichales y saladillales, además de enormes rocas cristalinas en forma de cerros redondeados.");
        resultados=s.busque("T");	
	assertEquals(resultados.size(),1);
    }
}