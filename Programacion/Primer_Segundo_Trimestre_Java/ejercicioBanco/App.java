package ejercicioBanco;

import java.util.*;

public class App {

	private List<Cliente> listaClientes;

	public App() {
		listaClientes = new ArrayList<Cliente>();
	}

	public void agregarCliente(Cliente cliente) {
		listaClientes.add(cliente);
	}

	public void mostrarListaClientes() {
		for (Cliente cliente : listaClientes) {
			System.out.println(cliente);
			System.out.println();
		}
	}

	public static void main(String[] args) {

		App app = new App();

		// Crear cuentas y clientes
		
		CuentaBancaria cuenta1 = new CuentaBancaria("123", 150, TipoCuenta.AHORROS, 10.0);
		Cliente cliente1 = new Cliente("Jonatan", "Tajada Rico", "08/05/1988", new Date(), "Barakaldo");
		cliente1.agregarCuentaBancaria(cuenta1);

		System.out.println("**************************************************************************************");

		CuentaBancaria cuenta2 = new CuentaBancaria("54321", 1500.0, TipoCuenta.CORRIENTE, 3.0);
		Cliente cliente2 = new Cliente("Maria", "Lopez", "15/03/1985", new Date(), "Bilbao");
		cliente2.agregarCuentaBancaria(cuenta2);

		app.agregarCliente(cliente1);
		app.agregarCliente(cliente2);

		// Mostrar lista de clientes y sus cuentas
		System.out.println("Lista de Clientes:");
		app.mostrarListaClientes();

		// Realizar operaciones en las cuentas
		System.out.println("\nOperaciones en las cuentas:");
		cuenta1.depositar(50);
		// cuenta1.retirar(200); // si activas esto la cuenta acaba inactiva
		cuenta2.retirar(200);
		System.out.println("-------");
		cuenta1.aplicarInteresMensual();
		cuenta2.aplicarInteresMensual();

		// Comparar saldos
		System.out.println("\nComparacion de saldos entre cuentas:");
		if (cuenta1.compararSaldos(cuenta2)) {
			System.out.println("El titular de la cuenta " + cliente1.getNombre() + " tiene un saldo mayor o igual a: "
					+ cliente2.getNombre() + ".");
		} else {
			System.out.println("El titular de la cuenta " + cliente1.getNombre() + " tiene un saldo menor a:  "
					+ cliente2.getNombre() + ".");
		}

		// Mostrar lista de clientes después de las operaciones
		System.out.println("\nLista de Clientes después de operaciones:");
		app.mostrarListaClientes();
	}

}
