function distribuirUsuario(papel) {
    if(papel === "estudiante"){
        document.getElementById("verificacionPreRegistro").value = "estudiante";
    }else{
        document.getElementById("verificacionPreRegistro").value = "profesor";
    }
}