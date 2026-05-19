import java.util.Arrays;

public class busquedaBinaria {
    public int [][] matriz;
    public int elemento;

    public busquedaBinaria(int [][] matriz, int elemento){
        this.matriz = matriz;
        this.elemento = elemento;
    }

    public static int[] buscarB(int [][] mat, int valor){
        if (mat == null || mat.length == 0 || mat[0].length == 0){
            return new int[]{-1,-1};
        }

        int filas = mat.length;
        int columnas = mat[0].length;
        int inicio = 0;
        int fin = (filas * columnas) - 1;

        // OBLIGATORIO: Necesitamos un bucle while para que vaia reducindo o espazo de busca
        while (inicio <= fin) {
            // CORRECCIÓN: Declaramos e calculamos o medio AQUÍ DENTRO en cada volta
            int medio = inicio + (fin - inicio) / 2;

            int fila = medio / columnas;
            int columna = medio % columnas;
            int valorMedio = mat[fila][columna];

            if (valorMedio == valor) {
                return new int[]{fila, columna}; // Atopado!
            }

            if (valorMedio < valor) {
                inicio = medio + 1; // Buscamos na metade dereita
            } else {
                fin = medio - 1;    // Buscamos na metade esquerda
            }
        } // Aquí remata o while

        // CORRECCIÓN: Se sae do bucle sen retornar, é que o número non existe
        return new int[]{-1, -1};
    }

    public static void main (String[] args){
        // CORRECCIÓN: Definimos unha matriz que XA ESTÁ ordenada correctamente a man
        int [][] matrizOrdenada = {
                {1,  2,  5},
                {6,  24, 33},
                {50, 67, 98}
        };

        // Creamos o obxecto b1 usando o teu construtor
        busquedaBinaria b1 = new busquedaBinaria(matrizOrdenada, 67);

        // Chamamos á túa función pasándolle os datos do obxecto
        int[] atopado = buscarB(b1.matriz, b1.elemento);
        System.out.println("Posición do 67: " + Arrays.toString(atopado));

        // Probamos cun número que non existe
        int[] noAtopado = buscarB(b1.matriz, 99);
        System.out.println("Posición do 99: " + Arrays.toString(noAtopado));
    }
}