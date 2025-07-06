package examen_Programacion_2º_Trimestre_Jonatan_Tajada_Rico;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class ProgramaPrueba {

	public static void main(String[] args) {
		// Crear trabajos de pintura
		TrabajoPintura trabajoPintura1 = new TrabajoPintura("Pintor1", LocalDate.now(), "Cliente1", 40.0, 15.0);
		TrabajoPintura trabajoPintura2 = new TrabajoPintura("Pintor2", LocalDate.now(), "Cliente2", 30.0, 20.0);

		// Crear revisiones de alarma
		RevisionAlarma revisionAlarma1 = new RevisionAlarma("Revisor1", LocalDate.now(), "Cliente3", 5);
		RevisionAlarma revisionAlarma2 = new RevisionAlarma("Revisor2", LocalDate.now(), "Cliente4", 8);

		// Crear ArrayList para almacenar los trabajos
		ArrayList<Servicio> listaTrabajos = new ArrayList<>();

		// Agregar los trabajos al ArrayList
		listaTrabajos.add(trabajoPintura1);
		listaTrabajos.add(trabajoPintura2);
		listaTrabajos.add(revisionAlarma1);
		listaTrabajos.add(revisionAlarma2);

		// Calcular la suma de los costes de todos los trabajos
		double sumaCostes = 0;
		for (Servicio trabajo : listaTrabajos) {
			sumaCostes += trabajo.costeTotal();
		}

		// Calcular el total de sueldos por esos trabajos
		double totalSueldos = 0;
		for (Servicio trabajo : listaTrabajos) {
			if (trabajo instanceof RevisionAlarma) {
				totalSueldos += ((RevisionAlarma) trabajo).costeManoObra();
			}
		}

		// Mostrar en pantalla el resumen detallado de cada uno de esos trabajos
		DecimalFormatSymbols simbolos = new DecimalFormatSymbols(Locale.getDefault());
		simbolos.setDecimalSeparator('.');
		DecimalFormat formatoDecimal = new DecimalFormat("#.00", simbolos);

		for (Servicio trabajo : listaTrabajos) {
			trabajo.detalleServicio();
			System.out.println("-----------------------------------------------------------------");
		}

		// Mostrar resultados con dos decimales
		System.out.println("Suma de los costes de todos los trabajos: " + formatoDecimal.format(sumaCostes) + "€.");
		System.out.println("Total de sueldos por esos trabajos: " + formatoDecimal.format(totalSueldos) + "€.");
	}
}
