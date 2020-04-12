package aplicacion;
import java.util.*;
public class MarbelGame {
	private static int altura1;
	private static int ancho1;
	private int nCanicas,nHuecos,nBarreras;
	private static int[][] matriz;
	private ArrayList < Integer >  lista;
	
	public MarbelGame(int altura,int canicas,int barreras) {
		altura1=altura;
		nCanicas=nHuecos=canicas;
		nBarreras=barreras;
		matriz=new int[altura1][altura1];
		for (int i=0;i<altura1;i++) {
			for (int j=0;j<altura1;j++){
				if (nCanicas!=0) {
					matriz[i][j]=1;
					nCanicas=nCanicas-1;
				}else if (nHuecos!=0 && matriz[i][j]!=1){
					matriz[i][j]=2;
					nHuecos=nHuecos-1;
				}else if((matriz[i][j]!=2||matriz[i][j]!=1) && nBarreras!=0) {
					matriz[i][j]=3;
					nBarreras=nBarreras-1;
				}
			 }
		 }
	}
	public static int getFilas() {
		return altura1;
	}
	public static int getColumnas() {
		return altura1;
	}
	public static int getPos(int x,int y) {
		return matriz[x][y];
	}
	public int[][] getMatriz(){
		return matriz;
	}
	public void moverAbajo() {
		int [][] copia=matriz;
		matriz[3][3]=1;
		for (int i=0;i<matriz.length;i++) {
			for (int j=0;j<matriz[0].length;j++) {
				
			}
		}
	}
}
