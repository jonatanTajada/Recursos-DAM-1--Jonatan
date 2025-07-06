package ejercicioBanco_Bateria_ejercicios;

public class CuentaCorriente {

	//Atributos
	private Titular titular1;
	private Titular titular2=null;
	private String numeroCuenta;
	private double saldo;

	// Constructor
	public CuentaCorriente(Titular titular1, Titular titular2, String numeroCuenta, double saldo) {
		this.titular1 = titular1;
		this.titular2 = titular2;
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
	}

	// Getters
	public Titular getTitular1() {
		return titular1;
	}

	public Titular getTitular2() {
		return titular2;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	// Setter para cambiar el saldo
	public void cambiarSaldo(double nuevoSaldo) {
		this.saldo = nuevoSaldo;
	}

	@Override
	public String toString() {
		return "CuentaCorriente [titular1=" + titular1 + ", titular2=" + titular2 + ", numeroCuenta=" + numeroCuenta
				+ ", saldo=" + saldo + "]";
	}
	
	
	
}
