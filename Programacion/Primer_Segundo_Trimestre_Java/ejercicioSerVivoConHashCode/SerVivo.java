package ejercicioSerVivoConHashCode;

import java.util.Objects;

public class SerVivo  implements IOperaciones {

	// Atributos
	private byte edad;

	// Constructor
	public SerVivo(byte edad) {
		this.edad = edad;
	}

	//getters ands setters
	public byte getEdad() {
		return edad;
	}

	public void setEdad(byte edad) {
		this.edad = edad;
	}

	// equals SerVivo
	public boolean equals(SerVivo otro) {
		if (this == otro)
			return true;
		if (otro == null || getClass() != otro.getClass())
			return false;
		SerVivo serVivo = otro;
		return this.edad == serVivo.edad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(edad);
	}

	
// devuelve objeto mayor por edad
	public SerVivo mayor(SerVivo otro) {
		SerVivo mayor = this;

		if (otro != null && otro.getEdad() > mayor.getEdad()) {
			mayor = otro;
		}

		return mayor;
	}
	
	@Override
	public String toString() {
		return "-Datos de Ser Vivo: \n-Edad: " + edad;
	}

}
