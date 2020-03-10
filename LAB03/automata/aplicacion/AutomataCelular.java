package aplicacion;
import java.util.*;
public class AutomataCelular{
    static private int LONGITUD=20;
    private Elemento[][] automata;      
    public AutomataCelular() {
        automata=new Elemento[LONGITUD][LONGITUD];        
        for (int f=0;f<LONGITUD;f++){
            for (int c=0;c<LONGITUD;c++){
                automata[f][c]=null;
            }
        }
        algunosElementos();
    }

    public int  getLongitud(){
        return LONGITUD;
    }

    public Elemento getElemento(int f,int c){
        return automata[f][c];
    }

    public void setElemento(int f, int c, Elemento nueva){
        automata[f][c]=nueva;
    }

    public void algunosElementos(){
        Elemento indiana= Elemento.crearElemento(this,0,0,1);
        Elemento OO7= Elemento.crearElemento(this,1,1,1);
        Elemento prueba=Elemento.crearElemento(this,2,2,2);
    }
    public void ticTac(){
    }

}
