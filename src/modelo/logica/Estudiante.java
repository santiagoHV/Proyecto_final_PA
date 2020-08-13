package modelo.logica;

public class Estudiante extends Usuario{

    public void setAtributos(String nombrex, String apellidox, String correox, String contactox, String passwordx, String idx) {
        super.nombre=nombrex;
        super.apellido=apellidox;
        super.contacto=contactox;
        super.correo=correox;
        super.id=idx;
        super.password=password;
    }
}
