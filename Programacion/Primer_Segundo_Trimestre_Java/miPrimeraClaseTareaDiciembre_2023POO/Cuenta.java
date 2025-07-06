package miPrimeraClaseTareaDiciembre_2023POO;

import java.util.Scanner;

public class Cuenta {

	
	//Atributos
	
	private String nombre;
	private String numeroCuenta;
	private double tipoInteres;
	private double saldo;
	
	//Constructores
	
	public Cuenta() {}
	
	public Cuenta(String nombre, String numeroCuenta, double tipoDeInteres, double saldo) {
		this.nombre=nombre;
		this.numeroCuenta= numeroCuenta;
		this.tipoInteres=tipoDeInteres;
		this.saldo=saldo;
	}
	
	public Cuenta(Cuenta otraCuenta) {
	    this.nombre = otraCuenta.nombre;
	    this.numeroCuenta = otraCuenta.numeroCuenta;
	    this.tipoInteres = otraCuenta.tipoInteres;
	    this.saldo = otraCuenta.saldo;
	}

	
	//Setters and Getters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public double getTipoInteres() {
		return tipoInteres;
	}

	public void setTipoInteres(double tipoDeInteres) {
		this.tipoInteres = tipoDeInteres;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	
	//Metodos
	
	
	public boolean ingreso(double cantidad) {
	    if (cantidad <= 0) {
	        System.err.println("Debes ingresar una cantidad superior a cero.");
	        return false;
	    }

	    saldo += cantidad;

	    System.out.println("La cantidad de " + cantidad + "€, ha sido ingresada correctamente.");
	    System.out.println("Su saldo actual es de: " + saldo);
	    System.out.println();

	    return true;
	}
	
	public boolean reintegro(double cantidad) {
	    Scanner scanner = new Scanner(System.in);

	    if (cantidad <= saldo) {
	        saldo -= cantidad;

	        System.out.println("Saldo retirado con éxito la cantidad de : " + cantidad + "€.");
	        System.out.println("El saldo actual es de : " + saldo + "€.");
	        System.out.println();

	        scanner.close();
	        return true;
	    } else {
	        System.err.println("Saldo insuficiente, no se puede retirar la cantidad de " + cantidad + "€");
	        System.out.println("Su saldo actual es de: " + saldo);

	        System.out.print("Introduce una nueva cantidad a retirar: ");
	        double nuevaCantidad = scanner.nextDouble();
	        scanner.close();
	        return reintegro(nuevaCantidad);
	    }
	    
	}
	
	
	public boolean transferencia(Cuenta cuentaDestino, double importe) {
	    if (importe <= 0) {
	        System.err.println("El importe debe ser superior a cero.");
	        return false;
	    }

	    if (saldo >= importe) {
	        saldo -= importe; // Restar importe de la cuenta de origen
	        cuentaDestino.saldo += importe; // Sumar importe a la cuenta de destino

	        System.out.println("Transferencia de " + importe + "€ realizada con éxito desde " + this.numeroCuenta + " a " + cuentaDestino.numeroCuenta + ".");
	        System.out.println("Nuevo saldo en " + this.numeroCuenta + ": " + saldo + "€");
	        System.out.println("Nuevo saldo en " + cuentaDestino.numeroCuenta + ": " + cuentaDestino.saldo + "€");
	        System.out.println();

	        return true;
	    } else {
	        System.err.println("Saldo insuficiente en la cuenta " + this.numeroCuenta + " para realizar la transferencia de " + importe + "€.");
	        System.out.println("Su saldo actual es de: " + saldo);
	        System.out.println();
	        return false;
	    }
	}

	
	
	//**********************************************************************************
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		 String nombre, numero;
		 double tipo, importe;

		 //se crea objeto cuenta1 sin parámetros
		 //se ejecuta el constructor por defecto
		 Cuenta cuenta1 = new Cuenta();

		 System.out.print("Nombre : ");
		 nombre = sc.nextLine();
		 System.out.print("Número de cuenta : ");
		 numero = sc.nextLine();
		 System.out.print("Tipo de interes : ");
		 tipo = sc.nextDouble();
		 System.out.print("Saldo: ");
		 importe = sc.nextDouble();

		 cuenta1.setNombre(nombre);
		 cuenta1.setNumeroCuenta(numero);
		 cuenta1.setTipoInteres(tipo);
		 cuenta1.setSaldo(importe);

		 //se crea el objeto cuenta2 con los valores leidos por teclado
		 //se ejecuta el constructor con parámetros
		 Cuenta cuenta2 = new Cuenta("Juan Ferrández Rubio", "12345678901234567890", 1.75, 300);                       

		 //se crea cuenta3 como copia de cuenta1
		 //se ejecuta el constructor copia
		 Cuenta cuenta3 = new Cuenta(cuenta1);

		 //mostrar los datos de cuenta1
		 System.out.println("Datos de la cuenta 1");
		 System.out.println("Nombre del titular: " + cuenta1.getNombre());
		 System.out.println("Número de cuenta: " + cuenta1.getNumeroCuenta());
		 System.out.println("Tipo de interés: " + cuenta1.getTipoInteres());
		 System.out.println("Saldo: " + cuenta1.getSaldo());
		 System.out.println();
		       
		 //se realiza un ingreso en cuenta1
		 cuenta1.ingreso(4000);
		     
		 //mostrar el saldo de cuenta1 después del ingreso
		 System.out.println("Saldo: " + cuenta1.getSaldo());
		     
		 //mostrar los datos de cuenta2
		 System.out.println("Datos de la cuenta 2");
		 System.out.println("Nombre del titular: " + cuenta2.getNombre());
		 System.out.println("Número de cuenta: " + cuenta2.getNumeroCuenta());
		 System.out.println("Tipo de interés: " + cuenta2.getTipoInteres());
		 System.out.println("Saldo: " + cuenta2.getSaldo());
		 System.out.println();
		     
		 //mostrar los datos de cuenta3
		 System.out.println("Datos de la cuenta 3");
		 System.out.println("Nombre del titular: " + cuenta3.getNombre());
		 System.out.println("Número de cuenta: " + cuenta3.getNumeroCuenta());                                         
		 System.out.println("Tipo de interés: " + cuenta3.getTipoInteres());
		 System.out.println("Saldo: " + cuenta3.getSaldo());
		 System.out.println();
		     
		 //realizar una transferencia de 10€ desde cuenta3 a cuenta2
		 cuenta3.transferencia(cuenta2, 10);
		     
		 //mostrar el saldo de cuenta2
		 System.out.println("Saldo de la cuenta 2");
		 System.out.println("Saldo: " + cuenta2.getSaldo());
		 System.out.println();
		     
		 //mostrar el saldo de cuenta3
		 System.out.println("Saldo de la cuenta 3");
		 System.out.println("Saldo: " + cuenta3.getSaldo());
		 System.out.println();

		
	}
	
	
}
