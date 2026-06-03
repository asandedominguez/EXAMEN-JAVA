public class Acronimo {
    // Método estático (non precisa "new Acronimo()")
    public static String crearAcronimo(String tituloCancion) {
        // 1. Control de seguridade por si mandan algo baleiro
        if (tituloCancion == null || tituloCancion.isEmpty()) {
            return "";
        }

        String acronimo = ""; // Aquí imos "sumar" as letras

        // 2. Cortamos a frase por espazos normais
        String[] palabras = tituloCancion.split(" ");

        // 3. Percorremos as palabras unha a unha
        for (int i = 0; i < palabras.length; i++) {
            String palabraActual = palabras[i];

            // Se a palabra non está baleira, collemos a súa primeira letra
            if (!palabraActual.isEmpty()) {
                char primeiraLetra = palabraActual.charAt(0);

                // Convertemos a letra a maiúscula e "sumámola" ao noso acrónimo
                acronimo = acronimo + Character.toUpperCase(primeiraLetra);
            }
        }

        // 4. Devolvemos o texto final
        return acronimo;
    }
}