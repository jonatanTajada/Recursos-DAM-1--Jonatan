package EDE_ejercicioEquipoFutbol;

import EDE_ejercicioClubCiclista.Equipo;

public class App {
	
	public static void main(String[] args) {
		
					// Crear un equipo de fútbol de la Selección Colombia
		
		//tecnico y portero
		Tecnico tecnico = new Tecnico("Unai", "Simon", 66, 30, false);
		Portero portero = new Portero("Andrew", "Perez", 30, true, 10);

		// defensas, mediocampos y delanteros
		Defensa[] defensas = {
				new Defensa("Jon", "Mina", 24, true),
				new Defensa("Dani", "Short", 23, true),
				new Defensa("Williams", "Loquesea", 29, true), 
				new Defensa("Pele", "Medina", 29, true)
				};

		Mediocampo[] mediocampos = { new Mediocampo("Mateus", "Uribe", 28, true, 12),
				new Mediocampo("Will", "Smith", 25, true, 12),
				new Mediocampo("Aduriz", "Cuadrado", 31, true, 10),
				new Mediocampo("Nico", "Rodríguez", 28, true, 32) };

		Delantero[] delanteros = { new Delantero("Javier Falcao", "García", 33, true, 15),
				new Delantero("Arkaitz", "Etxebarria", 28, true, 12) };

		
		//equipo de futbol
		EquipoDeFutbol seleccionColombia = new EquipoDeFutbol("Selección Española", "España", tecnico, portero,
				defensas, mediocampos, delanteros);

		// Imprimir informacion del equipo
		seleccionColombia.imprimir();
	}
	
	
}
