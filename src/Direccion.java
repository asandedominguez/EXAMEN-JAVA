public class Direccion {

    /**
     * Valida se a dirección cumpre o formato exacto:
     * (Rúa|Avda|Lugar|Trav) [Nome] Número [Díxitos] Portal [Díxitos] Piso [Díxitos]
     */
    public static boolean comprobarDireccion(String direccion) {
        if (direccion == null) return false;

        // Expresión regular que valida o patrón completo
        String regex = "^(Rúa|Avda|Lugar|Trav) .+[.]? Número \\d+ Portal \\d+ Piso \\d+$";

        return direccion.matches(regex);
    }
}