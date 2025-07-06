package examen_Programacion_2º_Trimestre_Jonatan_Tajada_Rico;

import java.time.LocalDate;

public class RevisionAlarma extends Servicio {

	// atributos
	private int numeroAlarmasARevisar;

	// constructor
	public RevisionAlarma(String nombreApellidosTrabajador, LocalDate fechaInicioServicio,
			String nombreApellidosCliente, int numeroAlarmasARevisar) {
		super(nombreApellidosTrabajador, fechaInicioServicio, nombreApellidosCliente);
		super.nombreApellidosTrabajador = "Revisor Especialista Contraincendios";
		this.numeroAlarmasARevisar = numeroAlarmasARevisar;
	}

	// getters ands setters
	public int getNumeroAlarmasARevisar() {
		return numeroAlarmasARevisar;
	}

	public void setNumeroAlarmasARevisar(int numeroAlarmasARevisar) {
		this.numeroAlarmasARevisar = numeroAlarmasARevisar;
	}

	// --------------------------*** METODOS ***------------------------------------------------------------------------------
	
	//costeMaterial
	@Override
	public double costeMaterial() {
		double costeMat = 0;
		return costeMat;
	}
	
	//coste mano de obra
	@Override
	public double costeManoObra() {
		double costManOb = (numeroAlarmasARevisar / 3) * 40;
		return costManOb;
	}
	//coste total
	@Override
	public double costeTotal() {
		double costeTot = costeManoObra();
		return costeTot;
	}

	//mostra detalle servicio
	@Override
	public double detalleServicio() {
		System.out.println("\nREVISIÓN PERIÓDICA ALARMAS CONTRAINCENDIOS: ");
		System.out.println("Nombre y apellidos del cliente: " + super.nombreApellidosCliente 
						+ "   Fecha Revisión: " + super.fechaInicioServicio) ;
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Total:..........." + this.costeTotal() + "€.");
		System.out.println();
		System.out.println("-----------------------------------------------------------------");
		
		return costeTotal();
	}

}
