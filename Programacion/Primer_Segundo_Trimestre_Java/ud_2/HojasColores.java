package ud_2;

public class HojasColores {

	public static void main(String[] args) {

		final int TOTAL_HOJAS_CUADERNO = 21;
		int hojasRojas=0, hojasVerdes=0;
		
		for (int i = 0; i < TOTAL_HOJAS_CUADERNO; i++) {
			if (i % 2 == 0) {
				hojasRojas++;
			}else {
				hojasVerdes++;
			}
		}
		
		System.out.println("El total de hojas del cuaderno son : " + TOTAL_HOJAS_CUADERNO);
		System.out.println("El total de hojas rojas que son las hojas impares es de: " + hojasRojas + " hojas.");
		System.out.println("El total de hojas verdes que son las hojas pares es de:  " + hojasVerdes + " hojas.");
	}

}
