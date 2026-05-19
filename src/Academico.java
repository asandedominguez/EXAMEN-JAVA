// Importa todas las utilidades de Java, incluyendo interfaces como Comparable
import java.util.*; 

/**
 * Clase que representa a un Académico.
 * Implementa la interfaz Comparable para permitir que los objetos de esta clase
 * se puedan ordenar de forma automática utilizando un criterio propio (orden natural).
 */
class Academico implements Comparable<Academico> {
    // Atributo para almacenar el nombre del académico
    String nome;
    // Atributo para almacenar el año en el que ingresó el académico
    int anoIngreso;

    /**
     * Constructor de la clase Academico.
     * Sirve para inicializar un nuevo objeto con un nombre y un año de ingreso específicos.
     * 
     * @param nome El nombre que se le asignará al académico.
     * @param anoIngreso El año de ingreso que se le asignará al académico.
     */
    public Academico(String nome, int anoIngreso) {
        this.nome = nome;             // Guarda el nombre recibido en el atributo de la clase
        this.anoIngreso = anoIngreso; // Guarda el año recibido en el atributo de la clase
    }

    /**
     * Sobrescribe el método de la interfaz Comparable.
     * Define el criterio de ordenación por defecto (orden natural) para los objetos Academico.
     * 
     * @param o El otro objeto Academico con el que se va a comparar el objeto actual.
     * @return Un número negativo si este nombre va antes, cero si son iguales, o positivo si va después.
     */
    @Override
    public int compareTo(Academico o) {
        // Compara alfabéticamente el nombre de este académico con el nombre del otro académico (o)
        return this.nome.compareTo(o.nome); // Orde natural por nome
    }

    /**
     * Sobrescribe el método heredado de la clase Object.
     * Define cómo se representará este objeto cuando se convierta a texto (por ejemplo, al imprimirlo).
     * 
     * @return Una cadena de texto con el formato "Nombre (Año)".
     */
    @Override
    public String toString() {
        // Devuelve el texto estructurado con las variables de la clase
        return nome + " (" + anoIngreso + ")";
    }
}


