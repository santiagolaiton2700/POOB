
/**
 * Write a description of class checkers here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class checkers
{
    private ArrayList<ArrayList<Rectangle>> tablero;
    private ArrayList<ArrayList<String>> simulacion;
    private boolean isVisible;
    private int medida;
    /**
     * Constructor for objects of class checkers
     */
    public checkers(int width)
    {
        medida=width;
        isVisible=true;
        pintarTablero();
    }
    public void pintarTablero(){
        Rectangle rectangleTempo;
        Circle circuloTempo;
        tablero=new ArrayList<ArrayList<Rectangle>>();
        simulacion=new ArrayList<ArrayList<String>>();
        int numeroFichas=24;
        int numeroFilas=8;
        int numeroColumnas=8;
        int moverCuadradox=medida;
        String color="white";
        int moverCuadradoy=10;
        for (int i=0;numeroFilas>i;i++){
            tablero.add(new ArrayList<Rectangle>());
            simulacion.add(new ArrayList<String>());
            for (int j=0;numeroColumnas>j;j++){
                rectangleTempo= new Rectangle();
                rectangleTempo.changeSize(medida);
                rectangleTempo.moveHorizontal(moverCuadradox*j);
                rectangleTempo.moveVertical(moverCuadradox*i);
                if (i%2==0){
                    rectangleTempo.changeColor(color);

                    if(color=="white"){
                        simulacion.get(i).add("W");
                        color="black";
                        
                    }else{
                        simulacion.get(i).add("B");
                        color="white";
                        
                    }
                }else{
                    if (color=="white"){
                        simulacion.get(i).add("W");
                        color="black";
                    }else{
                        simulacion.get(i).add("B"); 
                        color="white";
                    }
                    rectangleTempo.changeColor(color);
                }
                rectangleTempo.makeVisible();
                tablero.get(i).add(rectangleTempo);
                System.out.println(simulacion);
            }
        }
    }
}

