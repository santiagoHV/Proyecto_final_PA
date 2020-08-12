package modelo.logica;

public class Profesor extends Usuario{

    //PARA SETEAR DATOS DE PROFESOR (EXCEPTO MATERIA) USAR METODO DE USUARIO
    //PARA SETEAR MATERIA DE PROFESOR UTILIZAR DIRECTAMENTE EL SET

    private String Materia;

    public String getMateria() {
        return Materia;
    }

    public void setMateria(String materia) {
        Materia = materia;
    }
}
