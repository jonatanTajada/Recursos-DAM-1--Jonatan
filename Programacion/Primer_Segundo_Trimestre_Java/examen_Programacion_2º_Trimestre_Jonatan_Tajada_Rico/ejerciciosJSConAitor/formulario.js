let nombre = "";
while (nombre.trim() === "") {
    nombre = prompt("Ingrese su anombre:");
}
document.getElementById('result').innerHTML += "Nombre ingresado: " + nombre + "<br>";










/*
let email = "";
while (!email.includes("@")) {
    email = prompt("Ingrese su correo electrónico:");
}
document.getElementById('result').innerHTML += "Correo electrónico ingresado: " + email + "<br>";


let numero = 0;
let intentos = 0;
while (numero <= 10) {
    numero = parseInt(prompt("Ingrese un número mayor que 10:"));
    intentos++;
}
document.getElementById('result').innerHTML += "Número ingresado: " + numero + "<br>";
document.getElementById('result').innerHTML += "Intentos necesarios: " + intentos + "<br>";


let edad;
do {
    edad = parseInt(prompt("Ingrese su edad (debe ser mayor de 18 años):"));
} while (isNaN(edad) || edad <= 18);
document.getElementById('result').innerHTML += "Edad ingresada: " + edad + "<br>";


let numero = parseInt(prompt("Ingrese un número:"));
let suma = 0;
let contador = 1;
do {
    suma += contador;
    contador++;
} while (contador <= numero);
document.getElementById('result').innerHTML += "Suma de los números del 1 al " + numero + ": " + suma + "<br>";


let numero = parseInt(prompt("Ingrese un número para ver su tabla de multiplicar:"));
let contador = 1;
do {
    document.getElementById('result').innerHTML += numero + " x " + contador + " = " + (numero * contador) + "<br>";
    contador++;
} while (contador <= 10);


for (let i = 1; i <= 10; i++) {
    document.getElementById('result').innerHTML += i + "<br>";
}


for (let i = 10; i >= 1; i--) {
    document.getElementById('result').innerHTML += i + "<br>";
}


let numero = parseInt(prompt("Ingrese un número para ver su tabla de multiplicar:"));
for (let i = 1; i <= 10; i++) {
    document.getElementById('result').innerHTML += numero + " x " + i + " = " + (numero * i) + "<br>";
}
*/