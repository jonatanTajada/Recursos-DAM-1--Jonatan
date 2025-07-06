import java.util.ArrayList;
import java.util.List;

public class Ejercicio_1 {

    public static void main(String[] args) {

        List<String> compisClase = new ArrayList<>();

        compisClase.add("Aritz");
        compisClase.add("Aitor");
        compisClase.add("Isa");
        compisClase.add("Issi");
        compisClase.add("Lori");
        compisClase.add("Iñigo");
        compisClase.add("Houyam");
        compisClase.add("Blanca-Profesora!");

        for (String nombres : compisClase) {
            System.out.println(nombres.toString());
        }

    }

}