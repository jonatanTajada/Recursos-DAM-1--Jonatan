package ejercicioHotel;

public class Habitacion {

	//Atributos
	protected int numero;
	protected double precio;
	protected String tipo;
	protected String foto;
	
	
	//Constructor
	public Habitacion(int numero, double precio, String tipo, String foto) {
		this.numero=numero;
		this.precio=precio;
		this.tipo=tipo;
		this.foto=foto;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	//Constructor
	public String toString() {
		
		return "\nNumero de habitacion: " + numero + "\nPrecio: " + precio + "\nTipo habitacion: " + tipo +
				"\nFotos: " + foto; 
		
	}
	
}
