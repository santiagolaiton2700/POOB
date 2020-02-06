
import javax.swing.JOptionPane;
import java.util.ArrayList;
/**
 * Tablero de tamaño nxn dibujado sobre un canvas.
 * 
 * @author  Lina Buitrago and Santiago Laiton
 * @version 4.0.  (02 Febrero 2020) 
 */
public class checkers {
    Tablero juego;
    Tablero configuracion;
    int medida;
    private ArrayList<Fichas>fichas;
  
     /**
     * Crea dos tableros de tamaño "width" cada uno a una distancia de 800 del otro
     */
    public checkers(int width)
    {
        medida=width;
        configuracion=new Tablero(width);
        juego= new Tablero(width,800,0);
        fichas=new ArrayList<Fichas>();
        //configuracion
        //juego.moveTableroHorizontal();
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
    public void shift(boolean top,boolean right  ) {
    
    }
    public void jump(boolean top,boolean right){
    }
    /**public void move(String notation){
        for(int i=0;i<fichas.size();i++){
           if (fichas.get(i).getColor()=="green" && fichas.get(i).getJugador()=="j1"){
            if notacion.equals("izq"){
                //fichas.get(i).getFila()==fila && fichas.get(i).getColumna()==columna
            }    ficha.get(i).erase()
            if else notacion.equals("der"){
                
            }  
        }
    }*/
    /**
     * Adiciona una ficha king en el tablero en la coordenada fila,columna indicando el jugador , en caso de intentar adicionar la ficha en una posicon incorrecta se mostrara el respectivo mensaje de error al usuario 
     */
    public void add(boolean king, int fila,int columna,String jugador){
        if(fila==0 || fila>medida && columna==0 ||fila>medida){
             JOptionPane.showMessageDialog(null,"Esta posicion esta fuera de los rangos de tablero");            
        }else if((fila+columna)%2==0){
                JOptionPane.showMessageDialog(null,"No se puede añadir esta ficha en esta posicion");
        }else{
            int posX=configuracion.getposxCuadrado(fila,columna);
            int posY=configuracion.getposyCuadrado(fila,columna);
            String posS=configuracion.getSimulacion(fila-1,columna-1);
            if(posS.equals("black") || posS.equals("white")){
                System.out.println(fila+"fila");
                Fichas Ficha= new Fichas(fila,columna,posX+10,posY+10,jugador);
                fichas.add(Ficha);
                if(jugador.equals("j1")){
                    Ficha.changeColor("white");
                }
                juego.changePosition(fila-1,columna-1,jugador);
            }else{
                JOptionPane.showMessageDialog(null,"No se puede añadir esta ficha en esta posicion");
                
            }
        }
        
    }
    /**
     * Adiciona fichas men por medio de una matriz de enteros donde 1 es ficha y 0 espacio vacio e indicando el jugador ;en caso de intentar adicionar la ficha en una posicon incorrecta se mostrara el respectivo mensaje de error al usuario
     */
    public void add(int[][] men,String jugador){
        for(int i=0;men.length>i;i++){
            for(int j=0;men.length>j;j++){           
             if (men.length>medida){
                JOptionPane.showMessageDialog(null,"Esta posicion esta fuera de los rangos de tablero");            
             }else if((i+j)%2==0 || men[i][j]==0){
                JOptionPane.showMessageDialog(null,"No se puede añadir esta ficha en esta posicion");            
             }else{
                int posX=configuracion.getposxCuadrado(i+1,j+1);
                int posY=configuracion.getposyCuadrado(i+1,j+1);
                String posS=configuracion.getSimulacion(i,j);
               if(posS.equals("j1")||posS.equals("j2")){
                   JOptionPane.showMessageDialog(null,"No esta libre");            
                }else if(posS.equals("black") || posS.equals("white")){
                Fichas Ficha= new Fichas(i,j,posX+10,posY+10,jugador);
                if(jugador.equals("j1")){
                    Ficha.changeColor("white");
                }
                juego.changePosition(i,j,jugador);
                }else{
                JOptionPane.showMessageDialog(null,"No se puede loca añadir esta ficha en esta posicion");                
               }
            }        
      }   
     }
    }
    /**
     * Selecciona la ficha ubicada en la coordenada (fila,columna) y la cambia de color 
     */
     public void select(int fila,int columna){
       for(int i=0;i<fichas.size();i++){
           if (fichas.get(i).getColor()=="green" && fichas.get(i).getJugador()=="j1"){
                fichas.get(i).changeColor("white");   
             
            }
            else if (fichas.get(i).getColor()=="green" && fichas.get(i).getJugador()=="j2"){
                fichas.get(i).changeColor("red");
            }
            else if(fichas.get(i).getFila()==fila && fichas.get(i).getColumna()==columna){
               System.out.print("aqui voy");
               fichas.get(i).changeColor("green");
               
            } 
            else if(fichas.get(i).getFila() + fichas.get(i).getColumna() % 2==0){
            
                JOptionPane.showMessageDialog(null,"Esta ficha no se puede seleccionar");                
            }
        }
       
    }
    public void remove(int [][]pieces){
    }
    /**
     * Intercambia el tablero de juego con el de configuracion y viceversa 
     */
    public void swap(){
    }
    public int[][] consult(){
        return null;
    }
    /**
     * Hace el tablero visible.Si ya esta visible no hace nada.
     */
    public void makeVisible(){
        juego.makeVisibleTablero();
        configuracion.makeVisibleTablero();
    }  
    /**
     * Hace el tablero invisible.Si ya esta invisible no hace nada.
     */
    public void makeInvisible(){
        juego.makeInvisibleTablero();
        configuracion.makeInvisibleTablero();
    }
    /**
     * Termina el juego y no permite ejecutar mas metodos
     */
    public void finish(){
    }
    public void ok(){
    }
}
