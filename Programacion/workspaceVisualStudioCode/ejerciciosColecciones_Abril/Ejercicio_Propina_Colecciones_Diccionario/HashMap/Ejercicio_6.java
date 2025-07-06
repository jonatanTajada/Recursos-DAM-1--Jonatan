package HashMap;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio_6 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int intentos = 3;
        Map<String, String> listaUsuarios = new HashMap<>();

        listaUsuarios.put("Jonatan", "123");
        listaUsuarios.put("Blanca", "123");
        listaUsuarios.put("Aitor", "123");

        do {
            System.out.print("Introduce nombre usuario:  ");
            String usuario = scanner.nextLine();

            System.out.print("Introduce la contraseña:  ");
            String password = scanner.nextLine();

            if (listaUsuarios.containsKey(usuario) && listaUsuarios.get(usuario).equals(password)) {
                System.out.println("Se encuentra en el area restringida");
                break;
            } else {
                intentos--;
                System.err.println("Usuario o contraseña incorrecta, intentelo de nuevo");
                if (intentos > 0) {
                    System.out.println("Le quedan " + intentos + " intentos.");
                } else {
                    System.err.println("Lo siento, no tiene acceso al area restringida");
                }
            }

        } while (intentos > 0);
        scanner.close();

    }

}
