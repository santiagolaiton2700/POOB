
import java.util.ArrayList;
import java.lang.Math;
/**
 * Fraccionario
 * Esta clase implementa el tipo de dato Fraccionario; es decir, un n�mero racional que se pueden escribir de la forma p/q, donde p y q son enteros, con q <> 0
 * La implemantacion se hace mediante objetos inmutables
 * INV: El fraccionario se encuentra representado en forma irreductible.
 * @author E.C.I.
 *
 */
public class Fraccionario {
    private int [] fraccionario =new int[2];
    private float resultado;
    
    /**Calcula el maximo comun divisor de dos enteros
     * Lo implementaremos mediante el algoritmo recursivo
     * @param a primer entero
     * @param b segundo entero
     * @return el Maximo Comun Divisor de a y b
     */  
    public static int mcd(int a,int b){
        int cont=0;       
        while (b>0 || b<0){
            cont=b;
            b=a%b;
            a=Math.abs(cont);
        }
        return (a);
    }        
    /**Crea un nuevo fraccionario, dado el numerador y el denominador
     * @param numerador
     * @param denominador. denominador <> 0
     */
    public Fraccionario (int numerador, int denominador) {        
        if(denominador<0 && numerador>0){
            fraccionario[0]=numerador*-1;
            fraccionario[1]=denominador*-1;
            resultado=(float)numerador/(float)denominador;
        }else if(numerador<0 && denominador<0){
            fraccionario[0]=numerador*-1;
            fraccionario[1]=denominador*-1;
            resultado=(float)numerador/(float)denominador;
        }else{
            fraccionario[0]= numerador;
            fraccionario[1]= denominador;
            resultado=(float)numerador/(float)denominador;
        }     
    }        
    /**Crea un fraccionario correspondiente a un entero
     * @param entero el entero a crear
     */
    public Fraccionario (int entero) {
        fraccionario[0]=entero;
        fraccionario[1]=1;
        resultado=entero;
    }

    /**Crea un fraccionario, a partir de su representacion mixta. 
     * El numero creado es enteroMixto + numeradorMixto/denominadorMixto
     * @param enteroMixto la parte entera del numero
     * @param numeradorMixto el numerador de la parte fraccionaria
     * @param denominadorMixto el denominador de la parte fraccionaria. denominadorMixto<>0
     */
    public Fraccionario (int enteroMixto, int numeradorMixto, int denominadorMixto) {

    }

    /**
     * Un fraccionario p/q esta escrito en forma simplificada si q es un entero positivo y 
     * el maximo comun divisor de p y q es 1.
     * @return El numerador simplificado del fraccionario
     */
    public int numerador(){      
        int respuesta=mcd(fraccionario[0],fraccionario[1]);
        int resultado=fraccionario[0]/respuesta;
        return resultado;       
    }
    
    /**
     * Un fraccionario p/q esta escrito en forma simplificada si q es un entero Positivo y 
     * el maximo comun divisor de p y q es 1.
     * @return el denominador simplificado del fraccionario
     */
    public int denominador() {
        int respuesta=mcd(fraccionario[0],fraccionario[1]);
        int resultado=fraccionario[1]/respuesta;
        return resultado;
    }    
    /**Suma este fraccionario con otro fraccionario
     * @param otro es otro fraccionario
     * @return este+otro
     */
    public Fraccionario sume (Fraccionario otro) {
        int numerador1=fraccionario[0];
        int denominador1=fraccionario[1];
        int numerador2=otro.getFraccionario()[0];
        int denominador2=otro.getFraccionario()[1];
        int numerador=(numerador1*denominador2)+(denominador1*numerador2);
        int denominador=denominador1*denominador2;      
        return new Fraccionario(numerador,denominador);
    }
    /**Resta este fraccionario con otro fraccionario
     * @param otro es otro fraccionario
     * @return este-otro
     */
    public Fraccionario reste (Fraccionario otro) {
        int numerador1=fraccionario[0];
        int denominador1=fraccionario[1];
        int numerador2=otro.getFraccionario()[0];
        int denominador2=otro.getFraccionario()[1];
        int numerador=(numerador1*denominador2)-(denominador1*numerador2);
        int denominador=denominador1*denominador2;      
        return new Fraccionario(numerador,denominador);
    } 
    
    /**Multiplica este fraccionario con otro fraccionario
     * @param otro El otro fraccionario
     * @return este * otro
     */
    public Fraccionario multiplique (Fraccionario otro) {
        int numerador1=fraccionario[0];
        int denominador1=fraccionario[1];
        int numerador2=otro.getFraccionario()[0];
        int denominador2=otro.getFraccionario()[1];
        int numerador=(numerador1*numerador2);
        int denominador=denominador1*denominador2;      
        return new Fraccionario(numerador,denominador);
    }
 
    
    /**Divide este fraccionario sobre otro fraccionario
     * @param otro El otro fraccionario
     * @return este * otro
     */
    public Fraccionario divida (Fraccionario otro) {
        int numerador1=fraccionario[0];
        int denominador1=fraccionario[1];
        int numerador2=otro.getFraccionario()[0];
        int denominador2=otro.getFraccionario()[1];
        int numerador=(numerador1*denominador2);
        int denominador=(numerador2*denominador1);      
        return new Fraccionario(numerador,denominador);
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (!obj.getClass().getSimpleName().equals("Fraccionario")){
            return false;
        }
        else{
            Fraccionario aux = (Fraccionario) obj;
            return (this.getResultado()==(aux.getResultado()));
        }                
    }
    /**
     * Retorna el resultado en forma decimal .
     * 
     */
    public float getResultado(){
        return this.resultado;
    }
    /**Compara este fraccionario con otro fraccionario
     * @param otro eL otro fraccionario
     * @return true si este fraccionario es igual matem�ticamente al otro fraccionario, False d.l.c.
     */
    public boolean equals (Fraccionario otro) {
        return false;
    }
    
    /**
     * Retorna un fraccionario de tipo int[] .
     * 
     */
    public int[] getFraccionario () {
        return fraccionario;
    }


    /** Calcula la representacion en cadena de un fraccionario en formato mixto simplificado
     * @see java.lang.Object#toString(java.lang.Object)
     */
    @Override
    public String toString() {
        return (String.valueOf(fraccionario[0])+"/"+String.valueOf(fraccionario[1]));
       
    }
    
}
