package ejercicioClubCiclista;

import javax.swing.JOptionPane;

public class ClubCiclista {

    public static void main(String[] args) {
    	
        while (true) {
        	
            String entradaKilometros = JOptionPane.showInputDialog("Ingrese los kilometros separados por espacio (o FIN para terminar):");

            if (entradaKilometros == null || entradaKilometros.equalsIgnoreCase("FIN")) {
                break;
            }

            int[] kilometros = obtenerKilometrajes(entradaKilometros);

            // Apartado a) Mostrar si en todas las salidas se han sobrepasado los 100 km.
            int haSobrepasado100Km = verificarSobrepaso(kilometros);

            // Apartado b) Media de km diarios, sin computar los días de descanso.
            int mediaDiariaSinDescanso = calcularMedia(kilometros);

            // Apartado c) Diferencia máxima de km entre todas las salidas (sin contar los días de descanso).
            int diferenciaMaximaEntreSalidas = calcularDiferenciaMaxima(kilometros);

            // Apartado d) ¿Cuál fue el intervalo de días con más jornadas de descanso consecutivos?
            int maxDiasDescansoConsecutivos = calcularMaxDiasDescanso(kilometros);

            // Apartado e) Comprobar si existe una progresión ascendente de kms en todos los días de la semana.
            int progresionAscendente = verificarProgresionAscendente(kilometros);

            // Mostrar resultados usando JOptionPane
            String resultados = String.format("a) %d\nb) %d\nc) %d\nd) %d\ne) %d",
                    haSobrepasado100Km, mediaDiariaSinDescanso, diferenciaMaximaEntreSalidas,
                    maxDiasDescansoConsecutivos, progresionAscendente);

            JOptionPane.showMessageDialog(null, resultados);
        }
    }

    
  //  ---------------------------------------------------------------------------------------------------------------
  //  									*** METODOS **
  //-----------------------------------------------------------------------------------------------------------------
    
    private static int[] obtenerKilometrajes(String entrada) {
    	
        String[] kmsString = entrada.split(" ");
        int[] kms = new int[7];

        for (int i = 0; i < 7; i++) {
            // Verificar si hay suficientes elementos en kmsString antes de convertir a entero
            if (i < kmsString.length && !kmsString[i].isEmpty()) {
                try {
                    kms[i] = Integer.parseInt(kmsString[i]);
                } catch (NumberFormatException e) {
                    // Manejar el caso en el que la cadena no sea un numero valido
                    System.err.println("Error: La entrada no es un número válido en la posicion " + i);
                    kms[i] = 0; // Puedes asignar un valor por defecto o manejar el error de otra manera
                }
            } else {
                // Asignar 0 si no hay suficientes elementos o si la cadena es vacía
                kms[i] = 0;
            }
        }

        return kms;
    }


    private static int verificarSobrepaso(int[] kilometros) {
        for (int km : kilometros) {
            if (km <= 100) {
                return 0;
            }
        }
        return 1;
    }

    private static int calcularMedia(int[] kilometros) {
        int suma = 0;
        int conteo = 0;

        for (int km : kilometros) {
            if (km > 0) {
                suma += km;
                conteo++;
            }
        }

        return conteo > 0 ? suma / conteo : 0;
    }

    private static int calcularDiferenciaMaxima(int[] kilometros) {
        int maximo = Integer.MIN_VALUE;
        int minimo = Integer.MAX_VALUE;

        for (int km : kilometros) {
            if (km > 0) {
                maximo = Math.max(maximo, km);
                minimo = Math.min(minimo, km);
            }
        }

        return maximo - minimo;
    }

    private static int calcularMaxDiasDescanso(int[] kilometros) {
        int maxDiasDescanso = 0;
        int diasDescanso = 0;

        for (int km : kilometros) {
            if (km == 0) {
                diasDescanso++;
            } else {
                maxDiasDescanso = Math.max(maxDiasDescanso, diasDescanso);
                diasDescanso = 0;
            }
        }

        return maxDiasDescanso;
    }

    private static int verificarProgresionAscendente(int[] kilometros) {
        for (int i = 1; i < kilometros.length; i++) {
            if (kilometros[i] <= 0 || kilometros[i] <= kilometros[i - 1]) {
                return 0;
            }
        }
        return 1;
    }
}

   

//Este proyecto en Java está diseñado para analizar el rendimiento
//semanal de un club ciclista. Se registran los kilómetros recorridos 
//por cada corredor durante cada día de la semana, con la posibilidad 
//de especificar días de descanso (registrados como 0 km). El programa 
//proporciona diversos resultados, como verificar si se superaron los 100 km 
//en todas las salidas, calcular la media diaria sin contar los días de descanso, 
//determinar la diferencia máxima de kilómetros entre las salidas, encontrar el 
//intervalo máximo de días consecutivos de descanso, y verificar si hay una progresión 
//ascendente en los kilómetros recorridos.
