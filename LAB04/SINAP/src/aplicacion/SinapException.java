package aplicacion; 
public class SinapException extends Exception{
    public static final String VACIO ="No puede ser un campo vacio!";
    public static final String REPETIDO ="No se puede repetir";
    public static final String MAYOR ="El valor del area debe ser mayor a 0";
    public SinapException(String message){
        super(message);
    }
}