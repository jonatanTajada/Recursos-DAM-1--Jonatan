//1. validar campos para que ninguno este vacio
const form = document.querySelector("form");

form.addEventListener("submit", function (event) {
  const nombre = document.getElementById("nombre").value;
  const direccion = document.getElementById("direccion").value;
  const email = document.getElementById("email").value;
  const edad = document.getElementById("edad").value;
  const estudios = document.getElementById("estudios").value;
  const terminos = document.getElementById("terminos").value;

  if (
    nombre === "" ||
    direccion === "" ||
    email === "" ||
    edad === "" ||
    estudios === "" ||
    terminos === ""
  ) {
    event.defaultPrevented();
    alert("Por favor, complete todos los campos.");
  }
});

//1. validar campo nombre. Minimo 6 caracteres y no tener valores numericos
form.addEventListener('submit', function(event){
    const nombre = document.getElementById("nombre").value;
    if (nombre.length < 6 || !isNaN(nombre)) {
        event.preventDefault();
        alert('El nombre debe contener al menos 6 caracteres y no puede contener números');
    }
});

//2. Validar campo direccion , no tener mas de 15 caracteres
form.addEventListener('submit', function(event){
    const direccion = document.getElementById("direccion").value;
    if (direccion.length > 15) {
        event.preventDefault();
        alert('La dirección no puede contener más de 15 caracteres');
    }
});

//3. email debe ser valido
form.addEventListener("submit", function (event) {
    const email = document.getElementById("email").value;
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/; 
    if (!emailRegex.test(email)) {
      event.preventDefault();
      alert("Por favor, ingrese un email válido.");
    }
  });

//4. Validar campo estudio, si no selecciona uno marca por defecto uno
form.addEventListener('submit', function(event){
    const estudios = document.getElementById('estudios').value;
    if (estudios === "") {
        event.preventDefault();
        alert('Por favor, seleccione un nivel de estudios');
    }
});

// 5. Validar terminos
form.addEventListener("submit", function (event) {
    const condiciones = document.getElementById("condiciones").checked;
    if (!condiciones) {
      event.preventDefault();
      alert(
        "Por favor, marque la casilla de acepto las condiciones"
      );
    }
  });

//6. Validar edad
form.addEventListener("submit", function(event){
  const edad = document.getElementById("edad").value;

  if (edad < 0 || edad > 120) {
    alert('La edad tiene que estar comprendida entre 0 y 120');
  }
});

  