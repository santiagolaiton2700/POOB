import java.sql.Array;
import java.util.ArrayList;

/**
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
    
    public Matriz (int [][][] elementos) {
        for (int i=0; i<elementos.length;++i){
        	for(int j=0; j<elementos[i].length;++i) {
        		matriz= new Fraccionario[elementos[i][j][0]][elementos[i][j][1]];
        		listaFraccionario.add(matriz);
        	}
        }
        //matriz.toString();
    }
    
    
    /**
     * Retorna una matriz dados sus elementos. 
     */
    public Matriz (Fraccionario  elementos[][]) {

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
    
    
    public Matriz dimension(){
        return null;
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
