document.addEventListener('DOMContentLoaded', function () {
    
    const form = document.getElementById('registroForm');

    form.addEventListener('submit', function (event) {
        event.preventDefault();
        validarFormulario();
    });

    function validarFormulario() {
        validarCamposObligatorios();
        validarEmail();
        validarFechaNacimiento();
        validarLongitudMensaje();
        validarPais();
    }

    function validarCamposObligatorios() {
        const nombre = document.getElementById('nombre').value;
        const apellidos = document.getElementById('apellidos').value;
        const mensaje = document.getElementById('mensaje').value;

        if (nombre === "" || apellidos === "" || mensaje === "") {
            alert("Por favor, complete todos los campos.");
            event.preventDefault();
        }
    }

    function validarEmail() {
        const email = document.getElementById('email').value;
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/; // patrón de email válido

        if (!emailRegex.test(email)) {
            alert('Por favor, ingrese un email válido.');
            event.preventDefault();
        }
    }

    function validarFechaNacimiento() {
        const fechaNacimiento = new Date(document.getElementById('fecha_nacimiento').value);
        const hoy = new Date();

        if (fechaNacimiento > hoy) {
            alert('La fecha de nacimiento no puede ser posterior a la fecha actual');
            event.preventDefault();
        }
    }

    function validarLongitudMensaje() {
        const mensaje = document.getElementById('mensaje').value;
        if (mensaje.length > 200) {
            alert('El mensaje no puede exceder los 200 caracteres.');
            event.preventDefault();
        }
    }

    function validarPais() {
        const paisSp = document.getElementById('españa').checked;
        const paisFr = document.getElementById('francia').checked;

        if (!paisFr && !paisSp) {
            alert("Por favor, elija el país donde usted reside");
            event.preventDefault();
        }
    }
});
