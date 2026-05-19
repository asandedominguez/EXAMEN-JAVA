import java.util.*;

public class RealAcademia {

    /**
     * Método de inserción que vincula un académico a unha letra de sillón específica.
     * Inclúe unha validación para garantir que o carácter sexa unha letra loxica do alfabeto.
     * 
     * @param academia O mapa (Map) onde se gardará a información dos académicos.
     * @param novo O obxecto Academico que queremos dar de alta.
     * @param letra O carácter que actuará como chave (sillón) no mapa.
     * @return true se se inseriu correctamente, false se o carácter non era válido.
     */
    public static boolean nuevoAcademico(Map<Character, Academico> academia, Academico novo, Character letra) {
        // Character.isLetter() comproba nativamente se o carácter pasados por parámetro é unha letra
        if (Character.isLetter(letra)) {
            // .put(chave, valor) engade o par ao mapa ou sobrescríbeo se a chave xa existía
            academia.put(letra, novo);
            return true;
        }
        // Mensaxe de aviso se o usuario tenta utilizar un número ou un símbolo especial
        System.out.println("Erro: O carácter '" + letra + "' non é unha letra válida do abecedario.");
        return false;
    }

    public static void main(String[] args) {
        // Instanciamos un HashMap onde a chave é un carácter (letra) e o valor é o obxecto Academico
        Map<Character, Academico> academia = new HashMap<>();

        // Damos de alta varios académicos de proba asignándolles cadansúa letra (sillón)
        nuevoAcademico(academia, new Academico("Arturo Pérez-Reverte", 2003), 'T');
        nuevoAcademico(academia, new Academico("Ana María Matute", 1998), 'q');
        nuevoAcademico(academia, new Academico("Mario Vargas Llosa", 1996), 'L');
        nuevoAcademico(academia, new Academico("Carmen Iglesias", 2002), 'E');
        nuevoAcademico(academia, new Academico("Manuel Seco", 1995), 'A');

        // --- LISTADOS ---

        // Listado 1: Sen letra, por orde de nome
        System.out.println("\n--- POR ORDE DE NOME (Orde Natural) ---");
        // Extraemos unicamente os valores (obxectos Academico) do mapa e os volcamos nunha nova lista
        List<Academico> porNome = new ArrayList<>(academia.values());
        // Collections.sort() utiliza o método compareTo() definido dentro da clase Academico (orde alfabética de nomes)
        Collections.sort(porNome);
        // Expresión de referencia a método para imprimir rapidamente cada elemento da lista
        porNome.forEach(System.out::println);

        // Listado 2: Sen letra, por ano de ingreso
        System.out.println("\n--- POR ANO DE INGRESO ---");
        // Volvemos a extraer os académicos nunha lista independente
        List<Academico> porAno = new ArrayList<>(academia.values());
        // .sort() xunto con Comparator.comparingInt() permite crear un comparador dinámico usando o atributo numérico do ano
        porAno.sort(Comparator.comparingInt(a -> a.anoIngreso));
        porAno.forEach(System.out::println);

        // Listado 3: Con letra, por orde de letra (Clave Unicode: Maiúsculas van antes na táboa)
        System.out.println("\n--- CON LETRA, POR ORDE DE SILLÓN (Unicode) ---");
        // LÓXICA CLAVE: Ao pasarlle o noso HashMap ao construtor dun TreeMap, os elementos cópianse
        // e ordénanse automaticamente de xeito ascendente seguindo o valor das súas chaves (os caracteres dos sillóns)
        Map<Character, Academico> porSillon = new TreeMap<>(academia);
        
        // Percorremos o mapa balanceado empregando unha expresión lambda con dúas variables (letra, academico)
        porSillon.forEach((letra, academico) ->
                System.out.println("Sillón [" + letra + "] -> " + academico.nome + " | Ingreso: " + academico.anoIngreso)
        );
    }
}
