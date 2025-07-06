package cartaDeBarajas;

public class BarajaEspanola {
	public enum Palo {
		OROS, COPAS, BASTOS, ESPADAS
	}

	public static void main(String[] args) {

		int contador = 1;

		cargarPalo(contador);

//        for (int i = 0; i < Palo.values().length; i++) {
//            System.out.println("************");
//            System.out.println("Palo " + (i + 1) + ": " + Palo.values()[i]);
//        }

	

		
	}

	private static void cargarPalo(int contador) {
		for (Palo palo : Palo.values()) {
			System.out.println("************");
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("Palo ");
			stringBuilder.append(contador);
			stringBuilder.append(": ");
			stringBuilder.append(palo);
			System.out.println(stringBuilder.toString());
			contador++;
		}
		
	}


	
}


