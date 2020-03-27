package pruebas;


import aplicacion.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class SinapTest{
    public SinapTest(){  
    }
    @Test
    public void deberiaAdicionar() throws SinapException{   
        Sinap s= new Sinap();
        int size= s.numeroAreas();
        s.adicione("Tuparro","Tuparro Natural Park","Vichada","548000","Es una extensa sabana verde surcada por grandes rÃ­os con potentes raudales y playas doradas, pequeÃ±os caÃ±os de aguas cristalinas, bosques de galerÃ­a, morichales y saladillales, ademÃ¡s de enormes rocas cristalinas en forma de cerros redondeados.");
        assertTrue(size+1== s.numeroAreas());
    }
    @Test
    public void deberiaListar() throws SinapException{
        Sinap s= new Sinap();
        String consulta1=s.toString();
        s.adicione("Tuparro","Tuparro Natural Park","Vichada","548000","Es una extensa sabana verde surcada por grandes ríos con potentes raudales y playas doradas, pequeños caños de aguas cristalinas, bosques de galería, morichales y saladillales, además de enormes rocas cristalinas en forma de cerros redondeados.");
        String consulta2=s.toString();
        assertFalse(consulta1==consulta2);
    }
    @Test
    public void pruebaDeUnidad() throws SinapException{
        Sinap s= new Sinap();
        int size= s.numeroAreas();
        s.adicione("Tuparro","Tuparro Natural Park","Vichada","4","Es una extensa sabana verde surcada por grandes ríos con potentes raudales y playas doradas, pequeños caños de aguas cristalinas, bosques de galería, morichales y saladillales, además de enormes rocas cristalinas en forma de cerros redondeados.");
        s.adicione("Jaime Duque","Jaime Duque Park","Cundinamarca","700000","es un parque temático dedicado a la recreación familiar.");
        s.adicione("Mundo Aventura","Mundo Aventura Park","Bogota","13","es un parque de atracciones que se encuentra ubicado en la ciudad de Bogota, en la localidad de Kennedy");
        assertTrue(size+3== s.numeroAreas());  
    }
    @Test
    public void deberiaFallarSinNombreInternacional(){
        Sinap s= new Sinap();
        try {
             s.adicione("Tuparro","","Vichada","548000","Es una extensa sabana verde surcada por grandes ríos con potentes raudales y playas doradas, pequeños caños de aguas cristalinas, bosques de galería, morichales y saladillales, además de enormes rocas cristalinas en forma de cerros redondeados.");
             fail("No lanzo excepcion");
        }
        catch(SinapException e) { 
             assertEquals(e.getMessage(), SinapException.VACIO);
        }
    }
    @Test
    public void deberiaFallarConAreaRepetida(){
        Sinap s= new Sinap();
        try {
            s.adicione("Tuparro","Tuparro Natural Park","Vichada","548000","Es una extensa sabana verde surcada por grandes ríos con potentes raudales y playas doradas, pequeños caños de aguas cristalinas, bosques de galería, morichales y saladillales, además de enormes rocas cristalinas en forma de cerros redondeados.");
            s.adicione("Tuparro","Tuparro Natural Park","Vichada","548000","Es una extensa sabana verde surcada por grandes ríos con potentes raudales y playas doradas, pequeños caños de aguas cristalinas, bosques de galería, morichales y saladillales, además de enormes rocas cristalinas en forma de cerros redondeados.");
            fail("No lanzo excepcion");
        }
        catch(SinapException e) {
            assertEquals(e.getMessage(), SinapException.REPETIDO);
        }
    }
    @Test()
    public void deberiaFallarConAreaMenorACero(){
        Sinap s= new Sinap();
        try {
            s.adicione("Tuparro","Tuparro Natural Park","Vichada","-4","Es una extensa sabana verde surcada por grandes ríos con potentes raudales y playas doradas, pequeños caños de aguas cristalinas, bosques de galería, morichales y saladillales, además de enormes rocas cristalinas en forma de cerros redondeados.");
            fail("No lanzo excepcion");
        }
        catch(SinapException e) {
            assertEquals(e.getMessage(), SinapException.MAYOR);
        }
    }
    @Test 
    public void deberiaFallarBusque() throws SinapException{
	Sinap s= new Sinap();
	ArrayList<Area> resultados=new ArrayList<Area>();
	s.adicione("Tuparro","Tuparro Natural Park","Vichada","548000","Es una extensa sabana verde surcada por grandes ríos con potentes raudales y playas doradas, pequeños caños de aguas cristalinas, bosques de galería, morichales y saladillales, además de enormes rocas cristalinas en forma de cerros redondeados.");
        resultados=s.busque("T");	
	assertEquals(resultados.size(),1);
    }
}