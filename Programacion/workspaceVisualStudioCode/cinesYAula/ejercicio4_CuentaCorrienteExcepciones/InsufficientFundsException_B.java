package ejercicio4_CuentaCorrienteExcepciones;

public class InsufficientFundsException_B extends Exception {
    //atributo
    private double amountNeeded;

    //constructor
    public InsufficientFundsException_B(double amountNeeded) {
        super("Lo siento, no tienes suficiente dinero en la cuenta");
        this.amountNeeded = amountNeeded;
    }

    public double getAmountNeeded() {
        return amountNeeded;
    }

    public void setAmountNeeded(double amountNeeded) {
        this.amountNeeded = amountNeeded;
    }
}
