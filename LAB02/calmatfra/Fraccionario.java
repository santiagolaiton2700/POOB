import java.util.ArrayList;
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
        while (b>0){
            cont=b;
            b=a%b;
            a=cont;
        }
        return a;
    }        
    /**Crea un nuevo fraccionario, dado el numerador y el denominador
     * @param numerador
     * @param denominador. denominador <> 0
     */
    public Fraccionario (int numerador, int denominador) {
    fraccionario[0]= numerador;
    fraccionario[1]= denominador;
    resultado=numerador/denominador;
    
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
    public int numerador() {
        return fraccionario[0];
    }
    
    /**
     * Un fraccionario p/q esta escrito en forma simplificada si q es un entero Positivo y 
     * el maximo comun divisor de p y q es 1.
     * @return el denominador simplificado del fraccionario
     */
    public int denominador() {
        return fraccionario[1];
    }
    
    /**Suma este fraccionario con otro fraccionario
     * @param otro es otro fraccionario
     * @return este+otro
     */
    public Fraccionario sume (Fraccionario otro) {
        return null;
    }
    
    /**Multiplica este fraccionario con otro fraccionario
     * @param otro El otro fraccionario
     * @return este * otro
     */
    public Fraccionario multiplique (Fraccionario otro) {
        return null;
    }
    
    
    /**Divide este fraccionario sobre otro fraccionario
     * @param otro El otro fraccionario
     * @return este * otro
     */
    public Fraccionario divida (Fraccionario otro) {
        return null;
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


    /** Calcula la representacion en cadena de un fraccionario en formato mixto simplificado
     * @see java.lang.Object#toString(java.lang.Object)
     */
    @Override
    public String toString() {
        return (fraccionario[0]+"/"+fraccionario[1]);
    }
    
}