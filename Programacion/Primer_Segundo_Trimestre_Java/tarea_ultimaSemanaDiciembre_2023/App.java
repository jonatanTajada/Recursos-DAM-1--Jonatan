package tarea_ultimaSemanaDiciembre_2023;

public class App {

	
	public static void main(String[] args) {
		
		Fecha fecha = new Fecha(27, 10, 2023);
        Hora hora = new Hora(10, 30);

        Examen examen = new Examen("Programacion", "Aula 101", fecha, hora);

        System.out.println(examen.toString());

        
        examen.setAsignatura("Base de Datos");
        System.out.println(examen.toString());
		
        
        
		
	}
	
}
