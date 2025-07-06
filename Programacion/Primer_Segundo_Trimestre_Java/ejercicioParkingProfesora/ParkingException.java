package ejercicioParkingProfesora;



public class ParkingException extends Exception {
     
	
	private static final long serialVersionUID = 1L;
	
	private final String mensaje;
    private final String matricula;
    
    public ParkingException(String mensaje, String matricula) {
        this.mensaje = mensaje;
        this.matricula = matricula;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getMatricula() {
        return matricula;
    }
}

