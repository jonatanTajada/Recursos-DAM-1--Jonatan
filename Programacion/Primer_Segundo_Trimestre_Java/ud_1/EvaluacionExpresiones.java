package ud_1;

public class EvaluacionExpresiones {

	public static void main(String[] args) {
		int x = 1, y = 4, z = 10;
		double pi = 3.14, e = 2.71;

		// Primera expresión
		double resultado1 = (((3 + 2) * (3 + 2) - 15) / 2) * 5;
		boolean resultado2 = 5 - 2 > 4 && !(0.5 == 1.0 / 2.0); 

		// Segunda expresión
		double resultado3 = 2 * x + 0.5 + y - 1.0 / 5.0 * z;

		// Tercera expresión
		boolean resultado4 = pi * x * x > y || 2 * pi * x <= z;

		// Cuarta expresión
		double resultado5 = Math.exp(x - 1) / (x * z) / (x / z);

		// Imprimir resultados
		System.out.println("Resultado 1: " + resultado1);
		System.out.println("Resultado 2: " + resultado2);
		System.out.println("Resultado 3: " + resultado3);
		System.out.println("Resultado 4: " + resultado4);
		System.out.println("Resultado 5: " + resultado5);
	}

}
