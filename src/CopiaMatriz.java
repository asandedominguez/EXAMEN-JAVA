public class CopiaMatriz {

    public static int[][] copiarMatriz(int[][] orixinal) {
        // Se a matriz orixinal non existe, devolvemos null
        if (orixinal == null) {
            return null;
        }

        // Creamos a nova matriz co mesmo número de filas
        int[][] copia = new int[orixinal.length][];

        // Percorremos cada fila e clonámola directamente
        for (int i = 0; i < orixinal.length; i++) {
            copia[i] = orixinal[i].clone(); // Clona a fila completa coas súas columnas
        }

        return copia; // Devolvemos a matriz copiada
    }

    public static void main(String[] args) {
        int[][] matrizOrixinal = {
                {1, 2, 3},
                {4, 5, 6}
        };

        // Chamamos á función para facer a copia
        int[][] matrizCopia = copiarMatriz(matrizOrixinal);

        // PROBA DE INDEPENDENCIA:
        // Imos cambiar un dato na copia para demostrar que a orixinal non se altera
        matrizCopia[0][0] = 99;

        System.out.println("Orixinal [0][0]: " + matrizOrixinal[0][0]); // Segue sendo 1
        System.out.println("Copia [0][0]: " + matrizCopia[0][0]);       // Agora é 99
    }
}
