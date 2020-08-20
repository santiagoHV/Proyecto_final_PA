package modelo.logica;

public class Notas {

    /**
     * Constructor que inicializa todos los atributos
     * @param materia
     * @param estudiante
     * @param primerCorte
     * @param segundoCorte
     * @param tercerCorte
     */
    public Notas(String materia, String estudiante, int primerCorte, int segundoCorte, int tercerCorte){
        this.materia = materia;
        this.estudiante = estudiante;
        this.primerCorte = primerCorte;
        this.segundoCorte = segundoCorte;
        this.tercerCorte = tercerCorte;
    }
    private String materia;
    private String estudiante;
    private int primerCorte;
    private int segundoCorte;
    private int tercerCorte;

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public int getPrimerCorte() {
        return primerCorte;
    }

    public void setPrimerCorte(int primerCorte) {
        this.primerCorte = primerCorte;
    }

    public int getSegundoCorte() {
        return segundoCorte;
    }

    public void setSegundoCorte(int segundoCorte) {
        this.segundoCorte = segundoCorte;
    }

    public int getTercerCorte() {
        return tercerCorte;
    }

    public void setTercerCorte(int tercerCorte) {
        this.tercerCorte = tercerCorte;
    }

    /**
     * Retorna nota promediada
     * @return
     */
    public double getNotaFinal() {
        return (primerCorte*0.35)+(segundoCorte*0.35)+(tercerCorte*0.3);
    }
}
