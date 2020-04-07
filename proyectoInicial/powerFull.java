/**
 * Write a description of class libertarian here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class powerFull extends Normal
{   
    private int x;
    private Triangle ficha;
    /**
       * Constructor for objects of class libertarian
     */
    public powerFull(int filaa,int columnaa,int posX,int posY, String jugador,boolean king,int tipo){
        super(filaa,columnaa,posX, posY,jugador,king,tipo);
        ficha=new Triangle(posX,posY);
    }
    public void changeColor(String color){
        super.changeColor(color);
        ficha.changeColor("Orange");
    }
    public void jump(boolean top,boolean right){                
    }   
}
