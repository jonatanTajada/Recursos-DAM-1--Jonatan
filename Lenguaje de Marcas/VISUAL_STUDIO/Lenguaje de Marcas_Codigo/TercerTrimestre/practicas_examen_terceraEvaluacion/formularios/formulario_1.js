/*
ESTAMOS VALIDANDO LOS CAMPOS PARA QUE PASE ALGO SI NO SE CUMPLE, EVENTOS.

1. Tipo de evento: Es el primer parámetro y especifica el tipo de evento al que se va a escuchar. 
Por ejemplo, "click", "submit", "mouseover", etc.
2. Función de controlador de evento: Es el segundo parámetro y especifica la función que se ejecutará cuando ocurra el evento.

- Tipo de evento: 'submit'. Indica que el controlador de eventos se activará cuando se envíe el formulario.

- Función de controlador de evento: function(event) {...}. Es una función anónima que toma un parámetro event. 
Esta función se ejecutará cuando se envíe el formulario. El parámetro event representa el objeto del evento y 
puede utilizarse para acceder a información sobre el evento, como el elemento que causó el evento, etc.

No, no siempre tiene que haber dos parámetros. El parámetro del evento es opcional, pero es muy común porque 
generalmente necesitas saber algo sobre el evento que está ocurriendo. Por ejemplo, al manejar el evento de envío 
del formulario ('submit'), es común utilizar el objeto de evento para prevenir 
el envío predeterminado del formulario (con event.preventDefault()).
*/


// 1. Validación de campos requeridos: Verifica que los campos de nombre, email y mensaje no estén vacíos antes de enviar el formulario.
//--------------------------------------------------------------------------------------------------------------------------------------
const form = document.querySelector("form");
form.addEventListener("submit", function (event) {
    const nombre = document.getElementById("nombre").value;
    const apellidos = document.getElementById("apellidos").value;
    const mensaje = document.getElementById("mensaje").value;
    

  if (nombre === "" || apellidos === "" || mensaje === "") {
    event.preventDefault(); // Si alguno de los campos está vacío, evita el envío del formulario
    alert("Por favor, complete todos los campos.");
  }
});


// 2. Validación de formato de email: Asegúrate de que el campo de email tenga un formato válido.
form.addEventListener('submit', function(event) {
    const email = document.getElementById('email').value;
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/; //patron de email valido
    if (!emailRegex.test(email)) {
        event.preventDefault();
        alert('Por favor, ingrese un email válido.');
    }
});

// 3. Validación de fecha de nacimiento: Comprueba que la fecha de nacimiento sea menor que la fecha actual.
form.addEventListener('submit', function(event){
const fechaNacimiento = new Date(document.getElementById('fecha_nacimiento').value);
const hoy = new Date();

if (fechaNacimiento > hoy) {
    event.preventDefault();
    alert('La fecha de nacimiento no pueder ser posterior a la fecha actual');
}
});


// 4. Validación de longitud de mensaje: Limita la longitud del mensaje a un cierto número de caracteres, 200 caracteres.
form.addEventListener('submit', function(event) {
    const mensaje = document.getElementById('mensaje').value;
    if (mensaje.length > 200) {
        event.preventDefault();
        alert('El mensaje no puede exceder los 200 caracteres.');
    }
});


form.addEventListener('submit', function(event){
const pais_spain = document.getElementById('españa').checked;
const pais_france = document.getElementById('francia').checked;

if (!pais_france && !pais_spain) { // if (pais_france == true || pais_spain == true)
    event.preventDefault();
    alert("Por favor, eliga el pais donde usted reside");
}
});














