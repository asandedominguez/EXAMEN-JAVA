import java.util.Arrays;
import java.util.Scanner;

public class MenuRestaurante {

    /**
     * 1. FUNCIÓN QUE AMOSA O MENÚ AOS COMENSAIS
     * Percorre a matriz bidimensional para debuxar a carta estruturada por categorías.
     * 
     * @param menu Matriz de String que contén os pratos organizados por filas.
     */
    public static void mostrarMenu(String[][] menu) {
        // Array unidimensional para mapear visualmente o nome de cada fila (categoría)
        String[] categories = {"PRIMEIROS PRATOS", "SEGUNDOS PRATOS", "SOBREMESAS"};

        System.out.println("\n=================================");
        System.out.println("       CARTA DO RESTAURANTE      ");
        System.out.println("=================================");

        // Bucle externo: percorre as categorías (filas da matriz, de 0 a 2)
        for (int i = 0; i < menu.length; i++) {
            System.out.println("\n--- " + categories[i] + " ---");

            // Bucle interno: percorre os pratos dispoñibles en cada categoría (columnas)
            for (int j = 0; j < menu[i].length; j++) {
                // Amosamos o índice da columna [j] para que o cliente poida seleccionalo facilmente
                System.out.println("[" + j + "] " + menu[i][j]);
            }
        }
        System.out.println("=================================\n");
    }

    /**
     * 2. FUNCIÓN QUE PERMITE FACER O PEDIDO
     * Solicita os identificadores numéricos de cada prato e constrúe o menú elixido.
     * 
     * @param menu Matriz de String coa carta de pratos.
     * @return Un array unidimensional de 3 elementos: [primeiro, segundo, sobremesa].
     */
    public static String[] facerPedido(String[][] menu) {
        // Inicializa o Scanner local para ler as entradas numéricas do cliente dende o teclado
        Scanner teclado = new Scanner(System.in);
        // Instancia un array de tamaño 3 para almacenar de forma ordenada os tres pratos elixidos
        String[] pedido = new String[3]; 

        System.out.println("--- POR FAVOR, SELECCIONA O TEU MENÚ ---");

        // Elixir Primeiro Prato (Fila 0 da matriz de menú)
        System.out.print("Introduce o número do PRIMEIRO prato: ");
        int primeiro = teclado.nextInt();
        pedido[0] = menu[0][primeiro]; // Mapea a columna introducida na fila 0 e gárdaa no índice 0

        // Elixir Segundo Prato (Fila 1 da matriz de menú)
        System.out.print("Introduce o número do SEGUNDO prato: ");
        int segundo = teclado.nextInt();
        pedido[1] = menu[1][segundo];  // Mapea a columna introducida na fila 1 e gárdaa no índice 1

        // Elixir Sobremesa (Fila 2 da matriz de menú)
        System.out.print("Introduce o número da SOBREMESA: ");
        int sobremesa = teclado.nextInt();
        pedido[2] = menu[2][sobremesa]; // Mapea a columna introducida na fila 2 e gárdaa no índice 2

        return pedido; // Devolvemos o array co menú completo e pechado do cliente
    }

    public static void main(String[] args) {
        // Deseñamos a matriz do menú do día: 3 filas (categorías) con 3 columnas (pratos) en cada unha
        String[][] menuDoDia = {
                {"Ensalada César", "Crema de calabacín", "Sopa de peixe"}, // Fila 0: Primeiros
                {"Bilete con patacas", "Merluza á galega", "Lasanha vexetal"},// Fila 1: Segundos
                {"Flan casero", "Tarta de mazá", "Xeado de vainilla"}      // Fila 2: Sobremesas
        };

        // Chamamos á primeira función estática para imprimir a carta por consola
        mostrarMenu(menuDoDia);

        // Chamamos á segunda función para recoller a selección do usuario e capturamos o array retornado
        String[] oMeuPedido = facerPedido(menuDoDia);

        // Amosamos o recibo do pedido de xeito desglosado lendo os índices do array resultante
        System.out.println("\n=================================");
        System.out.println("      O TEU PEDIDO REGISTRADO    ");
        System.out.println("=================================");
        System.out.println("• Primeiro: " + oMeuPedido[0]);
        System.out.println("• Segundo:  " + oMeuPedido[1]);
        System.out.println("• Sobremesa: " + oMeuPedido[2]);
        System.out.println("=================================");

        // Imprime o array de retorno completo nun formato directo usando utilidades de Arrays
        System.out.println("Array de retorno: " + Arrays.toString(oMeuPedido));
    }
}
