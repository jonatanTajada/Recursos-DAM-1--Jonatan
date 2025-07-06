package ejerciciosArrays7Nov;

public class SumaFilasSumasColumnasMatriz {

	//mirar que falla pero parece que suma bien...!!!
	public static void main(String[] args) {
		
		int[][] matriz = {{1, 2}, {3, 4}, {5, 6}};

        // Mostrar la matriz
        System.out.println("Matriz original:");
        imprimirMatriz(matriz);
		
        
        System.out.println("Suma de las filas:");
        for (int i = 0; i < matriz.length; i++) {
			int sumaFila = sumarFila(matriz, i);
			System.out.println("Fila " + i + ": " + sumaFila);
		}
        System.out.println();
        
        System.out.println("Suma columnas: ");
        for (int j = 0; j < matriz.length; j++) {
			int sumaColumna = sumarColumna(matriz, j);
			System.out.println("Columna " + j + ":" + sumaColumna);
		}
		
        
	}
	
	
	
	
	
	
	
	
	
	public static void imprimirMatriz(int[][] matriz) {
	    System.out.println("***Matriz***");

	    for (int i = 0; i < matriz.length; i++) {
	        for (int j = 0; j < matriz[0].length; j++) {
	            System.out.print(matriz[i][j] + " ");
	        }
	        System.out.println();  // Agregado para pasar a la siguiente línea después de cada fila
	    }
	}
	
	public static int sumarFila(int[][] matriz, int fila) {
	    int suma = 0;
	    for (int j = 0; j < matriz[0].length; j++) {
	        suma += matriz[fila][j];
	    }
	    return suma;
	}

	public static int sumarColumna(int[][] matriz, int columna) {
	    int suma = 0;
	    for (int i = 0; i < matriz.length; i++) {
	        suma += matriz[i][columna];
	    }
	    return suma;
	}

	
	
	
	
	
}
