import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Ejercicio_5_Disco {

    // atributos
    private String cantante;
    private String disco;
    private int anio;

    // constructor
    public Ejercicio_5_Disco(String cantante, String disco, int anio) {
        this.cantante = cantante;
        this.disco = disco;
        this.anio = anio;
    }

    // setters y getters
    public String getCantante() {
        return cantante;
    }

    public void setCantante(String cantante) {
        this.cantante = cantante;
    }

    public String getDisco() {
        return disco;
    }

    public void setDisco(String disco) {
        this.disco = disco;
    }

    public int getAnio() {
        return anio;
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    //              Clase interna ColeccionDiscos
    //------------------------------------------------------------------------------------------------------------------------------------------------

    public static class ColeccionDiscos {

        public static void main(String[] args) {
            List<Ejercicio_5_Disco> listaDiscos = new ArrayList<>();

            listaDiscos.add(new Ejercicio_5_Disco("Alejandro Sanz", "El alma al aire", 2000));
            listaDiscos.add(new Ejercicio_5_Disco("Alejandro Sanz2", "El alma al aire2", 2002));
            listaDiscos.add(new Ejercicio_5_Disco("Alejandro Sanz3", "El alma al aire3", 2003));

            // Ordenar lista de colección por año
            Collections.sort(listaDiscos, Comparator.comparingInt(Ejercicio_5_Disco::getAnio));

            // Mostrar la lista ordenada de discos
            System.out.println("Coleccion de discos ordenada por año:");
            System.out.println("-------------------------------------");
            for (Ejercicio_5_Disco disco : listaDiscos) {
                System.out.println("Cantante/Grupo: " + disco.getCantante());
                System.out.println("Disco: " + disco.getDisco());
                System.out.println("Año: " + disco.getAnio());
                System.out.println("-------------------------------------");
            }
        }
    }
}
