package aplicacion;
import java.awt.Color;

public interface Elemento{
  int REDONDA = 1;
  int CUADRADA = 2;
  default void crearElemento(AutomataCelular ac,int fila, int columna,int tipo){
      switch(tipo){
        case 1:
        new Celula(ac,fila,columna);
        }
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
