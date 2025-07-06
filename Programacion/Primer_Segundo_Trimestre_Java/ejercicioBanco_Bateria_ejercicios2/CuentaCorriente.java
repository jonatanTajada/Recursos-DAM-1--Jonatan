package ejercicioBanco_Bateria_ejercicios2;

import java.util.Scanner;

import ejercicioBanco_Bateria_ejercicios.Titular;

public class CuentaCorriente {

	Scanner scanner = new Scanner(System.in);
	
	private Titular titular1;
	private Titular titular2;
	private String numeroCuenta;
	private double saldo;
	
	
	public CuentaCorriente(Titular titular1, Titular titular2, String numeroCuenta, double saldo) {
		
		this.titular1 = titular1;
		this.titular2 = titular2;
		
		if (numeroCuenta.length() != 20) {
			throw new IllegalArgumentException("El numero de cuenta debe contener 20 digitos");
		}else {
			this.numeroCuenta = numeroCuenta;
		}
		
		if (saldo < 0) {
			throw new IllegalArgumentException("El saldo no puede ser negativo");
		}else {
			this.saldo = saldo;
		}
		
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


	@Override
	public String toString() {
		return "CuentaCorriente [titular1=" + titular1 + ", titular2=" + titular2 + ", numeroCuenta=" + numeroCuenta
				+ ", saldo=" + saldo + "]";
	}
	
	
	
}
