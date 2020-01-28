
import java.util.ArrayList;
import java.lang.Math;
public class calcXook
{
    // instance variables - replace the example below with your own
    
    private Xook valor1;
    private Xook valor2;
    public calcXook(int numero1,int numero2){
        valor1=new Xook(numero1);
        valor2=new Xook(numero2);
        valor1.makeVisible();
        valor2.moverHorizontal(150);
        valor2.makeVisible();
    }
    public void meterNumero(int numero2){
        valor2.setValue(numero2);
        valor2.moverHorizontal(150);
    }
    public void suma(){
        int resultado=valor1.getValue()+valor2.getValue();
        valor1.setValue(resultado);
        valor2.setValue(0);
    }
    public void resta(){
        int resultado=Math.abs(valor1.getValue()-valor2.getValue());
        valor1.setValue(resultado);
        valor2.setValue(0);
    }
    public void Multiplicar(){
        int resultado=valor1.getValue()*valor2.getValue();
        valor1.setValue(resultado);
        valor2.setValue(0);
    }
    public void Division(){
        int resultado=valor1.getValue()/valor2.getValue();
        valor1.setValue(resultado);
        valor2.setValue(0);
    }
    public void Potencia(){
        double resultado=Math.pow(valor1.getValue(),valor2.getValue());
        int value=(int)resultado;
        valor1.setValue(value);
        valor2.setValue(0);
    }
}
