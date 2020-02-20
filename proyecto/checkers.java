    import javax.swing.JOptionPane;
    import java.util.ArrayList;
    import java.util.HashMap;
    /**
    * Tablero de tamaño nxn dibujado sobre un canvas.
    * 
    * @author  Lina Buitrago and Santiago Laiton
    * @version 5.0.  (06 Febrero 2020) 
    */
    public class checkers {
    private Tablero juego;
    private Tablero configuracion;
    private int medida;
    private ArrayList<Fichas>fichas;
    private Fichas fichaSelecionada;
    private HashMap<String, ArrayList> guardar;
    
    
    private boolean tableroEstoy;
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
        guardar=new HashMap<String,ArrayList>();
        tableroEstoy=true;
    }        
    /**
     * mueve fichas en el tablero con parametros boleeanos top y right 
     * @param top,right
     */
    public void shift(boolean top,boolean right  ) {
        if(fichaSelecionada!= null){
            int filaCuadrado=fichaSelecionada.getFila();
            int columnaCuadrado=fichaSelecionada.getColumna();
            if(top==true && right==false){
               if(filaCuadrado-1<1 ||columnaCuadrado-1<1){
                    JOptionPane.showMessageDialog(null,"No puede mover la ficha fuera del tablero");            
                }else{
                    moverFichas(filaCuadrado,columnaCuadrado,filaCuadrado-1,columnaCuadrado-1);                                  
                } 
            }else if(top==false && right==false){
                if(filaCuadrado+1>medida ||columnaCuadrado-1<1){
                    JOptionPane.showMessageDialog(null,"No puede mover la ficha fuera del tablero");            
                }else{
                   moverFichas(filaCuadrado,columnaCuadrado,filaCuadrado+1,columnaCuadrado-1);                                 
                }   
            }else if (top==false && right==true){
                if(filaCuadrado+1>medida ||columnaCuadrado+1>medida){
                    JOptionPane.showMessageDialog(null,"No puede mover la ficha fuera del tablero");            
                }else{
                    moverFichas(filaCuadrado,columnaCuadrado,filaCuadrado+1,columnaCuadrado+1);                              
                }
            }else if (top==true && right==true){
                if(filaCuadrado-1<1 ||columnaCuadrado+1>medida){
                    JOptionPane.showMessageDialog(null,"No puede mover la ficha fuera del tablero"); 
                }else{
                    moverFichas(filaCuadrado,columnaCuadrado,filaCuadrado-1,columnaCuadrado+1); 
                }
            }else{
                JOptionPane.showMessageDialog(null,"No se puede hacer shift"); 
            } 
            
        }
    }
    /**
     * Salta una ficha sobre otra 
     * @param top,right
     */
    public void jump(boolean top,boolean right){
        if(fichaSelecionada!= null){
            int filaCuadrado=fichaSelecionada.getFila();
            int columnaCuadrado=fichaSelecionada.getColumna();
            String jugador=fichaSelecionada.getJugador();            
            if (top==true && right==false){
                String posS=juego.getSimulacion(filaCuadrado-2,columnaCuadrado-2);                
                if(filaCuadrado-2<1 ||columnaCuadrado-2<1){
                    JOptionPane.showMessageDialog(null,"No puede mover la ficha fuera del tablero");                      
                }else if (jugador!=posS){                   
                    remove(filaCuadrado-1,columnaCuadrado-1); 
                    moverFichas(filaCuadrado,columnaCuadrado,filaCuadrado-2,columnaCuadrado-2);                                          
                }else{
                    moverFichas(filaCuadrado,columnaCuadrado,filaCuadrado-2,columnaCuadrado-2);                                        
                }
            }else if(top==false && right==false){
                String posS=juego.getSimulacion(filaCuadrado,columnaCuadrado-2);
                if(filaCuadrado+2>medida ||columnaCuadrado-2<1){
                    JOptionPane.showMessageDialog(null,"No puede mover la ficha fuera del tablero");            
                }else if (posS!=jugador){
                   remove(filaCuadrado+1,columnaCuadrado-1);                    
                   moverFichas(filaCuadrado,columnaCuadrado,filaCuadrado+2,columnaCuadrado-2);                                 
                }else{
                    moverFichas(filaCuadrado,columnaCuadrado,filaCuadrado+2,columnaCuadrado-2);                                 
                }                    
            }else if (top==false && right==true){
                String posS=juego.getSimulacion(filaCuadrado,columnaCuadrado);
                if(filaCuadrado+2>medida ||columnaCuadrado+2>medida){
                    JOptionPane.showMessageDialog(null,"No puede mover la ficha fuera del tablero");            
                }else if(posS!=jugador) {
                    remove(filaCuadrado+1,columnaCuadrado+1);                    
                    moverFichas(filaCuadrado,columnaCuadrado,filaCuadrado+2,columnaCuadrado+2);
                }else{
                    moverFichas(filaCuadrado,columnaCuadrado,filaCuadrado+2,columnaCuadrado+2);
                }    
            }else if (top==true && right==true){
                String posS=juego.getSimulacion(filaCuadrado-2,columnaCuadrado);
                if(filaCuadrado-2<1 ||columnaCuadrado+2>medida){
                    JOptionPane.showMessageDialog(null,"No puede mover la ficha fuera del tablero"); 
                }else if(posS!=jugador){
                    remove(filaCuadrado-1,columnaCuadrado+1);
                    moverFichas(filaCuadrado,columnaCuadrado,filaCuadrado-2,columnaCuadrado+2); 
                }else{
                    moverFichas(filaCuadrado,columnaCuadrado,filaCuadrado-2,columnaCuadrado+2); 
                }                
            }else{
                JOptionPane.showMessageDialog(null,"No puede saltar"); 
            }        
        }
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
                if(filaCuadrado-1<1 ||columnaCuadrado-1<1){
                    JOptionPane.showMessageDialog(null,"No puede mover la ficha fuera del tablero");            
                }else{
                    moverFichas(filaCuadrado,columnaCuadrado,filaCuadrado-1,columnaCuadrado-1);                                  
                }            
            }else if(notacion.equals("izqabajo")){
                if(filaCuadrado+1>medida ||columnaCuadrado-1<1){
                    JOptionPane.showMessageDialog(null,"No puede mover la ficha fuera del tablero");            
                }else{
                   moverFichas(filaCuadrado,columnaCuadrado,filaCuadrado+1,columnaCuadrado-1);                                 
                }                   
            }else if(notacion.equals("derabajo")){
                if(filaCuadrado+1>medida ||columnaCuadrado+1>medida){
                    JOptionPane.showMessageDialog(null,"No puede mover la ficha fuera del tablero");            
                }else{
                    moverFichas(filaCuadrado,columnaCuadrado,filaCuadrado+1,columnaCuadrado+1);                              
                }
            }else if(notacion.equals("derarriba")){
                if(filaCuadrado-1<1 ||columnaCuadrado+1>medida){
                    JOptionPane.showMessageDialog(null,"No puede mover la ficha fuera del tablero"); 
                }else{
                    moverFichas(filaCuadrado,columnaCuadrado,filaCuadrado-1,columnaCuadrado+1); 
                }
            }else{
                JOptionPane.showMessageDialog(null,"Solo puede moverse izqarriba,izqabajo,derabajo,derarriba"); 
                }
         }
    }  
    /**
     * Mueve las fichas 
     * @param recibe la fila y la columna a donde se tiene que mover
     */
    private void moverFichas(int filaPas,int columnaPas,int fila,int columna){
        String posSConfi=configuracion.getSimulacion(fila-1,columna-1);
        String posSJuego=juego.getSimulacion(fila-1,columna-1);
        String jugador=fichaSelecionada.getJugador();
        String colorPasConfi=configuracion.getColorCuadrado(filaPas,columnaPas);
        String colorPasJuego=juego.getColorCuadrado(filaPas,columnaPas);        
        if(tableroEstoy==true){
            if (posSConfi=="white"||posSConfi=="black"){
                fichaSelecionada.moveFicha(configuracion.getposxCuadrado(fila,columna),configuracion.getposyCuadrado(fila,columna));                                                                                                                                                                                                 
                fichaSelecionada.changePosition(fila,columna);
                configuracion.changePosition(filaPas-1,columnaPas-1,fila-1,columna-1,colorPasConfi,jugador);
            }else{
                JOptionPane.showMessageDialog(null,"No se puede mover");            
            }                    
        }else{
            if (posSJuego=="white"||posSJuego=="black"){
                fichaSelecionada.moveFicha(juego.getposxCuadrado(fila,columna),juego.getposyCuadrado(fila,columna));                                                                                                                                                                                                 
                fichaSelecionada.changePosition(fila,columna);
                juego.changePosition(filaPas-1,columnaPas-1,fila-1,columna-1,colorPasConfi,jugador);
            }else{
                JOptionPane.showMessageDialog(null,"No se puede mover");            
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
            if ((posS.equals("black") || posS.equals("white")) && king==true){
                Fichas Ficha= new Fichas(fila,columna,posX+10,posY+10,jugador);
                if(jugador.equals("j1")){
                    Ficha.changeColor("yellow");                    
                }else{
                    Ficha.changeColor("blue");
                }
                fichas.add(Ficha);
            }
            else if(posS.equals("black") || posS.equals("white")){
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
        for(int i=0;i<pieces.length;i++){
            for(int j=0;j<pieces[0].length;j++){
                if(pieces[i][j]==1){
                    remove(i+1,j+1);
                }
            }
        }
    }
    /**
    *Remueve la ficha del tablero en la fila y columna que el usuario quiera
    *
    */
    public void remove(int fila,int columna){       
        for(int i=0;i<fichas.size();i++){
           int filatempo = fichas.get(i).getFila();
           int columnatempo = fichas.get(i).getColumna();
           if (filatempo==fila && columnatempo==columna){               
               fichas.get(i).MakeInvisible();
               fichas.remove(i);    
           }
       }
    }
    /**
    * Intercambia el tablero de juego con el de configuracion y viceversa 
    */
    public void swap(){
        for (int i=0;i<fichas.size();i++){
            int filaCuadrado=fichas.get(i).getFila();
            int columnaCuadrado=fichas.get(i).getColumna();
            int xJuego=juego.getposxCuadrado(filaCuadrado,columnaCuadrado);
            int yJuego=juego.getposyCuadrado(filaCuadrado,columnaCuadrado);
            int xconfiguracion=configuracion.getposxCuadrado(filaCuadrado,columnaCuadrado);
            int yconfiguracion=configuracion.getposyCuadrado(filaCuadrado,columnaCuadrado);
            String colorConfi=configuracion.getColorCuadrado(filaCuadrado,columnaCuadrado);
            String jugador=fichas.get(i).getJugador();
            if (tableroEstoy==true){               
                fichas.get(i).moveFicha(xJuego,yJuego);
                configuracion.changePosition(filaCuadrado-1,columnaCuadrado-1,colorConfi);                         
                juego.changePosition(filaCuadrado-1,columnaCuadrado-1,jugador);   
            }else if (tableroEstoy==false){
                fichas.get(i).moveFicha(xconfiguracion,yconfiguracion);
                configuracion.changePosition(filaCuadrado-1,columnaCuadrado-1,jugador);   
                juego.changePosition(filaCuadrado-1,columnaCuadrado-1,colorConfi);
            }
        }
        if (tableroEstoy==true){
            tableroEstoy=false;           
        }else{
            tableroEstoy=true;           
        }
        
        System.out.println(configuracion.getSimulacion()+"configuracion");
        System.out.println(juego.getSimulacion()+"juego");
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
        for (int i=0;i<fichas.size();i++){
            fichas.get(i).MakeVisible();
        }               
    }  
    /**
     * Hace el tablero invisible.Si ya esta invisible no hace nada.
     */
    public void makeInvisible(){       
        for (int i=0;i<fichas.size();i++){
            fichas.get(i).MakeInvisible();
        }      
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
    public void save(String name){
        ArrayList<Tablero>tableros=new ArrayList<Tablero>();       
        tableros.add(configuracion);
        tableros.add(juego);
        guardar.put(name,tableros);
    }
    public void recovery(String name){
        guardar.get(name);
    }
}
