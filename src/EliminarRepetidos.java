import java.util.Arrays;

public class EliminarRepetidos {

    /**
     * FUNCIÓN AUXILIAR: Comproba se un número concreto xa foi engadido ao array temporal.
     * Limita a busca ata unha posición determinada para non comprobar celas baleiras.
     * 
     * @param array O array temporal onde estamos gardando os elementos únicos.
     * @param numero O número que queremos comprobar se xa existe.
     * @param limite A cantidade de elementos válidos que levamos gardados ata o de agora.
     * @return true se o número xa está na lista, false en caso contrario.
     */
    public static boolean xaExiste(int[] array, int numero, int limite) {
        // Percorremos o array unicamente ata a posición do límite actual
        for (int i = 0; i < limite; i++) {
            if (array[i] == numero) {
                return true; // Atopado: o número xa existe na lista
            }
        }
        return false; // Non atopado: o número aínda non se rexistrou
    }

    /**
     * FUNCIÓN PRINCIPAL: Recibe un array con duplicados e devolve un novo array
     * que contén só os elementos únicos, mantendo a orde de aparición.
     * 
     * @param orixinal O array de enteiros de entrada con posibles repetidos.
     * @return Un novo array co tamaño xusto e sen elementos duplicados.
     */
    public static int[] obterUnicos(int[] orixinal) {
        // Control de seguridade: se o array non existe ou está baleiro, devolve un array de tamaño 0
        if (orixinal == null || orixinal.length == 0) {
            return new int[0];
        }

        // 1. PASO: Filtramos os elementos e contamos cantos únicos existen
        // Creamos unha táboa temporal do mesmo tamaño que a orixinal por seguridade
        int[] temporal = new int[orixinal.length];
        int contadorUnicos = 0; // Funciona como índice do array temporal e como contador

        // Percorremos todos os elementos do array orixinal
        for (int i = 0; i < orixinal.length; i++) {
            // Se o número actual do array orixinal NON existe en 'temporal' (buscando ata contadorUnicos)...
            if (!xaExiste(temporal, orixinal[i], contadorUnicos)) {
                temporal[contadorUnicos] = orixinal[i]; // Gardámolo na seguinte posición libre de 'temporal'
                contadorUnicos++; // Incrementamos o total de elementos únicos atopados
            }
        }

        // 2. PASO: Creamos a táboa definitiva co tamaño exacto e recortamos
        // Instanciamos o array co tamaño xusto determinado polo contador de únicos
        int[] resultadoDefinitivo = new int[contadorUnicos];
        
        // Copiamos os elementos válidos dende o array temporal ao array definitivo
        for (int i = 0; i < contadorUnicos; i++) {
            resultadoDefinitivo[i] = temporal[i];
        }

        return resultadoDefinitivo; // Devolvemos o array final xa depurado
    }

    public static void main(String[] args) {
        // Táboa de proba con varios números repetidos (por exemplo, o 2, o 5 e o 8)
        int[] numerosRepetidos = {2, 5, 8, 2, 3, 5, 1, 8, 8, 9, 2};

        // Imprime o array inicial converténdoo a texto lexible con Arrays.toString()
        System.out.println("Táboa orixinal:   " + Arrays.toString(numerosRepetidos));

        // Chamamos á función principal para limpar as repeticións
        int[] numerosUnicos = obterUnicos(numerosRepetidos);

        // Imprime o resultado final para verificar que non hai duplicados
        System.out.println("Táboa sen repetir: " + Arrays.toString(numerosUnicos));
    }
}
