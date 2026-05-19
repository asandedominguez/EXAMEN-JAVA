import java.util.Scanner;

public class MapaXogo {
    // Atributo co contido real do mapa
    private String[][] mapa;

    // Construtor para inicializar o noso mapa de 3x3
    public MapaXogo(String[][] mapa) {
        this.mapa = mapa;
    }

    // Método para xogar unha quenda
    public boolean explorarHabitacion(int fila, int columna) {
        // 1. Validamos que as coordenadas introducidas existan no mapa 3x3
        if (fila < 0 || fila >= 3 || columna < 0 || columna >= 3) {
            System.out.println("❌ Coordenadas fóra do mapa! Elixe números entre 0 e 2.");
            return false; // O xogo continúa
        }

        // 2. Descubrimos o que hai nesa casiña
        String contido = mapa[fila][columna];
        System.out.println("\n------------------------------------------------");
        System.out.println("Entras na habitación [" + fila + "][" + columna + "]...");
        System.out.println("Resulta ser: ¡" + contido + "!");
        System.out.println("------------------------------------------------\n");

        // 3. Condición de vitoria
        if (contido.equalsIgnoreCase("Tesouro")) {
            System.out.println("🏆 ¡PARABÉNS! Atopaches o Tesouro Oculto. ¡Gañaches a partida!");
            return true; // Devolvemos true para indicar que o xogo rematou
        }

        // Se cae nunha trampa, podes engadir ambientación se queres
        if (contido.equalsIgnoreCase("Trampa")) {
            System.out.println("💥 ¡Zas! Activaches unha trampa de frechas, pero logras sobrevivir. ¡Segue buscando!");
        }

        return false; // O xogo continúa porque aínda non atopou o tesouro
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Deseñamos o mapa oculto de 3x3
        String[][] deseñoMapa = {
                {"Entrada", "Pasillo vello", "Trampa"},
                {"Monstro",  "Biblioteca",   "Cárcere"},
                {"Foso",     "Tesouro",      "Armería"}
        };

        // Instanciamos o xogo
        MapaXogo partida = new MapaXogo(deseñoMapa);

        System.out.println("===============================================");
        System.out.println(" ¡BENVIDO Á MAZMORRA OCULTA DE 3X3! ");
        System.out.println("===============================================");
        System.out.println("Atopa o 'Tesouro' para gañar. As coordenadas van do 0 ao 2.");

        boolean xogoRematado = false;

        // Bucle principal do xogo: repítese ata que a condición de vitoria sexa certa
        while (!xogoRematado) {
            System.out.print("Introduce a FILA (0, 1, 2): ");
            int f = teclado.nextInt();

            System.out.print("Introduce a COLUMNA (0, 1, 2): ");
            int c = teclado.nextInt();

            // Executamos a quenda e gardamos se gañou ou non
            xogoRematado = partida.explorarHabitacion(f, c);

            if (!xogoRematado) {
                System.out.println("O mapa segue estendéndose ante ti... Proba outra habitación.\n");
            }
        }

        System.out.println("=== FIN DO XOGO ===");
        teclado.close();
    }
}
