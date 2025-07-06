package ud_2;

public class EjercicioOperadoresLogicos_1 {

	public static void main(String[] args) {
		int x1 = 10, x2 = 5, x3 = 0;
		char c1 = 'F', c2 = 'S';

		// x1 es igual a x2
		boolean caso1 = (x1 == x2);

		// c1 es distinto a c2
		boolean caso2 = (c1 != c2);

		// x1 está entre 10 y 100
		boolean caso3 = (x1 >= 10 && x1 <= 100);

		// x2 no está entre 10 y 100
		boolean caso4 = !(x2 >= 10 && x2 <= 100);

		// x3 no está entre 10 y 100
		boolean caso5 = !(x3 >= 10 && x3 <= 100);

		// x1 es mayor que x2 y c1 es igual a c2
		boolean caso6 = (x1 > x2) && (c1 == c2);

		// O x1 es mayor que x2, o c1 es distinto a c2, cualquiera de los dos casos.
		boolean caso7 = (x1 > x2) || (c1 != c2);

		// x1 es menor o igual que 7 y c2 es igual a c1
		boolean caso8 = (x1 <= 7) && (c2 == c1);

		// c2 es distinto de 'A' y x2 es mayor que 0
		boolean caso9 = (c2 != 'A') && (x2 > 0);

		// 'F' es distinto de c1 o x1 es mayor que 20
		boolean caso10 = (c1 != 'F') || (x1 > 20);

		// 'F' es distinto de c1 o x1 es mayor que 20 o x2 es mayor que 2
		boolean caso11 = (c1 != 'F') || (x1 > 20) || (x2 > 2);

		// 'F' es igual a c1 y x3 es menor que x1
		boolean caso12 = (c1 == 'F') && (x3 < x1);

		// 'F' es igual a c1 y x3 es menor que x1 y x2 es menor o igual que x3
		boolean caso13 = (c1 == 'F') && (x3 < x1) && (x2 <= x3);

		// x2 está entre x3 y x1, y c2 es 'S'
		boolean caso14 = (x2 >= x3 && x2 <= x1) && (c2 == 'S');

		// x3 no está entre x2 y x1
		boolean caso15 = !(x3 >= x2 && x3 <= x1);

		// x2 no está entre x3 y x1, o c2 es igual a c1
		boolean caso16 = !(x2 >= x3 && x2 <= x1) || (c2 == c1);

		// no se cumple que x3 es menor que x1
		boolean caso17 = !(x3 < x1);

		// ni x3 es mayor que x1, ni c2 es distinto a c1
		boolean caso18 = !(x3 > x1) && !(c2 != c1);

		// no se cumple que x1 es menor que 100 y x2 es mayor que 10
		boolean caso19 = !(x1 < 100 && x2 > 10);

		// c2 es anterior alfabéticamente a c1
		boolean caso20 = (c2 < c1);

		// Imprimir los resultados
		System.out.println("Caso 1: " + caso1);
		System.out.println("Caso 2: " + caso2);
		System.out.println("Caso 3: " + caso3);
		System.out.println("Caso 4: " + caso4);
		System.out.println("Caso 5: " + caso5);
		System.out.println("Caso 6: " + caso6);
		System.out.println("Caso 7: " + caso7);
		System.out.println("Caso 8: " + caso8);
		System.out.println("Caso 9: " + caso9);
		System.out.println("Caso 10: " + caso10);
		System.out.println("Caso 11: " + caso11);
		System.out.println("Caso 12: " + caso12);
		System.out.println("Caso 13: " + caso13);
		System.out.println("Caso 14: " + caso14);
		System.out.println("Caso 15: " + caso15);
		System.out.println("Caso 16: " + caso16);
		System.out.println("Caso 17: " + caso17);
		System.out.println("Caso 18: " + caso18);
		System.out.println("Caso 19: " + caso19);
		System.out.println("Caso 20: " + caso20);

	}

}
