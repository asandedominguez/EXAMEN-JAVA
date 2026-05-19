import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        List<Integer> lista = new ArrayList<>();

        System.out.println("Introduce números enteiros (-1 para rematar):");
        while (true) {
            int num = teclado.nextInt();
            if (num == -1) break;
            if (num >= 0) lista.add(num);
        }

        System.out.println("\nElementos en índices pares multiplicados por 100:");
        for (int i = 0; i < lista.size(); i++) {
            if (i % 2 == 0) { // O índice é par (0, 2, 4...)
                // CORRECCIÓN: Cambiamos lista[i] por lista.get(i)
                System.out.println("Índice [" + i + "]: " + (lista.get(i) * 100));
            }
        }
    }
}