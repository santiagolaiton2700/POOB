import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Tablero de tamaño nxn dibujado sobre un canvas.   
 * @author  Lina Buitrago and Santiago Laiton
 * 
 * @version 1.0.  (30 Enero 2020) 
 * @version 2.0.  (06 Febrero 2020) 
 * @version 3.0.  (21 Febrero 2020) 
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
     * Crea tableros de tamaño "width", width es el numero de cuadrados por lado de el tablero, cada uno a una distancia de 800 del otro
     * @param width
     */
    public checkers(int width)
    {
        medida=width;      
        crearTablero();
        guardar=new HashMap<String,ArrayList>();
        tableroEstoy=true;         
    }        
    private void crearTablero(){
        configuracion=new Tablero(medida);
        juego= new Tablero(medida,800,0);
        fichas=new ArrayList<Fichas>();        
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
            if(!((top==true && right==false &&(filaCuadrado-2<1 ||columnaCuadrado-2<1))|| (top==false && right==false&&(filaCuadrado+2>medida ||columnaCuadrado-2<1)) || (top==false && right==true && (filaCuadrado+2>medida ||columnaCuadrado+2>medida)) || (top==true && right==true &&(filaCuadrado-2<1 ||columnaCuadrado+2>medida)))){
                if (top==true && right==false){
                    String posS=juego.getSimulacion(filaCuadrado-2,columnaCuadrado-2);                
                    //if(){
                    if (!((posS.equals(jugador)) || (posS.equals(jugador+"k")))){                   
                        remove(filaCuadrado-1,columnaCuadrado-1);
                    }
                    moverFichas(filaCuadrado,columnaCuadrado,filaCuadrado-2,columnaCuadrado-2);
                }else if(top==false && right==false){
                    String posS=juego.getSimulacion(filaCuadrado,columnaCuadrado-2);        
                    if (!((posS.equals(jugador)) || (posS.equals(jugador+"k")))){                    
                        remove(filaCuadrado+1,columnaCuadrado-1);
                    }
                    moverFichas(filaCuadrado,columnaCuadrado,filaCuadrado+2,columnaCuadrado-2);                   
                }else if (top==false && right==true){               
                    String posS=juego.getSimulacion(filaCuadrado,columnaCuadrado);                
                    //if(){
                    if(!((posS.equals(jugador)) || (posS.equals(jugador+"k")))) {      
                        remove(filaCuadrado+1,columnaCuadrado+1);
                    }
                    moverFichas(filaCuadrado,columnaCuadrado,filaCuadrado+2,columnaCuadrado+2);
                }else if (top==true && right==true){
                    String posS=juego.getSimulacion(filaCuadrado-2,columnaCuadrado);                
                    //if(){
                    if(!((posS.equals(jugador)) || (posS.equals(jugador+"k")))){                   
                        remove(filaCuadrado-1,columnaCuadrado+1);
                    }
                    moverFichas(filaCuadrado,columnaCuadrado,filaCuadrado-2,columnaCuadrado+2);                        
                }
            }else{
                JOptionPane.showMessageDialog(null,"No puede mover la ficha fuera del tablero");
            }
        } 
    }
    /**
     * Mueve la ficha en el tablero
     * @param notacion
     */
    public void moveArena(String notacion){
        if (notacion.indexOf("-")!=-1){
            String [] listamove=notacion.split("-");         
            for (int i=0;i+1<listamove.length;i++){
                int posActual = Integer.parseInt(listamove[i]);
                int posFuturo = Integer.parseInt(listamove[i+1]); 
                int [] actual=juego.getPosicion(posActual);
                int [] futuro=juego.getPosicion(posFuturo);
                select(actual[0]+1,actual[1]+1);                
                if(futuro[0]-actual[0]==-1 && futuro[1]-actual[1]==-1){                    
                    move("izqarriba");
                }else if(futuro[0]-actual[0]==-1 && futuro[1]-actual[1]==1){
                    move("derarriba");
                }else if(futuro[0]-actual[0]==1 && futuro[1]-actual[1]==1){
                    move("derabajo");
                }else if(futuro[0]-actual[0]==1 && futuro[1]-actual[1]==-1){
                    move("izqabajo");
                }
                select(futuro[0]+1,futuro[1]+1);  
            }
        }else if(notacion.indexOf("x")!=-1){
            String [] listajump=notacion.split("x");
            for (int i=0;i+1<listajump.length;i++){
                int posActual = Integer.parseInt(listajump[i]);
                int posFuturo = Integer.parseInt(listajump[i+1]); 
                int [] actual=juego.getPosicion(posActual);
                int [] futuro=juego.getPosicion(posFuturo);
                select(actual[0]+1,actual[1]+1);
                if(futuro[0]-actual[0]==-2 && futuro[1]-actual[1]==-2){
                    jump(true,false);             
                }else if(futuro[0]-actual[0]==-2 && futuro[1]-actual[1]==2){
                    jump(true,true);             
                }else if(futuro[0]-actual[0]==2 && futuro[1]-actual[1]==2){
                    jump(false,true);
                }else if(futuro[0]-actual[0]==2 && futuro[1]-actual[1]==-2){
                    jump(false,false);
                }
                select(futuro[0]+1,futuro[1]+1);  
            }            
        }
    }

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
                JOptionPane.showMessageDialog(null,"Solo puede moverse derabajo,derarriba"); 
            }
        }          
    } 
    /**
     * Mueve las fichas 
     * @param recibe la fila y la columna a donde se tiene que mover
     */
    private void moverFichas(int filaPas,int columnaPas,int fila,int columna){
        String jugador=fichaSelecionada.getJugador();
        String colorPasjuego = juego.colorCambio(fila, columna, filaPas, columnaPas);
        if (colorPasjuego.equals("NO")) {
            JOptionPane.showMessageDialog(null,"No se puede mover");
        }else {
            if (!(colorPasjuego.equals("NO"))) {
                fichaSelecionada.moveFicha(juego.getposxCuadrado(fila,columna),juego.getposyCuadrado(fila,columna),fila,columna);                                                                                                                                                                                                 
                juego.changePosition(filaPas-1,columnaPas-1,fila-1,columna-1,colorPasjuego,jugador);
            }
        }
    }            
    /**
     * Adiciona una ficha king en el tablero y entrega mensajes al usuario en caso de error
     * @param king,fila,columna,jugador  
     */
    public void add(boolean king, int fila,int columna,String jugador,int tipo){
        if(fila==0 || fila>medida && columna==0 ||fila>medida){
            JOptionPane.showMessageDialog(null,"Esta posicion esta fuera de los rangos de tablero");            
        }else if((fila+columna)%2==0){
            JOptionPane.showMessageDialog(null,"No se puede añadir esta ficha en esta posicion");
        }else{            
            int posX=configuracion.getposxCuadrado(fila,columna);
            int posY=configuracion.getposyCuadrado(fila,columna);
            String posS=configuracion.getSimulacion(fila-1,columna-1);           
            if ((posS.equals(".") || posS.equals("-")) && king==true){
                Fichas Ficha= Fichas.crearFichas(fila,columna,posX+10,posY+10,jugador,true,tipo);
                configuracion.changePosition(fila-1,columna-1,jugador+"k");
                if(jugador.equals("j1")){
                    Ficha.changeColor("yellow");                    
                }else{
                    Ficha.changeColor("blue");
                }
                fichas.add(Ficha);
            }
            else if(posS.equals("-") || posS.equals(".")){
                Fichas Ficha= Fichas.crearFichas(fila,columna,posX+10,posY+10,jugador,false,tipo);
                fichas.add(Ficha);
                if(jugador.equals("j1")){
                    Ficha.changeColor("white");                                        
                }
                configuracion.changePosition(fila-1,columna-1,jugador); 
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
                    }else if(posS.equals(".") || posS.equals("-")){
                        Fichas Ficha= Fichas.crearFichas(i+1,j+1,posX+10,posY+10,jugador,false,1);
                        fichas.add(Ficha);
                        if(jugador.equals("j1")){
                            Ficha.changeColor("white");
                        }
                        configuracion.changePosition(i,j,jugador);
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
            if (fichas.get(i).isKing() && fichas.get(i).getColor()=="green" && fichas.get(i).getJugador()=="j2"){
                fichas.get(i).changeColor("blue");
                fichaSelecionada=null;
            }else if(fichas.get(i).isKing() && fichas.get(i).getColor()=="green" && fichas.get(i).getJugador()=="j1"){
                fichas.get(i).changeColor("yellow");
                fichaSelecionada=null;
            }else if (fichas.get(i).getColor()=="green" && fichas.get(i).getJugador()=="j1"){
                fichas.get(i).changeColor("white");   
                fichaSelecionada=null;
            }else if (fichas.get(i).getColor()=="green" && fichas.get(i).getJugador()=="j2"){
                fichas.get(i).changeColor("red");
                fichaSelecionada=null;
            }else if(fichas.get(i).getFila()==fila && fichas.get(i).getColumna()==columna){
                fichas.get(i).changeColor("green");
                fichaSelecionada=fichas.get(i);
            }else if(fichas.get(i).getFila() + fichas.get(i).getColumna() % 2==0){
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
            String colorPasado=configuracion.getColorCuadrado(filatempo,columnatempo);
            if (filatempo==fila && columnatempo==columna){               
                if(fichas.get(i).morir()) {
                    fichas.remove(i);    
                }
                if (colorPasado=="black"){
                    colorPasado=".";
                }else{
                    colorPasado="-";
                }
            }
            if(tableroEstoy){
                configuracion.changePosition(fila-1,columna-1,colorPasado);                  
            }else{
                juego.changePosition(fila-1,columna-1,colorPasado);
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
            String colorJuego=juego.getColorCuadrado(filaCuadrado,columnaCuadrado);
            String jugador=fichas.get(i).getJugador();
            if (tableroEstoy==true){
                if(colorConfi=="black"){
                    colorConfi=".";
                }else{
                    colorConfi="-";
                }
                if (fichas.get(i).getColor()=="blue"){
                    jugador="j2k";
                }else if(fichas.get(i).getColor()=="yellow"){
                    jugador="j1k";
                }
                fichas.get(i).moveFicha(xJuego,yJuego,filaCuadrado,columnaCuadrado);
                configuracion.changePosition(filaCuadrado-1,columnaCuadrado-1,colorConfi);                         
                juego.changePosition(filaCuadrado-1,columnaCuadrado-1,jugador);  
            }else if (tableroEstoy==false){
                if(colorConfi=="black"){
                    colorJuego=".";
                }else{
                    colorJuego="-";
                }
                if (fichas.get(i).getColor()=="blue"){
                    jugador="j2k";
                }else if(fichas.get(i).getColor()=="yellow"){
                    jugador="j1k";
                }             
                fichas.get(i).moveFicha(xconfiguracion,yconfiguracion,filaCuadrado,columnaCuadrado);
                configuracion.changePosition(filaCuadrado-1,columnaCuadrado-1,jugador);   
                juego.changePosition(filaCuadrado-1,columnaCuadrado-1,colorJuego);
            }
        }
        if (tableroEstoy==true){
            tableroEstoy=false;           
        }else{
            tableroEstoy=true;           
        }               
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
    /**
     * Guarda todas las jugadas del tablero de configuracion 
     * @param name
     */
    public void save(String name){
        ArrayList<ArrayList<ArrayList<String>>>tableros=new ArrayList<ArrayList<ArrayList<String>>>();
        ArrayList<ArrayList<String>> simuConfiguracion=new ArrayList<ArrayList<String>>();
        for (int i=0;i<configuracion.getSimulacion().size();i++){
            simuConfiguracion.add(new ArrayList<String>());
            for (int j=0;j<configuracion.getSimulacion().size();j++){                
                simuConfiguracion.get(i).add(configuracion.getSimulacion().get(i).get(j));
            }
        }   
        tableros.add(simuConfiguracion);
        guardar.put(name,tableros);
    }
    /**
     * Dibuja las jugadas del tablero de configuracion que fueron guardadas pintando el tablero
     *  @param name
     */
    public String recovery(String name){
        //makeInvisible();
        ArrayList<ArrayList<ArrayList<String>>> lista=guardar.get(name);    
        ArrayList<ArrayList<String>> confi=lista.get(0);
        ArrayList<ArrayList<String>> imprimir=confi;
        //crearTablero();
        String retor="";
        for(int i=0;i<confi.size();i++){
            for(int j=0;j<confi.size();j++){                
                String contenido=confi.get(i).get(j);     
                if(contenido.equals("j1")){
                    //add(false,i+1,j+1,contenido);                   
                    imprimir.get(i).set(j,"w");
                }else if(contenido.equals("j1k")){                    
                    //add(true,i+1,j+1,"j1");
                    imprimir.get(i).set(j,"W");
                }else if((contenido.equals("j2k"))){
                    //add(true,i+1,j+1,"j2");
                    imprimir.get(i).set(j,"B");
                }else if (contenido.equals("j2")){
                    //add(false,i+1,j+1,"j2");
                    imprimir.get(i).set(j,"b");
                }
                //System.out.print(imprimir.get(i).get(j));
                retor+=imprimir.get(i).get(j);
            }   
            //System.out.println(); 
            retor+="\n";
        }   
        return retor;
    }                               
    /**
     * Entrega la matriz con el estado actual del tablero de configuracion
     * @return String
     */
    public void write(){
        ArrayList<ArrayList<String>>escribir=new ArrayList<ArrayList<String>>();
        for (int i = 0; i < configuracion.getSimulacion().size(); i++) {
            escribir.add(new ArrayList<String>());
            for (int j = 0; j < configuracion.getSimulacion().get(i).size(); j++){
                String contenido=configuracion.getSimulacion().get(i).get(j);
                if(contenido.equals("-")){
                    escribir.get(i).add(contenido); 
                }else if(contenido.equals(".")){
                    escribir.get(i).add(contenido);
                }else if(contenido.equals("j1")){
                    escribir.get(i).add("w");
                }else if(contenido.equals("j1k")){
                    escribir.get(i).add("W");
                }else if (contenido.equals("j2")){
                    escribir.get(i).add("b");
                }else if (contenido.equals("j2k")){
                    escribir.get(i).add("B");
                } 
                System.out.print(escribir.get(i).get(j));                              
            }
            System.out.println();                              
        }       
    }    
    public void read(String cadena){
        double longitud=Math.sqrt(cadena.length());
        int longi=(int)longitud;
        ArrayList<ArrayList<String>> leer=new ArrayList<ArrayList<String>>();
        for (int i=0;i<cadena.length();i=i+longi){
            ArrayList<String>lista=new ArrayList<String>();
            String subCa=cadena.substring(i,i+longi);
            for (int j=0;j<subCa.length();j++){
                lista.add(subCa.substring(j,j+1));
            }
            leer.add(lista);
        }
        recovery(leer,longi);
    }

    private void recovery(ArrayList<ArrayList<String>> matriz,int medida){
        makeInvisible();
        new checkers(medida);
        for (int i=0;i<matriz.size();i++){
            for(int j=0;j<matriz.get(0).size();j++){
                if (matriz.get(i).get(j).equals("W")){
                    add(true,i+1,j+1,"j1",1);                    
                }else if (matriz.get(i).get(j).equals("B")){
                    add(true,i+1,j+1,"j2",1);                    
                }else if (matriz.get(i).get(j).equals("w")){
                    add(false,i+1,j+1,"j1",1);                    
                }else if (matriz.get(i).get(j).equals("b")){
                    add(false,i+1,j+1,"j2",1);                    
                }
            }
        }
    }
}
