import java.util.*;

public class RealAcademia {

    // Método de inserción con validación de letras do abecedario
    public static boolean nuevoAcademico(Map<Character, Academico> academia, Academico novo, Character letra) {
        // Validamos que sexa unha letra maiúscula ou minúscula estándar do alfabeto
        if (Character.isLetter(letra)) {
            academia.put(letra, novo);
            return true;
        }
        System.out.println("Erro: O carácter '" + letra + "' non é unha letra válida do abecedario.");
        return false;
    }

    public static void main(String[] args) {
        Map<Character, Academico> academia = new HashMap<>();

        nuevoAcademico(academia, new Academico("Arturo Pérez-Reverte", 2003), 'T');
        nuevoAcademico(academia, new Academico("Ana María Matute", 1998), 'q');
        nuevoAcademico(academia, new Academico("Mario Vargas Llosa", 1996), 'L');
        nuevoAcademico(academia, new Academico("Carmen Iglesias", 2002), 'E');
        nuevoAcademico(academia, new Academico("Manuel Seco", 1995), 'A');

        // --- LISTADOS ---

        // Listado 1: Sen letra, por orde de nome
        System.out.println("\n--- POR ORDE DE NOME (Orde Natural) ---");
        List<Academico> porNome = new ArrayList<>(academia.values());
        Collections.sort(porNome);
        porNome.forEach(System.out::println);

        // Listado 2: Sen letra, por ano de ingreso
        System.out.println("\n--- POR ANO DE INGRESO ---");
        List<Academico> porAno = new ArrayList<>(academia.values());
        porAno.sort(Comparator.comparingInt(a -> a.anoIngreso));
        porAno.forEach(System.out::println);

        // Listado 3: Con letra, por orde de letra (Clave Unicode: Maiúsculas van antes)
        System.out.println("\n--- CON LETRA, POR ORDE DE SILLÓN (Unicode) ---");
        Map<Character, Academico> porSillon = new TreeMap<>(academia); // TreeMap ordena automaticamente polas claves
        porSillon.forEach((letra, academico) ->
                System.out.println("Sillón [" + letra + "] -> " + academico.nome + " | Ingreso: " + academico.anoIngreso)
        );
    }
}