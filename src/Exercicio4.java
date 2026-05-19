import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        // Inicializa o Scanner para ler os números decimais dende a consola
        Scanner teclado = new Scanner(System.in);
        
        // Creamos dúas listas dinámicas independentes para separar os números segundo o seu signo
        List<Double> positivos = new ArrayList<>();
        List<Double> negativos = new ArrayList<>();

        System.out.println("Introduce números reais (0 para rematar):");
        
        // Bucle infinito controlado por unha condición de parada (break) interna
        while (true) {
            double num = teclado.nextDouble(); // Le o seguinte número real introducido
            
            // Condición de saída: se o usuario introduce exactamente 0, rompe o bucle inmediatamente
            if (num == 0) break;

            // Clasificación: se o número é maior que cero vai a positivos, se non (menor que cero), a negativos
            if (num > 0) positivos.add(num);
            else negativos.add(num);
        }

        // Chamamos á función auxiliar para amosar as listas iniciais e as súas respectivas sumas
        mostrarDatos(positivos, negativos);

        // FILTRADO CON EXPRESIONS LAMBDA:
        // Elimina da lista de positivos calquera número que sexa estrictamente maior que 10
        positivos.removeIf(n -> n > 10);
        
        // Elimina da lista de negativos calquera número que sexa estrictamente menor que -10 (máis negativo)
        negativos.removeIf(n -> n < -10);

        System.out.println("\n--- TRAS ELIMINAR MAIORES DE 10 E MENORES DE -10 ---");
        
        // Volvemos amosar os datos actualizados para ver os novos totais e elementos filtrados
        mostrarDatos(positivos, negativos);
    }

    /**
     * Método auxiliar privado que calcula de xeito eficiente a suma total de cada lista
     * e imprime os resultados formateados por pantalla.
     * 
     * @param pos Lista que contén os números reais positivos.
     * @param neg Lista que contén os números reais negativos.
     */
    private static void mostrarDatos(List<Double> pos, List<Double> neg) {
        // .stream() crea un fluxo cos datos da lista
        // .mapToDouble unboxing automático de obxectos Double a tipos primitivos double
        // .sum() calcula de forma nativa e directa a suma acumulada de tódolos elementos
        double sumaPos = pos.stream().mapToDouble(Double::doubleValue).sum();
        double sumaNeg = neg.stream().mapToDouble(Double::doubleValue).sum();

        // Imprime por consola a lista de elementos xunto co resultado do seu sumatorio
        System.out.println("Positivos: " + pos + " | Suma: " + sumaPos);
        System.out.println("Negativos: " + neg + " | Suma: " + sumaNeg);
    }
}

