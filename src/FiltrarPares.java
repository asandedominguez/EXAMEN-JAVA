import java.util.Arrays;

public class FiltrarPares {

    /**
     * Método estático que recibe un array de enteiros e devolve un novo array
     * que contén unicamente os números pares presentes no orixinal.
     * 
     * @param vectorOrixinal O array de entrada con todos os números.
     * @return Un novo array co tamaño xusto que contén só os números pares.
     */
    public static int[] obterPares(int[] vectorOrixinal) {
        // Control de seguridade: se o vector non existe ou está baleiro,
        // devolvemos inmediatamente un array baleiro de tamaño 0 para evitar erros
        if (vectorOrixinal == null || vectorOrixinal.length == 0) {
            return new int[0];
        }

        // PASO 1: Contamos cantos elementos son pares (para saber o tamaño do array final)
        int contadorPares = 0;
        for (int i = 0; i < vectorOrixinal.length; i++) {
            // O operador % calcula o resto da división. Se o resto entre 2 é cero, o número é par
            if (vectorOrixinal[i] % 2 == 0) { 
                contadorPares++; // Incrementamos o contador de pares atopados
            }
        }

        // Creamos o novo vector en memoria co tamaño exacto de números pares que contamos
        int[] vectorPares = new int[contadorPares];

        // PASO 2: Enchemos o novo vector unicamente cos números pares do vector orixinal
        int indicePares = 0; // Este índice controla a posición de escritura dentro do novo vector
        for (int i = 0; i < vectorOrixinal.length; i++) {
            // Volvemos a comprobar se o elemento actual é par
            if (vectorOrixinal[i] % 2 == 0) {
                vectorPares[indicePares] = vectorOrixinal[i]; // Gardamos o número par no novo array
                indicePares++; // Avanzamos á seguinte cela baleira do novo vector de pares
            }
        }

        return vectorPares; // Devolvemos o vector filtrado e finalizado
    }

    public static void main(String[] args) {
        // Creamos un array unidimensional de proba con números pares e impares mixtos
        int[] numeros = {5, 8, 12, 3, 7, 14, 22, 9, 0};

        // Imprimimos o array inicial converténdoo a texto lexible con Arrays.toString()
        System.out.println("Vector orixinal: " + Arrays.toString(numeros));

        // Chamamos á función de filtrado pasándolle os nosos números
        int[] soPares = obterPares(numeros);

        // Amosamos o resultado final para comprobar que só contén os números pares (incluíndo o 0)
        System.out.println("Vector de pares: " + Arrays.toString(soPares));
    }
}

