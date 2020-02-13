*//** Calculadora.java
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
            for(int j=0;j<matrizTemporal.getMatriz()[i].length;j++){
            }
        }
    }
    
    // Los operadores binarios : + (suma), - (resta), . (multiplique elemento a elemento), * (multiplique matricial)
    public void opere(String respuesta, String operando1, char operacion, String operando2){
        Matriz m1; 
        Matriz m2;
        Matriz resultado;
        if(operacion=='+'){
            m1=variables.get(operando1);
            m2=variables.get(operando2);
            resultado=m1.sumar(m2);
            variables.put(respuesta,resultado);
            System.out.println(variables.size()+" longitud diccionario");
            System.out.print(variables);
        }

    }   
    
    public String consulta(String variable){   
        return null;
    }
    public HashMap getDic(){
        return variables;
    }
    public boolean ok(){
        return false;
    }
    /* public String toString() {
        String a;
        for (int i=0;i<resultado.length;i++){
            for (int j=0;j<resultado[i].length;j++){
                 a=(String.valueOf(resultado[i][j]));
                 return a;
        }     
      }     
    }*/
}



