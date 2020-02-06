import java.util.ArrayList;
public class Fichas
{
    // instance variables - replace the example below with your own
    private int posicionX;
    private int posicionY;
    private int columna;
    private int fila;
    private Circle ficha;
    public Fichas(int filaa,int columnaa,int posX,int posY)
    {
        posicionX=posX;
        posicionY=posY;
        fila=filaa;
        columna=columnaa;
        ficha=new Circle(posicionX,posicionY);
        ficha.makeVisible();
    }
    public void changeColor(String color){
        ficha.changeColor(color);
    }
    //public void seleccionar(int fila,int columna){
      //  Circle x;
      //  for (int i=0;i<fichas.size();i++){
      ///      System.out.println(i);
      //      x=fichas.get(i);
      //      int y=x.getFila();
      //      if (x.fila==fila && x.columna==columna){
      //          x.changeColor("green");
      //      }
      //  }
    //}
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
}
