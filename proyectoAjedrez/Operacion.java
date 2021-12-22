package proyectoAjedrez;
/**
 * -Logica Problema Reinas
 * @author Julian Cardenas 
 *@since 09-2021
 *@version 1.0
 */
public class Operacion {
	               //Numero reinas
	private final int NR=8;
	private int[][] tablero= new int[NR][NR];;
	
	String letras[]= {"A","B","C","D","E","F","G","H"};
	public void imprimir() {
		 // Imprime cabecera
	    System.out.print("   ");
	        
	    for (int i = 0; i < NR; i++) {
	        System.out.print(" " + letras[i] + "     ");
	    }
	        
	    System.out.print("\n");
	        
	    // Imprime tablero - filas 0 a (NR - 1)
	    for (int i = 0; i < NR; i++) {
	            
	        // Imprime índice de fila
	        System.out.print((i + 1));
	            
	        // Imprime fila i - Columnas 0 a (NR - 1)
	        for (int j = 0; j < NR; j++) {
	            System.out.print("   " + tablero[i][j] + "   ");
	        }
	            
	        System.out.print("\n\n");
	    }       
	}
	
	public boolean posicionVerdadera(int fila, int columna) {
		
		//verificar que fila actual sea segura, verificando cada columna de esta
		for (int j = 0; j < columna; j++) 
	        if (tablero[fila][j]==1) 
	            return false; 
	  
		//verifica diagonal superior del lado izquierdo sea segura
		for (int i=fila, j=columna; i>=0 && j>=0; i--, j--) 
	        if (tablero[i][j]==1) 
	            return false; 
	  
		//verifica diagonal inferior del lado izquierdo sea segura
		for (int i=fila, j=columna; j>=0 && i<NR; i++, j--) 
	        if (tablero[i][j]==1) 
	            return false; 
	  
		//verifica que no hayan atacantes ni en sus lados, ni en sus diagonales
		return true; 
		
		
	}
	
	public boolean solucion(int columna) {
		//Caso base: si la solucion es la correcta
		if (columna >=NR) {
			return true;
		}
		//Se considera la columna actual como una posible solución y se verifica
		for (int i = 0; i < NR; i++) {
			//verifica si se puede colocar  en el tablero[i][columna]
			if (posicionVerdadera(i, columna)) {
				
				tablero[i][columna]=1;
				System.out.println("Movimiento reina colocada en: Fila["+i+"] Columna["+columna+"]"  );
				//se invoca la funcion recursiva para dar solucion  a ls demad reinas del tablero
				if (solucion(columna+1)) {
					
					return true;
				}
				
				tablero[i][columna]=0;
				
			}	
		}
		//si no hay solucion la renia puede se colocada en ninguna fila de esta columna
		return false;
	}
	
	public boolean inicio() {
		
		if (solucion(0)==false) {
			System.out.println("No Hay solucion");
			return false;
		}
		imprimir();
		
		return true;
	}
	
}
