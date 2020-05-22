package aplicacion;

import java.awt.Rectangle;
import java.io.Serializable;

public class Target implements Serializable{
	private int x;
	private int y;
	private int width;
	private int height;
	private String nombreImg;
	private Rectangle figura;
	public Target(int x,int y,int width,int heigth) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=heigth;
		this.nombreImg="target";
		this.figura=new Rectangle(x,y,width,heigth);
	}
	
	public boolean TargetImpactado(Bola bola) {
		return ( bola.getShape().intersects(figura))? true: false; 
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void iniciar(Bola bola) {
		
	}
	public String getImagen() {
		return nombreImg;
	}

	
}
