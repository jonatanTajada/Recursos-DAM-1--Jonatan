package ejercicioBanco;

import java.util.Scanner;

//SUPERCLASE -- CLASE PADRE

public class CuentaBancaria {

	// Atributos

	private String numeroCuenta;
	private double saldo;
	private TipoCuenta tipoCuenta;
	private double tasaInteresMensual;
    private boolean activo;

	// Constructor
	public CuentaBancaria(String numeroCuenta, double saldo, TipoCuenta tipoCuenta, double tasaInteresMensual) {

		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.tipoCuenta = tipoCuenta;
		this.tasaInteresMensual = tasaInteresMensual;
		this.activo = saldo > 0;
	}

	// getters ands setters

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
	
//------------------------------------------------------------------------------
	//***** Metodos*******
//--------------------------------------------------------------------------------	
	
	public void depositar(double cantidad) {

		if (cantidad > 0) {
			saldo += cantidad;
			activo = saldo > 0;
			System.out.println("La cantidad de " + cantidad + "€, ha sido ingresado correctamente");
			mostrarSaldo();
		} else {
			System.err.println("Error: La cantidad a depositar debe ser mayor que cero.");
		}

	}

	// retirar dinero
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
	

	// Mostrar saldo
	 public void mostrarSaldo() {
	        System.out.println("Saldo actual: " + saldo + "€.");
	    }
	
	
	 // Aplicar Interes Mensual
	 public void aplicarInteresMensual() {
	        double interes = saldo * (tasaInteresMensual / 100.0);
	        saldo += interes;
	        activo = saldo > 0;
	        System.out.println("Nuevo saldo despues de aplicarle la tasa de interes mensual a s/f: " + saldo + "€.");
	    }
	 
	 // Comparar el saldo entre cuentas
	 public boolean compararSaldos(CuentaBancaria otraCuenta) {
	        return this.saldo >= otraCuenta.getSaldo();
	    }
	
	 //  Transferencia bancaria
	 public void transferencia(CuentaBancaria cuentaDestino, double valorTransferir) {
		 
		    if (this.retirar(valorTransferir)) {
		        cuentaDestino.depositar(valorTransferir);
		        System.out.println("Transferencia realizada con exito.\nSaldo actual: " + this.saldo + "€.");
		    } else {
		        System.err.println("Transferencia fallida. Saldo insuficiente.");
		    }
	 }
	 
	// toString

	 public String toString() {
	        return "Numero cuenta: " + numeroCuenta + "\nSaldo de la cuenta: " + saldo + "€." + "\nTipo de cuenta: " + tipoCuenta
	                + "\nTasa de Interes Mensual: " + tasaInteresMensual + "%" + "\nEstado de la cuenta: " + (activo ? "Activa" : "Inactiva");
	    }

}


