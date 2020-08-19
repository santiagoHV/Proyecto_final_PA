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
        formulario.inputContraseña.value="";
        formulario.inputContraseña1.value="";
    }
 }