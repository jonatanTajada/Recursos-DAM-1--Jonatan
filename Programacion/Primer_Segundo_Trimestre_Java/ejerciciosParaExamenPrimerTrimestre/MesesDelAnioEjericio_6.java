package ejerciciosParaExamenPrimerTrimestre;

/**
 * @author Jonatan
 * comentario : Lo que hace este programa es imprimir en consolo una variable de tipo Mes (enum)
 */
public class MesesDelAnioEjericio_6 {

	enum Mes{
		
		ENERO, FEBRERO, MARZO, ABRIL, MAYO, JUNIO, JULIO, AGOSTO, SEPTIEMBRE, OCTUBRE, NOVIEMBRE, DICIEMBRE
	}
	
	public static void main(String[] args) {
		
		Mes m = Mes.MARZO;
		
		System.out.println(Mes.MARZO);

	}
	
	
}
