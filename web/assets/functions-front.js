function distribuirUsuario(papel) {
    if(papel === "estudiante"){
        document.getElementById("verificacionPreRegistro").value = "estudiante";
    }else{
        document.getElementById("verificacionPreRegistro").value = "profesor";
    }
}

 function validarFormulario() {
    var formulario = document.addForm;
    if(formulario.inputContraseña.value!=formulario.inputContraseña2.value){
        //CODIGO DE MENSAJE DE ERROR
        console.log("CONTRASEÑAS DIFERENTES");
        formulario.inputContraseña.value="";
        formulario.inputContraseña1.value="";
        return false;
    }else{
        return true;
    }
 }