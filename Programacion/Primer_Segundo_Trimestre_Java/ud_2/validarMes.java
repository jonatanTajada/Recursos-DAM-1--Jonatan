package ud_2;

import java.util.Scanner;

public class validarMes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Ingrese el número de mes (1-12): ");
        int mes = scanner.nextInt();

        
        if (mes >= 1 && mes <= 12) {
            // Mostrar el nombre del mes
            String nombreMes = obtenerNombreMes(mes);
            System.out.println("Nombre del mes: " + nombreMes);

            // Comprobar la cantidad de días en el mes
            int dias = obtenerDiasEnMes(mes);
            System.out.println("Número de días en el mes: " + dias);
        } else {
            System.out.println("Valor de mes no válido. Debe estar entre 1 y 12.");
        }
    }

    // Método para obtener el nombre del mes
    private static String obtenerNombreMes(int mes) {
        String[] nombresMeses = {
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };

        return nombresMeses[mes - 1];
    }

    // Método para obtener la cantidad de días en el mes
    private static int obtenerDiasEnMes(int mes) {
        switch (mes) {
            case 2: // Febrero
                return 28;
            case 4: case 6: case 9: case 11: // Meses con 30 días
                return 30;
            default: // Meses con 31 días
                return 31;
        }
    }
}
