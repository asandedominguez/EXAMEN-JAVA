import java.util.Arrays;
import java.util.Scanner;

public class Ajenda {
    private String[][] tabla;

    // Construtor
    public Ajenda(String[][] tabla){
        this.tabla = tabla;
    }

    // Método para amosar o horario (simplificado e limpo)
    public void amosarHorario() {
        String[] dias = {"Luns", "Martes", "Mércores", "Xoves", "Venres"};
        System.out.println("\n\t[H0]\t\t[H1]\t\t[H2]\t\t[H3]\t\t[H4]");
        System.out.println("---------------------------------------------------------------------------------");
        for (int i = 0; i < tabla.length; i++) {
            System.out.print("[" + i + "] " + dias[i] + "\t");
            for (int j = 0; j < tabla[i].length; j++) {
                System.out.print(tabla[i][j] + "\t\t");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------------------------------------------\n");
    }

    // MÉTODO B: Cambiar unha actividade por outra
    public void cambiarActividade(int dia, int hora, String novaActividade) {
        // Primeiro comprobamos que os índices sexan válidos
        if (dia >= 0 && dia < tabla.length && hora >= 0 && hora < tabla[0].length) {
            String antiga = tabla[dia][hora];
            tabla[dia][hora] = novaActividade;
            System.out.println("¡Cambiado! Substituímos '" + antiga + "' por '" + novaActividade + "'.");
        } else {
            System.out.println("Erro: Día ou hora incorrectos.");
        }
    }

    // MÉTODO C: Engadir actividade extra nunha posición valeira (que conteña "Libre")
    public void engadirExtra(int dia, int hora, String actividadeExtra) {
        if (dia >= 0 && dia < tabla.length && hora >= 0 && hora < tabla[0].length) {

            // Comprobamos se a cela está baleira (neste caso, se pon "Libre")
            if (tabla[dia][hora].equalsIgnoreCase("Libre")) {
                tabla[dia][hora] = actividadeExtra;
                System.out.println("¡Engadida! Actividade extra gardada con éxito.");
            } else {
                System.out.println("Erro: Esa hora xa está ocupada por '" + tabla[dia][hora] + "'. Non está valeira.");
            }

        } else {
            System.out.println("Erro: Día ou hora incorrectos.");
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Creamos o horario inicial (deixamos o venres á última hora "Libre")
        String[][] horarioInicial = {
                {"Matemáticas", "Historia",    "Descanso", "Deporte",     "Titoría"},
                {"Lingua",       "Matemáticas", "Descanso", "Compra",      "Historia"},
                {"Deporte",      "Piscina",     "Descanso", "Informática", "Inglés"},
                {"Historia",     "Lingua",      "Descanso", "Matemáticas", "Compra"},
                {"Piscina",      "Deporte",     "Descanso", "Inglés",      "Libre"} // <- OCO VALEIRO
        };

        Ajenda a1 = new Ajenda(horarioInicial);

        // 1. Mostramos o horario inicial
        System.out.println("=== HORARIO INICIAL ===");
        a1.amosarHorario();

        // 2. PROBA DE CAMBIO (Exercicio B)
        System.out.println("--- CAMBIAR UNHA ACTIVIDADE ---");
        System.out.print("Introduce o número do día (0-Luns, 1-Martes, etc): ");
        int d = teclado.nextInt();
        System.out.print("Introduce o número da hora (0 ao 4): ");
        int h = teclado.nextInt();
        teclado.nextLine(); // Limpar o intro do teclado
        System.out.print("Introduce a nova actividade: ");
        String nova = teclado.nextLine();

        a1.cambiarActividade(d, h, nova);

        // e) Mostra o horario actualizado tras a modificación
        System.out.println("\n=== HORARIO ACTUALIZADO ===");
        a1.amosarHorario();


        // 3. PROBA DE ENGADIR EN POSICIÓN VALEIRA (Exercicio C)
        System.out.println("--- ENGADIR ACTIVIDADE EXTRA EN HOCO VALEIRO ---");
        System.out.println("(Próbao seleccionando o Venres [4] na última hora [4], que está 'Libre')");
        System.out.print("Introduce o número do día (0-4): ");
        int dExtra = teclado.nextInt();
        System.out.print("Introduce o número da hora (0-4): ");
        int hExtra = teclado.nextInt();
        teclado.nextLine(); // Limpar intro
        System.out.print("Introduce a actividade extra: ");
        String extra = teclado.nextLine();

        a1.engadirExtra(dExtra, hExtra, extra);

        // e) Mostra o horario actualizado tras a modificación
        System.out.println("\n=== HORARIO FINAL ACTUALIZADO ===");
        a1.amosarHorario();
    }
}