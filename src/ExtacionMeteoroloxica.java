import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExtacionMeteoroloxica {

    /**
     * Clase interna que representa un rexistro individual de temperatura.
     * Implementa 'Serializable' para poder gardar obxectos desta clase en ficheiros binarios.
     */
    static class Rexistro implements Serializable {
        // ID de versión para garantir a compatibilidade durante a deserialización
        private static final long serialVersionUID = 1L;
        double temperatura; // Almacena os graos ºC
        LocalTime hora;      // Almacena o momento exacto no que se tomou a medida

        /**
         * Construtor do rexistro.
         * Recibe a temperatura e asigna automaticamente a hora actual do sistema.
         * 
         * @param temperatura Valor decimal da temperatura en ºC.
         */
        public Rexistro(double temperatura) {
            this.temperatura = temperatura;
            this.hora = LocalTime.now(); // Captura a hora, minutos e segundos actuais
        }
    }

    public static void main(String[] args) {
        // Inicializa o Scanner para recoller as opcións e datos do usuario
        Scanner teclado = new Scanner(System.in);
        // Lista dinámica para acumular todos os rexistros meteorolóxicos do día
        List<Rexistro> datos = new ArrayList<>();
        int opcion; // Variable para controlar a selección do menú

        // Bucle do-while que garante que o menú se amose polo menos unha vez
        do {
            System.out.println("\n--- ESTACIÓN METEOROLÓXICA ---");
            System.out.println("1. Novo rexistro");
            System.out.println("2. Listar rexistros");
            System.out.println("3. Mostrar estatísticas");
            System.out.println("4. Saír");
            System.out.print("Elixe opción: ");
            opcion = teclado.nextInt(); // Le a opción escollida polo usuario

            // Estrutura condicional para executar a acción correspondente á opción
            switch (opcion) {
                case 1: // OPCIÓN 1: Engadir nova temperatura á lista
                    System.out.print("Introduce temperatura ºC: ");
                    // Le o decimal do teclado, crea un novo obxecto Rexistro e despois gárdao na lista
                    datos.add(new Rexistro(teclado.nextDouble()));
                    break;
                    
                case 2: // OPCIÓN 2: Percorrer e amosar tódolos rexistros acumulados
                    for (Rexistro r : datos) {
                        // Aplica un formato visual á hora (HH:mm:ss) e limita a temperatura a dous decimais (%.2f)
                        System.out.printf("Hora: %s -> %.2f ºC\n", 
                                r.hora.format(DateTimeFormatter.ofPattern("HH:mm:ss")), 
                                r.temperatura);
                    }
                    break;
                    
                case 3: // OPCIÓN 3: Calcular e imprimir as métricas analíticas
                    if (datos.isEmpty()) {
                        System.out.println("Non hai datos."); // Control se a lista aínda está baleira
                    } else {
                        // .mapToDouble() extrae as temperaturas illadas para operar directamente con elas
                        // .min(), .max() e .average() calculan os valores. Se fallan, utilízase .orElse(0) por seguridade
                        double min = datos.stream().mapToDouble(r -> r.temperatura).min().orElse(0);
                        double max = datos.stream().mapToDouble(r -> r.temperatura).max().orElse(0);
                        double pro = datos.stream().mapToDouble(r -> r.temperatura).average().orElse(0);
                        
                        // Imprime o resumo estatístico formateado
                        System.out.printf("Mínima: %.2fºC | Máxima: %.2fºC | Promedio: %.2fºC\n", min, max, pro);
                    }
                    break;
                    
                case 4: // OPCIÓN 4: Chamar ao método de gardado xusto antes de pechar o programa
                    gardarDatosIniciados(datos);
                    break;
            }
        } while (opcion != 4); // O bucle rompe e finaliza cando a opción escollida é 4
    }

    /**
     * Método privado que exporta a lista completa de rexistros a un ficheiro binario (.dat).
     * O nome do ficheiro calcúlase dinamicamente coa data actual do sistema.
     * 
     * @param datos A lista de rexistros que se vai a persistir.
     */
    private static void gardarDatosIniciados(List<Rexistro> datos) {
        // Obtén a data actual e dálle formato de cadea compacta (Exemplo: "20260519")
        String dataStr = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String nomeFicheiro = "rexistros" + dataStr + ".dat"; // Concatena para crear o nome final

        // Bloque try-with-resources: abre os fluxos de arquivos de xeito que se pechan sós automaticamente ao rematar
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeFicheiro))) {
            // Escribe a colección completa en disco grazas a que 'ArrayList' e 'Rexistro' son serializables
            oos.writeObject(datos);
            System.out.println("Datos gardados con éxito en " + nomeFicheiro);
        } catch (IOException e) {
            // Captura posibles fallos de entrada/saída (como falta de permisos de escritura)
            System.out.println("Erro ao gardar os datos: " + e.getMessage());
        }
    }
}
