
/**
 * Write a description of interface ControladorFichas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public interface Fichas
{
    public static Normal crearFichas(int fila,int columna,int posX,int posY,String jugador,boolean king,int tipo){
        Normal ficha=null;
        switch(tipo){
            case 1:
            ficha=new Normal(fila,columna,posX,posY,jugador,king,tipo);
            break;
            case 2:
            ficha= new libertarian(fila,columna,posX,posY,jugador,king,tipo);
            break;
            case 3:
            ficha= new powerFull(fila,columna,posX,posY,jugador,king,tipo);
        }
        return ficha;       
    }
    public void changeColor(String color);
    public boolean isKing();
    public void setKing();
    public String getColor();
    public String getJugador();
    public int getFila();
    public int getColumna();
    public void moveFicha(int fila, int columna,int nuevaFila,int nuevaColumna);
    public boolean morir();
    public void MakeVisible();
    public void MakeInvisible();
    public int getType();
}
