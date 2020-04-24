package aplicacion;


import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

public class Bola {
	private static final int TAMX=22;
	private static final int TAMY=22;
	private double x;
	private double y;
	private double dx;
	private double dy;
	private double dy0;
	private double dx0;
	private Ellipse2D figura;
	private int width;
	private double height;
	private boolean isFast=false;
	private boolean isSlow=false;
	private boolean diagonal = false;
	public Bola(double x, double y, double dx, double dy, int width, int height) {
		this.x=x;
		this.y=y;
		this.dx=dx;
		this.dy=dy;
		this.dx0=dx;
		this.width=width;
		this.height=height;
		figura=new Ellipse2D.Double(x, y, TAMX, TAMY);
		
	}
	public void muevePelotaca() {
		x+=dx;
		y-=dy;
		if(x<200) {
			x=200;
			dx=-dx;
		}
		if(x+TAMX >=750) {
			x=750-TAMX;
			dx=-dx;
		}
		if(y<20) {
			y=20;
			dy=-dy;
		}
		//if(y>650) {
		//	y=650;
		//	dy=-dy;
		//}
		figura.setFrame(x,y,TAMX, TAMY);
	}
	public void setXPosition(int x) {
		this.x=x;
		figura.setFrame(this.x,this.y,TAMX,TAMY);
	}
	public void cambiePosition(int x) {
		this.x += x;
		figura.setFrame(this.x , this.y, TAMX, TAMY);
	}
	public Ellipse2D getShape(){
		return figura; 
	}
	public int getYPosition() {
		return (int) y;
	}
	public void choqueRaqueta(int xPos,int yPos,int width,int height) {
		Rectangle centroIzquierda=new Rectangle(xPos + width/6,yPos,width/6,height/4);
		Rectangle centroDerecha=new Rectangle(xPos + width / 2, yPos, width / 3, height / 4);
		if(figura.intersects(centroIzquierda)) {
			dy=Math.abs(dx0);
			dx=-Math.abs(dx0);
		}else if (figura.intersects(centroDerecha)) {
			dy=Math.abs(dy0);
			dx=Math.abs(dx0);
		}
	}

	
}
