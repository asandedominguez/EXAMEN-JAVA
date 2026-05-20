import java.util.Arrays;
import java.util.Scanner;

public class Ajenda {
    // Matriz de cadeas de texto (String) que almacenará a táboa do horario
    private String[][] tabla;

    // Construtor da clase que recebe unha matriz e inicializa o atributo 'tabla'
    public Ajenda(String[][] tabla){
        this.tabla = tabla;
    }

    // Método para amosar o horario por consola dun xeito visual e limpo
    public void amosarHorario() {
        // Array cos nomes dos días correspondentes a cada fila (índices 0 a 4)
        String[] dias = {"Luns", "Martes", "Mércores", "Xoves", "Venres"};

        // Imprime a cabeceira coas etiquetas das horas
        System.out.println("\n\t[H0]\t\t[H1]\t\t[H2]\t\t[H3]\t\t[H4]");
        System.out.println("---------------------------------------------------------------------------------");

        // Bucle externo: percorre cada fila da matriz (cada día da semana)
        for (int i = 0; i < tabla.length; i++) {
            // Imprime o índice e o nome do día correspondente
            System.out.print("[" + i + "] " + dias[i] + "\t");

            // Bucle interno: percorre cada columna da fila actual (cada hora do día)
            for (int j = 0; j < tabla[i].length; j++) {
                // Imprime a actividade da cela actual separada por tabuladores
                System.out.print(tabla[i][j] + "\t\t");
            }
            System.out.println(); // Salto de liña ao rematar de imprimir un día completo
        }
        System.out.println("---------------------------------------------------------------------------------\n");
    }

    // MÉTODO B: Cambiar unha actividade por outra sen importar o que conteña a cela
    public void cambiarActividade(int dia, int hora, String novaActividade) {
        // Validación de seguridade: comproba que os índices non se saian dos límites da matriz
        if (dia >= 0 && dia < tabla.length && hora >= 0 && hora < tabla[0].length) {
            String antiga = tabla[dia][hora]; // Garda o nome da actividade que imos borrar
            tabla[dia][hora] = novaActividade; // Asigna a nova actividade na posición indicada
            System.out.println("¡Cambiado! Substituímos '" + antiga + "' por '" + novaActividade + "'.");
        } else {
            // Execútase se o usuario introduce números fóra de rango (ex: día 5 ou hora -1)
            System.out.println("Erro: Día ou hora incorrectos.");
        }
    }

    // MÉTODO C: Engadir actividade extra só se a posición está libre (contén a palabra "Libre")
    public void engadirExtra(int dia, int hora, String actividadeExtra) {
        // Validación de seguridade para garantir que os índices de día e hora son válidos
        if (dia >= 0 && dia < tabla.length && hora >= 0 && hora < tabla[0].length) {

            // Comproba se a cela está baleira (ignora maiúsculas/minúsculas ao comparar con "Libre")
            if (tabla[dia][hora].equalsIgnoreCase("Libre")) {
                tabla[dia][hora] = actividadeExtra; // Almacena a actividade extra se estaba libre
                System.out.println("¡Engadida! Actividade extra gardada con éxito.");
            } else {
                // Se a cela ten outra actividade, avisa ao usuario e non sobrescribe nada
                System.out.println("Erro: Esa hora xa está ocupada por '" + tabla[dia][hora] + "'. Non está valeira.");
            }

        } else {
            System.out.println("Erro: Día ou hora incorrectos.");
        }
    }

    public static void main(String[] args) {
        // Inicializa o Scanner para ler as entradas do usuario dende o teclado
        Scanner teclado = new Scanner(System.in);

        // Define a matriz co horario inicial estático (5 filas x 5 columnas)
        String[][] horarioInicial = {
                {"Matemáticas", "Historia",    "Descanso", "Deporte",     "Titoría"},
                {"Lingua",       "Matemáticas", "Descanso", "Compra",      "Historia"},
                {"Deporte",      "Piscina",     "Descanso", "Informática", "Inglés"},
                {"Historia",     "Lingua",      "Descanso", "Matemáticas", "Compra"},
                {"Piscina",      "Deporte",     "Descanso", "Inglés",      "Libre"} // <- OCO VALEIRO (Fila 4, Columna 4)
        };

        // Instancia un novo obxecto da clase Ajenda pasándolle o horario inicial
        Ajenda a1 = new Ajenda(horarioInicial);

        // 1. Mostramos o horario inicial
        System.out.println("=== HORARIO INICIAL ===");
        a1.amosarHorario(); // Chama ao método para debuxar a táboa

        // 2. PROBA DE CAMBIO (Exercicio B)
        System.out.println("--- CAMBIAR UNHA ACTIVIDADE ---");
        System.out.print("Introduce o número do día (0-Luns, 1-Martes, etc): ");
        int d = teclado.nextInt(); // Le o número correspondente ao día
        System.out.print("Introduce o número da hora (0 ao 4): ");
        int h = teclado.nextInt(); // Le o número correspondente á hora
        teclado.nextLine(); // Limpa o salto de liña (\n) que queda no búfer do Scanner
        System.out.print("Introduce a nova actividade: ");
        String nova = teclado.nextLine(); // Le o texto completo da nova actividade

        // Executa a modificación
        a1.cambiarActividade(d, h, nova);

        // Mostra o horario actualizado tras a modificación
        System.out.println("\n=== HORARIO ACTUALIZADO ===");
        a1.amosarHorario();

        // 3. PROBA DE ENGADIR EN POSICIÓN VALEIRA (Exercicio C)
        System.out.println("--- ENGADIR ACTIVIDADE EXTRA EN HOCO VALEIRO ---");
        System.out.println("(Próbao seleccionando o Venres [4] na última hora [4], que está 'Libre')");
        System.out.print("Introduce o número do día (0-4): ");
        int dExtra = teclado.nextInt(); // Le o día para a actividade extra
        System.out.print("Introduce o número da hora (0-4): ");
        int hExtra = teclado.nextInt(); // Le a hora para a actividade extra
        teclado.nextLine(); // Limpa de novo o búfer do Scanner
        System.out.print("Introduce a actividade extra: ");
        String extra = teclado.nextLine(); // Le o texto da actividade extra

        // Intenta engadir a actividade controlando se o oco está libre
        a1.engadirExtra(dExtra, hExtra, extra);

        // Mostra o horario actualizado tras a modificación final
        System.out.println("\n=== HORARIO FINAL ACTUALIZADO ===");
        a1.amosarHorario();

        teclado.close(); // Práctica recomendada: pechar o Scanner ao rematar
    }
}