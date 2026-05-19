import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Exercicio2e3 {
    public static void main(String[] args) {
        // Instanciamos unha lista dinámica (ArrayList) para almacenar obxectos de tipo Integer
        List<Integer> coleccion = new ArrayList<>();
        // Creamos un obxecto da clase Random para poder xerar números aleatorios
        Random rand = new Random();

        // Bucle for que se repite 100 veces para encher a lista
        for (int i = 0; i < 100; i++) {
            // rand.nextInt(10) devolve un número entre 0 e 9. Ao sumarlle 1, conseguimos o rango de 1 a 10
            coleccion.add(rand.nextInt(10) + 1);
        }

        // Amósase o contido completo da lista orixinal por consola
        System.out.println("Antes da eliminación:\n" + coleccion);

        // --- EXERCICIO 2: Eliminación usando removeIf (máis limpo en Java moderno) ---
        // Esta liña (comentada) faría o mesmo que o Iterator usando unha expresión lambda:
        // coleccion.removeIf(num -> num == 5 || num == 7);

        // --- EXERCICIO 3: Eliminación obrigatoria cun Iterator ---
        // Solicitamos o Iterator da colección para podela percorrer e modificar de xeito seguro
        Iterator<Integer> it = coleccion.iterator();
        
        // O bucle mentres (while) continuará mentres queden elementos por analizar na lista
        while (it.hasNext()) {
            // it.next() avanza a posición do punteiro e extrae o elemento actual da lista
            int num = it.next();
            
            // Comprobamos se o número actual coincide con calquera dos dous criterios de borrado (5 ou 7)
            if (num == 5 || num == 7) {
                // Borra o último elemento devolto por next() sen provocar un erro de concorrencia
                it.remove(); 
            }
        }

        // Amósase a lista final para verificar que se eliminaron correctamente tódolos 5 e 7
        System.out.println("\nDespois da eliminación (sen 5 nin 7):\n" + coleccion);
    }
}
