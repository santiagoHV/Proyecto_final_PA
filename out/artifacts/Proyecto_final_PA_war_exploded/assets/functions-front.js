function distribuirUsuario(papel) {
    if (papel === "estudiante") {
        document.getElementById("verificacionPreRegistro").value = "estudiante";
    } else {
        document.getElementById("verificacionPreRegistro").value = "profesor";
    }
}

function validarFormulario() {
    var formulario = document.getElementById("addForm");
    if (formulario.inputContraseña.value != formulario.inputContraseña2.value) {
        alert("Contraseñas iguales so");
        formulario.inputContraseña.value = "";
        formulario.inputContraseña1.value = "";
        return false;
    } else {
        return true
    }
}