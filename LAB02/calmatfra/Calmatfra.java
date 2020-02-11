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
        System.out.println(matrizTemporal.get(0,0));
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
    



