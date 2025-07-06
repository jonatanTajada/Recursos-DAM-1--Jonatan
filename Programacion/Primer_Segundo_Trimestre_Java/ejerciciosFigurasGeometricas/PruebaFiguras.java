package ejerciciosFigurasGeometricas;

import java.util.ArrayList;
import java.util.Scanner;

public class PruebaFiguras{

	static ArrayList<FiguraGeometrica> listaFiguras = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		llenarFiguras();
		mostrarResultados();
	}

	public static void llenarFiguras() {
		char continuar;
		int opcion;

		do {
			
			
			do {
				System.out.println("Selecciona una figura geométrica:");
				System.out.println("1. Circulo");
				System.out.println("2. Rectangulo");
				System.out.println("3. Cuadrado");
				System.out.println("4. Triangulo Rectangulo");
				System.out.println("5. Rombo");
				System.out.println("6. Trapecio");
				System.out.print("Opcion: ");
			    opcion = scanner.nextInt();
				
				if (opcion < 1 || opcion > 6) {
					System.err.println("Opcion invalida, introduzca de nuevo una opcion valida.");
				}
				
			} while (opcion < 1 || opcion > 6);
			

			switch (opcion) {
			case 1:
				llenarCirculo();
				break;
			case 2:
				llenarRectangulo();
				break;
			case 3:
				llenarCuadrado();
				break;
			case 4:
				llenarTrianguloRectangulo();
				break;
			case 5:
				llenarRombo();
				break;
			case 6:
				llenarTrapecio();
				break;
			default:
				System.err.println("Opcion no valida.");
				break;
			}

			System.out.println("¿Deseas introducir otra figura geométrica? (s/n)");
			continuar = scanner.next().toUpperCase().charAt(0);
			System.out.println();
		} while (continuar == 'S');
	}

	
	public static void llenarCirculo() {
		System.out.print("Radio del circulo en centimetros: ");
		double radio = scanner.nextDouble();

		listaFiguras.add(new Circulo(radio));
	}

	public static void llenarRectangulo() {
		System.out.print("Base del rectangulo en centimetros: ");
		double base = scanner.nextDouble();
		System.out.print("Altura del rectangulo en centimetros: ");
		double altura = scanner.nextDouble();
		
		listaFiguras.add(new Rectangulo(base, altura));
	}

	public static void llenarCuadrado() {
		System.out.print("Longitud de un lado del cuadrado en centimetros: ");
		double lado = scanner.nextDouble();
		
		listaFiguras.add(new Cuadrado(lado));
	}

	public static void llenarTrianguloRectangulo() {
		System.out.print("Base del triangulo rectangulo en centimetros: ");
		double base = scanner.nextDouble();
		System.out.print("Altura del triangulo rectángulo en centimetros: ");
		double altura = scanner.nextDouble();
		
		listaFiguras.add(new TrianguloRectangulo(base, altura));
	}

	public static void llenarRombo() {
		System.out.print("Diagonal mayor del rombo en centimetros: ");
		double diagonalMayor = scanner.nextDouble();
		System.out.print("Diagonal menor del rombo en centimetros: ");
		double diagonalMenor = scanner.nextDouble();
		
		listaFiguras.add(new Rombo(diagonalMayor, diagonalMenor));
	}

	public static void llenarTrapecio() {
	    System.out.print("Base mayor del trapecio en centimetros: ");
	    double baseMayor = scanner.nextDouble();
	    System.out.print("Base menor del trapecio en centimetros: ");
	    double baseMenor = scanner.nextDouble();
	    System.out.print("Lado izquierdo del trapecio en centimetros: ");
	    double ladoIzquierdo = scanner.nextDouble();
	    System.out.print("Lado derecho del trapecio en centimetros: ");
	    double ladoDerecho = scanner.nextDouble();
	    System.out.print("Altura del trapecio en centimetros: ");
	    double altura = scanner.nextDouble();
	    
	    listaFiguras.add(new Trapecio(baseMayor, baseMenor, ladoIzquierdo, ladoDerecho, altura));
	}

	public static void mostrarResultados() {

		for (FiguraGeometrica figura : listaFiguras) {
			
			System.out.println("\n***Información de la Figura Geométrica:*****");
			System.out.println("Tipo: " + figura.getClass().getSimpleName());
			System.out.println("Área: " + figura.calcularArea());
			System.out.println("Perímetro: " + figura.calcularPerimetro());
			
			if (figura instanceof TrianguloRectangulo) {
				TrianguloRectangulo trianguloRectangulo = (TrianguloRectangulo) figura;
				System.out.println("Hipotenusa: " + trianguloRectangulo.calcularHipotenusa());
				System.out.println("Tipo de Triángulo: " + trianguloRectangulo.determinarTipoTriangulo());
			}
			System.out.println();
		}
	}
}
