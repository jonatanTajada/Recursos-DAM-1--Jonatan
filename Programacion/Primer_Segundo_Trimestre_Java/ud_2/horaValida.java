package ud_2;

import java.util.Scanner;

public class horaValida {

	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Inrtoduce la hora");
		int h = scanner.nextInt();
		
		System.out.println("Introduce los minutos");
		int m = scanner.nextInt();
		
		System.out.println("Introduce los segundos");
		int s = scanner.nextInt();
		
		
		if (esHoraValida(h, m, s)) {
			System.out.println("Hora correcta");
		}else {
			System.out.println("hora incorrecta");
		}
		
		
	}
	
	
	
	
	
	
	public static boolean esHoraValida(int h, int m, int s) {
		
		return (h >=0 && h <= 24) && (m >= 0 && m <= 60)&&(s >= 0 && s <= 60);
		
	}
	
	
	
	
	
}
