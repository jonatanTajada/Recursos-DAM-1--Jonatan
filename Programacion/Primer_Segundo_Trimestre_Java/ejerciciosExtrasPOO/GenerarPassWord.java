package ejerciciosExtrasPOO;

import java.util.Random;

public class GenerarPassWord {

	
	//Atributos
	
	private Random random;
	
	private int longitud;
	private String passWord;
	
	//Constructores
	
	public GenerarPassWord () {
		this.longitud=8;
		this.random = new Random();
		generarPassword();
	}
	
	public GenerarPassWord(int longitud) {
		this.longitud=longitud;
		this.random= new Random();
		generarPassword();
		
	}
	
	
	
	//Setters and Getters
	
	public String getPassWord() {
		return passWord;
	}
	
	
	public int getLongitud() {
		return longitud;
	}
	
	
	public void setLongitud(int longitud) {
		this.longitud=longitud;
		generarPassword();
	}
	
	
	

	
	
	//Metodo para generar password
	public void generarPassword() {
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < longitud; i++) {
			
			int tipoCaracter = random.nextInt(3);
			
			switch (tipoCaracter) {
			
			case 0:
				sb.append((char) (random.nextInt(26) + 'A'));
				break;

			case 1:
				sb.append((char) (random.nextInt(26) + 'a'));
				break;
				
			case 2:
				sb.append(random.nextInt(10));
				break;
			}
		}
		
		passWord = sb.toString();
	}
	
	
	//Metodo para saber si contraseña es fuerte o no
	
	public boolean esFuertePassword() {
		
		int mayus= 0;
		int minus=0;
		int numeros=0;
		
		for(char c : passWord.toCharArray()) {
			
			if (Character.isUpperCase(c)) {
				mayus++;
			}else if(Character.isLowerCase(c)) {
				minus++;
			}else if(Character.isDigit(c)) {
				numeros++;
			}
		}
		
		return mayus > 2 && minus > 1 && numeros > 5;
	}
	
	
	
	
	
	
	
	
}
