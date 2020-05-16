package aplicacion;
import java.awt.Rectangle;
public class Turtle extends Poder{

		public Turtle(int x,int y ) {
			this.x=x;
			this.y=y;
			this.dx = 1;
			this.figura=new Rectangle(x,y,30,80);
		}
		
		public Rectangle getShape() {
			return figura;
		}
		@Override
		public void iniciar(Object o) {	
			Raqueta raqueta= (Raqueta)o;
			raqueta.setDistancia(1);
		}
		public void detener(Object o) {
			Raqueta raqueta= (Raqueta)o;
			raqueta.setDistancia(2);
		}
	}




