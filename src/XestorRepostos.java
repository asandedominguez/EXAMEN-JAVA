import java.io.*;
import java.util.*;

public class XestorRepostos {
    // Constante co nome do ficheiro de texto onde se persistirán os datos
    private static final String FICHEIRO = "existencias.txt";
    // Mapa estático (HashMap) que asocia un código de produto (String) co seu stock (Integer)
    private static Map<String, Integer> inventario = new HashMap<>();

    public static void main(String[] args) {
        // Carga automaticamente os datos gardados no ficheiro antes de iniciar o menú
        cargarDatos();
        Scanner teclado = new Scanner(System.in);
        int opcion;

        // Bucle do-while para manter o programa en execución ata que se escolla saír
        do {
            System.out.println("\n1. Alta produto\n2. Baixa produto\n3. Actualizar cantidade\n4. Visualizar stock\n5. Saír");
            System.out.print("Opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine(); // Limpar o salto de liña (\n) que queda no búfer do Scanner

            switch (opcion) {
                case 1: // ALTA: Engade un novo produto só se o seu código non existe de antes
                    System.out.print("Código produto: ");
                    String cod = teclado.nextLine();
                    // .putIfAbsent() comproba se a chave xa existe; se non está, créaa cun stock inicial de 0
                    inventario.putIfAbsent(cod, 0);
                    break;
                    
                case 2: // BAIXA: Elimina o produto do mapa a partir do seu código
                    System.out.print("Código a eliminar: ");
                    // .remove() elimina o par chave-valor correspondente á cadea introducida
                    inventario.remove(teclado.nextLine());
                    break;
                    
                case 3: // ACTUALIZAR: Modifica o stock dun produto existente
                    System.out.print("Código: ");
                    String c = teclado.nextLine();
                    // .containsKey() valida que o produto estea rexistrado no inventario para poder modificalo
                    if (inventario.containsKey(c)) {
                        System.out.print("Nova cantidade: ");
                        // .put() sobrescribe o valor anterior coa nova cantidade introducida
                        inventario.put(c, teclado.nextInt());
                    } else {
                        System.out.println("Produto non existe.");
                    }
                    break;
                    
                case 4: // VISUALIZAR: Percorre e amosa todo o stock actual
                    // .forEach() emprega unha expresión lambda con dúas variables (k = clave, v = valor) para imprimir
                    inventario.forEach((k, v) -> System.out.println("Prod: " + k + " | Cantidade: " + v));
                    break;
                    
                case 5: // SAÍR: Garda os datos en disco xusto antes de pechar o programa
                    gardarDatos();
                    break;
            }
        } while (opcion != 5); // O bucle remata cando a opción é igual a 5
    }

    /**
     * Método privado que le o ficheiro de texto liña por liña para reconstruír o inventario.
     */
    private static void cargarDatos() {
        // Bloque try-with-resources que abre o BufferedReader e garanta o seu peche automático
        try (BufferedReader br = new BufferedReader(new FileReader(FICHEIRO))) {
            String liña;
            // O bucle le liña a liña ata chegar ao final do documento (null)
            while ((liña = br.readLine()) != null) {
                // .split(";") trocea a liña usando o punto e coma como separador (Ex: "PROD01;15")
                String[] partes = liña.split(";");
                // partes[0] contén o código e partes[1] contén a cantidade en texto, que pasamos a int con parseInt
                inventario.put(partes[0], Integer.parseInt(partes[1]));
            }
        } catch (IOException ignored) {
            // Ignórase a excepción de xeito intencionado se o ficheiro aínda non existe na primeira execución
        }
    }

    /**
     * Método privado que exporta e sobrescribe o contido do HashMap cara ao ficheiro de texto.
     */
    private static void gardarDatos() {
        // Abre un PrintWriter sobre un FileWriter para escribir texto de xeito sinxelo e directo
        try (PrintWriter pw = new PrintWriter(new FileWriter(FICHEIRO))) {
            // Percorremos o inventario e imprimimos cada par clave-valor formatado con punto e coma
            inventario.forEach((k, v) -> pw.println(k + ";" + v));
            System.out.println("Datos gardados con éxito en " + FICHEIRO);
        } catch (IOException e) {
            // Captura fallos de escritura en disco (por exemplo, falta de permisos)
            System.out.println("Erro ao gardar: " + e.getMessage());
        }
    }
}
