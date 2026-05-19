import java.util.Arrays;

public class EliminarRepetidos {

    // FUNCIÓN AUXILIAR: Di se un número xa existe dentro dun array ata un límite determinado
    public static boolean xaExiste(int[] array, int numero, int limite) {
        for (int i = 0; i < limite; i++) {
            if (array[i] == numero) {
                return true; // Xa está na lista
            }
        }
        return false; // Non se atopa na lista
    }

    // FUNCIÓN PRINCIPAL: Devolve unha táboa sen duplicados
    public static int[] obterUnicos(int[] orixinal) {
        if (orixinal == null || orixinal.length == 0) {
            return new int[0];
        }

        // 1. PASO: Contamos cantos elementos únicos existen
        // Creamos unha táboa temporal do mesmo tamaño para facer a simulación
        int[] temporal = new int[orixinal.length];
        int contadorUnicos = 0;

        for (int i = 0; i < orixinal.length; i++) {
            // Se o número actual de 'orixinal' NON existe en 'temporal' ata o momento...
            if (!xaExiste(temporal, orixinal[i], contadorUnicos)) {
                temporal[contadorUnicos] = orixinal[i]; // Gardámolo temporalmente
                contadorUnicos++; // Sumamos un elemento único atopado
            }
        }

        // 2. PASO: Creamos a táboa definitiva co tamaño exacto e recortamos
        // Como 'temporal' xa ten os números ben postos ao principio, só copiamos os necesarios
        int[] resultadoDefinitivo = new int[contadorUnicos];
        for (int i = 0; i < contadorUnicos; i++) {
            resultadoDefinitivo[i] = temporal[i];
        }

        return resultadoDefinitivo;
    }

    public static void main(String[] args) {
        // Táboa de proba con varios números repetidos (por exemplo, o 2, o 5 e o 8)
        int[] numerosRepetidos = {2, 5, 8, 2, 3, 5, 1, 8, 8, 9, 2};

        System.out.println("Táboa orixinal:   " + Arrays.toString(numerosRepetidos));

        // Chamamos á función para limpar as repeticións
        int[] numerosUnicos = obterUnicos(numerosRepetidos);

        System.out.println("Táboa sen repetir: " + Arrays.toString(numerosUnicos));
    }
}