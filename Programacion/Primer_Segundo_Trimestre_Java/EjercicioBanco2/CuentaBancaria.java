package EjercicioBanco2;

import java.util.Scanner;

public class CuentaBancaria {


	 //atributos
	
	 private String numeroCuenta;
	 private double saldo;
	 private TipoCuenta tipoCuenta;
	 private double tasaInteresMensual;
	 private boolean activo;
	 
	 //constructor
	public CuentaBancaria(String numeroCuenta, double saldo, TipoCuenta tipoCuenta, double tasaInteresMensual, boolean activo) {
		this.numeroCuenta = numeroCuenta;
		this.saldo = 0;
		this.tipoCuenta = tipoCuenta;
		this.tasaInteresMensual = tasaInteresMensual;
		this.activo = saldo > 0;
	}
	
	
	//seterrs and getters

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

	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public double getTasaInteresMensual() {
		return tasaInteresMensual;
	}

	public void setTasaInteresMensual(double tasaInteresMensual) {
		this.tasaInteresMensual = tasaInteresMensual;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	//---------------  METODOS  ----------------------------------------------
	
	///metodo depositar
	public void depositar(double cantidad) {
		System.out.print("\nSaldo antes de realizar el ingreso: ");
		 mostrarSaldo();
	
		try {
			if (cantidad < 0) {
				System.err.println("No se puede realizar cantidad menor a cero.");
			}else {
				this.saldo += cantidad;
				System.out.println("\nCantidad ingresada: " + cantidad + "€");
				mostrarSaldo();
			    activo = saldo > 0;
			}
		} catch (Exception e) {
			System.err.println("Introduce valores numericos.");
		}
		
	}
	
	
	//metodo retirar
	public boolean retirar(double cantidad) {
		 Scanner scanner = new Scanner(System.in);

		    if (cantidad <= saldo && cantidad > 0) {
		        saldo -= cantidad;
		        activo = saldo > 0;
		        System.out.println("Saldo retirado con exito la cantidad de: " + cantidad + "€.");
		        mostrarSaldo();
		        System.out.println();
		        return true;
		    } else {
		        System.err.println("Saldo insuficiente, no se puede retirar la cantidad de " + cantidad + "€");
		        System.out.println("Su saldo actual es: " + saldo + "€.");

		        System.out.print("Introduce nueva cantidad a retirar: ");
		        double nuevaCantidad = scanner.nextDouble();
		        
		        return retirar(nuevaCantidad);
		}
	}
	
	//mostrar Saldo
	public void mostrarSaldo() {
		System.out.println("\nEl saldo actual de la cuenta es: " + this.saldo + "€.");
	}

	//aplicar interes mensual
	 
	 public void aplicarInteresMensual() {
		 double interes = this.saldo * (this.saldo * tasaInteresMensual)/100;
		 this.saldo += interes;
		 System.out.println("\nSaldo actualizado despues de aplicar a s/f la cantidad de " + interes + "€.\nSaldo: " + this.saldo +"€");
		 activo = saldo > 0;
	 }
	 
	 
	 //comparar saldos entre cuentas diferentes.
	 public boolean compararSaldos(CuentaBancaria otraCuenta) {
		    return this.saldo >= otraCuenta.getSaldo();
		}

	 
	 //realizar transferencia a otra cuenta
	 
		public void transferencia(CuentaBancaria cuentaDestino, double valorTransferir) {

			if (this.retirar(valorTransferir)) {
				cuentaDestino.depositar(valorTransferir);
				System.out.println("Transferencia realizada con exito.\nSaldo actual: " + this.saldo + "€.");
			} else {
				System.err.println("Transferencia fallida. Saldo insuficiente.");
			}

		}
	 
	 //tostring
	 
	 public String toString() {
		 return "\nNumero de cuenta: " + this.numeroCuenta + "\nSaldo: " + this.saldo + "€" + "\nTipo de la cuenta: " 
				 + this.tipoCuenta + "\nTasa de interes aplicada: " + this.tasaInteresMensual +"%" 
				 + "\nEstado de la cuenta: " + (activo ? "activada" : "inactiva");
	 }
	 
	 
	 
	

}
