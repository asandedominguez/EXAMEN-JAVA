import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        List<Double> positivos = new ArrayList<>();
        List<Double> negativos = new ArrayList<>();

        System.out.println("Introduce números reais (0 para rematar):");
        while (true) {
            double num = teclado.nextDouble();
            if (num == 0) break;

            if (num > 0) positivos.add(num);
            else negativos.add(num);
        }

        // Mostrar iniciais e sumas
        mostrarDatos(positivos, negativos);

        // Filtrar elementos (>10 e <-10 fóra)
        positivos.removeIf(n -> n > 10);
        negativos.removeIf(n -> n < -10);

        System.out.println("\n--- TRAS ELIMINAR MAIORES DE 10 E MENORES DE -10 ---");
        mostrarDatos(positivos, negativos);
    }

    private static void mostrarDatos(List<Double> pos, List<Double> neg) {
        double sumaPos = pos.stream().mapToDouble(Double::doubleValue).sum();
        double sumaNeg = neg.stream().mapToDouble(Double::doubleValue).sum();

        System.out.println("Positivos: " + pos + " | Suma: " + sumaPos);
        System.out.println("Negativos: " + neg + " | Suma: " + sumaNeg);
    }
}
