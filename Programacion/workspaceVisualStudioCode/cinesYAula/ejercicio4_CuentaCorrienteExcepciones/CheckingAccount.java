package ejercicio4_CuentaCorrienteExcepciones;

public class CheckingAccount {

    // atributos
    private String numeroCuenta;
    private double saldo;

    // constructor
    public CheckingAccount(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0.0;
    }

    // setter and getters
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

    // metodo extraer dinero
    public void extraer(double monto) throws InsufficientFundsException {
        if (monto > saldo) {
            throw new InsufficientFundsException();
        }
        saldo -= monto;
    }

    // toString
    @Override
    public String toString() {
        return "Numero de Cuenta: " + numeroCuenta + "\nSaldo: " + saldo ;
    }
}
