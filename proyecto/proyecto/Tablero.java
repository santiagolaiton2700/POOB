import java.util.ArrayList;
/**
    * Matriz de cuadrados dibujado sobre un canvas.
    * 
    * @author  Lina Buitrago and Santiago Laiton
    * @version 1.0.  (30 Enero 2020) 
    * @version 2.0.  (06 Febrero 2020) 
    * @version 3.0.  (21 Febrero 2020) 
    */ 
    
public class Tablero{
    private ArrayList<ArrayList<Rectangle>> tablero;
    private ArrayList<ArrayList<String>> simulacion;
    private int numero[][];
    private boolean isVisible;
    private int medida;
    private int xPos=0;
    private int yPos=0; 
 
    /**
    * Crea matrices de tipo Rectangle con los parametros indicados
    * @param width
    */
    public Tablero(int width){
        medida=width;
        this.simulacion=new ArrayList<ArrayList<String>>();
        this.tablero=new ArrayList<ArrayList<Rectangle>>();        
        numero = new int[width][width];
        isVisible=true;
        comprobacion();
    }
    /**
    * Crea matrices de tipo Rectangle con los parametros indicados
    * @param width ,xPos ,yPos
    */
    public Tablero(int width,int xPos,int yPos)
    {
        medida=width;
        this.xPos=xPos;
        this.yPos=yPos;
        this.simulacion=new ArrayList<ArrayList<String>>();
        this.tablero=new ArrayList<ArrayList<Rectangle>>();
        numero= new int[width][width];
        isVisible=true;
        comprobacion();
    }
    /**
    * Comprueba si las matrices de rectangulos son pares o impares
    */
    private void comprobacion(){
        if (medida%2==0){
            pintarTableroPar();
        }else{
            pintarTableroImpar();
        }        
    }  
    /**
    * Pinta matrices de rectangulos de tamaño par 
    
    */
    private void pintarTableroPar(){
        Rectangle rectangleTempo;
        int numeroFilas=medida;
        int numeroColumnas=medida;
        int moverCuadradox=medida;
        String color="white";
        String simbolo="-";
        int posicion=0;
        int blanco=0;
        for (int i=0;numeroFilas>i;i++){
            tablero.add(new ArrayList<Rectangle>());
            simulacion.add(new ArrayList<String>());
            for (int j=0;numeroColumnas>j;j++){
                rectangleTempo= new Rectangle(xPos,yPos);
                rectangleTempo.moveHorizontal(50*j);
                rectangleTempo.moveVertical(50*i);
                if (i%2==0){
                    rectangleTempo.changeColor(color);
                    simulacion.get(i).add(simbolo);
                    if(color=="white"){ 
                        numero[i][j]=blanco;
                        simbolo=".";
                        color="black";                        
                    }else{
                        posicion++;
                        numero[i][j]=posicion;
                        simbolo="-";                       
                        color="white";                        
                    }
                }else{
                    if (color=="white"){                        
                        simbolo=".";
                        color="black";
                        posicion++;
                        numero[i][j]=posicion;
                    }else{ 
                        simbolo="-";
                        numero[i][j]=blanco;
                        color="white";
                    }
                    rectangleTempo.changeColor(color);
                    simulacion.get(i).add(simbolo);
                }
                rectangleTempo.makeVisible();
                tablero.get(i).add(rectangleTempo);
            }
        }       
    }
    /**
    * Pinta matrices de rectangulos de tamaño impar 
    
    */
    
    private void pintarTableroImpar(){
        Rectangle rectangleTempo;
        int numeroFilas=medida;
        int numeroColumnas=medida;
        int moverCuadradox=medida;
        String color="white";
        String simbolo="-";        
        int posicion=0;
        int blanco=0;
        for (int i=0;numeroFilas>i;i++){
            tablero.add(new ArrayList<Rectangle>());
            simulacion.add(new ArrayList<String>());
            for (int j=0;numeroColumnas>j;j++){
                rectangleTempo= new Rectangle(xPos,yPos);
                rectangleTempo.moveHorizontal(50*j);
                rectangleTempo.moveVertical(50*i);
                rectangleTempo.changeColor(color);
                simulacion.get(i).add(simbolo);                               
                if(color=="white"){
                    numero[i][j]=blanco;
                    simbolo=".";
                    color="black";
                }else{
                    posicion++;
                    numero[i][j]=posicion;
                    simbolo="-";
                    color="white";                    
                }
                rectangleTempo.makeVisible();
                tablero.get(i).add(rectangleTempo);
            }
        }       
    }
    /**
    * Entrega la posicion en X del rectangulo en la matriz
    *@param fila ,columna
    *@return posicion en x de la matriz 
    */
    public int getposxCuadrado(int fila,int columna){
         return tablero.get(fila-1).get(columna-1).getPosicionX();
     }
    /**
    * Entrega la posicion en Y del rectangulo en la matriz
    *@param fila ,columna
    *@return posicion en y de la matriz
    */
    public int getposyCuadrado(int fila,int columna){
         return tablero.get(fila-1).get(columna-1).getPosicionY();
        }
    public String getColorCuadrado(int fila,int columna){
        return tablero.get(fila-1).get(columna-1).getColor();
    }
    /**
    * Entrega la matriz simulacion
    
    *@return simulacion
    */
    public ArrayList<ArrayList<String>> getSimulacion(){
        return simulacion;
     }
     /**
    * Entrega la posicion en X y Y de la matriz simulacion
    *@param x,y
    *@return posicionX y posicionY
    */
        public String getSimulacion(int x,int y)
     {
        return simulacion.get(x).get(y);
     }
     /**
    *Cambia la posicion 
    *@param fila,columna,jugador
  
    */
    public void changePosition(int fila,int columna,String jugador){                
        simulacion.get(fila).set(columna,jugador);
    }
    public void changePosition(int filaPas,int columnaPas,int fila,int columna,String colorPas,String jugador){                
        simulacion.get(fila).set(columna,jugador);       
        simulacion.get(filaPas).set(columnaPas,colorPas);                
    }
    /**
    * Hace visible la matriz, si ya es visible no hace nada.
    
    */
    public void makeVisibleTablero(){
        for(int i=0;i<tablero.size();i++){
            for(int j=0;j<tablero.size();j++){
                tablero.get(i).get(j).makeVisible();                
            }
        }
    }
      /**
    * Hace invisible la matriz, si ya es visible no hace nada.
    
    */
        public void makeInvisibleTablero(){        
        for(int i=0;i<tablero.size();i++){
            for(int j=0;j<tablero.size();j++){
                tablero.get(i).get(j).makeInvisible();
            }
        }
    }
    /**
    * Mueve la matriz horizontalmente
    
    */
    public void moveTableroHorizontal(){
            for(int i=0;tablero.size()>i;i++){
                for(int j=0;tablero.size()>i;i++){
                    tablero.get(i).get(j).makeInvisible();
                    tablero.get(i).get(j).moveHorizontal(200);
                    tablero.get(i).get(j).makeVisible();
            }
            }
    }
    public String colorPasado(int fila, int columna , int filaPas, int columnaPas) {
    	String posSConfi=simulacion.get(fila).get(columna);
    	String colorPasConfi=getColorCuadrado(filaPas,columnaPas);        
    	if (posSConfi=="-"||posSConfi=="."){
    		if(colorPasConfi=="black"){
    			colorPasConfi=".";
    		}else{
    			colorPasConfi="-";
    		}
    	}else {
    		colorPasConfi="NO";
    	}
    	return colorPasConfi;
    }
    public String colorCambio(int fila, int columna , int filaPas, int columnaPas) {
    	String posSConfi=simulacion.get(fila-1).get(columna-1);
    	String colorPasConfi=getColorCuadrado(filaPas,columnaPas);        
    	if (posSConfi=="-"||posSConfi=="."){
    		if(colorPasConfi=="black"){
    			colorPasConfi=".";
    		}else{
    			colorPasConfi="-";
    		}
    	}else {
    		colorPasConfi="NO";
    	}
    	return colorPasConfi;
    }
    public int [] getPosicion(int num){
        int [] posicion= new int[2];
        for (int i=0;i<numero.length;i++){
            for(int j=0;j<numero[0].length;j++){
                if (numero[i][j]==num){
                    posicion[0]=i;
                    posicion[1]=j;
                }
            }
        }
        return posicion;
    }
}      


