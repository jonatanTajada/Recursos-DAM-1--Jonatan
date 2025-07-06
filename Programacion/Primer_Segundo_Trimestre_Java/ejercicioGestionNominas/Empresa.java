package ejercicioGestionNominas;

import java.util.ArrayList;

public class Empresa {
	
	//Atributos
    private String cif;
    private String nombre;
    private ArrayList<Trabajador> trabajadores;

    
  //Constructor
    public Empresa(String cif, String nombre) {
        this.cif = cif;
        this.nombre = nombre;
        this.trabajadores = new ArrayList<>();
    }

    
    //metodo agregar trabajador
    public void agregarTrabajador(Trabajador trabajador) {
        trabajadores.add(trabajador);
    }

    //metodo mostrar listado de trabajadores
    public void mostrarListado() {
        for (Trabajador trabajador : trabajadores) {
            System.out.println(trabajador.toString());
        }
    }
}

