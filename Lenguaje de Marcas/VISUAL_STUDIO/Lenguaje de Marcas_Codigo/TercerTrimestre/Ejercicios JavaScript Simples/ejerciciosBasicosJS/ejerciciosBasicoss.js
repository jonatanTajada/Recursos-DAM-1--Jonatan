//  1.	Escribe un programa de una sola línea que haga que aparezca en la pantalla un alert que diga “Hello World”.
    /* alert("Helow World!"); */

//  2.	Escribe un programa de una sola línea que escriba en la pantalla un texto que diga “Hello World” (document.write).
   /*  document.write("--Hellow World!"); */ 

//  3.	Escribe un programa de una sola línea que escriba en la pantalla el resultado de sumar 3 + 5.
   /*  document.write(3+5); */

//  4.	Escribe un programa de dos líneas que pida el nombre del usuario con un prompt y escriba un texto que diga “Hola nombreUsuario”
  /*   var nombreUsuario = prompt("Introduce su nombre: ");
    document.write("--Hola " + nombreUsuario); */

//  5.	Escribe un programa de tres líneas que pida un número, pida otro número y escriba el resultado de sumar estos dos números.
    /*  var num1 = prompt("Introduce el primer numero: ");
    var num2 = prompt("Introduce el segundo numero: ");
      document.write(parseInt(num1) + parseInt(num2)); */

//  6.	Escribe un programa que pida dos números y escriba en la pantalla cual es el mayor.
    /* var numero1 = prompt("Introduce el primer numero: ");
    var numero2 = prompt("Introduce el segundo numero: ");
    document.write("El mayor es: " + Math.max(parseInt(numero1), parseInt(numero2)));
    -----------------------
    if (numero1 > numero2) {
        document.write("El primer numero introducido es el numero mayor: " + numero1);
    } else if (numero2 > numero1) {
        document.write("El segundo numero introducido es el numero mayor: " + numero2);
    }else{
        document.write("Ambos numeros son iguales");
    } */

//  7.	Escribe un programa que pida 3 números y escriba en la pantalla el mayor de los tres.
/* var num1 = prompt("Introduce el primer número:");
    var num2 = prompt("Introduce el segundo número:");
    var num3 = prompt("Introduce el tercer número:");
    document.write("El mayor es: " + Math.max(parseInt(num1), parseInt(num2), parseInt(num3))); */

//  8.	Escribe un programa que pida un número y diga si es divisible por 2
/*  var num = prompt("Introduce un numero:");
    if (num % 2 === 0) {
        document.write(num + " es divisible por 2");
    } else {
        document.write(num + " no es divisible por 2");
    } */

//  9.	Escribe un programa que pida una frase y escriba cuantas veces aparece la letra a
    /* var frase = prompt("Escribe una frase que aparezca al menos una vez la letra 'a'");
    var contador = frase.split('a').length-1;
    document.write("La letra 'a' aparece en la frase " + contador + " veces."); */

//  10.	Escribe un programa que pida una frase y escriba las vocales que aparecen
    /* var frase = prompt("Introduce una frase:");
    var vocales = frase.match(/[aeiou]/gi);
    document.write("Las vocales en la frase son: " + vocales); */

//  11.	Escribe un programa que pida una frase y escriba cuántas de las letras que tiene son vocales
    /* var frase = prompt("Introduce una frase:");
    var vocales = frase.match(/[aeiou]/gi);
    var conteo = vocales ? vocales.length : 0;
    document.write("La frase tiene " + conteo + " vocales"); */

//  12.	Escribe un programa que pida una frase y escriba cuántas veces aparecen cada una de las vocales
   /*  var frase = prompt("Introduce una frase:");
    var vocales = frase.match(/[aeiou]/gi);
    var conteo = {};
    if (vocales) {
        vocales.forEach(function(vocal) {
            if(conteo[vocal]) {
                conteo[vocal]++;
            } else {
                conteo[vocal] = 1;
            }
        });
    }
    document.write("Apariciones de vocales: " + JSON.stringify(conteo)); */

//  13.	Escribe un programa que pida un número y nos diga si es divisible por 2, 3, 5 o 7 
//      (sólo hay que comprobar si lo es por uno de los cuatro)
/*     var num = parseInt(prompt("Introduce un numero:"));
    if (num % 2 === 0 || num % 3 === 0 || num % 5 === 0 || num % 7 === 0) {
        document.write(num + " es divisible por 2, 3, 5 o 7");
    } else {
        document.write(num + " no es divisible por 2, 3, 5 o 7");
    } */

// 14. Mostrar por cuales de los cuatro números es divisible
   /*  var num = parseInt(prompt("Introduce un numero:"));
    var divisores = [];
    if (num % 2 === 0) divisores.push(2);
    if (num % 3 === 0) divisores.push(3);
    if (num % 5 === 0) divisores.push(5);
    if (num % 7 === 0) divisores.push(7);
    document.write(num + " es divisible por: " + divisores.join(", "));   */  

//  15.	Escribir un programa que escriba en pantalla los divisores de un numero dado
   /*  var num = parseInt(prompt("Introduce un numero:"));
    document.write("Los divisores de " + num + " son: ");
    for (var i = 1; i <= num; i++) {
        if (num % i === 0) {
            document.write(i + " ");
        }
    } */

//  16.	Escribir un programa que escriba en pantalla los divisores comunes de dos números dados
   /* var num1 = parseInt(prompt("Introduce un numero:"));
      var num2 = parseInt(prompt("Introduce el segundo numero::"));
    document.write("Los divisores comunes de " + num1 + " y " + num2 + " son: ");
    for (var i = 1; i <= Math.min(num1, num2); i++) {
        if (num1 % i === 0 && num2 % i === 0) {
            document.write(i + " ");
        }
    }  */

//  17.	Escribir un programa que nos diga si un número dado es primo (no es divisible por ninguno otro número 
//      que no sea él mismo o la unidad)
/*     var num = parseInt(prompt("Introduce un numero:"));
    var esPrimo = true;
    if (num === 1) {
        esPrimo = false;
    } else {
        for (var i = 2; i <= Math.sqrt(num); i++) {
            if (num % i === 0) {
                esPrimo = false;
                break;
            }
        }
    }
    if (esPrimo) {
        document.write(num + " es un numero primo");
    } else {
        document.write(num + " no es un numero primo");
    } */


