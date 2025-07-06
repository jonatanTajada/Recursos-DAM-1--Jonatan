package Practicas_fin_de_curso.Ejercicio_Colecciones_Diccionarios;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String continuar;
        Lista lista = new Lista();

        do {

            int opcion;

            do {
                System.out.println("Opciones de menu: ");
                System.out.println("1. Cargar datos en la lista personas");
                System.out.println("2. Listar todas las personas");
                System.out.println("3. Crear persona nueva y añadirlo a la lista");
                System.out.println("4. Eliminar persona de la lista");
                System.out.println("5. Numero total de personas");
                System.out.println("6. Buscar persona por DNI");
                System.out.println("7. Buscar persona por su nombre");
                System.out.println("8. Ordenar lista");
                System.out.println("9. Guardar la lista de personas en un archivo CSV.");
                System.out.println("10. Salir del menu");
                System.out.println("Por favor, elija una opcion: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                if (opcion < 1 || opcion > 10) {
                    System.err.println("Por favor, introduzca una opcion valida");
                }
            } while (opcion < 1 || opcion > 10);

            switch (opcion) {
                case 1:
                    lista.cargar();
                    break;

                case 2:
                    lista.recorrerListaPersonas();
                    break;

                case 3:
                    lista.crearPersona();
                    break;

                case 4:
                    System.out.println("Introduce el indice de la persona que quieres eliminar: ");
                    int indiceEliminar = Integer.parseInt(scanner.nextLine());
                    lista.eliminarPersona(indiceEliminar);
                    break;

                case 5:
                    System.out.println("Total de personas en la lista: " + lista.contar());
                    break;

                case 6:
                    System.out.println("Introduce el DNI de la persona que deseas buscar: ");
                    String dniBuscar = scanner.nextLine();
                    Persona personaEncontrada = lista.buscar(dniBuscar);
                    if (personaEncontrada != null) {
                        System.out.println("Persona encontrada: \n" + personaEncontrada);
                    }
                    break;

                case 7:
                    System.out.println("Introduce el nombre de la persona que deseas buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    List<Persona> personasEncontradas = lista.buscarPersonaNombre(nombreBuscar);

                    if (!personasEncontradas.isEmpty()) {
                        System.out.println("Personas encontradas:");
                        for (Persona persona : personasEncontradas) {
                            System.out.println(persona);
                        }
                    }
                    break;

                case 8:
                    System.out.println("Lista ordenada por nombre: ");
                    lista.ordenar();

                    break;
                    
                    case 9:
                    lista.guardar();
                    String rutaArchivo = lista.getRutaArchivo();
                    System.out.println("Lista guardada con exito en un archivo csv.");
                    System.out.println("La ruta del archivo es: " + rutaArchivo);
                    
                    break;

        

                case 10:
                    System.out.println("Saliendo del programa...");
                    System.out.println("Hasta la proxima!");
                    continuar = "no";
                    break;

            }

            System.out.println("Deseas realizar otra operacion? (si/no):");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("si"));

        System.out.println("Hasta pronto!");
        scanner.close();

    }
}
