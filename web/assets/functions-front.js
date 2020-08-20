function distribuirUsuario(papel) {
    if (papel === "estudiante") {
        document.getElementById("verificacionPreRegistro").value = "estudiante";
    } else {
        document.getElementById("verificacionPreRegistro").value = "profesor";
    }
}

function validarFormulario() {
    var formulario = document.addForm;
    if (formulario.inputContraseña.value != formulario.passwordregistro.value) {
        alert("Contraseñas iguales so");
        formulario.inputContraseña.value = "";
        formulario.passwordregistro.value = "";
        return false;
    } else {
        return true
    }
}