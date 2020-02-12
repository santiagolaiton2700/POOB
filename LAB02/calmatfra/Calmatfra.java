/** Calculadora.java
 * Representa una calculadora de matrices de fraccionarios
 * @author ESCUELA 2018-01
 */

import java.util.HashMap;
public class Calmatfra{

    private HashMap<String, Matriz> variables;
    
    //Consultar en el API Java la clase HashMap
    
    public Calmatfra(){
        variables=new HashMap<String,Matriz>();
    }

   
    public void asigne(String variable, int [][][] matriz){
        Matriz matrizTemporal= new Matriz(matriz);
        variables.put(variable ,matrizTemporal);
        for(int i=0;i<matrizTemporal.getMatriz().length;i++){
            for(int j=0;j<matrizTemporal.getMatriz()[i].length;j++) {
                System.out.print(matrizTemporal.getMatriz()[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    // Los operadores binarios : + (suma), - (resta), . (multiplique elemento a elemento), * (multiplique matricial)
    public void opere(String respuesta, String operando1, char operacion, String operando2){
    }
    

    public String consulta(String variable){   
        return null;
    }
    
    public boolean ok(){
        return false;
    }
}
    



