package ejerciciosExtrasPOO;

import java.util.Scanner;

public class GenerarPassWordApp {

	
	//se trara de pedirle al usuario que meta una longitud para crear una contraseña con sa longitud
	//Despues pedirle la cantidad de elementos que quiere que tenga el array
	//creamos un array para saber si es fuerte esa contraseña que nos genera el metodo esFuertePassword
	//por ultimo mostrar el array donde tenemos metidos las contraseñas e indicarle si cada posicion de el array donde
	//		tengo las contraseñas es fuerte o no.
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Intoduce un numero para establecer la longitud de la contraseña: ");
		int longitud = scanner.nextInt();
		
		System.out.print("Introduce un numero para establecer el tamaño que deseas que tenga el array: ");
		int cantidadElementos = scanner.nextInt();
		
		
		//Crear array de tipo GenerarPassWord con la cantidad de elementos que nos da el usuario.
		GenerarPassWord[] passWord = new GenerarPassWord[cantidadElementos];
		
		
		//creo array para indicar si son fuertes o no (true/false)
		boolean[] esFuerteArray = new boolean[passWord.length];
		
		
		//creo objeto PassWord y verifico si son fuertes o no
		for(int i = 0; i < passWord.length; i++) {
			passWord[i] = new GenerarPassWord(longitud);//creo objeto "passWord" y lo meto en la posicion actual
			esFuerteArray[i] = passWord[i].esFuertePassword();//despues ese "password" comparo si es fuerte o no
		}
		
		
		
		//Mostrar las contraseñas y si son fuertes o no
		System.out.println("\nMostrando contraseñas y si son fuertes o no: ");
		for(int i = 0; i < passWord.length; i++) {
			System.out.println("Contraseña # " + (i+1) + ":" + passWord[i].getPassWord() + " - " + esFuerteArray[i]);
		}
		
		scanner.close();
		
	}
	
	
}
