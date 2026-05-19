import java.util.Arrays;

public class BorradoDesordenado {

    public static int[] borrarDesordenado(int[] matriz, int valor) {
        int posicion = -1;

        // 1. Buscamos onde está o número
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i] == valor) {
                posicion = i;
                break; // Xa o atopamos, saímos do bucle
            }
        }

        // Se o número non existe na táboa, devolvemos a matriz tal cal
        if (posicion == -1) {
            return matriz;
        }

        // 2. Tapamos o oco poñendo o último elemento na posición do borrado
        matriz[posicion] = matriz[matriz.length - 1];

        // 3. Creamos unha nova táboa cun elemento menos e copiamos os datos
        int[] novaMatriz = new int[matriz.length - 1];
        for (int i = 0; i < novaMatriz.length; i++) {
            novaMatriz[i] = matriz[i];
        }

        return novaMatriz;
    }

    public static void main(String[] args) {
        int[] numeros = {14, 5, 8, 2, 9};
        System.out.println("Orixinal: " + Arrays.toString(numeros));

        int[] resultado = borrarDesordenado(numeros, 8);
        System.out.println("Despois de borrar o 8: " + Arrays.toString(resultado));
        // Saída típica: [14, 5, 9, 2] (O 9 pasou á posición do 8)
    }
}