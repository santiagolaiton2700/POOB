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

		this.figura = new Rectangle(x, y, width, height);

	}
	

	
	/**
	 * Activa el poder que es capaz de realizar
	 */
	public void activarPoder(Pong game, int indice) {
		game.getBola().disminuirVelocidad(3.0/2.0);
	}



	@Override
	public void iniciar(Object o) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void detener(Object o) {
		// TODO Auto-generated method stub
		
	}

}
