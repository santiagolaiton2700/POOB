package aplicacion;

import java.awt.Rectangle;

public class Energy extends Poder{		
		public Energy(int x,int y ) {
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
			Raqueta raqueta= (Raqueta)o;
			raqueta.setFortaleza((int) ((int)raqueta.getFortaleza()*0.50));
		}
		public void detener(Object o) {
			
		}
	}


