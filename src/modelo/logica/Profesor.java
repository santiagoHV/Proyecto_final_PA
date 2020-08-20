package modelo.logica;

public class Profesor extends Usuario{
    public Profesor(String nombre, String apellido, String correo, String contacto, String password, String id,String materia){
        setAtributos(nombre,apellido,correo,contacto,password,id,materia);
    }

    /**
     * Setea todos los parametros de la clase profesor
     * @param nombre
     * @param apellido
     * @param correo
     * @param contacto
     * @param password
     * @param id
     * @param materia
     */
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
