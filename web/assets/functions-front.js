function distribuirUsuario(papel) {
    if(papel === "estudiante"){
        document.getElementById("verificacionPreRegistro").value = "estudiante";
    }else{
        document.getElementById("verificacionPreRegistro").value = "profesor";
    }
}

 function validarFormulario() {
    if(document.getElementById(inputContraseña)!=document.getElementById(inputContraseña2)){
        alert("CONTRASEÑAS DIFERENTES")
        console.log("CONTRASEÑAS DIFERENTES");
        return false;
    }else{
        return true;
    }
 }