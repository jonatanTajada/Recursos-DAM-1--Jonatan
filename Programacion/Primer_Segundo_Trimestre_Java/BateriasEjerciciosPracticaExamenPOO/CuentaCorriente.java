package BateriasEjerciciosPracticaExamenPOO;

public class CuentaCorriente {


	//atributos
	private Titular titular1;
	private Titular titular2 = null;
	private String numeroCuenta;
	private double saldo;
	
	
	public CuentaCorriente(Titular titular1, Titular titular2, String numeroCuenta, double saldo) {
		this.titular1 = titular1;
		this.titular2 = titular2;
		
		if (numeroCuenta.length() == 20) {
			this.numeroCuenta = numeroCuenta;
		}else {
			System.err.println("El numero de cuenta debe contender 20 digitos ");
		}
		
	
		this.saldo = saldo;
	}


	public Titular getTitular1() {
		return titular1;
	}


	public void setTitular1(Titular titular1) {
		this.titular1 = titular1;
	}


	public Titular getTitular2() {
		return titular2;
	}


	public void setTitular2(Titular titular2) {
		this.titular2 = titular2;
	}


	public String getNumeroCuenta() {
		return numeroCuenta;
	}


	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void cambiarSaldo(double nuevoSaldo) {
		this.saldo= nuevoSaldo;
	}

	@Override
	public String toString() {
		return "\n-Datos del titular: " + this.titular1 + "-Datos del titular 2: " + this.titular2
				+ "\nNumero de cuenta: " + this.numeroCuenta + "\nSaldo: " + this.saldo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
