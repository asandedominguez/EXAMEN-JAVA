import java.util.*;

public class Exercicio6 {
    public static void main(String[] args) {
        // Creamos unha lista de proba inmutable con elementos repetidos para o exercicio
        List<Integer> lista = Arrays.asList(1, 2, 2, 3, 4, 4, 4, 5, 6, 7, 7, 8);
        System.out.println("Lista inicial: " + lista);

        // Conxunto para almacenar tódolos números da lista eliminando os duplicados automáticamente
        Set<Integer> senRepetir = new HashSet<>();
        // Conxunto para gardar unicamente aqueles números que aparecen máis dunha vez
        Set<Integer> repetidos = new HashSet<>();
        // Conxunto final para illar os números que aparecen exactamente unha única vez
        Set<Integer> unicos = new HashSet<>();

        // Percorremos a lista orixinal elemento por elemento usando un bucle for-each
        for (Integer num : lista) {
            // LÓXICA CLAVE: O método .add() dun Set intenta gardar o elemento.
            // Se o número NON existía, gárdao e devolve 'true' (polo que o ! o converte en false e non entra no if).
            // Se o número XA existía, non o volve gardar e devolve 'false' (polo que o ! o converte en true).
            if (!senRepetir.add(num)) {
                repetidos.add(num); // Se entramos aquí, significa que o número está duplicado na lista
            }
        }

        // OPERACIÓNS COAS PROPIEDADES DE CONXUNTOS (Álxebra de conxuntos):
        // 1. Copiamos todos os elementos limpos de 'senRepetir' cara ao conxunto 'unicos'
        unicos.addAll(senRepetir);
        
        // 2. Operación Diferenza: Eliminamos de 'unicos' todos os elementos que están en 'repetidos'.
        // Deste xeito, só quedan os números que apareceron unha soa vez na lista orixinal.
        unicos.removeAll(repetidos);

        // Amosamos os resultados finais obtidos polas diferentes clasificacións
        System.out.println("Sen repetir: " + senRepetir); // Contén todos sen duplicados [1, 2, 3, 4, 5, 6, 7, 8]
        System.out.println("Repetidos:   " + repetidos);   // Contén só os que tiñan copias [2, 4, 7]
        System.out.println("Únicos:      " + unicos);      // Contén os estritos [1, 3, 5, 6, 8]
    }
}
