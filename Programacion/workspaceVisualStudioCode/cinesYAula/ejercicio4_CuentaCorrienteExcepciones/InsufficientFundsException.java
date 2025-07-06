package ejercicio4_CuentaCorrienteExcepciones;

public class InsufficientFundsException extends Exception {
    //constructor
    public InsufficientFundsException() {
        super("Lo siento, no tienes suficiente dinero en la cuenta");
    }
}
