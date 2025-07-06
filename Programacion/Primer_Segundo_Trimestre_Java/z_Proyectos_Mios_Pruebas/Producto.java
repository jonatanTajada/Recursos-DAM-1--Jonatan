package z_Proyectos_Mios_Pruebas;

enum OperacionStock {
	SUMAR, RESTAR;
}

public class Producto {

	// Atributos

	private static int contadorIds = 1;
	private int id;
	private String nombreProducto;
	private int stock;
	private double precioCompra;
	private double precioVenta;

	// Constructor
	public Producto(String nombreProducto, int stock, double precioCompra, double precioVenta) {
		this.id = contadorIds++;
		this.nombreProducto = nombreProducto;
		this.stock = stock;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
	}

	// getters and setters
	public static int getContadorIds() {
		return contadorIds;
	}

	public static void setContadorIds(int contadorIds) {
		Producto.contadorIds = contadorIds;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	// metodos

	public void actualizarStock(int cantidad, OperacionStock operacion) {
		switch (operacion) {
		case SUMAR:
			stock += cantidad;
			break;
		case RESTAR:
			stock -= cantidad;
			break;
		default:
			System.err.println("Introduzca una operación valida: SUMAR o RESTAR.");
		}
	}

	public String toString() {
		return "\nDatos del producto: \n" + "-----------------------------------------\n" + "Id: " + this.id
				+ "\nNombre producto: " + this.nombreProducto + "\nStock disponible: " + this.stock
				+ "\nPrecio compra: " + precioCompra + "€." + "\nPrecio venta: " + precioVenta + "€.";

	}

}
