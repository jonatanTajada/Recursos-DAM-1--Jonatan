// no me gusta tanto y no me esta funcionando todo como yo quiero, revisar!!!


document.addEventListener("DOMContentLoaded", function () {
  const form = document.getElementById("registroForm");

  form.addEventListener("submit", function (event) {
    event.preventDefault();
    validarFormulario();
  });

  function validarFormulario() {
    const nombre = document.getElementById("nombre").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const confirmPassword = document.getElementById("confirmPassword").value;
    const fechaNacimiento = document.getElementById("fechaNacimiento").value;
    const genero = document.getElementById("genero").value;
    const pais = document.getElementById("pais").value;
    const intereses = obtenerIntereses();
    const terminos = document.getElementById("terminos").checked;

    if (
      !nombre ||
      !email ||
      !password ||
      !confirmPassword ||
      !fechaNacimiento ||
      !genero ||
      !pais ||
      !intereses ||
      !terminos
    ) {
      alert("Por favor, complete todos los campos.");
      return;
    }

    if (!validarContraseña(password, confirmPassword)) {
      alert(
        "Las contraseñas no coinciden o no tienen la longitud mínima requerida."
      );
      return;
    }

    // Aquí puedes enviar los datos del formulario a través de AJAX o realizar otras acciones
    console.log("Formulario válido. Enviando datos...");
  }

  function obtenerIntereses() {
    const intereses = [];
    const checkboxes = document.querySelectorAll(
      'input[name="intereses"]:checked'
    );
    checkboxes.forEach(function (checkbox) {
      intereses.push(checkbox.value);
    });
    return intereses.join(", ");
  }

  function validarContraseña(password, confirmPassword) {
    return password === confirmPassword && password.length >= 8;
  }
});
