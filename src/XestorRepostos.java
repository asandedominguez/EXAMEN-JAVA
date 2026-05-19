import java.io.*;
import java.util.*;

public class XestorRepostos {
    private static final String FICHEIRO = "existencias.txt";
    private static Map<String, Integer> inventario = new HashMap<>();

    public static void main(String[] args) {
        cargarDatos();
        Scanner teclado = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n1. Alta produto\n2. Baixa produto\n3. Actualizar cantidade\n4. Visualizar stock\n5. Saír");
            System.out.print("Opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine(); // Limpar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Código produto: ");
                    String cod = teclado.nextLine();
                    inventario.putIfAbsent(cod, 0);
                    break;
                case 2:
                    System.out.print("Código a eliminar: ");
                    inventario.remove(teclado.nextLine());
                    break;
                case 3:
                    System.out.print("Código: ");
                    String c = teclado.nextLine();
                    if (inventario.containsKey(c)) {
                        System.out.print("Nova cantidade: ");
                        inventario.put(c, teclado.nextInt());
                    } else System.out.println("Produto non existe.");
                    break;
                case 4:
                    inventario.forEach((k, v) -> System.out.println("Prod: " + k + " | Cantidade: " + v));
                    break;
                case 5:
                    gardarDatos();
                    break;
            }
        } while (opcion != 5);
    }

    private static void cargarDatos() {
        try (BufferedReader br = new BufferedReader(new FileReader(FICHEIRO))) {
            String liña;
            while ((liña = br.readLine()) != null) {
                String[] partes = liña.split(";");
                inventario.put(partes[0], Integer.parseInt(partes[1]));
            }
        } catch (IOException ignored) {}
    }

    private static void gardarDatos() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FICHEIRO))) {
            inventario.forEach((k, v) -> pw.println(k + ";" + v));
        } catch (IOException e) {
            System.out.println("Erro ao gardar.");
        }
    }
}