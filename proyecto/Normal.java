import java.util.ArrayList;
/**
 * Fichas de tipo circulo dibujadas sobre un canvas.
 * 
 * @author  Lina Buitrago and Santiago Laiton
 * * @version 1.0.  (30 Enero 2020) 
 * @version 2.0.  (06 Febrero 2020) 
 * @version 3.0.  (21 Febrero 2020) 
 */
public class Normal implements Fichas
{   
	private int posicionX;
	private int posicionY;
	private int columna;
	private int fila;
	private Circle ficha;
	private String jugador; 
	private boolean isKing;
	private boolean estoyViva;
	private int tipoo;
	/**
	 * Crea una ficha de tipo circulo a partir de los parametros dados
	 * @param posX ,posY ,fila, columna, jugador, king
	 * 
	 */
	public Normal(int filaa,int columnaa,int posX,int posY, String jugador,boolean king,int tipo)
	{
		posicionX=posX;
		posicionY=posY;
		fila=filaa;
		isKing=king;
		columna=columnaa;
		ficha=new Circle(posicionX,posicionY);
		ficha.makeVisible();
		this.jugador=jugador;
		estoyViva=true;
		tipoo=tipo;
	}
	/**
	 * Cambia el color de la ficha
	 */
	public void changeColor(String color){
		ficha.changeColor(color);
	}
	/**
	 * Retorna la fila donde esta la ficha
	 * @return fila
	 */
	public int getFila(){
		return fila;
	}
	/**
	 * Retorna la columna donde esta la ficha
	 * @return columna
	 */
	public int getColumna(){
		return columna;
	}
	/**
	 * Cambia el color de la ficha a verde

	 */
	public void setcolorgreen(){
		this.changeColor("magenta");
	}
	/**
	 * Retorna el color actual de la ficha
	 * @return color de la ficha
	 */
	public String getColor(){
		return ficha.getColor();
	}
	/**
	 * Retorna el jugador al que corresponde la ficha
	 * @return jugador
	 */
	public String getJugador(){
		return jugador;
	}
	/**
	 * Mueve la ficha 10 en fila y 10 en columna 
	 * @param fila,columna
	 */
	public void moveFicha(int fila, int columna,int nuevaFila,int nuevaColumna){
		ficha.changePos(fila+10,columna+10);
		changePosition(nuevaFila,nuevaColumna);
		changePosition(nuevaFila,nuevaColumna);        
	}
	/**
	 * Hace la ficha invisible , si ya esta invisible no hace nada

	 */
	public void MakeInvisible(){
		ficha.makeInvisible();
	}
	/**
	 * Hace la ficha visible , si ya esta visible no hace nada

	 */
	public void MakeVisible(){
		ficha.makeVisible();    
	}
	/**
	 * cambia la posicion de la fila y de la columna en una ficha
	 * @param nuevafila y nueva columna
	 */
	public void changePosition(int nuevaFila,int nuevaColumna){
		fila=nuevaFila;
		columna=nuevaColumna;
	}
	public boolean isKing(){
		return isKing==true;
	}
	public void setKing(){
		isKing=true;
	}
	public boolean morir() {
		MakeInvisible();
		estoyViva=false;
		return estoyViva;		
	}
	public int getType(){
	   return tipoo;
	}
}
