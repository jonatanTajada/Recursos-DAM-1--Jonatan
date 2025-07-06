package ejercicioPeajes;
//esta interfaz hereda de CalculadorPeaje, cualquier clases o interfaz que implemente o herede 
//de ella tb lo hara de la interfaz CalculadorPeaje

public interface Vehiculo extends CalculadorPeaje {
    String getPlaca();
}

