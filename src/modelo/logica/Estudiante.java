package modelo.logica;

public class Estudiante extends Usuario{
    public Estudiante(String nombre, String apellido, String correo, String contacto, String password, String id){
        setAtributos(nombre,apellido,correo,contacto,password,id);
    }

    /**
     * Setea todos los parametros de la clase estudiante
     * @param nombre
     * @param apellido
     * @param correo
     * @param contacto
     * @param password
     * @param id
     */
    public void setAtributos(String nombre, String apellido, String correo, String contacto, String password, String id) {
        super.nombre=nombre;
        super.apellido=apellido;
        super.contacto=contacto;
        super.correo=correo;
        super.id=id;
        super.password=password;
    }
}
