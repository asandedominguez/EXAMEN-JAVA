package examen;

public class Telefono {
    public static boolean verificarFormatoTelefono(String telefono) {
        // Si el texto es nulo, evitamos que el programa falle devolviendo false
        if (telefono == null) {
            return false;
        }
        
        // El patrón que define exactamente "+nn nnn nnn nnn"
        String patron = "\\+\\d{2} \\d{3} \\d{3} \\d{3}";
        
        // .matches() comprueba todo el String y devuelve true o false automáticamente
        return telefono.matches(patron);
    }
}
