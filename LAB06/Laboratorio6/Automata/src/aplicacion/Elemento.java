package aplicacion;
import java.awt.Color;
import java.util.ArrayList;
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
          celula=new Izquierdosa(ac,fila,columna);         
      }
      switch(tipo){         
          case 3:           
          celula=new Barrera(ac,fila,columna);         
      }
      switch(tipo){         
          case 4:           
          celula=new Derechosas(ac,fila,columna);         
      }
      switch(tipo){         
          case 5:           
          celula=new Conway(ac,fila,columna);         
      }
      return celula;    
  }      
  default void decida(){      
  };
   
  default void cambie(){
  };
  /** retorna la forma de la celula 
   * 
   */
  default int getForma(){
      return REDONDA;
  }
  /**retorna el color de la celula
   * 
   */
  Color getColor();
  /**retorna el estado de la celula
   * 
   */
  default boolean isVivo(){
      return false;
  }
  /**retorna la fila de la celula
   * 
   */
  public int getFila();
}
