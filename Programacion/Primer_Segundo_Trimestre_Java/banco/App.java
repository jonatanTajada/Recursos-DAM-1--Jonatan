package banco;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Me falta crear bien las relaciones!!!

public class App {

		private List<Cliente> listaClientes;
	
		public App(){
			listaClientes = new ArrayList<Cliente>();
		}
	
	
		public void agregarCliente(Cliente cliente) {
			listaClientes.add(cliente);
		}
		
		public void mostrarListaClientes() {
			for(Cliente cliente : listaClientes) {
				System.out.println(cliente);
				System.out.println();
			}
		}
		
		
	
	
	public static void main(String[] args) {
		
		App app = new App();
		
		CuentaBancaria cuenta1 = new CuentaBancaria("123", 150);
		Cliente cliente1 = new Cliente("Jonatan", "Tajada Rico", "08/05/1988",new Date(), "Barakaldo", cuenta1);
		
		CuentaBancaria cuenta2 = new CuentaBancaria("54321", 1500.0);
        Cliente cliente2 = new Cliente("Maria", "Lopez", "15/03/1985", new Date(), "Pueblo", cuenta2);
        
        CuentaBancaria cuenta3 = new CuentaBancaria("12345", 1000.0);
        Cliente cliente3 = new Cliente("Juan", "Perez", "01/01/1990", new Date(), "Ciudad", cuenta1);
		
//		System.out.println(cuenta1.toString());
//		System.out.println(cliente1.toString());
		
		
        app.agregarCliente(cliente1);
        app.agregarCliente(cliente2);
        app.agregarCliente(cliente3);
		
		
        app.mostrarListaClientes();   
		System.out.println();
		
		cuenta1.retirar(50);
		app.mostrarListaClientes();   
		
	}
	
	
}
