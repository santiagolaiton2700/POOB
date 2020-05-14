package aplicacion;

import java.awt.Rectangle;

public class fastBall extends Poder {
	
	
	public fastBall(int x,int y ) {
		this.x=x;
		this.y=y;
		this.dx = 10;
		this.figura=new Rectangle(x,y);
	}
	
	public Rectangle getShape() {
		return figura;
	}
	public void quitarPoder(Pong game,int indice) {
		System.out.println(indice);
		game.getBola().disminuirVelocidad(3.0/4.0);
	}
}
