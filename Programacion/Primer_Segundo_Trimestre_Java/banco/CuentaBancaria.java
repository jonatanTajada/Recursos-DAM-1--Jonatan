package banco;

import java.util.Scanner;

//SUPERCLASE -- CLASE PADRE

public class CuentaBancaria {

	//Atributos
	
	private String numeroCuenta;
	private double saldo;
	
	
	//Constructor
	public CuentaBancaria(String numeroCuenta, double saldo) {
		
		this.numeroCuenta=numeroCuenta;
		this.saldo=saldo;
	}

	
	//getters ands setters
	
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
	
	
	//Metodos
	
	
	public void depositar(double cantidad) {
		saldo+= cantidad;
		
		System.out.println("La cantidad de " + cantidad + "€, ha sido ingresado correctamente");
		System.out.println("Su saldo actual es de: " + saldo);
		System.out.println();
	}
	
	public void retirar(double cantidad) {
		Scanner scanner = new Scanner(System.in);
		
		if (cantidad <= saldo) {
			saldo-= cantidad;
			
			System.out.println("Saldo retirado con exito la cantidad de : " + cantidad + "€.");
			System.out.println("El saldo actual es de : " + saldo + "€.");
			System.out.println();
		}else {
		
				System.err.println("Saldo insuficiente no puede retirar la cantidad de  " + cantidad + "€");
				System.out.println("Su saldo actual es de: " + saldo);
				
				System.out.print("Introduce nueva cantidad a retirar: ");
				double nuevaCantidad=scanner.nextDouble();
				retirar(nuevaCantidad);
				
		}
		System.out.println();
		scanner.close();
	}
	
	
	//toString
	
	public String toString() {
		return "Numero cuenta: " + numeroCuenta + "\nSaldo de la cuenta: " + saldo + "€.";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
