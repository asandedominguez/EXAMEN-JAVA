import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        // Inicializa o Scanner para ler os números enteiros introducidos polo usuario dende a consola
        Scanner teclado = new Scanner(System.in);
        
        // Creamos unha lista dinámica (ArrayList) para gardar os números enteiros introducidos
        List<Integer> lista = new ArrayList<>();

        System.out.println("Introduce números enteiros (-1 para rematar):");
        
        // Bucle infinito que se executará continuamente ata que se force a súa saída
        while (true) {
            int num = teclado.nextInt(); // Le o seguinte número enteiro do teclado
            
            // Condición de parada: se o número introducido é -1, rompe o bucle de xeito inmediato
            if (num == -1) break;
            
            // Filtro de garda: só engade o número á lista se é positivo ou cero (evita outros negativos)
            if (num >= 0) lista.add(num);
        }

        System.out.println("\nElementos en índices pares multiplicados por 100:");
        
        // Bucle tradicional para percorrer a lista elemento por elemento usando un índice numérico
        for (int i = 0; i < lista.size(); i++) {
            // Comprobamos se a posición actual (o índice 'i') é par (o resto de dividilo entre 2 é cero)
            if (i % 2 == 0) { // O índice é par (0, 2, 4...)
                
                // NOTA DE CORRECCIÓN: En listas dinámicas non se usa corchetes como nos arrays (lista[i]),
                // senón que se emprega obrigatoriamente o método .get(i) para extraer o elemento.
                // Imprime a posición actual e o valor correspondente multiplicado por cen.
                System.out.println("Índice [" + i + "]: " + (lista.get(i) * 100));
            }
        }
    }
}
