package ud_5Arrays;

public class ArrayRecursiva {
	

	public static void main(String[] args) {
	
		int[] arreglo = { 10, 52, 73, 94, 75 };

		metodoRecursivoArray(arreglo, 0);
	}


	public static void metodoRecursivoArray(int[] array, int indice) {
		
		if (indice < array.length) {
			
			System.out.println(array[indice]);
			metodoRecursivoArray(array, indice + 1); 
	}

		
  }
	
}