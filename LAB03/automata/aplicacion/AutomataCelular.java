package aplicacion;
import java.util.*;
import java.awt.Color;
public class AutomataCelular{
    static private int LONGITUD=20;
    private Elemento[][] automata;      
    public AutomataCelular() {
        automata=new Elemento[LONGITUD][LONGITUD];        
        for (int f=0;f<LONGITUD;f++){
            for (int c=0;c<LONGITUD;c++){
                automata[f][c]=null;
            }
        }
        algunosElementos();
    }

    public int  getLongitud(){
        return LONGITUD;
    }

    public Elemento getElemento(int f,int c){
        return automata[f][c];
    }

    public void setElemento(int f, int c, Elemento nueva){
        automata[f][c]=nueva;
    }   

    public void algunosElementos(){ 
        Elemento indiana= Elemento.crearElemento(this,1,1,1);
        Elemento oo7=Elemento.crearElemento(this,2,2,1);
        //Elemento izquierdosa1=Elemento.crearElemento(this,6,6,2);        
        //Elemento izquierdosa2=Elemento.crearElemento(this,6,7,2);
        //Izquierdosas  marx = Elemento.crearElemento(this,3,6,2);
        //Izquierdosas  hegel = Elemento.crearElemento(this,3,7,5);
        //Barrera suroeste = new Barrera(this,15,1);
        //Barrera noroeste = new Barrera(this,1,15);
        Derechosas lina = new Derechosas(this,10,1);
        Derechosas santiago = new Derechosas(this,11,2);
        Conway q = new Conway(this,10,1);
        Conway p = new Conway(this,11,2);

        
        
    }    
    public void ticTac(){
        for (int i=0;i<automata.length;i++){
            for (int j=0;j<automata[i].length;j++){
                if  (automata[i][j]!=null) {
                    if(automata[i][j].getColor().equals(Color.black)){
                    verifique(i,j);           
                }else if(automata[i][j].getColor().equals(Color.red)){
                    derecha(i,j);
                }else if(automata[i][j].getColor().equals(Color.green)){
                    verifiquederechosas(i,j);
                }else if(automata[i][j].getColor().equals(Color.blue)){
                    verifique(i,j);    
                } else{
                  verifique(i,j);
                  verifiquederechosas(i,j);
             
                }
            }            
        }
    }
    }
    public void derecha(int fila,int columna){
       if (automata[fila][columna]!=null){ 
          if (columna<automata[fila].length-1){  
             if (automata[fila][columna+1]!=null){
                 if (automata[fila][columna+1].isVivo()){
                    automata[fila][columna].cambie();
                }else{
                    automata[fila][columna]=automata[fila][columna];
                    
                }
             }else{
               }return;          
          }
       }
                   
    }
    public Celula crearCelular(int fila, int columna){
        return new Celula(this, fila, columna); 
    }
    private void verifique(int fila,int columna){
        int[] vivasMuerta = {0,0};
        vivasMuerta=contar(fila,columna); 
        if (automata[fila][columna]!=null){              
            if(automata[fila][columna].isVivo()){                 
                if(vivasMuerta[0] + vivasMuerta[1] == 1 || vivasMuerta[0] + vivasMuerta[1] > 3){
                    automata[fila][columna].cambie();                                                                      
                }else if(vivasMuerta[0]==3 || vivasMuerta[0]==2){
                    return;
                } 
            }else if(!automata[fila][columna].isVivo()){
                if(vivasMuerta[0]==3){
                    automata[fila][columna].cambie();                   
                }
            }          
        }
        else{
           //vivasMuerta=contar(fila,columna);
           if (vivasMuerta[0]==3){
               Elemento lina= Elemento.crearElemento(this,0,1,1);
               automata[fila][columna]=lina;          
           }
        }
    }
    private void verifiquederechosas(int fila,int columna){
        int[] vivasMuerta = {0,0};
        vivasMuerta=contar(fila,columna); 
        if (automata[fila][columna]!=null){              
            if(!automata[fila][columna].isVivo()){                 
                if(vivasMuerta[0] + vivasMuerta[1] == 1 || vivasMuerta[0] + vivasMuerta[1] > 3){
                    automata[fila][columna].cambie();                                                                      
                }else if(vivasMuerta[1]==3 || vivasMuerta[1]==2){
                    return;
                } 
            }else if(automata[fila][columna].isVivo()){
                if(vivasMuerta[1]==3){
                    automata[fila][columna].cambie();                   
                }
            }          
        }
        else{
           //vivasMuerta=contar(fila,columna);
           if (vivasMuerta[1]==3){
               Elemento lina= Elemento.crearElemento(this,fila,columna,4);
           }
        }
    }
    private int[] cuente(int x1, int x2, int y1, int y2, int x, int y){
        int[] vivasMuertas = {0,0};        
        for (int i = x1; i<=x2; i++) {
            for (int j = y1; j<=y2; j++) {
                if (x == i && y == j) continue;
                if(automata[i][j]!=null){
                    if (automata[i][j].isVivo()) {
                        vivasMuertas[0] += 1;
                    }else if (!automata[i][j].isVivo()) {
                        vivasMuertas[1] += 1;
                    }         
                }
            }
        }            
        
        return vivasMuertas;
    }
    private int[] contar(int x,int y){
        int[] lista={0,0};        
        if (x==0 && y==0){
            //esquina de arriba
            lista = cuente(x,x+1,y,y+1, x, y);
            System.out.println("Hola 1");
        }else if(x==automata.length-1 && y==0){
            //esquina de abajoizquiera
            System.out.println("Hola 2");
            lista = cuente(x-1,x,y,y+1, x, y);
        }else if(x==0 && y==automata.length-1){
            //isquina derecha arriba
            System.out.println("Hola 3");
            lista = cuente(x,x+1,y-1,y,x, y);
        }else if(x==automata.length-1 && y==automata.length-1){
            //esquina derecha abajo
            System.out.println("Hola 4");
            lista = cuente(x-1,x,y-1,y, x, y);
        }else if(x==0 && 0<y && y<automata.length-1){
            //entre esquinaizqarriba y esquinaderarriba
            System.out.println("Hola 5");
            lista = cuente(x,x+1,y-1,y+1, x, y);
        }else if(y==0 && 0<x && x<automata.length-1){
            //entre esquinaizqarriba y esquinaizqabajo 
            System.out.println("Hola 6");
            lista = cuente(x-1,x+1,y,y+1, x, y);
        }else if(y==automata.length-1 && 0<x && x<automata.length-1){
            //entre esquina der arriba y esquina der abajo
            System.out.println("Hola 7");
            lista = cuente(x-1,x+1,y-1,y, x, y);
        }else if(x==automata.length-1 && 0<y && y<automata.length-1){
            //esquina izq abajo y esquina der abajo
            System.out.println("Hola 8");
            lista = cuente(x-1,x,y-1,y+1, x, y);
        }else{            
            System.out.println("Hola 9");
            lista = cuente(x-1,x+1,y-1,y+1, x, y);
        }                        
        return lista;
    }         
}
