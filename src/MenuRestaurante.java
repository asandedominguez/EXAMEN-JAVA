import java.util.Arrays;
import java.util.Scanner;

public class MenuRestaurante {

    // 1. FUNCIÓN QUE AMOSA O MENÚ AOS COMENSAIS
    public static void mostrarMenu(String[][] menu) {
        String[] categorias = {"PRIMEIROS PRATOS", "SEGUNDOS PRATOS", "SOBREMESAS"};

        System.out.println("\n=================================");
        System.out.println("       CARTA DO RESTAURANTE      ");
        System.out.println("=================================");

        // Percorremos as categorías (filas)
        for (int i = 0; i < menu.length; i++) {
            System.out.println("\n--- " + categorias[i] + " ---");

            // Percorremos os pratos de cada categoría (columnas)
            for (int j = 0; j < menu[i].length; j++) {
                // Amosamos un número identificador [0, 1, 2...] para que sexa fácil elixir
                System.out.println("[" + j + "] " + menu[i][j]);
            }
        }
        System.out.println("=================================\n");
    }

    // 2. FUNCIÓN QUE PERMITE FACER O PEDIDO
    // Devolve un array de 3 elementos: [primeiro, segundo, sobremesa]
    public static String[] facerPedido(String[][] menu) {
        Scanner teclado = new Scanner(System.in);
        String[] pedido = new String[3]; // Array onde gardaremos a elección do cliente

        System.out.println("--- POR FAVOR, SELECCIONA O TEU MENÚ ---");

        // Elixir Primeiro Prato (Fila 0)
        System.out.print("Introduce o número do PRIMEIRO prato: ");
        int primeiro = teclado.nextInt();
        pedido[0] = menu[0][primeiro]; // Gardamos o prato elixido

        // Elixir Segundo Prato (Fila 1)
        System.out.print("Introduce o número do SEGUNDO prato: ");
        int segundo = teclado.nextInt();
        pedido[1] = menu[1][segundo];

        // Elixir Sobremesa (Fila 2)
        System.out.print("Introduce o número da SOBREMESA: ");
        int sobremesa = teclado.nextInt();
        pedido[2] = menu[2][sobremesa];

        return pedido; // Devolvemos o array co menú completo do cliente
    }

    public static void main(String[] args) {
        // Deseñamos o menú: 3 filas (categorías) con 3 pratos en cada unha
        String[][] menuDoDia = {
                {"Ensalada César", "Crema de calabacín", "Sopa de peixe"}, // Fila 0
                {"Bilete con patacas", "Merluza á galega", "Lasanha vexetal"},// Fila 1
                {"Flan casero", "Tarta de mazá", "Xeado de vainilla"}      // Fila 2
        };

        // Chamamos á primeira función para amosar a carta
        mostrarMenu(menuDoDia);

        // Chamamos á segunda función para que o usuario escolla e gardamos o resultado
        String[] oMeuPedido = facerPedido(menuDoDia);

        // Amosamos o resultado do pedido que devolveu a función
        System.out.println("\n=================================");
        System.out.println("      O TEU PEDIDO REGISTRADO    ");
        System.out.println("=================================");
        System.out.println("• Primeiro: " + oMeuPedido[0]);
        System.out.println("• Segundo:  " + oMeuPedido[1]);
        System.out.println("• Sobremesa: " + oMeuPedido[2]);
        System.out.println("=================================");

        // Tamén podemos ver o array directamente en formato texto
        System.out.println("Array de retorno: " + Arrays.toString(oMeuPedido));
    }
}