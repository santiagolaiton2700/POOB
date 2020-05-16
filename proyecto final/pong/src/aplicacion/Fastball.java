package aplicacion;

import java.awt.Rectangle;

public class Fastball extends Poder {
	
	
	public Fastball(int x,int y ) {
		this.x=x;
		this.y=y;
		this.dx = 1;
		this.figura=new Rectangle(x,y,30,80);
	}
	
	public Rectangle getShape() {
		return figura;
	}
	/**
	public void quitarPoder(Pong game,int indice) {
		System.out.println(indice);
		game.getBola().disminuirVelocidad(3.0/4.0);
	}**/
	
	@Override
	public void iniciar(Object o) {
		Bola bola = (Bola)o;
		double aux = bola.getDx0()*2;

		bola.setDx((bola.getDx()>0)? (bola.getDx()+aux) : (bola.getDx()-aux) );
		bola.setDy((bola.getDy()>0)? (bola.getDy()+aux) : (bola.getDy()-aux) );
		
	}
	public void detener(Object o) {
		Bola bola = (Bola)o;
		double aux = bola.getDx0()*2;

		bola.setDx((bola.getDx()>0)? (bola.getDx()-aux) : (bola.getDx()+aux) );
		bola.setDy((bola.getDy()>0)? (bola.getDy()-aux) : (bola.getDy()+aux) );
	}
}
