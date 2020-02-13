//** Calculadora.java
 /** Representa una calculadora de matrices de fraccionarios
 * @author ESCUELA 2018-01
 **/

import java.util.HashMap;
public class Calmatfra{

    private HashMap<String, Matriz> variables;
    
    //Consultar en el API Java la clase HashMap
     /**Crea un HashMap cuya llave es varible y el valor asignado es Matriz
     
     */ 
    public Calmatfra(){
        variables=new HashMap<String,Matriz>();
    }
 /**Le asigna valores al HashMap
     * @param variable String (llave)
     * @param int [][][] matriz
     */ 
   
    public void asigne(String variable, int [][][] matriz){        
        Matriz matrizTemporal= new Matriz(matriz);
        variables.put(variable ,matrizTemporal);
        for(int i=0;i<matrizTemporal.getMatriz().length;i++){
            for(int j=0;j<matrizTemporal.getMatriz()[i].length;j++){
            }
        }
    }
     /**Recibe la informacion de la operacion (llaves de las matrices a operar y de la matriz resultado y el simbolo de la operacion que se hara 
     * @param String respuesta
     * @param String operando1
     * @param String operando2
     * @param char operacion
     */ 
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
        }else if(operacion=='-'){
            m1=variables.get(operando1);
            m2=variables.get(operando2);
            resultado=m1.restar(m2);
            variables.put(respuesta,resultado);            
        }

    }   
     /**Consulta llave de una matriz 
     * @return variable
     */ 
    public String consulta(String variable){   
        return null;
    }
      /**Consulta si el HashMa insertado es correcto , si es correcto retorna true de lo contrario false
     * @return false,true
     */
    public boolean ok(){
        return false;
    }
   
}



