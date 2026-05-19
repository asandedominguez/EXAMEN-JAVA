import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExtacionMeteoroloxica {

    // Clase interna para os datos
    static class Rexistro implements Serializable {
        private static final long serialVersionUID = 1L;
        double temperatura;
        LocalTime hora;

        public Rexistro(double temperatura) {
            this.temperatura = temperatura;
            this.hora = LocalTime.now();
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        List<Rexistro> datos = new ArrayList<>();
        int opcion;

        do {
            System.out.println("\n--- ESTACIÓN METEOROLÓXICA ---");
            System.out.println("1. Novo rexistro");
            System.out.println("2. Listar rexistros");
            System.out.println("3. Mostrar estatísticas");
            System.out.println("4. Saír");
            System.out.print("Elixe opción: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce temperatura ºC: ");
                    datos.add(new Rexistro(teclado.nextDouble()));
                    break;
                case 2:
                    for (Rexistro r : datos) {
                        System.out.printf("Hora: %s -> %.2f ºC\n", r.hora.format(DateTimeFormatter.ofPattern("HH:mm:ss")), r.temperatura);
                    }
                    break;
                case 3:
                    if (datos.isEmpty()) System.out.println("Non hai datos.");
                    else {
                        double min = datos.stream().mapToDouble(r -> r.temperatura).min().orElse(0);
                        double max = datos.stream().mapToDouble(r -> r.temperatura).max().orElse(0);
                        double pro = datos.stream().mapToDouble(r -> r.temperatura).average().orElse(0);
                        System.out.printf("Mínima: %.2fºC | Máxima: %.2fºC | Promedio: %.2fºC\n", min, max, pro);
                    }
                    break;
                case 4:
                    gardarDatosIniciados(datos);
                    break;
            }
        } while (opcion != 4);
    }

    private static void gardarDatosIniciados(List<Rexistro> datos) {
        String dataStr = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String nomeFicheiro = "rexistros" + dataStr + ".dat";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeFicheiro))) {
            oos.writeObject(datos);
            System.out.println("Datos gardados con éxito en " + nomeFicheiro);
        } catch (IOException e) {
            System.out.println("Erro ao gardar os datos: " + e.getMessage());
        }
    }
}