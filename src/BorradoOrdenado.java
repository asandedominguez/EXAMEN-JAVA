import java.util.Arrays;

public class BorradoOrdenado {

    public static int[] borrarOrdenado(int[] matriz, int valor) {
        int posicion = -1;

        // 1. Buscamos a posición do elemento
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i] == valor) {
                posicion = i;
                break;
            }
        }

        // Se non existe, devolvemos a orixinal
        if (posicion == -1) {
            return matriz;
        }

        // 2. Desprazamos os elementos cara á esquerda para manter a orde
        // O bucle vai desde onde estaba o número ata o penúltimo elemento
        for (int i = posicion; i < matriz.length - 1; i++) {
            matriz[i] = matriz[i + 1];
        }

        // 3. Creamos a nova táboa recortada
        int[] novaMatriz = new int[matriz.length - 1];
        for (int i = 0; i < novaMatriz.length; i++) {
            novaMatriz[i] = matriz[i];
        }

        return novaMatriz;
    }

    public static void main(String[] args) {
        int[] numerosOrdenados = {2, 5, 8, 14, 20};
        System.out.println("Orixinal Ordenada: " + Arrays.toString(numerosOrdenados));

        int[] resultado = borrarOrdenado(numerosOrdenados, 5);
        System.out.println("Despois de borrar o 5: " + Arrays.toString(resultado));
        // Saída: [2, 8, 14, 20] (Mantén a orde perfectamente)
    }
}