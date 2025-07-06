package ejercicioGestionNominas;

public class AppGestionNominas {
	
    public static void main(String[] args) {
        // Crear  empresa
        Empresa empresa = new Empresa("12345678X", "Empresa Ejemplo");

        // Añadir trabajadores a la empresa
        empresa.agregarTrabajador(new Informatico("147852A", "Jonatan", 2500, "Formacion Profesional"));
        empresa.agregarTrabajador(new Analista("204433963W", "Carles", 2800.0, "Ingeniero Informatico"));
        empresa.agregarTrabajador(new Analista("204437956R", "Maria", 3000.0, "Ingeniera Informatica"));
        empresa.agregarTrabajador(new Programador("204437963W", "Alba", 1100.0, "Ingeniera en Sistemas"));
        empresa.agregarTrabajador(new Programador("204437964W", "Marti", 1200.0, "Ingeniero de Software"));
        empresa.agregarTrabajador(new Administrativo("20443300A", "Nuria", 1300.0, 5));
        empresa.agregarTrabajador(new Administrativo("20443301A", "Pepe", 1400.0, 8));
        empresa.agregarTrabajador(new Auxiliar("20443302A", "Jose", 1000.0, 2));
        empresa.agregarTrabajador(new Auxiliar("20443303A", "Ana", 1100.0, 4));
        

        // Mostrar el listado de trabajadores
        empresa.mostrarListado();
        
        
        
    }
}

