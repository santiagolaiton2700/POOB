package aplicacion;
import java.awt.Color;

public interface Elemento{
  int REDONDA = 1;
  int CUADRADA = 2;
  public static Elemento crearElemento(AutomataCelular ac,int fila, int columna,int tipo){    
      Elemento celula= null;       
      switch(tipo){         
          case 1:           
          celula=new Celula(ac,fila,columna);         
      }
      switch(tipo){
          case 2:
          celula=new Izquierdosas(ac,fila,columna);         
      }  
      return celula;    
  }
      
  default void decida(){
  };
   
  default void cambie(){
  };
  
  default int getForma(){
      return REDONDA;
  }
  
  Color getColor();
  
  default boolean isVivo(){
      return false;
  }
  
}
