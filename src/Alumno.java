// CORREGIDO: Nombre de la clase padre alineado con la corrección anterior
public class Alumno extends MembroComunidadeEscolar {

    // CORREGIDO: Atributos privados para cumplir las reglas de encapsulamiento
    private String curso;
    private int asignaturas;

    // CORREGIDO: Constructor parametrizado adaptado a la clase superior corregida
    public Alumno(String nome, String dni, int edade, double estatura, int codCentro, String nomCentro, String curso, int asignaturas){
        super(nome, dni, edade, estatura, codCentro, nomCentro);
        this.curso = curso;
        this.asignaturas = asignaturas;
    }

    public Alumno() {
        super();
        this.curso = "descoñecido"; // Corregido idioma
        this.asignaturas = 0;
    }

    public String getCurso() {
        return this.curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getAsignaturas() {
        return this.asignaturas;
    }

    // CORREGIDO: Parámetro renombrado y asignación mediante 'this' corregida
    public void setAsignaturas(int asignaturas) {
        if (asignaturas >= 0) {
            this.asignaturas = asignaturas;
        } else {
            this.asignaturas = 0;
        }
    }

    @Override
    public String toString() {
        // OPTIMIZADO: Incluye la información del miembro escolar invocando a super.toString()
        return "Alumno [Curso: " + curso + ", Asignaturas: " + asignaturas + "] - " + super.toString();
    }

    public static void main(String [] args) {
        // CORREGIDO: Instanciación adaptada al constructor con estatura (ej: 1.65)
        Alumno a2 = new Alumno("Pepe", "12345678A", 20, 1.65, 27001, "IES San Clemente", "DAM2", 7);

        // CORREGIDO: Acceso mediante getters públicos debido al encapsulamiento obligatorio
        System.out.println(a2.getNome() + " " + a2.getDni() + " " + a2.getEdade() + " ");

        System.out.println(a2);
    }
}
