public class CopiaMatriz {

    /**
     * Método estático que recibe unha matriz bidimensional de enteiros
     * e devolve unha copia exacta e independente en memoria.
     * 
     * @param orixinal A matriz que queremos duplicar.
     * @return Unha nova matriz idéntica ou null se a orixinal non existe.
     */
    public static int[][] copiarMatriz(int[][] orixinal) {
        // Control de seguridade: se a referencia é nula, evitamos erros devolvendo null
        if (orixinal == null) {
            return null;
        }

        // Instanciamos a nova matriz especificando só o número de filas da orixinal
        int[][] copia = new int[orixinal.length][];

        // Bucle para percorrer individualmente cada unha das filas da matriz
        for (int i = 0; i < orixinal.length; i++) {
            // .clone() duplica a fila enteira en memoria (con tódolos seus elementos)
            // e asigna esa nova referencia á posición correspondente da matriz copia
            copia[i] = orixinal[i].clone(); 
        }

        return copia; // Devolvemos a nova matriz totalmente independente
    }

    public static void main(String[] args) {
        // Declaramos e inicializamos unha matriz orixinal de 2 filas e 3 columnas
        int[][] matrizOrixinal = {
                {1, 2, 3},
                {4, 5, 6}
        };

        // Executamos o método para obter a réplica da matriz
        int[][] matrizCopia = copiarMatriz(matrizOrixinal);

        // PROBA DE INDEPENDENCIA:
        // Modificamos a primeira cela da copia para comprobar que están desconectadas
        matrizCopia[0][0] = 99;

        // Imprimimos os resultados para verificar que a matriz orixinal non sufriu cambios
        System.out.println("Orixinal [0][0]: " + matrizOrixinal[0][0]); // Segue sendo 1
        System.out.println("Copia [0][0]: " + matrizCopia[0][0]);       // Agora é 99
    }
}
