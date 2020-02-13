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
    public Matriz (int [][][] elementos) 
        {
        matriz=new Fraccionario [elementos.length][elementos[0].length];
        for (int i=0; i<elementos.length;i++){
            for(int j=0; j<elementos[i].length; j++) {
                matriz[i][j]= new Fraccionario(elementos[i][j][0],elementos[i][j][1]);                
            }
        }
  
    }
    public Matriz(Fraccionario respuesta [][]){
            matriz=new Fraccionario[respuesta.length][respuesta[0].length];
            for(int i=0;i<respuesta.length;i++){
                for(int j=0;j<respuesta[0].length;j++){                    
                    matriz[i][j]=respuesta[i][j];
                }
            }
       }   
    
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
    
    public Fraccionario [][] getMatriz(){
        return matriz;
    }
    /**
    /**
     * Retorna una matriz dados sus elementos. 
     */
    //public Matriz (Fraccionario  elementos[][]) {
      //  return Matriz;
    //}           
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
