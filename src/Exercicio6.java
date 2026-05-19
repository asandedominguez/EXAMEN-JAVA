import java.util.*;

public class Exercicio6 {
    public static void main(String[] args) {
        // Lista inicial de proba entre 1 e 10
        List<Integer> lista = Arrays.asList(1, 2, 2, 3, 4, 4, 4, 5, 6, 7, 7, 8);
        System.out.println("Lista inicial: " + lista);

        Set<Integer> senRepetir = new HashSet<>();
        Set<Integer> repetidos = new HashSet<>();
        Set<Integer> unicos = new HashSet<>();

        for (Integer num : lista) {
            // Se non se pode engadir, é porque xa existía, logo está repetido
            if (!senRepetir.add(num)) {
                repetidos.add(num);
            }
        }

        // Os únicos son todos os elementos menos os que sabemos que se repiten
        unicos.addAll(senRepetir);
        unicos.removeAll(repetidos);

        System.out.println("Sen repetir: " + senRepetir);
        System.out.println("Repetidos:   " + repetidos);
        System.out.println("Únicos:      " + unicos);
    }
}