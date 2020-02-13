import java.sql.Array;
import java.util.ArrayList;

/**Matriz 
 * Esta clase implementa el tipo de dato Matriz; una matriz cuyos elementos cumplen la siguiente descripcion: un n�mero racional que se pueden escribir de la forma p/q, donde p y q son enteros, con q <> 0

 * @author ECI, 2019
 *
 */

public class Matriz{
    private ArrayList<Fraccionario> listaFraccionario;
    private Fraccionario [][] matriz;
    
    /**
     * Retorna una matriz dados sus elementos. Los fraccionarios se representan como {numerador, denominador}
     */
    
    public static boolean esMatriz (int [][][] elementos){
        return false;
    }
     /**
    /**
     * Cambia el tipo de int elementos[][][] a Matriz  .
     * 
     */
    public Matriz (int [][][] elementos) 
        {
        matriz=new Fraccionario [elementos.length][elementos[0].length];
        for (int i=0; i<elementos.length;i++){
            for(int j=0; j<elementos[i].length; j++) {
                matriz[i][j]= new Fraccionario(elementos[i][j][0],elementos[i][j][1]);                
            }
        }
  
    }
    /**
     * Cambia el tipo de int respuesta[][] a Matriz  .
     * 
     */
    public Matriz(Fraccionario respuesta [][]){
            matriz=new Fraccionario[respuesta.length][respuesta[0].length];
            for(int i=0;i<respuesta.length;i++){
                for(int j=0;j<respuesta[0].length;j++){                    
                    matriz[i][j]=respuesta[i][j];
                }
            }
       }   
    /**Recibe matriz de tipo Matriz y la suma con otra matriz del mismo tipo 
     * @param matriz2 Matriz
     * @return una matriz de tipo Matriz correspondiente a la suma de ambas matrices
     */
    public Matriz sumar(Matriz matriz2){
         Fraccionario[][] m2=matriz2.getMatriz();
         Fraccionario[][] respuesta=new Fraccionario [matriz.length][matriz[0].length];
         if(m2.length==matriz.length && m2[0].length==matriz[0].length){
            for(int i=0;i<matriz.length;i++){
                for(int j=0;j<matriz[0].length;j++){                    
                    respuesta[i][j]=matriz[i][j].sume(m2[i][j]);
                }
            }
            }        
         Matriz resp=new Matriz(respuesta);
         return resp;
    }
     /**Recibe matriz de tipo Matriz y la resta con otra matriz del mismo tipo 
     * @param matriz2 Matriz
     * @return una matriz de tipo Matriz correspondiente a la resta de ambas matrices
     */
    public Matriz restar(Matriz matriz2){
         Fraccionario[][] m2=matriz2.getMatriz();
         Fraccionario[][] respuesta=new Fraccionario [matriz.length][matriz[0].length];
         if(m2.length==matriz.length && m2[0].length==matriz[0].length){
            for(int i=0;i<matriz.length;i++){
                for(int j=0;j<matriz[0].length;j++){                    
                    respuesta[i][j]=matriz[i][j].reste(m2[i][j]);
                }
            }
            }        
         Matriz resp=new Matriz(respuesta);
         return resp;
    }
     /**
    /**
     * Retorna una matriz de tipo Fraccionario[][]. 
     */
    public Fraccionario [][] getMatriz(){
        return matriz;
    }
   
              
     /**
     * Retorna una matriz dada su diagonal. 
     */    
    public Matriz (Fraccionario d []){

    }    

    /**
     * Retorna una matriz de un numero repetido dada su dimension. 
     */
    public Matriz (Fraccionario e, int f, int c) {

    }
    
    /**
     * Retorna una matriz identidad dada su dimension. 
     */
    public Matriz (int n) {
    }
    
     /**
    /**
     * Retorna la dimension de una  matriz dados sus elementos. 
     */
    public String dimension(){
        String longitudMatriz=matriz.length+" ";
        String longitudLista=matriz[0].length+"  ";
        String respuesta=longitudMatriz+"*"+longitudLista;
        return respuesta;
    }
    
    public Fraccionario get(int f, int c){
        return null;
    }
    
    /**
     * Compara esta matriz con otra
     */
    public boolean equals (Matriz otra) {
        return false;
    }

    /** 
     * Compara esta matriz con otra
     */
    @Override
    public boolean equals(Object otra) {
            return false;
    }
    
    
    /** 
     * Retorna una cadena con los datos de la matriz alineado a derecha por columna
     * 
    */
    @Override
    public String toString () {
          String s = "";
          return s;
    }   
    
    //Retorna la matriz con el numero de filas o columnas
    public Matriz sume(Matriz m){
        return null;
    }
    
 
}
