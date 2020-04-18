package presentacion;
import javax.swing.*;
import java.awt.*;
/**
 * Esta clase ayuda a MarbelGUI con la creacion de las canicas y aros
 * @author Lina Buitrago - Santiago Laiton
 * @version 1.0 17 de Abril 2020
 */
public class Canicas extends JPanel{
	
		private Color color;
		private boolean canica;
		private boolean aro;
		private char ncanicas;
		private char naros;
		
		public Canicas(Color c, boolean ca, boolean a, char nc, char na){
			setBackground(Color.LIGHT_GRAY);
			canica = ca;
			aro = a;
			color = c;
			ncanicas = nc;
			naros = na;
		}
		/**
	     * Cambia el color 
	     */
		public void setColor(Color c){
			color = c;
			repaint();
		}
		/**
	     * Retorna el color
	     * @return Color
	     */
		public Color getColor(){
			return color;
		}
		/**
	     * Retorna si hay aroo o no 
	     * @return aro
	     */
		public boolean tieneAro(){
			return aro;
		}
		/**
	     * Retorna si tiene canica o no 
	     * @return canica
	     */
		public boolean tieneCanica(){
			return canica;
		}
		/**
	     * pinta aro
	     */
		public void pintarAro(){
			aro = true;
			repaint();
		}
		/**
	     * pinta canica
	     */
		public void pintarCanica(){
			canica = true;
			repaint();			
		}
		/**
	     * borra aro
	     */
		public void borrarAro(){
			aro = false;
			repaint();
		}
		/**
	     * borra canica
	     */
		public void borrarCanica(){
			canica = false;
			repaint();
		}
		
		public void paint(Graphics g){
			Color colorCanica;
			Color colorAro;			
			int centroxa = this.getWidth()/6;
			int centroya = this.getHeight()/12;
			int centroxca = this.getWidth()/4;
			int centroyca = this.getHeight()/6;
			int diametroCanica = this.getHeight()*70/100;
			int diametroAro = this.getHeight()*90/100;				
			super.paint(g);
			Graphics2D hole = (Graphics2D) g;
			if(aro){
				colorAro = Color.BLACK;
				if(canica){
					colorCanica = color;
				}
				else{
					colorCanica = Color.BLACK;
				}
			}
			else{
				colorAro = Color.LIGHT_GRAY;
				if(canica){
					colorCanica = color;
				}
				else{
					colorCanica = Color.LIGHT_GRAY;
				}
			}
			hole.setPaint(colorAro);
			hole.fillOval(centroxa,centroya,diametroAro,diametroAro);
			hole.setPaint(colorCanica);
			hole.fillOval(centroxca,centroyca,diametroCanica,diametroCanica);			
		}
} 