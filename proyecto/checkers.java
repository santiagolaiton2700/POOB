import javax.swing.JOptionPane;
public class Checkers
{
    Tablero configuracion;
    Tablero juego;
    Tablero simulador;
    int medida;
    public Checkers(int width)
    {
        medida=width;
        configuracion=new Tablero(width);
        juego=new Tablero(width);
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
    public void add(boolean king, int fila,int columna){
         if(fila==0 || fila>medida && columna==0 ||fila>medida){
             JOptionPane.showMessageDialog(null,"Esta posicion esta fuera de los rangos de tablero");            
        }else if((fila+columna)%2==0){
                JOptionPane.showMessageDialog(null,"No se puede añadir esta ficha en esta posicion");
        }else{
            int posX=configuracion.getposxCuadrado(fila,columna);
            int posY=configuracion.getposyCuadrado(fila,columna);
            String posS=simulador.get(fila-1).get(columna-1);
            if(posS=="black" || posS=="white"){
                Fichas Ficha= new Fichas(fila,columna,posX+10,posY+10);
                //simulacion.get(fila).set(columna, lo que entre);
            }else{
                JOptionPane.showMessageDialog(null,"No se puede añadir esta ficha en esta posicion");
                
            }
        }
     }
    public void add(int[][] men){
    }
    public void remove(int [][]pieces){
    }
    public void swap(){
    }
    public int[][] consult(){
    }
    public void makeVisible(){
    }
    public void makeInvisible(){
    }
    public void finish(){
    }
    public void ok(){
    }
}
