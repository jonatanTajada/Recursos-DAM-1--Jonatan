package z_PracticasParaExamen2ºEvaluacion;

import java.util.Scanner;

import miPrimeraClaseTareaDiciembre_2023POO.Cuenta;

public class CuentaBancaria {

	public enum TipoCuenta {
		AHORROS, CORRIENTA
	}

	private TipoCuenta tipoCuenta;
	private String nombresTitular;
	private String apellidosTitular;
	private int numeroCuenta;
	private float saldo = 0;
	
	private float interesMensual;
	private float saldoActual;

	public CuentaBancaria(String nombresTitular, String apellidosTitular, int numeroCuenta, TipoCuenta tipoCuenta) {
	
	this.nombresTitular=nombresTitular;
	this.apellidosTitular=apellidosTitular;
	this.numeroCuenta=numeroCuenta;
	this.tipoCuenta=tipoCuenta;
	}

	public String getNombresTitular() {
		return nombresTitular;
	}

	public void setNombresTitular(String nombresTitular) {
		this.nombresTitular = nombresTitular;
	}

	public String getApellidosTitular() {
		return apellidosTitular;
	}

	public void setApellidosTitular(String apellidosTitular) {
		this.apellidosTitular = apellidosTitular;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	
	
//--------------------------------------------------------------------------------------------------------------------------------
//									METODOS
//--------------------------------------------------------------------------------------------------------------------------------
	
	
	//CONSULTAR SALDO
	public void consultarSaldo() {
		System.out.println("\nSaldo actual:" + this.saldo + "€." );
	}
	
	//ingresar
	public boolean ingresar(int cantidad){
		if (cantidad > 0) {
			saldo += cantidad;
			System.out.println("Se ha realizado el ingreso con exito");
			System.out.println("Su saldo actual es: " + saldo + "€.");
		}else {
			System.err.println("No es posible ingresar negativo");
		}
		return true;
	}
	
	
	public boolean retirar(int cantidad) {
		Scanner scanner  = new Scanner(System.in);
		if (cantidad <= saldo && cantidad > 0) {
			saldo -= cantidad;
			System.out.println("Retirada de efectivo con exito.");
			System.out.println("Su saldo actual es: " + saldo + "€.");
			
			return true;
		}else {
			System.err.println("No es posble retirar la cantidad de: " + cantidad + "€, su saldo actual es: " + saldo + "€.");
			System.out.print("Introduzca una nueva cantidad: ");
			int cantidadNueva = scanner.nextInt();
			
			return retirar(cantidadNueva);
			
			
		}
		
		
		
		
	}
	
	
	public boolean  compararCuentasSaldo(CuentaBancaria otraCuenta) {
		return this.saldo >= otraCuenta.getSaldo();
	}
	
	public void transferencia (CuentaBancaria cuentaDestino, int valorTransferir) {
	
		if (this.retirar(valorTransferir)) {
			cuentaDestino.ingresar(valorTransferir);
			System.out.println("Transferencia realizada con exito.\nSu saldo actual es: " + this.saldo + "€.");
		}else {
			System.err.println("Transferencia fallida.");
		}
		
	}
	
	 public String toString() {
	        return "Numero cuenta: " + numeroCuenta + "\nSaldo de la cuenta: " + saldo + "€." + "\nTipo de cuenta: " + tipoCuenta
	                + "\nTasa de Interes Mensual: " + interesMensual + "%" + "\nNombre: " + nombresTitular + "\nApellidos: " + apellidosTitular;
	    }
	
	public void aplicarInteres() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Introduzca un numero entero para poder que representa el porcentaje aplicar en el saldo");
		interesMensual = scanner.nextFloat();
		
		float interes = saldo * (interesMensual / 100);
		saldo += interes;
		System.out.println("Nuevo saldo despues de aplicarle la tasa de interes mensual a s/f: " + saldo + "€.");
	}
	
	
	public static void main(String[] args) {
		
		CuentaBancaria cuenta1 = new CuentaBancaria("Jonatan", "Tajada Rico", 123, TipoCuenta.CORRIENTA);
		
		cuenta1.consultarSaldo();
		System.out.println();
		
		cuenta1.ingresar(100);
		System.out.println();
		
		cuenta1.retirar(50);
		System.out.println();
		
		cuenta1.ingresar(950);
		System.out.println();
		
		cuenta1.consultarSaldo();
		System.out.println();
		
		cuenta1.aplicarInteres();
		
		cuenta1.consultarSaldo();
		System.out.println();
		
		System.out.println(cuenta1.toString());
		
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		
		CuentaBancaria cuenta2 = new CuentaBancaria("Janire", "lo quesea", 1234567 , TipoCuenta.AHORROS);
		
		cuenta2.consultarSaldo();
		System.out.println();
		
		cuenta2.ingresar(100);
		System.out.println();
		
		cuenta2.retirar(50);
		System.out.println();
		
		cuenta2.ingresar(950);
		System.out.println();
		
		System.out.println(cuenta2.toString());
		
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		
		
		
		
		
		
	}
	
	
	
	
	
	
	

}

