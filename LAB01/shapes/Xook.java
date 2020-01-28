
/**
 * Write a description of class Xook here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Random;
public class Xook
{
    // instance variables - replace the example below with your own
    private int valor;
    private ArrayList<Circle> circulos; 
    private ArrayList<Rectangle> rectangulos;
    private boolean isVisible;

    public Xook(int value)
    {
        valor= value;
        isVisible=false;
        pintarXxok();
    }
    public int getValue(){
        return valor;
    }
    public void makeVisible(){
        for (int i=0;i<circulos.size();i++){
        
            circulos.get(i).makeVisible();
        }
        for (int i=0;i<rectangulos.size();i++){
            rectangulos.get(i).makeVisible();
        }
        isVisible=true;
    }
    public void makeInvisible(){
        for (int i=0;i<circulos.size();i++){
            circulos.get(i).makeInvisible();
        }
        for (int i=0;i<rectangulos.size();i++){
            rectangulos.get(i).makeInvisible();
        }
        isVisible=false;    
    }
    private void pintarXxok(){
        Circle circuloTempo;
        Rectangle rectangleTempo;
        circulos=new ArrayList<Circle>();
        rectangulos=new ArrayList<Rectangle>();
        int moverCirculo=20;
        int numeroCirculos=valor%5;
        int numeroRectangulos=valor/5;
        int moverRectangulo=20;
        for (int i = 0;numeroCirculos!=i; i++){
            circuloTempo=new Circle();
            circuloTempo.changeColor("red");
            circuloTempo.changeSize(8);
            circuloTempo.moveHorizontal(moverCirculo*i);
            circulos.add(circuloTempo);
        }
        for (int i=0;numeroRectangulos>i;i++){
            rectangleTempo=new Rectangle();
            rectangleTempo.changeColor("black");
            rectangleTempo.changeSize(10,90);
            rectangleTempo.moveVertical(moverRectangulo*i);
            rectangulos.add(rectangleTempo);
        }
    }
    public void random(){
        Random r = new Random();
        valor = r.nextInt(50)+1;
        dibujarBorrar();
    }
    public void setValue(int value){
        valor=value;
        dibujarBorrar();
    }
    private void dibujarBorrar(){
        if(isVisible){
            makeInvisible();
            pintarXxok();
            makeVisible();
        }else{
            pintarXxok();
        }
    }
    public void moverHorizontal(int distancia){
        for(int i=0;rectangulos.size()>i;i++){
            rectangulos.get(i).moveHorizontal(distancia);
        }
        for (int i=0;circulos.size()>i;i++){
            circulos.get(i).moveHorizontal(distancia);
        }
    }
    public void changeColor(String color){
        for (int i=0;rectangulos.size()>i;i++){
            rectangulos.get(i).changeColor(color);
        }
        for (int i=0;circulos.size()>i;i++){
            circulos.get(i).changeColor(color);
        }
    }
}
