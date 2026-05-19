import java.util.Scanner;

public class FundirAFrota {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int TAMAÑO = 4;

        // 1. Creamos os dous taboleiros
        char[][] taboleiroReal = new char[TAMAÑO][TAMAÑO];
        char[][] taboleiroVisible = new char[TAMAÑO][TAMAÑO];

        // Inicializamos ambos taboleiros cheos de auga ('~')
        for (int i = 0; i < TAMAÑO; i++) {
            for (int j = 0; j < TAMAÑO; j++) {
                taboleiroReal[i][j] = '~';
                taboleiroVisible[i][j] = '~';
            }
        }

        // 2. Colocamos 3 barcos de forma ALEATORIA no taboleiro real
        int barcosColocados = 0;
        int totalBarcos = 3; // Podes cambiar este número se queres máis barcos

        while (barcosColocados < totalBarcos) {
            // Xera un número aleatorio entre 0 e 3
            int filaAleatoria = (int) (Math.random() * TAMAÑO);
            int colAleatoria = (int) (Math.random() * TAMAÑO);

            // Se esa casiña estaba baleira, colocamos o barco
            if (taboleiroReal[filaAleatoria][colAleatoria] == '~') {
                taboleiroReal[filaAleatoria][colAleatoria] = 'B';
                barcosColocados++;
            }
        }

        int barcosRestantes = totalBarcos;
        System.out.println("=========================================");
        System.out.println(" ¡BENVIDO A FUNDIR A FROTA! (Tamaño 4x4) ");
        System.out.println("=========================================");
        System.out.println("Hai " + totalBarcos + " barcos ocultos no mar. ¡A por eles!");

        // 3. BUCLE PRINCIPAL DO XOGO
        while (barcosRestantes > 0) {

            // Mostramos o taboleiro visible actual ao usuario
            System.out.println("\n  Taboleiro Actual:");
            System.out.println("   0  1  2  3"); // Cabeceira de columnas
            for (int i = 0; i < TAMAÑO; i++) {
                System.out.print(i + "  "); // Número de fila
                for (int j = 0; j < TAMAÑO; j++) {
                    System.out.print(taboleiroVisible[i][j] + "  ");
                }
                System.out.println();
            }

            // Pedimos coordenadas de disparo
            System.out.print("\nIntroduce FILA do disparo (0-3): ");
            int f = teclado.nextInt();
            System.out.print("Introduce COLUMNA do disparo (0-3): ");
            int c = teclado.nextInt();

            // Validamos que o disparo estea dentro do mar
            if (f < 0 || f >= TAMAÑO || c < 0 || c >= TAMAÑO) {
                System.out.println("❌ Coordenadas fóra de rango. Apunta mellor ao mapa.");
                continue; // Salta o resto do bucle e volve pedir coordenadas
            }

            // Comprobamos se xa disparou aí antes
            if (taboleiroVisible[f][c] == 'X' || taboleiroVisible[f][c] == 'O') {
                System.out.println("⚠️ Xa disparaches nesa posición. Non gastes munición!");
                continue;
            }

            // 4. LOGICA DO DISPARO
            if (taboleiroReal[f][c] == 'B') {
                System.out.println("💥 ¡TOCADO! Destruíches un barco.");
                taboleiroVisible[f][c] = 'X'; // Actualizamos o que ve o usuario
                barcosRestantes--;            // Queda un barco menos
                System.out.println("Quedan " + barcosRestantes + " barcos en pé.");
            } else {
                System.out.println("💧 ¡AUGA! Non había nada aí.");
                taboleiroVisible[f][c] = 'O'; // Actualizamos con auga fallada
            }
        }

        // 5. CONDICIÓN DE FIN DE XOGO
        System.out.println("\n🏆 ¡VICTORIA TOTAL! Conseguiches fundir toda a frota inimiga.");
        System.out.println("=== FIN DO XOGO ===");
        teclado.close();
    }
}