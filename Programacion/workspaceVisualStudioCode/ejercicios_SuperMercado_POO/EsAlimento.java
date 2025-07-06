package ejercicios_SuperMercado_POO;

import java.time.LocalDate;

public interface EsAlimento {

    void setCaducidad(LocalDate fc);

    LocalDate getCaducidad();

    int getCalorias();
}
