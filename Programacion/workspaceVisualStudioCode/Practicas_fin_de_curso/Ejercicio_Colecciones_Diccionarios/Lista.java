package Practicas_fin_de_curso.Ejercicio_Colecciones_Diccionarios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Lista {

    Scanner scanner = new Scanner(System.in);
    // atributos
    private ArrayList<Persona> listaPersonas;
    private String rutaArchivo;

    // cosntructores
    public Lista() {
        this.listaPersonas = new ArrayList<>();
        this.rutaArchivo = "";
    }

    public Lista(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    // setters and getters

    public ArrayList<Persona> getLista() {
        return listaPersonas;
    }

    public void setLista(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    // --------------------METODOS--------------------------------------------------------------------------------------------

    // agregar persona a la lista
    public void insertar(Persona persona) {
        listaPersonas.add(persona);
        System.out.println("Lista actualiza despues de insertar una nueva persona a la lista: ");
        recorrerListaPersonas();
    }

    // -----------------------------------------------------------------------------------------------------------------------------
    // crear persona a la lista
    // @SuppressWarnings("resource")
    public void crearPersona() {

        try {
            // Pedir direccion
            System.out.println("-Introduce la direccion de la persona que deseas insertar en lista:");
            System.out.println("Introducir calle: ");
            String nuevaCalle = scanner.nextLine();
            if (nuevaCalle.isEmpty()) {
                throw new IllegalArgumentException("La calle no puede estar vacia.");
            }
            System.out.println("Introducir codigo postal");
            int nuevoCP = Integer.parseInt(scanner.nextLine());
            if (nuevoCP < 0 || nuevoCP > 99999) {
                throw new IllegalArgumentException("El codigo postal debe ser un numero entre 0 y 99999.");
            }
            System.out.println("Introducir provincia");
            String nuevaProvincia = scanner.nextLine();
            if (nuevaProvincia.isEmpty()) {
                throw new IllegalArgumentException("La provincia no puede estar vacia.");
            }
            Direccion nuevaDireccion = new Direccion(nuevaCalle, nuevoCP, nuevaProvincia);

            // Perdir datos personales
            System.out.println("-Introduce los datos personales: ");
            System.out.println("Introduce el nombre: ");
            String nuevoNombre = scanner.nextLine();
            System.out.println("Introduce los apellidos: ");
            String nuevoApellidos = scanner.nextLine();
            System.out.println("Introduce el D.N.I: ");
            String nuevoDni = scanner.nextLine();
            if (nuevoDni.length() != 9) {
                throw new IllegalArgumentException("El DNI debe tener 9 caracteres.");
            }
            System.out.println("Introduce la edad: ");
            int nuevaEdad = Integer.parseInt(scanner.next());
            if (nuevaEdad < 0 || nuevaEdad > 130) {
                throw new IllegalArgumentException("La edad debe ser un numero entre 0 y 130");
            }

            // Crear Persona
            Persona nuevaPersona = new Persona(nuevoNombre, nuevoApellidos, nuevoDni, nuevaEdad, nuevaDireccion);
            listaPersonas.add(nuevaPersona);
            System.out.println("Persona agregada a alista correctamente!!!");

        } catch (NumberFormatException e) {
            System.err.println("Error: Debes ingresar un numero valido para el codigo postal o la edad.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
    // -----------------------------------------------------------------------------------------------------------------------------

    // Eliminar una persona de la lista por su índice
    public void eliminarPersona(int indice) {
        if (!listaPersonas.isEmpty() && indice >= 0 && indice < listaPersonas.size()) {
            listaPersonas.remove(indice);
            System.out.println("Persona eliminada con exito.");
        } else {
            System.err.println("Error: el indice introducido no es valido o la lista esta vacia.");
        }
    }
    // -----------------------------------------------------------------------------------------------------------------------------

    // Obtener una persona de la lista por su índice
    public Persona buscarPersona(int indice) {
        if (!listaPersonas.isEmpty() && indice >= 0 && indice < listaPersonas.size()) {
            return listaPersonas.get(indice);
        } else {
            System.err.println("Error: el indice introducido no es valido o la lista esta vacia.");
            return null;
        }
    }
    // -----------------------------------------------------------------------------------------------------------------------------

    // obtener la cantidad de personas en la lista
    public int contar() {
        return listaPersonas.size();
    }
    // -----------------------------------------------------------------------------------------------------------------------------

    // obtener todas las personas de la lista
    public void recorrerListaPersonas() {
        if (listaPersonas.isEmpty()) {
            System.err.println("La lista de persona esta vacia");
        } else {
            for (Persona persona : listaPersonas) {
                System.out.println(persona.toString());
            }
        }
    }
    // -----------------------------------------------------------------------------------------------------------------------------

    // cargar la lista con personas
    public void cargar() {
        listaPersonas.clear();
        listaPersonas.add(new Persona("Jonatan", "Tajada Rico", "72447878A", 36,
                new Direccion("Alameda Rekalde", 48901, "Bizkaia")));
        listaPersonas.add(
                new Persona("Aitor", "Larranzabal Cobo", "32447878Z", 25, new Direccion("Gran Via", 48920, "Bizkaia")));
        listaPersonas.add(
                new Persona("Blanca", "Blanca Suarez", "45947878W", 45, new Direccion("Los Fueros", 47100, "Bizkaia")));
        System.out.println("Cargar realiza con exito.");

        System.out.println("Tamaño de la lista despues de cargar: " +
                listaPersonas.size() + " personas\n");
        System.out.println("Lista de personas actualiza: ");
        recorrerListaPersonas();
    }

    // -----------------------------------------------------------------------------------------------------------------------------

    // buscar persona por dni
    public Persona buscar(String dni) {
        if (listaPersonas.isEmpty()) {
            System.err.println("La lista esta vacia");
            return null;
        } else {
            for (Persona persona : listaPersonas) {
                if (persona.getDni().equals(dni)) {
                    return persona;
                }
            }
            System.out.println("La persona que desea buscar no se encuentra en la lista.");
            return null;
        }
    }

    // buscar a una persona por su nombre y si hay mas nombre que coincida que
    // devuelva todos
    public List<Persona> buscarPersonaNombre(String nombre) {
        List<Persona> personasEncontradas = new ArrayList<>();

        for (Persona persona : listaPersonas) {
            if (persona.getNombre().equalsIgnoreCase(nombre)) {
                personasEncontradas.add(persona);
            }
        }

        if (personasEncontradas.isEmpty()) {
            System.out.println("La persona que desea buscar no se encuentra en la lista");
        }

        return personasEncontradas;
    }

    // -----------------------------------------------------------------------------------------------------------------------------

    // ordenar la lista personas por nombre
    public void ordenar() {
        Collections.sort(listaPersonas, new Comparator<Persona>() {
            @Override
            public int compare(Persona persona1, Persona persona2) {
                return persona1.getNombre().compareTo(persona2.getNombre());
            }
        });
    }

    /*
     * public void ordenar2() {
     * listaPersonas.sort(Comparator.comparing(Persona::getNombre));
     * }
     */
    // ------------------------------------------------------------------------------------------------------------------------------------
    // guardar la lista de personas en un archivo CSV.
    public void guardar() {

        String archivoListaPersonasCSV = "D:\\Users\\famil\\Desktop\\PROGRAMACION\\DAM ORDUÑA 2023_2024\\Programacion\\workspaceVisualStudioCode\\Practicas_fin_de_curso\\Ejercicio_Colecciones_Diccionarios\\listaPersonas.csv";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoListaPersonasCSV))) {
            for (Persona persona : listaPersonas) {
                bw.write(persona.getNombre() + "," +
                        persona.getApellidos() + "," +
                        persona.getDni() + "," +
                        persona.getEdad() + "," +
                        persona.getDireccion().getCalle() + "," +
                        persona.getDireccion().getCp() + "," +
                        persona.getDireccion().getProvincia() + "\n");
            }

            bw.close();
            // actuliza la ruta del archivo con la nueva ruta
            this.rutaArchivo = archivoListaPersonasCSV;

        } catch (IOException e) {
            System.err.println("Error al guardar la lista de personas en el archivo CSV.");
            e.printStackTrace();
        }
    }

    // obtener la ruta del archivo
     public String getRutaArchivo() {
        return rutaArchivo;
    }

}
