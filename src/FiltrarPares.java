import java.util.Arrays;

public class FiltrarPares {

    public static int[] obterPares(int[] vectorOrixinal) {
        // Se o vector está baleiro ou non existe, devolvemos un vector baleiro
        if (vectorOrixinal == null || vectorOrixinal.length == 0) {
            return new int[0];
        }

        // PASO 1: Contamos cantos elementos son pares (para saber o tamaño)
        int contadorPares = 0;
        for (int i = 0; i < vectorOrixinal.length; i++) {
            if (vectorOrixinal[i] % 2 == 0) { // O resto entre 2 é cero -> é par
                contadorPares++;
            }
        }

        // Creamos o novo vector co tamaño exacto de pares atopados
        int[] vectorPares = new int[contadorPares];

        // PASO 2: Enchemos o novo vector só cos números pares
        int indicePares = 0; // Este contador controla a posición dentro do novo vector
        for (int i = 0; i < vectorOrixinal.length; i++) {
            if (vectorOrixinal[i] % 2 == 0) {
                vectorPares[indicePares] = vectorOrixinal[i];
                indicePares++; // Avanzamos á seguinte cela do novo vector
            }
        }

        return vectorPares; // Devolvemos o vector filtrado
    }

    public static void main(String[] args) {
        // Creamos un vector de proba con números mistos
        int[] numeros = {5, 8, 12, 3, 7, 14, 22, 9, 0};

        System.out.println("Vector orixinal: " + Arrays.toString(numeros));

        // Chamamos á función
        int[] soPares = obterPares(numeros);

        // Amosamos o resultado
        System.out.println("Vector de pares: " + Arrays.toString(soPares));
    }
}
