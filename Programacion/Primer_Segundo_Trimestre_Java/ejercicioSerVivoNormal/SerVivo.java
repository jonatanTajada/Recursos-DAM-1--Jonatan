package ejercicioSerVivoNormal;


public class SerVivo implements IOperaciones{

	//Atributos
	
	private byte edad;
	
	//Constructor

	public SerVivo(byte edad) {
		this.edad=edad;
	}

	//setters and getters
	public byte getEdad() {
		return edad;
	}

	public void setEdad(byte edad) {
		this.edad = edad;
	}


	
	//metodo equals-si la edad son iguales
	public boolean equals(SerVivo otro) {
		if (this.edad == otro.getEdad()) {
			return true;
		}else {
			return false;
		}
	}
	
	
	@Override
	public SerVivo mayor(SerVivo otro) {
		
		if (this.edad > otro.getEdad()) {
			return this;
		}else {
			return otro;
		}
	}


	@Override
	public String toString() {
		return "-Datos de ser vivo:\nEdad: " + edad;
	} 

	
	
}
