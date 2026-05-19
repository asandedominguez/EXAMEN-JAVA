import java.util.Scanner;

public class MapaXogo {
    // Atributo privado que garda a matriz bidimensional co contido real do mapa
    private String[][] mapa;

    /**
     * Construtor da clase MapaXogo.
     * Inicializa o atributo 'mapa' co deseño estruturado que se lle pase por parámetro.
     */
    public MapaXogo(String[][] mapa) {
        this.mapa = mapa;
    }

    /**
     * Método para procesar a quenda de exploración dunha habitación.
     * 
     * @param fila Índice da fila seleccionada polo xogador.
     * @param columna Índice da columna seleccionada polo xogador.
     * @return true se o xogador atopa o tesouro (fin do xogo), false en caso contrario.
     */
    public boolean explorarHabitacion(int fila, int columna) {
        // 1. VALIDACIÓN DE SEGURIDADE: Comprobamos que as coordenadas existan dentro dos límites (0 a 2)
        if (fila < 0 || fila >= 3 || columna < 0 || columna >= 3) {
            System.out.println("❌ Coordenadas fóra do mapa! Elixe números entre 0 e 2.");
            return false; // Devolve false para que o bucle principal non remate e pida outra posición
        }

        // 2. Descubrimos e extraemos o texto oculto nesa casiña da matriz
        String contido = mapa[fila][columna];
        System.out.println("\n------------------------------------------------");
        System.out.println("Entras na habitación [" + fila + "][" + columna + "]...");
        System.out.println("Resulta ser: ¡" + contido + "!");
        System.out.println("------------------------------------------------\n");

        // 3. CONDICIÓN DE VITORIA: Se o contido coincide con "Tesouro" (sen importar maiúsculas)
        if (contido.equalsIgnoreCase("Tesouro")) {
            System.out.println("🏆 ¡PARABÉNS! Atopaches o Tesouro Oculto. ¡Gañaches a partida!");
            return true; // Devolve true para indicar que a partida finalizou con éxito
        }

        // Ambientación extra se o xogador cae na trampa
        if (contido.equalsIgnoreCase("Trampa")) {
            System.out.println("💥 ¡Zas! Activaches unha trampa de frechas, pero logras sobrevivir. ¡Segue buscando!");
        }

        return false; // O xogo continúa porque a habitación non tiña o tesouro
    }

    public static void main(String[] args) {
        // Inicializa o Scanner para ler as coordenadas do usuario dende o teclado
        Scanner teclado = new Scanner(System.in);

        // Deseñamos a matriz do mapa oculto de 3 filas por 3 columnas con obxectos e perigos
        String[][] deseñoMapa = {
                {"Entrada", "Pasillo vello", "Trampa"},
                {"Monstro",  "Biblioteca",   "Cárcere"},
                {"Foso",     "Tesouro",      "Armería"}
        };

        // Instanciamos un novo obxecto do xogo pasándolle a nosa matriz deseñada
        MapaXogo partida = new MapaXogo(deseñoMapa);

        System.out.println("===============================================");
        System.out.println(" ¡BENVIDO Á MAZMORRA OCULTA DE 3X3! ");
        System.out.println("===============================================");
        System.out.println("Atopa o 'Tesouro' para gañar. As coordenadas van do 0 ao 2.");

        // Variable 'flag' ou bandeira para controlar o estado e a finalización da partida
        boolean xogoRematado = false;

        // BUCLE PRINCIPAL DO XOGO: Repítese ciclicamente mentres 'xogoRematado' sexa falso
        while (!xogoRematado) {
            System.out.print("Introduce a FILA (0, 1, 2): ");
            int f = teclado.nextInt(); // Le a fila introducida

            System.out.print("Introduce a COLUMNA (0, 1, 2): ");
            int c = teclado.nextInt(); // Le a columna introducida

            // Executamos o método de exploración e actualizamos o estado da bandeira co que devolva
            xogoRematado = partida.explorarHabitacion(f, c);

            // Se tras o disparo aínda non se atopou o tesouro, amosamos unha mensaxe de ánimo
            if (!xogoRematado) {
                System.out.println("O mapa segue estendéndose ante ti... Proba outra habitación.\n");
            }
        }

        System.out.println("=== FIN DO XOGO ===");
        teclado.close(); // Pechamos o recurso por seguridade e boas prácticas
    }
}
