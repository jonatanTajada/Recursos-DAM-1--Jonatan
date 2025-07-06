package ejercicio_Diccionario_HashMap_abril;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Diccionario {

    //atributo
    private Map<String, String> diccionario;

    //constructor
    public Diccionario() {
        diccionario = new HashMap<>();
    }

   //------------------------METODOS-------------------------------------------

   /**
     * Agrega un nuevo par de palabras al diccionario.
     *
     * @param palabraEspañol La palabra en español.
     * @param palabraIngles  La palabra en inglés.
     */
    public void nuevoPar(String palabraEspañol, String palabraIngles) {
        diccionario.put(palabraEspañol, palabraIngles);
    }


    /**
     * Traduce una palabra en español a su equivalente en inglés.
     *
     * @param palabraEspañol La palabra en español a traducir.
     * @return La palabra traducida en inglés, o null si la palabra no está en el diccionario.
     */
    public String traduce(String palabraEspañol) {
        return diccionario.get(palabraEspañol);
    }

    /**
     * Devuelve una palabra aleatoria en español del diccionario.
     *
     * @return Una palabra aleatoria en español.
     */
    public String palabraAleatoria() {
        if (diccionario.isEmpty()) {
            throw new IllegalStateException("El diccionario está vacío");
        }
        Random random = new Random();
        int indiceAleatorio = random.nextInt(diccionario.size());
        return (String) diccionario.keySet().toArray()[indiceAleatorio];
    }
    
    

/**
     * Devuelve la primera letra de la palabra en inglés correspondiente a una palabra en español.
     *
     * @param palabraEspañol La palabra en español.
     * @return La primera letra de la palabra en inglés, o '\0' si la palabra no está en el diccionario.
     */
    public char primeraLetraTraduccion(String palabraEspañol) {
        String traduccion = diccionario.get(palabraEspañol);
        return traduccion.charAt(0);
    }



    


}