import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Exercicio2e3 {
    public static void main(String[] args) {
        List<Integer> coleccion = new ArrayList<>();
        Random rand = new Random();

        // Inserir 100 números entre 1 e 10
        for (int i = 0; i < 100; i++) {
            coleccion.add(rand.nextInt(10) + 1);
        }

        System.out.println("Antes da eliminación:\n" + coleccion);

        // --- EXERCICIO 2: Eliminación usando removeIf (máis limpo en Java moderno) ---
        // coleccion.removeIf(num -> num == 5 || num == 7);

        // --- EXERCICIO 3: Eliminación obrigatoria cun Iterator ---
        Iterator<Integer> it = coleccion.iterator();
        while (it.hasNext()) {
            int num = it.next();
            if (num == 5 || num == 7) {
                it.remove(); // Elimina o elemento actual de forma segura
            }
        }

        System.out.println("\nDespois da eliminación (sen 5 nin 7):\n" + coleccion);
    }
}