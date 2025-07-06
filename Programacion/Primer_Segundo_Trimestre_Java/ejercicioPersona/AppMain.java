package ejercicioPersona;

public class AppMain {

	public static void main(String[] args) {
		
		// crear dos personas
		Persona p1 = new Persona("Jonatan", "Tajada", "132456H", "07/05/2000", "España", 'd');
		Persona p2 = new Persona("Janire", "Lopez", "132422P", "07/08/1988", "España", 'M');
		
		// mostrar personas
		
		System.out.println(p1.toString());
		System.out.println("*****************************************");
		System.out.println(p2.toString());
		

	}

}
