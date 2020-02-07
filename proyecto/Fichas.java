import java.util.ArrayList;
/**
 * Fichas de tipo circulo dibujadas sobre un canvas.
 * 
 * @author  Lina Buitrago and Santiago Laiton
 * @version 2.0.  (02 Febrero 2020) 
 */
public class Fichas
{
   
    private int posicionX;
    private int posicionY;
    private int columna;
    private int fila;
    private Circle ficha;
    private String jugador;
    
     
     /**
     * 
     * Crea una ficha de tipo circulo a partir de los parametros dados
     * @param posX ,posY ,filaa,columnaa, jugador 
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
    /**
     * Cambia el color de la ficha
     
     */
    public void changeColor(String color){
        ficha.changeColor(color);
    }
    /**
     * Retorna la fila donde esta la ficha
     * @return fila
     */
    public int getFila(){
        return fila;
    }
    /**
     * Retorna la columna donde esta la ficha
     * @return columna
     */
    public int getColumna(){
        return columna;
    }
    /**
     * Cambia el color de la ficha a verde
     
     */
    public void setcolorgreen(){
        this.changeColor("green");
    }
    /**
     * Retorna el color actual de la ficha
     * @return ficha.getColor()
     */
    public String getColor(){
        return ficha.getColor();
    }
    /**
     * Retorna el jugador al que corresponde la ficha
     * @return jugador
     */
    public String getJugador(){
        return jugador;
    }
    /**
     * Mueve la ficha 10 en fila y 10 en columna 
     * @param fila,columna
     */
    public void moveFicha(int fila, int columna){
        ficha.changePos(fila+10,columna+10);
     }
     /**
     * Hace la ficha invisible , si ya esta invisible no hace nada

     */
    public void MakeInvisible(){
        ficha.makeInvisible();
    }
    /**
     * Hace la ficha visible , si ya esta visible no hace nada
     
     */
    public void MakeVisible(){
        ficha.makeVisible();
    }
}
