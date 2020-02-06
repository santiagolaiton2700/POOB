import javax.swing.JOptionPane;
import java.util.ArrayList;
public class Checkers
{
    Tablero juego;
    Tablero configuracion;
    int medida;
    public Checkers(int width)
    {
        medida=width;
        configuracion=new Tablero(width);
        juego= new Tablero(width,500,0);
        //configuracion
        //juego.moveTableroHorizontal();
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void select(int filas,int columnas){
        // put your code here
    }
    public void shift(boolean top,boolean right  ) {
    
    }
    public void jump(boolean top,boolean right){
    }
    public void move(String notation){
    }
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
                Fichas Ficha= new Fichas(fila,columna,posX+10,posY+10);
                if(jugador.equals("j1")){
                    Ficha.changeColor("white");
                }
                juego.changePosition(fila-1,columna-1,jugador);
            }else{
                JOptionPane.showMessageDialog(null,"No se puede añadir esta ficha en esta posicion");
                
            }
        }
    }
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
                Fichas Ficha= new Fichas(i,j,posX+10,posY+10);
                if(jugador.equals("j1")){
                    Ficha.changeColor("yellow");
                }
                juego.changePosition(i,j,jugador);
                }else{
                JOptionPane.showMessageDialog(null,"No se puede loca añadir esta ficha en esta posicion");                
               }
            }        
      }   
     }
     //System.out.println(simulador);
    }
    
    public void remove(int [][]pieces){
    }
    public void swap(){
    }
    public int[][] consult(){
        return null;
    }
    public void makeVisible(){
        juego.makeVisibleTablero();
        configuracion.makeVisibleTablero();
    }            
    public void makeInvisible(){
        juego.makeInvisibleTablero();
        configuracion.makeInvisibleTablero();
    }
    public void finish(){
    }
    public void ok(){
    }
}
