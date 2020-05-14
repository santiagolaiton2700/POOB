package aplicacion;

import java.awt.Rectangle;

/**
 * Tipo de poder que disminuye la velocidad de la bola
 */
public class DisminuirVelocidad extends Poder {
	
	/**
	 * Constructor del poder
	 * @param x Es la posicion a crearlo en X 
	 * @param y Es la posicion a crearlo en Y
	 * @param width Es el ancho que va a ocupar el poder
	 * @param height Es el alto que va a ocupar el poder
	 */
	public DisminuirVelocidad(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.figura = new Rectangle(x, y, width, height);
		this.imagen = "disminuirVelocidad.gif";
	}
	
	/**
	 * Retorna el nombre de su imagen
	 */
	public String getImagen() {
		return imagen;
	}
	
	/**
	 * Activa el poder que es capaz de realizar
	 */
	public void activarPoder(Pong game, int indice) {
		game.getBola().disminuirVelocidad(3.0/2.0);
	}

	@Override
	public Rectangle getShape() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void quitarPoder(Pong game, int indice) {
		// TODO Auto-generated method stub
		
	}
}
