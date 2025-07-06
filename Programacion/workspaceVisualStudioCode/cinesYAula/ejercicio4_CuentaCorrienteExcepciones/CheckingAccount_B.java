package ejercicio4_CuentaCorrienteExcepciones;

public class CheckingAccount_B {

    // atributos
    private String numeroCuenta;
    private double saldo;

    // constructor
    public CheckingAccount_B(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0.0;
    }

    // setters and getters
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void depositar(double monto) {
        saldo += monto;
    }

    public void extraer(double monto) throws InsufficientFundsException_B {
        if (monto > saldo) {
            double amountNeeded = monto - saldo;
            throw new InsufficientFundsException_B(amountNeeded);
        }
        saldo -= monto;
    }

    @Override
    public String toString() {
        return "Numero de Cuenta: " + numeroCuenta + "\nSaldo: " + saldo;
    }
}
