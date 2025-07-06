package ejercicio_5;




public class Hola {
    public static void main(String[] args) {
        // Declaración de variables
        double num1 = 10.5;
        double num2 = 5.2;
        double resultado;

        // Operaciones matemáticas
        resultado = num1 + num2; // Suma
        System.out.println("La suma de " + num1 + " y " + num2 + " es: " + resultado);

        resultado = num1 - num2; // Resta
        System.out.println("La resta de " + num1 + " y " + num2 + " es: " + resultado);

        resultado = num1 * num2; // Multiplicacion
        System.out.println("El producto de " + num1 + " y " + num2 + " es: " + resultado);

        resultado = num1 / num2; // División
        System.out.println("La division de " + num1 + " entre " + num2 + " es: " + resultado);

        // Modificación de variables
        num1++; // Incremento de num1 en 1
        num2--; // Decremento de num2 en 1
        System.out.println("Despues de incrementar num1 y decrementar num2:");
        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);

        // Uso de operadores de asignación
        num1 += 5; // Equivalente a: num1 = num1 + 5;
        num2 *= 2; // Equivalente a: num2 = num2 * 2;
        System.out.println("Despues de utilizar operadores de asignacion:");
        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);

        // Operaciones con otros tipos de datos
        int numeroEntero = 10;
        double resultadoMixto = numeroEntero / num1; // Division entre un entero y un double
        System.out.println("El resultado de dividir " + numeroEntero + " entre " + num1 + " es: " + resultadoMixto);
    }
}
