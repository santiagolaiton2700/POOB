import java.util.ArrayList;
/**
 * Fichas de tipo circula dibujado sobre un canvas sobrepuestas sobre tablero.
 * 
 * @author  Lina Buitrago and Santiago Laiton
 * @version 2.0.  (02 Febrero 2020) 
 */
public class Fichas
{
    // instance variables - replace the example below with your own
    private int posicionX;
    private int posicionY;
    private int columna;
    private int fila;
    private Circle ficha;
    private String jugador;
     /**
     * Crea una ficha de tipo circulo con posicionX ,posicionY ;fila y columna dadas por el usuario
     */
    public Fichas(int filaa,int columnaa,int posX,int posY, String jugador)
    {
        posicionX=posX;
        posicionY=posY;
        fila=filaa;
        columna=columnaa;
        ficha=new Circle(posicionX,posicionY);
        ficha.makeVisible();
        this.jugador=jugador;
    }
    public void changeColor(String color){
        ficha.changeColor(color);
    }
    public int getFila(){
        return fila;
    }
    public int getColumna(){
        return columna;
    }
    public void setcolorgreen(){
        this.changeColor("green");
    }
    public String getColor(){
        return ficha.getColor();
    }
    public String getJugador(){
        return jugador;
    }
    public void moveFicha(int fila, int columna){
        ficha.changePos(fila+10,columna+10);
     }
    public void MakeInvisible(){
        ficha.makeInvisible();
    }
    public void MakeVisible(){
        ficha.makeVisible();
    }
}
