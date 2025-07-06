//1. validar campos para que ninguno este vacio
const form = document.querySelector("form");
form.addEventListener("submit", function (event) {
  const nombre = document.getElementById("nombre").value;
  const email = document.getElementById("email").value;
  const password = document.getElementById("password").value;
  const confirmPassword = document.getElementById("confirmPassword").value;
  const fecha_nacimiento = document.getElementById("fecha_nacimiento").value;
  const genero = document.getElementById("genero").value;
  const pais = document.getElementById("pais").value;
  const terminos = document.getElementById("terminos").value;

  if (
    nombre === "" ||
    email === "" ||
    password === "" ||
    confirmPassword === "" ||
    fecha_nacimiento === "" ||
    genero === "" ||
    pais === "" ||
    terminos === ""
  ) {
    event.defaultPrevented();
    alert("Por favor, complete todos los campos.");
  }
});

// 2. Validación de formato de email: Asegúrate de que el campo de email tenga un formato válido.
form.addEventListener("submit", function (event) {
  const email = document.getElementById("email").value;
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/; //patron de email valido
  if (!emailRegex.test(email)) {
    event.preventDefault();
    alert("Por favor, ingrese un email válido.");
  }
});

// 3. Validación de contraseña
form.addEventListener("submit", function (event) {
  const password = document.getElementById("password").value;
  const confirmPassword = document.getElementById("confirmPassword").value;
  if (password.length < 8 || password === "") {
    event.preventDefault();
    alert("Debes de introducir al menos 8 caracteres");
  }

  if (password !== confirmPassword) {
    event.preventDefault();
    alert("Ambas contraseñas tienen que coincidir");
  }
});

// 4. Validacion de fecha nacimiento
form.addEventListener("submit", function (event) {
  const fechaNacimiento = new Date(
    document.getElementById("fecha_nacimiento").value
  );
  const hoy = new Date();
  if (fechaNacimiento > hoy) {
    event.preventDefault();
    alert("La fecha de nacimiento no puede ser mayor a la fecha actual");
  }
});

//5. Validacion de genero
function validarGenero() {
  const genero = document.getElementById("genero").value;
  if (genero === "") {
    alert("Por favor, seleccione un género");
    return false;
  }
  return true;
}
// Agrega un listener al evento 'submit' del formulario
form.addEventListener("submit", function (event) {
  if (!validarGenero()) {
    event.preventDefault();
    alert("Por favor, seleccione un género");
  }
});

// 6. Validacion de pais de residencia
form.addEventListener("submit", function (event) {
  const paisResidencia = document.getElementById("pais").value;
  if (paisResidencia === "") {
    event.preventDefault();
    alert("Por favor, indique un pais de residencia");
  }
});

// 7. Validacion de Intereses
form.addEventListener("submit", function (event) {
  const deporte = document.getElementById("deporte").checked;
  const musica = document.getElementById("musica").checked;
  const lectura = document.getElementById("lectura").checked;
  const programacion = document.getElementById("programacion").checked;

  if (!deporte && !musica && !lectura && !programacion) {
    event.preventDefault();
    alert(
      "Por favor, elija al menos un de las opciones disponibles: Deporte, Musica, etc."
    );
  }
});

/*
    **  una segunda forma  **
// Función de validación para los checkboxes
function validarIntereses(event) {
    // Obtener todos los checkboxes con el nombre 'intereses'
    const checkboxes = document.querySelectorAll('input[name="intereses"]:checked');
    
    // Verificar si al menos un checkbox está seleccionado
    if (checkboxes.length === 0) {
        alert('Por favor, seleccione al menos un interés');
        event.preventDefault(); // Detener el envío del formulario si no se seleccionó ningún interés
    }
}

// Agregar listener al evento 'submit' del formulario
const form = document.querySelector('form');
form.addEventListener('submit', validarIntereses);
*/

// 8. Validacion de terminos
form.addEventListener("submit", function (event) {
  const terminos = document.getElementById("terminos").checked;
  if (!terminos) {
    event.preventDefault();
    alert(
      "Por favor, marque la casilla de aceptacion de terminos y condiciones"
    );
  }
});

/*
function validarTerminos(event) {

  const terminos = document.querySelectorAll('input[name=terminos]:checked');

  if (checkboxes.length === 0) {
    alert('Pro favor, debe aceptar los terminos y condiciones, si no lo hace es imposible enviar formulario.');
    event.preventDefault();
  }
}

*/
