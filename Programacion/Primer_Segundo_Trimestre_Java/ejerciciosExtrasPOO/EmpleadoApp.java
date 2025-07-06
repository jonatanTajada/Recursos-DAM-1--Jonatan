package ejerciciosExtrasPOO;

public class EmpleadoApp {

	
	public static void main(String[] args) {
		
		
		EmpleadoComercial comercial1 = new EmpleadoComercial("Jonatan", 35, 1500.20, 250);
		EmpleadoRepartidor repartidor1 = new EmpleadoRepartidor("Janire", 21, 1200, "zona 3");
		
		EmpleadoComercial comercial2 = new EmpleadoComercial("Maria", 35, 1500, 50);
		EmpleadoRepartidor repartidor2 = new EmpleadoRepartidor("Alex", 30, 1200, "zona 2");
		
		System.out.println(comercial1);
		comercial1.plus();
		System.out.println(comercial1);
		
		System.out.println("****************");
		
		System.out.println(comercial2);
		comercial2.plus();
		System.out.println(comercial2);
		
		System.out.println("****************");
		
		System.out.println(repartidor1);
		repartidor1.plus();
		System.out.println(repartidor1);
		
		System.out.println("****************");
		
		System.out.println(repartidor2);
		repartidor2.plus();
		System.out.println(repartidor2);
		
	}
	
	
}
