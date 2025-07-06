package ejercicioZoologico2;

import java.util.Scanner;

public class AppGestionZoologico {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("*** Bienvenido a la aplicación de gestión del zoológico ***");

        System.out.print("Ingrese el nombre del zoológico: ");
        String nombreZoologico = scanner.nextLine();

        Zoologico zoologico = new Zoologico(nombreZoologico);

        int opcion;

        do {
            zoologico.mostrarMenu();
            System.out.print("Ingrese la opción: ");
            opcion = Integer.parseInt(scanner.next());
            

            switch (opcion) {
            
                case 1:
                    zoologico.agregarZona();
                    break;

                case 2:
                    zoologico.agregarInstalacion();
                    break;

                case 3:
                    zoologico.agregarAnimal();
                    break;

                case 4:
                    zoologico.agregarTrabajador();
                    break;

                case 5:
                    System.out.println("Listado de instalaciones:");
                    for (Instalacion instalacion : zoologico.getInstalaciones()) {
                        System.out.println(instalacion);
                    }
                    break;

                case 6:
                    System.out.println("Listado de animales:");
                    for (Animal animal : zoologico.getAnimales()) {
                        System.out.println(animal);
                    }
                    break;

                case 7:
                    System.out.print("Ingrese el ID del trabajador: ");
                    String idTrabajador = scanner.nextLine();
                    Trabajador trabajadorBusqueda = zoologico.buscarTrabajadorPorId(idTrabajador);

                    if (trabajadorBusqueda != null) {
                        zoologico.seleccionarTrabajador(trabajadorBusqueda);
                        zoologico.listarZonasTrabajador();
                    } else {
                        System.err.println("No se encontró el trabajador con el ID: " + idTrabajador);
                    }
                    break;
                    
                case 8:
                	 System.out.println("Listado de trabajadores:");
                     for (Trabajador trabajadores: zoologico.getTrabajadores()) {
                         System.out.println(trabajadores);
                     }
                	break;

                case 9:
                    zoologico.modificarZona();
                    break;

                case 10:
                    zoologico.modificarInstalacion();
                    break;

                case 11:
                    zoologico.modificarAnimal();
                    break;

                case 12:
                    zoologico.modificarTrabajador();
                    break;

                case 13:
                    zoologico.eliminarZona();
                    break;

                case 14:
                    zoologico.eliminarInstalacion();
                    break;

                case 15:
                    zoologico.eliminarAnimal();
                    break;

                case 16:
                    zoologico.eliminarTrabajador();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                   
                    break;

                default:
                    System.out.println("Opción no valida. Intente de nuevo.");
            }

        } while (opcion != 0);

   scanner.close();
   
   System.out.println("Hasta la proxima.");
    }


}




















