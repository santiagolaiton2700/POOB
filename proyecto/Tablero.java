
import java.util.ArrayList;
public class Tablero{
    private ArrayList<ArrayList<Rectangle>> tablero;
    private ArrayList<ArrayList<String>> simulacion;
    private boolean isVisible;
    private int medida;
    private ArrayList<Fichas>Fichas;
    /**
     * Constructor for objects of class checkers
     */
    public Tablero(int width)
    {
        medida=width;
        this.simulacion=new ArrayList<ArrayList<String>>();
        this.tablero=new ArrayList<ArrayList<Rectangle>>();
        isVisible=true;
        comprobacion();
        
    }
    private void comprobacion(){
        if (medida%2==0){
            pintarTableroPar();
        }else{
            pintarTableroImpar();
        }
        
    }
    private void pintarTableroPar(){
        Rectangle rectangleTempo;
        
       
        int numeroFilas=medida;
        int numeroColumnas=medida;
        int moverCuadradox=medida;
        String color="white";
        
        for (int i=0;numeroFilas>i;i++){
            tablero.add(new ArrayList<Rectangle>());
            simulacion.add(new ArrayList<String>());
            for (int j=0;numeroColumnas>j;j++){
                rectangleTempo= new Rectangle();
                rectangleTempo.moveHorizontal(50*j);
                rectangleTempo.moveVertical(50*i);
                if (i%2==0){
                    rectangleTempo.changeColor(color);
                    simulacion.get(i).add(color);
                    if(color=="white"){
                        color="black";                        
                    }else{
                        color="white";                        
                    }
                }else{
                    if (color=="white"){
                        color="black";
                    }else{ 
                        color="white";
                    }
                    rectangleTempo.changeColor(color);
                    simulacion.get(i).add(color);
                }
                rectangleTempo.makeVisible();
                tablero.get(i).add(rectangleTempo);

            }
        }
    }
    private void pintarTableroImpar(){
        Rectangle rectangleTempo;
        int numeroFilas=medida;
        int numeroColumnas=medida;
        int moverCuadradox=medida;
        String color="white";
        for (int i=0;numeroFilas>i;i++){
            tablero.add(new ArrayList<Rectangle>());
            simulacion.add(new ArrayList<String>());
            for (int j=0;numeroColumnas>j;j++){
                rectangleTempo= new Rectangle();
                rectangleTempo.moveHorizontal(50*j);
                rectangleTempo.moveVertical(50*i);
                rectangleTempo.changeColor(color);
                simulacion.get(i).add(color);
                if(color=="white"){
                        color="black";
                }else{
                        color="white";
                }
                rectangleTempo.makeVisible();
                tablero.get(i).add(rectangleTempo);
            }
        }
     }
    public int getposxCuadrado(int fila,int columna){
         return tablero.get(fila-1).get(columna-1).getPosicionX();
        }
    public int getposyCuadrado(int fila,int columna){
         return tablero.get(fila-1).get(columna-1).getPosicionY();
        }
    public ArrayList<ArrayList<String>> getSimulacion(){
        return simulacion;
     }
    public String getSimulacion(int x,int y)
     {
        return simulacion.get(x).get(y);
     }
    public void changePosition(int fila,int columna,String jugador){
        simulacion.get(fila).set(columna,jugador);
        System.out.println(simulacion);
    }
    public void moveHorizontal(){
        
    }
}      


