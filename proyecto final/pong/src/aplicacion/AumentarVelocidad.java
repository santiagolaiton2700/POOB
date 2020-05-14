package aplicacion;

import java.awt.Rectangle;

public class AumentarVelocidad extends Poder {
	
	
	public AumentarVelocidad(int x,int y ,int width,int heigth,int llave) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		esVivo=true;
		tipo=llave;
		this.imagen="bolaDos.png";
		this.figura=new Rectangle(x,y,width,heigth);
	}
	public AumentarVelocidad() {
		
	}
	
	
	public String getImagen() {
		return imagen;
	}
	public void activarPoder(Pong game,int indice) {
		System.out.println(indice);
		game.getBola().aumentarVelocidad(3.0/2.0);
	}
	public Rectangle getShape() {
		return figura;
	}
	public void quitarPoder(Pong game,int indice) {
		System.out.println(indice);
		game.getBola().disminuirVelocidad(3.0/4.0);
	}
}
