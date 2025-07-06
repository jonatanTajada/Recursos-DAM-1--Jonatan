package miPrimeraClaseTareaDiciembre_2023POO;

public class Articulo {

	//Atributos
	
	private int codigoArticulo;
	private String titulo;
	private static final double PRECIO_ALQUILER = 100;
	
	
	//Constructor
	public Articulo(int codigoArticulo, String titulo ) {
	
		this.codigoArticulo = codigoArticulo;
		this.titulo = titulo;

	}
	
	public Articulo() {}


	//Setters and Getters
	
	public int getCodigoArticulo() {
		return codigoArticulo;
	}


	public void setCodigoArticulo(int codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	
	//Metodos
	
	public double calcularUnDia() {
		return PRECIO_ALQUILER ;
		
	}
	
	public double calcularDosDia() {
		return PRECIO_ALQUILER * 2 ;
		
	}
	
	public double calcularTresDia() {
		return PRECIO_ALQUILER * 3 ;
		
	}
	
	
	
	public static void main(String[] args) {
		
		Articulo a = new Articulo(1, "asdasd" );
		
		System.out.println(a.calcularUnDia());
		System.out.println(a.calcularDosDia());
		System.out.println(a.calcularTresDia());
		
	}
	
	
	
	
}
