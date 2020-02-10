    
    import javax.swing.JOptionPane;
    import java.util.ArrayList;
    /**
    * Tablero de tamaño nxn dibujado sobre un canvas.
    * 
    * @author  Lina Buitrago and Santiago Laiton
    * @version 4.0.  (06 Febrero 2020) 
    */
    public class checkers {
    Tablero juego;
    Tablero configuracion;
    int medida;
    private ArrayList<Fichas>fichas;
    private Fichas fichaSelecionada;
    
    /**
    * Crea tableros de tamaño "width" cada uno a una distancia de 800 del otro
    * @param width
    */
    public checkers(int width)
    {
        medida=width;
        configuracion=new Tablero(width);
        juego= new Tablero(width,800,0);
        fichas=new ArrayList<Fichas>();
    }
    
    
    /**
     * Intercambian fichas de posición
     * @param top,right
     */
    public void shift(boolean top,boolean right  ) {
    
    }
    /**
     * Salta una ficha sobre otra 
     * @param top,right
     */
    public void jump(boolean top,boolean right){
    }
    /**
     * Mueve la ficha en el tablero
     * @param notacion
     */
    public void move(String notacion){
        if(fichaSelecionada!= null){
            int filaCuadrado=fichaSelecionada.getFila();
            int columnaCuadrado=fichaSelecionada.getColumna();
            if (notacion.equals("izqarriba")){                      
                fichaSelecionada.moveFicha(configuracion.getposxCuadrado(filaCuadrado-1,columnaCuadrado-1),configuracion.getposyCuadrado(filaCuadrado-1,columnaCuadrado-1));                                                                                                                                                                                                 
                fichaSelecionada.changePosition(configuracion.getposxCuadrado(filaCuadrado-1,columnaCuadrado-1),configuracion.getposyCuadrado(filaCuadrado-1,columnaCuadrado-1));
                fichaSelecionada.changePosition(filaCuadrado-1,columnaCuadrado-1);
            }else if(notacion.equals("izqabajo")){                
                    fichaSelecionada.moveFicha(configuracion.getposxCuadrado(filaCuadrado+1,columnaCuadrado-1),configuracion.getposyCuadrado(filaCuadrado+1,columnaCuadrado-1)); 
                    fichaSelecionada.changePosition(filaCuadrado+1,columnaCuadrado-1);
            }else if(notacion.equals("derabajo")){
                fichaSelecionada.moveFicha(configuracion.getposxCuadrado(filaCuadrado+1,columnaCuadrado+1),configuracion.getposyCuadrado(filaCuadrado+1,columnaCuadrado+1));
                fichaSelecionada.changePosition(filaCuadrado+1,columnaCuadrado+1);
            }else{                
                fichaSelecionada.moveFicha(configuracion.getposxCuadrado(filaCuadrado-1,columnaCuadrado+1),configuracion.getposyCuadrado(filaCuadrado-1,columnaCuadrado+1));
                fichaSelecionada.changePosition(filaCuadrado-1,columnaCuadrado+1);
            }
    }
    }
    /**
     * Adiciona una ficha king en el tablero y entrega mensajes al usuario en caso de error
     * @param king,fila,columna,jugador  
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
     * Adiciona fichas men en el tablero y entrega mensajes al usuario en caso de error
     * @param men,jugador
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
                Fichas Ficha= new Fichas(i+1,j+1,posX+10,posY+10,jugador);
                fichas.add(Ficha);
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
     * Selecciona la ficha y la identifica cambiandola de color a verde
     * @param fila,columna
     */
     public void select(int fila,int columna){
       for(int i=0;i<fichas.size();i++){
           if (fichas.get(i).getColor()=="green" && fichas.get(i).getJugador()=="j1"){
                fichas.get(i).changeColor("white");   
                fichaSelecionada=null;
            }
            else if (fichas.get(i).getColor()=="green" && fichas.get(i).getJugador()=="j2"){
                fichas.get(i).changeColor("red");
            }
            else if(fichas.get(i).getFila()==fila && fichas.get(i).getColumna()==columna){
               fichas.get(i).changeColor("green");
               fichaSelecionada=fichas.get(i);
            } 
            else if(fichas.get(i).getFila() + fichas.get(i).getColumna() % 2==0){
                JOptionPane.showMessageDialog(null,"Esta ficha no se puede seleccionar");                
            }
        }       
    }
    /**
     * Remueve una ficha del tablero
     * @param pieces
     */
    public void remove(int [][]pieces){
    }
    /**
     * Intercambia el tablero de juego con el de configuracion y viceversa 
     */
    public void swap(){
    }
    /**
     * Consulta posicion de la ficha
     * @return null
     */
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
        System.exit(0);
    }
    /**
     * Indica si la ultima operación se realizo 
     */
    public void ok(){
    }
}
