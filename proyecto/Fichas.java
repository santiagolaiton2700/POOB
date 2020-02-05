import java.util.ArrayList;
public class Fichas
{
    // instance variables - replace the example below with your own
    private int posicionX;
    private int posicionY;
    private int columna;
    private int fila;
    private Circle ficha;
    public Fichas(int fila,int columna,int posX,int posY)
    {
        posicionX=posX;
        posicionY=posY;
        fila=fila;
        columna=columna;
        ficha=new Circle(posicionX,posicionY);
        ficha.makeVisible();
    }
    public void changeColor(String color){
        ficha.changeColor(color);
    }
}
