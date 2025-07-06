package EDE_ejercicioEquipoFutbol_2;



public class App {

	
	
	
	public static void main(String[] args) {
		
		
		//crear Personas(tecnico y jugadores)
		
		
		Tecnico tecnico = new Tecnico("Carlos", "Quez", 66, 30, true);
		Portero portero = new Portero("David", "Ospin", 30, true, 10);
		Defensa[] defensas = {
				new Defensa("Jon", "Mina", 24, true),
				new Defensa("Dani", "Short", 23, true),
				new Defensa("Williams", "Loquesea", 29, true), 
				new Defensa("Pele", "Medina", 29, true)
				};
		
		Mediocampo[] mediocampos = { 
				new Mediocampo("Mateus", "Uribe", 28, true, 12),
				new Mediocampo("Will", "Smith", 25, true, 12),
				new Mediocampo("Aduriz", "Cuadrado", 31, true, 10),
				new Mediocampo("Nico", "Rodríguez", 28, true, 32) };

		Delantero[] delanteros = { new Delantero("Javier Falcao", "García", 33, true, 15),
				new Delantero("Arkaitz", "Etxebarria", 28, true, 12) };
		
		//equipo de futbol
		Equipo equipo1 = new Equipo("Seleccion española", "España", tecnico, portero, defensas, mediocampos, delanteros);

		
		equipo1.imprimir();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
