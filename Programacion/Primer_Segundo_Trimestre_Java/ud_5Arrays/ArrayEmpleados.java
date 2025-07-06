package ud_5Arrays;


import java.util.Scanner;

public class ArrayEmpleados {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		int cantidadEmpleados = 2;
		double sueldoMaximo = 0;
		String nombreEmpleadoSueldoMasAlto = "";
		
		String[] nombres = new String[cantidadEmpleados];
		double[] sueldos = new double[cantidadEmpleados];
		
		System.out.println("Introduciendo datos\n");
		for (int i = 0; i < cantidadEmpleados; i++) {
		    System.out.print("Nombre del empleado " + (i + 1) + ": ");
		    nombres[i] = scanner.next().toUpperCase();
		
		    System.out.print("Sueldo del empleado " + (i + 1) + ": ");
		    sueldos[i] = scanner.nextDouble();
		}
		

		System.out.println("Datos sobre la consulta del empleado que mejor salario tiene en la empresa.\n");
		for (int i = 0; i < sueldos.length; i++) {
	
		    if (sueldos[i] > sueldoMaximo) {
		    	
		        sueldoMaximo = sueldos[i];
		        nombreEmpleadoSueldoMasAlto = nombres[i];
		    } else if (sueldos[i] == sueldoMaximo) {
		    	
		        nombreEmpleadoSueldoMasAlto += ", " + nombres[i];
		    }
		}
		
		System.out.println("El/los empleados mejor remunerados son: " + nombreEmpleadoSueldoMasAlto);
		System.out.println("Sueldo máximo: " + sueldoMaximo + "€.");
		
		}

	
	
	}
















//2º opcion utulizando el metodo Min_Value de la clase Double

//Scanner scanner = new Scanner(System.in);
//
//int cantidadEmpleados = 2;
//
//String[] nombres = new String[cantidadEmpleados];
//double[] sueldos = new double[cantidadEmpleados];
//
//
//double sueldoMaximo = Double.MIN_VALUE;
//
//String nombreEmpleadoSueldoMasAlto = "";
//
//for (int i = 0; i < cantidadEmpleados; i++) {
//	
//	System.out.print("Nombre del empleado " + (i + 1) + ": ");
//	nombres[i] = scanner.next();
//	
//	System.out.print("Sueldo del empleado " + (i + 1) + ": ");
//	sueldos[i] = scanner.nextDouble();
//
//	if (sueldos[i] > sueldoMaximo) {
//		
//		sueldoMaximo = sueldos[i];
//		nombreEmpleadoSueldoMasAlto = nombres[i];
//	}
//}
//
//System.out.println("El empleado mejor remunerado es: " + nombreEmpleadoSueldoMasAlto);
//System.out.println("Sueldo: " + sueldoMaximo + "€.");


//3º forma y mas compleja

//int cantidadEmpleados = 2;
//String[] nombres = new String[cantidadEmpleados];
//double[] sueldos = new double[cantidadEmpleados];
//
//double sueldoMaximo = 0;
//String nombreEmpleadoSueldoMasAlto = "";
//
//for (int i = 0; i < nombres.length; i++) {
//	
//	System.out.print("Nombre del empleado " + (i + 1) + ": ");
//	nombres[i] = scanner.next();
//
//	System.out.print("Sueldo del empleado " + (i + 1) + ": ");
//	sueldos[i] = scanner.nextDouble();
//
//	if (i == 0 || sueldos[i] >= sueldoMaximo) {
//		
//		if (sueldos[i] > sueldoMaximo) {
//			
//			sueldoMaximo = sueldos[i];
//			nombreEmpleadoSueldoMasAlto = nombres[i];
//		} else if (sueldos[i] == sueldoMaximo) {
//			
//			nombreEmpleadoSueldoMasAlto += ", " + nombres[i];
//		}
//	}
//	
//}
//
//
//
//System.out.println("El/los empleados mejor remunerados son: " + nombreEmpleadoSueldoMasAlto);
//System.out.println("Sueldo máximo: " + sueldoMaximo + "€.");

