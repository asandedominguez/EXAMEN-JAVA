/**
 * Interfaz que define el comportamiento para las figuras que tienen área.
 */
public interface Area {
    
    /**
     * Método por defecto para calcular el área.
     * Al ser 'default', las clases que implementen esta interfaz NO están obligadas
     * a escribir este método si no lo necesitan, ya que heredan esta lógica básica.
     * 
     * @return El valor del área (por defecto devuelve 0).
     */
    default double calcularArea(){
        return 0; // Devuelve cero como valor inicial o genérico
    }
}
