package ejercicio4_CuentaCorrienteExcepciones;

public class TesterApp_B {
    public static void main(String[] args) {

        CheckingAccount_B cuenta = new CheckingAccount_B("12345");
        System.out.println("Bienvenido a la aplicación de gestión de cuentas corrientes.\n");

        System.out.println("Creando una nueva cuenta corriente...");
        System.out.println("Detalles de la cuenta creada:");
        System.out.println(cuenta);

        try {
            System.out.println("\nRealizando un deposito de 500 euros");
            cuenta.depositar(500);
            System.out.println("Despues del deposito:");
            System.out.println(cuenta);

            System.out.println("\nRealizando un retiro de 200 euros");
            cuenta.extraer(200);
            System.out.println("Despues del retiro:");
            System.out.println(cuenta);

            System.out.println("\nIntentando retirar 400 euros");
            cuenta.extraer(400); //lanzarA InsufficientFundsException
        } catch (InsufficientFundsException_B e) {
            System.out.println("ERROR: " + e.getMessage());
            System.out.println("Cantidad necesaria para retirar: " + e.getAmountNeeded());
            System.out.println("Por favor, asegurese de tener suficiente saldo antes de realizar retiros.");
        }
    }
}
