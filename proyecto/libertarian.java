/**
 * Write a description of class libertarian here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class libertarian extends Normal
{   
    private Triangle ficha;
    /**
       * Constructor for objects of class libertarian
     */
    public libertarian(int filaa,int columnaa,int posX,int posY, String jugador,boolean king,int tipo){
        super(filaa,columnaa,posX, posY,jugador,king,tipo);
        ficha=new Triangle(posX,posY);
    }
    public void changeColor(String color){
        super.changeColor(color);
        ficha.changeColor("magenta");
    }   
    public void moveFicha(int fila,int columna,int nuevaFila,int nuevaColumna){
	super.moveFicha(fila,columna,nuevaFila,nuevaColumna);
	ficha.changePos(fila+15,columna+15);
    }
}
