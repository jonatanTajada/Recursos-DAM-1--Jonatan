package examen_Programacion_2º_Trimestre_Jonatan_Tajada_Rico;

import java.time.LocalDate;

public class TrabajoPintura extends Servicio {

	// atributos
	private double superficie;
	private double precioPintura;
	

	// Constructor

	public TrabajoPintura(String nombreApellidosTrabajador, LocalDate fechaInicioServicio,
			String nombreApellidosCliente, double superficie, double precioPintura) {
		super(nombreApellidosTrabajador, fechaInicioServicio, nombreApellidosCliente);
		this.superficie = superficie;
		this.precioPintura = precioPintura;
	}
	

	// setters and getters

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	public double getPrecioPintura() {
		return precioPintura;
	}

	public void setPrecioPintura(double precioPintura) {
		this.precioPintura = precioPintura;
	}
	
	
	

	// -----Metodos -----------------
	
	// coste material
	@Override
	public double costeMaterial() {
		double costeMat= (this.superficie/7.8) * this.precioPintura;
		return costeMat;
	}
	
	//coste mano de obra
	@Override
	public double costeManoObra() {
		double costeManObr = (this.superficie/7.8) * this.precioPintura;
		return costeManObr;
	}

	//coste total
	@Override
	public double costeTotal() {
	    double costeTot = costeMaterial() + costeManoObra();
	    
	    if (this.superficie < 50) {
	        costeTot += costeTot * 0.15;  
	    }
	    
	    return costeTot;
	}


	// detalle del serivcio ("toString")
	@Override
	public double detalleServicio() {
		
	    System.out.println("TRABAJO DE PINTURA");
	    System.out.println("Cliente: " + super.nombreApellidosCliente + " Fecha de inicio: " + super.fechaInicioServicio);
	    System.out.println("---------------------------------------------------------------------------------------------");
	    System.out.println("Pintor: " + super.nombreApellidosTrabajador);
	    System.out.println("Coste de material.......... " + costeMaterial() + "€.");
	    System.out.println("Coste mano de obra......... " + costeManoObra() + "€.");

	    if (superficie < 50) {
	        double costeAdicional = this.costeTotal() - this.costeMaterial() - this.costeManoObra();
	        System.out.println("Coste adicional (superficie < 50)......... " + costeAdicional + "€.");
	    }

	    System.out.println("Coste total.......... " + costeTotal() + "€.");
	    
	    return costeTotal();
	}


	
	
	
}
