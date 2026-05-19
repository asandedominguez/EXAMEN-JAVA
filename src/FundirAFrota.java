import java.util.Scanner;

public class FundirAFrota {

    public static void main(String[] args) {
        // Inicializa o Scanner para recoller as coordenadas introducidas polo xogador
        Scanner teclado = new Scanner(System.in);
        // Define o tamaño constante da matriz cadrada (4x4)
        int TAMAÑO = 4;

        // 1. Creamos os dous taboleiros necesarios
        // taboleiroReal: Almacena en segredo onde están os barcos ('B') e a auga ('~')
        char[][] taboleiroReal = new char[TAMAÑO][TAMAÑO];
        // taboleiroVisible: O que ve o xogador na pantalla cos seus acertos ('X') e fallos ('O')
        char[][] taboleiroVisible = new char[TAMAÑO][TAMAÑO];

        // Inicializamos ambos taboleiros cheos de auga ('~') usando bucles aniñados
        for (int i = 0; i < TAMAÑO; i++) {
            for (int j = 0; j < TAMAÑO; j++) {
                taboleiroReal[i][j] = '~';
                taboleiroVisible[i][j] = '~';
            }
        }

        // 2. Colocamos 3 barcos de forma ALEATORIA no taboleiro real
        int barcosColocados = 0;
        int totalBarcos = 3; // Podes cambiar este número se queres máis barcos no mapa

        // O bucle execútase ata lograr colocar o número exacto de barcos requirido
        while (barcosColocados < totalBarcos) {
            // Math.random() * TAMAÑO xera un decimal entre 0.0 e 3.99. Ao aplicar o cast a (int),
            // trúncase devolvendo un número enteiro aleatorio entre 0 e 3 (índices válidos)
            int filaAleatoria = (int) (Math.random() * TAMAÑO);
            int colAleatoria = (int) (Math.random() * TAMAÑO);

            // Control de solapamento: só colocamos o barco se a casiña seleccionada tiña auga
            if (taboleiroReal[filaAleatoria][colAleatoria] == '~') {
                taboleiroReal[filaAleatoria][colAleatoria] = 'B'; // Asignamos un barco
                barcosColocados++; // Incrementamos o contador de barcos situados con éxito
            }
        }

        int barcosRestantes = totalBarcos; // Contador para controlar cantos barcos quedan vivos
        System.out.println("=========================================");
        System.out.println(" ¡BENVIDO A FUNDIR A FROTA! (Tamaño 4x4) ");
        System.out.println("=========================================");
        System.out.println("Hai " + totalBarcos + " barcos ocultos no mar. ¡A por eles!");

        // 3. BUCLE PRINCIPAL DO XOGO: Repítese mentres queden barcos sen afundir
        while (barcosRestantes > 0) {

            // Mostramos o taboleiro visible actual ao usuario na pantalla
            System.out.println("\n  Taboleiro Actual:");
            System.out.println("   0  1  2  3"); // Imprime a cabeceira visual co número das columnas
            for (int i = 0; i < TAMAÑO; i++) {
                System.out.print(i + "  "); // Imprime o número da fila actual na marxe esquerda
                for (int j = 0; j < TAMAÑO; j++) {
                    // Imprime o carácter que ve o usuario (auga, impacto ou fallo) separado por espazos
                    System.out.print(taboleiroVisible[i][j] + "  ");
                }
                System.out.println(); // Salto de liña ao rematar cada fila do mapa
            }

            // Pedimos as coordenadas do disparo ao xogador
            System.out.print("\nIntroduce FILA do disparo (0-3): ");
            int f = teclado.nextInt();
            System.out.print("Introduce COLUMNA do disparo (0-3): ");
            int c = teclado.nextInt();

            // VALIDACIÓN 1: Comprobamos que o disparo estea dentro das dimensións da matriz (0 a 3)
            if (f < 0 || f >= TAMAÑO || c < 0 || c >= TAMAÑO) {
                System.out.println("❌ Coordenadas fóra de rango. Apunta mellor ao mapa.");
                continue; // Ignora o resto do código e volve ao inicio do bucle while para repetir o tiro
            }

            // VALIDACIÓN 2: Comprobamos se o xogador xa disparara nesa mesma posición previamente
            if (taboleiroVisible[f][c] == 'X' || taboleiroVisible[f][c] == 'O') {
                System.out.println("⚠️ Xa disparaches nesa posição. Non gastes munición!");
                continue; // Salta o tiro e volve pedir coordenadas
            }

            // 4. LÓXICA DO DISPARO
            // Comprobamos no taboleiro secreto (real) se nesa coordenada había un barco
            if (taboleiroReal[f][c] == 'B') {
                System.out.println("💥 ¡TOCADO! Destruíches un barco.");
                taboleiroVisible[f][c] = 'X'; // Marcamos con 'X' o taboleiro visible do usuario
                barcosRestantes--;            // Decrementamos un barco na conta global
                System.out.println("Quedan " + barcosRestantes + " barcos en pé.");
            } else {
                System.out.println("💧 ¡AUGA! Non había nada aí.");
                taboleiroVisible[f][c] = 'O'; // Marcamos cunha 'O' para indicar auga fallada
            }
        }

        // 5. CONDICIÓN DE FIN DE XOGO (Execútase cando barcosRestantes chega a 0)
        System.out.println("\n🏆 ¡VICTORIA TOTAL! Conseguiches fundir toda a frota inimiga.");
        System.out.println("=== FIN DO XOGO ===");
        teclado.close(); // Pechamos o recurso Scanner por boas prácticas
    }
}
