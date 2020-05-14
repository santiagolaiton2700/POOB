package aplicacion;

public class PongException extends Exception{
	public static final String NO_GUARDADO="No se puede guardar";

	public PongException(String message) {
		super(message);
	}

}
