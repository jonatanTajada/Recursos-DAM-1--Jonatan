package ejercicio4_CuentaCorrienteExcepciones;

public class TesterApp {
    public static void main(String[] args) {

        CheckingAccount cuenta = new CheckingAccount("12345");
        System.out.println("Bienvenido a la aplicación de gestión de cuentas corrientes.\n");

        System.out.println("Creando una nueva cuenta corriente...");
        System.out.println("Detalles de la cuenta creada:");
        System.out.println(cuenta);

        try {
            System.out.println("\nRealizando un depósito de 500 euros");
            cuenta.depositar(500);
            System.out.println("Después del depósito:");
            System.out.println(cuenta);

            System.out.println("\nRealizando un retiro de 200 euros");
            cuenta.extraer(200);
            System.out.println("Después del retiro:");
            System.out.println(cuenta);

            System.out.println("\nIntentando retirar 400 euros");
            cuenta.extraer(400); // lanzara InsufficientFundsException
        } catch (InsufficientFundsException e) {
            System.out.println("ERROR: " + e.getMessage());
            System.out.println("Por favor, asegúrese de tener suficiente saldo antes de realizar retiros.");
        }
    }
}
