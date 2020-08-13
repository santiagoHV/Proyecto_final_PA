package modelo.logica;

public class Profesor extends Usuario{

    public void setAtributos(String nombre, String apellido,String correo,String contacto,String password,String id, String materia){
        super.nombre=nombre;
        super.apellido=apellido;
        super.contacto=contacto;
        super.correo=correo;
        super.id=id;
        super.password=password;
        super.materia=materia;
    }
}
